package com.tournity.App.Team.View.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.tournity.R;

public class TeamsActivity extends AppCompatActivity {
    private Button btnCreate;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_list);
        btnCreate = findViewById(R.id.btnCreateTeam);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TeamsActivity.this, CreateTeamActivity.class);
                startActivity(intent);
            }
        });
    }

}
