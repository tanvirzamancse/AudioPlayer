package com.tzp.audioplayer.view.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.tzp.audioplayer.R;
import com.tzp.audioplayer.data.SongMode;
import com.tzp.audioplayer.view.activity.PlayerActivity;

import java.util.List;

public class CategoryOneAdapter extends RecyclerView.Adapter<CategoryOneAdapter.ViewHolder> {
    private List<SongMode> songModeList;
    private Context context;

    public CategoryOneAdapter(List<SongMode> songModeList, Context context) {
        this.songModeList = songModeList;
        this.context = context;
    }

    @NonNull
    @Override
    public CategoryOneAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_song, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryOneAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        SongMode songMode = songModeList.get(position);
        holder.title.setText(songModeList.get(position).getTitle());

        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context.getApplicationContext(), PlayerActivity.class);
                intent.putExtra("url", songMode.getUrl());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        if (songModeList != null) {
            return songModeList.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        AppCompatTextView title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
        }
    }
}
