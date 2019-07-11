package com.tournity.App.Team.Bloc.Controllers;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.tournity.App.Team.View.Activities.CreateTeamActivity;
import com.tournity.App.Team.View.Activities.TeamsActivity;
import com.tournity.Bloc.Enums.ControllerError;
import com.tournity.Bloc.Listeners.TeamListener;
import com.tournity.Repository.Enums.ModelError;
import com.tournity.Repository.Listeners.ModelListener;
import com.tournity.Repository.Models.TeamModel;

public class TeamController {
    Context ctx;

    public TeamController(Context ctx) {
        this.ctx = ctx;
    }

    public void getTeams(String groupID) {
        ModelListener teamListener = new ModelListener<TeamModel>() {

            @Override
            public void onSuccess(TeamModel model) {
                Intent intent = new Intent(ctx, CreateTeamActivity.class);
                ctx.startActivity(intent);
            }

            @Override
            public void onError(ModelError error) {
                Toast.makeText(ctx, "Equipo no encontrado", Toast.LENGTH_SHORT).show();

            }
        };
    }
}
