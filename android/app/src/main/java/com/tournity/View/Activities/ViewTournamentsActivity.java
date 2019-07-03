package com.tournity.View.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.tournity.BussinessLogic.Controllers.TournamentController;
import com.tournity.R;

import java.util.ArrayList;

public class ViewTournamentsActivity extends AppCompatActivity {
    Spinner filterSpinner;
    ListView tournamentListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_tournaments);

        filterSpinner = findViewById(R.id.idSpinnerFilters);
        tournamentListView =  findViewById(R.id.idListViewTournaments);

        ArrayAdapter<CharSequence> spinnerAdapter =ArrayAdapter.createFromResource(this,
                R.array.filter_combo,android.R.layout.simple_spinner_item);

        ArrayList<String> tournamentNamesList = new ArrayList<>();
        //Insert names
        //tournamentNamesList = getAllNamesOfTournaments();

        ArrayAdapter<CharSequence> listViewAdapter = new  ArrayAdapter(this,
                android.R.layout.simple_list_item_1,tournamentNamesList);

        filterSpinner.setAdapter(spinnerAdapter);
        tournamentListView.setAdapter(listViewAdapter);

        /*When select a item*/
        filterSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        tournamentListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
    }
}
