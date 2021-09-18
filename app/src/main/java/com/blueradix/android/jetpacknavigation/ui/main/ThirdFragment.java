package com.blueradix.android.jetpacknavigation.ui.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blueradix.android.jetpacknavigation.databinding.FragmentThirdBinding;


public class ThirdFragment extends Fragment {

    private FragmentThirdBinding binding;

    public static ThirdFragment newInstance() {
        return new ThirdFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentThirdBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Use the getArguments method to retrieve the data passed through the action
        ThirdFragmentArgs args = ThirdFragmentArgs.fromBundle(getArguments());
        //we immediately set it to the nameTextView widget in the fragment_third.xml file by using the viewBinding
        binding.nameTextView.setText(args.getName());

    }
}