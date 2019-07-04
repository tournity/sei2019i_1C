package com.tournity.Repository.Models;

import android.content.Context;

import com.tournity.Entities.SportEntity;
import com.tournity.Repository.Repositories.SportRepository;

import java.util.ArrayList;

public class SportModel {
    private Context context;
    private SportEntity sportEntity;
    private SportRepository sportRepository;
    public SportModel(Context context) {
        this.context = context;
        this.sportRepository=new SportRepository();
    }

    public SportModel() {
        this.sportRepository=new SportRepository();
    }

    public SportModel(SportEntity sportEntity) {
        this.sportEntity = sportEntity;
        this.sportRepository=new SportRepository();
    }

    public SportEntity getSportEntity() {
        return sportEntity;
    }

    public void SportEntity(SportEntity sportEntity) {
        this.sportEntity = sportEntity;
    }


    public ArrayList<SportModel>getAll(){
        ArrayList<SportModel>result=new ArrayList<>();
        for(SportEntity sport:this.sportRepository.selectAll()){
            result.add(new SportModel(sport));
        }
        return result;
    }
}
