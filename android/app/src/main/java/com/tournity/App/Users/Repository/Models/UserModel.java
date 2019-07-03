package com.tournity.App.Users.Repository.Models;

import android.content.Context;

import com.tournity.App.Users.Bloc.Controllers.UserController;
import com.tournity.App.Users.Entities.UserEntity;
import com.tournity.App.Users.Repository.Repositories.UserRepository;

public class UserModel {

    private UserEntity userEntity;
    private Context context;

    public UserModel(UserEntity userEntity, Context context) {
        this.userEntity = userEntity;
        this.context = context;
    }


    public static UserModel signUp(long id, String name, String email, String password, Context context) {
        UserEntity userEntity = UserRepository.Insert(new UserEntity(id, name, email, password), context);
        UserModel userModel = new UserModel(userEntity, context);
        UserController userController = new UserController();

        userController.signUp(name, email, password);

        return userModel;
    }


}
