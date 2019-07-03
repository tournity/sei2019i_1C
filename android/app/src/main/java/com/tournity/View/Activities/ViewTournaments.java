package com.tournity.View.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.tournity.R;

public class ViewTournaments extends AppCompatActivity {
private EditText txtOwner;
private Button btnSearch;
private Spinner Filter;
private Spinner FilterValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_tournaments);


         txtOwner=findViewById(R.id.txtOwner);
         Filter=(Spinner) findViewById(R.id.SpinnerTypeFilter);
         FilterValue=(Spinner) findViewById(R.id.SpinnerFilterValue);
         btnSearch=(Button)findViewById(R.id.btnSearch);
         
    }
}
