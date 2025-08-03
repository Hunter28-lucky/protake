package com.blink.academy.film.widgets;

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
public class AudioScheduleView extends TextureView implements TextureView.SurfaceTextureListener {

    /* renamed from: ޖ, reason: contains not printable characters */
    public static final int f1894;

    /* renamed from: ޗ, reason: contains not printable characters */
    public static final int f1895;

    /* renamed from: ޘ, reason: contains not printable characters */
    public static final int f1896;

    /* renamed from: ޙ, reason: contains not printable characters */
    public static final float[] f1897;

    /* renamed from: ޚ, reason: contains not printable characters */
    public static final int[] f1898;

    /* renamed from: ޛ, reason: contains not printable characters */
    public static final C4740 f1899;

    /* renamed from: ԫ, reason: contains not printable characters */
    public LinearGradient f1900;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public LinearGradient f1901;

    /* renamed from: ԭ, reason: contains not printable characters */
    public boolean f1902;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public RectF f1903;

    /* renamed from: ԯ, reason: contains not printable characters */
    public RectF f1904;

    /* renamed from: ՠ, reason: contains not printable characters */
    public RectF f1905;

    /* renamed from: ֈ, reason: contains not printable characters */
    public Paint f1906;

    /* renamed from: ֏, reason: contains not printable characters */
    public Paint f1907;

    /* renamed from: ׯ, reason: contains not printable characters */
    public RectF f1908;

    /* renamed from: ؠ, reason: contains not printable characters */
    public RectF f1909;

    /* renamed from: ހ, reason: contains not printable characters */
    public RectF f1910;

    /* renamed from: ށ, reason: contains not printable characters */
    public float f1911;

    /* renamed from: ނ, reason: contains not printable characters */
    public float f1912;

    /* renamed from: ރ, reason: contains not printable characters */
    public int f1913;

    /* renamed from: ބ, reason: contains not printable characters */
    public int f1914;

    /* renamed from: ޅ, reason: contains not printable characters */
    public int f1915;

    /* renamed from: ކ, reason: contains not printable characters */
    public int f1916;

    /* renamed from: އ, reason: contains not printable characters */
    public float f1917;

    /* renamed from: ވ, reason: contains not printable characters */
    public int f1918;

    /* renamed from: މ, reason: contains not printable characters */
    public Paint f1919;

    /* renamed from: ފ, reason: contains not printable characters */
    public boolean f1920;

    /* renamed from: ދ, reason: contains not printable characters */
    public float f1921;

    /* renamed from: ތ, reason: contains not printable characters */
    public float f1922;

    /* renamed from: ލ, reason: contains not printable characters */
    public float f1923;

    /* renamed from: ގ, reason: contains not printable characters */
    public float f1924;

    /* renamed from: ޏ, reason: contains not printable characters */
    public int f1925;

    /* renamed from: ސ, reason: contains not printable characters */
    public float f1926;

    /* renamed from: ޑ, reason: contains not printable characters */
    public float f1927;

    /* renamed from: ޒ, reason: contains not printable characters */
    public float f1928;

    /* renamed from: ޓ, reason: contains not printable characters */
    public int f1929;

    /* renamed from: ޔ, reason: contains not printable characters */
    public float f1930;

    /* renamed from: ޕ, reason: contains not printable characters */
    public final double f1931;

    static {
        int iArgb = Color.argb(255, 255, 251, 114);
        f1894 = iArgb;
        int iArgb2 = Color.argb(255, 176, 58, 67);
        f1895 = iArgb2;
        int iArgb3 = Color.argb(255, 34, 201, 137);
        f1896 = iArgb3;
        float[] fArr = {0.0f, 0.29f, 0.56f, 0.82f, 1.0f};
        f1897 = fArr;
        int[] iArr = {iArgb3, C3844.m12260(iArgb3, 0.5f, iArgb), iArgb, C3844.m12260(iArgb, 0.5f, iArgb2), iArgb2};
        f1898 = iArr;
        f1899 = new C4740(iArr, fArr);
    }

    public AudioScheduleView(Context context) {
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
        m2114(0.0f, 0.0f, false);
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
    public final void m2109(float f, float f2) {
        if (f == -1.0f && f2 == -1.0f) {
            this.f1921 = 0.0f;
            this.f1925 = 0;
            this.f1924 = 0.0f;
            this.f1926 = 0.0f;
            this.f1923 = 0.0f;
            this.f1922 = 0.0f;
            this.f1929 = 0;
            this.f1928 = 0.0f;
            this.f1930 = 0.0f;
            this.f1927 = 0.0f;
            this.f1917 = 0.0f;
            return;
        }
        float f3 = this.f1921;
        float f4 = f3 + ((f - f3) / 5.0f);
        this.f1921 = f4;
        if (f4 <= 0.0f) {
            f4 = 1.0E-4f;
        }
        float fMax = Math.max(0.0f, ((float) (Math.log10(f4 * this.f1931) * 20.0d)) / 60.0f);
        this.f1924 = fMax;
        int i = this.f1925 - 1;
        this.f1925 = i;
        float f5 = this.f1923;
        if (fMax > f5) {
            this.f1926 = this.f1921;
            this.f1923 = fMax;
            this.f1925 = 25;
        } else if (i < 0) {
            this.f1923 = f5 + ((fMax - f5) / 20.0f);
            float f6 = this.f1926;
            this.f1926 = f6 + ((this.f1921 - f6) / 8.0f);
        }
        float f7 = this.f1922;
        float f8 = f7 + ((f2 - f7) / 5.0f);
        this.f1922 = f8;
        if (f8 <= 0.0f) {
            f8 = 1.0E-4f;
        }
        float fMax2 = Math.max(0.0f, ((float) (Math.log10(f8 * this.f1931) * 20.0d)) / 60.0f);
        this.f1928 = fMax2;
        int i2 = this.f1929 - 1;
        this.f1929 = i2;
        float f9 = this.f1927;
        if (fMax2 > f9) {
            this.f1930 = this.f1922;
            this.f1927 = fMax2;
            this.f1929 = 25;
        } else if (i2 < 0) {
            this.f1927 = f9 + ((fMax2 - f9) / 20.0f);
            float f10 = this.f1930;
            this.f1930 = f10 + ((this.f1922 - f10) / 8.0f);
        }
        this.f1917 = ((float) (Math.log10((Math.max(this.f1926, this.f1930) > 0.0f ? r13 : 1.0E-4f) * this.f1931) * 20.0d)) - 60.0f;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final void m2110(Canvas canvas, Paint paint, RectF rectF, RectF rectF2, RectF rectF3, float f, float f2, LinearGradient linearGradient) {
        if (paint != null) {
            if (!this.f1902) {
                paint.setColor(ViewCompat.MEASURED_STATE_MASK);
                canvas.drawRect(rectF, paint);
            }
            paint.setColor(0);
            canvas.drawRect(rectF, paint);
            float f3 = rectF.bottom;
            rectF2.top = f3 + ((rectF.top - f3) * f);
            paint.setShader(linearGradient);
            paint.setAlpha(200);
            canvas.drawRect(rectF2, paint);
            paint.setAlpha(255);
            if (f2 < 1.0E-4f && f == 0.0f) {
                f2 = 0.0f;
            }
            float f4 = rectF.bottom;
            float f5 = f4 + ((rectF.top - f4) * f2);
            rectF3.top = f5;
            if (f2 == 0.0f) {
                rectF3.bottom = f5;
            } else {
                rectF3.bottom = f5 - (this.f1911 / 2.0f);
            }
            canvas.drawRect(rectF3, paint);
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final void m2111() {
        setSurfaceTextureListener(this);
        setOpaque(false);
        Paint paint = new Paint();
        this.f1919 = paint;
        paint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.f1919.setStyle(Paint.Style.STROKE);
        this.f1919.setAntiAlias(true);
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final synchronized void m2112() {
        Canvas canvasLockCanvas = lockCanvas(null);
        if (canvasLockCanvas != null) {
            canvasLockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
            canvasLockCanvas.drawColor(Color.argb(128, 0, 0, 0));
            m2110(canvasLockCanvas, this.f1906, this.f1905, this.f1903, this.f1904, this.f1924, this.f1923, this.f1900);
            m2110(canvasLockCanvas, this.f1907, this.f1910, this.f1908, this.f1909, this.f1928, this.f1927, this.f1901);
        }
        try {
            if (isAvailable()) {
                unlockCanvasAndPost(canvasLockCanvas);
            }
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public void m2113(int i, int i2, int i3, int i4, int i5, int i6) {
        this.f1915 = i3 - i;
        this.f1916 = i4 - i2;
        this.f1913 = i;
        this.f1914 = i2;
        this.f1918 = i3;
        this.f1912 = i5;
        this.f1911 = i6;
        this.f1905 = new RectF(this.f1913, this.f1914, r4 + i5, this.f1916 + r8);
        this.f1903 = new RectF(this.f1913, this.f1914, r4 + i5, this.f1916 + r8);
        this.f1904 = new RectF(this.f1913, this.f1914, r4 + i5, this.f1916 + r8);
        this.f1906 = new Paint();
        C4740 c4740 = f1899;
        RectF rectF = this.f1905;
        float f = rectF.left;
        this.f1900 = c4740.m14279(f, rectF.bottom, f, rectF.top);
        float f2 = i3 - i5;
        float f3 = i3;
        this.f1910 = new RectF(f2, this.f1914, f3, this.f1916 + r7);
        this.f1908 = new RectF(f2, this.f1914, f3, this.f1916 + r7);
        this.f1909 = new RectF(f2, this.f1914, f3, this.f1916 + r7);
        RectF rectF2 = this.f1910;
        float f4 = rectF2.left;
        this.f1901 = c4740.m14279(f4, rectF2.bottom, f4, rectF2.top);
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public void m2114(float f, float f2, boolean z) {
        this.f1920 = z;
        m2109(f, f2);
        try {
            if (isAvailable()) {
                m2112();
            }
        } catch (IllegalStateException unused) {
        }
    }

    public AudioScheduleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AudioScheduleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1902 = true;
        this.f1906 = new Paint(1);
        this.f1907 = new Paint(2);
        this.f1920 = false;
        this.f1931 = 2500.0d / Math.pow(10.0d, 4.5d);
        m2111();
    }
}
