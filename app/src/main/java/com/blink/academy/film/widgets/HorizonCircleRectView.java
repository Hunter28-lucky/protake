package com.blink.academy.film.widgets;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.annotation.Nullable;
import defpackage.C2579;
import defpackage.C4792;

/* loaded from: classes.dex */
public class HorizonCircleRectView extends View {

    /* renamed from: ޗ, reason: contains not printable characters */
    public static boolean f2347 = false;

    /* renamed from: ޘ, reason: contains not printable characters */
    public static boolean f2348 = false;

    /* renamed from: ԫ, reason: contains not printable characters */
    public Paint f2349;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public Paint f2350;

    /* renamed from: ԭ, reason: contains not printable characters */
    public Paint f2351;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public Paint f2352;

    /* renamed from: ԯ, reason: contains not printable characters */
    public int f2353;

    /* renamed from: ՠ, reason: contains not printable characters */
    public int f2354;

    /* renamed from: ֈ, reason: contains not printable characters */
    public int f2355;

    /* renamed from: ֏, reason: contains not printable characters */
    public float f2356;

    /* renamed from: ׯ, reason: contains not printable characters */
    public boolean f2357;

    /* renamed from: ؠ, reason: contains not printable characters */
    public boolean f2358;

    /* renamed from: ހ, reason: contains not printable characters */
    public float f2359;

    /* renamed from: ށ, reason: contains not printable characters */
    public float f2360;

    /* renamed from: ނ, reason: contains not printable characters */
    public boolean f2361;

    /* renamed from: ރ, reason: contains not printable characters */
    public boolean f2362;

    /* renamed from: ބ, reason: contains not printable characters */
    public double f2363;

    /* renamed from: ޅ, reason: contains not printable characters */
    public float f2364;

    /* renamed from: ކ, reason: contains not printable characters */
    public float f2365;

    /* renamed from: އ, reason: contains not printable characters */
    public float f2366;

    /* renamed from: ވ, reason: contains not printable characters */
    public float f2367;

    /* renamed from: މ, reason: contains not printable characters */
    public float f2368;

    /* renamed from: ފ, reason: contains not printable characters */
    public float f2369;

    /* renamed from: ދ, reason: contains not printable characters */
    public int f2370;

    /* renamed from: ތ, reason: contains not printable characters */
    public int f2371;

    /* renamed from: ލ, reason: contains not printable characters */
    public int f2372;

    /* renamed from: ގ, reason: contains not printable characters */
    public int f2373;

    /* renamed from: ޏ, reason: contains not printable characters */
    public int f2374;

    /* renamed from: ސ, reason: contains not printable characters */
    public int f2375;

    /* renamed from: ޑ, reason: contains not printable characters */
    public int f2376;

    /* renamed from: ޒ, reason: contains not printable characters */
    public int f2377;

    /* renamed from: ޓ, reason: contains not printable characters */
    public ValueAnimator f2378;

    /* renamed from: ޔ, reason: contains not printable characters */
    public int f2379;

    /* renamed from: ޕ, reason: contains not printable characters */
    public int f2380;

    /* renamed from: ޖ, reason: contains not printable characters */
    public int f2381;

    /* renamed from: com.blink.academy.film.widgets.HorizonCircleRectView$Ϳ, reason: contains not printable characters */
    public class C0924 implements ValueAnimator.AnimatorUpdateListener {
        public C0924() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            HorizonCircleRectView.this.f2376 = (int) (((r0.f2373 - HorizonCircleRectView.this.f2374) * fFloatValue) + HorizonCircleRectView.this.f2374);
            HorizonCircleRectView.this.f2377 = (int) (((r0.f2372 - HorizonCircleRectView.this.f2375) * fFloatValue) + HorizonCircleRectView.this.f2375);
            if (fFloatValue == 1.0f) {
                HorizonCircleRectView horizonCircleRectView = HorizonCircleRectView.this;
                horizonCircleRectView.f2374 = horizonCircleRectView.f2376;
                HorizonCircleRectView horizonCircleRectView2 = HorizonCircleRectView.this;
                horizonCircleRectView2.f2375 = horizonCircleRectView2.f2377;
            }
        }
    }

    public HorizonCircleRectView(Context context) {
        this(context, null);
    }

    private void setIsHori(boolean z) {
        f2348 = z;
        if (z) {
            this.f2351.setAlpha(255);
            this.f2351.setStrokeWidth(C4792.m14375().m14435());
            this.f2351.setColor(C4792.m14375().m14431());
            this.f2350.setAlpha(255);
            this.f2350.setStrokeWidth(this.f2379);
            this.f2350.setColor(C4792.m14375().m14431());
            this.f2352.setAlpha(255);
            this.f2352.setColor(C4792.m14375().m14431());
            return;
        }
        this.f2351.setAlpha(128);
        this.f2351.setStrokeWidth(C4792.m14375().m14489());
        this.f2351.setColor(C4792.m14375().m14417());
        this.f2350.setAlpha(128);
        this.f2350.setStrokeWidth(this.f2379);
        this.f2350.setColor(C4792.m14375().m14417());
        this.f2352.setAlpha(128);
        this.f2352.setColor(C4792.m14375().m14417());
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f2362) {
            m2440();
            if (!this.f2361) {
                canvas.drawCircle(this.f2359, this.f2360, this.f2353, this.f2352);
            }
            canvas.drawCircle((this.f2354 * 1.0f) / 2.0f, (this.f2355 * 1.0f) / 2.0f, this.f2353, this.f2350);
            return;
        }
        if (!this.f2358) {
            int i = this.f2354;
            int i2 = this.f2376;
            float f = this.f2356;
            int i3 = this.f2377;
            canvas.drawRect(new RectF((i - (i2 / 3.0f)) / 2.0f, f - ((i3 / 3.0f) / 2.0f), ((i - (i2 / 3.0f)) / 2.0f) + (i2 / 3.0f), f + ((i3 / 3.0f) / 2.0f)), this.f2349);
        }
        canvas.rotate((float) Math.toDegrees(this.f2363), this.f2354 / 2, this.f2355 / 2);
        float f2 = this.f2364;
        float f3 = this.f2365;
        canvas.drawRect(new RectF(f2, f3, this.f2366 + f2, this.f2367 + f3), this.f2351);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f2380 = i;
        this.f2381 = i2;
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final void m2438(float f) {
        int i = this.f2376;
        int i2 = this.f2377;
        double d = (i * 1.0f) / i2;
        double d2 = f;
        float f2 = (i / 3.0f) * ((float) (1.0d - ((1.0d - (1.0d / d)) * d2)));
        float f3 = (i2 / 3.0f) * ((float) (((d - 1.0d) * d2) + 1.0d));
        this.f2364 = (this.f2354 - f2) / 2.0f;
        this.f2365 = (this.f2355 - f3) / 2.0f;
        this.f2366 = f2;
        this.f2367 = f3;
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public final void m2439(Context context, AttributeSet attributeSet) {
        this.f2354 = C2579.f9598;
        this.f2355 = C2579.f9597;
        Paint paint = new Paint();
        this.f2349 = paint;
        paint.setAntiAlias(true);
        this.f2349.setStyle(Paint.Style.STROKE);
        this.f2349.setAlpha(128);
        this.f2349.setStrokeWidth(C4792.m14375().m14489());
        this.f2349.setColor(-1);
        Paint paint2 = new Paint();
        this.f2351 = paint2;
        paint2.setAntiAlias(true);
        this.f2351.setStyle(Paint.Style.STROKE);
        this.f2351.setAlpha(128);
        this.f2351.setStrokeWidth(C4792.m14375().m14489());
        this.f2351.setColor(-1);
        Paint paint3 = new Paint();
        this.f2350 = paint3;
        paint3.setAntiAlias(true);
        this.f2350.setStyle(Paint.Style.STROKE);
        this.f2350.setAlpha(128);
        this.f2350.setStrokeWidth(C4792.m14375().m14489());
        this.f2350.setColor(C4792.m14375().m14417());
        this.f2350.setStrokeCap(Paint.Cap.ROUND);
        this.f2350.setStrokeJoin(Paint.Join.ROUND);
        Paint paint4 = new Paint();
        this.f2352 = paint4;
        paint4.setAntiAlias(true);
        this.f2352.setStyle(Paint.Style.STROKE);
        this.f2352.setAlpha(128);
        this.f2352.setStrokeWidth(C4792.m14375().m14489());
        this.f2352.setColor(C4792.m14375().m14417());
        this.f2352.setStrokeCap(Paint.Cap.ROUND);
        this.f2352.setStrokeJoin(Paint.Join.ROUND);
        this.f2379 = C4792.m14375().m14489();
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public final void m2440() {
        int iM9442;
        int iM9449;
        if (!f2347 ? (iM9449 = C2579.m9449(getContext())) <= (iM9442 = C2579.m9442(getContext())) : (iM9449 = C2579.m9450(getContext())) <= (iM9442 = C2579.m9443(getContext()))) {
            iM9442 = iM9449;
        }
        this.f2353 = (int) (((((((int) ((iM9442 / 3.0f) * 0.4f)) + C4792.m14375().m14476(8)) - C4792.m14375().m14476(8)) * 1.0f) / 2.0f) - this.f2379);
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public void m2441(float f, float f2, boolean z) {
        float f3;
        boolean z2;
        if (this.f2368 == f && f2 == this.f2369) {
            return;
        }
        this.f2370 = C2579.m9449(getContext());
        int iM9450 = C2579.m9450(getContext());
        this.f2371 = iM9450;
        int i = this.f2370;
        if (i > iM9450) {
            f3 = (i * 1.0f) / iM9450;
            z2 = true;
        } else {
            f3 = (iM9450 * 1.0f) / i;
            z2 = false;
        }
        if (f2 == f3) {
            if (f > f3) {
                if (z2) {
                    this.f2372 = i;
                    this.f2373 = (int) (i / f);
                } else {
                    this.f2373 = iM9450;
                    this.f2372 = (int) (iM9450 / f);
                }
            } else if (z2) {
                this.f2373 = iM9450;
                this.f2372 = (int) (iM9450 * f);
            } else {
                this.f2372 = i;
                this.f2373 = (int) (i * f);
            }
        } else {
            if (f < f2) {
                if (z2) {
                    int i2 = (int) (i / f2);
                    this.f2373 = i2;
                    this.f2372 = (int) (i2 * f);
                } else {
                    int i3 = (int) (iM9450 / f2);
                    this.f2372 = i3;
                    this.f2373 = (int) (i3 * f);
                }
            } else if (z2) {
                this.f2372 = i;
                this.f2373 = (int) (i / f);
            } else {
                this.f2373 = iM9450;
                this.f2372 = (int) (iM9450 / f);
            }
        }
        m2440();
        m2443(z);
        this.f2368 = f;
        this.f2369 = f2;
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x02ee  */
    /* renamed from: ހ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m2442(float r20, float r21, float r22, double r23) {
        /*
            Method dump skipped, instructions count: 762
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blink.academy.film.widgets.HorizonCircleRectView.m2442(float, float, float, double):void");
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public final void m2443(boolean z) {
        if (this.f2374 == 0 || this.f2375 == 0) {
            this.f2374 = this.f2373;
            this.f2375 = this.f2372;
        }
        if (!z) {
            this.f2376 = this.f2373;
            this.f2377 = this.f2372;
            return;
        }
        ValueAnimator valueAnimator = this.f2378;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f2374 = this.f2376;
            this.f2375 = this.f2377;
            this.f2378.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f2378 = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(100L);
        this.f2378.addUpdateListener(new C0924());
        this.f2378.setInterpolator(new LinearInterpolator());
        this.f2378.start();
    }

    public HorizonCircleRectView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HorizonCircleRectView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2358 = false;
        this.f2362 = true;
        m2439(context, attributeSet);
    }
}
