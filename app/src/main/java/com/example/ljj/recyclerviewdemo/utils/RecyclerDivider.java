package com.example.ljj.recyclerviewdemo.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * 作者：ljj
 * 日期：2016/5/13 14:08
 */
public class RecyclerDivider extends RecyclerView.ItemDecoration{

    private int mOrigination;
    private Drawable mDivider;
    public static final int HOREZONTAL_LIST = LinearLayoutManager.HORIZONTAL;
    public static final int VERTIAL_LIST = LinearLayoutManager.VERTICAL;
    private final int[] ATTRS = new int[]{android.R.attr.listDivider};


    public RecyclerDivider(Context context,int orientation) {
        TypedArray a = context.obtainStyledAttributes(ATTRS);
        mDivider = a.getDrawable(0);
        a.recycle();
        setOrientation(orientation);
    }

    public void setOrientation(int orientation) {
        this.mOrigination = orientation;
        if (orientation != HOREZONTAL_LIST && orientation != VERTIAL_LIST){
            throw new IllegalArgumentException("invalid orientation");
        }
        mOrigination = orientation;
    }


    @Override
    public void onDraw(Canvas c, RecyclerView parent) {
        super.onDraw(c, parent);
        if (mOrigination == VERTIAL_LIST){
            drawVertical(c,parent);
        }else{
            drawHorizontal(c,parent);
        }
    }

    public void drawVertical(Canvas canvas, RecyclerView parents){
        final int left = parents.getPaddingLeft();
        final int right = parents.getWidth() - parents.getPaddingRight();
        int childCount = parents.getChildCount();
        for (int i = 0 ; i < childCount ; i++){
            View child = parents.getChildAt(i);
            RecyclerView recyclerView = new RecyclerView(parents.getContext());
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            int top = child.getBottom() + params.bottomMargin;
            int bottom = top + mDivider.getIntrinsicHeight();
            mDivider.setBounds(left,top,right,bottom);
            mDivider.draw(canvas);
        }
    }

    public void drawHorizontal(Canvas c, RecyclerView parent) {
        final int top = parent.getPaddingTop();
        final int bottom = parent.getHeight() - parent.getPaddingBottom();

        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View child = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                    .getLayoutParams();
            final int left = child.getRight() + params.rightMargin;
            final int right = left + mDivider.getIntrinsicHeight();
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }
    }

    @Override
    public void getItemOffsets(Rect outRect, int itemPosition, RecyclerView parent) {
        if (mOrigination == VERTIAL_LIST) {
            outRect.set(0, 0, 0, mDivider.getIntrinsicHeight());
        } else {
            outRect.set(0, 0, mDivider.getIntrinsicWidth(), 0);
        }
    }

}
