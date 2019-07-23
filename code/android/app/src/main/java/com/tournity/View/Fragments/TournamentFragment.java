package com.tournity.View.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.tournity.App.Tournament.View.Activities.TournamentViewActivity;
import com.tournity.R;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TournamentFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TournamentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TournamentFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ListView tournamentList;
    private ArrayList<TournamentM> tournamentMList;
    private ArrayAdapter<String> tournamentAdapter;
    private OnFragmentInteractionListener mListener;

    public TournamentFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static TournamentFragment newInstance() {
        TournamentFragment fragment = new TournamentFragment();
        return fragment;
    }

    public ListView getTournamentList() {
        return tournamentList;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_tournament, container, false);
        tournamentList = root.findViewById(R.id.idListTournaments);

        //----Test--------------------------------------
        String[] data = {};
        tournamentAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, data);
        tournamentList.setAdapter(tournamentAdapter);
        tournamentList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                onClick(tournamentMList.get(i).id);
            }
        });

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("tournaments");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int count = (int)dataSnapshot.getChildrenCount();
                String[] data = new String[count];
                tournamentMList = new ArrayList<>();
                int index = 0;
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    TournamentM post = postSnapshot.getValue(TournamentM.class);
                    tournamentMList.add(post);
                    data[index++] = post.name;
                    Log.d("PEPE", post.name);
                }
                tournamentAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, data);
                tournamentList.setAdapter(tournamentAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        //---------------------------------------------------

        // Inflate the layout for this fragment
        return root;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    public void onClick(String SportId) {
        Intent intent = new Intent(this.getActivity(), TournamentViewActivity.class);
        intent.putExtra("idTournament", SportId);
        startActivity(intent);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
