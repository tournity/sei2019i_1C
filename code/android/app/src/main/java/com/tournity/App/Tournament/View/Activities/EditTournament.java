package com.tournity.App.Tournament.View.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.tournity.App.Tournament.Bloc.Controllers.TournamentController;
import com.tournity.App.Tournament.Entities.TournamentEntity;
import com.tournity.R;

import java.util.Date;

public class EditTournament extends AppCompatActivity {
    TournamentController controller;
    EditText txtdescription;
    EditText txtStartDate;
    EditText txtFinisDate;
    EditText txtCreatedDate;
    EditText txtStatus;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_tournament);
        this.controller = new TournamentController(this);
        txtdescription=(EditText)findViewById(R.id.txtdescriptionEditTournament);
        txtStartDate=(EditText)findViewById(R.id.txtStartDateEditTournament);
        txtFinisDate=(EditText)findViewById(R.id. txtFinisDateEditTournament);
        txtCreatedDate=(EditText)findViewById(R.id.txtCreatedDateEditTournament);
        txtStatus=(EditText)findViewById(R.id.txtStatusEditTournament);
    }

    public void Edit(View v) {
        TournamentEntity entity=new TournamentEntity();
        entity.setDescription(txtdescription.getText().toString());
        entity.setStartDate(new Date(txtStartDate.getText().toString()));
        entity.setEndDate(new Date(txtFinisDate.getText().toString()));
        entity.setCreatedDate(new Date(txtCreatedDate.getText().toString()));
        entity.setStatus(txtStatus.getText().toString());
        controller.Update(entity);
    }
}
