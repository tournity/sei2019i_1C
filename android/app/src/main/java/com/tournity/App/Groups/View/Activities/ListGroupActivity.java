package com.tournity.App.Groups.View.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.tournity.App.Groups.Bloc.Controllers.GroupController;
import com.tournity.R;

public class ListGroupActivity extends AppCompatActivity {
    public ListView listView;
    GroupController controller;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listView = findViewById(R.id.idListGroup);
        controller.listGroups();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //
            }
        });
    }

}
