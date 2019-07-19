package com.tournity.App.Match.Repository.Models;

import android.content.Context;

import com.tournity.App.Match.Entities.MatchEntity;
import com.tournity.App.Match.Repository.Repositories.MatchRepository;
import com.tournity.Repository.Enums.ModelError;
import com.tournity.Repository.Enums.RepositoryError;
import com.tournity.Repository.Listeners.ModelListener;
import com.tournity.Repository.Listeners.RepositoryListener;

public class MatchModel {
    private Context context;
    private MatchEntity matchEntity;
    private MatchRepository matchRepository;

    public MatchModel(Context context) {
        this.context = context;
        matchRepository=new MatchRepository();
    }

    public MatchEntity getMatchEntity() {
        return matchEntity;

    }

    public MatchModel(MatchEntity matchEntity) {
        this.matchEntity = matchEntity;
        matchRepository=new MatchRepository();
    }

    public void setMatchEntity(MatchEntity matchEntity) {
        this.matchEntity = matchEntity;
    }
    public static void getById(int id, Context context, final ModelListener<MatchModel>listener){
        RepositoryListener<MatchEntity> match=new RepositoryListener<MatchEntity>() {
            @Override
            public void onQueryCompleted(MatchEntity entity) {


                listener.onSuccess(new MatchModel(entity));
            }

            @Override
            public void onQueryFailed(RepositoryError error) {
                listener.onError(ModelError.DATA_CONVERSION_FAILED);
            }
        };
        MatchRepository.SelectById(id,context,match);
    }
}
