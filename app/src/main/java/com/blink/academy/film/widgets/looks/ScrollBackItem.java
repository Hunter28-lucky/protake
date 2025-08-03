package com.blink.academy.film.widgets.looks;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public class ScrollBackItem extends ViewGroup {
    public ScrollBackItem(Context context) {
        super(context);
        m3859();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        return (action == 0 || action == 1 || action == 3) ? false : true;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m3859() {
    }

    public ScrollBackItem(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m3859();
    }

    public ScrollBackItem(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m3859();
    }
}
