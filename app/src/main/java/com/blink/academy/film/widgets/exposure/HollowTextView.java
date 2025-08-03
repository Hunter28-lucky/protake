package com.blink.academy.film.widgets.exposure;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.R$styleable;
import defpackage.r1;

/* loaded from: classes.dex */
public class HollowTextView extends View {

    /* renamed from: ԫ, reason: contains not printable characters */
    public Context f3162;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public String f3163;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f3164;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public int f3165;

    /* renamed from: ԯ, reason: contains not printable characters */
    public int f3166;

    /* renamed from: ՠ, reason: contains not printable characters */
    public boolean f3167;

    /* renamed from: ֈ, reason: contains not printable characters */
    public boolean f3168;

    /* renamed from: ֏, reason: contains not printable characters */
    public boolean f3169;

    /* renamed from: ׯ, reason: contains not printable characters */
    public boolean f3170;

    /* renamed from: ؠ, reason: contains not printable characters */
    public int f3171;

    /* renamed from: ހ, reason: contains not printable characters */
    public int f3172;

    /* renamed from: ށ, reason: contains not printable characters */
    public int f3173;

    /* renamed from: ނ, reason: contains not printable characters */
    public int f3174;

    /* renamed from: ރ, reason: contains not printable characters */
    public Paint f3175;

    /* renamed from: ބ, reason: contains not printable characters */
    public Paint f3176;

    /* renamed from: ޅ, reason: contains not printable characters */
    public Paint f3177;

    /* renamed from: ކ, reason: contains not printable characters */
    public Bitmap f3178;

    /* renamed from: އ, reason: contains not printable characters */
    public int f3179;

    /* renamed from: ވ, reason: contains not printable characters */
    public int f3180;

    /* renamed from: މ, reason: contains not printable characters */
    public Canvas f3181;

    /* renamed from: ފ, reason: contains not printable characters */
    public boolean f3182;

    public HollowTextView(Context context) {
        super(context);
        this.f3164 = 15;
        this.f3165 = -1711276033;
        this.f3166 = 0;
        this.f3167 = false;
        this.f3168 = false;
        this.f3169 = false;
        this.f3170 = false;
        this.f3171 = 0;
        this.f3172 = 0;
        this.f3173 = 0;
        this.f3174 = 0;
        this.f3182 = true;
        this.f3162 = context;
        m3161();
    }

    public String getText() {
        return this.f3163;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Log.d("HollowTextView", "----onDraw----");
        if (TextUtils.isEmpty(this.f3163)) {
            return;
        }
        m3159();
        canvas.drawBitmap(this.f3178, 0.0f, 0.0f, (Paint) null);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        this.f3179 = ((int) this.f3175.measureText(this.f3163)) + getPaddingLeft() + getPaddingRight();
        this.f3180 = this.f3164 + getPaddingTop() + getPaddingBottom();
        this.f3179 = m3162(this.f3179, i);
        int iM3162 = m3162(this.f3180, i2);
        this.f3180 = iM3162;
        setMeasuredDimension(this.f3179, iM3162);
        Log.d("HollowTextView", "----onMeasure---- the last width=" + this.f3179 + ", height=" + this.f3180);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Log.d("HollowTextView", "----onSizeChanged----[w=" + i + ",h=" + i2 + ",oldw=" + i3 + ",oldh=" + i4 + "]");
        if (i <= 0 || i2 <= 0) {
            return;
        }
        this.f3178 = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        this.f3181 = new Canvas(this.f3178);
    }

    public void setDrawText(boolean z) {
        this.f3182 = z;
    }

    public void setText(String str) {
        if (str == null || str.equals(this.f3163)) {
            return;
        }
        this.f3163 = str;
        requestLayout();
        invalidate();
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m3159() {
        Log.i("HollowTextView", "----drawContentBitmap----");
        if (TextUtils.isEmpty(this.f3163)) {
            return;
        }
        this.f3181.drawColor(0, PorterDuff.Mode.CLEAR);
        if (this.f3166 > 0) {
            RectF rectF = new RectF();
            rectF.left = 0.0f;
            rectF.top = 0.0f;
            rectF.right = this.f3179;
            rectF.bottom = this.f3180;
            Canvas canvas = this.f3181;
            int i = this.f3166;
            canvas.drawRoundRect(rectF, i, i, this.f3176);
            if (!this.f3167) {
                Canvas canvas2 = this.f3181;
                int i2 = this.f3166;
                canvas2.drawRect(0.0f, 0.0f, i2, i2, this.f3177);
            }
            if (!this.f3168) {
                this.f3181.drawRect(r0 - r2, 0.0f, this.f3179, this.f3166, this.f3177);
            }
            if (!this.f3169) {
                Canvas canvas3 = this.f3181;
                int i3 = this.f3180;
                canvas3.drawRect(0.0f, i3 - r3, this.f3166, i3, this.f3177);
            }
            if (!this.f3170) {
                Canvas canvas4 = this.f3181;
                int i4 = this.f3179;
                int i5 = this.f3166;
                canvas4.drawRect(i4 - i5, r4 - i5, i4, this.f3180, this.f3177);
            }
        } else {
            this.f3181.drawColor(this.f3165);
        }
        Paint.FontMetrics fontMetrics = this.f3175.getFontMetrics();
        float f = ((this.f3180 - (fontMetrics.ascent - fontMetrics.descent)) / 2.0f) - 3.0f;
        float fM3160 = (this.f3179 - m3160(this.f3175, this.f3163)) >> 1;
        if (this.f3182) {
            this.f3181.drawText(this.f3163, fM3160, f, this.f3175);
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public int m3160(Paint paint, String str) {
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
    public final void m3161() {
        Paint paint = new Paint();
        this.f3175 = paint;
        paint.setTextSize(this.f3164);
        this.f3175.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.f3175.setAntiAlias(true);
        this.f3175.setFakeBoldText(true);
        this.f3175.setTypeface(FilmApp.m404());
        this.f3175.setColor(Color.parseColor("#000000"));
        Paint paint2 = new Paint();
        this.f3176 = paint2;
        paint2.setColor(this.f3165);
        this.f3176.setAntiAlias(true);
        Paint paint3 = new Paint();
        this.f3177 = paint3;
        paint3.setColor(this.f3165);
        this.f3177.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final int m3162(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        return mode != Integer.MIN_VALUE ? mode != 1073741824 ? i : size : Math.min(i, size);
    }

    public HollowTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3164 = 15;
        this.f3165 = -1711276033;
        this.f3166 = 0;
        this.f3167 = false;
        this.f3168 = false;
        this.f3169 = false;
        this.f3170 = false;
        this.f3171 = 0;
        this.f3172 = 0;
        this.f3173 = 0;
        this.f3174 = 0;
        this.f3182 = true;
        this.f3162 = context;
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.HollowTextView, 0, 0);
        try {
            String string = typedArrayObtainStyledAttributes.getString(7);
            this.f3163 = string;
            if (r1.m8143(string)) {
                this.f3163 = this.f3163.toUpperCase();
            }
            this.f3164 = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, this.f3164);
            this.f3165 = typedArrayObtainStyledAttributes.getColor(0, this.f3165);
            this.f3166 = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, this.f3166);
            this.f3167 = typedArrayObtainStyledAttributes.getBoolean(5, false);
            this.f3168 = typedArrayObtainStyledAttributes.getBoolean(6, false);
            this.f3169 = typedArrayObtainStyledAttributes.getBoolean(3, false);
            this.f3170 = typedArrayObtainStyledAttributes.getBoolean(4, false);
            typedArrayObtainStyledAttributes.recycle();
            m3161();
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }
}
