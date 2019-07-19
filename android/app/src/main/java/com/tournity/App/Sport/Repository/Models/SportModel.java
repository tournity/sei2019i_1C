package com.tournity.App.Sport.Repository.Models;

import android.content.Context;

import com.tournity.App.Sport.Entities.SportEntity;
import com.tournity.Repository.Enums.ModelError;
import com.tournity.Repository.Enums.RepositoryError;
import com.tournity.Repository.Listeners.ModelListener;
import com.tournity.Repository.Listeners.RepositoryListener;

import java.util.ArrayList;

public class SportModel {
    SportEntity sportEntity;

    public SportModel(SportEntity sportEntity) {
        this.sportEntity = sportEntity;
    }

    public static void listGroups(Context context, final ModelListener<ArrayList<SportModel>> listener){
        RepositoryListener repositoryListener = new RepositoryListener<ArrayList<SportEntity>>() {
            @Override
            public void onQueryCompleted(ArrayList<SportEntity> entities) {
                ArrayList arrayList = new ArrayList<SportModel>();
                for (SportEntity entity : entities) {
                    SportModel sportModel = new SportModel(entity);
                    arrayList.add(sportModel);
                }
                listener.onSuccess(arrayList);

            }

            @Override
            public void onQueryFailed(RepositoryError error) {
                listener.onError(ModelError.DATA_CONVERSION_FAILED);
            }
        };

    }

    public String getName(){
        return sportEntity.getName();
    }
}
