package com.andromoticaia.valletparking.ui.presenter;

import android.content.Context;

import com.andromoticaia.valletparking.database.DriverEntity;
import com.andromoticaia.valletparking.ui.adapters.DriverAdapter;

import java.util.List;

public interface IHomeFragment {

    DriverAdapter createAdapter(List<DriverEntity> drivers, Context context);
    void initAdapter(DriverAdapter driver);
}
