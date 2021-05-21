package com.andromoticaia.valletparking.ui.presenter;

import android.content.Context;
import android.widget.Button;
import android.widget.Toast;

import androidx.navigation.Navigation;

import com.andromoticaia.valletparking.database.DriverDatabase;
import com.andromoticaia.valletparking.database.DriverEntity;
import com.andromoticaia.valletparking.ui.Utils;

public class PresenterAddDriver implements IPresenterAddDriver{

    IAddDriverFragment iPresenterAddDriver;
    Context context;
    DriverDatabase driverDatabase;

    public PresenterAddDriver(IAddDriverFragment iPresenterAddDriver, Context context) {
        this.iPresenterAddDriver = iPresenterAddDriver;
        this.context = context;
        validatedata();
    }

    @Override
    public void validatedata() {

        Button add = iPresenterAddDriver.createButtonAdd();
        add.setOnClickListener(v ->{

            String name = iPresenterAddDriver.createEditTextName().getText().toString();
            String licensePlate = iPresenterAddDriver.createEditTextlicesePlate().getText().toString();

            if (name.isEmpty() || licensePlate.isEmpty()){
                Toast.makeText(context, "Ingrese toda la informacion", Toast.LENGTH_SHORT).show();
            }else {
                driverDatabase = DriverDatabase.get(context);
                Utils utils = new Utils();
                DriverEntity driverEntity = new DriverEntity(null, name,utils.getDate() ,licensePlate, true, false );
                driverDatabase.addDriver(driverEntity);
                Toast.makeText(context, "Se agrego el conductor", Toast.LENGTH_SHORT).show();
                Navigation.findNavController(v).navigateUp();
            }
        });
    }
}
