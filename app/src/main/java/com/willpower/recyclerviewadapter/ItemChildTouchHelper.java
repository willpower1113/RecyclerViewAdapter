package com.willpower.recyclerviewadapter;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import java.util.Set;

import androidx.recyclerview.widget.RecyclerView;

class ItemChildTouchHelper extends GestureDetector.SimpleOnGestureListener {

    RecyclerView recyclerView;
    OnItemChildClickListener listener;

    public ItemChildTouchHelper(RecyclerView recyclerView, OnItemChildClickListener listener) {
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
            Set<Integer> childClickViewIds = VH.getChildClickViewIds();
            for (Integer integer :
                    childClickViewIds) {
                View clickView = child.findViewById(integer);
                if (Helper.inRangeOfView(clickView, e)) {
                    this.listener.onItemChildClick(adapter, clickView, position);
                    return true;
                }
            }
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
            Set<Integer> childLongClickViewIds = VH.getChildLongClickViewIds();
            for (Integer integer :
                    childLongClickViewIds) {
                View clickView = child.findViewById(integer);
                if (Helper.inRangeOfView(clickView, e)) {
                    this.listener.onItemChildLongClick(adapter, clickView, position);
                    break;
                }
            }
        }
    }



}