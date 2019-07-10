package com.tournity.View.Activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.tournity.R;

public class CreateTournament extends AppCompatActivity {

    EditText txtTournamentName;
    EditText txtDescription;
    EditText txtDate;
    Button btnCreateTournament;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_tournament);
        txtTournamentName = (EditText) findViewById(R.id.TournamentName);
        txtDescription = (EditText) findViewById(R.id.Description);
        txtDate = (EditText) findViewById(R.id.Date);
        btnCreateTournament=(Button)findViewById(R.id.CreateTournament);

    }
}
