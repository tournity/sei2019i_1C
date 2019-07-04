package com.tournity.Bloc.Controllers;

import android.content.Context;

import com.tournity.Repository.Models.SportModel;

import java.util.ArrayList;

public class SportController {
    private Context context;
    private static SportModel sportModel;

    public SportController(Context context) {
        this.context = context;
        sportModel=new SportModel(context);
    }
    public SportController() {

        sportModel=new SportModel();
    }
    public static ArrayList<SportModel>getAll(){
        ArrayList<SportModel>result=sportModel.getAll();
    return result;
    }
}
