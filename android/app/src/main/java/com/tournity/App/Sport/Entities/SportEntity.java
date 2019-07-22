package com.tournity.App.Sport.Entities;

import com.tournity.App.Tournament.Entities.TournamentEntity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

public class SportEntity {
    private int id;
    private String name;
    private String description;
    private String status;
    private String createdAt;
    private String updatedAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
    public static SportEntity fromJSON(JSONObject sportData) throws JSONException {
        SportEntity myEntity = new SportEntity();
        myEntity.id = sportData.getInt("id");
        myEntity.setName(sportData.getString("name"))  ;
        myEntity.setDescription(sportData.getString("description"));
        myEntity.setStatus(sportData.getString("status"));
        myEntity.setCreatedAt(sportData.getString("createdAt"));
        myEntity.setUpdatedAt(sportData.getString("updatedAt"));
        return myEntity;
    }
}
