package com.tournity.DataAccess.Repositories;

import android.content.Context;

import com.tournity.Entities.TournamentEntity;

import java.util.ArrayList;

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


}
