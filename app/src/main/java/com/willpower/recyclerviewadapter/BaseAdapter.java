package com.willpower.recyclerviewadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public abstract class BaseAdapter<VH extends BaseViewHolder, E> extends RecyclerView.Adapter<VH> {

    protected int layoutId;
    protected List<E> mData;
    protected Context mContext;

    public BaseAdapter(int layoutId) {
        this.layoutId = layoutId;
    }

    public BaseAdapter(int layoutId, List<E> mData) {
        this.layoutId = layoutId;
        this.mData = mData;
    }

    protected abstract VH createViewHolder(View view);

    protected abstract void bindViewHolder(@NonNull VH holder, E data, int position);

    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.mContext = parent.getContext();
        return createViewHolder(LayoutInflater.from(this.mContext).inflate(this.layoutId,
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        bindViewHolder(holder, mData.get(position), position);
    }

    @Override
    public int getItemCount() {
        return this.mData == null ? 0 : this.mData.size();
    }

    public E getData(int position) {
        return mData == null ? null : mData.get(position);
    }

    public void setNewData(List<E> mData) {
        if (mData == null) return;
        this.mData = mData;
        notifyDataSetChanged();
    }

    public void addData(E e) {
        if (this.mData == null) return;
        int count = this.mData.size();
        this.mData.add(count, e);
        notifyItemInserted(count);
    }

    public void updateData(int index, E e) {
        if (this.mData == null) return;
        this.mData.set(index, e);
        notifyItemChanged(index);
    }

    public void removeData(int index) {
        if (this.mData == null) return;
        this.mData.remove(index);
        notifyDataSetChanged();
    }

    public void removeData(E e) {
        if (this.mData == null) return;
        this.mData.remove(e);
        notifyDataSetChanged();
    }

}
