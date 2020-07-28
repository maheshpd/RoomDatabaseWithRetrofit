package com.createsapp.roomdatabasewithretrofit.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.createsapp.roomdatabasewithretrofit.model.Actor;

import java.util.List;

@Dao
public interface ActorDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Actor> actorList);

    @Query("SELECT * FROM actor")
    void getAllActors();

    @Query("DELETE FROM actor")
    void delete();
}
