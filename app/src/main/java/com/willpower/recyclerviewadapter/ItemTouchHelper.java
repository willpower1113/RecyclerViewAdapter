package com.willpower.recyclerviewadapter;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

class ItemTouchHelper extends GestureDetector.SimpleOnGestureListener {

    RecyclerView recyclerView;
    OnItemClickListener listener;

    public ItemTouchHelper(RecyclerView recyclerView, OnItemClickListener listener) {
        this.recyclerView = recyclerView;
        this.listener = listener;
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
        if (child != null) {
            BaseViewHolder VH = (BaseViewHolder) recyclerView.getChildViewHolder(child);
            BaseAdapter adapter = (BaseAdapter) recyclerView.getAdapter();
            int position = VH.getAdapterPosition();
            this.listener.onItemClick(adapter, position);
            return true;
        }
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
        if (child != null) {
            BaseViewHolder VH = (BaseViewHolder) recyclerView.getChildViewHolder(child);
            BaseAdapter adapter = (BaseAdapter) recyclerView.getAdapter();
            int position = VH.getAdapterPosition();
            this.listener.onItemLongClick(adapter,position);
        }
    }


}