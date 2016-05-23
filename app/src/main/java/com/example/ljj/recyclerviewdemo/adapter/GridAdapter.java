package com.example.ljj.recyclerviewdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.ljj.recyclerviewdemo.R;

import java.util.List;

/**
 * 作者：ljj
 * 日期：2016/5/13 16:43
 */
public class GridAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Integer> images;
    private LayoutInflater inflater;
    private Context context;

    public GridAdapter(Context context, List<Integer> list) {
        this.images = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_grid_adapter,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        Holder mHolder = (Holder) holder;
        int  image = images.get(position);
        mHolder.imageView.setImageDrawable(context.getResources().getDrawable(image));
        mHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null){
                    listener.itemClick(position);
                }
            }
        });
    }

    private class Holder extends RecyclerView.ViewHolder{
        ImageView imageView;
        public Holder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    private AdapterItemClickListener listener;

    public void setListener(AdapterItemClickListener listener) {
        this.listener = listener;
    }

    public interface AdapterItemClickListener{
        void itemClick(int position);
    }
}
