package com.tournity.App.Match.View.Activities;

import androidx.appcompat.app.AppCompatActivity;

import com.tournity.App.Match.Bloc.Controllers.MatchController;
import com.tournity.App.Match.Entities.MatchEntity;
import com.tournity.R;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Date;

public class EditMatchActivity extends AppCompatActivity {
    MatchController controller;
    EditText textDescription;
    EditText textStartDate;
    EditText textFinisDate;
    EditText textCreatedDate;
    EditText textStatus;
    EditText textStageGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_match);
        this.controller = new MatchController(this);
        textDescription = findViewById(R.id.description_edit_text);
        textStartDate = findViewById(R.id.editText1);
        textFinisDate = findViewById(R.id.editText2);
        textCreatedDate = findViewById(R.id.editText3);
        textStatus = findViewById(R.id.editText4);
        textStageGroup = findViewById(R.id.editText5);
    }

    public void Update (View view){
        MatchEntity entity = new MatchEntity();
        entity.setDescription(textDescription.getText().toString());
        entity.setStartDate(new Date(textStartDate.getText().toString()));
        entity.setEndDate(new Date(textFinisDate.getText().toString()));
        entity.setCreatedDate(new Date(textCreatedDate.getText().toString()));
        entity.setCreatedDate(new Date(textCreatedDate.getText().toString()));
        entity.setStatus(textStatus.getText().toString());
        entity.setStageGroup(Integer.parseInt(textStageGroup.getText().toString()));
        controller.update(entity);
    }
}
