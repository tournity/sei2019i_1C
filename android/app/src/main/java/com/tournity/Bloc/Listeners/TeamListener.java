package com.tournity.Bloc.Listeners;

import com.tournity.Bloc.Enums.ControllerError;

public interface TeamListener {
    public void Then();
    public void Catch(ControllerError error);
}
