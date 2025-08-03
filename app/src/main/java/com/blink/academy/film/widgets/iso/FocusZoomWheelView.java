package com.blink.academy.film.widgets.iso;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.blink.academy.film.custom.WeakHandler;
import com.blink.academy.film.widgets.iso.WheelProgressView;
import com.blink.academy.protake.R;
import defpackage.AbstractC4968;
import defpackage.C3947;
import defpackage.C4008;
import defpackage.C4535;
import defpackage.C4638;
import defpackage.C4792;

/* loaded from: classes.dex */
public class FocusZoomWheelView extends FrameLayout {

    /* renamed from: ރ, reason: contains not printable characters */
    public static final String f3273 = FocusZoomWheelView.class.getSimpleName();

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC4968 f3274;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public long f3275;

    /* renamed from: ԭ, reason: contains not printable characters */
    public boolean f3276;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public ValueAnimator f3277;

    /* renamed from: ԯ, reason: contains not printable characters */
    public ValueAnimator f3278;

    /* renamed from: ՠ, reason: contains not printable characters */
    public ValueAnimator f3279;

    /* renamed from: ֈ, reason: contains not printable characters */
    public WheelProgressView.InterfaceC1249 f3280;

    /* renamed from: ֏, reason: contains not printable characters */
    public float f3281;

    /* renamed from: ׯ, reason: contains not printable characters */
    public float f3282;

    /* renamed from: ؠ, reason: contains not printable characters */
    public boolean f3283;

    /* renamed from: ހ, reason: contains not printable characters */
    public int f3284;

    /* renamed from: ށ, reason: contains not printable characters */
    public int f3285;

    /* renamed from: ނ, reason: contains not printable characters */
    public InterfaceC1176 f3286;

    /* renamed from: com.blink.academy.film.widgets.iso.FocusZoomWheelView$Ϳ, reason: contains not printable characters */
    public class C1161 extends AnimatorListenerAdapter {
        public C1161() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.FocusZoomWheelView$Ԩ, reason: contains not printable characters */
    public class C1162 implements WheelProgressView.InterfaceC1249 {
        public C1162() {
        }

        @Override // com.blink.academy.film.widgets.iso.WheelProgressView.InterfaceC1249
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo3281() {
            if (FocusZoomWheelView.this.f3279 == null || !FocusZoomWheelView.this.f3279.isRunning()) {
                return;
            }
            FocusZoomWheelView.this.f3279.cancel();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.FocusZoomWheelView$Ԫ, reason: contains not printable characters */
    public class C1163 implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public float f3289;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final /* synthetic */ float f3290;

        /* renamed from: ԩ, reason: contains not printable characters */
        public final /* synthetic */ float f3291;

        public C1163(float f, float f2) {
            this.f3290 = f;
            this.f3291 = f2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            FocusZoomWheelView.this.f3274.f16697.m3483(((fFloatValue - this.f3289) * this.f3290) + FocusZoomWheelView.this.f3282, this.f3291, FocusZoomWheelView.this.f3280);
            FocusZoomWheelView.this.f3282 = 0.0f;
            this.f3289 = fFloatValue;
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.FocusZoomWheelView$Ԭ, reason: contains not printable characters */
    public class C1164 extends AnimatorListenerAdapter {
        public C1164() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.FocusZoomWheelView$Ԯ, reason: contains not printable characters */
    public class C1165 implements InterfaceC1175 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ InterfaceC1175 f3294;

        public C1165(InterfaceC1175 interfaceC1175) {
            this.f3294 = interfaceC1175;
        }

        @Override // com.blink.academy.film.widgets.iso.FocusZoomWheelView.InterfaceC1175
        /* renamed from: Ϳ */
        public void mo1325() {
            FocusZoomWheelView.this.f3283 = false;
            InterfaceC1175 interfaceC1175 = this.f3294;
            if (interfaceC1175 != null) {
                interfaceC1175.mo1325();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.FocusZoomWheelView$ՠ, reason: contains not printable characters */
    public class C1166 implements WheelProgressView.InterfaceC1251 {
        public C1166() {
        }

        @Override // com.blink.academy.film.widgets.iso.WheelProgressView.InterfaceC1251
        public void onChange(float f) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (C3947.f13602) {
                C4638.m14099(FocusZoomWheelView.f3273, "zoom pro:" + f);
            }
            if (FocusZoomWheelView.this.f3286 != null) {
                FocusZoomWheelView.this.f3286.onZoomChange(f);
            }
            FocusZoomWheelView.this.f3275 = jCurrentTimeMillis;
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.FocusZoomWheelView$ֈ, reason: contains not printable characters */
    public class C1167 implements WheelProgressView.InterfaceC1251 {
        public C1167() {
        }

        @Override // com.blink.academy.film.widgets.iso.WheelProgressView.InterfaceC1251
        public void onChange(float f) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (C3947.f13602) {
                C4638.m14099(FocusZoomWheelView.f3273, "focus pro:" + f);
            }
            if (FocusZoomWheelView.this.f3286 != null) {
                FocusZoomWheelView.this.f3286.onFocusChange(f);
            }
            FocusZoomWheelView.this.f3275 = jCurrentTimeMillis;
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.FocusZoomWheelView$֏, reason: contains not printable characters */
    public class C1168 implements WheelProgressView.InterfaceC1250 {
        public C1168() {
        }

        @Override // com.blink.academy.film.widgets.iso.WheelProgressView.InterfaceC1250
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo3282() {
            if (FocusZoomWheelView.this.f3286 != null) {
                FocusZoomWheelView.this.f3286.onHideAB();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.FocusZoomWheelView$ׯ, reason: contains not printable characters */
    public class ViewOnClickListenerC1169 implements View.OnClickListener {
        public ViewOnClickListenerC1169() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FocusZoomWheelView.this.f3276) {
                FocusZoomWheelView.this.f3276 = false;
                C3947.m12727().m12800(FocusZoomWheelView.this.f3276, false);
                FocusZoomWheelView.this.m3258();
                if (FocusZoomWheelView.this.f3286 != null) {
                    FocusZoomWheelView.this.f3286.onModeChange(FocusZoomWheelView.this.f3276);
                }
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.FocusZoomWheelView$ؠ, reason: contains not printable characters */
    public class ViewOnClickListenerC1170 implements View.OnClickListener {
        public ViewOnClickListenerC1170() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FocusZoomWheelView.this.f3276) {
                return;
            }
            FocusZoomWheelView.this.f3276 = true;
            C3947.m12727().m12800(FocusZoomWheelView.this.f3276, false);
            FocusZoomWheelView.this.m3258();
            if (FocusZoomWheelView.this.f3286 != null) {
                FocusZoomWheelView.this.f3286.onModeChange(FocusZoomWheelView.this.f3276);
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.FocusZoomWheelView$ހ, reason: contains not printable characters */
    public class C1171 implements WheelProgressView.InterfaceC1252 {
        public C1171() {
        }

        @Override // com.blink.academy.film.widgets.iso.WheelProgressView.InterfaceC1252
        public void onAnimChange(boolean z) {
            if (FocusZoomWheelView.this.f3286 != null) {
                FocusZoomWheelView.this.f3286.onAnimChange(z);
            }
        }

        @Override // com.blink.academy.film.widgets.iso.WheelProgressView.InterfaceC1252
        public void onDown() {
            if (FocusZoomWheelView.this.f3286 != null) {
                FocusZoomWheelView.this.f3286.onTouchChange(true);
                FocusZoomWheelView.this.f3286.onTouchChange2(true);
            }
        }

        @Override // com.blink.academy.film.widgets.iso.WheelProgressView.InterfaceC1252
        public void onUp() {
            if (FocusZoomWheelView.this.f3286 != null) {
                FocusZoomWheelView.this.f3286.onTouchChange(false);
                FocusZoomWheelView.this.f3286.onTouchChange2(false);
            }
            C4535.m13880().m13915();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.FocusZoomWheelView$ށ, reason: contains not printable characters */
    public class C1172 implements WheelProgressView.InterfaceC1252 {
        public C1172() {
        }

        @Override // com.blink.academy.film.widgets.iso.WheelProgressView.InterfaceC1252
        public void onAnimChange(boolean z) {
            if (FocusZoomWheelView.this.f3286 != null) {
                FocusZoomWheelView.this.f3286.onAnimChange(z);
            }
        }

        @Override // com.blink.academy.film.widgets.iso.WheelProgressView.InterfaceC1252
        public void onDown() {
            if (FocusZoomWheelView.this.f3286 != null) {
                FocusZoomWheelView.this.f3286.onTouchChange2(true);
            }
        }

        @Override // com.blink.academy.film.widgets.iso.WheelProgressView.InterfaceC1252
        public void onUp() {
            if (FocusZoomWheelView.this.f3286 != null) {
                FocusZoomWheelView.this.f3286.onTouchChange2(false);
            }
            C4535.m13880().m13915();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.FocusZoomWheelView$ނ, reason: contains not printable characters */
    public class RunnableC1173 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ String f3303;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ float f3304;

        public RunnableC1173(String str, float f) {
            this.f3303 = str;
            this.f3304 = f;
        }

        @Override // java.lang.Runnable
        public void run() {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) FocusZoomWheelView.this.f3274.f16698.getLayoutParams();
            float fMeasureText = FocusZoomWheelView.this.f3274.f16702.getPaint().measureText(this.f3303);
            int iMeasureText = ((int) FocusZoomWheelView.this.f3274.f16704.getPaint().measureText(FocusZoomWheelView.this.getResources().getString(R.string.RECORDING_WHEELS_ZOOM).toUpperCase())) / 2;
            int i = ((int) fMeasureText) / 2;
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) FocusZoomWheelView.this.f3274.f16703.getLayoutParams();
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) FocusZoomWheelView.this.f3274.f16704.getLayoutParams();
            layoutParams3.width = (int) (C4792.f16138 + fMeasureText);
            layoutParams3.height = layoutParams2.width;
            layoutParams3.leftMargin = (int) (((layoutParams.leftMargin + layoutParams.width) - (fMeasureText / 2.0f)) + (C4792.m14375().m14476(65) * this.f3304) + 0.5f);
            int i2 = (iMeasureText - i) / 2;
            layoutParams3.topMargin = ((-iMeasureText) + i2) - C4792.m14375().m14476(30);
            FocusZoomWheelView.this.f3274.f16704.setLayoutParams(layoutParams3);
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) FocusZoomWheelView.this.f3274.f16702.getLayoutParams();
            layoutParams4.width = (int) (fMeasureText + C4792.f16138);
            layoutParams4.leftMargin = layoutParams3.leftMargin;
            layoutParams4.height = layoutParams2.width;
            layoutParams4.topMargin = i + i2 + C4792.m14375().m14476(30);
            FocusZoomWheelView.this.f3274.f16702.setLayoutParams(layoutParams4);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.FocusZoomWheelView$ރ, reason: contains not printable characters */
    public class C1174 extends AnimatorListenerAdapter {
        public C1174() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.FocusZoomWheelView$ބ, reason: contains not printable characters */
    public interface InterfaceC1175 {
        /* renamed from: Ϳ */
        void mo1325();
    }

    /* renamed from: com.blink.academy.film.widgets.iso.FocusZoomWheelView$ޅ, reason: contains not printable characters */
    public interface InterfaceC1176 {
        void onAnimChange(boolean z);

        void onFocusChange(float f);

        void onHideAB();

        void onModeChange(boolean z);

        void onTouchChange(boolean z);

        void onTouchChange2(boolean z);

        void onZoomChange(float f);

        void onZoomEnableChange(boolean z);
    }

    public FocusZoomWheelView(@NonNull Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ސ, reason: contains not printable characters */
    public /* synthetic */ void m3253(ValueAnimator valueAnimator) {
        this.f3274.f16697.setPro(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ޑ, reason: contains not printable characters */
    public /* synthetic */ void m3254(ValueAnimator valueAnimator) {
        this.f3274.f16705.setPro(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    public float getCurrentFocusWheelDegree() {
        return this.f3274.f16697.getCurrentDegree();
    }

    public WheelProgressView getFocusWheel() {
        return this.f3274.f16697;
    }

    public void setCardWidth(int i) {
        this.f3285 = i;
    }

    public void setFocusEnable(boolean z) {
        this.f3274.f16697.setEnabled(z);
        this.f3274.f16700.setEnabled(z);
        if (z) {
            this.f3274.f16702.setAlpha(1.0f);
            this.f3274.f16698.setAlpha(1.0f);
            return;
        }
        if (!this.f3276) {
            this.f3276 = true;
            C3947.m12727().m12800(this.f3276, true);
            m3258();
            InterfaceC1176 interfaceC1176 = this.f3286;
            if (interfaceC1176 != null) {
                interfaceC1176.onModeChange(this.f3276);
            }
        }
        this.f3274.f16702.setAlpha(0.2f);
    }

    public void setHandler(WeakHandler weakHandler) {
        this.f3274.f16697.setHandler(weakHandler);
        this.f3274.f16705.setHandler(weakHandler);
    }

    public void setOnValueChange(InterfaceC1176 interfaceC1176) {
        this.f3286 = interfaceC1176;
    }

    public void setZoomEnable(boolean z) {
        this.f3274.f16705.setEnabled(z);
        this.f3274.f16701.setEnabled(z);
        if (z) {
            this.f3274.f16704.setAlpha(1.0f);
            this.f3274.f16698.setAlpha(1.0f);
            this.f3274.f16705.setAlpha(1.0f);
        } else {
            if (!this.f3274.f16697.isEnabled()) {
                this.f3274.f16705.setAlpha(0.2f);
                this.f3274.f16698.setAlpha(0.2f);
            } else if (this.f3276) {
                this.f3276 = false;
                C3947.m12727().m12800(this.f3276, true);
                m3258();
                InterfaceC1176 interfaceC1176 = this.f3286;
                if (interfaceC1176 != null) {
                    interfaceC1176.onModeChange(this.f3276);
                }
            }
            this.f3274.f16704.setAlpha(0.2f);
        }
        InterfaceC1176 interfaceC11762 = this.f3286;
        if (interfaceC11762 != null) {
            interfaceC11762.onZoomEnableChange(this.f3274.f16705.isEnabled());
        }
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public void m3255() {
        this.f3274.f16705.cancelClickMove();
        this.f3274.f16697.cancelClickMove();
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public void m3256() {
        this.f3274.f16697.m3482();
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public void m3257(float f, float f2) {
        this.f3282 = 0.0f;
        ValueAnimator valueAnimator = this.f3279;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            float fFloatValue = ((Float) this.f3279.getAnimatedValue()).floatValue();
            this.f3279.cancel();
            if (this.f3281 == f2) {
                this.f3282 = (1.0f - fFloatValue) * f;
            }
        }
        this.f3281 = f2;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f3279 = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(100L);
        this.f3279.setInterpolator(new LinearInterpolator());
        this.f3279.addUpdateListener(new C1163(f, f2));
        this.f3279.addListener(new C1164());
        this.f3279.start();
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public final void m3258() {
        if (this.f3276) {
            this.f3274.f16704.setContentTextColor(C4792.m14375().m14431());
            this.f3274.f16702.setContentTextColor(this.f3284);
            this.f3274.f16697.setVisibility(8);
            this.f3274.f16705.setVisibility(0);
            return;
        }
        this.f3274.f16702.setContentTextColor(C4792.m14375().m14431());
        this.f3274.f16704.setContentTextColor(this.f3284);
        this.f3274.f16697.setVisibility(0);
        this.f3274.f16705.setVisibility(8);
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public final Bitmap m3259(Resources resources, int i) throws Resources.NotFoundException {
        TypedValue typedValue = new TypedValue();
        resources.openRawResource(i, typedValue);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inTargetDensity = typedValue.density;
        return BitmapFactory.decodeResource(resources, i, options);
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public void m3260(int i, InterfaceC1175 interfaceC1175) {
        this.f3283 = true;
        this.f3274.f16697.m3484(i, new C1165(interfaceC1175));
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public float m3261(boolean z) {
        return z ? this.f3274.f16705.getNowDegree() : this.f3274.f16697.getNowDegree();
    }

    /* renamed from: އ, reason: contains not printable characters */
    public float m3262(boolean z) {
        return z ? this.f3274.f16705.getDegreeFromPercent(C3947.m12727().m12742()) : this.f3274.f16697.getDegreeFromPercent(C3947.m12727().m12736());
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public final int m3263(Paint paint, String str) {
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

    /* JADX WARN: Removed duplicated region for block: B:29:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x027b  */
    /* renamed from: މ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.graphics.Bitmap m3264(int r34, int r35, int r36) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 722
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blink.academy.film.widgets.iso.FocusZoomWheelView.m3264(int, int, int):android.graphics.Bitmap");
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public void m3265(int i) {
        C4008.m12886(this, this.f3285, 0.0f, i, null);
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public final void m3266() {
        this.f3274 = AbstractC4968.m14748(LayoutInflater.from(getContext()), this, true);
        m3267();
        m3269();
        m3268();
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public final void m3267() {
        float fM14434 = C4792.m14375().m14434();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f3274.f16698.getLayoutParams();
        layoutParams.width = (int) (((C4792.m14375().m14476(33) + (C4792.m14375().m14443() * 2.0f)) * fM14434) + 0.5f);
        int iM14476 = (int) (((C4792.m14375().m14476(20) + (C4792.m14375().m14443() * 2.0f)) * fM14434) + 0.5f);
        layoutParams.height = iM14476;
        layoutParams.height = iM14476 + (iM14476 % 2);
        layoutParams.leftMargin = (int) (((C4792.m14375().m14476(161) + C4792.m14375().m14443()) * fM14434) + 0.5f);
        this.f3274.f16698.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f3274.f16703.getLayoutParams();
        layoutParams2.leftMargin = (int) (((C4792.m14375().m14476(26) + layoutParams.width + layoutParams.leftMargin) * fM14434) + 0.5f);
        layoutParams2.width = (int) ((C4792.m14375().m14476(88) * fM14434) + 0.5f);
        layoutParams2.height = (int) ((C4792.m14375().m14476(325) * fM14434) + 0.5f);
        this.f3274.f16703.setLayoutParams(layoutParams2);
        this.f3274.f16697.setDegrees(60.0f, -60.0f, 30.0f);
        this.f3274.f16705.setDegrees(60.0f, -60.0f);
        this.f3274.f16705.setRightView(true);
        this.f3274.f16697.setRightView(true);
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public final void m3268() {
        this.f3274.f16705.setOnProChange(new C1166());
        this.f3274.f16697.setOnProChange(new C1167());
        this.f3274.f16697.m3485(new C1168());
        this.f3274.f16700.setOnClickListener(new ViewOnClickListenerC1169());
        this.f3274.f16701.setOnClickListener(new ViewOnClickListenerC1170());
        this.f3274.f16697.setOnTouchStateChange(new C1171());
        this.f3274.f16705.setOnTouchStateChange(new C1172());
    }

    /* renamed from: ގ, reason: contains not printable characters */
    public final void m3269() {
        float fM14434 = C4792.m14375().m14434();
        this.f3274.f16697.setWheelImage(m3264(60, -60, 30));
        this.f3274.f16705.setWheelImage(m3264(60, -60, 0));
        String upperCase = getResources().getString(R.string.RECORDING_WHEELS_FOCUS).toUpperCase();
        this.f3274.f16704.setText(R.string.RECORDING_WHEELS_ZOOM);
        this.f3274.f16702.setText(upperCase);
        this.f3274.f16702.m2562(0, C4792.m14375().m14377() * fM14434);
        this.f3274.f16704.m2562(0, C4792.m14375().m14377() * fM14434);
        this.f3274.f16702.post(new RunnableC1173(upperCase, fM14434));
    }

    /* renamed from: ޏ, reason: contains not printable characters */
    public boolean m3270() {
        return this.f3283;
    }

    /* renamed from: ޒ, reason: contains not printable characters */
    public void m3271() {
        this.f3274.f16697.setPro(C3947.m12727().m12736());
    }

    /* renamed from: ޓ, reason: contains not printable characters */
    public void m3272(float f) {
        float fM12736 = C3947.m12727().m12736();
        ValueAnimator valueAnimator = this.f3278;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f3278.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f, fM12736);
        this.f3278 = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(100L);
        this.f3278.setInterpolator(new LinearInterpolator());
        this.f3278.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ກ
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                this.f16654.m3253(valueAnimator2);
            }
        });
        this.f3278.addListener(new C1161());
        this.f3278.start();
    }

    /* renamed from: ޔ, reason: contains not printable characters */
    public final void m3273() {
        float fM12736 = C3947.m12727().m12736();
        float fM12742 = C3947.m12727().m12742();
        if (C3947.f13602) {
            C4638.m14099(f3273, "currentFocusP:" + fM12736 + " currentZoomP:" + fM12742);
        }
        this.f3274.f16697.setPro(fM12736);
        this.f3274.f16705.setPro(fM12742);
        this.f3276 = C3947.m12727().m12772();
        m3258();
    }

    /* renamed from: ޕ, reason: contains not printable characters */
    public void m3274() {
        this.f3276 = C4535.m13880().m13890().m12490();
        C3947.m12727().m12800(this.f3276, true);
        m3258();
    }

    /* renamed from: ޖ, reason: contains not printable characters */
    public void m3275() {
        this.f3274.f16705.setPro(C3947.m12727().m12742());
    }

    /* renamed from: ޗ, reason: contains not printable characters */
    public void m3276(float f) {
        float fM12742 = C3947.m12727().m12742();
        ValueAnimator valueAnimator = this.f3277;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f3277.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f, fM12742);
        this.f3277 = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(100L);
        this.f3277.setInterpolator(new LinearInterpolator());
        this.f3277.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ຮ
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                this.f16751.m3254(valueAnimator2);
            }
        });
        this.f3277.addListener(new C1174());
        this.f3277.start();
    }

    /* renamed from: ޘ, reason: contains not printable characters */
    public void m3277(boolean z, float f) {
        if (z) {
            this.f3274.f16697.onAnimValueChange(f);
        } else {
            this.f3274.f16705.onAnimValueChange(f);
        }
    }

    /* renamed from: ޙ, reason: contains not printable characters */
    public void m3278(int i) {
        m3273();
        C4008.m12886(this, 0.0f, 0.0f, i, null);
    }

    /* renamed from: ޚ, reason: contains not printable characters */
    public void m3279(boolean z) {
        this.f3274.f16699.setVisibility(z ? 0 : 8);
    }

    /* renamed from: ޛ, reason: contains not printable characters */
    public void m3280() {
        if (this.f3276) {
            if (this.f3274.f16700.isEnabled()) {
                this.f3274.f16700.performClick();
            }
        } else if (this.f3274.f16701.isEnabled()) {
            this.f3274.f16701.performClick();
        }
    }

    public FocusZoomWheelView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FocusZoomWheelView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3277 = null;
        this.f3278 = null;
        this.f3279 = null;
        this.f3280 = new C1162();
        this.f3284 = Color.parseColor("#ffffff");
        m3266();
    }
}
