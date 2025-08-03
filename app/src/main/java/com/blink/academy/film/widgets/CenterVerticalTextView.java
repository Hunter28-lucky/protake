package com.blink.academy.film.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.R$styleable;
import defpackage.C2579;
import defpackage.r1;

/* loaded from: classes.dex */
public class CenterVerticalTextView extends View {

    /* renamed from: ԫ, reason: contains not printable characters */
    public Paint f2045;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public float f2046;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f2047;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public boolean f2048;

    /* renamed from: ԯ, reason: contains not printable characters */
    public String f2049;

    /* renamed from: ՠ, reason: contains not printable characters */
    public int f2050;

    /* renamed from: ֈ, reason: contains not printable characters */
    public int f2051;

    /* renamed from: ֏, reason: contains not printable characters */
    public Bitmap f2052;

    /* renamed from: ׯ, reason: contains not printable characters */
    public Canvas f2053;

    public CenterVerticalTextView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (TextUtils.isEmpty(this.f2049)) {
            return;
        }
        m2208();
        canvas.drawBitmap(this.f2052, 0.0f, 0.0f, (Paint) null);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        this.f2050 = ((int) this.f2045.measureText(this.f2049)) + getPaddingLeft() + getPaddingRight();
        this.f2051 = (int) (this.f2046 + getPaddingTop() + getPaddingBottom());
        this.f2050 = m2211(this.f2050, i);
        int iM2211 = m2211(this.f2051, i2);
        this.f2051 = iM2211;
        setMeasuredDimension(this.f2050, iM2211);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        this.f2052 = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        this.f2053 = new Canvas(this.f2052);
    }

    public void setText(String str) {
        if (str == null || str.equals(this.f2049)) {
            return;
        }
        this.f2049 = str;
        requestLayout();
        invalidate();
    }

    public void setTextColor(int i) {
        this.f2047 = i;
    }

    public void setTextSize(int i) {
        this.f2046 = i;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m2208() {
        if (TextUtils.isEmpty(this.f2049)) {
            return;
        }
        this.f2053.drawColor(0, PorterDuff.Mode.CLEAR);
        Paint.FontMetrics fontMetrics = this.f2045.getFontMetrics();
        this.f2053.drawText(this.f2049, (this.f2050 - m2209(this.f2045, this.f2049)) >> 1, ((this.f2051 - (fontMetrics.ascent - fontMetrics.descent)) / 2.0f) - 3.0f, this.f2045);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public int m2209(Paint paint, String str) {
        if (str == null || str.length() <= 0) {
            return 0;
        }
        int length = str.length();
        paint.getTextWidths(str, new float[length]);
        int iCeil = 0;
        for (int i = 0; i < length; i++) {
            iCeil += (int) Math.ceil(r2[i]);
        }
        return iCeil;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final void m2210() {
        Paint paint = new Paint();
        this.f2045 = paint;
        paint.setTextSize(this.f2046);
        this.f2045.setAntiAlias(true);
        this.f2045.setFakeBoldText(this.f2048);
        this.f2045.setTypeface(FilmApp.m404());
        this.f2045.setColor(this.f2047);
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final int m2211(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        return mode != Integer.MIN_VALUE ? mode != 1073741824 ? i : size : Math.min(i, size);
    }

    public CenterVerticalTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [android.content.res.TypedArray] */
    /* JADX WARN: Type inference failed for: r3v5, types: [boolean] */
    public CenterVerticalTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.HollowTextView, 0, 0);
        try {
            try {
                this.f2049 = typedArrayObtainStyledAttributes.getString(1);
                this.f2047 = typedArrayObtainStyledAttributes.getColor(2, -1);
                this.f2046 = typedArrayObtainStyledAttributes.getDimension(3, C2579.m9438(10.0f));
                this.f2048 = typedArrayObtainStyledAttributes.getBoolean(0, true);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            typedArrayObtainStyledAttributes.recycle();
            typedArrayObtainStyledAttributes = r1.m8143(this.f2049);
            if (typedArrayObtainStyledAttributes == 0) {
                this.f2049 = "";
            }
            m2210();
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }
}
