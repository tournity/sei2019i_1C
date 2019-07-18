package com.tournity.App.Authentication.View.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.tournity.App.Authentication.Bloc.Controllers.AuthenticationController;
import com.tournity.App.Match.View.Activities.SelectTypeMatchActivity;
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
        controller.login(email.getText().toString(), pass.getText().toString());
    }

    public void onSignUp(View v){
        Intent intent = new Intent(this, SelectTypeMatchActivity.class);
        startActivity(intent);
    }
}
