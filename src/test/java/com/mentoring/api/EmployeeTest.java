package com.mentoring.api;


import com.google.gson.Gson;
import com.mentoring.api.controllers.EmployeeController;
import com.mentoring.api.request.EmployeeRequest;
import com.mentoring.api.response.EmployeeBodyResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class EmployeeTest {

    private EmployeeBodyResponse employee;
    private Gson gson = new Gson();
    private String response;

    @Test
    public void testGetEmployeeById() {
        createEmployee();

        assertEquals(200, EmployeeController.getEmployeeByID(getEmployeeId()).asObject(EmployeeBodyResponse.class)
                .getStatus());
    }

    private void createEmployee() {

        EmployeeRequest request = new EmployeeRequest("test", "123", "23");
        String json = gson.toJson(request);

        response = EmployeeController.createNewEmployee(json)
                .asString()
                .getBody();

        employee = gson.fromJson(response, EmployeeBodyResponse.class);
    }

    private int getEmployeeId() {
        return employee.getData().getId();
    }
}
