package com.tournity.App.Users.Bloc.Controllers;

public class UserController {
    public static boolean signUp(String name, String email, String password) {

        return false;
    }

    public boolean validateEmail(String email) {
        if (email.contains("@")) {
            return true;
        }
        return false;
    }

    public boolean validatePasswordLength(String password) {
        if (password.length() > 5) {
            return true;
        }
        return false;
    }

    public boolean nameIsEmpty(String name){
        if(name.isEmpty()){
            return false;
        }
        return true;
    }
}
