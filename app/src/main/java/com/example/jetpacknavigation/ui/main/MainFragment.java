package com.example.jetpacknavigation.ui.main;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jetpacknavigation.R;
import com.example.jetpacknavigation.databinding.MainFragmentBinding;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;
    private MainFragmentBinding binding;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = MainFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        NavController navController = Navigation.findNavController(view);

        binding.goToSecondFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NavDirections navDirections = MainFragmentDirections.actionMainFragmentToSecondFragment();
                navController.navigate(navDirections);
            }
        });

        binding.goToThirdFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = binding.nameEditText.getText().toString();
                /*
                 * Using Bundle if you did not want to use Safe args
                 *
                Bundle bundle = new Bundle();
                bundle.putString("myName", name);
                navController.navigate(R.id.action_mainFragment_to_thirdFragment, bundle);
                 */

                /*  Using Safe Args  */
                MainFragmentDirections.ActionMainFragmentToThirdFragment action = MainFragmentDirections.actionMainFragmentToThirdFragment(name);
                navController.navigate(action);
            }
        });

        binding.goToFourthFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Contact contact = new Contact();
                contact.setName("Daphne Walsh");
                contact.setEmail("dwalsh@gmail.com");
                contact.setPosition("General Manager");

                /* Using Bundle
                Bundle bundle = new Bundle();
                bundle.putSerializable("contact", contact);
                navController.navigate(R.id.action_mainFragment_to_fourthFragment, bundle);
                 */

                /* Using Safe Args */
                MainFragmentDirections.ActionMainFragmentToFourthFragment action = MainFragmentDirections.actionMainFragmentToFourthFragment(contact);
                navController.navigate(action);

            }
        });

    }


}