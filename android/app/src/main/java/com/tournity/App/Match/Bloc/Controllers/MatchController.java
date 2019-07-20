package com.tournity.App.Match.Bloc.Controllers;

import android.content.Context;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.tournity.App.Match.Entities.MatchEntity;
import com.tournity.App.Match.Repository.Models.MatchModel;
import com.tournity.App.Match.View.Activities.MatchViewActivity;
import com.tournity.App.Match.View.Activities.SelectTypeMatchActivity;
import com.tournity.App.Tournament.Entities.TournamentEntity;
import com.tournity.App.Tournament.Repository.Models.TournamentModel;
import com.tournity.Repository.Enums.ModelError;
import com.tournity.Repository.Listeners.ModelListener;

import java.util.ArrayList;

public class MatchController {
    private Context context;
    private MatchModel matchModel;

    public MatchController(Context context) {
        this.context = context;
        this.matchModel = new MatchModel(context);
    }

    public void getAllByIdTournament(int idTournament) {
        ModelListener<ArrayList<MatchModel>> matches = new ModelListener<ArrayList<MatchModel>>() {
            @Override
            public void onSuccess(ArrayList<MatchModel> model) {
                if (context instanceof MatchViewActivity) {
                    SelectTypeMatchActivity activity = (SelectTypeMatchActivity) context;
                    ArrayList<String> listplayed = new ArrayList<>();
                    ArrayList<String> listforplay = new ArrayList<>();
                    for (MatchModel match : model) {
                        if (match.getMatchEntity().getStatus().equals("PLAYED")) {
                            listplayed.add(match.getMatchEntity().getId() + " " + match.getMatchEntity().getName());
                        } else {
                            listforplay.add(match.getMatchEntity().getId() + " " + match.getMatchEntity().getName());
                        }

                    }
                    ArrayAdapter adapterplayed = new ArrayAdapter(context, android.R.layout.simple_list_item_1, listplayed);
                    ArrayAdapter adapterforplay = new ArrayAdapter(context, android.R.layout.simple_list_item_1, listforplay);
                    activity.getForplay().SetAdapter(adapterforplay);
                    activity.getPlayed().setAdapter(adapterplayed);

                }

            }

            @Override
            public void onError(ModelError error) {
                Toast.makeText(context, "Matches not found", Toast.LENGTH_SHORT).show();
            }
        };
        MatchModel.getByIdTournament(idTournament, this.context, matches);

    }

    public void getById(int id) {
        ModelListener<MatchModel> added = new ModelListener<MatchModel>() {
            @Override
            public void onSuccess(MatchModel model) {
                if (context instanceof MatchViewActivity) {
                    MatchViewActivity activity = (MatchViewActivity) context;
                    activity.txtname.setText(model.getMatchEntity().getName());
                    activity.txtdescription.setText(model.getMatchEntity().getDescription());
                    activity.txtstartime.setText(model.getMatchEntity().getStartDate().toString());
                    activity.txtfinishtime.setText(model.getMatchEntity().getEndDate().toString());
                    activity.txtcreatedDate.setText(model.getMatchEntity().getCreatedDate().toString());
                    activity.txtstatus.setText(model.getMatchEntity().getStatus());
                    activity.txtstageGroup.setText(model.getMatchEntity().getStageGroup());

                }
            }

            @Override
            public void onError(ModelError error) {

            }
        };
        MatchModel.getById(id, context, added);
    }
    public void Update(MatchEntity matchEntity) {
        ModelListener<MatchModel> created = new ModelListener<MatchModel>() {
            @Override
            public void onSuccess(MatchModel model) {
                Toast.makeText(context, "Sucessful Update Tournament", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(ModelError error) {
                Toast.makeText(context, "something was wrong", Toast.LENGTH_SHORT).show();
            }
        };
        MatchModel.Update(matchEntity, this.context, created);
    }
}
