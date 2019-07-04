package com.tournity.App.Users.View.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.tournity.App.Authentication.View.Activities.LoginActivity;
import com.tournity.R;

public class SignUpActivity extends AppCompatActivity {

    private String password;
    private String name;
    private String email;
    private Button signUpButton;
    private Button logInButton;
    private EditText editText1;
    private EditText editText2;
    private EditText editText3;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        editText1 = (EditText) findViewById(R.id.email);
        editText2 = (EditText) findViewById(R.id.password);
        editText3 = (EditText) findViewById(R.id.username);
        signUpButton = (Button) findViewById(R.id.registerButton);
        logInButton = (Button) findViewById(R.id.loginButton);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSignUpClick();
            }
        });
        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onLoginClick();
            }
        });
    }

    private void onSignUpClick(){
        email = editText1.getText().toString();
        name = editText3.getText().toString();
        password = editText2.getText().toString();
    }
    private void onLoginClick(){
        Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}
