package com.tournity.App.CreateAndListGroup.Repository.Repositories;

import android.content.Context;

import com.tournity.App.CreateAndListGroup.Entities.GroupEntity;
import com.tournity.Data.API.API;
import com.tournity.Data.API.Enums.APIEndpoints.GroupEndpoint;
import com.tournity.Data.API.Enums.APIErrors.APIError;
import com.tournity.Data.API.Listeners.HttpLitener;
import com.tournity.Repository.Enums.RepositoryError;
import com.tournity.Repository.Listeners.RepositoryListener;

import org.json.JSONArray;

import java.util.HashMap;

public class ListGroupRepository {
    public static void getAll(Context context, final RepositoryListener<GroupEntity []> listener){
        HttpLitener grListener = new HttpLitener<JSONArray>() {
            @Override
            public void onResponse(JSONArray responseData) {
            }
            @Override
            public void onErrorResponse(APIError error) {
                listener.onQueryFailed(RepositoryError.DATA_ERROR);
            }
        };
        HashMap<String, String> params = new HashMap<String, String>();
        API.sendRequestToEndpoint(context, GroupEndpoint.getAll,params,grListener);
    }
}
