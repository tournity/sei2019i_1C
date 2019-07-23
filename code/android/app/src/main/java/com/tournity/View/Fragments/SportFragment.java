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
import com.tournity.App.Group.View.Activities.ListGroupActivity;
import com.tournity.App.Sport.Bloc.Controllers.SportController;
import com.tournity.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SportFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SportFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SportFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters

    public ListView sportList;
    private ArrayAdapter<String> sportAdapter;
    private ArrayList<SportM> sportMList;
    private OnFragmentInteractionListener mListener;
    private SportController sportController;

    public SportFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SportFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SportFragment newInstance() {
        SportFragment fragment = new SportFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sportController = new SportController(this.getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_sport, container, false);
        sportList = root.findViewById(R.id.idListSport);
        sportController.listSports();
        //--test------------------------------------------------------------
        String[] data = {};
        sportAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, data);
        sportList.setAdapter(sportAdapter);
        //--------------------------------------------------------------------

        sportList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                onSelectedItem(sportMList.get(i).id);
            }
        });

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("sports");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int count = (int)dataSnapshot.getChildrenCount();
                String[] data = new String[count];
                sportMList = new ArrayList<>();
                int index = 0;
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    SportM post = postSnapshot.getValue(SportM.class);
                    sportMList.add(post);
                    data[index++] = post.name;
                }
                sportAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, data);
                sportList.setAdapter(sportAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        // Inflate the layout for this fragment
        return root;
    }

    public void onSelectedItem(String id) {
        Intent intent = new Intent(this.getActivity(), ListGroupActivity.class);
        intent.putExtra("id", id);
        startActivity(intent);
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

    public ListView getSportList() {
        return sportList;
    }
}
