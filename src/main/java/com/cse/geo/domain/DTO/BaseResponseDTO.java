package com.cse.geo.domain.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponseDTO<T> {
    private String errorCode;

    private Integer errorMsg;

    private T body;
}
