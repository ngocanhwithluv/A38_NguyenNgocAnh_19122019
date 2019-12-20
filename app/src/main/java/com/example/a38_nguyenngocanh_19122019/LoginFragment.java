package com.example.a38_nguyenngocanh_19122019;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.a38_nguyenngocanh_19122019.databinding.ActivityLoginBinding;

public class LoginFragment extends Fragment {

//    SharedPreferences sharedPreferences ;
//    SharedPreferences.Editor editor;
    OrderFragment orderFragment;

    ActivityLoginBinding binding;


    public static LoginFragment newInstance() {
        Bundle args = new Bundle();
        LoginFragment fragment = new LoginFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.activity_login, container, false);

        binding.buttonLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, orderFragment);

//                Log.e("NNA",binding.editTextUserName.getText().toString()+ " " );

                if(binding.editTextUserName.getText().toString().equals(user) &&
                    binding.editTextPassword.getText().toString().equals(password)){
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.log_in, new OrderFragment()).addToBackStack(null).commit();
                }
                else{
                    Toast.makeText(getContext() , "Try again", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return binding.getRoot();
    }

    private String user = "admin";
    private String password = "admin";



}
