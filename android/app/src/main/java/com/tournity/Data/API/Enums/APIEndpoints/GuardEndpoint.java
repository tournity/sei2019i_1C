package com.tournity.Data.API.Enums.APIEndpoints;

import com.android.volley.Request;
import com.tournity.Data.API.Enums.APIResponseDataType;

public enum GuardEndpoint implements Endpoint {
    Login("guard/login", Request.Method.POST, APIResponseDataType.OBJECT)
    ;

    private String endPoint;
    private int method;
    private APIResponseDataType dataType;

    GuardEndpoint(String endPoint, int method, APIResponseDataType dataType) {
        this.endPoint = endPoint;
        this.method = method;
        this.dataType = dataType;
    }

    @Override
    public String getEndpoint() {
        return null;
    }

    @Override
    public int getMethod() {
        return 0;
    }

    @Override
    public APIResponseDataType getResponseDataType() {
        return null;
    }
}