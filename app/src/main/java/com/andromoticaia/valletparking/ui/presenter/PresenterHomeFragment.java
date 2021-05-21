package com.andromoticaia.valletparking.ui.presenter;

import android.content.Context;

import com.andromoticaia.valletparking.database.DriverDatabase;
import com.andromoticaia.valletparking.database.DriverEntity;

import java.util.List;

public class PresenterHomeFragment implements IPresenterHomeFragment {

    private final IHomeFragment iHomeFragment;
    private final Context context;
    List<DriverEntity> drives;

    public PresenterHomeFragment(IHomeFragment iHomeFragment, Context context) {
        this.iHomeFragment = iHomeFragment;
        this.context = context;
        getDriversFromDb();
    }

    @Override
    public void getDriversFromDb() {

        DriverDatabase driverDatabase = DriverDatabase.get(context);

        drives = driverDatabase.getDrivers();
        showDrivers();
    }

    @Override
    public void showDrivers() {
        iHomeFragment.initAdapter(iHomeFragment.createAdapter(drives, context));
    }
}
