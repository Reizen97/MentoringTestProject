package com.mentoring.api;


import com.mentoring.api.controllers.EmployeeController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class EmployeeTest {

    @Test
    public void testGetEmployeeById() {
        assertEquals(200, EmployeeController.getEmployeeByID(1).asString().getStatus());
    }
}
