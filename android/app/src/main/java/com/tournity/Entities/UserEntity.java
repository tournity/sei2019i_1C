package com.tournity.Entities;

import com.tournity.App.Authentication.Entities.AccountEntity;

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
}
