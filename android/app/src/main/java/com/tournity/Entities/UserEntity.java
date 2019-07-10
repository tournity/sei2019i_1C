package com.tournity.Entities;

import com.tournity.App.Authentication.Entities.AccountEntity;

import org.json.JSONException;
import org.json.JSONObject;

public class UserEntity {
private int Id;
private AccountEntity account;

    public UserEntity() {
    }

    public UserEntity(int id) {
        Id = id;
    }

    public int getId() {
        return Id;
    }

    public AccountEntity getAccount() {
        return account;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setAccount(AccountEntity account) {
        this.account = account;
    }
    public static UserEntity fromJSON(JSONObject userData) throws JSONException{
        UserEntity myEntity = new UserEntity();
        myEntity.setId(userData.getInt("id"));
        myEntity.setAccount(new AccountEntity().fromJSON(userData.getJSONObject("account")));
        return myEntity;
    }
}
