package com.tournity.App.Tournament.View.Activities;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.tournity.App.Tournament.Bloc.Controllers.TournamentController;
import com.tournity.R;

public class EditTournament extends AppCompatActivity {
   TournamentController controller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_tournament);
   this.controller=new TournamentController(this);
   }
    public void Edit(View v){

    }
}
