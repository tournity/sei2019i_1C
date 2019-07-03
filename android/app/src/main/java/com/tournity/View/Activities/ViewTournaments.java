package com.tournity.View.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.tournity.R;

public class ViewTournaments extends AppCompatActivity {
private EditText txtOwner;
private Button btnSearch;
private Spinner Filter;
private Spinner FilterValue;
private String datos[];
private ArrayAdapter<String>adapter;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_tournaments);
    this.datos=new String[]{"Owner","Sport","Date"};

         txtOwner=findViewById(R.id.txtOwner);
         Filter=(Spinner) findViewById(R.id.SpinnerTypeFilter);
         FilterValue=(Spinner) findViewById(R.id.SpinnerFilterValue);
         btnSearch=(Button)findViewById(R.id.btnSearch);
         addFilter(this);




}
    public void addFilter(Context context){
    this.adapter=new ArrayAdapter<String>(context,android.R.layout.simple_spinner_item,this.datos);
        this.Filter.setAdapter(this.adapter);
    }
   


}
