package com.tournity.App.Group.View.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.tournity.App.Group.Bloc.Controllers.GroupController;
import com.tournity.App.Player.View.Activities.PlayersActivity;
import com.tournity.R;
import com.tournity.View.Fragments.SportM;

import java.util.ArrayList;

public class ListGroupActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    public ListView listView;
    public  ArrayList<GroupM> groupMList;
    GroupController controller;
    String path;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_groups);
        listView = findViewById(R.id.idDataUser);
        controller = new GroupController(this);
        controller.listGroups();

        ArrayList<String> listGroupName = new ArrayList<>();
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_expandable_list_item_1, listGroupName);
        listView.setAdapter(adapter);

        String sportId = getIntent().getStringExtra("id");

        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        path = "users/"+uid+"/sports/" + sportId + "/groups";
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(path);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ArrayList<String> listGroupName = new ArrayList<>();
                groupMList = new ArrayList<>();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    GroupM post = postSnapshot.getValue(GroupM.class);
                    groupMList.add(post);
                    listGroupName.add(post.name);
                }
                ArrayAdapter adapter = new ArrayAdapter(ListGroupActivity.this,
                        android.R.layout.simple_expandable_list_item_1, listGroupName);
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ListGroupActivity.this, PlayersActivity.class);
                intent.putExtra("path", path + "/" +groupMList.get(i).id);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}
