package com.tournity.Entities;

import android.graphics.Bitmap;

public class PlayerEntity {
    private int id;
    private String name;
    private int age;
    private double height;
    private double weight;
    private Bitmap photo;
    private GroupEntity group;

    private PlayerEntity(int id, String name, int age,double height,double wight, Bitmap photo,GroupEntity group){
        this.id = id;
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = wight;
        this.photo = photo;
        this.group = group;
    }


}
