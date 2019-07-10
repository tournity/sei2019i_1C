package com.tournity.App.Tournaments.Repository.Repositories;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.tournity.App.Tournaments.Entities.TournamentEntity;
import com.tournity.Repository.Enums.RepositoryError;
import com.tournity.Repository.Listeners.RepositoryListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TournamentRepository {
    private Context context;

    public TournamentRepository(Context context) {
        this.context = context;
    }

    public TournamentRepository() {
    }
public static void Insert(final TournamentEntity entity, final Context context, final RepositoryListener<TournamentEntity>listener){
    RequestQueue queue = Volley.newRequestQueue(context);
    String url ="http://10.203.183.88:3000/api/guard/login";
    StringRequest MyStringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            try {
                TournamentEntity tournament= TournamentEntity.fromJSON(new JSONObject(response).getJSONObject("tournamentData"));
                Toast.makeText(context, tournament.getId(), Toast.LENGTH_SHORT).show();
                listener.onQueryCompleted(tournament);
            } catch (JSONException e) {
                listener.onQueryFailed(RepositoryError.JSON_ERROR);
            }
        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            listener.onQueryFailed(RepositoryError.DATA_ERROR);
        }
    }) {

        @Override
        protected Map<String, String> getParams() {
            Map<String, String> MyData = new HashMap<String, String>();
            MyData.put("name", entity.getName());
            MyData.put("description", entity.getDescription());
            MyData.put("start_date",entity.getStartDate().toString());
            MyData.put("end_date",entity.getEndDate().toString());
             MyData.put("user_sport_group",entity.getUserSportGroup()+"");
            MyData.put("created_date",entity.getCreatedDate().toString());
            MyData.put("status",entity.getStatus());
            return MyData;
        }
        @Override
        public Map<String, String> getHeaders() {
            Map<String,String> headers = new HashMap<String, String>();
            headers.put("Content-Type","application/x-www-form-urlencoded");
            return headers;
        }
    };
    queue.add(MyStringRequest);
}
    public static void  selectAll(Context context, RepositoryListener<ArrayList<TournamentEntity>>listener){//ANALIZAR COMO ES EL RESPOND DE UN GET
        RequestQueue queue = Volley.newRequestQueue(context);
        String url ="http://10.203.183.88:3000/api/guard/login";
       /* StringRequest MyStringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    ArrayList<TournamentEntity> tournaments = AccountEntity.fromJSON(new JSONObject(response).getJSONObject("accountData"));
                    Toast.makeText(context, account.getId(), Toast.LENGTH_SHORT).show();
                    listener.onQueryCompleted(account);
                } catch (JSONException e) {
                    listener.onQueryFailed(RepositoryError.JSON_ERROR);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onQueryFailed(RepositoryError.DATA_ERROR);
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> MyData = new HashMap<String, String>();
                MyData.put("email", accountData.getEmail());
                MyData.put("password", accountData.getEncryptedPassword());
                return MyData;
            }
            @Override
            public Map<String, String> getHeaders() {
                Map<String,String> headers = new HashMap<String, String>();
                headers.put("Content-Type","application/x-www-form-urlencoded");
                return headers;
            }
        };
        queue.add(MyStringRequest);*/

    }



    public static  void SelectAllBySportId(int idSport,Context context,RepositoryListener<ArrayList<TournamentEntity>>listener){
     ArrayList<TournamentEntity>result=new ArrayList<>();





    }




public static void SelectAllByDate(Date Initdate,Context context,RepositoryListener<ArrayList<TournamentEntity>>listener){
        ArrayList<TournamentEntity>result=new ArrayList<>();


    }
    public static void SelectAllByOwner(int owner,Context context,RepositoryListener<ArrayList<TournamentEntity>>listener){
        ArrayList<TournamentEntity>result=new ArrayList<>();



    }


}
