package com.tournity.App.Authentication.View.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.tournity.App.Authentication.Bloc.Controllers.AuthenticationController;
import com.tournity.Bloc.Enums.ControllerError;
import com.tournity.Bloc.Listeners.ControllerListener;
import com.tournity.R;

public class LoginActivity extends AppCompatActivity {
    AuthenticationController controller;
    EditText email;
    EditText pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = (EditText)findViewById(R.id.email);
        pass = (EditText)findViewById(R.id.password);
        controller = new AuthenticationController(this);
    }

    public void onLogin(View v){
        ControllerListener listener = new ControllerListener() {
            @Override
            public void Then() {

            }

            @Override
            public void Catch(ControllerError error) {

            }
        };
        controller.login(email.getText().toString(), pass.getText().toString(), listener);
    }

    public void onSignUp(View v){

    }
}
