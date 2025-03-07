package com.cse.geo.common.exception;

import com.cse.geo.common.enums.ExceptionEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SpotException extends RuntimeException {
    /**
     * 错误代码
     */
    private String errcode;
    /**
     * 错误信息
     */
    private String errmsg;

    public SpotException(String errcode, String errmsg) {
        super(errmsg);
        this.errcode = errcode;
        this.errmsg = errmsg;
    }

    public SpotException(ExceptionEnum codeEnum) {
        super(codeEnum.getErrorMsg());
        this.errcode = codeEnum.getErrorCode();
        this.errmsg = codeEnum.getErrorMsg();
    }
}
