package com.tournity.App.CreateAndListGroup.Repository.Repositories;

import android.content.Context;

import com.tournity.App.CreateAndListGroup.Entities.GroupEntity;
import com.tournity.Data.API.API;
import com.tournity.Data.API.Enums.APIEndpoints.CeateGroupEndpoint;
import com.tournity.Data.API.Enums.APIErrors.APIError;
import com.tournity.Data.API.Listeners.HttpLitener;
import com.tournity.Repository.Enums.RepositoryError;
import com.tournity.Repository.Listeners.RepositoryListener;

import java.util.HashMap;

public class CreateGroupRepository {

    public static void createGroup(final Context context, final GroupEntity groupData,final RepositoryListener<GroupEntity>listener){
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
        params.put("name",groupData.getName());
        API.sendRequestToEndpoint(context, CeateGroupEndpoint.Create,params,createGListener);
    }
}
