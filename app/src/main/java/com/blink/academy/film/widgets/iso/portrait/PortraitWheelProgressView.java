package com.blink.academy.film.widgets.iso.portrait;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.custom.ABPointMessage;
import com.blink.academy.film.custom.WeakHandler;
import com.google.mlkit.common.MlKitException;
import defpackage.AbstractC3611;
import defpackage.C3947;
import defpackage.C4008;
import defpackage.C4638;
import defpackage.C4792;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes.dex */
public class PortraitWheelProgressView extends FrameLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC3611 f3684;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public boolean f3685;

    /* renamed from: ԭ, reason: contains not printable characters */
    public long f3686;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public float f3687;

    /* renamed from: ԯ, reason: contains not printable characters */
    public float f3688;

    /* renamed from: ՠ, reason: contains not printable characters */
    public float f3689;

    /* renamed from: ֈ, reason: contains not printable characters */
    public int f3690;

    /* renamed from: ֏, reason: contains not printable characters */
    public WeakHandler f3691;

    /* renamed from: ׯ, reason: contains not printable characters */
    public Timer f3692;

    /* renamed from: ؠ, reason: contains not printable characters */
    public ABPointMessage f3693;

    /* renamed from: ހ, reason: contains not printable characters */
    public int f3694;

    /* renamed from: ށ, reason: contains not printable characters */
    public ValueAnimator f3695;

    /* renamed from: ނ, reason: contains not printable characters */
    public int f3696;

    /* renamed from: ރ, reason: contains not printable characters */
    public int f3697;

    /* renamed from: ބ, reason: contains not printable characters */
    public int f3698;

    /* renamed from: ޅ, reason: contains not printable characters */
    public int f3699;

    /* renamed from: ކ, reason: contains not printable characters */
    public int f3700;

    /* renamed from: އ, reason: contains not printable characters */
    public int f3701;

    /* renamed from: ވ, reason: contains not printable characters */
    public int f3702;

    /* renamed from: މ, reason: contains not printable characters */
    public int f3703;

    /* renamed from: ފ, reason: contains not printable characters */
    public int f3704;

    /* renamed from: ދ, reason: contains not printable characters */
    public int f3705;

    /* renamed from: ތ, reason: contains not printable characters */
    public float f3706;

    /* renamed from: ލ, reason: contains not printable characters */
    public float f3707;

    /* renamed from: ގ, reason: contains not printable characters */
    public float f3708;

    /* renamed from: ޏ, reason: contains not printable characters */
    public InterfaceC1314 f3709;

    /* renamed from: ސ, reason: contains not printable characters */
    public InterfaceC1313 f3710;

    /* renamed from: ޑ, reason: contains not printable characters */
    public InterfaceC1312 f3711;

    /* renamed from: com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView$Ϳ, reason: contains not printable characters */
    public class ViewOnTouchListenerC1303 implements View.OnTouchListener {
        public ViewOnTouchListenerC1303() {
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0027  */
        @Override // android.view.View.OnTouchListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean onTouch(android.view.View r4, android.view.MotionEvent r5) {
            /*
                r3 = this;
                com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView r4 = com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView.this
                boolean r4 = r4.isEnabled()
                if (r4 == 0) goto L79
                com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView r4 = com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView.this
                boolean r4 = com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView.m3592(r4)
                if (r4 == 0) goto L11
                goto L79
            L11:
                int r4 = r5.getAction()
                r0 = 1
                if (r4 == 0) goto L43
                if (r4 == r0) goto L27
                r1 = 2
                if (r4 == r1) goto L21
                r1 = 3
                if (r4 == r1) goto L27
                goto L78
            L21:
                com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView r4 = com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView.this
                com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView.m3620(r4, r5)
                goto L78
            L27:
                com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView r4 = com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView.this
                com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView.m3621(r4, r5)
                com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView r4 = com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView.this
                com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView.m3622(r4)
                com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView r4 = com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView.this
                com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView$ׯ r4 = com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView.m3619(r4)
                if (r4 == 0) goto L78
                com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView r4 = com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView.this
                com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView$ׯ r4 = com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView.m3619(r4)
                r4.onUp()
                goto L78
            L43:
                com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView r4 = com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView.this
                float r1 = r5.getRawY()
                com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView.m3595(r4, r1)
                com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView r4 = com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView.this
                float r1 = r5.getRawX()
                com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView.m3609(r4, r1)
                com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView r4 = com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView.this
                float r5 = r5.getRawY()
                com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView.m3617(r4, r5)
                com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView r4 = com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView.this
                long r1 = java.lang.System.currentTimeMillis()
                com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView.m3618(r4, r1)
                com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView r4 = com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView.this
                com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView$ׯ r4 = com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView.m3619(r4)
                if (r4 == 0) goto L78
                com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView r4 = com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView.this
                com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView$ׯ r4 = com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView.m3619(r4)
                r4.onDown()
            L78:
                return r0
            L79:
                r4 = 0
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView.ViewOnTouchListenerC1303.onTouch(android.view.View, android.view.MotionEvent):boolean");
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView$Ԩ, reason: contains not printable characters */
    public class C1304 extends TimerTask {

        /* renamed from: com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView$Ԩ$Ϳ, reason: contains not printable characters */
        public class RunnableC1305 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ float f3714;

            public RunnableC1305(float f) {
                this.f3714 = f;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (PortraitWheelProgressView.this.f3710 != null) {
                    PortraitWheelProgressView.this.f3710.onChange(((PortraitWheelProgressView.this.f3703 - this.f3714) * 1.0f) / (PortraitWheelProgressView.this.f3696 - PortraitWheelProgressView.this.f3697));
                }
            }
        }

        /* renamed from: com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView$Ԩ$Ԩ, reason: contains not printable characters */
        public class RunnableC1306 implements Runnable {
            public RunnableC1306() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PortraitWheelProgressView.this.m3625();
            }
        }

        /* renamed from: com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView$Ԩ$Ԫ, reason: contains not printable characters */
        public class RunnableC1307 implements Runnable {
            public RunnableC1307() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PortraitWheelProgressView.this.m3625();
            }
        }

        public C1304() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (PortraitWheelProgressView.this.f3693 == null) {
                PortraitWheelProgressView.this.f3691.post(new RunnableC1307());
                return;
            }
            if (System.currentTimeMillis() >= PortraitWheelProgressView.this.f3693.getStartMs() + PortraitWheelProgressView.this.f3693.getTotalMs()) {
                PortraitWheelProgressView.this.f3691.post(new RunnableC1306());
                return;
            }
            long totalMs = PortraitWheelProgressView.this.f3693.getTotalMs();
            long jCurrentTimeMillis = System.currentTimeMillis() - PortraitWheelProgressView.this.f3693.getStartMs();
            float startFocusP = PortraitWheelProgressView.this.f3693.getStartFocusP();
            PortraitWheelProgressView.this.f3691.post(new RunnableC1305(startFocusP + (((jCurrentTimeMillis * 1.0f) / totalMs) * (PortraitWheelProgressView.this.f3693.getEndFocusP() - startFocusP))));
            Message messageObtain = Message.obtain();
            messageObtain.obj = PortraitWheelProgressView.this.f3693;
            messageObtain.what = MlKitException.CODE_SCANNER_APP_NAME_UNAVAILABLE;
            PortraitWheelProgressView.this.f3691.sendMessageDelayed(messageObtain, (1 / C3947.m12727().m12747()) * 1000);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView$Ԫ, reason: contains not printable characters */
    public class RunnableC1308 implements Runnable {
        public RunnableC1308() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (PortraitWheelProgressView.this.f3710 != null) {
                PortraitWheelProgressView portraitWheelProgressView = PortraitWheelProgressView.this;
                portraitWheelProgressView.f3708 = portraitWheelProgressView.m3624();
                if (PortraitWheelProgressView.this.f3708 > 1.1f) {
                    PortraitWheelProgressView.this.f3708 = 1.25f;
                }
                if (PortraitWheelProgressView.this.f3708 < 0.1f) {
                    PortraitWheelProgressView.this.f3708 = -0.25f;
                }
                PortraitWheelProgressView.this.f3710.onChange(PortraitWheelProgressView.this.f3708);
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView$Ԭ, reason: contains not printable characters */
    public class RunnableC1309 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ MotionEvent f3719;

        public RunnableC1309(MotionEvent motionEvent) {
            this.f3719 = motionEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            float rawY = this.f3719.getRawY() - PortraitWheelProgressView.this.f3687;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(PortraitWheelProgressView.this.f3684.f12551.getLayoutParams());
            float top = PortraitWheelProgressView.this.f3684.f12551.getTop() + rawY;
            float fMax = Math.max(PortraitWheelProgressView.this.f3697, Math.min(PortraitWheelProgressView.this.f3696, top));
            boolean z = true;
            if (PortraitWheelProgressView.this.f3704 == 2) {
                float f = (PortraitWheelProgressView.this.f3696 - PortraitWheelProgressView.this.f3697) * 0.5f;
                if (Math.abs(fMax - (PortraitWheelProgressView.this.f3703 - f)) < 2.0f) {
                    if (PortraitWheelProgressView.this.f3694 < 10) {
                        fMax = PortraitWheelProgressView.this.f3703 - f;
                        PortraitWheelProgressView.m3607(PortraitWheelProgressView.this);
                    } else {
                        PortraitWheelProgressView.this.f3694 = 0;
                    }
                }
            } else if (PortraitWheelProgressView.this.f3704 == 4) {
                float fMin = Math.min(Math.max(top, PortraitWheelProgressView.this.f3699), PortraitWheelProgressView.this.f3698);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) PortraitWheelProgressView.this.f3684.f12551.getLayoutParams();
                float fM12736 = C3947.m12727().m12736();
                boolean z2 = fMin >= ((float) PortraitWheelProgressView.this.f3697) ? fMin <= ((float) PortraitWheelProgressView.this.f3696) || !(fM12736 == 0.0f || fM12736 == 1.0f || fM12736 == 1.25f || fM12736 == -0.25f) : !(fM12736 == 0.0f || fM12736 == 1.0f || fM12736 == 1.25f || fM12736 == -0.25f);
                if (!z2) {
                    fMax = PortraitWheelProgressView.this.m3630(layoutParams2.topMargin, fMin, fM12736 > 1.0f ? PortraitWheelProgressView.this.f3696 : fM12736 < 0.0f ? PortraitWheelProgressView.this.f3697 : (fM12736 < 0.0f || fM12736 >= 0.1f) ? PortraitWheelProgressView.this.f3698 : PortraitWheelProgressView.this.f3699);
                    if (PortraitWheelProgressView.this.f3711 != null) {
                        PortraitWheelProgressView.this.f3711.mo3567();
                    }
                    if (Math.abs(fMax - PortraitWheelProgressView.this.f3697) > 0.1f && Math.abs(fMax - PortraitWheelProgressView.this.f3699) > 0.1f && Math.abs(fMax - PortraitWheelProgressView.this.f3696) > 0.1f && Math.abs(fMax - PortraitWheelProgressView.this.f3698) > 0.1f) {
                        z = false;
                    }
                    if (z) {
                        if (PortraitWheelProgressView.this.f3695 == null || !PortraitWheelProgressView.this.f3695.isRunning()) {
                            PortraitWheelProgressView.this.m3626();
                            PortraitWheelProgressView.this.m3628(layoutParams2.topMargin, fMax, 100);
                            return;
                        }
                        return;
                    }
                }
                z = z2;
            }
            layoutParams.topMargin = (int) fMax;
            PortraitWheelProgressView.this.f3684.f12551.setLayoutParams(layoutParams);
            PortraitWheelProgressView.this.f3684.f12551.requestLayout();
            PortraitWheelProgressView.this.f3684.f12551.invalidate();
            PortraitWheelProgressView.this.m3640(layoutParams.topMargin);
            if (PortraitWheelProgressView.this.f3710 != null && z) {
                PortraitWheelProgressView portraitWheelProgressView = PortraitWheelProgressView.this;
                portraitWheelProgressView.f3708 = portraitWheelProgressView.m3624();
                C4638.m14099("sdsdsdsdsd", "pro:" + PortraitWheelProgressView.this.f3708);
                PortraitWheelProgressView.this.f3710.onChange(PortraitWheelProgressView.this.f3708);
            }
            PortraitWheelProgressView.this.f3687 = this.f3719.getRawY();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView$Ԯ, reason: contains not printable characters */
    public class C1310 implements ValueAnimator.AnimatorUpdateListener {
        public C1310() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            PortraitWheelProgressView.this.m3638(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView$ՠ, reason: contains not printable characters */
    public class C1311 implements Animator.AnimatorListener {
        public C1311() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (PortraitWheelProgressView.this.f3710 != null) {
                PortraitWheelProgressView portraitWheelProgressView = PortraitWheelProgressView.this;
                portraitWheelProgressView.f3708 = portraitWheelProgressView.m3624();
                if (PortraitWheelProgressView.this.f3708 > 1.1f) {
                    PortraitWheelProgressView.this.f3708 = 1.25f;
                }
                if (PortraitWheelProgressView.this.f3708 < -0.1f) {
                    PortraitWheelProgressView.this.f3708 = -0.25f;
                }
                PortraitWheelProgressView.this.f3710.onChange(PortraitWheelProgressView.this.f3708);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView$ֈ, reason: contains not printable characters */
    public interface InterfaceC1312 {
        /* renamed from: Ϳ */
        void mo3567();
    }

    /* renamed from: com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView$֏, reason: contains not printable characters */
    public interface InterfaceC1313 {
        void onChange(float f);

        /* renamed from: Ϳ */
        void mo3566(int i, int i2);
    }

    /* renamed from: com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView$ׯ, reason: contains not printable characters */
    public interface InterfaceC1314 {
        void onAnimChange(boolean z);

        void onDown();

        void onUp();
    }

    public PortraitWheelProgressView(@NonNull Context context) {
        this(context, null);
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public static /* synthetic */ int m3607(PortraitWheelProgressView portraitWheelProgressView) {
        int i = portraitWheelProgressView.f3694;
        portraitWheelProgressView.f3694 = i + 1;
        return i;
    }

    public int getNowMargin() {
        return ((LinearLayout.LayoutParams) this.f3684.f12551.getLayoutParams()).topMargin;
    }

    public float getPro() {
        return this.f3708;
    }

    public int getRange() {
        return this.f3696 - this.f3697;
    }

    public void setHandler(WeakHandler weakHandler) {
        this.f3691 = weakHandler;
    }

    public void setOnHideAB(InterfaceC1312 interfaceC1312) {
        this.f3711 = interfaceC1312;
    }

    public void setOnProChange(InterfaceC1313 interfaceC1313) {
        this.f3710 = interfaceC1313;
    }

    public void setOnTouchStateChange(InterfaceC1314 interfaceC1314) {
        this.f3709 = interfaceC1314;
    }

    public void setPro(float f) {
        this.f3708 = f;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f3684.f12551.getLayoutParams());
        layoutParams.topMargin = (int) (this.f3703 - ((this.f3696 - this.f3697) * f));
        if (f == 1.25f) {
            layoutParams.topMargin = this.f3699;
        } else if (f == -0.25f) {
            layoutParams.topMargin = this.f3698;
        }
        this.f3684.f12551.setLayoutParams(layoutParams);
        m3640(layoutParams.topMargin);
    }

    /* renamed from: ޒ, reason: contains not printable characters */
    public final float m3624() {
        return ((this.f3703 - ((LinearLayout.LayoutParams) this.f3684.f12551.getLayoutParams()).topMargin) * 1.0f) / (this.f3696 - this.f3697);
    }

    /* renamed from: ޓ, reason: contains not printable characters */
    public void m3625() {
        this.f3691.removeMessages(MlKitException.CODE_SCANNER_APP_NAME_UNAVAILABLE);
        Timer timer = this.f3692;
        if (timer != null) {
            timer.cancel();
            this.f3692 = null;
        }
        m3637();
    }

    /* renamed from: ޔ, reason: contains not printable characters */
    public final void m3626() {
        ValueAnimator valueAnimator = this.f3695;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    /* renamed from: ޕ, reason: contains not printable characters */
    public final void m3627(MotionEvent motionEvent) {
        int i = this.f3704;
        if (i == 3 || i == 4) {
            m3625();
            boolean z = Math.abs(motionEvent.getRawX() - this.f3688) <= 3.0f && Math.abs(motionEvent.getRawY() - this.f3689) <= 3.0f;
            if (System.currentTimeMillis() - this.f3686 >= 200 || !z) {
                return;
            }
            int i2 = ((LinearLayout.LayoutParams) this.f3684.f12551.getLayoutParams()).topMargin;
            int y = (int) (((this.f3701 / 2) + i2) - motionEvent.getY());
            if (this.f3704 == 4) {
                int i3 = this.f3696;
                if (i2 > i3) {
                    i2 = i3;
                } else {
                    int i4 = this.f3697;
                    if (i2 < i4) {
                        i2 = i4;
                    }
                }
                if (y > i3) {
                    if (i2 == i3) {
                        i3++;
                    }
                    y = i3;
                    this.f3690 = 1;
                } else {
                    int i5 = this.f3697;
                    if (y < i5) {
                        if (i2 == i5) {
                            i5--;
                        }
                        y = i5;
                        this.f3690 = 2;
                    }
                }
            } else {
                y = Math.max(this.f3697, Math.min(this.f3696, y));
            }
            this.f3693 = new ABPointMessage();
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.f3693.setStartMs(jCurrentTimeMillis);
            this.f3693.setEndMs(jCurrentTimeMillis + ((int) (((Math.abs(y - i2) * 1.0f) / this.f3701) * 2000.0f)));
            this.f3693.setStartFocusP(i2);
            this.f3693.setEndFocusP(y);
            this.f3693.setType(this.f3704 == 4 ? 1 : 0);
            long endMs = this.f3693.getEndMs() - this.f3693.getStartMs();
            if (endMs < 0) {
                endMs = 0;
            }
            this.f3693.setTotalMs(endMs);
            Timer timer = new Timer();
            this.f3692 = timer;
            timer.schedule(new C1304(), 0L, (1000 / Math.min(C3947.m12727().m12747(), 60)) / 2);
            InterfaceC1314 interfaceC1314 = this.f3709;
            if (interfaceC1314 != null) {
                interfaceC1314.onAnimChange(true);
            }
        }
    }

    /* renamed from: ޖ, reason: contains not printable characters */
    public final void m3628(float f, float f2, int i) {
        int iAbs = (int) (((Math.abs(f2 - f) * 1.0f) / (this.f3707 / 2.0f)) * i);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f, f2);
        this.f3695 = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(iAbs);
        this.f3695.addUpdateListener(new C1310());
        this.f3695.setInterpolator(C4008.m12881());
        this.f3695.addListener(new C1311());
        this.f3695.start();
    }

    /* renamed from: ޗ, reason: contains not printable characters */
    public final void m3629() {
        if (this.f3704 == 4) {
            m3626();
            int i = ((LinearLayout.LayoutParams) this.f3684.f12551.getLayoutParams()).topMargin;
            int i2 = this.f3696;
            if (i <= i2) {
                i2 = this.f3697;
                if (i >= i2) {
                    return;
                }
                if (i2 - i >= this.f3707 / 2.0f) {
                    i2 = this.f3699;
                }
            } else if (i - i2 >= this.f3707 / 2.0f) {
                i2 = this.f3698;
            }
            m3628(i, i2, 200);
        }
    }

    /* renamed from: ޘ, reason: contains not printable characters */
    public final float m3630(float f, float f2, float f3) {
        float f4 = f2 - f;
        if (Math.abs(f4) >= 0.001f) {
            f += f4 / 1.0f;
        }
        float fAbs = Math.abs(f3 - f);
        float f5 = this.f3707;
        if (fAbs > f5 / 2.0f) {
            return f;
        }
        float f6 = (f3 != ((float) this.f3696) && (f3 == ((float) this.f3698) || f3 != ((float) this.f3699))) ? f3 - (f5 / 2.0f) : (f5 / 2.0f) + f3;
        return Math.abs(f3 - f6) <= this.f3707 / 2.0f ? f3 : f6;
    }

    /* renamed from: ޙ, reason: contains not printable characters */
    public final Bitmap m3631(int i, int i2) {
        Paint paint;
        Canvas canvas;
        float fM14434 = C4792.m14375().m14434();
        float fM14476 = C4792.m14375().m14476(5) * fM14434;
        float fM144762 = C4792.m14375().m14476(2) * fM14434;
        float fM14443 = C4792.m14375().m14443() * fM14434;
        float f = fM14443 * 2.0f;
        this.f3706 = f + fM14476;
        float f2 = f + fM144762;
        float fM144763 = C4792.m14375().m14476(30) * fM14434;
        int i3 = (int) (((i2 + 1) * this.f3706) + (i2 * 4 * f2) + (i2 * 5 * fM144763));
        this.f3705 = i3;
        this.f3705 = i3 + (i3 % 2);
        float fM144764 = C4792.m14375().m14476(34) * fM14434;
        float fM144765 = C4792.m14375().m14476(24) * fM14434;
        float f3 = f + fM144764;
        float f4 = f + fM144765;
        int i4 = i;
        if (i4 < f3) {
            i4 = (int) f3;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i4, (int) (this.f3705 + 0.5f), Bitmap.Config.ARGB_8888);
        Canvas canvas2 = new Canvas(bitmapCreateBitmap);
        Paint paint2 = new Paint(1);
        Paint paint3 = new Paint(1);
        paint3.setStyle(Paint.Style.STROKE);
        paint3.setStrokeJoin(Paint.Join.ROUND);
        paint3.setStrokeCap(Paint.Cap.ROUND);
        paint2.setColor(-1);
        paint3.setColor(ViewCompat.MEASURED_STATE_MASK);
        paint3.setStrokeWidth(fM14443);
        float f5 = 0.0f;
        float f6 = 2.0f;
        float f7 = (i4 - f3) / 2.0f;
        float f8 = ((f3 - f4) / 2.0f) + f7;
        int i5 = 0;
        while (i5 < i2) {
            if (i5 == 0) {
                float f9 = fM14443 / f6;
                float f10 = f5 + f9;
                float f11 = f7 + fM14443;
                float f12 = f10 + f9;
                float f13 = f11 + fM144764;
                paint = paint2;
                canvas = canvas2;
                canvas2.drawRect(f11, f12, f13, f12 + fM14476, paint);
                canvas.drawRect(f7 + f9, f10, f13 + f9, f10 + fM14443 + fM14476, paint3);
                f5 = f10 + (this.f3706 - f9);
            } else {
                paint = paint2;
                canvas = canvas2;
            }
            for (int i6 = 0; i6 < 4; i6++) {
                float f14 = fM14443 / 2.0f;
                float f15 = f5 + fM144763 + f14;
                float f16 = f8 + fM14443;
                float f17 = f15 + f14;
                float f18 = f16 + fM144765;
                canvas.drawRect(f16, f17, f18, f17 + fM144762, paint);
                canvas.drawRect(f8 + f14, f15, f18 + f14, f15 + fM14443 + fM144762, paint3);
                f5 = f15 + (f2 - f14);
            }
            float f19 = fM14443 / 2.0f;
            float f20 = f5 + fM144763 + f19;
            float f21 = f7 + fM14443;
            float f22 = f20 + f19;
            float f23 = f21 + fM144764;
            canvas.drawRect(f21, f22, f23, f22 + fM14476, paint);
            canvas.drawRect(f7 + f19, f20, f23 + f19, f20 + fM14443 + fM14476, paint3);
            f5 = f20 + (this.f3706 - f19);
            i5++;
            f6 = 2.0f;
            paint2 = paint;
            canvas2 = canvas;
        }
        ViewGroup.LayoutParams layoutParams = this.f3684.f12551.getLayoutParams();
        layoutParams.height = this.f3705;
        this.f3684.f12551.setLayoutParams(layoutParams);
        return bitmapCreateBitmap;
    }

    /* renamed from: ޚ, reason: contains not printable characters */
    public final Bitmap m3632(int i, int i2) {
        int i3 = i2;
        float fM14434 = C4792.m14375().m14434();
        float fM14476 = C4792.m14375().m14476(5) * fM14434;
        float fM144762 = C4792.m14375().m14476(2) * fM14434;
        float fM14443 = C4792.m14375().m14443() * fM14434;
        float f = fM14443 * 2.0f;
        this.f3706 = f + fM14476;
        float f2 = f + fM144762;
        float fM144763 = C4792.m14375().m14476(30) * fM14434;
        float fM144764 = C4792.m14375().m14476(34) * fM14434;
        float fM144765 = C4792.m14375().m14476(24) * fM14434;
        float f3 = f + fM144764;
        float f4 = f + fM144765;
        float f5 = 0.75f * f3;
        Paint paint = new Paint(1);
        paint.setColor(-1);
        paint.setTypeface(FilmApp.m404());
        paint.setTextSize(f5);
        Paint paint2 = new Paint(1);
        paint2.setColor(ViewCompat.MEASURED_STATE_MASK);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeJoin(Paint.Join.ROUND);
        paint2.setStrokeCap(Paint.Cap.ROUND);
        paint2.setStrokeWidth(5.0f);
        paint2.setTypeface(FilmApp.m404());
        paint2.setTextSize(f5);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        int i4 = ((int) (fontMetrics.descent - fontMetrics.ascent)) - 3;
        float f6 = i3 + 1;
        float f7 = this.f3706;
        float f8 = i3 * 4 * f2;
        float f9 = i3 * 5 * fM144763;
        float f10 = i4;
        int i5 = (int) ((f6 * f7) + f8 + f9 + f10 + (f7 * 2.0f) + (10.0f * fM144763) + (8.0f * f2));
        this.f3705 = i5;
        int i6 = i5 + (i5 % 2);
        this.f3705 = i6;
        int i7 = (int) ((f6 * f7) + f8 + f9);
        this.f3707 = (i6 - (i7 + (i7 % 2))) / 2.0f;
        int i8 = i;
        if (i8 < f3) {
            i8 = (int) f3;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i8, (int) (i6 + 0.5f), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint3 = new Paint(1);
        Paint paint4 = new Paint(1);
        paint4.setStyle(Paint.Style.STROKE);
        paint4.setStrokeJoin(Paint.Join.ROUND);
        paint4.setStrokeCap(Paint.Cap.ROUND);
        paint3.setColor(-1);
        paint4.setColor(ViewCompat.MEASURED_STATE_MASK);
        paint4.setStrokeWidth(fM14443);
        float f11 = i8;
        float f12 = (f11 - f3) / 2.0f;
        float f13 = f12 + ((f3 - f4) / 2.0f);
        float f14 = f11 / 2.0f;
        float fM3633 = f14 - (m3633(paint, "A") / 2.0f);
        float f15 = i4 - 2;
        canvas.drawText("A", fM3633, f15, paint2);
        canvas.drawText("A", fM3633, f15, paint);
        float f16 = 5.0f * fM144763;
        float f17 = 4.0f * f2;
        float f18 = (f10 / 2.0f) + 0.0f + this.f3706 + f16 + f17;
        int i9 = 0;
        while (i9 < i3) {
            if (i9 == 0) {
                float f19 = fM14443 / 2.0f;
                float f20 = f18 + f19;
                float f21 = f12 + fM14443;
                float f22 = f20 + f19;
                float f23 = f21 + fM144764;
                canvas.drawRect(f21, f22, f23, f22 + fM14476, paint3);
                canvas.drawRect(f12 + f19, f20, f23 + f19, f20 + fM14443 + fM14476, paint4);
                f18 = f20 + (this.f3706 - f19);
            }
            Paint paint5 = paint2;
            for (int i10 = 0; i10 < 4; i10++) {
                float f24 = fM14443 / 2.0f;
                float f25 = f18 + fM144763 + f24;
                float f26 = f13 + fM14443;
                float f27 = f25 + f24;
                float f28 = f26 + fM144765;
                canvas.drawRect(f26, f27, f28, f27 + fM144762, paint3);
                canvas.drawRect(f13 + f24, f25, f28 + f24, f25 + fM14443 + fM144762, paint4);
                f18 = f25 + (f2 - f24);
            }
            float f29 = fM14443 / 2.0f;
            float f30 = f18 + fM144763 + f29;
            float f31 = f12 + fM14443;
            float f32 = f30 + f29;
            float f33 = f31 + fM144764;
            canvas.drawRect(f31, f32, f33, f32 + fM14476, paint3);
            canvas.drawRect(f12 + f29, f30, f33 + f29, f30 + fM14443 + fM14476, paint4);
            f18 = f30 + (this.f3706 - f29);
            i9++;
            i3 = i2;
            paint2 = paint5;
        }
        float fM36332 = f14 - (m3633(paint, "A") / 2.0f);
        float f34 = ((f18 + (f16 + f17)) + f10) - 6.0f;
        canvas.drawText("A", fM36332, f34, paint2);
        canvas.drawText("A", fM36332, f34, paint);
        ViewGroup.LayoutParams layoutParams = this.f3684.f12551.getLayoutParams();
        layoutParams.height = this.f3705;
        this.f3684.f12551.setLayoutParams(layoutParams);
        return bitmapCreateBitmap;
    }

    /* renamed from: ޛ, reason: contains not printable characters */
    public final int m3633(Paint paint, String str) {
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

    /* renamed from: ޜ, reason: contains not printable characters */
    public final void m3634(MotionEvent motionEvent) {
        post(new RunnableC1309(motionEvent));
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0042  */
    /* renamed from: ޝ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m3635() {
        /*
            r10 = this;
            ڹ r0 = r10.f3684
            com.blink.academy.film.widgets.iso.portrait.FadingEdgeLayout r0 = r0.f12550
            r1 = 1
            r2 = 0
            r0.m3533(r1, r2, r1, r2)
            ڹ r0 = r10.f3684
            com.blink.academy.film.widgets.iso.portrait.FadingEdgeLayout r0 = r0.f12550
            r3 = 100
            r0.m3534(r3, r2, r3, r2)
            ڹ r0 = r10.f3684
            android.widget.ImageView r0 = r0.f12551
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r0 = (android.widget.LinearLayout.LayoutParams) r0
            int r3 = r10.f3704
            r4 = 4
            r5 = 1073741824(0x40000000, float:2.0)
            r6 = 2
            if (r3 == 0) goto L42
            if (r3 == r1) goto L42
            if (r3 == r6) goto L42
            r1 = 3
            if (r3 == r1) goto L42
            if (r3 == r4) goto L33
            r1 = 5
            if (r3 == r1) goto L42
            r10.f3703 = r2
            goto L4d
        L33:
            int r1 = r10.f3701
            int r1 = r1 / r6
            float r1 = (float) r1
            float r2 = r10.f3706
            float r2 = r2 / r5
            float r1 = r1 - r2
            float r2 = r10.f3707
            float r1 = r1 - r2
            int r1 = (int) r1
            r10.f3703 = r1
            goto L4d
        L42:
            int r1 = r10.f3701
            int r1 = r1 / r6
            float r1 = (float) r1
            float r2 = r10.f3706
            float r2 = r2 / r5
            float r1 = r1 - r2
            int r1 = (int) r1
            r10.f3703 = r1
        L4d:
            int r1 = r10.f3703
            r0.topMargin = r1
            ڹ r1 = r10.f3684
            android.widget.ImageView r1 = r1.f12551
            r1.setLayoutParams(r0)
            int r0 = r10.f3701
            int r1 = r0 / 2
            float r1 = (float) r1
            float r2 = r10.f3706
            float r3 = r2 / r5
            float r1 = r1 - r3
            r3 = 1056964608(0x3f000000, float:0.5)
            float r1 = r1 + r3
            int r1 = (int) r1
            r10.f3696 = r1
            int r7 = r10.f3705
            int r8 = r0 / 2
            int r8 = r7 - r8
            float r8 = (float) r8
            float r8 = r8 + r3
            float r9 = r2 / r5
            float r8 = r8 - r9
            float r8 = -r8
            int r8 = (int) r8
            r10.f3697 = r8
            r10.f3698 = r1
            r10.f3699 = r8
            int r1 = r10.f3704
            if (r4 != r1) goto L98
            int r1 = r0 / 2
            float r1 = (float) r1
            float r4 = r2 / r5
            float r1 = r1 - r4
            float r1 = r1 + r3
            float r4 = r10.f3707
            float r1 = r1 - r4
            int r1 = (int) r1
            r10.f3696 = r1
            float r1 = (float) r7
            float r1 = r1 - r4
            int r0 = r0 / r6
            float r0 = (float) r0
            float r1 = r1 - r0
            float r1 = r1 + r3
            float r2 = r2 / r5
            float r1 = r1 - r2
            float r0 = -r1
            int r0 = (int) r0
            r10.f3697 = r0
        L98:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView.m3635():void");
    }

    /* renamed from: ޞ, reason: contains not printable characters */
    public final void m3636() {
        this.f3684 = AbstractC3611.m11667(LayoutInflater.from(getContext()), this, true);
    }

    /* renamed from: ޟ, reason: contains not printable characters */
    public final void m3637() {
        ABPointMessage aBPointMessage = this.f3693;
        if (aBPointMessage != null) {
            float endFocusP = aBPointMessage.getEndFocusP();
            int iMax = Math.max(this.f3698, this.f3696);
            float fMin = Math.min(this.f3699, this.f3697);
            float f = iMax;
            Math.min(Math.max(endFocusP, fMin), f);
            int i = this.f3690;
            if (i == 1) {
                m3638(f);
            } else if (i == 2) {
                m3638(fMin);
            }
            this.f3690 = 0;
            InterfaceC1314 interfaceC1314 = this.f3709;
            if (interfaceC1314 != null) {
                interfaceC1314.onAnimChange(false);
            }
            this.f3691.post(new RunnableC1308());
            this.f3693 = null;
        }
    }

    /* renamed from: ޠ, reason: contains not printable characters */
    public void m3638(float f) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f3684.f12551.getLayoutParams());
        layoutParams.topMargin = (int) f;
        this.f3684.f12551.setLayoutParams(layoutParams);
    }

    /* renamed from: ޡ, reason: contains not printable characters */
    public void m3639() {
        m3640(((LinearLayout.LayoutParams) this.f3684.f12551.getLayoutParams()).topMargin);
    }

    /* renamed from: ޢ, reason: contains not printable characters */
    public final void m3640(int i) {
        boolean z;
        int i2;
        int i3 = this.f3705 + i;
        boolean z2 = true;
        if (i < 0) {
            z = true;
            i = 0;
        } else {
            z = false;
        }
        int i4 = this.f3701;
        if (i3 > i4) {
            i2 = 0;
        } else {
            i2 = i4 - i3;
            z2 = false;
        }
        this.f3684.f12550.m3533(z, false, z2, false);
        InterfaceC1313 interfaceC1313 = this.f3710;
        if (interfaceC1313 != null) {
            interfaceC1313.mo3566(i, i2);
        }
    }

    /* renamed from: ޣ, reason: contains not printable characters */
    public final void m3641() {
        setOnTouchListener(new ViewOnTouchListenerC1303());
    }

    /* renamed from: ޤ, reason: contains not printable characters */
    public void m3642(int i, int i2, int i3, int i4) {
        this.f3700 = i;
        this.f3701 = i2;
        this.f3702 = i3;
        this.f3704 = i4;
        if (i4 == 4) {
            this.f3684.f12551.setImageBitmap(m3632(i, i3));
        } else {
            this.f3684.f12551.setImageBitmap(m3631(i, i3));
        }
        m3635();
    }

    public PortraitWheelProgressView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PortraitWheelProgressView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3690 = 0;
        this.f3694 = 0;
        m3636();
        m3641();
    }
}
