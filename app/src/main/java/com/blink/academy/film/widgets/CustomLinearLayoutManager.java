package com.blink.academy.film.widgets;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;

/* loaded from: classes.dex */
public class CustomLinearLayoutManager extends LinearLayoutManager {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public boolean f2066;

    public CustomLinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f2066 = true;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return this.f2066 && super.canScrollVertically();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return this.f2066 && super.canScrollVertically();
    }
}
