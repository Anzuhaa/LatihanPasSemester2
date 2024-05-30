package com.example.latihanpassemester2;

import static android.app.Activity.RESULT_OK;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.latihanpassemester2.MainActivity;
import com.example.latihanpassemester2.R;

public class ProfileFragment extends Fragment {
    static final String PREFS_NAME = "MyPrefsFile";

    Button btnLogout;

    @NonNull
    @Override
     public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        btnLogout = view.findViewById(R.id.btnLogout);


    btnLogout.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            logout();
        }
    });
    return view;
    }
    public void logout() {
        SharedPreferences settings = getActivity().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.clear();
        editor.apply();
        Toast.makeText(getActivity(), "Logged out successfully", Toast.LENGTH_SHORT).show();
        // Redirect to MainActivity
        Intent intent = new Intent(getActivity(), MainActivity.class);
        startActivity(intent);
        getActivity().finish();
    }
}