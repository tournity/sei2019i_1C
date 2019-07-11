package com.tournity.App.Authentication.Repository.Repositories;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.tournity.App.Authentication.Entities.AccountEntity;
import com.tournity.Data.API.API;
import com.tournity.Data.API.Enums.APIEndpoints.GuardEndpoint;
import com.tournity.Data.API.Enums.APIErrors.APIError;
import com.tournity.Data.API.Listeners.HttpLitener;
import com.tournity.Repository.Enums.RepositoryError;
import com.tournity.Repository.Listeners.RepositoryListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AuthenticationRepository {
    public static void authenticate(final Context context, final AccountEntity accountData, final RepositoryListener<AccountEntity> listener){
        HttpLitener authListener = new HttpLitener<JSONObject>() {
            @Override
            public void onResponse(JSONObject responseData) {
                try {
                    AccountEntity account = AccountEntity.fromJSON(responseData);
                    listener.onQueryCompleted(account);
                } catch (JSONException e) {
                    listener.onQueryFailed(RepositoryError.JSON_ERROR);
                }
            }

            @Override
            public void onErrorResponse(APIError error) {
                listener.onQueryFailed(RepositoryError.DATA_ERROR);
            }
        };
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("email", accountData.getEmail());
        params.put("password", accountData.getEncryptedPassword());

        API.sendRequestToEndpoint(context, GuardEndpoint.Login, params, authListener);
    };
}
