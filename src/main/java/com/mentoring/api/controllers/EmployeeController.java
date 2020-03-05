package com.mentoring.api.controllers;

import com.mentoring.api.core.HttpClient;
import kong.unirest.HttpRequest;

import static com.mentoring.api.core.SystemApi.CreateEmployee;
import static com.mentoring.api.core.SystemApi.DeleteEmployeeById;
import static com.mentoring.api.core.SystemApi.GetEmployeeById;


public class EmployeeController {

    public static HttpRequest<? extends HttpRequest> getEmployeeByID(int id) {
        return HttpClient.sender(GetEmployeeById.getMethod(), GetEmployeeById.getEndpoint(), id);
    }

    public static HttpRequest<? extends HttpRequest> updateEmployeeByID(int id, String body) {
        return HttpClient.sender(GetEmployeeById.getMethod(), GetEmployeeById.getEndpoint(), body, id);
    }

    public static HttpRequest<? extends HttpRequest> deleteEmployeeByID(int id) {
        return HttpClient.sender(DeleteEmployeeById.getMethod(), DeleteEmployeeById.getEndpoint(), id);
    }

    public static HttpRequest<? extends HttpRequest> createEmployee(String body) {
        return HttpClient.sender(CreateEmployee.getMethod(), CreateEmployee.getEndpoint(), body, null);
    }
}
