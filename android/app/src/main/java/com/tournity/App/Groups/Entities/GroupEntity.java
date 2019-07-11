package com.tournity.App.Groups.Entities;


import com.tournity.App.Sports.Entities.UserSport;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

public class GroupEntity {
    private int id;
    private String name;
    private String description;
    private int userSport;
    private String status;
    private Date createdAt;
    private Date updatedAt;

    public GroupEntity() {
    }

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

    public int getUserSport() {
        return userSport;
    }

    public void setUserSport(int userSport) {
        this.userSport = userSport;
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

    public static GroupEntity fromJSON(JSONObject groupData) throws JSONException {
        GroupEntity gE = new GroupEntity();
        gE.id = groupData.getInt("id");
        gE.name = groupData.getString("name");
        gE.description = groupData.getString("description");
        gE.userSport = groupData.getInt("userSport");
        gE.status = groupData.getString("status");
        gE.updatedAt =  new Date(groupData.getString("updatedAt"));
        gE.createdAt = new Date(groupData.getString("createdAt"));
        return  gE;
    }
}
