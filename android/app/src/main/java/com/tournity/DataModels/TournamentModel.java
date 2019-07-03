package com.tournity.DataModels;

import android.content.Context;

import com.tournity.DataAccess.Repositories.TournamentRepository;
import com.tournity.Entities.TournamentEntity;

import java.util.ArrayList;

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
    public ArrayList<TournamentModel>getAllBySportId(int idSport){
        ArrayList<TournamentModel>result=new ArrayList<>();
        for(TournamentEntity tournament:this.tournamentRepository.SelectAllBySportId(idSport)){
            result.add(new TournamentModel(tournament));
        }
    return result;
    }

}
