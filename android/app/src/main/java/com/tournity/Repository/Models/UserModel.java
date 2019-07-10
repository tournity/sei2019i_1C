package com.tournity.Repository.Models;

import com.tournity.Entities.UserEntity;
import com.tournity.Repository.Enums.RepositoryError;
import com.tournity.Repository.Listeners.ModelListener;
import com.tournity.Repository.Listeners.RepositoryListener;

public class UserModel {
    UserEntity user;

    public UserModel(UserEntity user) {
        this.user = user;
    }

    public void Register(String Username, String email, String Password, final ModelListener<UserModel>listener){
        RepositoryListener<UserEntity>userRegistered=new RepositoryListener<UserEntity>() {
            @Override
            public void onQueryCompleted(UserEntity entity) {
                listener.onSuccess(new UserModel(entity));
            }

            @Override
            public void onQueryFailed(RepositoryError error) {

            }
        };
       UserEntity newuser=new UserEntity();

    }
}
