package com.example.ljj.recyclerviewdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.ljj.recyclerviewdemo.adapter.MainRecyclerViewAdapter;
import com.example.ljj.recyclerviewdemo.utils.RecyclerDivider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainRecyclerViewAdapter.RecyclerViewItemClickListener{


    @Bind(R.id.id_recyclerView)
    RecyclerView recyclerView;
    private LinearLayoutManager linearManager;
    private MainRecyclerViewAdapter adapter;
    private List<String> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
        list = Arrays.asList(getResources().getStringArray(R.array.mainList));
        adapter = new MainRecyclerViewAdapter(this,list);
        linearManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearManager);
        adapter.setRecyclerItemListener(this);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new RecyclerDivider(this,RecyclerDivider.VERTIAL_LIST));
    }


    @Override
    public void recyclerItemClick(int position) {
        switch (position){
            case 0://水平
                Intent intent = new Intent(this,HorizontalActivity.class);
                startActivity(intent);
                //overridePendingTransition();
                break;

            case 1://gridLayout
                Intent intent1 = new Intent(this,GridLayoutActivity.class);
                startActivity(intent1);
                break;
            case 2://瀑布流

                break;
        }
    }
}
