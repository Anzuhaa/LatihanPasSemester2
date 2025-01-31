package com.example.latihanpassemester2.Liga;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

import com.example.latihanpassemester2.Api_2.Team;
import com.example.latihanpassemester2.Api_2.TeamAdapter;
import com.example.latihanpassemester2.Api_2.TeamService;
import com.example.latihanpassemester2.Api_2.TeamResponse2;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class LigaSpanyol extends Fragment {


    private static final String BASE_URL = "https://www.thesportsdb.com/api/v1/json/3/";
    private RecyclerView recyclerView;
    private TeamAdapter teamAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(com.example.latihanpassemester2.R.layout.fragment_liga_spanyol, container, false);
        recyclerView = view.findViewById(com.example.latihanpassemester2.R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        fetchData();
        return view;
    }

    private void fetchData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TeamService service = retrofit.create(TeamService.class);
        Call<TeamResponse2> call = service.getTeams();
        call.enqueue(new Callback<TeamResponse2>() {
            @Override
            public void onResponse(Call<TeamResponse2> call, Response<TeamResponse2> response) {
                if (response.isSuccessful()) {
                    TeamResponse2 teamResponse = response.body();
                    if (teamResponse != null) {
                        List<Team> teams = teamResponse.getTeams();
                        teamAdapter = new TeamAdapter(getContext(), teams);
                        recyclerView.setAdapter(teamAdapter);
                    }
                } else {
                    // Handle unsuccessful response
                }
            }

            @Override
            public void onFailure(Call<TeamResponse2> call, Throwable t) {
                // Handle network failures
            }
        });
    }
}