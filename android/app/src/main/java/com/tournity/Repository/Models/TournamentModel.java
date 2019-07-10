package com.tournity.Repository.Models;

import android.content.Context;

import com.tournity.Entities.TournamentEntity;
import com.tournity.Repository.Enums.RepositoryError;
import com.tournity.Repository.Listeners.ModelListener;
import com.tournity.Repository.Listeners.RepositoryListener;
import com.tournity.Repository.Repositories.TournamentRepository;

import java.util.ArrayList;
import java.util.Date;

public class TournamentModel {
    private Context context;
    private TournamentEntity tournamentEntity;
    private TournamentRepository tournamentRepository;
    public TournamentModel(Context context) {
        this.context = context;
        this.tournamentRepository=new TournamentRepository();
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
public static void Create (String name, String description, String st_date, String end_date, int iduser_sport_group, Context context, final ModelListener<TournamentModel>listener){
       RepositoryListener<TournamentEntity> registered=new RepositoryListener<TournamentEntity>() {
           @Override
           public void onQueryCompleted(TournamentEntity entity) {
         listener.onSuccess(new TournamentModel(entity));
           }

           @Override
           public void onQueryFailed(RepositoryError error) {

           }
       };
       TournamentEntity tournament=new TournamentEntity();
       tournament.setName(name);
       tournament.setDescription(description);
       tournament.setStartDate(new Date(st_date));
       tournament.setEndDate(new Date(end_date));
       tournament.setUserSportGroup(iduser_sport_group);

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

        TournamentRepository.SelectAllByDate(new Date(InitDate)),context,tournaments);
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

            }
        };
        TournamentRepository.SelectAllByOwner(idOwner,context,tournaments);
    }


}
