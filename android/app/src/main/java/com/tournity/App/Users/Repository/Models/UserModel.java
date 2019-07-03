package com.tournity.App.Users.Repository.Models;

import android.content.Context;

import com.tournity.App.Users.Entities.UserEntity;
import com.tournity.App.Users.Repository.Repositories.UserRepository;

public class UserModel {

    private UserEntity userEntity;
    private Context context;

    public UserModel(UserEntity userEntity,Context context){
        this.userEntity = userEntity;
        this.context = context;
    }


    public static UserModel signUp(String name, String email, String password,Context context){
        UserEntity userEntity = UserRepository.Insert(new UserEntity(),context);
        UserModel userModel = new UserModel(userEntity,context);
        return  userModel;
    }


}
