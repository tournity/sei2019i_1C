package com.tournity.Data.API;

import com.tournity.Data.API.APIEndpoints.UserEndpoint;

public class API {
    static  final String URL = "192.168.0.11:3000/%s";


    static String getEndPoint(UserEndpoint api){
        return String.format(URL, api.getEndpoint());
    }
}