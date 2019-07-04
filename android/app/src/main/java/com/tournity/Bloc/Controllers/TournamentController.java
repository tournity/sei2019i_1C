
package com.tournity.Bloc.Controllers;

import android.content.Context;

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
    public ArrayList<TournamentModel> getAllTournaments()throws Exception{

        if(this.tournamentModel.getAll()!=null) {
            return this.tournamentModel.getAll();
        }else{
            throw new Exception("No se encontraron resultados");
    }




}
    public static ArrayList<String> getAllNamesOfTournaments(ArrayList<TournamentModel> listTournaments){
        ArrayList<String> namesList = new ArrayList<>();
            for (int i = 0; i<listTournaments.size();i++){
                namesList.add(listTournaments.get(i).getTournamentEntity().getName());
            }
        return namesList;
}

public ArrayList<TournamentModel>getAllTournamentsBySportId(int idSport)throws Exception{
    ArrayList<TournamentModel>result=this.tournamentModel.getAllBySportId(idSport);
    if(result!=null){
        return result;
    }else
throw new Exception("No se encontraron Torneos por El deporte especificado");

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
