package com.example.jetpacknavigation.ui.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jetpacknavigation.R;
import com.example.jetpacknavigation.databinding.SecondFragmentBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SecondFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SecondFragment extends Fragment {

    private SecondFragmentBinding binding;
    public static SecondFragment newInstance() {
        // Required empty public constructor
        return new SecondFragment();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = SecondFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}