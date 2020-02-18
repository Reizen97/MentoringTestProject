package com.mentoring.api;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.junit.jupiter.api.BeforeEach;


public class BaseTest {

    HttpResponse<EmployeeBodyResponse> employee;

    @BeforeEach
    public void createEmployee() {

        employee = Unirest.post("http://dummy.restapiexample.com/api/v1/create")
                .body(new EmployeeRequest("test", "123", "23"))
                .asObject(EmployeeBodyResponse.class);
    }

    public String getEmployeeId() {
        return employee.getBody().getData().getId();
    }
}
