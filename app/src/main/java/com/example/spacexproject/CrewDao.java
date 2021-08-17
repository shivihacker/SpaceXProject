package com.example.spacexproject;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CrewDao {

    @Insert
    void insert(List<Model> model);

    @Delete
    void delete(List<Model> model);

    // we will call it in showing in recycler view
//    @Query("SELECT * FROM crew_table ORDER BY name ASC")
//    LiveData<List<CrewMember>> getAllCrew();

    @Query("SELECT DISTINCT * FROM crew_table")
    LiveData<List<Model>>  getMemberList();

    @Query("DELETE FROM crew_table")
    void deleteAll();
}
