package com.mentoring.api.controllers;


import com.mentoring.api.core.HttpClient;
import kong.unirest.GetRequest;
import kong.unirest.HttpRequest;
import kong.unirest.RequestBodyEntity;

import static com.mentoring.api.core.SystemApi.CreateEmployee;
import static com.mentoring.api.core.SystemApi.GetEmployeeById;


public class EmployeeController {

    public static HttpRequest<GetRequest> getEmployeeByID(int id) {
        return HttpClient.sender(GetEmployeeById.getMethod(), GetEmployeeById.getEndpoint(), id);
    }

    public static HttpRequest<RequestBodyEntity> updateEmployeeByID(int id, String body) {
        return HttpClient.sender(GetEmployeeById.getMethod(), GetEmployeeById.getEndpoint(), body, id);
    }

    public static HttpRequest<RequestBodyEntity> createEmployee(String body) {
        return HttpClient.sender(CreateEmployee.getMethod(), CreateEmployee.getEndpoint(), body, null);
    }
}
