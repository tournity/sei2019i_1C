package com.tournity.Data.API.Enums.APIEndpoints;

import com.android.volley.Request;
import com.tournity.Data.API.Enums.APIResponseDataType;

public enum UserEndpoint implements Endpoint {
   // Authentication("authentication"),
    //Accounts("accounts"),
    Create("users/", Request.Method.POST, null);
    private String endPoint;
    private int method;
    private APIResponseDataType dataType;

    UserEndpoint(String endPoint, int method, APIResponseDataType dataType) {
        this.endPoint = endPoint;
        this.method = method;
        this.dataType = dataType;
    }

    @Override
    public String getEndpoint() {
        return endPoint;
    }

    @Override
    public int getMethod() {
        return method;
    }

    @Override
    public APIResponseDataType getResponseDataType() {
        return dataType;
    }

}
