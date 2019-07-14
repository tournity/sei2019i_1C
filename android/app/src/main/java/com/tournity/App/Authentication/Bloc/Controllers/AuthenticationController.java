package com.tournity.App.Authentication.Bloc.Controllers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.tournity.App.Authentication.Repository.Models.AuthenticationModel;
import com.tournity.App.Authentication.View.Activities.LoginActivity;
import com.tournity.App.Groups.View.Activities.ListGroupActivity;
import com.tournity.App.Groups.View.Activities.PlayerOrTeamActivity;
import com.tournity.Bloc.Listeners.ControllerListener;
import com.tournity.Bloc.Listeners.SessionListener;
import com.tournity.Bloc.Services.SessionService;
import com.tournity.Repository.Enums.ModelError;
import com.tournity.Repository.Listeners.ModelListener;

public class AuthenticationController {
    Context ctx;

    public AuthenticationController(final Context ctx) {
        this.ctx = ctx;
        SessionListener sessionListener = new SessionListener() {
            @Override
            public void onSessionChanged(boolean data) {
                if (data) {
                    Intent intent = new Intent(ctx, PlayerOrTeamActivity.class);
                    ctx.startActivity(intent);
                } else {
                    try {
                        LoginActivity login = (LoginActivity) ctx;
                    } catch (Exception e) {
                        Intent intent = new Intent(ctx, LoginActivity.class);
                        ctx.startActivity(intent);
                    }
                }
            }
        };

        SessionService.setOnChangeSesionState(sessionListener);

        SharedPreferences preferences =
                ctx.getSharedPreferences(SessionService.SESSION_PREFERENCES, Context.MODE_PRIVATE);
        String token = preferences.getString("token", null);
        System.out.println(token);
        if (token != null) {
            SessionService.setTokenAndAuthorize(ctx, token);
        }
    }

    ;

    public void login(String email, String password) {
        if (validateEmail(email) && validatePassword(password)) {
            ModelListener authListener = new ModelListener<AuthenticationModel>() {
                @Override
                public void onSuccess(AuthenticationModel model) {
                    Toast.makeText(ctx, "Login", Toast.LENGTH_SHORT).show();
                    SharedPreferences preferences =
                            ctx.getSharedPreferences(SessionService.SESSION_PREFERENCES, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("token", model.getToken());
                    editor.commit();
                    SessionService.setSession(model.getToken(), model.getCurrentUser());
                }

                @Override
                public void onError(ModelError error) {
                    Toast.makeText(ctx, "Usuario no encontrado", Toast.LENGTH_SHORT).show();
                }
            };
            AuthenticationModel.authorize(ctx, email, password, authListener);
        } else {
            Toast.makeText(ctx, "Datos inválidos", Toast.LENGTH_SHORT).show();
        }
    }

    public static boolean validateEmail(String email) {
        return email.contains("@");
    }

    public static boolean validatePassword(String password) {
        return password.length() >= 2;
    }
}
