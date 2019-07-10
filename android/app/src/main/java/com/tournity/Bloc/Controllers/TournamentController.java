
package com.tournity.Bloc.Controllers;

import android.content.Context;

import com.tournity.Bloc.Listeners.ControllerListener;
import com.tournity.Repository.Enums.ModelError;
import com.tournity.Repository.Listeners.ModelListener;
import com.tournity.Repository.Models.TournamentModel;

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
    public static void Create(  String name,String description,String st_date,String end_date,int iduser_sport_group,Context context,final ControllerListener<TournamentModel>listener){
    ModelListener<TournamentModel>createdTournament=new ModelListener<TournamentModel>() {
        @Override
        public void onSuccess(TournamentModel model) {
            listener.Then();
        }

        @Override
        public void onError(ModelError error) {

        }
    };
        TournamentModel.Create(name, description, st_date, end_date, iduser_sport_group, context,createdTournament);
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

    }

    public ArrayList<TournamentModel>getAllTournamentsByDate(Date date)throws Exception{
        ArrayList<TournamentModel>result=this.tournamentModel.getAllByDate(date);
        if(result!=null)return result;
        else throw new Exception("No se encontraron resultados por la fecha especificada");
    }

public ArrayList<TournamentModel>getAllTournamentsByOwner(String owner)throws Exception{
        ArrayList<TournamentModel>result=this.tournamentModel.getAllByOwner(owner);
        if(result!=null)return result;
        else throw new Exception("No se encontraron resultados por el nombre del creador del torneo");

}

}
