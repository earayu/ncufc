package cn.eovie.ncufcbackend.manager;

import cn.eovie.ncufcbackend.dao.PosterDao;
import cn.eovie.ncufcbackend.model.domain.PosterDO;
import cn.eovie.ncufcbackend.model.dto.PosterDTO;
import cn.eovie.ncufcbackend.util.BaseConveter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by earayu on 2017/11/27.
 */
@Service
public class PosterManager {

    @Autowired
    private PosterDao posterDao;

    public void addPost(PosterDTO posterDTO){
        posterDao.insert(BaseConveter.convertObject(posterDTO, PosterDO.class));
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
