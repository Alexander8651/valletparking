package com.andromoticaia.valletparking.ui.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andromoticaia.valletparking.R;
import com.andromoticaia.valletparking.database.DriverEntity;
import com.andromoticaia.valletparking.databinding.FragmentHomeBinding;
import com.andromoticaia.valletparking.ui.adapters.DriverAdapter;
import com.andromoticaia.valletparking.ui.presenter.IHomeFragment;
import com.andromoticaia.valletparking.ui.presenter.IPresenterHomeFragment;
import com.andromoticaia.valletparking.ui.presenter.PresenterHomeFragment;

import java.util.List;


public class HomeFragment extends Fragment implements IHomeFragment {

    FragmentHomeBinding binding;
    IPresenterHomeFragment iPresenterHomeFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(LayoutInflater.from(requireContext()), R.layout.fragment_home,container, false);

        iPresenterHomeFragment = new PresenterHomeFragment(this, requireContext());

        binding.addriver.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_addDriverFragment);
        });

        return binding.getRoot();
    }

    @Override
    public DriverAdapter createAdapter(List<DriverEntity> drivers, Context context) {
        DriverAdapter driverAdapter = new DriverAdapter(drivers);
        return driverAdapter;
    }

    @Override
    public void initAdapter(DriverAdapter driver) {
        binding.rvFormulario.setAdapter(driver);
    }
}