package com.blink.academy.film.widgets.grids;

import android.content.Context;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.blink.academy.film.FilmApp;
import defpackage.AbstractC2502;
import defpackage.C4008;
import defpackage.C4792;

/* loaded from: classes.dex */
public class GridsItemView extends FrameLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC2502 f3224;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public TextPaint f3225;

    /* renamed from: ԭ, reason: contains not printable characters */
    public float f3226;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public float f3227;

    /* renamed from: ԯ, reason: contains not printable characters */
    public boolean f3228;

    public GridsItemView(@NonNull Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        float f = this.f3227;
        this.f3224.f9277.setPadding((int) (i * f), (int) (i2 * f), (int) (i3 * f), (int) (i4 * f));
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m3174() {
        this.f3224 = AbstractC2502.m9221(LayoutInflater.from(getContext()), this, true);
        this.f3227 = C4792.m14375().m14434();
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m3175(int i, float f) {
        this.f3224.f9278.m2562(i, f * this.f3227);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public void m3176(int i, float f) {
        this.f3226 = f;
        this.f3224.f9279.m2562(i, f * this.f3227);
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public void m3177(boolean z, int i) {
        this.f3228 = z;
        C4008.m12876(this.f3224.f9276, z ? 1.0f : 0.0f, i, null);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public void m3178(int i, int i2) {
        m3179(FilmApp.m402().getResources().getString(i), i2);
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public void m3179(String str, int i) {
        this.f3224.f9278.m2561(str);
        TextPaint paint = this.f3224.f9278.getPaint();
        float fMeasureText = paint.measureText(str) + C4792.f16138;
        ViewGroup.LayoutParams layoutParams = this.f3224.f9276.getLayoutParams();
        layoutParams.width = (int) Math.ceil(fMeasureText);
        layoutParams.height = C4792.m14375().m14467();
        this.f3224.f9276.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.f3224.f9278.getLayoutParams();
        layoutParams2.width = (int) fMeasureText;
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        layoutParams2.height = (int) (fontMetrics.bottom - fontMetrics.top);
        this.f3224.f9278.setLayoutParams(layoutParams2);
        this.f3225 = this.f3224.f9279.getPaint();
        String string = i == 0 ? "" : getResources().getString(i);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f3224.f9279.getLayoutParams();
        layoutParams3.width = (int) (this.f3225.measureText(string) + C4792.f16138);
        Paint.FontMetrics fontMetrics2 = this.f3225.getFontMetrics();
        layoutParams3.height = (int) ((fontMetrics2.bottom - fontMetrics2.top) + C4792.f16138);
        layoutParams3.bottomMargin = (int) ((C4792.m14375().m14477(29.0f, this.f3227) - (layoutParams3.height / 2.0f)) * 0.9f);
        this.f3224.f9279.setLayoutParams(layoutParams3);
        this.f3224.f9279.setText(string);
    }

    public GridsItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GridsItemView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m3174();
    }
}
