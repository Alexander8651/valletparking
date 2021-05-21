package com.andromoticaia.valletparking.database;

import android.content.Context;

import androidx.room.Room;

import java.util.List;

public class DriverDatabase {

    private static DriverDatabase driverDataBase;
    private DriverDao driverDao;

    public DriverDatabase(){

    }

    private DriverDatabase(Context context){
        Context appContext = context.getApplicationContext();
        DataBase database = Room.databaseBuilder(
                appContext,
                DataBase.class,
                "driversdatabase"
        ).allowMainThreadQueries().build();
        driverDao = database.obtenerProductoDao();
    }

    public  static  DriverDatabase get(Context context){
        if (driverDataBase == null){
            driverDataBase = new DriverDatabase(context);
        }
        return driverDataBase;
    }

    public void addDriver(DriverEntity driverEntity){
        driverDao.addDriver(driverEntity);
    }

    public void updateDriver(DriverEntity driverEntity){
        driverDao.updateDriver(driverEntity);
    }


    public List<DriverEntity> getDrivers(){
        return  driverDao.getDrivers();
    }


}

