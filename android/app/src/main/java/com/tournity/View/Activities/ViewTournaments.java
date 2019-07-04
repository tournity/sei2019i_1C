package com.tournity.View.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import com.tournity.Bloc.Controllers.SportController;
import com.tournity.Bloc.Controllers.TournamentController;
import com.tournity.R;
import com.tournity.Repository.Models.SportModel;
import com.tournity.Repository.Models.TournamentModel;

import java.util.ArrayList;

public class ViewTournaments extends AppCompatActivity {
private EditText txtOwner;
private Button btnSearch;
private Spinner Filter;
private Spinner FilterValue;
private String datos[];
private ArrayAdapter<CharSequence>adapter;
private Context context;
private ListView list;
private TournamentController controller;
private ArrayList<SportModel>sports;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.context=this;
        this.controller=new TournamentController(context);
        setContentView(R.layout.activity_view_tournaments);
        this.datos=new String[]{"Owner","Sport","Date"};
        this.list=findViewById(R.id.ListTournaments);
         txtOwner=findViewById(R.id.txtOwner);
         Filter=(Spinner) findViewById(R.id.SpinnerTypeFilter);
         FilterValue=(Spinner) findViewById(R.id.SpinnerFilterValue);
         btnSearch=(Button)findViewById(R.id.btnSearch);
         ArrayList<String>Filters=new ArrayList<String>();
         Filters.add("Sport");
         Filters.add("Owner");
         Filters.add("Date");

this.adapter=new ArrayAdapter(this,android.R.layout.simple_spinner_item,Filters);
this.Filter.setAdapter(this.adapter);
this.Filter.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


        if(i==0){

            sports= SportController.getAll();
            ArrayList<String>sportsnames=new ArrayList<>();
            for(SportModel sport:sports){
                sportsnames.add(sport.getSportEntity().getName());
            }
            ArrayAdapter<CharSequence>adap=new ArrayAdapter(context,android.R.layout.simple_spinner_item,sportsnames);
      }else if(i==2){
            
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
});


}

   public void Search(View view){
    ArrayList<TournamentModel>result;
    if(this.Filter.getSelectedItem().toString().equals("Sport")){

    }else if(this.Filter.getSelectedItem().toString().equals("Owner")){

    }else if(this.Filter.getSelectedItem().toString().equals("Date")){
   }


}
}