package com.mentoring.api;

enum Endpoint {

    BASE_URL("http://dummy.restapiexample.com"),
    CREATE("/api/v1/create"),
    GET("/api/v1/employee/");

    public final String value;

    private Endpoint(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
