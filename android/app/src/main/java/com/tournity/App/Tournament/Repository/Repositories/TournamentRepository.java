package com.tournity.App.Tournament.Repository.Repositories;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.tournity.App.Tournament.Entities.TournamentEntity;
import com.tournity.Data.API.API;
import com.tournity.Data.API.Enums.APIEndpoints.GroupEndpoint;
import com.tournity.Data.API.Enums.APIEndpoints.TournamentEndpoint;
import com.tournity.Data.API.Enums.APIErrors.APIError;
import com.tournity.Data.API.Listeners.HttpLitener;
import com.tournity.Repository.Enums.RepositoryError;
import com.tournity.Repository.Listeners.RepositoryListener;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class TournamentRepository {
    private Context context;

    public TournamentRepository(Context context) {
        this.context = context;
    }

    public TournamentRepository() {
    }
public static void Insert(final TournamentEntity entity, final Context context,
                          final RepositoryListener<TournamentEntity>listener){

}
    public static void  selectAll(Context context, final RepositoryListener<ArrayList<TournamentEntity>>listener){//ANALIZAR COMO ES EL RESPOND DE UN GET
        HttpLitener DataListener=new HttpLitener<JSONArray>() {


            @Override
            public void onResponse(JSONArray responseData) {
                ArrayList<TournamentEntity>tournaments=new ArrayList<>();
                try {
                for(int i=0;i<responseData.length();i++){
                    tournaments.add(TournamentEntity.fromJSON(responseData.getJSONObject(i)));
                    listener.onQueryCompleted(tournaments);
                }
                }catch (JSONException e){
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


        API.sendRequestToEndpoint(context, TournamentEndpoint.getAll, params, DataListener);

        };



    public static  void SelectAllBySportId(int idSport,Context context,final RepositoryListener<ArrayList<TournamentEntity>>listener){
        HttpLitener DataListener=new HttpLitener<JSONArray>() {


            @Override
            public void onResponse(JSONArray responseData) {
                ArrayList<TournamentEntity>tournaments=new ArrayList<>();
                try {
                    for(int i=0;i<responseData.length();i++){
                        tournaments.add(TournamentEntity.fromJSON(responseData.getJSONObject(i)));
                        listener.onQueryCompleted(tournaments);
                    }
                }catch (JSONException e){
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
        params.put("idsport",  ""+idSport);
        API.sendRequestToEndpoint(context, TournamentEndpoint.getById, params, DataListener);



    }




public static void SelectAllByDate(Date Initdate,Context context,RepositoryListener<ArrayList<TournamentEntity>>listener){
        ArrayList<TournamentEntity>result=new ArrayList<>();


    }
    public static void SelectAllByOwner(int owner,Context context,final RepositoryListener<ArrayList<TournamentEntity>>listener){
        HttpLitener DataListener=new HttpLitener<JSONArray>() {


            @Override
            public void onResponse(JSONArray responseData) {
                ArrayList<TournamentEntity>tournaments=new ArrayList<>();
                try {
                    for(int i=0;i<responseData.length();i++){
                        tournaments.add(TournamentEntity.fromJSON(responseData.getJSONObject(i)));
                        listener.onQueryCompleted(tournaments);
                    }
                }catch (JSONException e){
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
        params.put("idowner",  ""+owner);
        API.sendRequestToEndpoint(context, TournamentEndpoint.getByOwner, params, DataListener);




    }


}
