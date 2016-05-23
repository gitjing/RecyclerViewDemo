package com.example.ljj.recyclerviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.ljj.recyclerviewdemo.adapter.HorizontalAdapter;

import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 作者：ljj
 * 使用水平RecyclerView实现相册画廊效果
 */
public class HorizontalActivity extends AppCompatActivity implements HorizontalAdapter.AdapterItemClickListener{

    @Bind(R.id.recycler_horizontal)
    RecyclerView recyclerView;
    @Bind(R.id.id_imageView)
    ImageView imageView;
    private View mCurrentView;
    private LinearLayoutManager linearLayoutManager;
    private HorizontalAdapter adapter;
    private List<Integer> mList = Arrays.asList(R.mipmap.tu,R.mipmap.tu2,R.mipmap.tu3,R.mipmap.tu4,R.mipmap.tu5,R.mipmap.tu6
    ,R.mipmap.tu7,R.mipmap.tu8,R.mipmap.tu9,R.mipmap.tu10,R.mipmap.tu11);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal);
        ButterKnife.bind(this);
        initView();

        //监听ScrollListener 实现滑动时候上面图片的动态改变效果
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                View newView = recyclerView.getChildAt(0);
                if (newView != null && newView != mCurrentView){
                    mCurrentView = newView;
                    int childLayoutPosition = recyclerView.getChildLayoutPosition(mCurrentView);
                    showView(childLayoutPosition);
                }
            }
        });
    }

    private void initView() {
        imageView.setImageDrawable(getResources().getDrawable(mList.get(0)));
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new HorizontalAdapter(this, mList);
        adapter.setListener(this);
        recyclerView.setAdapter(adapter);
        mCurrentView = recyclerView.getChildAt(0);
    }

    @Override
    public void itemClick(int position) {
        showView(position);
    }

    private void showView(int position) {
        imageView.setImageDrawable(getResources().getDrawable(mList.get(position)));
    }
}
