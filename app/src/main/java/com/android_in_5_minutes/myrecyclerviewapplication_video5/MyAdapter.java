package com.android_in_5_minutes.myrecyclerviewapplication_video5;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by renato on 24/07/2016.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    Context context;
    ArrayList<MyObjectProvider.MyObject> myObjects = new ArrayList<>();

    public MyAdapter(Context context) {
        this.context = context;
        myObjects = new MyObjectProvider(context).getObjects();
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.row, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyAdapter.ViewHolder holder, final int position) {
        holder.imageView.setImageResource(myObjects.get(position).getImageId());
        holder.textView.setText(myObjects.get(position).getText());
        if(myObjects.get(position).isFavorite()) {
            holder.imageView_favorite.setImageResource(R.drawable.star_yellow);
        } else {
            holder.imageView_favorite.setImageResource(R.drawable.star_gray);
        }

        holder.imageView_favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(myObjects.get(position).isFavorite()) {
                    holder.imageView_favorite.setImageResource(R.drawable.star_gray);
                    myObjects.get(position).setFavorite(false);
                } else {
                    holder.imageView_favorite.setImageResource(R.drawable.star_yellow);
                    myObjects.get(position).setFavorite(true);
                }
            }
        });

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, SecondActivity.class));
            }
        });

    }


    @Override
    public int getItemCount() {
        return myObjects.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView, imageView_favorite;
        TextView textView;
        RelativeLayout relativeLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.my_imageView);
            textView = (TextView) itemView.findViewById(R.id.my_textView);
            imageView_favorite = (ImageView) itemView.findViewById(R.id.imageView_favorite);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.relative_layout);
        }
    }


}
