package com.mentoring.api.response;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class EmployeeBodyResponse {

    private String status;
    private EmployeeResponse data;
}
