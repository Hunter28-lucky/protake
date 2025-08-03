package com.blink.academy.film.widgets.exposure;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import defpackage.C2579;
import defpackage.C4792;

/* loaded from: classes.dex */
public class TouchFocusView extends View {

    /* renamed from: ԫ, reason: contains not printable characters */
    public Paint f3216;

    public TouchFocusView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m3172() {
        Paint paint = new Paint(1);
        this.f3216 = paint;
        paint.setStrokeWidth(C2579.m9438(3.0f));
        this.f3216.setColor(C4792.m14375().m14431());
    }

    public TouchFocusView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TouchFocusView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m3172();
    }
}
