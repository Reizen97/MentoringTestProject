package com.mentoring.api.core;


import kong.unirest.GetRequest;
import kong.unirest.HttpRequest;
import kong.unirest.RequestBodyEntity;
import kong.unirest.Unirest;

import static com.mentoring.api.conf.Configuration.BASE_URL;


public final class HttpClient {

    public static HttpRequest<RequestBodyEntity> sender(HttpMethod method, String endpoint, String body, Object... parameters) {

        switch (method) {

            case GET:
                get(endpoint);
                break;

            case POST:
                post(endpoint, body);
                break;

            default: throw new IllegalArgumentException("Only GET, POST, PUT, DELETE allowed");
        }
        return null;
    }

    private static GetRequest get(String endpoint) {
        return Unirest.get(BASE_URL + endpoint);
    }

    private static HttpRequest<RequestBodyEntity> post(String endpoint, String body) {
        return Unirest.post(BASE_URL + endpoint)
                .body(body);
    }
}
