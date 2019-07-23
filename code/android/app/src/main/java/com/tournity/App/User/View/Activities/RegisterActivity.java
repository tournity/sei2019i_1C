package com.tournity.App.User.View.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.tournity.App.Authentication.View.Activities.LoginActivity;
import com.tournity.App.User.Bloc.Controllers.UserController;
import com.tournity.R;
import com.tournity.View.Activities.HomeActivity;
import com.tournity.View.Fragments.SportM;

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
        txtUsername = (EditText) findViewById(R.id.txtUsername);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        txtPasswordConfirm = (EditText) findViewById(R.id.txtPasswordConfirm);
        controller = new UserController(this);
    }


    public void Register(View v) {
        boolean valid = true;
        if (txtEmail.getText() == null || txtPassword.getText() == null ||
                txtUsername.getText() == null || txtPasswordConfirm.getText() == null)
            valid = false;
        if (txtEmail.getText().toString().trim().length() < 5 ||
                txtUsername.getText().toString().trim().length() < 5 ||
                txtPassword.getText().toString().length() < 5) valid = false;
        if(! txtPassword.getText().toString().equals(txtPasswordConfirm.getText().toString())) valid = false;

        if (!valid) {
            Toast.makeText(this, "Incorrect data", Toast.LENGTH_SHORT).show();
            return;
        }
        FirebaseAuth.getInstance().
                createUserWithEmailAndPassword(txtUsername.getText().toString(), txtPassword.getText().toString()).
                addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            task.getResult().getUser();
                            String id = task.getResult().getUser().getUid();
                            FirebaseDatabase database = FirebaseDatabase.getInstance();
                            DatabaseReference myRef = database.getReference("users/" + id);
                            SportM pepe = new SportM();
                            pepe.id = id;
                            pepe.name = txtUsername.getText().toString();
                            myRef.setValue(pepe);
                            goToHome();
                        } else {
                            Toast.makeText(RegisterActivity.this,
                                    "Authentication failed.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }

    public void onLogin(View v) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    private void goToHome() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}
