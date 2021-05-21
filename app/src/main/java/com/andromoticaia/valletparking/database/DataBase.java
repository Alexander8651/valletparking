package com.andromoticaia.valletparking.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = DriverEntity.class, version = 1)
public abstract class DataBase extends RoomDatabase {

    public abstract DriverDao obtenerProductoDao();

}