package com.tournity.App.User.Repository.Models;

import android.content.Context;

import com.tournity.App.Authentication.Entities.AccountEntity;
import com.tournity.App.User.Entities.UserEntity;
import com.tournity.App.User.Repository.Repositories.UserRepository;
import com.tournity.Repository.Enums.ModelError;
import com.tournity.Repository.Enums.RepositoryError;
import com.tournity.Repository.Listeners.ModelListener;
import com.tournity.Repository.Listeners.RepositoryListener;

public class UserModel {
    UserEntity user;

    public UserModel(UserEntity user) {
        this.user = user;
    }

    public UserModel() {
    }

    public void Register(AccountEntity newaccount, Context context, final ModelListener listener){
        RepositoryListener<AccountEntity>userRegistered=new RepositoryListener() {
            @Override
            public void onQueryCompleted(Object entity) {
                listener.onSuccess(null);
            }

            @Override
            public void onQueryFailed(RepositoryError error) {
                listener.onError(ModelError.DATA_CONVERSION_FAILED);
            }
        };


        UserRepository.Insert(newaccount,context,userRegistered);
    }
}

