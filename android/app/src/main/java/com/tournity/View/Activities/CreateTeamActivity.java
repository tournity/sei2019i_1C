package com.tournity.View.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.tournity.R;

public class CreateTeamActivity extends AppCompatActivity {
    TextView textViewTitleGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_team);

        textViewTitleGroup = findViewById(R.id.idTitleCreateTeamGroup);

        /*Obtain group's name*/
        Bundle bundle = this.getIntent().getExtras();
        String name = bundle.getString("name");
        textViewTitleGroup.setText(textViewTitleGroup.getText()+name);

    }

    public void onClick(View view) {
        
    }
}
