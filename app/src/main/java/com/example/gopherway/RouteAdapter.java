package com.example.gopherway;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

public class RouteAdapter extends RecyclerView.Adapter<RouteAdapter.RouteViewHolder> {


    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<Route> routeList;

    //getting the context and product list with constructor
    public RouteAdapter(Context mCtx, List<Route> routeList) {
        this.mCtx = mCtx;
        this.routeList = routeList;
    }

    @Override
    public RouteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.layout_routes, null);
        return new RouteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RouteViewHolder holder, int position) {
        //getting the product of the specified position
        Route route = routeList.get(position);

        //binding the data with the viewholder views
        holder.textViewStart.setText(route.getStart());
        holder.textViewEnd.setText(route.getEnd());

//        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(product.getImage()));

    }


    @Override
    public int getItemCount() {
        return routeList.size();
    }


    class RouteViewHolder extends RecyclerView.ViewHolder {

        TextView textViewStart, textViewEnd;
        ImageView imageView;

        public RouteViewHolder(View itemView) {
            super(itemView);

            textViewStart = itemView.findViewById(R.id.textViewStart);
            textViewEnd = itemView.findViewById(R.id.textViewEnd);
        }
    }
}
