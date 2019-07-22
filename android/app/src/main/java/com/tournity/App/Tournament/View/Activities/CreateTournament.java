package com.tournity.App.Tournament.View.Activities;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.tournity.App.Tournament.Bloc.Controllers.TournamentController;
import com.tournity.Bloc.Enums.ControllerError;
import com.tournity.Bloc.Listeners.ControllerListener;
import com.tournity.R;

public class CreateTournament extends AppCompatActivity {

    EditText txtTournamentName;
    EditText txtDescription;
    EditText txtDateInit;
    EditText txtDateFinish;
    Button btnCreateTournament;
    Context context;
    TournamentController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_tournament);
        this.context = this;
        txtTournamentName = (EditText) findViewById(R.id.TournamentName);
        txtDescription = (EditText) findViewById(R.id.Description);
        txtDateInit = (EditText) findViewById(R.id.Date);
        txtDateFinish = (EditText) findViewById(R.id.DateFinish);
        btnCreateTournament = (Button) findViewById(R.id.CreateTournament);
        this.controller = new TournamentController(this);
    }

    public void CreateTournament(View v) {


        ControllerListener listener = new ControllerListener() {
            @Override
            public void Then() {
                Toast.makeText(context, "Successful register", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void Catch(ControllerError error) {

            }
        };
        //por defecto se pone el grupo 1 pero hay que reconocer el grupo al que se hace referencia
    }

}
