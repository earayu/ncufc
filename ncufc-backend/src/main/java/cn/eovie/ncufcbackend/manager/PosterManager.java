package cn.eovie.ncufcbackend.manager;

import cn.eovie.ncufcbackend.dao.PosterDao;
import cn.eovie.ncufcbackend.exception.CodeException;
import cn.eovie.ncufcbackend.exception.ExceptionCode;
import cn.eovie.ncufcbackend.exception.ExceptedException;
import cn.eovie.ncufcbackend.model.domain.PosterDO;
import cn.eovie.ncufcbackend.model.domain.Result;
import cn.eovie.ncufcbackend.model.dto.PosterDTO;
import cn.eovie.ncufcbackend.util.BaseConveter;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static cn.eovie.ncufcbackend.exception.ExceptionUtils.throwFlyingException;

/**
 * Created by earayu on 2017/11/27.
 */
@Slf4j
@Service
public class PosterManager {

    @Autowired
    private PosterDao posterDao;

    @Autowired
    private CosManager cosManager;

    public Result addPost(String name, String postUser, MultipartFile file){
        try {
            //上传图片到腾讯cos
            Optional<String> result = cosManager.upload(compress(file));
            PosterDTO posterDTO = PosterDTO.builder()
                    .name(name)
                    .postUser(postUser)
                    .url(result.get())
                    .build();
            posterDao.insert(BaseConveter.convertObject(posterDTO, PosterDO.class));
            return Result.success();
        }catch (ExceptedException e){
            throw e;
        }catch (Exception e){
            throw new CodeException(e);
        }
    }

    private byte[] compress(MultipartFile file){
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            Thumbnails.of(file.getInputStream()).scale(1f).outputFormat("jpg").toOutputStream(baos);
            return baos.toByteArray();
        } catch (IOException e) {
            log.error("压缩图片失败:{}", e.getMessage());
            throw new CodeException(ExceptionCode.COMPRESS_ERROR);
        }
    }

    /**
     * 返回图片，首页展示所有返回的图片
     * TODO
     * 1. 配置哪些图片该展现，哪些不展现，展现顺序，切换图片时间
     * 2. 暂时做成返回全部
     * @return
     */
    public List<PosterDTO> findAll(){
        return BaseConveter.convertList(posterDao.findAll(), PosterDTO.class);
    }

}
