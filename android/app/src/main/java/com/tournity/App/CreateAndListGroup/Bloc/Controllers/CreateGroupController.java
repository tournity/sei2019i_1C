package com.tournity.App.CreateAndListGroup.Bloc.Controllers;

import android.content.Context;
import android.widget.Toast;

import com.tournity.App.CreateAndListGroup.Repository.Models.CreateGroupModel;
import com.tournity.Repository.Enums.ModelError;
import com.tournity.Repository.Listeners.ModelListener;

public class CreateGroupController {
    Context context;

    public CreateGroupController(Context context) {
        this.context = context;
    }
    public void create(String name){
        if (validateNameLength(name)){
            ModelListener crGrListener = new ModelListener() {
                @Override
                public void onSuccess(Object model) {
                    Toast.makeText(context, "OK", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onError(ModelError error) {
                    Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
                }
            };
            CreateGroupModel.assemble(context,name,crGrListener);
        }else{
            Toast.makeText(context, "Invalid name", Toast.LENGTH_SHORT).show();
        }
    }
    public boolean validateNameLength(String name){
        return name.length() >=3;
    }
}
