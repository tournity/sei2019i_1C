package com.tournity.Data.API;

import android.content.Context;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.tournity.Data.API.Enums.APIEndpoints.Endpoint;
import com.tournity.Data.API.Enums.APIErrors.GuardErrors;
import com.tournity.Data.API.Enums.APIResponseDataType;
import com.tournity.Data.API.Listeners.HttpLitener;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class API {
    static final String URL = "http://192.168.0.12:3000/api/%s";


    static String getURL(Endpoint api) {
        return String.format(URL, api.getEndpoint());
    }

   public static void sendRequestToEndpoint(Context context, Endpoint endpoint, final HashMap<String, String> params, final HttpLitener responseListener) {
        excecuteMethod(
                context,
                getURL(endpoint),
                endpoint.getMethod(),
                endpoint.getResponseDataType(),
                params,
                responseListener
        );
    }

    private static void excecuteMethod(Context context, String url, int method, final APIResponseDataType responseDataType,
                                       final HashMap<String, String> params, final HttpLitener responseListener) {
        RequestQueue queue = Volley.newRequestQueue(context);

        StringRequest MyStringRequest = new StringRequest(method, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    Object data;
                    switch (responseDataType) {
                        case ARRAY:
                            data = new JSONObject(response).getJSONArray("data");
                            break;
                        case OBJECT:
                            data = new JSONObject(response).getJSONObject("data");
                            break;
                        default:
                            data = null;
                            break;
                    }
                    responseListener.onResponse(data);
                } catch (JSONException e) {
                    responseListener.onErrorResponse(GuardErrors.INCORRECT_PASSWORD);
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                responseListener.onErrorResponse(GuardErrors.INCORRECT_PASSWORD);
                error.printStackTrace();
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                return params;
            }

            @Override
            public Map<String, String> getHeaders() {
                return API.getHeaders();
            }
        };
        queue.add(MyStringRequest);
        queue.start();
    }

    static Map<String, String> getHeaders() {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/x-www-form-urlencoded");
        return headers;
    }
}