package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.view.animation.ScaleAnimation;
import androidx.core.view.ViewCompat;

/* compiled from: AnimationUtil.java */
/* renamed from: ࢾ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4008 {

    /* compiled from: AnimationUtil.java */
    /* renamed from: ࢾ$Ϳ, reason: contains not printable characters */
    public class C4009 implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ l5 f13966;

        public C4009(l5 l5Var) {
            this.f13966 = l5Var;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Integer num = (Integer) valueAnimator.getAnimatedValue();
            l5 l5Var = this.f13966;
            if (l5Var != null) {
                l5Var.mo1307(num.floatValue());
            }
        }
    }

    /* compiled from: AnimationUtil.java */
    /* renamed from: ࢾ$Ԩ, reason: contains not printable characters */
    public class C4010 extends AnimatorListenerAdapter {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ l5 f13967;

        public C4010(l5 l5Var) {
            this.f13967 = l5Var;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            l5 l5Var = this.f13967;
            if (l5Var != null) {
                l5Var.mo1305();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            l5 l5Var = this.f13967;
            if (l5Var != null) {
                l5Var.mo1306();
            }
        }
    }

    /* compiled from: AnimationUtil.java */
    /* renamed from: ࢾ$Ԫ, reason: contains not printable characters */
    public class C4011 extends AnimatorListenerAdapter {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ l5 f13968;

        public C4011(l5 l5Var) {
            this.f13968 = l5Var;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            this.f13968.mo1305();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            this.f13968.mo1306();
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static void m12876(View view, float f, int i, AbstractC4012 abstractC4012) {
        if (view.getVisibility() != 0) {
            view.setAlpha(0.0f);
            view.setVisibility(0);
        }
        ViewCompat.animate(view).alpha(f).setDuration(i).setInterpolator(m12881()).setListener(abstractC4012).start();
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static void m12877(View view, float f, int i, AbstractC4012 abstractC4012) {
        ViewCompat.animate(view).alpha(f).setDuration(i).setInterpolator(m12881()).setListener(abstractC4012).start();
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static void m12878(View view, int i, AbstractC4012 abstractC4012) {
        ViewCompat.animate(view).alpha(1.0f).setDuration(i).setInterpolator(new DecelerateInterpolator()).setListener(abstractC4012).start();
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static void m12879(View view, int i, AbstractC4012 abstractC4012) {
        ViewCompat.animate(view).alpha(0.0f).setDuration(i).setInterpolator(new AccelerateInterpolator()).setListener(abstractC4012).start();
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static void m12880(float f, float f2, long j, final l5 l5Var) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f, f2);
        valueAnimatorOfFloat.setDuration(j);
        valueAnimatorOfFloat.setInterpolator(m12881());
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ࢽ
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                C4008.m12882(l5Var, valueAnimator);
            }
        });
        valueAnimatorOfFloat.addListener(new C4011(l5Var));
        valueAnimatorOfFloat.start();
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static Interpolator m12881() {
        return new PathInterpolator(0.42f, 0.0f, 0.58f, 1.0f);
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static /* synthetic */ void m12882(l5 l5Var, ValueAnimator valueAnimator) {
        if (l5Var == null) {
            return;
        }
        l5Var.mo1307(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public static void m12883(View view, float f, float f2, float f3, float f4, int i, Animation.AnimationListener animationListener) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(f, f2, f, f2, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setRepeatCount(-1);
        scaleAnimation.setRepeatMode(1);
        AlphaAnimation alphaAnimation = new AlphaAnimation(f3, f4);
        alphaAnimation.setRepeatCount(-1);
        alphaAnimation.setRepeatMode(1);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.setInterpolator(m12881());
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.setDuration(i);
        animationSet.setRepeatMode(1);
        animationSet.setRepeatCount(-1);
        animationSet.setAnimationListener(animationListener);
        view.startAnimation(animationSet);
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public static void m12884(View view, float f, float f2, int i, AbstractC4012 abstractC4012) {
        ViewCompat.animate(view).scaleX(f).scaleY(f2).setDuration(i).setInterpolator(m12881()).setListener(abstractC4012).start();
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public static void m12885(long j, int i, int i2, l5 l5Var) {
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(i, i2);
        valueAnimatorOfInt.setInterpolator(m12881());
        valueAnimatorOfInt.setDuration(j);
        valueAnimatorOfInt.addUpdateListener(new C4009(l5Var));
        valueAnimatorOfInt.addListener(new C4010(l5Var));
        valueAnimatorOfInt.start();
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public static void m12886(View view, float f, float f2, int i, AbstractC4012 abstractC4012) {
        ViewCompat.animate(view).translationX(f).translationY(f2).setDuration(i).setInterpolator(m12881()).setListener(abstractC4012).start();
    }
}
