package com.mentoring.api.response;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class ErrorResponse {

    private String status;
    private String data;
}
