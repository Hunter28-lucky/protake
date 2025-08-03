package com.blink.academy.film.widgets;

import android.content.Context;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.blink.academy.film.FilmApp;
import com.blink.academy.protake.R;
import defpackage.C4792;

/* loaded from: classes.dex */
public class StrokeTextGroup extends FrameLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public TextView f2531;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public TextView f2532;

    public StrokeTextGroup(@NonNull Context context) {
        this(context, null);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m2558(Context context, AttributeSet attributeSet, int i) {
        TextView textView = new TextView(context, attributeSet);
        this.f2531 = textView;
        TextPaint paint = textView.getPaint();
        paint.setStrokeWidth(C4792.f16138);
        paint.setStyle(Paint.Style.STROKE);
        this.f2531.setTextColor(getResources().getColor(R.color.border_text));
        this.f2531.setGravity(17);
        this.f2531.setTextSize(15.0f);
        this.f2531.setTypeface(FilmApp.m404());
        this.f2531.setText("400");
        addView(this.f2531);
        TextView textView2 = new TextView(context, attributeSet);
        this.f2532 = textView2;
        textView2.setTextColor(getResources().getColor(R.color.colorWhite));
        this.f2532.setGravity(17);
        this.f2532.setTextSize(15.0f);
        this.f2532.setText("400");
        this.f2532.setTypeface(FilmApp.m404());
        addView(this.f2532);
    }

    public StrokeTextGroup(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StrokeTextGroup(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2531 = null;
        m2558(context, attributeSet, i);
        setClipChildren(false);
        setClipToPadding(false);
    }
}
