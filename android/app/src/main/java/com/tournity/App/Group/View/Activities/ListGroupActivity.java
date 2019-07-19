package com.tournity.App.Group.View.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.tournity.App.Group.Bloc.Controllers.GroupController;
import com.tournity.R;

import java.util.ArrayList;

public class ListGroupActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    public ListView listView;
    GroupController controller;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_groups);
        listView = findViewById(R.id.idDataUser);
        controller = new GroupController(this);
        controller.listGroups();

        //----Test---------------------------------------------
        ArrayList<String> listGroupName = new ArrayList<>();
        listGroupName.add("grupo 1");
        listGroupName.add("grupo 2");
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_expandable_list_item_1, listGroupName);
        listView.setAdapter(adapter);
        //----------------------------------------------------


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}
