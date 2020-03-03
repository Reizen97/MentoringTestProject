package com.mentoring.api.request;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class EmployeeRequest {

    private int id;
    private String name;
    private String salary;
    private String age;
    private String image;

    public EmployeeRequest(String name, String salary, String age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }
}
