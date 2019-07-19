package com.tournity.View.Activities;

import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.tournity.R;
import com.tournity.View.Fragments.SportFragment;
import com.tournity.View.Fragments.TournamentFragment;
import com.tournity.View.Fragments.UserFragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;

import android.view.MenuItem;
import android.view.View;

public class HomeActivity extends AppCompatActivity implements TournamentFragment.OnFragmentInteractionListener,
        SportFragment.OnFragmentInteractionListener, UserFragment.OnFragmentInteractionListener {

    private SportFragment sportFragment;
    private TournamentFragment tournamentFragment;
    private UserFragment userFragment;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            // Fragment selectedFragment = null;
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            switch (item.getItemId()) {
                case R.id.navigation_tournament:
                    //selectedFragment = TournamentFragment.newInstance();
                    System.out.println("tournament");
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, tournamentFragment).commit();
                    break;
                case R.id.navigation_sport:
                    //selectedFragment= SportFragment.newInstance();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, sportFragment).commit();
                    System.out.println("sport");
                    break;
                case R.id.navigation_profile:
                    //selectedFragment = UserFragment.newInstance();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, userFragment).commit();
                    System.out.println("profile");
                    break;
            }
            /*FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frame_layout,selectedFragment);*/
            fragmentTransaction.commit();
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sportFragment = new SportFragment();
        tournamentFragment = new TournamentFragment();
        userFragment = new UserFragment();
        setContentView(R.layout.activity_home);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        getSupportFragmentManager().beginTransaction().add(R.id.frame_layout, tournamentFragment).commit();


       /* FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, TournamentFragment.newInstance());
        transaction.commit();*/
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public void onClick(View view) {
    }

    public TournamentFragment getTournamentFragment() {
        return tournamentFragment;
    }

    public SportFragment getSportFragment() {
        return sportFragment;
    }
}
