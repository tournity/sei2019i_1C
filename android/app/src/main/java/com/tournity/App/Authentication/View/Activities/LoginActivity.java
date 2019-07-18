package com.tournity.App.Authentication.View.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.tournity.App.Authentication.Bloc.Controllers.AuthenticationController;
import com.tournity.App.Match.View.Activities.SelectTypeMatchActivity;
import com.tournity.App.User.View.Activities.RegisterActivity;
import com.tournity.R;
import com.tournity.View.Activities.HomeActivity;

public class LoginActivity extends AppCompatActivity {
    AuthenticationController controller;
    EditText email;
    EditText pass;
    Button btnLogin;
    Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = (EditText) findViewById(R.id.email);
        pass = (EditText) findViewById(R.id.password);
        btnLogin=findViewById(R.id.btnLogin);
        btnSignUp=findViewById(R.id.btnSignUp);
        controller = new AuthenticationController(this);
       /* btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            onLogin(view);
            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSignUp(view);
            }
        });*/
    }

    public void onLogin(View v) {
        controller.login(email.getText().toString(), pass.getText().toString());
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    public void onSignUp(View v) {
        Intent intent = new Intent(this, SelectTypeMatchActivity.class);
        startActivity(intent);
    }
}
