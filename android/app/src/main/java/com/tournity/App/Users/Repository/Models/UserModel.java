package com.tournity.App.Users.Repository.Models;

import android.content.Context;

import com.tournity.App.Authentication.Entities.AccountEntity;
import com.tournity.App.Users.Entities.UserEntity;
import com.tournity.App.Users.Repository.Repositories.UserRepository;
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

    public void Register(AccountEntity newaccount, Context context, final ModelListener<UserModel>listener){
        RepositoryListener<UserEntity>userRegistered=new RepositoryListener<AccountEntity>() {
            @Override
            public void onQueryCompleted(AccountEntity entity) {
                listener.onSuccess(new AccountModel(entity));
            }

            @Override
            public void onQueryFailed(RepositoryError error) {
                listener.onError(ModelError.DATA_CONVERSION_FAILED);
            }
        };
       UserEntity newuser=new UserEntity();



       newuser.setAccount(newaccount);
        UserRepository.Insert(newuser,context,userRegistered);
    }
}

