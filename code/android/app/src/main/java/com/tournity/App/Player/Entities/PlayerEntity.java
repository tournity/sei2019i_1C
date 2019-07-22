package com.tournity.App.Player.Entities;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

public class PlayerEntity {
    private int id;
    private double heightInCentimeters;
    private int userSportGroupCompetitor;
    private String status;
    private Date createdAt;
    private Date updatedAt;

    public PlayerEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getHeightInCentimeters() {
        return heightInCentimeters;
    }

    public void setHeightInCentimeters(double heightInCentimeters) {
        this.heightInCentimeters = heightInCentimeters;
    }

    public int getUserSportGroupCompetitor() {
        return userSportGroupCompetitor;
    }

    public void setUserSportGroupCompetitor(int userSportGroupCompetitor) {
        this.userSportGroupCompetitor = userSportGroupCompetitor;
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

    public static PlayerEntity fromJSON(JSONObject playerData) throws JSONException{
        PlayerEntity player = new PlayerEntity();
        player.id = playerData.getInt("id");
        player.heightInCentimeters = playerData.getDouble("heightInCentimeters");
        player.userSportGroupCompetitor = playerData.getInt("userSportGroupCompetitor");
        player.status = playerData.getString("status");
        player.createdAt = new Date(playerData.getString("createdAt"));
        player.updatedAt = new Date(playerData.getString("updatedAt"));
        return player;
    }
}
