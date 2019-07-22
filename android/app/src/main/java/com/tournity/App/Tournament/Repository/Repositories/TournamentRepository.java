package com.tournity.App.Tournament.Repository.Repositories;

import android.content.Context;
import android.provider.ContactsContract;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.tournity.App.Tournament.Entities.TournamentEntity;
import com.tournity.App.Tournament.Repository.Models.TournamentModel;
import com.tournity.Data.API.API;
import com.tournity.Data.API.Enums.APIEndpoints.GroupEndpoint;
import com.tournity.Data.API.Enums.APIEndpoints.TournamentEndpoint;
import com.tournity.Data.API.Enums.APIErrors.APIError;
import com.tournity.Data.API.Listeners.HttpLitener;
import com.tournity.Repository.Enums.ModelError;
import com.tournity.Repository.Enums.RepositoryError;
import com.tournity.Repository.Listeners.ModelListener;
import com.tournity.Repository.Listeners.RepositoryListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

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
                              final RepositoryListener<TournamentEntity> listener) {


        HttpLitener DataListener = new HttpLitener<JSONObject>() {
            @Override
            public void onResponse(JSONObject responseData) {
                try {
                    listener.onQueryCompleted(TournamentEntity.fromJSON(responseData));
                } catch (JSONException e) {
                    listener.onQueryFailed(RepositoryError.JSON_ERROR);
                    e.printStackTrace();
                }
            }

            @Override
            public void onErrorResponse(APIError error) {
                listener.onQueryFailed(RepositoryError.DATA_ERROR);
            }
        };
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("name", entity.getName());
        params.put("description", entity.getDescription());
        params.put("start_date", entity.getStartDate().toString());
        params.put("end_date", entity.getEndDate().toString());
        params.put("user_sport_group", entity.getUserSportGroup() + "");
        params.put("created_date", entity.getCreatedDate().toString());
        params.put("status", entity.getStatus());
        API.sendRequestToEndpoint(context, TournamentEndpoint.Insert, params, DataListener);
    }

    public static void selectAll(Context context, final RepositoryListener<ArrayList<TournamentEntity>> listener) {//ANALIZAR COMO ES EL RESPOND DE UN GET
        HttpLitener DataListener = new HttpLitener<JSONArray>() {


            @Override
            public void onResponse(JSONArray responseData) {
                ArrayList<TournamentEntity> tournaments = new ArrayList<>();
                try {
                    for (int i = 0; i < responseData.length(); i++) {
                        tournaments.add(TournamentEntity.fromJSON(responseData.getJSONObject(i)));

                    }
                    listener.onQueryCompleted(tournaments);
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


        API.sendRequestToEndpoint(context, TournamentEndpoint.getAll, params, DataListener);

    }

    ;


    public static void SelectAllBySportId(int idSport, Context context, final RepositoryListener<ArrayList<TournamentEntity>> listener) {
        HttpLitener DataListener = new HttpLitener<JSONArray>() {


            @Override
            public void onResponse(JSONArray responseData) {
                ArrayList<TournamentEntity> tournaments = new ArrayList<>();
                try {
                    for (int i = 0; i < responseData.length(); i++) {
                        tournaments.add(TournamentEntity.fromJSON(responseData.getJSONObject(i)));
                        listener.onQueryCompleted(tournaments);
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
        params.put("idsport", "" + idSport);
        API.sendRequestToEndpoint(context, TournamentEndpoint.getByIdSport, params, DataListener);


    }


   /* public static void SelectAllByDate(Date Initdate, Context context, RepositoryListener<ArrayList<TournamentEntity>> listener) {
        ArrayList<TournamentEntity> result = new ArrayList<>();


    }*/

    public static void SelectAllByOwner(int owner, Context context, final RepositoryListener<ArrayList<TournamentEntity>> listener) {
        HttpLitener DataListener = new HttpLitener<JSONArray>() {


            @Override
            public void onResponse(JSONArray responseData) {
                ArrayList<TournamentEntity> tournaments = new ArrayList<>();
                try {
                    for (int i = 0; i < responseData.length(); i++) {
                        tournaments.add(TournamentEntity.fromJSON(responseData.getJSONObject(i)));
                        listener.onQueryCompleted(tournaments);
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
        params.put("idowner", "" + owner);
        API.sendRequestToEndpoint(context, TournamentEndpoint.getByOwner, params, DataListener);


    }

    public static void SelectById(int id, Context context, final RepositoryListener<TournamentEntity> listener) {
        HttpLitener DataListener = new HttpLitener<JSONObject>() {
            @Override
            public void onResponse(JSONObject responseData) {
                try {
                    listener.onQueryCompleted(TournamentEntity.fromJSON(responseData));
                } catch (JSONException e) {
                    listener.onQueryFailed(RepositoryError.JSON_ERROR);
                    e.printStackTrace();
                }
            }

            @Override
            public void onErrorResponse(APIError error) {
                listener.onQueryFailed(RepositoryError.DATA_ERROR);
            }
        };

        HashMap<String, String> params = new HashMap<String, String>();
        params.put("id", "" + id);
        API.sendRequestToEndpoint(context, TournamentEndpoint.getById, params, DataListener);
    }

    public static void Update(TournamentModel entity, Context context, final RepositoryListener<TournamentEntity> listener) {
        HttpLitener<JSONObject> DataListener = new HttpLitener<JSONObject>() {
            @Override
            public void onResponse(JSONObject responseData) {
                try {
                    listener.onQueryCompleted(TournamentEntity.fromJSON(responseData));
                } catch (JSONException e) {
                    listener.onQueryFailed(RepositoryError.JSON_ERROR);
                    e.printStackTrace();
                }
            }

            @Override
            public void onErrorResponse(APIError error) {
                listener.onQueryFailed(RepositoryError.DATA_ERROR);
            }
        };
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("id", entity.getTournamentEntity().getId() + "");
        params.put("name", entity.getTournamentEntity().getName());
        params.put("description", entity.getTournamentEntity().getDescription());
        params.put("start_date", entity.getTournamentEntity().getStartDate().toString());
        params.put("end_date", entity.getTournamentEntity().getEndDate().toString());
        params.put("user_sport_group", entity.getTournamentEntity().getUserSportGroup() + "");
        params.put("created_date", entity.getTournamentEntity().getCreatedDate().toString());
        params.put("status", entity.getTournamentEntity().getStatus());
        API.sendRequestToEndpoint(context, TournamentEndpoint.Update, params, DataListener);

    }

}
