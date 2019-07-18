package com.tournity.App.Group.View.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.tournity.App.Group.Bloc.Controllers.GroupController;
import com.tournity.R;

public class ListGroupActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    public ListView listView;
    GroupController controller;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listView = findViewById(R.id.idListSport);
        controller.listGroups();
        listView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}
