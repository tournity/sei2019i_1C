package com.tournity.App.Match.View.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.EditText;

import com.tournity.App.MatchCompetitor.Bloc.Controllers.MatchCompetitorController;
import com.tournity.R;

public class EditResultActivity extends AppCompatActivity {
    EditText textPointsTeamA;
    EditText textPointsTeamB;
    MatchCompetitorController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_result_view);
        textPointsTeamA = (EditText) findViewById(R.id.pointsTeamAEdit);
        textPointsTeamB = (EditText) findViewById(R.id.pointsTeamBEdit);
        this.controller = new MatchCompetitorController(this);
        //this.controller.getResult(); se obtiene el resultado actual.
    }

    public EditText getTextPointsTeamA() {
        return textPointsTeamA;
    }

    public EditText getTextPointsTeamB() {
        return textPointsTeamB;
    }
}
