package com.tournity.App.CreateAndListGroup.View.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.tournity.App.CreateAndListGroup.Bloc.Controllers.ListGroupController;
import com.tournity.R;

public class ListGroupActivity extends AppCompatActivity {
    public ListView listView;
    ListGroupController controller;
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
