package com.blink.academy.film.widgets.iso.portrait;

import android.content.Context;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.blink.academy.film.custom.ABPointMessage;
import com.blink.academy.film.custom.WeakHandler;
import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import defpackage.AbstractC3140;
import defpackage.C3947;
import defpackage.C4535;
import defpackage.C4638;
import defpackage.C4792;
import defpackage.j;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes.dex */
public class PortraitABPointView extends FrameLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC3140 f3616;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public WeakHandler f3617;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f3618;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public int f3619;

    /* renamed from: ԯ, reason: contains not printable characters */
    public int f3620;

    /* renamed from: ՠ, reason: contains not printable characters */
    public float f3621;

    /* renamed from: ֈ, reason: contains not printable characters */
    public float f3622;

    /* renamed from: ֏, reason: contains not printable characters */
    public float f3623;

    /* renamed from: ׯ, reason: contains not printable characters */
    public boolean f3624;

    /* renamed from: ؠ, reason: contains not printable characters */
    public int f3625;

    /* renamed from: ހ, reason: contains not printable characters */
    public float f3626;

    /* renamed from: ށ, reason: contains not printable characters */
    public float f3627;

    /* renamed from: ނ, reason: contains not printable characters */
    public ABPointMessage f3628;

    /* renamed from: ރ, reason: contains not printable characters */
    public Timer f3629;

    /* renamed from: ބ, reason: contains not printable characters */
    public InterfaceC1279 f3630;

    /* renamed from: com.blink.academy.film.widgets.iso.portrait.PortraitABPointView$Ϳ, reason: contains not printable characters */
    public class ViewOnClickListenerC1273 implements View.OnClickListener {
        public ViewOnClickListenerC1273() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PortraitABPointView.this.isEnabled() && PortraitABPointView.this.f3618 == 0) {
                PortraitABPointView.this.m3548();
                if (PortraitABPointView.this.f3630 != null) {
                    PortraitABPointView.this.f3630.mo3550(PortraitABPointView.this.f3618);
                }
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.portrait.PortraitABPointView$Ԩ, reason: contains not printable characters */
    public class ViewOnClickListenerC1274 implements View.OnClickListener {
        public ViewOnClickListenerC1274() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PortraitABPointView.this.isEnabled() && PortraitABPointView.this.f3618 == 1) {
                PortraitABPointView.this.f3618 = 2;
                PortraitABPointView.this.m3542();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.portrait.PortraitABPointView$Ԫ, reason: contains not printable characters */
    public class C1275 extends TimerTask {

        /* renamed from: com.blink.academy.film.widgets.iso.portrait.PortraitABPointView$Ԫ$Ϳ, reason: contains not printable characters */
        public class RunnableC1276 implements Runnable {
            public RunnableC1276() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PortraitABPointView.this.m3545();
            }
        }

        /* renamed from: com.blink.academy.film.widgets.iso.portrait.PortraitABPointView$Ԫ$Ԩ, reason: contains not printable characters */
        public class RunnableC1277 implements Runnable {
            public RunnableC1277() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PortraitABPointView.this.m3545();
            }
        }

        /* renamed from: com.blink.academy.film.widgets.iso.portrait.PortraitABPointView$Ԫ$Ԫ, reason: contains not printable characters */
        public class RunnableC1278 implements Runnable {
            public RunnableC1278() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PortraitABPointView.this.m3545();
                C4535.m13880().m13915();
            }
        }

        public C1275() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (PortraitABPointView.this.f3628 == null) {
                PortraitABPointView.this.f3617.post(new RunnableC1276());
            }
            int type = PortraitABPointView.this.f3628.getType();
            long totalMs = PortraitABPointView.this.f3628.getTotalMs();
            long startMs = PortraitABPointView.this.f3628.getStartMs();
            long jCurrentTimeMillis = System.currentTimeMillis();
            float startFocusP = PortraitABPointView.this.f3628.getStartFocusP();
            float endFocusP = PortraitABPointView.this.f3628.getEndFocusP();
            float startZoomP = PortraitABPointView.this.f3628.getStartZoomP();
            float endZoomP = PortraitABPointView.this.f3628.getEndZoomP();
            float f = ((jCurrentTimeMillis - startMs) * 1.0f) / totalMs;
            float f2 = startFocusP + (f * (endFocusP - startFocusP));
            float f3 = startZoomP + ((endZoomP - startZoomP) * f);
            long j = startMs + totalMs;
            if (jCurrentTimeMillis < j) {
                endFocusP = f2;
                endZoomP = f3;
            }
            if (type == 1) {
                C3947.m12727().m12789(endZoomP);
                if (PortraitABPointView.this.f3630 != null) {
                    PortraitABPointView.this.f3630.onZoomChange(C3947.m12727().m12754(endZoomP));
                }
            } else if (type == 2) {
                C3947.m12727().m12785(endFocusP);
                if (PortraitABPointView.this.f3630 != null) {
                    if (endFocusP > 1.0f || endFocusP < 0.0f) {
                        PortraitABPointView.this.f3630.onFocusChange(-1.0f);
                    } else {
                        PortraitABPointView.this.f3630.onFocusChange(C3947.m12727().m12756(endFocusP));
                    }
                }
            }
            if (jCurrentTimeMillis >= j) {
                PortraitABPointView.this.f3617.post(new RunnableC1278());
                return;
            }
            Message messageObtain = Message.obtain();
            messageObtain.obj = PortraitABPointView.this.f3628;
            messageObtain.what = 200;
            PortraitABPointView.this.f3617.sendMessage(messageObtain);
            if (type == 2) {
                if (endFocusP > 1.0f || endFocusP < 0.0f) {
                    PortraitABPointView.this.f3617.post(new RunnableC1277());
                }
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.portrait.PortraitABPointView$Ԭ, reason: contains not printable characters */
    public interface InterfaceC1279 {
        void onFocusChange(float f);

        void onZoomChange(float f);

        /* renamed from: Ϳ, reason: contains not printable characters */
        boolean mo3549();

        /* renamed from: Ԩ, reason: contains not printable characters */
        void mo3550(int i);
    }

    public PortraitABPointView(@NonNull Context context) {
        this(context, null);
    }

    private float getDuration() {
        float f = this.f3626;
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        float f2 = this.f3627;
        float f3 = f2 >= 0.0f ? f2 : 0.0f;
        float fAbs = Math.abs((f3 <= 1.0f ? f3 : 1.0f) - f);
        float f4 = this.f3622;
        return f4 + ((this.f3623 - f4) * fAbs);
    }

    public int getCurrentState() {
        return this.f3618;
    }

    public void setHandler(WeakHandler weakHandler) {
        this.f3617 = weakHandler;
    }

    public void setNowMargin(int i) {
        if (this.f3618 != 0) {
            int i2 = i - this.f3625;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f3616.f11149.getLayoutParams());
            layoutParams.topMargin = this.f3619 + i2;
            this.f3616.f11149.setLayoutParams(layoutParams);
            if (Math.abs(layoutParams.topMargin - this.f3619) > this.f3620 / 2) {
                this.f3616.f11148.setVisibility(0);
            } else {
                this.f3616.f11148.setVisibility(8);
            }
        }
    }

    public void setOnABStateChange(InterfaceC1279 interfaceC1279) {
        this.f3630 = interfaceC1279;
    }

    public void setStartMargin(int i) {
        this.f3625 = i;
    }

    public void setZoom(boolean z) {
        this.f3624 = z;
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final void m3542() {
        if (this.f3624) {
            this.f3626 = C3947.m12727().m12742();
            InterfaceC1279 interfaceC1279 = this.f3630;
            if (interfaceC1279 != null) {
                j.m7053(interfaceC1279.mo3549() ? 1 : 0);
            }
        } else {
            this.f3626 = C3947.m12727().m12736();
            InterfaceC1279 interfaceC12792 = this.f3630;
            if (interfaceC12792 != null) {
                j.m7052(interfaceC12792.mo3549() ? 1 : 0);
            }
        }
        if (this.f3626 > 1.0f) {
            this.f3626 = 1.0f;
        }
        if (this.f3626 < 0.0f) {
            this.f3626 = 0.0f;
        }
        float duration = getDuration();
        this.f3621 = duration;
        this.f3628 = new ABPointMessage();
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.f3628.setStartMs(jCurrentTimeMillis);
        this.f3628.setEndMs(jCurrentTimeMillis + ((long) (duration * 1000.0f)));
        int i = 0;
        if (this.f3624) {
            this.f3628.setStartZoomP(this.f3626);
            this.f3628.setEndZoomP(this.f3627);
            if (this.f3626 != this.f3627) {
                i = 1;
            }
        } else {
            this.f3628.setStartFocusP(this.f3626);
            this.f3628.setEndFocusP(this.f3627);
            if (this.f3626 != this.f3627) {
                i = 2;
            }
        }
        this.f3628.setType(i);
        long endMs = this.f3628.getEndMs() - this.f3628.getStartMs();
        if (endMs < 0) {
            endMs = 0;
        }
        this.f3628.setTotalMs(endMs);
        Message messageObtain = Message.obtain();
        ABPointMessage aBPointMessage = this.f3628;
        messageObtain.obj = aBPointMessage;
        messageObtain.what = 200;
        if (aBPointMessage.getType() == 0) {
            this.f3618 = 1;
            return;
        }
        this.f3617.sendMessage(messageObtain);
        C4638.m14099("slimabpoint", "startP:" + this.f3628.getStartZoomP() + " endP:" + this.f3628.getEndZoomP() + MyUTIL.white_space);
        Timer timer = new Timer();
        this.f3629 = timer;
        timer.schedule(new C1275(), 0L, (long) ((1000 / Math.min(C3947.m12727().m12747(), 60)) / 2));
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final void m3543() {
        this.f3616 = AbstractC3140.m10734(LayoutInflater.from(getContext()), this, true);
        m3544();
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public final void m3544() {
        this.f3616.f11149.setOnClickListener(new ViewOnClickListenerC1273());
        this.f3616.f11148.setOnClickListener(new ViewOnClickListenerC1274());
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public void m3545() {
        if (this.f3618 != 0) {
            this.f3618 = 0;
            this.f3616.f11149.setAlpha(0.2f);
            this.f3616.f11148.setVisibility(8);
        }
        Timer timer = this.f3629;
        if (timer != null) {
            timer.cancel();
            this.f3629 = null;
        }
        m3546();
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public void m3546() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f3616.f11149.getLayoutParams());
        layoutParams.topMargin = this.f3619;
        this.f3616.f11149.setLayoutParams(layoutParams);
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public void m3547(int i, float f) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f3616.f11151.getLayoutParams();
        layoutParams.height = i;
        this.f3616.f11151.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f3616.f11150.getLayoutParams();
        layoutParams2.height = i;
        this.f3616.f11150.setLayoutParams(layoutParams2);
        int iM14476 = (int) ((C4792.m14375().m14476(C4792.m14375().m14401()) * f) + 0.5f);
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.f3616.f11148.getLayoutParams();
        float f2 = iM14476 * 2;
        layoutParams3.width = (int) ((C4792.m14375().m14476(C4792.m14375().m14400()) * f) + 0.5f + f2);
        int iM144762 = (int) ((C4792.m14375().m14476(C4792.m14375().m14400()) * f) + 0.5f + f2);
        layoutParams3.height = iM144762;
        layoutParams3.topMargin = (layoutParams2.height - iM144762) / 2;
        this.f3616.f11148.setLayoutParams(layoutParams3);
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.f3616.f11149.getLayoutParams();
        layoutParams4.width = (int) ((C4792.m14375().m14476(C4792.m14375().m14399()) * f) + 0.5f + f2);
        int iM144763 = (int) ((C4792.m14375().m14476(C4792.m14375().m14399()) * f) + 0.5f + f2);
        layoutParams4.height = iM144763;
        int i2 = (layoutParams2.height - iM144763) / 2;
        layoutParams4.topMargin = i2;
        this.f3619 = i2;
        this.f3616.f11149.setLayoutParams(layoutParams4);
        int i3 = (int) ((iM14476 * 0.35f) + 0.5f);
        int i4 = iM14476 - i3;
        int i5 = iM14476 + i3;
        this.f3616.f11148.setPadding(i4, 0, i5, 0);
        this.f3616.f11149.setPadding(i4, 0, i5, 0);
        this.f3620 = layoutParams3.height - i3;
        this.f3616.f11149.setAlpha(0.2f);
        this.f3616.f11148.setVisibility(8);
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public final void m3548() {
        if (this.f3618 == 0) {
            this.f3618 = 1;
            this.f3616.f11149.setAlpha(1.0f);
            if (this.f3624) {
                this.f3627 = C3947.m12727().m12742();
            } else {
                this.f3627 = C3947.m12727().m12736();
            }
        }
    }

    public PortraitABPointView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PortraitABPointView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3618 = 0;
        this.f3622 = 0.5f;
        this.f3623 = 5.0f;
        m3543();
    }
}
