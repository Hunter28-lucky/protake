package com.blink.academy.film.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import defpackage.AbstractC4864;
import defpackage.C4792;

/* loaded from: classes.dex */
public class TagView extends RelativeLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC4864 f2707;

    /* renamed from: com.blink.academy.film.widgets.TagView$Ϳ, reason: contains not printable characters */
    public class RunnableC0978 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ String f2708;

        public RunnableC0978(String str) {
            this.f2708 = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            float fMeasureText = TagView.this.f2707.f16460.getPaint().measureText(this.f2708);
            ViewGroup.LayoutParams layoutParams = TagView.this.f2707.f16460.getLayoutParams();
            layoutParams.width = (int) (fMeasureText + C4792.f16138);
            TagView.this.f2707.f16460.setLayoutParams(layoutParams);
        }
    }

    public TagView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public boolean performClick() {
        return super.performClick();
    }

    public void setContentMargin(int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f2707.f16460.getLayoutParams();
        layoutParams.topMargin = i;
        this.f2707.f16460.setLayoutParams(layoutParams);
    }

    public void setContentText(String str) {
        this.f2707.f16460.setText(str);
        this.f2707.f16460.post(new RunnableC0978(str));
    }

    public void setImageRes(int i) {
        this.f2707.f16459.setImageResource(i);
    }

    public void setTextColor(int i) {
        this.f2707.f16460.setContentTextColor(i);
    }

    public void setTextSize(int i) {
        this.f2707.f16460.m2562(0, i);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final void m2679() {
        this.f2707 = AbstractC4864.m14587(LayoutInflater.from(getContext()), this, true);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public void m2680(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.f2707.f16459.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        this.f2707.f16459.setLayoutParams(layoutParams);
    }

    public TagView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TagView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2679();
    }
}
