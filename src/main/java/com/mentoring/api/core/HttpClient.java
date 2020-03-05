package com.mentoring.api.core;

import kong.unirest.GetRequest;
import kong.unirest.HttpRequest;
import kong.unirest.HttpRequestWithBody;
import kong.unirest.RequestBodyEntity;
import kong.unirest.Unirest;

import static com.mentoring.api.conf.Configuration.BASE_URL;
import static java.lang.String.format;


public final class HttpClient {

    private static HttpRequest<? extends HttpRequest> response;

    public static HttpRequest<? extends HttpRequest> sender(HttpMethod method, String endpoint, String body, Object... parameters) {

        switch (method) {

            case GET:
                response = get(format(endpoint, parameters));
                break;

            case POST:
                response = post(endpoint, body);
                break;

            case PUT:
                response = put(format(endpoint, parameters), body);
                break;

            case DELETE:
                response = delete(format(endpoint, parameters));
                break;

            default: throw new IllegalArgumentException("Only GET, POST, PUT, DELETE allowed");
        }
        return response;
    }

    public static HttpRequest<? extends HttpRequest> sender(HttpMethod method, String endpoint, Object... parameters) {
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
