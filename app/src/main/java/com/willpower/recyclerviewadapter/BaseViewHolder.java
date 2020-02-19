package com.willpower.recyclerviewadapter;

import android.view.View;

import java.util.LinkedHashSet;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public abstract class BaseViewHolder extends RecyclerView.ViewHolder {
    private final LinkedHashSet<Integer> childClickViewIds;
    private final LinkedHashSet<Integer> childLongClickViewIds;

    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
        this.childClickViewIds = new LinkedHashSet<>();
        this.childLongClickViewIds = new LinkedHashSet<>();
    }

    public boolean addOnClickListener(View view) {
        return this.childClickViewIds.add(view.getId());
    }

    public boolean addOnLongClickListener(View view) {
        return this.childLongClickViewIds.add(view.getId());
    }

    public LinkedHashSet<Integer> getChildClickViewIds() {
        return childClickViewIds;
    }

    public LinkedHashSet<Integer> getChildLongClickViewIds() {
        return childLongClickViewIds;
    }
}
