package com.tournity.Bloc.Listeners;

import com.tournity.App.Tournament.Repository.Models.TournamentModel;
import com.tournity.Bloc.Enums.ControllerError;

public interface TournamentListener <T>{
    public void onTeamFound(T data);
    public void Catch(ControllerError e);
}
