package com.example.myapplication;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class GifAdapter extends RecyclerView.Adapter<GifAdapter.ViewHolder> {
    private final List<String> gifUrls;

    public GifAdapter(List<String> gifUrls) {
        this.gifUrls = gifUrls;
    }

    public void addGifUrls(List<String> newGifUrls) {
        gifUrls.addAll(newGifUrls);
        notifyDataSetChanged();
    }
    @SuppressLint("NotifyDataSetChanged")
    public void updateGifUrls(List<String> gifUrls) {
        this.gifUrls.clear();
        this.gifUrls.addAll(gifUrls);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.one_gif, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String gifUrl = gifUrls.get(position);
        Glide.with(holder.itemView.getContext())
                .asGif()
                .load(gifUrl)
                .into(holder.gifImageView);
    }

    @Override
    public int getItemCount() {
        return gifUrls.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView gifImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            gifImageView = itemView.findViewById(R.id.gifImage);
        }
    }
}

