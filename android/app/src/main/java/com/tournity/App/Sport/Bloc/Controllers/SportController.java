package com.tournity.App.Sport.Bloc.Controllers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.tournity.App.Sport.Repository.Models.SportModel;
import com.tournity.R;
import com.tournity.Repository.Enums.ModelError;
import com.tournity.Repository.Listeners.ModelListener;
import com.tournity.View.Activities.HomeActivity;
import com.tournity.View.Fragments.SportFragment;

import java.util.ArrayList;

public class SportController {
    protected Context context;

    public SportController(Context context) {
        this.context = context;
    }

    public void listSports() {
        ModelListener sportListener = new ModelListener<ArrayList<SportModel>>() {
            @Override
            public void onSuccess(ArrayList<SportModel> models) {
                HomeActivity activity = (HomeActivity) context;
                ArrayList<String> listSports = new ArrayList<>();
                for (SportModel model : models) {
                    listSports.add(model.getName());
                }
                ArrayAdapter adapter = new ArrayAdapter(activity, android.R.layout.simple_list_item_1, listSports);
                activity.getSportFragment().getSportList().setAdapter(adapter);
            }

            @Override
            public void onError(ModelError error) {
                Toast.makeText(context, "Error al importar deportes", Toast.LENGTH_SHORT).show();

            }
        };
        SportModel.listGroups(context,sportListener);
    }
}
