
package com.tournity.App.Tournament.Bloc.Controllers;

import android.content.Context;
import android.widget.Toast;

import com.tournity.App.Tournament.Entities.TournamentEntity;
import com.tournity.App.Tournament.Repository.Models.TournamentModel;
import com.tournity.Bloc.Listeners.ControllerListener;
import com.tournity.Repository.Enums.ModelError;
import com.tournity.Repository.Listeners.ModelListener;

import java.util.ArrayList;
import java.util.Date;

public class TournamentController {
    private Context context;
    private TournamentModel tournamentModel;

    public TournamentController(Context context) {
        this.context = context;
        this.tournamentModel=new TournamentModel(context);
    }
    public TournamentController() {

        this.tournamentModel=new TournamentModel();
    }
    public static void Create(String name, String description, String st_date, String end_date, int iduser_sport_group, final Context context){
    ModelListener<TournamentModel>createdTournament=new ModelListener<TournamentModel>() {
        @Override
        public void onSuccess(TournamentModel model) {

            Toast.makeText(context, "Sucessful Registered Tournament", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onError(ModelError error) {

        }
    };
        TournamentEntity tournament=new TournamentEntity();
tournament.setName(name);
tournament.setDescription(description);
tournament.setStartDate(new Date(st_date));
tournament.setEndDate(new Date(end_date));
tournament.setUserSportGroup(iduser_sport_group);


        TournamentModel.Create(tournament, context,createdTournament);
    }
    public void getAllTournaments()throws Exception{
        ModelListener<ArrayList<TournamentModel>>listener=new ModelListener<ArrayList<TournamentModel>>() {
            @Override
            public void onSuccess(ArrayList<TournamentModel> model) {
            }

            @Override
            public void onError(ModelError error) {

            }
        };
       this.tournamentModel.getAll(context,listener);




}
    public static ArrayList<String> getAllNamesOfTournaments(ArrayList<TournamentModel> listTournaments){
        ArrayList<String> namesList = new ArrayList<>();
            for (int i = 0; i<listTournaments.size();i++){
                namesList.add(listTournaments.get(i).getTournamentEntity().getName());
            }
        return namesList;
}

public void getAllTournamentsBySportId(int idSport, final ControllerListener<ArrayList<TournamentModel>>listener){
        ModelListener<ArrayList<TournamentModel>>tournaments=new ModelListener<ArrayList<TournamentModel>>() {
            @Override
            public void onSuccess(ArrayList<TournamentModel> model) {
                listener.Then();
            }

            @Override
            public void onError(ModelError error) {

            }
        };
        TournamentModel.getAllBySportId(idSport,context,tournaments);

    }

    public void getAllTournamentsByDate(String initDate, final ControllerListener<ArrayList<TournamentModel>>listener){
        ModelListener<ArrayList<TournamentModel>>tournaments=new ModelListener<ArrayList<TournamentModel>>() {
            @Override
            public void onSuccess(ArrayList<TournamentModel> model) {
                listener.Then();
            }

            @Override
            public void onError(ModelError error) {

            }
        };
        TournamentModel.getAllByDate(initDate,context,tournaments);

    }
    public void getAllTournamentsByOwner(int IdOwner, final ControllerListener<ArrayList<TournamentModel>>listener){
        ModelListener<ArrayList<TournamentModel>>tournaments=new ModelListener<ArrayList<TournamentModel>>() {
            @Override
            public void onSuccess(ArrayList<TournamentModel> model) {
                listener.Then();
            }

            @Override
            public void onError(ModelError error) {

            }
        };
        TournamentModel.getAllByOwner(IdOwner,context,tournaments);

    }


}