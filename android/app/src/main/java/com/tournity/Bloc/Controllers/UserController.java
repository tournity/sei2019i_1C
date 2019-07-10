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
     ModelListener<UserModel>registeredlistener=new ModelListener<UserModel>() {
         @Override
         public void onSuccess(UserModel model) {
    listener.Then();
         }

         @Override
         public void onError(ModelError error) {
             Toast.makeText(context, "Los datos no pueden ser usados pues ya existen", Toast.LENGTH_SHORT).show();
         }
     };
       this.model.Register(Username,email,Password,context,registeredlistener);

     }else{
         Toast.makeText(context, "Las Contraseñas no coinciden", Toast.LENGTH_SHORT).show();
    }



    }
}
