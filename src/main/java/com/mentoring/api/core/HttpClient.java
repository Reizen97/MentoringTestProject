package com.mentoring.api.core;


import kong.unirest.*;

import static com.mentoring.api.conf.Configuration.BASE_URL;


public final class HttpClient {

    public static <T extends HttpRequest> HttpRequest<T> sender(HttpMethod method, String endpoint, String body, Object... parameters) {

        endpoint = parameters.length > 0 ? String.format(endpoint, parameters) : endpoint;

        switch (method) {

            case GET:
                get(endpoint);
                break;

            case POST:
                post(endpoint, body);
                break;

            case PUT:
                put(endpoint, body);
                break;

            case DELETE:
                delete(endpoint);
                break;

            default:
                throw new IllegalArgumentException("Only GET, POST, PUT, DELETE allowed");
        }

        return null;
    }

    public static <T extends HttpRequest> HttpRequest<T> sender(HttpMethod method, String endpoint, Object... parameters) {
        return sender(method, endpoint, null, parameters);
    }

    private static HttpRequest<GetRequest> get(String endpoint) {
        return Unirest.get(BASE_URL + endpoint);
    }

    private static HttpRequest<RequestBodyEntity> post(String endpoint, String body) {
        return Unirest.post(BASE_URL + endpoint)
                .body(body);
    }

    private static HttpRequest<RequestBodyEntity> put(String endpoint, String body) {
        return Unirest.put(BASE_URL + endpoint)
                .body(body);
    }

    private static HttpRequest<HttpRequestWithBody> delete(String endpoint) {
        return Unirest.delete(BASE_URL + endpoint);
    }
}
