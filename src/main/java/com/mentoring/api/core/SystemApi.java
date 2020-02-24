package com.mentoring.api.core;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static com.mentoring.api.core.HttpMethod.GET;
import static com.mentoring.api.core.HttpMethod.POST;


@AllArgsConstructor
@Getter
public enum SystemApi {

    CreateEmployee(POST, "/api/v1/create"),
    GetEmployeeById(GET, "/api/v1/employee/1");

    private HttpMethod method;
    private String endpoint;
}
