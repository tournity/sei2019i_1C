package com.tournity.App.Match.Repository.Repositories;

import android.content.Context;
import android.view.contentcapture.ContentCaptureCondition;

import com.tournity.App.Match.Entities.MatchEntity;
import com.tournity.Data.API.API;
import com.tournity.Data.API.Enums.APIEndpoints.MatchEndpoint;
import com.tournity.Data.API.Enums.APIEndpoints.TournamentEndpoint;
import com.tournity.Data.API.Enums.APIErrors.APIError;
import com.tournity.Data.API.Listeners.HttpLitener;
import com.tournity.Repository.Enums.RepositoryError;
import com.tournity.Repository.Listeners.RepositoryListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MatchRepository {
    private Context context;

    public MatchRepository() {

    }

    public static void SelectByIdTournament(int idTournament, Context context, final RepositoryListener<ArrayList<MatchEntity>> listener) {
        HttpLitener DataListener = new HttpLitener<JSONArray>() {
            @Override
            public void onResponse(JSONArray responseData) {
                ArrayList<MatchEntity> array = new ArrayList<>();
                try {
                    for (int i = 0; i < responseData.length(); i++) {
                        array.add(MatchEntity.fromJSON(responseData.getJSONObject(i)));
                    }
                    listener.onQueryCompleted(array);
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
        params.put("idTournament",""+idTournament);

        API.sendRequestToEndpoint(context, MatchEndpoint.getAllByIdTournament, params, DataListener);
    }
    public static void SelectById(int id,Context context,final RepositoryListener<MatchEntity>listener){
        HttpLitener DataListener = new HttpLitener<JSONObject>() {
            @Override
            public void onResponse(JSONObject responseData) {
                ArrayList<MatchEntity> array = new ArrayList<>();
                try {

                    listener.onQueryCompleted(MatchEntity.fromJSON(responseData));
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
        params.put("id",""+id);

        API.sendRequestToEndpoint(context, MatchEndpoint.getById, params, DataListener);
    }
}
