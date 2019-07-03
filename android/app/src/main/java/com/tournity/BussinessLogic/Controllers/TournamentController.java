
package com.tournity.BussinessLogic.Controllers;

import android.content.Context;

import com.tournity.DataModels.TournamentModel;

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



}
