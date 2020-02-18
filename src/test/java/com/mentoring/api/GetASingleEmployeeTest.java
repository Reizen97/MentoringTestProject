package com.mentoring.api;

import kong.unirest.Unirest;
import org.junit.jupiter.api.Test;

import static java.lang.String.format;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class GetASingleEmployeeTest extends BaseTest{

    @Test
    public void testSuccessStatus() {

        String url = format("http://dummy.restapiexample.com/api/v1/employee/%s", getEmployeeId());

        String actualStatus = Unirest.get(url)
                .asObject(EmployeeBodyResponse.class)
                .getBody()
                .getStatus();

        assertEquals("success", actualStatus);
    }

    @Test
    public void testStatusCodeOk() {

        String url = format("http://dummy.restapiexample.com/api/v1/employee/%s", getEmployeeId());

        int actualStatusCode = Unirest.get(url)
                .asObject(EmployeeBodyResponse.class)
                .getStatus();

        assertEquals( 200, actualStatusCode);
    }

    @Test
    public void testStatusCodeNotFound() {

        String url = format("http://dummy.restapiexample.com/api/v1/employee/%s", (getEmployeeId() + 1));

        int actualStatusCode = Unirest.get(url)
                .asObject(EmployeeBodyResponse.class)
                .getStatus();

        assertEquals( 401, actualStatusCode);
    }

    @Test
    public void testFailedStatus() {

        String url = format("http://dummy.restapiexample.com/api/v1/employee/%s", (getEmployeeId() + 1));

        String actualStatus = Unirest.get(url)
                .asObject(ErrorResponse.class)
                .getBody()
                .getStatus();

        assertEquals( "failed", actualStatus);
    }

    @Test
    public void testFailedMessage() {

        String url = format("http://dummy.restapiexample.com/api/v1/employee/%s", (getEmployeeId() + 1));

        String actualData = Unirest.get(url)
                .asObject(ErrorResponse.class)
                .getBody()
                .getData();

        assertEquals( "Record does not found.", actualData);
    }

    @Test
    public void testEmployeeData() {

        String url = format("http://dummy.restapiexample.com/api/v1/employee/%s", getEmployeeId());

        EmployeeResponse employee = Unirest.get(url)
                .asObject(EmployeeBodyResponse.class)
                .getBody()
                .getData();

        assertEquals(getEmployeeId(), employee.getId());
        assertEquals("test", employee.getEmployee_name());
        assertEquals("123", employee.getEmployee_salary());
        assertEquals("23", employee.getEmployee_age());
        assertNull(employee.getProfile_image());
    }
}
