package com.mentoring.api.controllers;


import com.mentoring.api.core.HttpClient;
import kong.unirest.HttpRequest;
import kong.unirest.RequestBodyEntity;

import static com.mentoring.api.core.SystemApi.GetEmployeeById;


public class EmployeeController {

    public static HttpRequest<RequestBodyEntity> getEmployeeByID(int id) {
        return HttpClient.sender(GetEmployeeById.getMethod(), GetEmployeeById.getEndpoint(), null, null);
    }
}
