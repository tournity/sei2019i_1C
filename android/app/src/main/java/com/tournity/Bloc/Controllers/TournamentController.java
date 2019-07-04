
package com.tournity.Bloc.Controllers;

import android.content.Context;

import com.tournity.Repository.Models.TournamentModel;

import java.util.ArrayList;
import java.util.Date;

public class TournamentController {
    private Context context;
    private static TournamentModel tournamentModel;

    public TournamentController(Context context) {
        this.context = context;
        tournamentModel=new TournamentModel(context);
    }
    public TournamentController() {

        tournamentModel=new TournamentModel();
    }
public static ArrayList<TournamentModel> getAllTournaments()throws Exception{

        if(tournamentModel.getAll()!=null) {
            return tournamentModel.getAll();
        }else{
            throw new Exception("No se encontraron resultados");
    }



}

public static ArrayList<TournamentModel>getAllTournamentsBySportId(int idSport)throws Exception{
    ArrayList<TournamentModel>result=tournamentModel.getAllBySportId(idSport);
    if(result!=null){
        return result;
    }else
throw new Exception("No se encontraron Torneos por El deporte especificado");

    }

    public static ArrayList<TournamentModel>getAllTournamentsByDate(Date date)throws Exception{
        ArrayList<TournamentModel>result=tournamentModel.getAllByDate(date);
        if(result!=null)return result;
        else throw new Exception("No se encontraron resultados por la fecha especificada");
    }

public static ArrayList<TournamentModel>getAllTournamentsByOwner(String owner)throws Exception{
        ArrayList<TournamentModel>result=tournamentModel.getAllByOwner(owner);
        if(result!=null)return result;
        else throw new Exception("No se encontraron resultados por el nombre del creador del torneo");

}

}
