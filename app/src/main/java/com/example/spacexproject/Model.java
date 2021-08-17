package com.example.spacexproject;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "crew_table")
public class Model {

    @PrimaryKey @NonNull
    @SerializedName("id")
    @ColumnInfo(name = "id")
     String id;

    @SerializedName("name")
    @ColumnInfo(name = "name")
    String name;

    @SerializedName("agency")
    @ColumnInfo(name = "agency")
    String agency;

    @SerializedName("image")
    @ColumnInfo(name = "image")
    String image;

    @SerializedName("wikipedia")
    @ColumnInfo(name = "wikipedia")
    String wikipedia;

    @SerializedName("status")
    @ColumnInfo(name = "status")
    String status;

//    public Model(String id, String name, String agency, String image, String wikipedia, String status) {
//
//        this.name = name;
//        this.agency = agency;
//        this.image = image;
//        this.wikipedia = wikipedia;
//        this.status = status;
//    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setWikipedia(String wikipedia) {
        this.wikipedia = wikipedia;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getAgency() {
        return agency;
    }

    public String getImage() {
        return image;
    }

    public String getWikipedia() {
        return wikipedia;
    }

    public String getStatus() {
        return status;
    }

}
