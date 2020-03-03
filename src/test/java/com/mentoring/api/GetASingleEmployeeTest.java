package com.mentoring.api;

import com.google.gson.Gson;
import com.mentoring.api.request.EmployeeRequest;
import com.mentoring.api.response.EmployeeBodyResponse;
import com.mentoring.api.response.EmployeeResponse;
import com.mentoring.api.response.ErrorResponse;
import kong.unirest.Unirest;
import org.junit.jupiter.api.Test;

import static com.mentoring.api.Endpoint.BASE_URL;
import static com.mentoring.api.Endpoint.CREATE;
import static com.mentoring.api.Endpoint.GET;
import static java.lang.String.format;
import static org.junit.Assert.assertEquals;


public class GetASingleEmployeeTest {

    private EmployeeBodyResponse employee;
    private Gson gson = new Gson();
    private String response;

    @Test
    public void testSuccessStatus() {

        createEmployee();

        response = Unirest.get(format("%s%s%s", BASE_URL.getValue(), GET.getValue(), getEmployeeId()))
                .asString()
                .getBody();

        assertEquals("success", gson.fromJson(response, EmployeeBodyResponse.class).getStatus());
    }

    @Test
    public void testStatusCodeOk() {

        createEmployee();

        int actualStatusCode = Unirest.get(format("%s%s%s", BASE_URL.getValue(), GET.getValue(), getEmployeeId()))
                .asString()
                .getStatus();

        assertEquals( 200, actualStatusCode);
    }

    @Test
    public void testStatusCodeNotFound() {

        createEmployee();

        int actualStatusCode = Unirest.get(format("%s%s%s", BASE_URL.getValue(), GET.getValue(), (getEmployeeId() + 1)))
                .asObject(EmployeeBodyResponse.class)
                .getStatus();

        assertEquals( 401, actualStatusCode);
    }

    @Test
    public void testFailedStatus() {

        createEmployee();

        response = Unirest.get(format("%s%s%s", BASE_URL.getValue(), GET.getValue(), (getEmployeeId() + 1)))
                .asString()
                .getBody();

        assertEquals( "failed", gson.fromJson(response, ErrorResponse.class).getStatus());
    }

    @Test
    public void testFailedMessage() {

        createEmployee();

        response = Unirest.get(format("%s%s%s", BASE_URL.getValue(), GET.getValue(), (getEmployeeId() + 1)))
                .asString()
                .getBody();

        assertEquals( "Record does not found.",  gson.fromJson(response, ErrorResponse.class).getData());
    }

    @Test
    public void testEmployeeData() {

        createEmployee();

        response = Unirest.get(format("%s%s%s", BASE_URL.getValue(), GET.getValue(), getEmployeeId()))
                .asString()
                .getBody();

        EmployeeResponse expectedEmployee = new EmployeeResponse(getEmployeeId(), "test", "123", "23",
                null);

        assertEquals(expectedEmployee, gson.fromJson(response, EmployeeBodyResponse.class).getData());
    }

    private void createEmployee() {

        EmployeeRequest request = new EmployeeRequest("test", "123", "23");
        String json = gson.toJson(request);

        response = Unirest.post(format("%s%s", BASE_URL.getValue(), CREATE.getValue()))
                .body(json)
                .asString()
                .getBody();

        employee = gson.fromJson(response, EmployeeBodyResponse.class);
    }

    private int getEmployeeId() {
        return employee.getData().getId();
    }
}
