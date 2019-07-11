package com.tournity.App.Groups.View.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.tournity.App.Team.View.Activities.CreateTeamActivity;
import com.tournity.R;

import java.util.ArrayList;

public class CreateTeamSelectGroupActivity extends AppCompatActivity {
    ListView listViewGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_team_select_group);

        listViewGroup = findViewById(R.id.idListViewTournaments);

        ArrayList<String> listGroupString = new ArrayList<>();
        //listGroupString = ...
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,listGroupString);

        listViewGroup.setAdapter(adapter);

        listViewGroup.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(CreateTeamSelectGroupActivity.this, CreateTeamActivity.class);

                Bundle bundle = new Bundle();
                bundle.putString("name",listViewGroup.getTransitionName());

                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
