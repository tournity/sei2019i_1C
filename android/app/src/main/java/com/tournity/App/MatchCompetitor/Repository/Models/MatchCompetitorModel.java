package com.tournity.App.MatchCompetitor.Repository.Models;

import android.content.Context;

import com.tournity.App.MatchCompetitor.Entities.MatchCompetitorEntity;
import com.tournity.App.MatchCompetitor.Repository.Repositories.MatchCompetitorRepository;
import com.tournity.Repository.Enums.ModelError;
import com.tournity.Repository.Enums.RepositoryError;
import com.tournity.Repository.Listeners.ModelListener;
import com.tournity.Repository.Listeners.RepositoryListener;

import java.util.ArrayList;

public class MatchCompetitorModel {
    private Context context;
    private MatchCompetitorEntity matchCompetitorEntity;
    private MatchCompetitorRepository matchCompetitorRepository;

    public MatchCompetitorModel(Context context) {
        this.context = context;
        this.matchCompetitorRepository=new MatchCompetitorRepository();
    }

    public MatchCompetitorModel(MatchCompetitorEntity matchCompetitorEntity) {
        this.matchCompetitorEntity = matchCompetitorEntity;
        this.matchCompetitorRepository=new MatchCompetitorRepository();
    }

   public static void getAllByMatchId(int IdMatch, Context context, final ModelListener<ArrayList<MatchCompetitorModel>>listener){
       RepositoryListener<ArrayList<MatchCompetitorEntity>>competitors=new RepositoryListener<ArrayList<MatchCompetitorEntity>>() {
           @Override
           public void onQueryCompleted(ArrayList<MatchCompetitorEntity> entity) {
               ArrayList<MatchCompetitorModel>models=new ArrayList<>();
               for(MatchCompetitorEntity m:entity){
                   models.add(new MatchCompetitorModel(m));
               }
               listener.onSuccess(models);
           }

           @Override
           public void onQueryFailed(RepositoryError error) {
               listener.onError(ModelError.DATA_CONVERSION_FAILED);
           }
       };
       MatchCompetitorRepository.SelectAllByMatchId(IdMatch,context,competitors);
   }

    public MatchCompetitorEntity getMatchCompetitorEntity() {
        return matchCompetitorEntity;
    }


}
