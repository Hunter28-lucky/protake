package com.blink.academy.film.widgets.adapter.layout_manager;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class AutoLineFeedLayoutManager extends RecyclerView.LayoutManager {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public boolean f2783 = false;

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean isAutoMeasureEnabled() {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        detachAndScrapAttachedViews(recycler);
        int width = getWidth();
        this.f2783 = false;
        int i = 0;
        int iMax = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < getItemCount(); i3++) {
            View viewForPosition = recycler.getViewForPosition(i3);
            addView(viewForPosition);
            measureChildWithMargins(viewForPosition, 0, 0);
            int decoratedMeasuredWidth = getDecoratedMeasuredWidth(viewForPosition);
            int decoratedMeasuredHeight = getDecoratedMeasuredHeight(viewForPosition);
            int i4 = i + decoratedMeasuredWidth;
            if (i4 <= width) {
                layoutDecorated(viewForPosition, i4 - decoratedMeasuredWidth, i2, i4, i2 + decoratedMeasuredHeight);
                iMax = Math.max(iMax, decoratedMeasuredHeight);
                i = i4;
            } else {
                if (iMax == 0) {
                    iMax = decoratedMeasuredHeight;
                }
                i2 += iMax;
                layoutDecorated(viewForPosition, 0, i2, decoratedMeasuredWidth, i2 + decoratedMeasuredHeight);
                this.f2783 = true;
                i = decoratedMeasuredWidth;
                iMax = decoratedMeasuredHeight;
            }
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public boolean m2764() {
        return this.f2783;
    }
}
