package com.tournity.App.Match.View.Activities;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

import com.tournity.R;

public class MatchViewActivity extends AppCompatActivity {
    TextView txtname;
    TextView txtdescription;
    TextView txtstartime;
    TextView txtfinishtime;
    TextView txtcreatedDate;
    TextView txtstatus;
    TextView txtstageGroup;
    TextView txtresultTeamA;
    TextView txtresultTeamB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_view);
        txtname = (TextView) findViewById(R.id.txtmatchName);
        txtdescription = (TextView) findViewById(R.id.txtdescriptionmatch);
        txtstartime = (TextView) findViewById(R.id.txtStartTime);
        txtfinishtime = (TextView) findViewById(R.id.txtFinishTime);
        txtcreatedDate=(TextView)findViewById(R.id.txtCreatedDateMatch);
        txtstatus=(TextView)findViewById(R.id.txtStatusMatch);
        txtstageGroup=(TextView)findViewById(R.id.txtstagegroup);
        txtresultTeamA=(TextView)findViewById(R.id.pointsTeamA);
       txtresultTeamB=(TextView)findViewById(R.id.pointsTeamB);

    }
    public void GotoEditMatch(View v){
        Intent intent=new Intent(this,EditMatchActivity.class);
        startActivity(intent);
    }

}
