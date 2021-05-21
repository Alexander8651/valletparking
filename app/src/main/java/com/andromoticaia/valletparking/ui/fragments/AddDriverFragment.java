package com.andromoticaia.valletparking.ui.fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.andromoticaia.valletparking.R;
import com.andromoticaia.valletparking.databinding.FragmentAddDriverBinding;
import com.andromoticaia.valletparking.ui.presenter.IAddDriverFragment;
import com.andromoticaia.valletparking.ui.presenter.IPresenterAddDriver;
import com.andromoticaia.valletparking.ui.presenter.PresenterAddDriver;

public class AddDriverFragment extends Fragment implements IAddDriverFragment {

    FragmentAddDriverBinding mBinding;

    IPresenterAddDriver presenterAddDriver;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mBinding = DataBindingUtil.bind(LayoutInflater.from(container.getContext()).inflate(R.layout.fragment_add_driver,container, false));

        presenterAddDriver = new PresenterAddDriver(this, requireContext());

        return mBinding.getRoot();
    }

    @Override
    public EditText createEditTextName() {
        return mBinding.name;
    }

    @Override
    public EditText createEditTextlicesePlate() {
        return mBinding.licenseplate;
    }

    @Override
    public Button createButtonAdd() {
        return mBinding.add;
    }
}