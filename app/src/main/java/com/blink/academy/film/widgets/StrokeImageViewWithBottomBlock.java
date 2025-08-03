package com.blink.academy.film.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import com.blink.academy.protake.R;
import defpackage.AbstractC4150;
import defpackage.C4008;
import defpackage.C4792;

/* loaded from: classes.dex */
public class StrokeImageViewWithBottomBlock extends FrameLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC4150 f2513;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public boolean f2514;

    public StrokeImageViewWithBottomBlock(@NonNull Context context) {
        this(context, null);
    }

    public void setBottomBlockHeight(int i) {
        ViewGroup.LayoutParams layoutParams = this.f2513.f14381.getLayoutParams();
        layoutParams.height = i;
        this.f2513.f14381.setLayoutParams(layoutParams);
    }

    public void setBottomBlockMargin(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f2513.f14381.getLayoutParams();
        layoutParams.topMargin = i;
        this.f2513.f14381.setLayoutParams(layoutParams);
    }

    public void setBottomStrokeColor(int i) {
        this.f2513.f14381.setStrokeColor(i);
    }

    public void setBottomStrokeWidth(int i) {
        this.f2513.f14381.setLineWidth(i);
    }

    public void setImageResBitmap(int i) {
        this.f2513.f14382.setImageResource(i);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m2552(Context context, AttributeSet attributeSet, int i) {
        this.f2513 = (AbstractC4150) DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.layout_image_bottom_block, this, true);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m2553(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.f2513.f14382.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        ViewGroup.LayoutParams layoutParams2 = this.f2513.f14381.getLayoutParams();
        layoutParams2.width = (int) Math.ceil(i);
        layoutParams2.height = C4792.m14375().m14404();
        this.f2513.f14381.setLayoutParams(layoutParams2);
        setBottomBlockMargin(5);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public void m2554(boolean z, int i) {
        this.f2514 = z;
        C4008.m12876(this.f2513.f14381, z ? 1.0f : 0.0f, i, null);
    }

    public StrokeImageViewWithBottomBlock(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StrokeImageViewWithBottomBlock(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2552(context, attributeSet, i);
    }
}
