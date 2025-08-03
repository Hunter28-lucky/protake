package com.blink.academy.film.widgets.adapter.fps;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import com.blink.academy.protake.R;
import defpackage.AbstractC4728;
import defpackage.C4792;

/* loaded from: classes.dex */
public class ImageClickView extends FrameLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC4728 f2782;

    public ImageClickView(@NonNull Context context) {
        super(context);
        m2762();
    }

    public void setImageRes(int i) {
        this.f2782.f15994.setImageResource(i);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m2762() {
        this.f2782 = (AbstractC4728) DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.layout_image_click_view, this, true);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m2763(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f2782.f15994.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        layoutParams.topMargin = (int) (((C4792.m14375().m14405() - i2) / 2.0f) - C4792.m14375().m14476(20));
        this.f2782.f15994.setLayoutParams(layoutParams);
    }

    public ImageClickView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m2762();
    }

    public ImageClickView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2762();
    }
}
