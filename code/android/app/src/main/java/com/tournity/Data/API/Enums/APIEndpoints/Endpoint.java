package com.tournity.Data.API.Enums.APIEndpoints;

import com.tournity.Data.API.Enums.APIResponseDataType;

public interface Endpoint {
   public String getEndpoint();
   public int getMethod();
   public APIResponseDataType getResponseDataType();
}
