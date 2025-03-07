package com.cse.geo.common.enums;

import com.cse.geo.common.exception.SpotException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.geo.Metrics;

import java.util.Arrays;
import java.util.Optional;

@Getter
@AllArgsConstructor
public enum SpotRadiusEnum {
    METER(0, Metrics.MILES,"米"),

    KILOMETER(1, Metrics.KILOMETERS,"千米");

    /**
     * 码值
     */
    private Integer code;
    /**
     * 单位
     */
    private Metrics metrics;
    /**
     * 描述
     */
    private String desc;

    public static SpotRadiusEnum getByCode(Integer code) {
        Optional<SpotRadiusEnum> spotRadiusEnumOptional = Arrays.stream(SpotRadiusEnum.values())
                .filter(e -> e.code.equals(code)).findFirst();
        return spotRadiusEnumOptional.orElseThrow(() -> new SpotException("", "距离单位不合法"));
    }
}
