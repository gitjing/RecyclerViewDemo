package com.example.ljj.recyclerviewdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ljj.recyclerviewdemo.R;

import java.util.List;

/**
 * 作者：ljj
 * 日期：2016/5/13 10:46
 */
public class MainRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<String> list;
    private Context context;
    private LayoutInflater inflater;

    public MainRecyclerViewAdapter(Context context,List<String> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.support_simple_spinner_dropdown_item,parent,false);
        return new MainViewHolder(view);
    }

    private class MainViewHolder  extends RecyclerView.ViewHolder{
        private TextView textView;
        public MainViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(android.R.id.text1);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        MainViewHolder mHolder = (MainViewHolder) holder;
        mHolder.textView.setText(list.get(position));
        mHolder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != recyclerListener){
                    recyclerListener.recyclerItemClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private RecyclerViewItemClickListener recyclerListener;

    public void setRecyclerItemListener(RecyclerViewItemClickListener recyclerListener) {
        this.recyclerListener = recyclerListener;
    }

    public interface RecyclerViewItemClickListener {
        void recyclerItemClick(int position);
    }
}
