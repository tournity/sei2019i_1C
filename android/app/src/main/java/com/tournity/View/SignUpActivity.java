package com.tournity.View;

import android.os.Bundle;
import android.view.View;
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
        editText1 = (EditText) findViewById(R.id.email);
        editText2 = (EditText) findViewById(R.id.password);
        editText3 = (EditText) findViewById(R.id.username);
        signUpButton = (Button) findViewById(R.id.button);
        logInButton = (Button) findViewById(R.id.login);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSignUpClick();
            }
        });
    }

    private void onSignUpClick(){
        email = editText1.getText().toString();
        name = editText3.getText().toString();
        password = editText2.getText().toString();
    }
    
}
