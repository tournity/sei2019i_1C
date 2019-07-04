package com.tournity.View.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.*;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.tournity.R;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {
    private TextView mTextViewResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextViewResult = findViewById(R.id.text_view_result);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://192.168.0.11:3000/api/account/signup";
        StringRequest MyStringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                mTextViewResult.setText("true");
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mTextViewResult.setText(error.getMessage());
            }
        }) {
            protected Map<String, String> getParams() {
                Map<String, String> MyData = new HashMap<String, String>();
                MyData.put("email", "pepe@pepe.coodsfsdf");
                MyData.put("name", "pepepepecoo");
                MyData.put("type", "user");
                MyData.put("password", "pepe@pepe.coo");
                return MyData;
            }
        };

        queue.add(MyStringRequest);
    }

}
