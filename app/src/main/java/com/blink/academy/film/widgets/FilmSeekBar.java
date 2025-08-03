package com.blink.academy.film.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.blink.academy.film.R$styleable;
import defpackage.C2579;
import defpackage.C3947;
import defpackage.C4638;
import defpackage.C4792;

/* loaded from: classes.dex */
public class FilmSeekBar extends View {

    /* renamed from: ޖ, reason: contains not printable characters */
    public static final String f2164 = FilmSeekBar.class.getSimpleName();

    /* renamed from: ԫ, reason: contains not printable characters */
    public Paint f2165;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public Paint f2166;

    /* renamed from: ԭ, reason: contains not printable characters */
    public boolean f2167;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public Paint f2168;

    /* renamed from: ԯ, reason: contains not printable characters */
    public Paint f2169;

    /* renamed from: ՠ, reason: contains not printable characters */
    public Paint f2170;

    /* renamed from: ֈ, reason: contains not printable characters */
    public Paint f2171;

    /* renamed from: ֏, reason: contains not printable characters */
    public int f2172;

    /* renamed from: ׯ, reason: contains not printable characters */
    public float f2173;

    /* renamed from: ؠ, reason: contains not printable characters */
    public float f2174;

    /* renamed from: ހ, reason: contains not printable characters */
    public float f2175;

    /* renamed from: ށ, reason: contains not printable characters */
    public int f2176;

    /* renamed from: ނ, reason: contains not printable characters */
    public int f2177;

    /* renamed from: ރ, reason: contains not printable characters */
    public int f2178;

    /* renamed from: ބ, reason: contains not printable characters */
    public int f2179;

    /* renamed from: ޅ, reason: contains not printable characters */
    public float f2180;

    /* renamed from: ކ, reason: contains not printable characters */
    public boolean f2181;

    /* renamed from: އ, reason: contains not printable characters */
    public boolean f2182;

    /* renamed from: ވ, reason: contains not printable characters */
    public View.OnTouchListener f2183;

    /* renamed from: މ, reason: contains not printable characters */
    public float f2184;

    /* renamed from: ފ, reason: contains not printable characters */
    public float f2185;

    /* renamed from: ދ, reason: contains not printable characters */
    public float f2186;

    /* renamed from: ތ, reason: contains not printable characters */
    public boolean f2187;

    /* renamed from: ލ, reason: contains not printable characters */
    public float f2188;

    /* renamed from: ގ, reason: contains not printable characters */
    public int f2189;

    /* renamed from: ޏ, reason: contains not printable characters */
    public float f2190;

    /* renamed from: ސ, reason: contains not printable characters */
    public float f2191;

    /* renamed from: ޑ, reason: contains not printable characters */
    public RectF f2192;

    /* renamed from: ޒ, reason: contains not printable characters */
    public float f2193;

    /* renamed from: ޓ, reason: contains not printable characters */
    public float f2194;

    /* renamed from: ޔ, reason: contains not printable characters */
    public InterfaceC0896 f2195;

    /* renamed from: ޕ, reason: contains not printable characters */
    public InterfaceC0897 f2196;

    /* renamed from: com.blink.academy.film.widgets.FilmSeekBar$Ϳ, reason: contains not printable characters */
    public class ViewOnTouchListenerC0895 implements View.OnTouchListener {
        public ViewOnTouchListenerC0895() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (!FilmSeekBar.this.f2181 || !FilmSeekBar.this.isEnabled()) {
                return false;
            }
            int action = motionEvent.getAction();
            if (action == 0) {
                if (FilmSeekBar.this.f2196 != null) {
                    FilmSeekBar.this.f2196.mo2146();
                }
                FilmSeekBar.this.m2306(motionEvent);
            } else if (action == 1) {
                if (FilmSeekBar.this.f2182) {
                    FilmSeekBar.this.m2307(motionEvent);
                    FilmSeekBar.this.m2305();
                    FilmSeekBar.this.setPressed(false);
                }
                if (FilmSeekBar.this.f2196 != null) {
                    FilmSeekBar.this.f2196.mo2145();
                }
            } else if (action == 2 && FilmSeekBar.this.f2182) {
                FilmSeekBar.this.m2307(motionEvent);
            }
            return true;
        }
    }

    /* renamed from: com.blink.academy.film.widgets.FilmSeekBar$Ԩ, reason: contains not printable characters */
    public interface InterfaceC0896 {
        /* renamed from: Ϳ */
        void mo1561(float f, float f2);
    }

    /* renamed from: com.blink.academy.film.widgets.FilmSeekBar$Ԫ, reason: contains not printable characters */
    public interface InterfaceC0897 {
        /* renamed from: Ϳ */
        void mo2145();

        /* renamed from: Ԩ */
        void mo2146();
    }

    public FilmSeekBar(Context context) {
        this(context, null);
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public static int m2298(TypedArray typedArray, int i, int i2) {
        return typedArray == null ? i2 : typedArray.getColor(i, i2);
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public static float m2299(TypedArray typedArray, int i, float f) {
        return typedArray == null ? f : typedArray.getFloat(i, f);
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public static int m2300(TypedArray typedArray, int i, int i2) {
        return typedArray == null ? i2 : typedArray.getInt(i, i2);
    }

    public float getMax() {
        return this.f2193;
    }

    public float getMin() {
        return this.f2194;
    }

    public float getPro() {
        return this.f2185;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.f2167) {
            canvas.drawCircle(this.f2173, this.f2174, this.f2175, this.f2171);
        }
        if (this.f2187 && !this.f2167) {
            int i = this.f2189;
            float f = this.f2191;
            float f2 = this.f2174;
            float f3 = this.f2188;
            canvas.drawRect((i / 2.0f) - f, f2 - f3, (i / 2.0f) + f, f2 + f3, this.f2165);
        }
        RectF rectF = this.f2192;
        float f4 = this.f2175;
        rectF.left = f4;
        rectF.right = this.f2189 - f4;
        float f5 = this.f2174;
        int i2 = this.f2176;
        rectF.top = f5 - (i2 * 0.5f);
        rectF.bottom = f5 + (i2 * 0.5f);
        float f6 = i2 * 0.5f;
        float f7 = i2 * 0.5f;
        canvas.drawRoundRect(rectF, f6, f7, this.f2168);
        if (!this.f2167) {
            canvas.drawRoundRect(this.f2192, f6, f7, this.f2169);
        }
        if (this.f2187) {
            int i3 = this.f2189;
            float f8 = this.f2190;
            float f9 = this.f2174;
            float f10 = this.f2188;
            canvas.drawRect((i3 / 2.0f) - (f8 / 2.0f), (f9 - f10) + 1.0f, (i3 / 2.0f) + (f8 / 2.0f), (f9 + f10) - 1.0f, this.f2166);
        }
        canvas.drawCircle(this.f2173, this.f2174, this.f2175 - this.f2180, this.f2170);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f2189 = i;
        float f = this.f2175;
        this.f2172 = (int) ((i - (f * 2.0f)) - (this.f2179 * 2));
        this.f2174 = (i2 * 1.0f) / 2.0f;
        this.f2188 = f * 0.8f;
        invalidate();
    }

    public void setCircleRadius(int i) {
        this.f2175 = i;
    }

    public void setClearStroke(boolean z) {
        this.f2167 = z;
    }

    public void setLineWidth(int i) {
        this.f2176 = i;
    }

    public void setMax(float f) {
        this.f2193 = f;
    }

    public void setMin(float f) {
        this.f2194 = f;
    }

    public void setOnProChange(InterfaceC0896 interfaceC0896) {
        this.f2195 = interfaceC0896;
    }

    public void setOnTouchStateChange(InterfaceC0897 interfaceC0897) {
        this.f2196 = interfaceC0897;
    }

    public void setPaintAlpha(float f) {
        int i = (int) (f * 255.0f);
        this.f2168.setAlpha(i);
        this.f2169.setAlpha(i);
        this.f2170.setAlpha(i);
        this.f2171.setAlpha(i);
        invalidate();
    }

    public void setShowCenterLine(boolean z) {
        this.f2187 = z;
        postInvalidate();
    }

    public void setValueAndUpdateUI(float f) {
        float max = getMax() - getMin();
        if (f < getMin()) {
            f = getMin();
        }
        this.f2186 = f;
        float min = ((f - getMin()) * 1.0f) / max;
        this.f2185 = min;
        this.f2173 = this.f2175 + this.f2179 + (min * this.f2172);
        invalidate();
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final void m2301() {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final void m2302(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = attributeSet != null ? context.obtainStyledAttributes(attributeSet, R$styleable.FilmSeekBar) : null;
        this.f2175 = C2579.m9438(m2299(typedArrayObtainStyledAttributes, 1, 10.0f));
        this.f2176 = C2579.m9438(m2300(typedArrayObtainStyledAttributes, 4, 2));
        this.f2175 = C4792.m14375().m14476(35);
        this.f2176 = C4792.m14375().m14476(7);
        this.f2178 = m2298(typedArrayObtainStyledAttributes, 3, Color.parseColor("#ffffff"));
        this.f2177 = m2298(typedArrayObtainStyledAttributes, 0, Color.parseColor("#ffffff"));
        this.f2179 = C2579.m9438(m2300(typedArrayObtainStyledAttributes, 2, 2));
        if (typedArrayObtainStyledAttributes != null) {
            typedArrayObtainStyledAttributes.recycle();
        }
        this.f2168 = new Paint(1);
        this.f2169 = new Paint(1);
        this.f2171 = new Paint(1);
        this.f2170 = new Paint(1);
        this.f2170.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        this.f2169.setStyle(Paint.Style.STROKE);
        this.f2171.setStyle(Paint.Style.STROKE);
        this.f2168.setColor(this.f2178);
        this.f2169.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.f2171.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.f2170.setColor(this.f2177);
        this.f2168.setStrokeWidth(this.f2176);
        this.f2168.setStrokeCap(Paint.Cap.ROUND);
        this.f2168.setStrokeJoin(Paint.Join.ROUND);
        float fM14443 = C4792.m14375().m14443();
        this.f2180 = fM14443;
        this.f2169.setStrokeWidth(fM14443);
        this.f2171.setStrokeWidth(this.f2180);
        this.f2173 = this.f2175 + this.f2179;
        setOnTouchListener(this.f2183);
        this.f2165 = new Paint();
        float fM144432 = C4792.m14375().m14443();
        this.f2191 = fM144432;
        this.f2165.setStrokeWidth(fM144432);
        this.f2165.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.f2165.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f2165.setStrokeCap(Paint.Cap.SQUARE);
        this.f2166 = new Paint();
        float fM144433 = C4792.m14375().m14443();
        this.f2190 = fM144433;
        this.f2166.setStrokeWidth(fM144433);
        this.f2166.setColor(-1);
        this.f2166.setStyle(Paint.Style.FILL);
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public boolean m2303() {
        return this.f2182;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public void m2304() {
        this.f2182 = true;
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public void m2305() {
        this.f2182 = false;
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public final void m2306(MotionEvent motionEvent) {
        setPressed(true);
        m2304();
        m2307(motionEvent);
        m2301();
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public final void m2307(MotionEvent motionEvent) {
        float f;
        int iRound = Math.round(motionEvent.getX());
        Math.round(motionEvent.getY());
        int width = getWidth();
        int i = this.f2172;
        float f2 = iRound;
        int i2 = this.f2179;
        float f3 = this.f2175;
        float f4 = 0.0f;
        if (f2 < i2 + f3) {
            f = 0.0f;
        } else if (f2 > (width - i2) - f3) {
            f = 1.0f;
        } else {
            f4 = this.f2184;
            f = ((iRound - i2) - f3) / i;
        }
        float max = getMax() - getMin();
        float fRound = Math.round(f4 + (f * max) + getMin());
        if (this.f2186 != fRound) {
            this.f2186 = fRound;
            float min = ((fRound - getMin()) * 1.0f) / max;
            this.f2185 = min;
            this.f2173 = this.f2175 + this.f2179 + (min * i);
            if (C3947.f13602) {
                C4638.m14099(f2164, "mPro:" + this.f2185 + " mProgress:" + this.f2186);
            }
            InterfaceC0896 interfaceC0896 = this.f2195;
            if (interfaceC0896 != null) {
                interfaceC0896.mo1561(this.f2185, this.f2186);
            }
            invalidate();
        }
    }

    public FilmSeekBar(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FilmSeekBar(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2181 = true;
        this.f2183 = new ViewOnTouchListenerC0895();
        this.f2184 = 0.0f;
        this.f2192 = new RectF();
        m2302(context, attributeSet);
    }
}
