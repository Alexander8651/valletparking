package com.andromoticaia.valletparking.ui.fragments;

import android.os.Bundle;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.andromoticaia.valletparking.R;
import com.andromoticaia.valletparking.database.DriverEntity;
import com.andromoticaia.valletparking.databinding.FragmentDetailBinding;
import com.andromoticaia.valletparking.ui.Utils;
import com.andromoticaia.valletparking.ui.presenter.IDetailFragment;
import com.andromoticaia.valletparking.ui.presenter.IPresenterDetailFragment;
import com.andromoticaia.valletparking.ui.presenter.PresenterDetailFragment;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DetailFragment extends Fragment implements IDetailFragment {

    DriverEntity driverEntity;
    double pay;
    FragmentDetailBinding  binding;

    IPresenterDetailFragment iPresenterDetailFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            driverEntity = getArguments().getParcelable("driver");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         binding = DataBindingUtil
                .bind(LayoutInflater.from(requireContext()).inflate(R.layout.fragment_detail, container, false) );

        iPresenterDetailFragment = new PresenterDetailFragment(this, driverEntity, requireContext());

        binding.licesePlate.setText(driverEntity.getLicenseplate().toUpperCase());
        binding.driver.setText(driverEntity.getName());
        binding.datein.setText(driverEntity.getAdmissionDate());

        DateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        try {
            Date date = format.parse(driverEntity.getAdmissionDate());
            Utils utils = new Utils();
            Date dateOut = format.parse(utils.getDate());

            long in = date.getTime();
            long out = dateOut.getTime();

            long timeToPay= out - in;

            int hour = (int) (timeToPay/3600000);
            double restHour = timeToPay%3600000;
            double minute = restHour/60000;
            int costOfHour = 1;
            double costOfMinute = 0.017;

            if (hour > 0) {
                pay = ((hour * costOfHour) + (minute * costOfMinute));

                String allCost = pay + " Us";
                binding.cost.setText(allCost);
            }else {
                pay =   (minute * costOfMinute);
                DecimalFormat numberFormat = new DecimalFormat("#0.00");
                String formattedNumber = numberFormat.format(pay);
                String allCost = formattedNumber + " Us";
                binding.cost.setText(allCost);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return binding.getRoot();
    }

    @Override
    public Button createButtonPay() {
        return binding.pay;
    }
}