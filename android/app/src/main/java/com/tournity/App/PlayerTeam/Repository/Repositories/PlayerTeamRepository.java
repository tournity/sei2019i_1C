package com.tournity.App.PlayerTeam.Repository.Repositories;

import android.content.Context;

import com.tournity.App.Player.Entities.PlayerEntity;
import com.tournity.Data.API.Enums.APIErrors.APIError;
import com.tournity.Data.API.Listeners.HttpLitener;
import com.tournity.Repository.Listeners.RepositoryListener;

import org.json.JSONArray;

import java.util.ArrayList;

public class PlayerTeamRepository {
    private Context context;

    public PlayerTeamRepository() {
    }
    public void SelectPlayerByTeam(int IdTeam, Context context, RepositoryListener<ArrayList<PlayerEntity>>listener){
        HttpLitener<JSONArray>DataListener=new HttpLitener<JSONArray>() {
            @Override
            public void onResponse(JSONArray responseData) {
                ArrayList<PlayerEntity>players=new ArrayList<>();
                for(int i=0;i<responseData.length();i++){
                    //players.add(PlayerEntity.fromJSON())
                }
            }

            @Override
            public void onErrorResponse(APIError error) {

            }
        };
    }
}
