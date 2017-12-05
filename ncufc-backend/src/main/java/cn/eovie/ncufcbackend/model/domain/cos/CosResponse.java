package cn.eovie.ncufcbackend.model.domain.cos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.ToString;

/**
 * Created by earayu on 2017/12/5.
 */
@Data
public class CosResponse {

    private String code;

    private String message;

    @SerializedName("request_id")
    private String requestId;

    private CosResponseData data;

    @Data
    public class CosResponseData{
        @SerializedName(value = "access_url")
        private String accessUrl;

        @SerializedName(value = "resource_path")
        private String resourcePath;

        @SerializedName(value = "source_url")
        private String sourceUrl;

        private String url;

        private String vid;

    }

}
