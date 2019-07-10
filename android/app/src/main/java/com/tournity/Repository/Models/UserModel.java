package com.tournity.Repository.Models;

import com.tournity.App.Authentication.Entities.AccountEntity;
import com.tournity.Entities.UserEntity;
import com.tournity.Repository.Enums.RepositoryError;
import com.tournity.Repository.Listeners.ModelListener;
import com.tournity.Repository.Listeners.RepositoryListener;
import com.tournity.Repository.Repositories.UserRepository;

import java.util.Date;

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
       AccountEntity newaccount=new AccountEntity();
       newaccount.setName(Username);
       newaccount.setType("user");
       newaccount.setEmail(email);
       newaccount.setEncryptedPassword(Password);
       newaccount.setCreatedAt(new Date());
       newaccount.setStatus("active");
       newuser.setAccount(newaccount);
        UserRepository.Insert(newuser,userRegistered);
    }
}

