package com.blink.academy.film.widgets.exposure;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;
import com.blink.academy.film.widgets.exposure.SlideBarView;
import defpackage.AbstractC5215;
import defpackage.C2579;
import defpackage.C4792;

/* loaded from: classes.dex */
public class CameraTouchView extends RelativeLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public View f3156;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public SlideBarView f3157;

    /* renamed from: ԭ, reason: contains not printable characters */
    public AbstractC5215 f3158;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public boolean f3159;

    /* renamed from: com.blink.academy.film.widgets.exposure.CameraTouchView$Ϳ, reason: contains not printable characters */
    public class C1142 extends AnimatorListenerAdapter {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ InterfaceC1143 f3160;

        public C1142(InterfaceC1143 interfaceC1143) {
            this.f3160 = interfaceC1143;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            InterfaceC1143 interfaceC1143 = this.f3160;
            if (interfaceC1143 != null) {
                interfaceC1143.mo1326();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.exposure.CameraTouchView$Ԩ, reason: contains not printable characters */
    public interface InterfaceC1143 {
        /* renamed from: Ϳ */
        void mo1326();
    }

    public CameraTouchView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Ԭ, reason: contains not printable characters */
    public /* synthetic */ void m3147(ValueAnimator valueAnimator) {
        this.f3156.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    public float getTouchViewAlpha() {
        return this.f3156.getAlpha();
    }

    public void setDrawIcon(boolean z) {
        this.f3159 = z;
        this.f3157.setNeedDrawIcon(z);
    }

    public void setLineAlpha(int i) {
        this.f3157.m3170(i);
    }

    public void setNeedDrawLine(boolean z) {
        this.f3157.setNeedDrawLine(z);
    }

    public void setSlidebarAlpha(float f) {
        this.f3157.setAlpha(f);
    }

    public void setSlidebarAndTouchAlpha(float f) {
        this.f3156.setAlpha(f);
        this.f3157.setAlpha(f);
    }

    public void setSlidebarCallback(SlideBarView.InterfaceC1144 interfaceC1144) {
        this.f3157.setCallBack(interfaceC1144);
    }

    public void setViewAlpha(float f) {
        setAlpha(f);
        this.f3156.setAlpha(f);
        this.f3157.setAlpha(f);
    }

    public void setViewScale(Float f) {
        setScaleX(f.floatValue());
        setScaleY(f.floatValue());
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m3148() {
        Animation animation = this.f3156.getAnimation();
        if (animation != null) {
            animation.setAnimationListener(null);
            animation.cancel();
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public void m3149() {
        this.f3156.clearAnimation();
        this.f3157.clearAnimation();
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public void m3150() {
        this.f3157.m3166();
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final void m3151(Context context, AttributeSet attributeSet) {
        AbstractC5215 abstractC5215M15220 = AbstractC5215.m15220(LayoutInflater.from(getContext()), this, true);
        this.f3158 = abstractC5215M15220;
        TouchSquareView touchSquareView = abstractC5215M15220.f17274;
        this.f3156 = touchSquareView;
        this.f3157 = abstractC5215M15220.f17273;
        ViewGroup.LayoutParams layoutParams = touchSquareView.getLayoutParams();
        layoutParams.width = C2579.m9438(130.0f);
        layoutParams.height = C2579.m9438(130.0f);
        this.f3156.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.f3157.getLayoutParams();
        layoutParams2.width = C2579.m9438(50.0f);
        layoutParams2.height = C2579.m9438(240.0f);
        this.f3157.setLayoutParams(layoutParams2);
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public boolean m3152() {
        return this.f3157.m3167();
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public void m3153(float f, boolean z, float f2) {
        this.f3157.m3168(f, z, f2);
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public void m3154() {
        setScaleX(1.0f);
        setScaleY(1.0f);
        this.f3156.setAlpha(1.0f);
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public void m3155() {
        this.f3157.m3169();
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public void m3156() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f3157.getLayoutParams();
        layoutParams.leftMargin = C2579.m9438(25.0f);
        this.f3157.setLayoutParams(layoutParams);
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public void m3157(float f, int i, InterfaceC1143 interfaceC1143) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.f3156.getAlpha(), f);
        valueAnimatorOfFloat.setDuration(i);
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ໄ
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f16770.m3147(valueAnimator);
            }
        });
        valueAnimatorOfFloat.addListener(new C1142(interfaceC1143));
        valueAnimatorOfFloat.start();
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public void m3158() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f3157.getLayoutParams();
        layoutParams.leftMargin = C2579.m9438(C4792.m14375().m14415() - 75);
        this.f3157.setLayoutParams(layoutParams);
    }

    public CameraTouchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CameraTouchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m3151(context, attributeSet);
    }
}
