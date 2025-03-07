package com.cse.geo.application.service;

import com.cse.geo.application.api.request.WxLoginRequest;
import com.cse.geo.infrastructure.feign.WxLoginFeignClient;
import com.cse.geo.infrastructure.feign.response.WxLoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WxLoginService {

    @Value("${wx.appid}")
    private String appId;

    @Value("${wx.secret}")
    private String appSecret;

    /**
     * 微信登录feign
     */
    private final WxLoginFeignClient wxLoginFeignClient;

    public WxLoginResponse wxLogin(WxLoginRequest request) {
        try{
            return wxLoginFeignClient.wxLogin(appId, appSecret, request.getJsCode(), request.getGrantType());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
