package com.mentoring.api;

public class EmployeeBodyResponse {

    private String status;
    private EmployeeResponse data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public EmployeeResponse getData() {
        return data;
    }

    public void setData(EmployeeResponse data) {
        this.data = data;
    }
}
