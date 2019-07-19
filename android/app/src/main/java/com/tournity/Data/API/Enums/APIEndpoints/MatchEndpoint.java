package com.tournity.Data.API.Enums.APIEndpoints;



import com.tournity.Data.API.Enums.APIResponseDataType;


import com.android.volley.Request;
public enum MatchEndpoint implements Endpoint {
    getAllByIdTournament("match/%i", Request.Method.GET,APIResponseDataType.ARRAY),
    getById("match/%i",Request.Method.GET,APIResponseDataType.OBJECT);
    private String endPoint;
    private int method;
    private APIResponseDataType dataType;

    MatchEndpoint(String endPoint, int method, APIResponseDataType dataType) {
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
