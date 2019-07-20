package com.tournity.App.MatchCompetitor.Repository.Repositories;

import android.content.Context;

import com.tournity.App.MatchCompetitor.Entities.MatchCompetitorEntity;
import com.tournity.Data.API.Enums.APIErrors.APIError;
import com.tournity.Data.API.Listeners.HttpLitener;
import com.tournity.Repository.Listeners.RepositoryListener;

import org.json.JSONArray;

import java.util.ArrayList;

public class MatchCompetitorRepository {
    Context context;

    public MatchCompetitorRepository() {

    }


    public static void getByMatchId(int IdMatch, Context context, RepositoryListener<ArrayList<MatchCompetitorEntity>>listener){
        HttpLitener<JSONArray>DataListener=new HttpLitener<JSONArray>() {
            @Override
            public void onResponse(JSONArray responseData) {
                ArrayList<MatchCompetitorEntity>competitors=new ArrayList<>();
                for(int i=0;i<responseData.length();i++){
                    competitors.add(new )
                }
                listener.onQueryCompleted();
            }

            @Override
            public void onErrorResponse(APIError error) {

            }
        }
    }
}
