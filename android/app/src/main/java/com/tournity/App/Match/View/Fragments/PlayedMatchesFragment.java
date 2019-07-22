package com.tournity.App.Match.View.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.tournity.App.Group.View.Activities.ListGroupActivity;
import com.tournity.App.Match.View.Activities.MatchViewActivity;
import com.tournity.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PlayedMatchesFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PlayedMatchesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PlayedMatchesFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    View view;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ListView matchlist;
    private OnFragmentInteractionListener mListener;

    public PlayedMatchesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PlayedMatchesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PlayedMatchesFragment newInstance(String param1, String param2) {
        PlayedMatchesFragment fragment = new PlayedMatchesFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.view = inflater.inflate(R.layout.fragment_played_matches, container, false);
        setData();
        matchlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                onSelectedItem();
            }
        });
        return view;
    }

    public void onSelectedItem() {
        Intent intent = new Intent(this.getActivity(), MatchViewActivity.class);
        startActivity(intent);
    }

    public void setData(){
        ArrayList<String> Partidos = new ArrayList<>();
        Partidos.add("Partido 1");
        Partidos.add("Partido 2");
        Partidos.add("Partido 3");
        Partidos.add("Partido 4");
        matchlist = (ListView) this.view.findViewById(R.id.listmatches);
        ArrayAdapter adaptador = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, Partidos);
        matchlist.setAdapter(adaptador);

    }
    public void setAdapter(ArrayAdapter adapter){

        this.matchlist.setAdapter(adapter);
    }
    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
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
