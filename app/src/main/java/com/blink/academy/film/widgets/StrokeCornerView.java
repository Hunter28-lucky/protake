package com.blink.academy.film.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.blink.academy.film.FilmApp;
import defpackage.AbstractC4652;
import defpackage.C4008;
import defpackage.C4792;

/* loaded from: classes.dex */
public class StrokeCornerView extends FrameLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC4652 f2510;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public float f2511;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f2512;

    public StrokeCornerView(@NonNull Context context) {
        this(context, null);
    }

    public float getUpdateHeight() {
        return this.f2512;
    }

    public void setContentText(String str) {
        this.f2510.f15825.setText(str);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public int m2547(int i) {
        return C4792.m14375().m14476(i);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m2548() {
        C4008.m12877(this, 0.0f, 100, null);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final void m2549() {
        this.f2510 = AbstractC4652.m14133(LayoutInflater.from(getContext()), this, true);
        m2550();
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final void m2550() {
        this.f2511 = C4792.m14375().m14434();
        this.f2510.f15825.setTextSize(0, C4792.m14375().m14396() * this.f2511);
        this.f2510.f15825.setTypeface(FilmApp.m404());
        int iM2547 = (int) (m2547(15) * this.f2511);
        int iM25472 = (int) (m2547(4) * this.f2511);
        this.f2510.f15824.setPadding(iM2547, iM25472, iM2547, iM25472);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public void m2551() {
        C4008.m12877(this, 1.0f, 100, null);
    }

    public StrokeCornerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StrokeCornerView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2549();
    }
}
