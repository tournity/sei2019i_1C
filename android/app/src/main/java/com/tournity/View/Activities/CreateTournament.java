package com.tournity.View.Activities;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.tournity.Bloc.Enums.ControllerError;
import com.tournity.Bloc.Listeners.ControllerListener;
import com.tournity.R;
import com.tournity.Repository.Repositories.TournamentRepository;

public class CreateTournament extends AppCompatActivity {

    EditText txtTournamentName;
    EditText txtDescription;
    EditText txtDate;
    Button btnCreateTournament;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_tournament);
        this.context=this;
        txtTournamentName = (EditText) findViewById(R.id.TournamentName);
        txtDescription = (EditText) findViewById(R.id.Description);
        txtDate = (EditText) findViewById(R.id.Date);
        btnCreateTournament=(Button)findViewById(R.id.CreateTournament);

    }
    public void CreateTournament(View v){
        TournamentRepository.


        ControllerListener listener=new ControllerListener() {
            @Override
            public void Then() {
                Toast.makeText(context,"Successful register",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void Catch(ControllerError error) {

            }
        };
    }

}
