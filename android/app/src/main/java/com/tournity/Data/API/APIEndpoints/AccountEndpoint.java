package com.tournity.Data.API.APIEndpoints;

public enum AccountEndpoint implements Endpoint {
    getAll("accounts/"),
    getById("accounts/%i");

    private String endPoint;

    private AccountEndpoint(String endPoint){
        this.endPoint = endPoint;
    }

    @Override
    public String getEndpoint() {
        return endPoint;
    }
}
