package cn.eovie.ncufcbackend.manager;

import cn.eovie.ncufcbackend.config.CosConfig;
import cn.eovie.ncufcbackend.exception.*;
import cn.eovie.ncufcbackend.model.domain.cos.CosResponse;
import com.google.gson.Gson;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.request.UploadFileRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

import static cn.eovie.ncufcbackend.exception.ExceptionUtils.*;

/**
 * Created by earayu on 2017/12/5.
 */
@Service
public class CosManager {

    @Autowired
    private COSClient cosClient;

    @Autowired
    private CosConfig cosConfig;

    public Optional<String> upload(byte[] bytes){
        UploadFileRequest request = new UploadFileRequest(
                cosConfig.getBucketName(),
                cosConfig.getCosPath() + "/" + UUID.randomUUID().toString() + ".jpg",
                bytes);
        String result = cosClient.uploadFile(request);

        CosResponse cosResponse = new Gson().fromJson(result, CosResponse.class);

        if(cosResponse.getCode().equals("-1")){
            throwServiceException(ExceptionCode.UPLOAD_ERROR);
        }else if(cosResponse.getCode().equals("-2") || cosResponse.getCode().equals("-3")){
            throwNetworkException(ExceptionCode.UPLOAD_TIMEOUT);
        }
        return Optional.of(cosResponse.getData().getSourceUrl());
    }


}
