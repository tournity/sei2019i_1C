package com.tournity.App.Groups.View.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.tournity.App.Groups.Bloc.Controllers.GroupController;
import com.tournity.R;

public class CreateGroupActivity extends AppCompatActivity {
    GroupController controller;
    EditText editText;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_group);

        controller = new GroupController(this);
        editText = (EditText) findViewById(R.id.idGroupName);
    }

    public void onClick(View v){
        controller.create(editText.getText().toString());
    }
}
