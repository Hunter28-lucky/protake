package com.blink.academy.film.widgets.score;

import android.content.Context;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import com.google.android.gms.dynamite.descriptors.com.google.mlkit.dynamite.face.ModuleDescriptor;

/* loaded from: classes.dex */
class PartialView extends RelativeLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public ImageView f3898;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public ImageView f3899;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f3900;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public int f3901;

    public PartialView(Context context, int i, int i2, int i3, int i4) {
        super(context);
        this.f3900 = i2;
        this.f3901 = i3;
        setTag(Integer.valueOf(i));
        setPadding(i4, i4, i4, i4);
        m3893();
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m3893() {
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2, 1.0f));
        int i = this.f3900;
        if (i == 0) {
            i = -2;
        }
        int i2 = this.f3901;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i2 != 0 ? i2 : -2);
        layoutParams.addRule(13);
        ImageView imageView = new ImageView(getContext());
        this.f3898 = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.f3898, layoutParams);
        ImageView imageView2 = new ImageView(getContext());
        this.f3899 = imageView2;
        imageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.f3899, layoutParams);
        m3894();
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m3894() {
        this.f3898.setImageLevel(0);
        this.f3899.setImageLevel(ModuleDescriptor.MODULE_VERSION);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public void m3895(@NonNull Drawable drawable) {
        if (drawable.getConstantState() == null) {
            return;
        }
        this.f3899.setImageDrawable(new ClipDrawable(drawable.getConstantState().newDrawable(), GravityCompat.END, 1));
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public void m3896() {
        this.f3898.setImageLevel(ModuleDescriptor.MODULE_VERSION);
        this.f3899.setImageLevel(0);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public void m3897(@NonNull Drawable drawable) {
        if (drawable.getConstantState() == null) {
            return;
        }
        this.f3898.setImageDrawable(new ClipDrawable(drawable.getConstantState().newDrawable(), GravityCompat.START, 1));
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public void m3898(float f) {
        int i = (int) ((f % 1.0f) * 10000.0f);
        if (i == 0) {
            i = 10000;
        }
        this.f3898.setImageLevel(i);
        this.f3899.setImageLevel(ModuleDescriptor.MODULE_VERSION - i);
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public void m3899(@IntRange(from = 0) int i) {
        this.f3901 = i;
        ViewGroup.LayoutParams layoutParams = this.f3898.getLayoutParams();
        layoutParams.height = this.f3901;
        this.f3898.setLayoutParams(layoutParams);
        this.f3899.setLayoutParams(layoutParams);
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public void m3900(@IntRange(from = 0) int i) {
        this.f3900 = i;
        ViewGroup.LayoutParams layoutParams = this.f3898.getLayoutParams();
        layoutParams.width = this.f3900;
        this.f3898.setLayoutParams(layoutParams);
        this.f3899.setLayoutParams(layoutParams);
    }

    public PartialView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3900 = 0;
        this.f3901 = 0;
        m3893();
    }

    public PartialView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3900 = 0;
        this.f3901 = 0;
        m3893();
    }
}
