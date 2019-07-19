package com.tournity.App.Tournament.View.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.tournity.App.Match.View.Activities.SelectTypeMatchActivity;
import com.tournity.App.Tournament.Bloc.Controllers.TournamentController;
import com.tournity.R;

import java.util.ArrayList;

public class TournamentViewActivity extends AppCompatActivity {
    TournamentController controller;
    TextView txtTournamentName;
    TextView txtdescription;
    TextView txtStartDate;
    TextView txtFinishDate;
    TextView txtCreatedDate;
    TextView txtStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tournament_view);
        controller = new TournamentController(this);
        txtTournamentName = (TextView) findViewById(R.id.txtTournamentName);
        txtdescription = (TextView) findViewById(R.id.txtdescription);
        txtStartDate = (TextView) findViewById(R.id.txtStartDate);
        txtFinishDate = (TextView) findViewById(R.id.txtFinishDate);
        txtCreatedDate = (TextView) findViewById(R.id.txtCreatedDate);
        txtStatus=(TextView)findViewById(R.id.txtStatus);


        int idTournament = getIntent().getIntExtra("idTournament", 1);


    }

    public void gotoMatches(View view) {


        Intent intent = new Intent(this, SelectTypeMatchActivity.class);
        startActivity(intent);

    }
}
