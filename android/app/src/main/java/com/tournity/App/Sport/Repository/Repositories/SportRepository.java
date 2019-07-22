package com.tournity.App.Sport.Repository.Repositories;

import android.content.Context;

import com.tournity.App.Sport.Entities.SportEntity;
import com.tournity.App.Tournament.Entities.TournamentEntity;
import com.tournity.Data.API.API;
import com.tournity.Data.API.Enums.APIEndpoints.SportEndpoint;
import com.tournity.Data.API.Enums.APIEndpoints.TournamentEndpoint;
import com.tournity.Data.API.Enums.APIErrors.APIError;
import com.tournity.Data.API.Listeners.HttpLitener;
import com.tournity.Repository.Enums.RepositoryError;
import com.tournity.Repository.Listeners.RepositoryListener;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;

public class SportRepository {
    public static void SelectAllBySportId(Context context, final RepositoryListener<ArrayList<SportEntity>> listener) {
        HttpLitener DataListener = new HttpLitener<JSONArray>() {

            @Override
            public void onResponse(JSONArray responseData) {
                ArrayList<SportEntity> sports = new ArrayList<>();
                try {
                    for (int i = 0; i < responseData.length(); i++) {
                        sports.add(SportEntity.fromJSON(responseData.getJSONObject(i)));
                        listener.onQueryCompleted(sports);
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
        //--Revisar--------------------------------------
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("idsport", "" );
        API.sendRequestToEndpoint(context, SportEndpoint.getByIdSport, params, DataListener);
        //---------------------------------------------------------

    }
}
