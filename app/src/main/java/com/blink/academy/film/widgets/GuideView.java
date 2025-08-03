package com.blink.academy.film.widgets;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.blink.academy.film.FilmApp;
import defpackage.C2579;
import defpackage.C3444;
import defpackage.C4008;
import defpackage.C4792;
import defpackage.l5;

/* loaded from: classes.dex */
public class GuideView extends View {

    /* renamed from: ԫ, reason: contains not printable characters */
    public Paint f2254;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public Paint f2255;

    /* renamed from: ԭ, reason: contains not printable characters */
    public Paint f2256;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public Paint f2257;

    /* renamed from: ԯ, reason: contains not printable characters */
    public Paint f2258;

    /* renamed from: ՠ, reason: contains not printable characters */
    public Paint f2259;

    /* renamed from: ֈ, reason: contains not printable characters */
    public int f2260;

    /* renamed from: ֏, reason: contains not printable characters */
    public int f2261;

    /* renamed from: ׯ, reason: contains not printable characters */
    public float f2262;

    /* renamed from: ؠ, reason: contains not printable characters */
    public float f2263;

    /* renamed from: ހ, reason: contains not printable characters */
    public float f2264;

    /* renamed from: ށ, reason: contains not printable characters */
    public float f2265;

    /* renamed from: ނ, reason: contains not printable characters */
    public float f2266;

    /* renamed from: ރ, reason: contains not printable characters */
    public float f2267;

    /* renamed from: ބ, reason: contains not printable characters */
    public float f2268;

    /* renamed from: ޅ, reason: contains not printable characters */
    public float f2269;

    /* renamed from: ކ, reason: contains not printable characters */
    public float f2270;

    /* renamed from: އ, reason: contains not printable characters */
    public float f2271;

    /* renamed from: ވ, reason: contains not printable characters */
    public float f2272;

    /* renamed from: މ, reason: contains not printable characters */
    public float f2273;

    /* renamed from: ފ, reason: contains not printable characters */
    public float f2274;

    /* renamed from: ދ, reason: contains not printable characters */
    public double f2275;

    /* renamed from: ތ, reason: contains not printable characters */
    public boolean f2276;

    /* renamed from: ލ, reason: contains not printable characters */
    public boolean f2277;

    /* renamed from: ގ, reason: contains not printable characters */
    public float f2278;

    /* renamed from: ޏ, reason: contains not printable characters */
    public float f2279;

    /* renamed from: ސ, reason: contains not printable characters */
    public float f2280;

    /* renamed from: ޑ, reason: contains not printable characters */
    public float f2281;

    /* renamed from: ޒ, reason: contains not printable characters */
    public float f2282;

    /* renamed from: ޓ, reason: contains not printable characters */
    public int f2283;

    /* renamed from: ޔ, reason: contains not printable characters */
    public ValueAnimator f2284;

    /* renamed from: ޕ, reason: contains not printable characters */
    public boolean f2285;

    /* renamed from: ޖ, reason: contains not printable characters */
    public int f2286;

    /* renamed from: ޗ, reason: contains not printable characters */
    public int f2287;

    /* renamed from: ޘ, reason: contains not printable characters */
    public boolean f2288;

    /* renamed from: ޙ, reason: contains not printable characters */
    public boolean f2289;

    /* renamed from: ޚ, reason: contains not printable characters */
    public int f2290;

    /* renamed from: ޛ, reason: contains not printable characters */
    public int f2291;

    /* renamed from: ޜ, reason: contains not printable characters */
    public int f2292;

    /* renamed from: ޝ, reason: contains not printable characters */
    public int f2293;

    /* renamed from: ޞ, reason: contains not printable characters */
    public boolean f2294;

    /* renamed from: ޟ, reason: contains not printable characters */
    public boolean f2295;

    /* renamed from: ޠ, reason: contains not printable characters */
    public float[] f2296;

    /* renamed from: ޡ, reason: contains not printable characters */
    public int f2297;

    /* renamed from: ޢ, reason: contains not printable characters */
    public boolean f2298;

    /* renamed from: ޣ, reason: contains not printable characters */
    public boolean f2299;

    /* renamed from: ޤ, reason: contains not printable characters */
    public boolean f2300;

    /* renamed from: ޥ, reason: contains not printable characters */
    public ValueAnimator f2301;

    /* renamed from: ޱ, reason: contains not printable characters */
    public boolean f2302;

    /* renamed from: ߾, reason: contains not printable characters */
    public boolean f2303;

    /* renamed from: ߿, reason: contains not printable characters */
    public float f2304;

    /* renamed from: ࡠ, reason: contains not printable characters */
    public float f2305;

    /* renamed from: ࡡ, reason: contains not printable characters */
    public float f2306;

    /* renamed from: ࡢ, reason: contains not printable characters */
    public float f2307;

    /* renamed from: ࡣ, reason: contains not printable characters */
    public float f2308;

    /* renamed from: ࡤ, reason: contains not printable characters */
    public float f2309;

    /* renamed from: ࡥ, reason: contains not printable characters */
    public float f2310;

    /* renamed from: ࡦ, reason: contains not printable characters */
    public float f2311;

    /* renamed from: ࡧ, reason: contains not printable characters */
    public float f2312;

    /* renamed from: ࡨ, reason: contains not printable characters */
    public float f2313;

    /* renamed from: ࡩ, reason: contains not printable characters */
    public float f2314;

    /* renamed from: ࡪ, reason: contains not printable characters */
    public float f2315;

    /* renamed from: ࢠ, reason: contains not printable characters */
    public float f2316;

    /* renamed from: ࢡ, reason: contains not printable characters */
    public float f2317;

    /* renamed from: ࢢ, reason: contains not printable characters */
    public float f2318;

    /* renamed from: ࢣ, reason: contains not printable characters */
    public float f2319;

    /* renamed from: ࢤ, reason: contains not printable characters */
    public float f2320;

    /* renamed from: ࢥ, reason: contains not printable characters */
    public float f2321;

    /* renamed from: ࢦ, reason: contains not printable characters */
    public float f2322;

    /* renamed from: ࢧ, reason: contains not printable characters */
    public int f2323;

    /* renamed from: ࢨ, reason: contains not printable characters */
    public int f2324;

    /* renamed from: ࢩ, reason: contains not printable characters */
    public boolean f2325;

    /* renamed from: ࢪ, reason: contains not printable characters */
    public int f2326;

    /* renamed from: ࢫ, reason: contains not printable characters */
    public int f2327;

    /* renamed from: com.blink.academy.film.widgets.GuideView$Ϳ, reason: contains not printable characters */
    public class C0918 implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ float f2328;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final /* synthetic */ float f2329;

        /* renamed from: ԩ, reason: contains not printable characters */
        public final /* synthetic */ float f2330;

        /* renamed from: Ԫ, reason: contains not printable characters */
        public final /* synthetic */ float f2331;

        public C0918(float f, float f2, float f3, float f4) {
            this.f2328 = f;
            this.f2329 = f2;
            this.f2330 = f3;
            this.f2331 = f4;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            GuideView guideView = GuideView.this;
            guideView.f2271 = ((this.f2328 - guideView.f2271) * fFloatValue) + GuideView.this.f2271;
            GuideView guideView2 = GuideView.this;
            guideView2.f2272 = ((this.f2329 - guideView2.f2272) * fFloatValue) + GuideView.this.f2272;
            GuideView guideView3 = GuideView.this;
            guideView3.f2273 = ((this.f2330 - guideView3.f2273) * fFloatValue) + GuideView.this.f2273;
            GuideView guideView4 = GuideView.this;
            guideView4.f2274 = ((this.f2331 - guideView4.f2274) * fFloatValue) + GuideView.this.f2274;
            if (fFloatValue == 1.0f && GuideView.this.f2275 == 1.0d) {
                GuideView.this.f2302 = false;
            } else {
                GuideView.this.f2302 = true;
            }
            GuideView.this.invalidate();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.GuideView$Ԩ, reason: contains not printable characters */
    public class C0919 implements l5 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ int f2333;

        public C0919(int i) {
            this.f2333 = i;
        }

        @Override // defpackage.l5
        /* renamed from: Ϳ */
        public void mo1305() {
            GuideView.this.f2283 = this.f2333;
        }

        @Override // defpackage.l5
        /* renamed from: Ԩ */
        public void mo1306() {
        }

        @Override // defpackage.l5
        /* renamed from: ԩ */
        public void mo1307(float f) {
            GuideView.this.f2283 = (int) f;
            GuideView.this.f2259.setAlpha(GuideView.this.f2283);
            GuideView.this.postInvalidate();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.GuideView$Ԫ, reason: contains not printable characters */
    public class C0920 implements l5 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ int f2335;

        public C0920(int i) {
            this.f2335 = i;
        }

        @Override // defpackage.l5
        /* renamed from: Ϳ */
        public void mo1305() {
            GuideView.this.f2283 = this.f2335;
        }

        @Override // defpackage.l5
        /* renamed from: Ԩ */
        public void mo1306() {
        }

        @Override // defpackage.l5
        /* renamed from: ԩ */
        public void mo1307(float f) {
            GuideView.this.f2283 = (int) f;
            GuideView.this.f2259.setAlpha(GuideView.this.f2283);
            GuideView.this.postInvalidate();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.GuideView$Ԭ, reason: contains not printable characters */
    public class C0921 implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ int f2337;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final /* synthetic */ int f2338;

        public C0921(int i, int i2) {
            this.f2337 = i;
            this.f2338 = i2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            GuideView.this.f2286 = (int) (r0.f2290 + ((this.f2337 - GuideView.this.f2290) * fFloatValue));
            GuideView.this.f2287 = (int) (r0.f2291 + ((this.f2338 - GuideView.this.f2291) * fFloatValue));
            if (fFloatValue == 1.0f) {
                GuideView guideView = GuideView.this;
                guideView.f2290 = guideView.f2286;
                GuideView guideView2 = GuideView.this;
                guideView2.f2291 = guideView2.f2287;
            }
            GuideView.this.m2406();
            GuideView guideView3 = GuideView.this;
            guideView3.m2409(guideView3.f2275);
            GuideView.this.m2411();
            GuideView.this.invalidate();
        }
    }

    public GuideView(Context context) {
        this(context, null);
    }

    public float getRatio() {
        int i;
        int i2 = this.f2326;
        if (i2 == 0 || (i = this.f2327) == 0) {
            return 0.0f;
        }
        return (i2 * 1.0f) / i;
    }

    public float getTargetCameraHeight() {
        return this.f2281;
    }

    public float getTargetCameraWidth() {
        return this.f2282;
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f2298) {
            this.f2294 = true;
            this.f2325 = true;
        }
        if (this.f2302) {
            float f = this.f2271;
            int i = this.f2297;
            canvas.drawRect(new RectF(f - i, this.f2272 - i, this.f2273 + i, this.f2274 + i), this.f2255);
        }
        if (this.f2276) {
            canvas.drawLine(this.f2306, this.f2307, this.f2308, this.f2309, this.f2256);
            canvas.drawLine(this.f2310, this.f2311, this.f2312, this.f2313, this.f2256);
            canvas.drawLine(this.f2314, this.f2315, this.f2316, this.f2317, this.f2256);
            canvas.drawLine(this.f2318, this.f2319, this.f2320, this.f2321, this.f2256);
        }
        if (this.f2277) {
            canvas.drawLines(this.f2296, this.f2257);
        }
        if ((!this.f2299 ? C3444.m11227().m11257() : this.f2300) && this.f2302) {
            RectF rectF = new RectF(this.f2262, this.f2266, this.f2265, this.f2269);
            if (!this.f2294) {
                if (this.f2288) {
                    float f2 = this.f2262;
                    float f3 = this.f2266;
                    int i2 = this.f2297;
                    rectF = new RectF(f2, f3 + i2, this.f2265, this.f2269 - i2);
                }
                if (this.f2289) {
                    float f4 = this.f2262;
                    int i3 = this.f2297;
                    rectF = new RectF(f4 + i3, this.f2266, this.f2265 - i3, this.f2269);
                }
            }
            Path path = new Path();
            float f5 = this.f2271;
            int i4 = this.f2297;
            path.addRect(f5 - (i4 * 2), this.f2272 - (i4 * 2), (i4 * 2) + this.f2273, this.f2274 + (i4 * 2), Path.Direction.CW);
            canvas.clipPath(path, Region.Op.DIFFERENCE);
            canvas.drawRect(rectF, this.f2258);
        }
        if (!this.f2295 || this.f2283 == 255) {
            if (!this.f2294) {
                if (this.f2260 > this.f2261) {
                    if (this.f2289) {
                        canvas.drawLine(this.f2262, this.f2266, this.f2263, this.f2267, this.f2254);
                        canvas.drawLine(this.f2264, this.f2268, this.f2265, this.f2269, this.f2254);
                    }
                    if (this.f2288) {
                        canvas.drawLine(this.f2262, this.f2266, this.f2264, this.f2268, this.f2254);
                        canvas.drawLine(this.f2263, this.f2267, this.f2265, this.f2269, this.f2254);
                    }
                } else {
                    if (this.f2288) {
                        canvas.drawLine(this.f2262, this.f2266, this.f2264, this.f2268, this.f2254);
                        canvas.drawLine(this.f2263, this.f2267, this.f2265, this.f2269, this.f2254);
                    }
                    if (this.f2289) {
                        canvas.drawLine(this.f2262, this.f2266, this.f2263, this.f2267, this.f2254);
                        canvas.drawLine(this.f2264, this.f2268, this.f2265, this.f2269, this.f2254);
                    }
                }
            }
            RectF rectF2 = new RectF(0.0f, 0.0f, this.f2260, this.f2261);
            Path path2 = new Path();
            path2.addRect(this.f2262, this.f2266, this.f2265, this.f2269, Path.Direction.CW);
            canvas.clipPath(path2, Region.Op.DIFFERENCE);
            this.f2259.setColor(ViewCompat.MEASURED_STATE_MASK);
            this.f2259.setAlpha(this.f2283);
            canvas.drawRect(rectF2, this.f2259);
            this.f2326 = this.f2286;
            this.f2327 = this.f2287;
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        m2410();
        m2407();
        float f = this.f2262;
        float f2 = this.f2278;
        this.f2271 = f + f2;
        float f3 = this.f2266;
        float f4 = this.f2279;
        this.f2272 = f3 + f4;
        this.f2273 = this.f2265 - f2;
        this.f2274 = this.f2269 - f4;
        m2411();
    }

    public void setCreateByMonitor(boolean z) {
        this.f2299 = z;
        this.f2292 = 51;
        this.f2254.setStrokeWidth(C2579.m9441());
        this.f2254.setColor(-1);
        this.f2254.setAlpha(this.f2292);
        this.f2255.setStrokeWidth(C2579.m9441());
        this.f2255.setColor(-1);
        this.f2255.setAlpha(this.f2292);
        this.f2256.setStrokeWidth(C2579.m9441());
        this.f2256.setColor(-1);
        this.f2256.setAlpha(this.f2292);
        this.f2257.setStrokeWidth(C2579.m9441());
        this.f2257.setColor(-1);
        this.f2257.setAlpha(this.f2292);
    }

    public void setShowSafeCover(boolean z) {
        this.f2300 = z;
        postInvalidate();
    }

    /* renamed from: މ, reason: contains not printable characters */
    public void m2400() {
        this.f2326 = 0;
        this.f2327 = 0;
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public boolean m2401() {
        return this.f2327 == 0 || this.f2326 == 0;
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public boolean m2402() {
        return this.f2288;
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public boolean m2403() {
        return this.f2289;
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public final void m2404(Context context, AttributeSet attributeSet) {
        this.f2297 = C4792.m14375().m14489();
        Paint paint = new Paint(1);
        this.f2254 = paint;
        paint.setColor(C4792.m14375().m14417());
        this.f2254.setStrokeWidth(this.f2297);
        Paint paint2 = new Paint();
        this.f2259 = paint2;
        paint2.setColor(ViewCompat.MEASURED_STATE_MASK);
        int iM14413 = C4792.m14375().m14413();
        this.f2293 = iM14413;
        this.f2259.setAlpha(iM14413);
        this.f2259.setStyle(Paint.Style.FILL);
        this.f2259.setStrokeWidth(this.f2297);
        Paint paint3 = new Paint();
        this.f2255 = paint3;
        paint3.setColor(C4792.m14375().m14417());
        this.f2255.setStrokeWidth(this.f2297);
        this.f2255.setStyle(Paint.Style.STROKE);
        Paint paint4 = new Paint(1);
        this.f2256 = paint4;
        paint4.setColor(-1);
        this.f2256.setStrokeWidth(this.f2297);
        Paint paint5 = new Paint(1);
        this.f2257 = paint5;
        paint5.setColor(-1);
        this.f2257.setStrokeWidth(this.f2297);
        Paint paint6 = new Paint();
        this.f2258 = paint6;
        paint6.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.f2258.setAlpha(C4792.m14375().m14413());
        this.f2258.setStyle(Paint.Style.FILL);
        this.f2258.setStrokeWidth(this.f2297);
        this.f2283 = FilmApp.m405().m406() ? C3444.m11227().m11256() : false ? C4792.m14375().m14414() : C4792.m14375().m14413();
    }

    /* renamed from: ގ, reason: contains not printable characters */
    public void m2405() {
        int iM14413 = C4792.m14375().m14413();
        this.f2283 = iM14413;
        this.f2259.setAlpha(iM14413);
    }

    /* renamed from: ޏ, reason: contains not printable characters */
    public final void m2406() {
        int i = this.f2260;
        int i2 = this.f2261;
        float f = (int) ((i - this.f2286) / 2.0f);
        this.f2262 = f;
        this.f2263 = f;
        this.f2264 = i - r1;
        this.f2265 = i - r1;
        float f2 = (int) ((i2 - this.f2287) / 2.0f);
        this.f2266 = f2;
        this.f2267 = i2 - r4;
        this.f2268 = f2;
        this.f2269 = i2 - r4;
        float fMax = Math.max(i, i2) / 15.0f;
        int i3 = this.f2260;
        int i4 = this.f2261;
        this.f2296 = new float[]{(i3 - fMax) / 2.0f, i4 / 2.0f, (i3 + fMax) / 2.0f, i4 / 2.0f, i3 / 2.0f, (i4 - fMax) / 2.0f, i3 / 2.0f, (i4 + fMax) / 2.0f};
    }

    /* renamed from: ސ, reason: contains not printable characters */
    public final void m2407() {
        double d = this.f2264 - this.f2262;
        double d2 = this.f2275;
        this.f2278 = (float) ((d * (1.0d - d2)) / 2.0d);
        this.f2279 = (float) (((this.f2267 - this.f2266) * (1.0d - d2)) / 2.0d);
    }

    /* renamed from: ޑ, reason: contains not printable characters */
    public final void m2408() {
        m2407();
        float f = this.f2262;
        float f2 = this.f2278;
        float f3 = f + f2;
        float f4 = this.f2266;
        float f5 = this.f2279;
        float f6 = f4 + f5;
        float f7 = this.f2265 - f2;
        float f8 = this.f2269 - f5;
        ValueAnimator valueAnimator = this.f2301;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f2301.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f2301 = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(300L);
        this.f2301.addUpdateListener(new C0918(f3, f6, f7, f8));
        this.f2301.setInterpolator(new LinearInterpolator());
        this.f2301.start();
    }

    /* renamed from: ޒ, reason: contains not printable characters */
    public void m2409(double d) {
        this.f2275 = d;
        m2407();
        float f = this.f2262;
        float f2 = this.f2278;
        this.f2271 = f + f2;
        float f3 = this.f2266;
        float f4 = this.f2279;
        this.f2272 = f3 + f4;
        this.f2273 = this.f2265 - f2;
        this.f2274 = this.f2269 - f4;
        invalidate();
    }

    /* renamed from: ޓ, reason: contains not printable characters */
    public final void m2410() {
        if (this.f2260 == 0 || this.f2261 == 0) {
            this.f2261 = C2579.f9597;
            this.f2260 = C2579.f9598;
        }
        int i = this.f2261;
        int i2 = this.f2260;
        if (i > i2) {
            this.f2322 = (i * 1.0f) / i2;
        } else {
            this.f2322 = (i2 * 1.0f) / i;
        }
        int i3 = this.f2286;
        this.f2290 = i3;
        int i4 = this.f2287;
        this.f2291 = i4;
        float f = this.f2280;
        if (((float) ((int) (f * 100.0f))) / 100.0f == ((float) ((int) (this.f2322 * 100.0f))) / 100.0f) {
            this.f2322 = f;
            float f2 = this.f2270;
            boolean z = f2 > f;
            this.f2325 = z;
            this.f2294 = f2 == f;
            if (z) {
                if (i > i2) {
                    this.f2289 = true;
                    this.f2286 = (int) (i / f2);
                    this.f2287 = i;
                } else {
                    this.f2288 = true;
                    this.f2287 = (int) (i2 / f2);
                    this.f2286 = i2;
                }
            } else if (i > i2) {
                this.f2288 = true;
                this.f2287 = (int) (f2 * i2);
                this.f2286 = i2;
            } else {
                this.f2289 = true;
                this.f2286 = (int) (f2 * i);
                this.f2287 = i;
            }
        } else {
            float f3 = this.f2270;
            boolean z2 = f3 < f;
            this.f2325 = z2;
            this.f2288 = true;
            this.f2294 = false;
            if (i > i2) {
                this.f2289 = true;
            } else {
                this.f2288 = true;
            }
            if (z2) {
                if (i > i2) {
                    this.f2288 = true;
                    int i5 = (int) (i / f);
                    this.f2286 = i5;
                    this.f2287 = (int) (i5 * f3);
                } else {
                    this.f2289 = true;
                    int i6 = (int) (i2 / f);
                    this.f2287 = i6;
                    this.f2286 = (int) (i6 * f3);
                }
            } else if (i > i2) {
                this.f2288 = false;
                this.f2287 = i;
                this.f2286 = (int) (i / f3);
            } else {
                this.f2286 = i2;
                this.f2287 = (int) (i2 / f3);
            }
        }
        int i7 = this.f2286;
        this.f2282 = i7;
        int i8 = this.f2287;
        this.f2281 = i8;
        if (i3 == 0 || i4 == 0) {
            this.f2290 = i7;
            this.f2291 = i8;
        }
        this.f2323 = i7;
        this.f2324 = i8;
        if (!this.f2285) {
            m2406();
            m2409(this.f2275);
            m2411();
            invalidate();
            return;
        }
        ValueAnimator valueAnimator = this.f2284;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f2290 = this.f2286;
            this.f2291 = this.f2287;
            this.f2284.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f2284 = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(100L);
        this.f2284.addUpdateListener(new C0921(i7, i8));
        this.f2284.setInterpolator(new LinearInterpolator());
        this.f2284.start();
    }

    /* renamed from: ޔ, reason: contains not printable characters */
    public final void m2411() {
        if (this.f2276) {
            float f = this.f2264;
            float f2 = this.f2262;
            float f3 = (f - f2) / 3.0f;
            this.f2304 = f3;
            float f4 = this.f2267;
            float f5 = this.f2266;
            float f6 = (f4 - f5) / 3.0f;
            this.f2305 = f6;
            this.f2306 = f2 + f3;
            this.f2307 = f5;
            this.f2308 = f2 + f3;
            this.f2309 = f4;
            this.f2310 = (f3 * 2.0f) + f2;
            this.f2311 = f5;
            this.f2312 = (f3 * 2.0f) + f2;
            this.f2313 = f4;
            this.f2314 = f2;
            this.f2315 = f5 + f6;
            this.f2316 = f;
            float f7 = this.f2268;
            this.f2317 = f7 + f6;
            this.f2318 = f2;
            this.f2319 = f5 + (f6 * 2.0f);
            this.f2320 = f;
            this.f2321 = f7 + (f6 * 2.0f);
        }
    }

    /* renamed from: ޕ, reason: contains not printable characters */
    public boolean m2412() {
        return this.f2326 == this.f2323 && this.f2327 == this.f2324;
    }

    /* renamed from: ޖ, reason: contains not printable characters */
    public void m2413() {
        this.f2327 = this.f2324;
        this.f2326 = this.f2323;
    }

    /* renamed from: ޗ, reason: contains not printable characters */
    public void m2414(float f, boolean z, float f2) {
        this.f2254.setAlpha((int) (this.f2292 * f));
        this.f2255.setAlpha((int) (this.f2292 * f));
        this.f2256.setAlpha((int) (this.f2292 * f));
        this.f2257.setAlpha((int) (this.f2292 * f));
        this.f2258.setAlpha((int) (this.f2293 * f));
        C4792 c4792M14375 = C4792.m14375();
        int iM14414 = (int) ((z ? c4792M14375.m14414() : c4792M14375.m14413()) * f2);
        this.f2283 = iM14414;
        this.f2259.setAlpha(iM14414);
        postInvalidate();
    }

    /* renamed from: ޘ, reason: contains not printable characters */
    public GuideView m2415(boolean z) {
        this.f2295 = z;
        return this;
    }

    /* renamed from: ޙ, reason: contains not printable characters */
    public void m2416(float f, float f2, boolean z) {
        this.f2285 = z;
        if (this.f2270 != f) {
            this.f2303 = true;
        } else {
            this.f2303 = false;
        }
        this.f2270 = f;
        this.f2288 = false;
        this.f2289 = false;
        this.f2280 = f2;
        m2410();
    }

    /* renamed from: ޚ, reason: contains not printable characters */
    public void m2417(int i, int i2, boolean z) {
        this.f2260 = i;
        this.f2261 = i2;
        m2416(this.f2270, this.f2280, false);
        m2409(1.0d);
        m2420(z);
        postInvalidate();
    }

    /* renamed from: ޛ, reason: contains not printable characters */
    public void m2418(boolean z) {
        this.f2276 = z;
        if (z) {
            m2411();
        }
        invalidate();
    }

    /* renamed from: ޜ, reason: contains not printable characters */
    public void m2419(boolean z) {
        this.f2277 = z;
        invalidate();
    }

    /* renamed from: ޝ, reason: contains not printable characters */
    public void m2420(boolean z) {
        this.f2298 = z;
    }

    /* renamed from: ޞ, reason: contains not printable characters */
    public void m2421(double d) {
        this.f2275 = d;
        m2408();
    }

    /* renamed from: ޟ, reason: contains not printable characters */
    public void m2422(int i) {
        C4008.m12885(100L, this.f2283, i, new C0919(i));
    }

    /* renamed from: ޠ, reason: contains not printable characters */
    public void m2423(int i, long j) {
        if (j != 0) {
            C4008.m12885(100L, this.f2283, i, new C0920(i));
            return;
        }
        this.f2283 = i;
        this.f2259.setAlpha(i);
        postInvalidate();
    }

    public GuideView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GuideView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2276 = false;
        this.f2277 = false;
        this.f2278 = 0.0f;
        this.f2279 = 0.0f;
        this.f2281 = 0.0f;
        this.f2282 = 0.0f;
        this.f2286 = 0;
        this.f2287 = 0;
        this.f2292 = 255;
        this.f2293 = 255;
        this.f2299 = false;
        this.f2300 = true;
        this.f2302 = true;
        this.f2303 = false;
        this.f2304 = 0.0f;
        this.f2305 = 0.0f;
        this.f2309 = 0.0f;
        this.f2313 = 0.0f;
        this.f2317 = 0.0f;
        this.f2321 = 0.0f;
        m2404(context, attributeSet);
    }
}
