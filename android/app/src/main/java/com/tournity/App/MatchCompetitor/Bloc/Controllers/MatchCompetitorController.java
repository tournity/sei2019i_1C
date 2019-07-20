package com.tournity.App.MatchCompetitor.Bloc.Controllers;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import com.tournity.App.Match.View.Activities.EditResultActivity;
import com.tournity.App.Match.View.Activities.MatchViewActivity;
import com.tournity.App.MatchCompetitor.Repository.Models.MatchCompetitorModel;
import com.tournity.Repository.Enums.ModelError;
import com.tournity.Repository.Listeners.ModelListener;

import java.util.ArrayList;

public class MatchCompetitorController {
    private Context context;
    private MatchCompetitorModel matchCompetitorModel;

    public MatchCompetitorController(Context context) {
        this.context = context;
        this.matchCompetitorModel=new MatchCompetitorModel(context);
    }



    public void getResult(int idMatch){
        final ModelListener<ArrayList<MatchCompetitorModel>> competitors=new ModelListener<ArrayList<MatchCompetitorModel>>() {
            @Override
            public void onSuccess(ArrayList<MatchCompetitorModel> model) {
                if(context instanceof MatchViewActivity){
                    MatchViewActivity activity=(MatchViewActivity)context;

                    activity.txtresultTeamA.setText(model.get(0).getMatchCompetitorEntity().getPoints()+"");
                    activity.txtresultTeamB.setText(model.get(1).getMatchCompetitorEntity().getPoints()+"");
                }else if(context instanceof EditResultActivity){
                    EditResultActivity activity=(EditResultActivity)context;
                    activity.getTxtpointsTeamA().setText(model.get(0).getMatchCompetitorEntity().getPoints()+"");
                    activity.getTxtpointsTeamB().setText(model.get(1).getMatchCompetitorEntity().getPoints()+"");
                }

            }

            @Override
            public void onError(ModelError error) {
                Toast.makeText(context, "Result not found", Toast.LENGTH_SHORT).show();
            }
        };
        MatchCompetitorModel.getAllByMatchId(idMatch,context,competitors);
    }
}
