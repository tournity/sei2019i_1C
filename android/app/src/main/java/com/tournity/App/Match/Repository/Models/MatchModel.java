package com.tournity.App.Match.Repository.Models;

import android.content.Context;

import com.tournity.App.Match.Entities.MatchEntity;
import com.tournity.App.Match.Repository.Repositories.MatchRepository;
import com.tournity.App.Tournament.Entities.TournamentEntity;
import com.tournity.App.Tournament.Repository.Models.TournamentModel;
import com.tournity.App.Tournament.Repository.Repositories.TournamentRepository;
import com.tournity.Repository.Enums.ModelError;
import com.tournity.Repository.Enums.RepositoryError;
import com.tournity.Repository.Listeners.ModelListener;
import com.tournity.Repository.Listeners.RepositoryListener;

import java.util.ArrayList;

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




    public static void getByIdTournament(int idTournament, Context context, final ModelListener<ArrayList<MatchModel>>listener){
        RepositoryListener<ArrayList<MatchEntity>> match=new RepositoryListener<ArrayList<MatchEntity>>() {
            @Override
            public void onQueryCompleted(ArrayList<MatchEntity> entities) {
         ArrayList<MatchModel> array=new ArrayList<>();
                for(MatchEntity t:entities){
             array.add(new MatchModel(t));
         }

                listener.onSuccess(array);
            }

            @Override
            public void onQueryFailed(RepositoryError error) {
                listener.onError(ModelError.DATA_CONVERSION_FAILED);
            }
        };
        MatchRepository.SelectByIdTournament(idTournament,context,match);
    }
    public static void Update(MatchEntity entity, Context context, final ModelListener<MatchModel> listener) {
        RepositoryListener<MatchEntity> created = new RepositoryListener<MatchEntity>() {
            @Override
            public void onQueryCompleted(MatchEntity entity) {
                listener.onSuccess(new MatchModel(entity));
            }

            @Override
            public void onQueryFailed(RepositoryError error) {
                listener.onError(ModelError.DATA_CONVERSION_FAILED);
            }
        };
        MatchRepository.Update(new MatchModel(entity), context, created);
    }
}
