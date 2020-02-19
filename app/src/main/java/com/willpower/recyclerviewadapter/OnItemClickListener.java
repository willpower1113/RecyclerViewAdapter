package com.willpower.recyclerviewadapter;

import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.view.GestureDetectorCompat;
import androidx.recyclerview.widget.RecyclerView;


public abstract class OnItemClickListener<A extends BaseAdapter> implements RecyclerView.OnItemTouchListener {
    GestureDetectorCompat mGestureDetectorCompat;
    RecyclerView recyclerView;
    BaseAdapter baseAdapter;

    @Override
    public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent e) {
        if (this.recyclerView == null) {
            this.recyclerView = recyclerView;
            this.baseAdapter = (BaseAdapter) this.recyclerView.getAdapter();
            mGestureDetectorCompat = new GestureDetectorCompat(recyclerView.getContext()
                    , new ItemTouchHelper(recyclerView, this));
        } else if (this.recyclerView != recyclerView) {
            this.recyclerView = recyclerView;
            this.baseAdapter = (BaseAdapter) this.recyclerView.getAdapter();
            mGestureDetectorCompat = new GestureDetectorCompat(recyclerView.getContext()
                    , new ItemTouchHelper(recyclerView, this));
        }
        if (mGestureDetectorCompat != null)
            mGestureDetectorCompat.onTouchEvent(e);
        return false;
    }

    @Override
    public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
        if (mGestureDetectorCompat != null)
            mGestureDetectorCompat.onTouchEvent(e);
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
    }

    public abstract void onItemClick(A adapter, int position);

    public void onItemLongClick(A adapter,int position) {
    }


}
