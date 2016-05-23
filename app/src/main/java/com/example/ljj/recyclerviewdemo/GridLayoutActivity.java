package com.example.ljj.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.ljj.recyclerviewdemo.adapter.GridAdapter;

import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


public class GridLayoutActivity extends AppCompatActivity {

    @Bind(R.id.id_recyclerView)
    RecyclerView recyclerView;

    private GridLayoutManager gridLayoutManager;
    private GridAdapter adapter;
    private List<Integer> mList = Arrays.asList(R.mipmap.tu,R.mipmap.tu2,R.mipmap.tu3,R.mipmap.tu4,R.mipmap.tu5,R.mipmap.tu6
            ,R.mipmap.tu7,R.mipmap.tu8,R.mipmap.tu9,R.mipmap.tu10,R.mipmap.tu11,R.mipmap.tu,R.mipmap.tu2,R.mipmap.tu3,R.mipmap.tu4,R.mipmap.tu5,R.mipmap.tu6
            ,R.mipmap.tu7,R.mipmap.tu8,R.mipmap.tu9,R.mipmap.tu10,R.mipmap.tu11);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_layout);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        gridLayoutManager = new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(gridLayoutManager);
        adapter = new GridAdapter(this,mList);
        recyclerView.setAdapter(adapter);
    }
}
