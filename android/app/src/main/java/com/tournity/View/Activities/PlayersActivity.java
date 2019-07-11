package com.tournity.View.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.tournity.R;

public class PlayersActivity extends AppCompatActivity {
    Button btnAddPlayer;

    protected void onCreate(Bundle bundleSavedInstance) {
        super.onCreate(bundleSavedInstance);
        setContentView(R.layout.activity_list_players);
        btnAddPlayer = findViewById(R.id.buttonAddPlayer);
        btnAddPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PlayersActivity.this, AddPlayerActivity.class);
                startActivity(intent);
            }
        });
    }
}
