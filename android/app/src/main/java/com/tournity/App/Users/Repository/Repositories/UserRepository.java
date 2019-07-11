package com.tournity.App.Users.Repository.Repositories;

import android.content.Context;

import com.tournity.App.Authentication.Entities.AccountEntity;
import com.tournity.App.Groups.Entities.GroupEntity;
import com.tournity.Data.API.API;
import com.tournity.Data.API.Enums.APIEndpoints.GroupEndpoint;
import com.tournity.Data.API.Enums.APIErrors.APIError;
import com.tournity.Data.API.Listeners.HttpLitener;
import com.tournity.Repository.Enums.RepositoryError;
import com.tournity.Repository.Listeners.RepositoryListener;

import java.util.HashMap;

public class UserRepository {
    public UserRepository() {
    }
    public static void Insert(final AccountEntity newaccount, final Context context, final RepositoryListener<AccountEntity>listener){
        HttpLitener createAccountListener = new HttpLitener() {
            @Override
            public void onResponse(Object responseData) {
                listener.onQueryCompleted((AccountEntity) responseData);
            }

            @Override
            public void onErrorResponse(APIError error) {
                listener.onQueryFailed(RepositoryError.DATA_ERROR);
            }
        };
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("name", groupData.getName());
        API.sendRequestToEndpoint(context, GroupEndpoint.Create, params, createAccountListener);
    }



}
