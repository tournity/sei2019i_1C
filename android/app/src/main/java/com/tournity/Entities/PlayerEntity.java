package com.tournity.Entities;

import android.graphics.Bitmap;

import java.util.ArrayList;

public class PlayerEntity {
    private int id;
    private String name;
    private String description;
    private Bitmap icon;
    private ArrayList<PlayerEntity> playerList;

    public PlayerEntity(int id, String name, String description, Bitmap icon){
        this.id = id;
        this.name = name;
        this.description = description;
        this.icon = icon;
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

    public Bitmap getIcon() {
        return icon;
    }

    public void setIcon(Bitmap icon) {
        this.icon = icon;
    }

    public ArrayList<PlayerEntity> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(ArrayList<PlayerEntity> playerList) {
        this.playerList = playerList;
    }
}
