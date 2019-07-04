package com.tournity.App.Authentication.Repository.Repositories;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.tournity.App.Authentication.Entities.AccountEntity;
import com.tournity.Repository.Listeners.RepositoryListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AunthenticationRepository {


    public static void authenticate(final AccountEntity accountData, Context context, final RepositoryListener<AccountEntity> listener){
        RequestQueue queue = Volley.newRequestQueue(context);
        String url ="http://192.168.0.11:3000/api/guard/login";
        StringRequest MyStringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    listener.onQueryCompleted(new AccountEntity().fromJSON(new JSONObject(response).getJSONObject("user_data").toString()));
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            protected Map<String, String> getParams() {
                Map<String, String> MyData = new HashMap<String, String>();
                MyData.put("email", accountData.getEmail());
                MyData.put("password", accountData.getPassword());
                return MyData;
            }
        };
    };
}
