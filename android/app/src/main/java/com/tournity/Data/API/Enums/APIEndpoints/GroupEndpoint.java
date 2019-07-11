package com.tournity.Data.API.Enums.APIEndpoints;

import com.android.volley.Request;
import com.tournity.Data.API.Enums.APIResponseDataType;

public enum GroupEndpoint implements Endpoint {
    getAll("accounts/", Request.Method.GET, APIResponseDataType.ARRAY),
    getById("accounts/%i", Request.Method.GET, APIResponseDataType.OBJECT),
    Create("groups/", Request.Method.POST,null)
    ;
    private String endPoint;
    private int method;
    private APIResponseDataType dataType;

    GroupEndpoint(String endPoint, int method, APIResponseDataType dataType) {
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
