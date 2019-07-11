package com.tournity.App.Groups.View.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.tournity.App.Player.View.Activities.PlayersActivity;
import com.tournity.App.Team.View.Activities.TeamsActivity;
import com.tournity.R;

public class PlayerOrTeamActivity extends AppCompatActivity {
    private Button btnPlayers;
    private Button btnTeams;

    protected void onCreate(Bundle savedBundleInstance) {
        super.onCreate(savedBundleInstance);
        setContentView(R.layout.activity_player_teams);
        btnPlayers = findViewById(R.id.button2);
        btnTeams = findViewById(R.id.button3);

        btnPlayers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PlayerOrTeamActivity.this, PlayersActivity.class);
                startActivity(intent);
            }
        });
        btnTeams.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PlayerOrTeamActivity.this, TeamsActivity.class);
                startActivity(intent);
            }
        });
    }
}
