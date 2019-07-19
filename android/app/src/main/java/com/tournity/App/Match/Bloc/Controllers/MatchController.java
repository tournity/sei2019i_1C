package com.tournity.App.Match.Bloc.Controllers;

import android.content.Context;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.tournity.App.Match.Repository.Models.MatchModel;
import com.tournity.App.Match.View.Activities.MatchViewActivity;
import com.tournity.App.Match.View.Activities.SelectTypeMatchActivity;
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
                    ArrayList<String>listforplay=new ArrayList<>();
                    for (MatchModel match : model) {
                        if(match.getMatchEntity().getStatus().equals("PLAYED")){
                            listplayed.add(match.getMatchEntity().getId() + " " + match.getMatchEntity().getName());
                        }else{
                            listforplay.add(match.getMatchEntity().getId() + " " + match.getMatchEntity().getName());
                        }

                    }
                    ArrayAdapter adapterplayed = new ArrayAdapter(context, android.R.layout.simple_list_item_1, listplayed);
                    ArrayAdapter adapterforplay=new ArrayAdapter(context, android.R.layout.simple_list_item_1, listforplay);
                   activity.getForplay().SetAdapter(adapterforplay);
                   activity.getPlayed().setAdapter(adapterplayed);

                }

            }

            @Override
            public void onError(ModelError error) {
                Toast.makeText(context, "Matches not found", Toast.LENGTH_SHORT).show();
            }
        };
MatchModel.getByIdTournament(idTournament,this.context,matches);

    }
}
