package com.cse.geo.application.api;

import com.cse.geo.application.api.request.WxLoginRequest;
import com.cse.geo.application.service.WxLoginService;
import com.cse.geo.infrastructure.feign.response.WxLoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WxLoginApi {
    private final WxLoginService wxLoginService;

    @PostMapping("/user/wxlogin")
    public WxLoginResponse login(@RequestBody WxLoginRequest request) {
        return wxLoginService.wxLogin(request);
    }
}
