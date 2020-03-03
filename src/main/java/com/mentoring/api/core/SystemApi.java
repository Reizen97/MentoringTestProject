package com.mentoring.api.core;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static com.mentoring.api.core.HttpMethod.GET;
import static com.mentoring.api.core.HttpMethod.POST;
import static com.mentoring.api.core.HttpMethod.PUT;


@AllArgsConstructor
@Getter
public enum SystemApi {

    CreateEmployee(POST, "/api/v1/create"),
    GetEmployeeById(GET, "/api/v1/employee/%s"),
    UpdateEmployeeById(PUT, "/api/v1/update/%s");

    private HttpMethod method;
    private String endpoint;
}
