package com.cse.geo.application.api.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WxLoginRequest {
    /**
     * 登录时获取的 code
     */
    private String jsCode;

    /**
     * 授权类型
     */
    private String grantType;
}
