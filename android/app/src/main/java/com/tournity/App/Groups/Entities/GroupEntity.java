package com.tournity.App.Groups.Entities;


import org.json.JSONException;
import org.json.JSONObject;

public class GroupEntity {
    private int id;
    private String name;

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
    public static GroupEntity fromJSON(JSONObject groupData) throws JSONException {
        GroupEntity gE = new GroupEntity();
        gE.id = groupData.getInt("id");
        gE.name = groupData.getString("name");
        return  gE;
    }
}
