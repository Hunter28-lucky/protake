package com.blink.academy.film.widgets.audio;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView;
import androidx.core.view.ViewCompat;
import defpackage.C3844;
import defpackage.C4740;

/* loaded from: classes.dex */
public class AudioSchedulePortraitView extends TextureView implements TextureView.SurfaceTextureListener {

    /* renamed from: ޖ, reason: contains not printable characters */
    public static final int f2784;

    /* renamed from: ޗ, reason: contains not printable characters */
    public static final int f2785;

    /* renamed from: ޘ, reason: contains not printable characters */
    public static final int f2786;

    /* renamed from: ޙ, reason: contains not printable characters */
    public static final float[] f2787;

    /* renamed from: ޚ, reason: contains not printable characters */
    public static final int[] f2788;

    /* renamed from: ޛ, reason: contains not printable characters */
    public static final C4740 f2789;

    /* renamed from: ԫ, reason: contains not printable characters */
    public LinearGradient f2790;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public LinearGradient f2791;

    /* renamed from: ԭ, reason: contains not printable characters */
    public boolean f2792;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public RectF f2793;

    /* renamed from: ԯ, reason: contains not printable characters */
    public RectF f2794;

    /* renamed from: ՠ, reason: contains not printable characters */
    public RectF f2795;

    /* renamed from: ֈ, reason: contains not printable characters */
    public Paint f2796;

    /* renamed from: ֏, reason: contains not printable characters */
    public Paint f2797;

    /* renamed from: ׯ, reason: contains not printable characters */
    public RectF f2798;

    /* renamed from: ؠ, reason: contains not printable characters */
    public RectF f2799;

    /* renamed from: ހ, reason: contains not printable characters */
    public RectF f2800;

    /* renamed from: ށ, reason: contains not printable characters */
    public float f2801;

    /* renamed from: ނ, reason: contains not printable characters */
    public float f2802;

    /* renamed from: ރ, reason: contains not printable characters */
    public int f2803;

    /* renamed from: ބ, reason: contains not printable characters */
    public int f2804;

    /* renamed from: ޅ, reason: contains not printable characters */
    public int f2805;

    /* renamed from: ކ, reason: contains not printable characters */
    public int f2806;

    /* renamed from: އ, reason: contains not printable characters */
    public float f2807;

    /* renamed from: ވ, reason: contains not printable characters */
    public int f2808;

    /* renamed from: މ, reason: contains not printable characters */
    public Paint f2809;

    /* renamed from: ފ, reason: contains not printable characters */
    public boolean f2810;

    /* renamed from: ދ, reason: contains not printable characters */
    public float f2811;

    /* renamed from: ތ, reason: contains not printable characters */
    public float f2812;

    /* renamed from: ލ, reason: contains not printable characters */
    public float f2813;

    /* renamed from: ގ, reason: contains not printable characters */
    public float f2814;

    /* renamed from: ޏ, reason: contains not printable characters */
    public int f2815;

    /* renamed from: ސ, reason: contains not printable characters */
    public float f2816;

    /* renamed from: ޑ, reason: contains not printable characters */
    public float f2817;

    /* renamed from: ޒ, reason: contains not printable characters */
    public float f2818;

    /* renamed from: ޓ, reason: contains not printable characters */
    public int f2819;

    /* renamed from: ޔ, reason: contains not printable characters */
    public float f2820;

    /* renamed from: ޕ, reason: contains not printable characters */
    public final double f2821;

    static {
        int iArgb = Color.argb(255, 255, 251, 114);
        f2784 = iArgb;
        int iArgb2 = Color.argb(255, 176, 58, 67);
        f2785 = iArgb2;
        int iArgb3 = Color.argb(255, 34, 201, 137);
        f2786 = iArgb3;
        float[] fArr = {0.0f, 0.29f, 0.56f, 0.82f, 1.0f};
        f2787 = fArr;
        int[] iArr = {iArgb3, C3844.m12260(iArgb3, 0.5f, iArgb), iArgb, C3844.m12260(iArgb, 0.5f, iArgb2), iArgb2};
        f2788 = iArr;
        f2789 = new C4740(iArr, fArr);
    }

    public AudioSchedulePortraitView(Context context) {
        this(context, null);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        Canvas canvasLockCanvas = null;
        try {
            canvasLockCanvas = lockCanvas(null);
            synchronized (surfaceTexture) {
                draw(canvasLockCanvas);
            }
        } catch (Exception e2) {
            try {
                e2.printStackTrace();
                if (canvasLockCanvas != null) {
                    unlockCanvasAndPost(canvasLockCanvas);
                }
            } finally {
                if (canvasLockCanvas != null) {
                    unlockCanvasAndPost(canvasLockCanvas);
                }
            }
        }
        m2770(0.0f, 0.0f, false);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m2765(float f, float f2) {
        if (f == -1.0f && f2 == -1.0f) {
            this.f2811 = 0.0f;
            this.f2815 = 0;
            this.f2814 = 0.0f;
            this.f2816 = 0.0f;
            this.f2813 = 0.0f;
            this.f2812 = 0.0f;
            this.f2819 = 0;
            this.f2818 = 0.0f;
            this.f2820 = 0.0f;
            this.f2817 = 0.0f;
            this.f2807 = 0.0f;
            return;
        }
        float f3 = this.f2811;
        float f4 = f3 + ((f - f3) / 5.0f);
        this.f2811 = f4;
        if (f4 <= 0.0f) {
            f4 = 1.0E-4f;
        }
        float fMax = Math.max(0.0f, ((float) (Math.log10(f4 * this.f2821) * 20.0d)) / 60.0f);
        this.f2814 = fMax;
        int i = this.f2815 - 1;
        this.f2815 = i;
        float f5 = this.f2813;
        if (fMax > f5) {
            this.f2816 = this.f2811;
            this.f2813 = fMax;
            this.f2815 = 25;
        } else if (i < 0) {
            this.f2813 = f5 + ((fMax - f5) / 20.0f);
            float f6 = this.f2816;
            this.f2816 = f6 + ((this.f2811 - f6) / 8.0f);
        }
        float f7 = this.f2812;
        float f8 = f7 + ((f2 - f7) / 5.0f);
        this.f2812 = f8;
        if (f8 <= 0.0f) {
            f8 = 1.0E-4f;
        }
        float fMax2 = Math.max(0.0f, ((float) (Math.log10(f8 * this.f2821) * 20.0d)) / 60.0f);
        this.f2818 = fMax2;
        int i2 = this.f2819 - 1;
        this.f2819 = i2;
        float f9 = this.f2817;
        if (fMax2 > f9) {
            this.f2820 = this.f2812;
            this.f2817 = fMax2;
            this.f2819 = 25;
        } else if (i2 < 0) {
            this.f2817 = f9 + ((fMax2 - f9) / 20.0f);
            float f10 = this.f2820;
            this.f2820 = f10 + ((this.f2812 - f10) / 8.0f);
        }
        this.f2807 = ((float) (Math.log10((Math.max(this.f2816, this.f2820) > 0.0f ? r13 : 1.0E-4f) * this.f2821) * 20.0d)) - 60.0f;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final void m2766(Canvas canvas, Paint paint, RectF rectF, RectF rectF2, RectF rectF3, float f, float f2, LinearGradient linearGradient) {
        if (paint != null) {
            if (!this.f2792) {
                paint.setColor(ViewCompat.MEASURED_STATE_MASK);
                canvas.drawRect(rectF, paint);
            }
            paint.setColor(0);
            canvas.drawRect(rectF, paint);
            float f3 = rectF.left;
            rectF2.right = f3 + ((rectF.right - f3) * f);
            paint.setShader(linearGradient);
            paint.setAlpha(200);
            canvas.drawRect(rectF2, paint);
            paint.setAlpha(255);
            if (f2 < 1.0E-4f && f == 0.0f) {
                f2 = 0.0f;
            }
            float f4 = rectF.left;
            float f5 = f4 + ((rectF.right - f4) * f2);
            rectF3.right = f5;
            if (f2 == 0.0f) {
                rectF3.left = f5;
            } else {
                rectF3.left = f5 - (this.f2802 / 2.0f);
            }
            canvas.drawRect(rectF3, paint);
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final void m2767() {
        setSurfaceTextureListener(this);
        setOpaque(false);
        Paint paint = new Paint();
        this.f2809 = paint;
        paint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.f2809.setStyle(Paint.Style.STROKE);
        this.f2809.setAntiAlias(true);
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final synchronized void m2768() {
        Canvas canvasLockCanvas = lockCanvas(null);
        if (canvasLockCanvas != null) {
            canvasLockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
            canvasLockCanvas.drawColor(Color.argb(128, 0, 0, 0));
            m2766(canvasLockCanvas, this.f2796, this.f2795, this.f2793, this.f2794, this.f2814, this.f2813, this.f2790);
            m2766(canvasLockCanvas, this.f2797, this.f2800, this.f2798, this.f2799, this.f2818, this.f2817, this.f2791);
        }
        try {
            if (isAvailable()) {
                unlockCanvasAndPost(canvasLockCanvas);
            }
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public void m2769(int i, int i2, int i3, int i4, int i5, int i6) {
        this.f2805 = i3 - i;
        this.f2806 = i4 - i2;
        this.f2803 = i;
        this.f2804 = i2;
        this.f2808 = i3;
        this.f2802 = i5;
        this.f2801 = i6;
        this.f2795 = new RectF(this.f2803, this.f2804, this.f2805 + r4, r7 + i6);
        this.f2793 = new RectF(this.f2803, this.f2804, this.f2805 + r4, r7 + i6);
        this.f2794 = new RectF(this.f2803, this.f2804, this.f2805 + r4, r7 + i6);
        this.f2796 = new Paint();
        C4740 c4740 = f2789;
        RectF rectF = this.f2795;
        float f = rectF.left;
        float f2 = rectF.top;
        this.f2790 = c4740.m14279(f, f2, rectF.right, f2);
        float f3 = i4 - i6;
        float f4 = i4;
        this.f2800 = new RectF(this.f2803, f3, this.f2805 + r5, f4);
        this.f2798 = new RectF(this.f2803, f3, this.f2805 + r5, f4);
        this.f2799 = new RectF(this.f2803, f3, this.f2805 + r5, f4);
        RectF rectF2 = this.f2800;
        float f5 = rectF2.left;
        float f6 = rectF2.top;
        this.f2791 = c4740.m14279(f5, f6, rectF2.right, f6);
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public void m2770(float f, float f2, boolean z) {
        this.f2810 = z;
        m2765(f, f2);
        try {
            if (isAvailable()) {
                m2768();
            }
        } catch (IllegalStateException unused) {
        }
    }

    public AudioSchedulePortraitView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AudioSchedulePortraitView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2792 = true;
        this.f2796 = new Paint(1);
        this.f2797 = new Paint(2);
        this.f2810 = false;
        this.f2821 = 2500.0d / Math.pow(10.0d, 4.5d);
        m2767();
    }
}
