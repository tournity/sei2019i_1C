package com.tournity.Entities;

import java.util.ArrayList;

public class TeamEntity {
    private int id;
    private GroupEntity group;
    private String name;
    private ArrayList<PlayerEntity> playerList;

    public TeamEntity(int id, GroupEntity group, String name){
        this.id = id;
        this.group = group;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public GroupEntity getGroup() {
        return group;
    }

    public void setGroup(GroupEntity group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<PlayerEntity> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(ArrayList<PlayerEntity> playerList) {
        this.playerList = playerList;
    }
}
