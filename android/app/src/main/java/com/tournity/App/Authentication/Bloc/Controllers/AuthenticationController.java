package com.tournity.App.Authentication.Bloc.Controllers;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import com.tournity.App.Authentication.Repository.Models.AuthenticationModel;
import com.tournity.Bloc.Listeners.ControllerListener;
import com.tournity.Repository.Enums.ModelError;
import com.tournity.Repository.Listeners.ModelListener;

public class AuthenticationController {
    Context ctx;
    public AuthenticationController(Context ctx){
        this.ctx = ctx;
    };

    public void login(String email, String password){
        if(validateEmail(email) && validatePassword(password)){
            ModelListener authListener = new ModelListener<AuthenticationModel>() {
                @Override
                public void onSuccess(AuthenticationModel model) {
                    Toast.makeText(ctx, "Login", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onError(ModelError error) {
                    Toast.makeText(ctx, "Unuario no encontrado", Toast.LENGTH_SHORT).show();
                }
            };
            AuthenticationModel.authorize(ctx, email, password, authListener);
        }else{
            Toast.makeText(ctx, "Datos inválidos", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean validateEmail(String email){
        return email.contains("@");
    }

    public boolean validatePassword(String password){
        return password.length() >= 2;
    }
}
