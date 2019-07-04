package com.tournity.Repository.Repositories;

import android.content.Context;

import com.tournity.Entities.SportEntity;

import java.util.ArrayList;

public class SportRepository {
    private Context context;

    public SportRepository(Context context) {
        this.context = context;
    }

    public SportRepository() {
    }
public ArrayList<SportEntity>selectAll(){

        ArrayList<SportEntity>result=new ArrayList<>();
        


        return result;

}
}
