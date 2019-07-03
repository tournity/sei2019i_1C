package com.tournity.Repository.Models;

import android.content.Context;

import com.tournity.Repository.Repositories.TournamentRepository;
import com.tournity.Entities.TournamentEntity;

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

    public ArrayList<TournamentModel>getAll(){
        ArrayList<TournamentModel>result=new ArrayList<>();
        for(TournamentEntity tournament:this.tournamentRepository.getAll()){
            result.add(new TournamentModel(tournament));
        }
       return result;

    }
    public  ArrayList<TournamentModel>getAllBySportId(int idSport){
        ArrayList<TournamentModel>result=new ArrayList<>();
        for(TournamentEntity tournament:this.tournamentRepository.SelectAllBySportId(idSport)){
            result.add(new TournamentModel(tournament));
        }
    return result;
    }

    public ArrayList<TournamentModel>getAllByDate(Date date){
           ArrayList<TournamentModel>result=new ArrayList<>();
        for(TournamentEntity tournament:this.tournamentRepository.SelectAllByInitDate(date)){
            result.add(new TournamentModel(tournament));
        }
        return result;
    }

    public ArrayList<TournamentModel>getAllByOwner (String Owner) {
        ArrayList<TournamentModel>result=new ArrayList<>();
        for(TournamentEntity tournament:this.tournamentRepository.SelectAllByOwner(Owner)){
            result.add(new TournamentModel(tournament));

        }
        return result;
    }


}
