package com.tournity.Data.API.Enums.APIEndpoints;

import com.tournity.Data.API.Enums.APIResponseDataType;

public enum GroupEndpoint implements Endpoint {
    ;
    private String endPoint;
    private int method;
    private APIResponseDataType dataType;
    
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
