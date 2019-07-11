package com.tournity.App.Player.View.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.tournity.R;

public class AddPlayerActivity extends AppCompatActivity {
    Button btnAddPlayer;

    protected void onCreate(Bundle bundleSavedInstance) {
        super.onCreate(bundleSavedInstance);
        setContentView(R.layout.activity_add_player);
        btnAddPlayer = findViewById(R.id.btn_add_player);
        btnAddPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
