package com.tournity.App.MatchCompetitor.Entities;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Date;

public class MatchCompetitorEntity {
    private int id;
    private double points;
    private int match;
    private int stageGroupCompetitor;
    private Date createdDate;
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public int getMatch() {
        return match;
    }

    public void setMatch(int match) {
        this.match = match;
    }

    public int getStageGroupCompetitor() {
        return stageGroupCompetitor;
    }

    public void setStageGroupCompetitor(int stageGroupCompetitor) {
        this.stageGroupCompetitor = stageGroupCompetitor;
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

    public static MatchCompetitorEntity fromJSON(JSONObject matchCompetitorData) throws JSONException {
        MatchCompetitorEntity myEntity = new MatchCompetitorEntity();
        myEntity.setId(matchCompetitorData.getInt("id"));
        myEntity.setPoints(Double.parseDouble(matchCompetitorData.getString("points")));
        ;
        myEntity.setMatch(matchCompetitorData.getInt("match"));
        myEntity.setStageGroupCompetitor(matchCompetitorData.getInt("stage_group_competitor"));//es posible que la implementacion del casting sea diferente
        myEntity.setCreatedDate((Date) matchCompetitorData.get("created_date"));
        myEntity.setStatus(matchCompetitorData.getString("status"));

        return myEntity;
    }

    public String toJSON() throws IOException {
        return new ObjectMapper().writeValueAsString(this);
    }
}
