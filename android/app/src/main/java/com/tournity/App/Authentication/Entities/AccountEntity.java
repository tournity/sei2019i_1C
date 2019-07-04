package com.tournity.App.Authentication.Entities;

import com.tournity.Entities.Entity;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.Date;

public class AccountEntity implements Entity<AccountEntity> {
    private int id;
    private String type;
    private String name;
    private String email;
    private Date lastInteractionDate;
    private String password;
    private String token;
    private String status;
    private Date createdAt;
    private Date updatedAt;

    public AccountEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public Date getLastInteractionDate() {
        return lastInteractionDate;
    }

    public void setLastInteractionDate(Date lastInteractionDate) {
        this.lastInteractionDate = lastInteractionDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public AccountEntity fromJSON(String json) throws IOException {
        return new ObjectMapper().readValue(json, AccountEntity.class);
    }

    public String toJSON() throws IOException {
        return new ObjectMapper().writeValueAsString(this);
    }
}
