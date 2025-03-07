package com.cse.geo.infrastructure.feign.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class WxLoginResponse {
    /**
     * 会话密钥
     */
    @JsonProperty("session_key")
    private String sessionKey;

    /**
     * 用户唯一标识
     */
    @JsonProperty("openid")
    private String openId;

//    /**
//     * 用户在开放平台的唯一标识符
//     */
//    @JsonProperty("unionid")
//    private String unionId;
}
