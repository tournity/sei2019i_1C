package com.tournity.Bloc.Controllers;

import android.content.Context;
import android.widget.Toast;

import com.tournity.Bloc.Listeners.ControllerListener;
import com.tournity.Repository.Enums.ModelError;
import com.tournity.Repository.Listeners.ModelListener;
import com.tournity.Repository.Models.UserModel;

public class UserController {
    private Context context;
    private UserModel model;
    public UserController(Context context) {
        this.context = context;
        this.model=new UserModel();
    }


    public  void Register(String Username,String email,String Password,String PasswordConfirm,final ControllerListener listener){
     if(Password.equals(PasswordConfirm)){

     }else{
         Toast.makeText(context, "Las Contraseñas no coinciden", Toast.LENGTH_SHORT).show();
    }
    public void Exist(String Username, String email){

        ModelListener <UserModel>modelListener=new ModelListener<UserModel>() {
            @Override
            public void onSuccess(UserModel model) {

            }

            @Override
            public void onError(ModelError error) {

            }

        };


    }
}
