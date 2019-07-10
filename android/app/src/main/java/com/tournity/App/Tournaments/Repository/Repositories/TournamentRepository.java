package com.tournity.App.Tournaments.Repository.Repositories;

import android.content.Context;

import com.tournity.App.Tournaments.Entities.TournamentEntity;

import java.util.ArrayList;
import java.util.Date;

public class TournamentRepository {
    private Context context;

    public TournamentRepository(Context context) {
        this.context = context;
    }

    public TournamentRepository() {
    }

    public ArrayList<TournamentEntity> getAll(){

            ArrayList<TournamentEntity>result=null;
        return result;
    }
    public ArrayList<TournamentEntity>SelectAllBySportId(int idSport){
     ArrayList<TournamentEntity>result=new ArrayList<>();




     return result;
    }

public ArrayList<TournamentEntity>SelectAllByInitDate(Date Initdate){
        ArrayList<TournamentEntity>result=new ArrayList<>();


    return result;
    }
    public ArrayList<TournamentEntity>SelectAllByOwner(String owner){
        ArrayList<TournamentEntity>result=new ArrayList<>();


        return result;
    }


}
