package com.tournity.App.Tournament.View.Activities;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.tournity.R;

import java.util.ArrayList;

public class TournamentViewActivity extends AppCompatActivity {
    ListView listViewMPlay,listViewMPlayed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tournament_view);

        listViewMPlay = findViewById(R.id.idListViewMatchToPlay);
        listViewMPlayed = findViewById(R.id.idListViewMatchPlayed);

        ArrayList<String> matchToPlayList = new ArrayList<>();
        ArrayList<String> matchPlayedList = new ArrayList<>();
        /*obtain string values*/

        ArrayAdapter<CharSequence> listViewAdapterMPlay = new  ArrayAdapter(this,
                android.R.layout.simple_list_item_1,matchToPlayList);
        ArrayAdapter<CharSequence> listViewAdapterMPlayed = new  ArrayAdapter(this,
                android.R.layout.simple_list_item_1,matchPlayedList);

        listViewMPlay.setAdapter(listViewAdapterMPlay);
        listViewMPlayed.setAdapter(listViewAdapterMPlayed);



    }
}
