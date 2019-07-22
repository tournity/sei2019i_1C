package com.tournity.Data.API.Listeners;

import com.tournity.Data.API.Enums.APIErrors.APIError;

public interface HttpLitener<T> {
    public void onResponse(T responseData);
    public void onErrorResponse(APIError error);
}
