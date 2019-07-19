package com.tournity.App.Tournament.Repository.Models;

import android.content.Context;

import com.tournity.App.Tournament.Entities.TournamentEntity;
import com.tournity.Repository.Enums.ModelError;
import com.tournity.Repository.Enums.RepositoryError;
import com.tournity.Repository.Listeners.ModelListener;
import com.tournity.Repository.Listeners.RepositoryListener;
import com.tournity.App.Tournament.Repository.Repositories.TournamentRepository;

import java.util.ArrayList;
import java.util.Date;

public class TournamentModel {
    private Context context;
    private TournamentEntity tournamentEntity;
    private TournamentRepository tournamentRepository;
    public TournamentModel(Context context) {
        this.context = context;
        this.tournamentRepository=new TournamentRepository(context);
    }



    public TournamentModel() {
        this.tournamentRepository=new TournamentRepository();
    }

    public TournamentModel(TournamentEntity tournamentEntity) {
        this.tournamentEntity = tournamentEntity;
        this.tournamentRepository=new TournamentRepository();
    }

    public TournamentEntity getTournamentEntity() {
        return tournamentEntity;
    }

    public void setTournamentEntity(TournamentEntity tournamentEntity) {
        this.tournamentEntity = tournamentEntity;
    }
public static void Create (TournamentEntity tournament, Context context, final ModelListener<TournamentModel>listener){
       RepositoryListener<TournamentEntity> registered=new RepositoryListener<TournamentEntity>() {
           @Override
           public void onQueryCompleted(TournamentEntity entity) {
         listener.onSuccess(new TournamentModel(entity));
           }

           @Override
           public void onQueryFailed(RepositoryError error) {
               listener.onError(ModelError.DATA_CONVERSION_FAILED);
           }
       };


       TournamentRepository.Insert(tournament,context,registered);
}
    public static void getAll(Context context, final ModelListener <ArrayList<TournamentModel>> listener){
        RepositoryListener<ArrayList<TournamentEntity>>tournaments=new RepositoryListener<ArrayList<TournamentEntity>>() {
            @Override
            public void onQueryCompleted(ArrayList<TournamentEntity> entity) {
                ArrayList<TournamentModel>arr=new ArrayList<>();
                for(TournamentEntity t:entity){
                    arr.add(new TournamentModel(t));
                }
                listener.onSuccess(arr);
            }

            @Override
            public void onQueryFailed(RepositoryError error) {
                listener.onError(ModelError.DATA_CONVERSION_FAILED);
            }
        };
        TournamentRepository.selectAll(context,tournaments);

    }
    public  static void getAllBySportId(int idSport, Context context, final ModelListener<ArrayList<TournamentModel>>listener){
        RepositoryListener<ArrayList<TournamentEntity>>tournaments=new RepositoryListener<ArrayList<TournamentEntity>>() {
            @Override
            public void onQueryCompleted(ArrayList<TournamentEntity> entity) {
              ArrayList<TournamentModel>arr=new ArrayList<>();
              for(TournamentEntity t:entity){
                  arr.add(new TournamentModel(t));
              }
                listener.onSuccess(arr);
            }

            @Override
            public void onQueryFailed(RepositoryError error) {
                listener.onError(ModelError.DATA_CONVERSION_FAILED);
            }
        };
        TournamentRepository.SelectAllBySportId(idSport,context,tournaments);
    }

    public  static void getAllByDate(String InitDate, Context context, final ModelListener<ArrayList<TournamentModel>>listener){
        RepositoryListener<ArrayList<TournamentEntity>>tournaments=new RepositoryListener<ArrayList<TournamentEntity>>() {
            @Override
            public void onQueryCompleted(ArrayList<TournamentEntity> entity) {
                ArrayList<TournamentModel>arr=new ArrayList<>();
                for(TournamentEntity t:entity){
                    arr.add(new TournamentModel(t));
                }
                listener.onSuccess(arr);
            }

            @Override
            public void onQueryFailed(RepositoryError error) {

            }
        };

        TournamentRepository.SelectAllByDate(new Date(InitDate),context,tournaments);
    }


    public  static void getAllByOwner(int idOwner, Context context, final ModelListener<ArrayList<TournamentModel>>listener){
        RepositoryListener<ArrayList<TournamentEntity>>tournaments=new RepositoryListener<ArrayList<TournamentEntity>>() {
            @Override
            public void onQueryCompleted(ArrayList<TournamentEntity> entity) {
                ArrayList<TournamentModel>arr=new ArrayList<>();
                for(TournamentEntity t:entity){
                    arr.add(new TournamentModel(t));
                }
                listener.onSuccess(arr);
            }

            @Override
            public void onQueryFailed(RepositoryError error) {
                listener.onError(ModelError.DATA_CONVERSION_FAILED);
            }
        };
        TournamentRepository.SelectAllByOwner(idOwner,context,tournaments);
    }


}
