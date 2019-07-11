package com.tournity.App.Groups.Repository.Repositories;

import android.content.Context;

import com.tournity.App.Groups.Entities.GroupEntity;
import com.tournity.Data.API.API;
import com.tournity.Data.API.Enums.APIEndpoints.GroupEndpoint;
import com.tournity.Data.API.Enums.APIErrors.APIError;
import com.tournity.Data.API.Listeners.HttpLitener;
import com.tournity.Repository.Enums.RepositoryError;
import com.tournity.Repository.Listeners.RepositoryListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class GroupRepository {


    public static void selectAll(Context context, final RepositoryListener<ArrayList<GroupEntity>> listener) {
        HttpLitener grListener = new HttpLitener<JSONArray>() {
            @Override
            public void onResponse(JSONArray responseData) {
                ArrayList groupArray = new ArrayList<GroupEntity>();
                try {
                    for (int i = 0; i < responseData.length(); i++) {
                        groupArray.add(GroupEntity.fromJSON(responseData.getJSONObject(i)));
                        listener.onQueryCompleted(groupArray);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    listener.onQueryFailed(RepositoryError.JSON_ERROR);
                }
            }

            @Override
            public void onErrorResponse(APIError error) {
                listener.onQueryFailed(RepositoryError.DATA_ERROR);
            }
        };
        HashMap<String, String> params = new HashMap<String, String>();
        API.sendRequestToEndpoint(context, GroupEndpoint.getAll, params, grListener);
    }

    public static void insert(final Context context, final GroupEntity groupData, final RepositoryListener<GroupEntity> listener) {
        HttpLitener createGListener = new HttpLitener() {
            @Override
            public void onResponse(Object responseData) {
                listener.onQueryCompleted((GroupEntity) responseData);
            }

            @Override
            public void onErrorResponse(APIError error) {
                listener.onQueryFailed(RepositoryError.DATA_ERROR);
            }
        };
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("name", groupData.getName());
        API.sendRequestToEndpoint(context, GroupEndpoint.Create, params, createGListener);
    }
}

