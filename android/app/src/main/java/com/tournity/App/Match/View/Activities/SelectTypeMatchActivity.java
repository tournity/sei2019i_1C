package com.tournity.App.Match.View.Activities;

import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.tournity.App.Match.View.Fragments.ForPlayMatchesFragment;
import com.tournity.App.Match.View.Fragments.PlayedMatchesFragment;
import com.tournity.R;

public class SelectTypeMatchActivity extends AppCompatActivity implements ForPlayMatchesFragment.OnFragmentInteractionListener, PlayedMatchesFragment.OnFragmentInteractionListener {
    private TextView mTextMessage;
    PlayedMatchesFragment played;
    ForPlayMatchesFragment forplay;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentTransaction transaction;

            switch (item.getItemId()) {
                case R.id.navigation_home:
                     transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.containerFragment, forplay);
                    transaction.commit();

                case R.id.navigation_dashboard:
                    transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.containerFragment, played);
                    transaction.commit();

            }
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_type_match);
        BottomNavigationView navView = findViewById(R.id.nav_view_match);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        forplay = new ForPlayMatchesFragment();
        played = new PlayedMatchesFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.containerFragment, forplay).commit();


    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
