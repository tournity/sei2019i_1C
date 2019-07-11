package com.tournity.Bloc.Listeners;

import com.tournity.Bloc.Enums.ControllerError;
import com.tournity.Repository.Enums.ModelError;

public interface ControllerListener<T> {
    public void Then();
    public void Catch(ControllerError error);
}
