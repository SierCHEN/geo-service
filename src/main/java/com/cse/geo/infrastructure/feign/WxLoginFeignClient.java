package com.cse.geo.infrastructure.feign;

import com.cse.geo.common.config.OpenFeignLogConfig;
import com.cse.geo.infrastructure.feign.response.WxLoginResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="wx-service", url="${url.wx-api}", configuration = OpenFeignLogConfig.class)
public interface WxLoginFeignClient {
    @GetMapping("/sns/jscode2session")
    WxLoginResponse wxLogin(@RequestParam("appid") String appId,
                                             @RequestParam("secret") String secret,
                                             @RequestParam("js_code") String jsCode,
                                             @RequestParam("grant_type") String grantType);
}
