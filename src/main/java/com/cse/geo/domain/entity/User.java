package com.cse.geo.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("user")
public class User {
    /**
     * 用户id
     */
    @TableField(value = "USER_ID")
    private Long id;

    /**
     * 微信用户唯一标识
     */
    @TableField(value = "OPEN_ID")
    private String openId;

    /**
     * 用户名称
     */
    @TableField(value = "USERNAME")
    private String username;

    /**
     * 头像路径
     */
    @TableField(value = "AVATAR_URL")
    private String avatarUrl;

    /**
     * 创建时间
     */
    @TableField(value = "CREATE_TIME")
    private LocalDateTime createTime;

}
