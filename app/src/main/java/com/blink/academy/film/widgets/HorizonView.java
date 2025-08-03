package com.blink.academy.film.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationUtils;
import androidx.annotation.Nullable;
import defpackage.C4792;

/* loaded from: classes.dex */
public class HorizonView extends View {

    /* renamed from: ԫ, reason: contains not printable characters */
    public Paint f2383;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public boolean f2384;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f2385;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public int f2386;

    /* renamed from: ԯ, reason: contains not printable characters */
    public int f2387;

    /* renamed from: ՠ, reason: contains not printable characters */
    public Path f2388;

    /* renamed from: ֈ, reason: contains not printable characters */
    public Matrix f2389;

    /* renamed from: ֏, reason: contains not printable characters */
    public boolean f2390;

    /* renamed from: ׯ, reason: contains not printable characters */
    public int f2391;

    /* renamed from: ؠ, reason: contains not printable characters */
    public int f2392;

    /* renamed from: ހ, reason: contains not printable characters */
    public int f2393;

    /* renamed from: ށ, reason: contains not printable characters */
    public boolean f2394;

    /* renamed from: ނ, reason: contains not printable characters */
    public boolean f2395;

    /* renamed from: ރ, reason: contains not printable characters */
    public long f2396;

    /* renamed from: ބ, reason: contains not printable characters */
    public long f2397;

    public HorizonView(Context context) {
        super(context, null);
        this.f2387 = -1;
        this.f2391 = 0;
        this.f2392 = 0;
        this.f2393 = 0;
        this.f2394 = false;
        this.f2395 = true;
        this.f2396 = 0L;
        this.f2397 = 0L;
        m2444();
    }

    public int getRatioCameraHeight() {
        return this.f2386;
    }

    public int getRatioCameraWidth() {
        return this.f2385;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f2388 == null) {
            return;
        }
        if (this.f2391 != this.f2393) {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            if (jCurrentAnimationTimeMillis < this.f2397) {
                int i = (int) (jCurrentAnimationTimeMillis - this.f2396);
                int i2 = this.f2392;
                if (!this.f2394) {
                    i = -i;
                }
                int i3 = i2 + ((i * 720) / 1000);
                this.f2391 = i3 >= 0 ? i3 % 360 : (i3 % 360) + 360;
                invalidate();
            } else {
                this.f2391 = this.f2393;
            }
        }
        this.f2389.setRotate(-this.f2391, getWidth() / 2.0f, getHeight() / 2.0f);
        canvas.setMatrix(this.f2389);
        if (this.f2384 && this.f2390) {
            this.f2383.setColor(this.f2387);
            if (this.f2387 == C4792.m14375().m14431()) {
                this.f2383.setAlpha(255);
                this.f2383.setStrokeWidth(C4792.m14375().m14435());
            } else {
                this.f2383.setAlpha(128);
                this.f2383.setStrokeWidth(C4792.m14375().m14489());
            }
            this.f2383.setAntiAlias(true);
            this.f2383.setStyle(Paint.Style.STROKE);
            canvas.drawPath(this.f2388, this.f2383);
        }
    }

    public void setDegree(int i) {
        int i2 = i >= 0 ? i % 360 : (i % 360) + 360;
        if (i2 == this.f2393) {
            return;
        }
        this.f2393 = i2;
        this.f2392 = this.f2391;
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        this.f2396 = jCurrentAnimationTimeMillis;
        int i3 = this.f2393 - this.f2391;
        if (i3 < 0) {
            i3 += 360;
        }
        if (i3 > 180) {
            i3 -= 360;
        }
        this.f2394 = i3 >= 0;
        this.f2397 = jCurrentAnimationTimeMillis + ((Math.abs(i3) * 1000) / 720);
        invalidate();
    }

    public void setLineColor(int i) {
        this.f2387 = i;
    }

    public void setNeedShow(boolean z) {
        this.f2390 = z;
    }

    public void setOrientation(int i) {
        setDegree(i);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m2444() {
        this.f2383 = new Paint();
        this.f2389 = new Matrix();
        setLayerType(1, null);
    }

    public HorizonView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2387 = -1;
        this.f2391 = 0;
        this.f2392 = 0;
        this.f2393 = 0;
        this.f2394 = false;
        this.f2395 = true;
        this.f2396 = 0L;
        this.f2397 = 0L;
        m2444();
    }
}
