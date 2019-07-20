package com.tournity.App.Match.View.Activities;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;

import com.tournity.App.MatchCompetitor.Bloc.Controllers.MatchCompetitorController;
import com.tournity.R;

public class EditResultActivity extends AppCompatActivity {
    EditText txtpointsTeamA;
    EditText txtpointsTeamB;
    MatchCompetitorController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_result_view);
        txtpointsTeamA = (EditText) findViewById(R.id.pointsTeamAEdit);
        txtpointsTeamB = (EditText) findViewById(R.id.pointsTeamBEdit);
        this.controller = new MatchCompetitorController(this);
        //this.controller.getResult(); se obtiene el resultado actual.
    }

    public EditText getTxtpointsTeamA() {
        return txtpointsTeamA;
    }

    public EditText getTxtpointsTeamB() {
        return txtpointsTeamB;
    }
}
