package com.tournity.Repository.Listeners;

import com.tournity.Repository.Enums.RepositoryError;

public interface RepositoryListener<T> {
    public void onQueryCompleted(T entity);
    public void onQueryFailed(RepositoryError error);
}
