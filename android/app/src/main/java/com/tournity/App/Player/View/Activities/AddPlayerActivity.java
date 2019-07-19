package com.tournity.App.Player.View.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.tournity.R;

public class AddPlayerActivity extends AppCompatActivity {
    Button btnAddPlayer;
    EditText editTextName;
    EditText editTextType;
    EditText editTextDesc;
    EditText editTextSport;
    protected void onCreate(Bundle bundleSavedInstance) {
        super.onCreate(bundleSavedInstance);
        setContentView(R.layout.activity_add_player);
        btnAddPlayer = findViewById(R.id.idBtn_add_player);
        editTextName = findViewById(R.id.idNameAddPlayer);
        editTextType = findViewById(R.id.idTypeAddPlayer);
        editTextDesc = findViewById(R.id.idDescriptionAddPlayer);
        editTextSport = findViewById(R.id.idSportGroupAddSport);
        btnAddPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
