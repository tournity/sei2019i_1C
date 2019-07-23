package com.tournity.App.Authentication.View.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.tournity.App.Authentication.Bloc.Controllers.AuthenticationController;
import com.tournity.App.Match.View.Activities.SelectTypeMatchActivity;
import com.tournity.App.User.View.Activities.RegisterActivity;
import com.tournity.R;
import com.tournity.View.Activities.HomeActivity;

public class LoginActivity extends AppCompatActivity {
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
        btnLogin = findViewById(R.id.btnLogin);
        btnSignUp = findViewById(R.id.btnSignUp);
        FirebaseAuth.getInstance().
                addAuthStateListener(new FirebaseAuth.AuthStateListener() {
                    @Override
                    public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                        if (firebaseAuth != null && firebaseAuth.getCurrentUser() != null) {
                            Log.d("EMAIL", firebaseAuth.getCurrentUser().getEmail());
                            goToHome();
                        }
                    }
                });

    }

    public void onLogin(View v) {
        boolean valid = true;
        if (email.getText() == null || pass.getText() == null) valid = false;
        if (email.getText().toString().trim().length() < 5 || pass.getText().toString().length() < 5)
            valid = false;
        if (!valid) {
            Toast.makeText(this, "Incorrect data", Toast.LENGTH_SHORT).show();
            return;
        }


        FirebaseAuth.getInstance().signInWithEmailAndPassword(email.getText().toString(), pass.getText().toString()).
                addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            goToHome();
                        } else {
                            Toast.makeText(LoginActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void goToHome() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    public void onSignUp(View v) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}
