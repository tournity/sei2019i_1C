package com.tournity.Data.API.Enums.APIEndpoints;

public enum UserEndpoint {
    Authentication("authentication"),
    Accounts("accounts");

    private String endpoint;
    private UserEndpoint(String endpoint){
        this.endpoint = endpoint;
    }

    public String getEndpoint() {
        return endpoint;
    }
}
