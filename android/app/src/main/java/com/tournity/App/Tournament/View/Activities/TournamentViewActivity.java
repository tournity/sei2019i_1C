package com.tournity.App.Tournament.View.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.tournity.App.Match.View.Activities.SelectTypeMatchActivity;
import com.tournity.R;

import java.util.ArrayList;

public class TournamentViewActivity extends AppCompatActivity {
    ListView listViewMPlay, listViewMPlayed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tournament_view);

        //listViewMPlay = findViewById(R.id.idListViewMatchToPlay);
        //listViewMPlayed = findViewById(R.id.idListViewMatchPlayed);

        ArrayList<String> matchToPlayList = new ArrayList<>();
        ArrayList<String> matchPlayedList = new ArrayList<>();
        /*obtain string values*/

     /*   ArrayAdapter<CharSequence> listViewAdapterMPlay = new  ArrayAdapter(this,
                android.R.layout.simple_list_item_1,matchToPlayList);
        ArrayAdapter<CharSequence> listViewAdapterMPlayed = new  ArrayAdapter(this,
                android.R.layout.simple_list_item_1,matchPlayedList);

        listViewMPlay.setAdapter(listViewAdapterMPlay);
        listViewMPlayed.setAdapter(listViewAdapterMPlayed);
*/


    }

    public void onClick(View view) {


        Intent intent = new Intent(this, SelectTypeMatchActivity.class);
        startActivity(intent);

    }
}
