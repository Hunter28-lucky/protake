package com.blink.academy.film.widgets.beauty;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.blink.academy.film.FilmApp;
import defpackage.AbstractC2517;
import defpackage.C4792;

/* loaded from: classes.dex */
public class BeautyItemView extends FrameLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC2517 f2832;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f2833;

    public BeautyItemView(@NonNull Context context) {
        super(context);
        m2776();
    }

    public int getHalfLevelWidth() {
        return (int) (this.f2833 / 2.0f);
    }

    public void setBeautyLevel(String str) {
        this.f2832.f9335.setContentText(str);
    }

    public void setBeautyName(String str) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f2832.f9334.getLayoutParams();
        layoutParams.width = (int) (this.f2832.f9334.getPaint().measureText(str) + C4792.f16138);
        this.f2832.f9334.setLayoutParams(layoutParams);
        this.f2832.f9334.setText(str);
    }

    public void setImageRes(int i) {
        if (i != 0) {
            this.f2832.f9331.setImageResource(i);
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m2775() {
        this.f2832.f9335.m2548();
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final void m2776() {
        this.f2832 = AbstractC2517.m9306(LayoutInflater.from(getContext()), this, true);
        float fM14434 = C4792.m14375().m14434();
        this.f2832.f9334.m2562(0, C4792.m14375().m14398() * fM14434);
        this.f2832.f9334.setContentTypeFace(FilmApp.m404());
        this.f2832.f9334.setContentTextColor(-1);
        ViewGroup.LayoutParams layoutParams = this.f2832.f9331.getLayoutParams();
        int iM14476 = (int) (C4792.m14375().m14476(135) * fM14434);
        layoutParams.width = iM14476;
        layoutParams.height = iM14476;
        this.f2832.f9331.setLayoutParams(layoutParams);
        Paint paint = new Paint();
        paint.setTextSize(C4792.m14375().m14398());
        paint.setTypeface(FilmApp.m404());
        float fMeasureText = paint.measureText("10");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f2832.f9332.getLayoutParams();
        layoutParams2.leftMargin = (int) ((layoutParams.width / 2.0f) + C4792.m14375().m14476(75));
        layoutParams2.topMargin = (int) ((layoutParams.height / 2.0f) + C4792.m14375().m14476(5));
        layoutParams2.width = (int) ((fMeasureText + (C4792.m14375().m14476(15) * 2)) * fM14434);
        this.f2832.f9332.setLayoutParams(layoutParams2);
        this.f2833 = layoutParams2.width;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public void m2777() {
        this.f2832.f9335.m2551();
    }

    public BeautyItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m2776();
    }

    public BeautyItemView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2776();
    }
}
