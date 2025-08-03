package com.blink.academy.film.widgets.exposure;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.blink.academy.protake.R;
import defpackage.C2579;

/* loaded from: classes.dex */
public class SlideBarView extends View {

    /* renamed from: ԫ, reason: contains not printable characters */
    public Paint f3183;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public Paint f3184;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f3185;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public int f3186;

    /* renamed from: ԯ, reason: contains not printable characters */
    public int f3187;

    /* renamed from: ՠ, reason: contains not printable characters */
    public int f3188;

    /* renamed from: ֈ, reason: contains not printable characters */
    public int f3189;

    /* renamed from: ֏, reason: contains not printable characters */
    public int f3190;

    /* renamed from: ׯ, reason: contains not printable characters */
    public int f3191;

    /* renamed from: ؠ, reason: contains not printable characters */
    public int f3192;

    /* renamed from: ހ, reason: contains not printable characters */
    public int f3193;

    /* renamed from: ށ, reason: contains not printable characters */
    public int f3194;

    /* renamed from: ނ, reason: contains not printable characters */
    public int f3195;

    /* renamed from: ރ, reason: contains not printable characters */
    public Bitmap f3196;

    /* renamed from: ބ, reason: contains not printable characters */
    public float[] f3197;

    /* renamed from: ޅ, reason: contains not printable characters */
    public int f3198;

    /* renamed from: ކ, reason: contains not printable characters */
    public float f3199;

    /* renamed from: އ, reason: contains not printable characters */
    public int f3200;

    /* renamed from: ވ, reason: contains not printable characters */
    public int f3201;

    /* renamed from: މ, reason: contains not printable characters */
    public int f3202;

    /* renamed from: ފ, reason: contains not printable characters */
    public int f3203;

    /* renamed from: ދ, reason: contains not printable characters */
    public int f3204;

    /* renamed from: ތ, reason: contains not printable characters */
    public int f3205;

    /* renamed from: ލ, reason: contains not printable characters */
    public float f3206;

    /* renamed from: ގ, reason: contains not printable characters */
    public float f3207;

    /* renamed from: ޏ, reason: contains not printable characters */
    public InterfaceC1144 f3208;

    /* renamed from: ސ, reason: contains not printable characters */
    public Rect f3209;

    /* renamed from: ޑ, reason: contains not printable characters */
    public Rect f3210;

    /* renamed from: ޒ, reason: contains not printable characters */
    public float f3211;

    /* renamed from: ޓ, reason: contains not printable characters */
    public float f3212;

    /* renamed from: ޔ, reason: contains not printable characters */
    public boolean f3213;

    /* renamed from: ޕ, reason: contains not printable characters */
    public boolean f3214;

    /* renamed from: ޖ, reason: contains not printable characters */
    public float f3215;

    /* renamed from: com.blink.academy.film.widgets.exposure.SlideBarView$Ϳ, reason: contains not printable characters */
    public interface InterfaceC1144 {
        /* renamed from: Ϳ, reason: contains not printable characters */
        void mo3171(float f);
    }

    public SlideBarView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f3200 == 0 || this.f3201 == 0 || !this.f3213) {
            return;
        }
        if (this.f3214) {
            m3164(canvas);
        }
        m3163(canvas);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.f3200 == 0) {
            this.f3200 = i;
            this.f3201 = i2;
            int i5 = (int) ((i2 * 13.0f) / 15.0f);
            this.f3185 = i5;
            int i6 = i2 / 2;
            this.f3202 = i;
            this.f3203 = i;
            this.f3198 = 0;
            float f = i2 / 2.0f;
            this.f3211 = f;
            int i7 = (int) (i * (((this.f3215 - 1.0f) * 0.5f) + 1.0f));
            Rect rect = this.f3210;
            int i8 = (i - i7) / 2;
            rect.left = i8;
            rect.right = i8 + i7;
            int i9 = (int) (f - (i7 / 2));
            rect.top = i9;
            rect.bottom = i9 + i7;
            int i10 = this.f3186;
            int i11 = (i / 2) - (i10 / 2);
            this.f3188 = i11;
            int i12 = i10 + i11;
            this.f3190 = i12;
            this.f3192 = i11;
            this.f3194 = i12;
            int i13 = i6 - (i5 / 2);
            this.f3189 = i13;
            int i14 = i5 + i13;
            this.f3195 = i14;
            int i15 = this.f3187;
            this.f3191 = i9 - i15;
            this.f3193 = i7 + i9 + i15;
            int i16 = i13 - (i / 2);
            this.f3204 = i16;
            this.f3205 = i14 - (i / 2);
            float f2 = i16 + (i / 2.0f);
            this.f3207 = f2;
            float f3 = i9 + ((r3 - i9) / 2.0f);
            this.f3211 = f3;
            this.f3206 = (f3 - f2) + f3;
            this.f3199 = f3;
        }
    }

    public void setCallBack(InterfaceC1144 interfaceC1144) {
        this.f3208 = interfaceC1144;
    }

    public void setNeedDrawIcon(boolean z) {
        this.f3213 = z;
        postInvalidate();
    }

    public void setNeedDrawLine(boolean z) {
        this.f3214 = z;
        invalidate();
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m3163(Canvas canvas) {
        canvas.drawBitmap(this.f3196, this.f3209, this.f3210, this.f3183);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final void m3164(Canvas canvas) {
        int i = this.f3191;
        int i2 = this.f3189;
        if (i > i2) {
            canvas.drawRect(this.f3188, i2, this.f3190, i, this.f3184);
        }
        int i3 = this.f3195;
        int i4 = this.f3193;
        if (i3 > i4) {
            canvas.drawRect(this.f3192, i4, this.f3194, i3, this.f3184);
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final void m3165() {
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.icon_30_exposure_slider_sun);
        this.f3196 = bitmapDecodeResource;
        Rect rect = this.f3209;
        rect.left = 0;
        rect.right = bitmapDecodeResource.getWidth();
        Rect rect2 = this.f3209;
        rect2.top = 0;
        rect2.bottom = this.f3196.getHeight();
        Paint paint = new Paint(3);
        this.f3183 = paint;
        paint.setColorFilter(new ColorMatrixColorFilter(this.f3197));
        Paint paint2 = new Paint(3);
        this.f3184 = paint2;
        paint2.setColorFilter(new ColorMatrixColorFilter(this.f3197));
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public void m3166() {
        this.f3212 = this.f3210.top + ((r0.bottom - r1) / 2.0f);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public boolean m3167() {
        return this.f3214;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public void m3168(float f, boolean z, float f2) {
        float f3 = this.f3212 + f;
        this.f3199 = f3;
        float f4 = this.f3207;
        if (f3 <= f4) {
            this.f3199 = f4;
        }
        float f5 = this.f3199;
        float f6 = this.f3206;
        if (f5 >= f6) {
            this.f3199 = f6;
        }
        float f7 = ((this.f3199 - f4) * 1.0f) / (f6 - f4);
        if (f2 != -1.0f) {
            this.f3199 = f4 + ((f6 - f4) * f2);
        } else {
            f2 = f7;
        }
        int i = this.f3200;
        int i2 = (int) (i * (((this.f3215 - 1.0f) * f2) + 1.0f));
        Rect rect = this.f3210;
        int i3 = (i - i2) / 2;
        rect.left = i3;
        rect.right = i3 + i2;
        int i4 = (int) (this.f3199 - (i2 / 2.0f));
        rect.top = i4;
        rect.bottom = i4 + i2;
        float f8 = (-(f2 - 0.5f)) * 2.0f;
        int i5 = this.f3187;
        this.f3191 = i4 - i5;
        this.f3193 = i4 + i2 + i5;
        InterfaceC1144 interfaceC1144 = this.f3208;
        if (interfaceC1144 != null && z) {
            interfaceC1144.mo3171(f8);
        }
        postInvalidate();
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public void m3169() {
        this.f3214 = false;
        float f = this.f3211;
        this.f3199 = f;
        int i = this.f3200;
        int i2 = (int) (i * (((this.f3215 - 1.0f) * 0.5f) + 1.0f));
        Rect rect = this.f3210;
        int i3 = (i - i2) / 2;
        rect.left = i3;
        rect.right = i3 + i2;
        int i4 = (int) (f - (i2 / 2.0f));
        rect.top = i4;
        rect.bottom = i4 + i2;
        int i5 = this.f3187;
        this.f3191 = i4 - i5;
        this.f3193 = i4 + i2 + i5;
        postInvalidate();
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public void m3170(int i) {
        this.f3184.setAlpha(i);
        invalidate();
    }

    public SlideBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlideBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3186 = C2579.m9438(1.0f);
        this.f3187 = C2579.m9438(4.0f);
        this.f3188 = 0;
        this.f3189 = 0;
        this.f3190 = 0;
        this.f3191 = 0;
        this.f3192 = 0;
        this.f3193 = 0;
        this.f3194 = 0;
        this.f3195 = 0;
        this.f3197 = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 255.0f, 0.0f, 1.0f, 0.0f, 0.0f, 186.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f};
        this.f3198 = 0;
        this.f3199 = 0.0f;
        this.f3209 = new Rect();
        this.f3210 = new Rect();
        this.f3213 = true;
        this.f3215 = 0.7f;
        m3165();
    }
}
