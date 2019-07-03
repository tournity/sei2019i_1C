package com.tournity.App.Users.Entities;

import com.tournity.Entities.SportEntity;

import java.util.ArrayList;

public class UserEntity {

    private long idUser;
    private long idAccount;
    private String name;
    private String email;
    private String password;
    private ArrayList<SportEntity> sportEntities;

    public UserEntity(long idUser, String name, String email, String password) {
        this.idUser = idUser;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public long getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(long idAccount) {
        this.idAccount = idAccount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<SportEntity> getSportEntities() {
        return sportEntities;
    }

    public void setSportEntities(ArrayList<SportEntity> sportEntities) {
        this.sportEntities = sportEntities;
    }
}
