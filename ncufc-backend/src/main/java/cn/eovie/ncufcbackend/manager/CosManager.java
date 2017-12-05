package cn.eovie.ncufcbackend.manager;

import cn.eovie.ncufcbackend.config.CosConfig;
import cn.eovie.ncufcbackend.exception.ExceptionCode;
import cn.eovie.ncufcbackend.exception.SpecificException;
import cn.eovie.ncufcbackend.model.domain.cos.CosResponse;
import com.google.common.base.Preconditions;
import com.google.gson.Gson;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.request.UploadFileRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

/**
 * Created by earayu on 2017/12/5.
 */
@Service
public class CosManager {

    @Autowired
    private COSClient cosClient;

    @Autowired
    private CosConfig cosConfig;

    //TODO 返回成功与否、URL
    public Optional<String> upload(byte[] bytes){
        try {

        }catch (Exception e){
            throw new SpecificException(ExceptionCode.COS_ERROR);
        }
        UploadFileRequest request = new UploadFileRequest(
                cosConfig.getBucketName(),
                cosConfig.getCosPath() + "/" + UUID.randomUUID().toString() + ".jpg",
                bytes);
        String result = cosClient.uploadFile(request);

        CosResponse cosResponse = new Gson().fromJson(result, CosResponse.class);

        if(!cosResponse.getCode().equals("0")){//TODO 细分网络异常和参数异常
            throw new SpecificException(ExceptionCode.UPLOAD_ERROR);
        }

        return Optional.of(cosResponse.getData().getSourceUrl());
    }


}
