package com.tournity.View;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
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
        editText1 = (EditText) findViewById(R.id.username);
        editText2 = (EditText) findViewById(R.id.password);
        editText3 = (EditText) findViewById(R.id.username);
        signUpButton = (Button) findViewById(R.id.button);
        logInButton = (Button) findViewById(R.id.login);
    }

    private void onSignUpClick(){

    }

    public void eventButton(){

    }
}
