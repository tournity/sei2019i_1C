package com.tournity.App.MatchCompetitor.Repository.Repositories;

import android.content.Context;

import com.tournity.App.MatchCompetitor.Entities.MatchCompetitorEntity;
import com.tournity.Data.API.API;
import com.tournity.Data.API.Enums.APIEndpoints.MatchCompetitorEndpoint;
import com.tournity.Data.API.Enums.APIErrors.APIError;
import com.tournity.Data.API.Listeners.HttpLitener;
import com.tournity.Repository.Enums.RepositoryError;
import com.tournity.Repository.Listeners.RepositoryListener;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;

public class MatchCompetitorRepository {
    Context context;

    public MatchCompetitorRepository() {

    }


    public static void SelectAllByMatchId(int IdMatch, Context context, final RepositoryListener<ArrayList<MatchCompetitorEntity>> listener) {
        HttpLitener<JSONArray> DataListener = new HttpLitener<JSONArray>() {
            @Override
            public void onResponse(JSONArray responseData) {
                ArrayList<MatchCompetitorEntity> competitors = new ArrayList<>();
                try {
                    for (int i = 0; i < responseData.length(); i++) {
                        competitors.add(MatchCompetitorEntity.fromJSON(responseData.getJSONObject(i)));
                    }
                    listener.onQueryCompleted(competitors);
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
        params.put("match",""+IdMatch);

        API.sendRequestToEndpoint(context, MatchCompetitorEndpoint.getAllByMatchId, params, DataListener);
    }
}

