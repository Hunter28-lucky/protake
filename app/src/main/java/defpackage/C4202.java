package defpackage;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.os.Message;
import android.view.animation.LinearInterpolator;
import com.blink.academy.film.custom.WeakHandler;

/* compiled from: FocusTouchHelper.java */
/* renamed from: শ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4202 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static C4202 f14489;

    /* compiled from: FocusTouchHelper.java */
    /* renamed from: শ$Ϳ, reason: contains not printable characters */
    public class C4203 implements Animator.AnimatorListener {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ InterfaceC4205 f14490;

        public C4203(InterfaceC4205 interfaceC4205) {
            this.f14490 = interfaceC4205;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            InterfaceC4205 interfaceC4205 = this.f14490;
            if (interfaceC4205 != null) {
                interfaceC4205.end();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* compiled from: FocusTouchHelper.java */
    /* renamed from: শ$Ԩ, reason: contains not printable characters */
    public class C4204 implements Animator.AnimatorListener {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ InterfaceC4205 f14492;

        public C4204(InterfaceC4205 interfaceC4205) {
            this.f14492 = interfaceC4205;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            InterfaceC4205 interfaceC4205 = this.f14492;
            if (interfaceC4205 != null) {
                interfaceC4205.end();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* compiled from: FocusTouchHelper.java */
    /* renamed from: শ$Ԫ, reason: contains not printable characters */
    public interface InterfaceC4205 {
        void end();

        /* renamed from: Ϳ */
        void mo10644(float f);
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static C4202 m13274() {
        if (f14489 == null) {
            synchronized (C4202.class) {
                if (f14489 == null) {
                    f14489 = new C4202();
                }
            }
        }
        return f14489;
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public static /* synthetic */ void m13275(InterfaceC4205 interfaceC4205, ValueAnimator valueAnimator) {
        Float f = (Float) valueAnimator.getAnimatedValue();
        if (interfaceC4205 != null) {
            interfaceC4205.mo10644(f.floatValue());
        }
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public static /* synthetic */ void m13276(InterfaceC4205 interfaceC4205, ValueAnimator valueAnimator) {
        Float f = (Float) valueAnimator.getAnimatedValue();
        if (interfaceC4205 != null) {
            interfaceC4205.mo10644(f.floatValue());
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public void m13277(float f, float f2, int i, final InterfaceC4205 interfaceC4205) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f, f2);
        valueAnimatorOfFloat.setDuration(i);
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: จ
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                C4202.m13275(interfaceC4205, valueAnimator);
            }
        });
        valueAnimatorOfFloat.addListener(new C4203(interfaceC4205));
        valueAnimatorOfFloat.start();
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public void m13278(WeakHandler weakHandler, boolean z, boolean z2) {
        Message messageObtain = Message.obtain();
        messageObtain.what = z ? 105 : 107;
        if (z2) {
            messageObtain.what = 108;
        }
        weakHandler.sendMessage(messageObtain);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public void m13279(float f, float f2, int i, final InterfaceC4205 interfaceC4205) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f, f2);
        valueAnimatorOfFloat.setDuration(i);
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: Ⴑ
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                C4202.m13276(interfaceC4205, valueAnimator);
            }
        });
        valueAnimatorOfFloat.addListener(new C4204(interfaceC4205));
        valueAnimatorOfFloat.start();
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public float m13280() {
        return 1.0f;
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public float m13281() {
        return 1.2f;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public float m13282() {
        return 0.6f;
    }
}
