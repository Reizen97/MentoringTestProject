package com.mentoring.api;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.mentoring.api.controllers.EmployeeController;
import com.mentoring.api.request.EmployeeRequest;
import com.mentoring.api.response.EmployeeBodyResponse;
import com.mentoring.api.response.MessageResponse;
import kong.unirest.HttpResponse;
import org.junit.jupiter.api.Test;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class EmployeeTest {

    private EmployeeBodyResponse employee;
    private Gson gson = new Gson();
    private HttpResponse<String> response;

    @Test
    public void testGetEmployeeByIdStatusCodeOk() {
        createEmployee();

        assertEquals(200, EmployeeController.getEmployeeByID(getEmployeeId())
                .asObject(EmployeeBodyResponse.class)
                .getStatus());
    }

    @Test
    public void testGetEmployeeByIdSuccessStatus() {

        createEmployee();

        assertEquals("success", EmployeeController.getEmployeeByID(getEmployeeId())
                .asObject(EmployeeBodyResponse.class)
                .getBody()
                .getStatus());
    }

    @Test
    public void testGetEmployeeByIdData() {

        createEmployee();

        assertEquals(employee.getData(), EmployeeController.getEmployeeByID(getEmployeeId())
                .asObject(EmployeeBodyResponse.class)
                .getBody()
                .getData());
    }

    @Test
    public void testGetEmployeeByIdStatusCodeNotFound() {

        createEmployee();

        assertEquals(401, EmployeeController.getEmployeeByID(getEmployeeId() +1 )
                .asObject(EmployeeBodyResponse.class)
                .getStatus());
    }

    @Test
    public void testGetEmployeeByIdFailedStatus() {

        createEmployee();

        assertEquals("failed", EmployeeController.getEmployeeByID(getEmployeeId() + 1)
                .asObject(MessageResponse.class)
                .getBody()
                .getStatus());
    }

    @Test
    public void testGetEmployeeByIdFailedMessage() {

        createEmployee();

        assertEquals("Record does not found.", EmployeeController.getEmployeeByID(getEmployeeId() + 1)
                .asObject(MessageResponse.class)
                .getBody()
                .getData());
    }

    @Test
    public void testDeleteEmployeeByIdSuccessStatus() {

        createEmployee();

        assertEquals("success", EmployeeController.deleteEmployeeByID(getEmployeeId())
                .asObject(MessageResponse.class)
                .getBody()
                .getStatus());
    }

    @Test
    public void testDeleteEmployeeByIdSuccessMessage() {

        createEmployee();

        assertEquals("successfully! deleted Records", EmployeeController.deleteEmployeeByID(getEmployeeId())
                .asObject(MessageResponse.class)
                .getBody()
                .getData());
    }

    @Test
    public void testDeleteEmployeeByIdFailedStatus() {

        createEmployee();

        assertEquals("failed", EmployeeController.deleteEmployeeByID(getEmployeeId() + 1)
                .asObject(MessageResponse.class)
                .getBody()
                .getStatus());
    }

    @Test
    public void testDeleteEmployeeByIdFailedMessage() {

        createEmployee();

        assertEquals("Error! Id must be greater than zerp", EmployeeController.deleteEmployeeByID(getEmployeeId() + 1)
                .asObject(MessageResponse.class)
                .getBody()
                .getData());
    }

    private void createEmployee() {

        Faker faker = new Faker();

        EmployeeRequest request = new EmployeeRequest(faker.name().fullName(),
                String.valueOf(faker.number().numberBetween(100, 5000)),
                String.valueOf(faker.number().numberBetween(18, 60)));
        String json = gson.toJson(request);

        response = EmployeeController.createEmployee(json)
                .asString();

        await().atMost(3, SECONDS).until(() -> response.getStatus() == 200);

        employee = gson.fromJson(response.getBody(), EmployeeBodyResponse.class);
        employee.getData().setName(request.getName());
        employee.getData().setSalary(request.getSalary());
        employee.getData().setAge(request.getAge());
    }

    private int getEmployeeId() {
        return employee.getData().getId();
    }
}
