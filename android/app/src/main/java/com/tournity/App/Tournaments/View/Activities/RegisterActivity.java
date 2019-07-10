package com.tournity.App.Tournaments.View.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.tournity.App.Users.Bloc.Controllers.UserController;
import com.tournity.Bloc.Enums.ControllerError;
import com.tournity.Bloc.Listeners.ControllerListener;
import com.tournity.R;

public class RegisterActivity extends AppCompatActivity {
EditText txtUsername;
EditText txtEmail;
EditText txtPassword;
EditText txtPasswordConfirm;
UserController controller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        txtUsername=(EditText)findViewById(R.id.txtUsername);
        txtEmail=(EditText)findViewById(R.id.txtEmail);
        txtPassword=(EditText)findViewById(R.id.txtPassword);
        txtPasswordConfirm=(EditText)findViewById(R.id.txtPasswordConfirm);
   controller=new UserController(this);
    }
    public void Register(View v){
        ControllerListener listener=new ControllerListener() {
            @Override
            public void Then() {

            }

            @Override
            public void Catch(ControllerError error) {

            }
        };
        controller.Register(txtUsername.getText().toString(),txtEmail.getText().toString(),txtPassword.getText().toString(),txtPasswordConfirm.getText().toString(),listener);

    }
}
