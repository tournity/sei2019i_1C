package com.tournity.Entities;

import java.util.Date;

public class SportEntity {
    private int id;
    private String name;
    private String description;
    private int created_by;
    private Date created_date;
    private String status;

    public SportEntity(String name, String description, int created_by, Date created_date, String status) {
        this.name = name;
        this.description = description;
        this.created_by = created_by;
        this.created_date = created_date;
        this.status = status;
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

    public int getCreated_by() {
        return created_by;
    }

    public void setCreated_by(int created_by) {
        this.created_by = created_by;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
