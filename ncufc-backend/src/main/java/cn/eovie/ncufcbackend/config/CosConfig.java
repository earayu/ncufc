package cn.eovie.ncufcbackend.config;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.sign.Credentials;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by earayu on 2017/12/5.
 */
@Data
@Configuration
public class CosConfig {

    @Value("${cos.appId}")
    private long appId;

    @Value("${cos.secretId}")
    private String secretId;

    @Value("${cos.secretKey}")
    private String secretKey;

    @Value("${cos.bucketName}")
    private String bucketName;

    @Value("${cos.reigon}")
    private String reigon;

    @Value("${cos.cosPath}")
    private String cosPath;


    @Bean
    public COSClient  clientConfig(){
        Credentials cred = new Credentials(appId, secretId, secretKey);
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.setRegion(reigon);
        COSClient cosClient = new COSClient(clientConfig, cred);
        return cosClient;
    }






}
