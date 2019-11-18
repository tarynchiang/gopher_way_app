package com.example.gopherway;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

public class DirectionAdapter extends RecyclerView.Adapter<DirectionAdapter.DirectionViewHolder> {

    private Context mCtx;

    private List<Direction> directionList;

    public DirectionAdapter(Context mCtx, List<Direction> directionList) {
        this.mCtx = mCtx;
        this.directionList = directionList;
    }

    @Override
    public DirectionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.layout_directions, null);
        return new DirectionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DirectionViewHolder holder, int position) {
        Direction direction = directionList.get(position);

        holder.textViewDirection.setText(direction.getTitle());
        holder.textViewShortDesc.setText(direction.getShortdesc());
        holder.textViewDistance.setText(String.valueOf(direction.getDistance()));

        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(direction.getImage()));

    }


    @Override
    public int getItemCount() {
        return directionList.size();
    }


    class DirectionViewHolder extends RecyclerView.ViewHolder {

        TextView textViewDirection, textViewShortDesc, textViewDistance;
        ImageView imageView;

        public DirectionViewHolder(View itemView) {
            super(itemView);

            textViewDirection = itemView.findViewById(R.id.textViewDirection);
            textViewShortDesc = itemView.findViewById(R.id.textViewShortDesc);
            textViewDistance = itemView.findViewById(R.id.textViewDistance);
            imageView = itemView.findViewById(R.id.nav_display_picture);
        }
    }
}
