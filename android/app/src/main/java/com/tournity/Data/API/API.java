package com.tournity.Data.API;

import com.tournity.Data.API.APIEndpoints.UserEndpoint;

public class API {
    static  final String URL = "localhost:3435/%s";


    static String getEndPoint(UserEndpoint api){
        return String.format(URL, api.getEndpoint());
    }
}