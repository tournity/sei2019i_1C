package com.tournity.App.Player.View.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.tournity.App.Group.View.Activities.GroupM;
import com.tournity.App.Group.View.Activities.ListGroupActivity;
import com.tournity.R;

import java.util.ArrayList;

public class PlayersActivity extends AppCompatActivity  implements AdapterView.OnItemClickListener {
    Button btnAddPlayer;
    ListView listView;
    ArrayList<PlayerM> playerMList;
    String path;
    protected void onCreate(Bundle bundleSavedInstance) {
        super.onCreate(bundleSavedInstance);
        setContentView(R.layout.activity_players_list);
        btnAddPlayer = findViewById(R.id.buttonAddPlayer);
        btnAddPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PlayersActivity.this, AddPlayerActivity.class);
                intent.putExtra("path", path);
                startActivity(intent);
            }
        });

        listView = findViewById(R.id.idDataUser);
        ArrayList<String> listGroupName = new ArrayList<>();
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_expandable_list_item_1, listGroupName);
        listView.setAdapter(adapter);
        path = getIntent().getStringExtra("id");
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(path + "/players");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ArrayList<String> listGroupName = new ArrayList<>();
                playerMList = new ArrayList<>();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    PlayerM post = postSnapshot.getValue(PlayerM.class);
                    playerMList.add(post);
                    listGroupName.add(post.name);
                }
                ArrayAdapter adapter = new ArrayAdapter(PlayersActivity.this,
                        android.R.layout.simple_expandable_list_item_1, listGroupName);
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}
