package com.tournity.Data.API.Enums.APIEndpoints;


import com.android.volley.Request;
import com.tournity.App.Tournament.Bloc.Controllers.TournamentController;
import com.tournity.Data.API.Enums.APIResponseDataType;

public enum TournamentEndpoint implements Endpoint {
    getAll("tournaments/",Request.Method.GET,APIResponseDataType.ARRAY ),
    getByIdSport("tournament/",Request.Method.GET,APIResponseDataType.ARRAY),
    getById("tournaments/%i",Request.Method.GET,APIResponseDataType.OBJECT),
    getByOwner("tournaments/%i",Request.Method.GET,APIResponseDataType.ARRAY),
    Insert("tournaments/",Request.Method.POST,APIResponseDataType.OBJECT),
    Update("tournaments/",Request.Method.PUT,APIResponseDataType.OBJECT);


    private String endPoint;
    private int method;
    private APIResponseDataType dataType;

   TournamentEndpoint(String endPoint, int method, APIResponseDataType dataType) {
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
