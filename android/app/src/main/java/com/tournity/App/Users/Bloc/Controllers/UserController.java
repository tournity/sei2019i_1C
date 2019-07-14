package com.tournity.App.Users.Bloc.Controllers;

import android.content.Context;
import android.widget.Toast;

import com.tournity.App.Authentication.Entities.AccountEntity;
import com.tournity.App.Users.Entities.UserEntity;
import com.tournity.App.Users.Repository.Models.UserModel;
import com.tournity.Repository.Enums.ModelError;
import com.tournity.Repository.Listeners.ModelListener;

public class UserController {
    private Context context;
    private UserModel model;

    public UserController(Context context) {
        this.context = context;
        this.model = new UserModel();
    }


    public void Register(String username, String email, String Password, String PasswordConfirm) {
        if (Password.equals(PasswordConfirm)) {
            ModelListener registeredlistener = new ModelListener() {
                @Override
                public void onSuccess(Object model) {
                    Toast.makeText(context, "Sucessful Register", Toast.LENGTH_SHORT).show();

                }

                @Override
                public void onError(ModelError error) {
                    Toast.makeText(context, "Los datos no pueden ser usados pues ya existen", Toast.LENGTH_SHORT).show();
                }
            };
            UserEntity user=new UserEntity();
            AccountEntity account=new AccountEntity();
            account.setName(username);
            account.setEmail(email);
            account.setEncryptedPassword(Password);
            this.model.Register( account,context, registeredlistener);

        } else {
            Toast.makeText(context, "Las Contraseñas no coinciden", Toast.LENGTH_SHORT).show();
        }


    }
}
