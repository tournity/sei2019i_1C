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
import com.tournity.App.Match.View.Fragments.PlayedMatches;
import com.tournity.R;

public class SelectTypeMatchActivity extends AppCompatActivity implements ForPlayMatchesFragment.OnFragmentInteractionListener,PlayedMatches.OnFragmentInteractionListener{
    private TextView mTextMessage;
PlayedMatches played;
ForPlayMatchesFragment forplay;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:

                    return true;
                case R.id.navigation_dashboard:
                    FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.containerFragment,played);
                    transaction.commit();
                    return true;
                //case R.id.navigation_notifications:
                  //  return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_type_match);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        forplay=new ForPlayMatchesFragment();
        played=new PlayedMatches();
        getSupportFragmentManager().beginTransaction().add(R.id.containerFragment,forplay).commit();


    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
