package com.cse.geo.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ExceptionEnum {
    ERR_COMMON("GS000", "默认失败");

    /**
     * 错误码
     */
    private String errorCode;
    /**
     * 错误信息
     */
    private String errorMsg;

    /**
     * 根据代码获取枚举
     * @param errorCode 错误码
     * @return 枚举
     */
    public static ExceptionEnum getExceptionEnum(String errorCode) {
        ExceptionEnum exceptionEnum = null;
        for (ExceptionEnum e : ExceptionEnum.values()) {
            if (e.getErrorCode().equals(errorCode)) {
                exceptionEnum = e;
            }
        }
        return exceptionEnum;
    }
}
