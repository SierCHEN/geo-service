package com.cse.geo.infrastructure.feign.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WxLoginFeignRequest {
    /**
     * 小程序 appId
     */
    @JsonProperty("appid")
    private String appId;

    /**
     * 小程序 appSecret
     */
    @JsonProperty("secret")
    private String secret;

    /**
     * 登录时获取的 code
     */
    @JsonProperty("js_code")
    private String jsCode;

    /**
     * 授权类型
     */
    @JsonProperty("grant_type")
    private String grantType;
}
