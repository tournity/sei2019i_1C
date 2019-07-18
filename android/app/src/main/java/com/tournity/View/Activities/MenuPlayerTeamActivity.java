package com.tournity.View.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.tournity.App.Player.View.Activities.PlayersActivity;
import com.tournity.App.Team.View.Activities.TeamsActivity;
import com.tournity.R;

public class MenuPlayerTeamActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_player_team);
    }

    public void onClick(View view) {
        Intent myIntent=null;
        switch (view.getId()){
            case R.id.btnPlayers:
                myIntent = new Intent(MenuPlayerTeamActivity.this, PlayersActivity.class);
                break;
            case R.id.btnTeams:
                myIntent = new Intent(MenuPlayerTeamActivity.this, TeamsActivity.class);
                break;
        }
        startActivity(myIntent);
    }
}
