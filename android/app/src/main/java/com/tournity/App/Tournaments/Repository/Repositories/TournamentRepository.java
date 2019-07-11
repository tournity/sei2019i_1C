package com.tournity.App.Tournaments.Repository.Repositories;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.tournity.App.Tournaments.Entities.TournamentEntity;
import com.tournity.Repository.Listeners.RepositoryListener;

import java.util.ArrayList;
import java.util.Date;

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
