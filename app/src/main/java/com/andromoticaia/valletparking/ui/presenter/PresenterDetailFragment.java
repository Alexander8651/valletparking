package com.andromoticaia.valletparking.ui.presenter;

import android.content.Context;
import android.widget.Toast;

import androidx.navigation.Navigation;

import com.andromoticaia.valletparking.database.DriverDatabase;
import com.andromoticaia.valletparking.database.DriverEntity;

public class PresenterDetailFragment implements IPresenterDetailFragment{

    IDetailFragment iDetailFragment;
    DriverEntity driverEntity;
    Context context;

    public PresenterDetailFragment(IDetailFragment iDetailFragment, DriverEntity driverEntity, Context context) {
        this.iDetailFragment = iDetailFragment;
        this.driverEntity = driverEntity;
        this.context = context;
        payValletParking();
    }

    @Override
    public void payValletParking() {

        iDetailFragment.createButtonPay().setOnClickListener(v->{
            DriverDatabase db = DriverDatabase.get(context);

            driverEntity.setInside(false);
            driverEntity.setOut(true);


            db.updateDriver(driverEntity);
            Toast.makeText(context, "Se pago el parqueadero", Toast.LENGTH_SHORT).show();
            Navigation.findNavController(v).navigateUp();

        });

    }
}
