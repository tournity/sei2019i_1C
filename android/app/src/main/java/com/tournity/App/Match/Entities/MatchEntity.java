package com.tournity.App.Match.Entities;

import com.tournity.App.Tournament.Entities.TournamentEntity;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Date;

public class MatchEntity {
    private int id;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private int stageGroup;
    private Date createdDate;
    private String status;

    public MatchEntity() {
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

    public int getStageGroup() {
        return stageGroup;
    }

    public void setStageGroup(int stageGroup) {
        this.stageGroup = stageGroup;
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

    public static MatchEntity fromJSON(JSONObject matchData) throws JSONException {
        MatchEntity myEntity = new MatchEntity();
        myEntity.setId(matchData.getInt("id"));
        myEntity.setName(matchData.getString("name"))  ;
        myEntity.setDescription(matchData.getString("description"));
        myEntity.setStartDate((Date) matchData.get("start_date"));//es posible que la implementacion del casting sea diferente
        myEntity.setEndDate((Date)matchData.get("end_date"));
        myEntity.setStageGroup(matchData.getInt("stage_group"));
        myEntity.setCreatedDate((Date)matchData.get("created_date"));
        myEntity.setStatus(matchData.getString("status"));

        return myEntity;
    }
    public String toJSON() throws IOException {
        return new ObjectMapper().writeValueAsString(this);
    }
}
