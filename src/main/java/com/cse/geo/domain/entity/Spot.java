package com.cse.geo.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName("spot")
public class Spot {
    @TableField(value = "SPOT_ID")
    private String spotId;

    @TableField(value = "SPOT_NAME")
    private String spotName;

    @TableField(value = "SPOT_TYPE")
    private String spotType;

    @TableField(value = "SPOT_LONGITUDE")
    private BigDecimal spotLongitude;

    @TableField(value = "SPOT_LATITUDE")
    private BigDecimal spotLatitude;

}