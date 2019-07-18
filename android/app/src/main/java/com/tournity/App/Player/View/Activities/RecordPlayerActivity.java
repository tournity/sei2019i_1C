package com.tournity.App.Player.View.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.tournity.R;

public class RecordPlayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_player);
    }

    public void onClick(View view) {
        Intent myIntent = new Intent(RecordPlayerActivity.this,EditPlayerProfileActivity.class);
        startActivity(myIntent);
    }
}
