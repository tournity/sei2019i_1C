package com.tournity.App.Player.View.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.tournity.R;

public class AddPlayerActivity extends AppCompatActivity {
    Button btnAddPlayer;
    EditText editTextName;
    EditText editTextDesc;
    String path;
    protected void onCreate(Bundle bundleSavedInstance) {
        super.onCreate(bundleSavedInstance);
        setContentView(R.layout.activity_add_player);
        btnAddPlayer = findViewById(R.id.idbtn_add_player);
        editTextName = findViewById(R.id.idNameAddPlayer);
        editTextDesc = findViewById(R.id.idDescriptionAddPlayer);
        path = getIntent().getStringExtra("path");

        btnAddPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference ref = FirebaseDatabase.getInstance().getReference((path + "/players"));
                PlayerM pm = new PlayerM();

                DatabaseReference push = ref.push();
                pm.description = editTextDesc.getText().toString();
                pm.name = editTextName.getText().toString();
                pm.id = push.getKey();
                push.setValue(pm).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            onBackPressed();
                        }else{
                            Toast.makeText(AddPlayerActivity.this, "An error has ocurred", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}
