package com.tournity.Repository.Listeners;

import com.tournity.Entities.Entity;

public interface RepositoryListener<T> {
    public void onQueryCompleted(T Entity);
    public void onError();
}
