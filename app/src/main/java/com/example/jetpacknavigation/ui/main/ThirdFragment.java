package com.example.jetpacknavigation.ui.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jetpacknavigation.databinding.ThirdFragmentBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ThirdFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ThirdFragment extends Fragment {

    private MainViewModel mViewModel;
    private ThirdFragmentBinding binding;

    public static ThirdFragment newInstance() {
        return new ThirdFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = ThirdFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        /*
         * Using Bundle
         *

        Bundle bundle = getArguments();
        if(bundle != null && bundle.containsKey("myName")){
            String value = bundle.getString("myName");
            binding.nameTextView.setText(value);
        }
         */

        /*
         * Using Safe Args
         */
        ThirdFragmentArgs args = ThirdFragmentArgs.fromBundle(getArguments());
        binding.nameTextView.setText(args.getName());

    }
}