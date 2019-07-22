package com.tournity.App.Tournament.Entities;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Date;

public class TournamentEntity {
    private int id;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private int UserSportGroup;
    private Date createdDate;
    private String status;

    public TournamentEntity(String name, String description, Date startDate, Date endDate, Date createdDate, String status) {
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.createdDate = createdDate;
        this.status = status;
    }
    public TournamentEntity(){

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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getUserSportGroup() {
        return UserSportGroup;
    }

    public void setUserSportGroup(int userSportGroup) {
        UserSportGroup = userSportGroup;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static TournamentEntity fromJSON(JSONObject tournamentData) throws JSONException {
        TournamentEntity myEntity = new TournamentEntity();
        myEntity.id = tournamentData.getInt("id");
        myEntity.setName(tournamentData.getString("name"))  ;
        myEntity.setDescription(tournamentData.getString("description"));
        myEntity.setStartDate((Date) tournamentData.get("start_date"));//es posible que la implementacion del casting sea diferente
        myEntity.setEndDate((Date)tournamentData.get("end_date"));
        myEntity.setUserSportGroup(tournamentData.getInt("user_sport_group"));
        myEntity.setCreatedDate((Date)tournamentData.get("created_date"));
        myEntity.setStatus(tournamentData.getString("status"));

        return myEntity;
    }

    public String toJSON() throws IOException {
        return new ObjectMapper().writeValueAsString(this);
    }
}
