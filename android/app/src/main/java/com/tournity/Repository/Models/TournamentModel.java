package com.tournity.Repository.Models;

import com.tournity.Entities.TournamentEntity;

import com.tournity.Repository.Repositories.TournamentRepository;
public class TournamentModel {
    public void CreateTournament(int id, int owner, int group, String name, int InitDate, int FinishDate) {
        TournamentEntity TE = new TournamentEntity(id, owner, group, name, InitDate, FinishDate);

        TournamentRepository TR = null;

        TR.Insert(null, TE);



    }
}
