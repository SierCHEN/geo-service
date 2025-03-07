package com.cse.geo.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName("spot")
public class Spot {
    /**
     * 地点id
     */
    @TableField(value = "SPOT_ID")
    private String spotId;

    /**
     * 地点名称
     */
    @TableField(value = "SPOT_NAME")
    private String spotName;

    /**
     * 地点类型
     */
    @TableField(value = "SPOT_TYPE")
    private String spotType;

    /**
     * 经度
     */
    @TableField(value = "SPOT_LONGITUDE")
    private BigDecimal spotLongitude;

    /**
     * 纬度
     */
    @TableField(value = "SPOT_LATITUDE")
    private BigDecimal spotLatitude;

}