package com.andromoticaia.valletparking.ui.adapters;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.andromoticaia.valletparking.R;
import com.andromoticaia.valletparking.database.DriverEntity;
import com.andromoticaia.valletparking.databinding.ItemdriverBinding;

import org.jetbrains.annotations.NotNull;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;

public class DriverAdapter extends RecyclerView.Adapter<DriverAdapter.Viewolder> {

    List<DriverEntity> drivers;

    public DriverAdapter(List<DriverEntity> drivers) {
        this.drivers = drivers;
    }

    @NonNull
    @Override
    public Viewolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        ItemdriverBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.itemdriver, parent, false);
        return new Viewolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull DriverAdapter.Viewolder holder, int position) {
        DriverEntity driver = drivers.get(position);
        holder.bindItem(driver);
        holder.itemView.setOnClickListener( v-> {
            Bundle bundle = new Bundle();
            bundle.putParcelable("driver", driver);
            Navigation.findNavController(v).navigate(R.id.action_homeFragment_to_detailFragment, bundle);

        });
    }

    @Override
    public int getItemCount() {
        return drivers.size();
    }

    public static class Viewolder extends RecyclerView.ViewHolder  {
        ItemdriverBinding mbinding;

        public Viewolder(ItemdriverBinding binding) {
            super(binding.getRoot());
            mbinding = binding;
        }

        public void bindItem(DriverEntity driverEntity) {
            mbinding.setDriver(driverEntity);
        }
    }
}
