package com.cse.geo.application.api.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SpotRadiusRequest {
    /**
     * 地点id
     */
    private String spotId;

    /**
     * 半径单位
     */
    private Integer radiusUnit;

    /**
     * 半径
     */
    private Integer radius;
}
