package com.andromoticaia.valletparking.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DriverDao {

    @Insert
    void addDriver(DriverEntity driverEntity);

    @Update
    void updateDriver(DriverEntity driverEntity);

    @Query("SELECT * FROM driver WHERE enterokay == 1")
    List<DriverEntity> getDrivers();
}

