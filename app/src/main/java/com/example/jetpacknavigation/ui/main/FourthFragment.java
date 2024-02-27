package com.example.jetpacknavigation.ui.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jetpacknavigation.R;
import com.example.jetpacknavigation.databinding.FourthFragmentBinding;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FourthFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FourthFragment extends Fragment {

    private MainViewModel mViewModel;
    private FourthFragmentBinding binding;
    public static FourthFragment newInstance() {
        return new FourthFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FourthFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        /* Using Bundle
        Bundle bundle = getArguments();
        if(bundle != null && bundle.containsKey("contact")){

            Contact contact = (Contact) bundle.getSerializable("contact");
            String value = contact.getName() + "-" + contact.getEmail() + "-" + contact.getPosition();
            binding.objectTextView.setText(value);
        }

         */

        /* Using Safe Args */

        FourthFragmentArgs args = FourthFragmentArgs.fromBundle(getArguments());
        String value = args.getContact().getName() + "-" + args.getContact().getEmail() + "-" + args.getContact().getPosition();
        binding.objectTextView.setText(value);

        binding.goToFifthFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(view);
//                navController.navigate(R.id.action_fourthFragment_to_fifthFragment);
                NavDirections navDirections = FourthFragmentDirections.actionFourthFragmentToFifthFragment();
                navController.navigate(navDirections);

            }
        });
    }
}