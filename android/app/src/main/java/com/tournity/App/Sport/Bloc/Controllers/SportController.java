package com.tournity.App.Sport.Bloc.Controllers;

import android.content.Context;

import com.tournity.App.Sport.Repository.Models.SportModel;
import com.tournity.Repository.Enums.ModelError;
import com.tournity.Repository.Listeners.ModelListener;
import com.tournity.View.Fragments.SportFragment;

import java.util.ArrayList;

public class SportController {
    protected SportFragment context;

    public SportController(SportFragment context){
        this.context = context;
    }

    public void listSports(){
        ModelListener sportListener = new ModelListener<ArrayList<SportModel>>() {
            @Override
            public void onSuccess(ArrayList<SportModel> models) {
                ArrayList<String> listSports = new ArrayList<>();
                for (SportModel model:models){
                    listSports.add(model.getName());
                }
            }

            @Override
            public void onError(ModelError error) {

            }
        };
    }
}
