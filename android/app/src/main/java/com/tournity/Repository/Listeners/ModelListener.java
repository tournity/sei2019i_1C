package com.tournity.Repository.Listeners;

import com.tournity.Repository.Enums.ModelError;

public interface ModelListener<T> {
    public void onSuccess(T model);
    public void onError(ModelError error);
}
