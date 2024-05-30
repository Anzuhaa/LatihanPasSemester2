package com.example.latihanpassemester2.Api_1;

import static android.os.Build.VERSION_CODES.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.latihanpassemester2.Api_1.Team;
import com.example.latihanpassemester2.R;

import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.TeamViewHolder> {

    private List<Team> teamList;
    private Context context;

    public TeamAdapter(Context context, List<Team> teamList) {
        this.context = context;
        this.teamList = teamList;
    }

    @NonNull
    @Override
    public TeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(com.example.latihanpassemester2.R.layout.item_layout, parent, false);
        return new TeamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamViewHolder holder, int position) {
        Team team = teamList.get(position);
        holder.teamName.setText(team.getStrTeam());
        holder.teamStadium.setText(team.getStrStadium());
        Glide.with(context).load(team.getStrTeamBadge()).into(holder.teamBadge);
    }

    @Override
    public int getItemCount() {
        return teamList.size();
    }

    public static class TeamViewHolder extends RecyclerView.ViewHolder {
        TextView teamName;
        TextView teamStadium;
        ImageView teamBadge;

        public TeamViewHolder(@NonNull View itemView) {
            super(itemView);
            teamName = itemView.findViewById(com.example.latihanpassemester2.R.id.tvTeamname);
            teamStadium = itemView.findViewById(com.example.latihanpassemester2.R.id.tvStadium);
            teamBadge = itemView.findViewById(com.example.latihanpassemester2.R.id.ivImage);
        }
    }
}