package com.blink.academy.film.widgets.iso;

import android.content.Context;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.blink.academy.film.custom.ABPointMessage;
import com.blink.academy.film.custom.WeakHandler;
import defpackage.AbstractC3824;
import defpackage.C3947;
import defpackage.C4008;
import defpackage.C4535;
import defpackage.C4792;
import defpackage.j;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes.dex */
public class ABPointWheelView extends RelativeLayout {

    /* renamed from: ބ, reason: contains not printable characters */
    public static final String f3229 = ABPointWheelView.class.getSimpleName();

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC3824 f3230;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public WeakHandler f3231;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f3232;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public ABPointMessage f3233;

    /* renamed from: ԯ, reason: contains not printable characters */
    public float f3234;

    /* renamed from: ՠ, reason: contains not printable characters */
    public float f3235;

    /* renamed from: ֈ, reason: contains not printable characters */
    public float f3236;

    /* renamed from: ֏, reason: contains not printable characters */
    public boolean f3237;

    /* renamed from: ׯ, reason: contains not printable characters */
    public float f3238;

    /* renamed from: ؠ, reason: contains not printable characters */
    public float f3239;

    /* renamed from: ހ, reason: contains not printable characters */
    public float f3240;

    /* renamed from: ށ, reason: contains not printable characters */
    public InterfaceC1151 f3241;

    /* renamed from: ނ, reason: contains not printable characters */
    public int f3242;

    /* renamed from: ރ, reason: contains not printable characters */
    public Timer f3243;

    /* renamed from: com.blink.academy.film.widgets.iso.ABPointWheelView$Ϳ, reason: contains not printable characters */
    public class ViewOnClickListenerC1145 implements View.OnClickListener {
        public ViewOnClickListenerC1145() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ABPointWheelView.this.isEnabled() && ABPointWheelView.this.f3232 == 0) {
                ABPointWheelView.this.m3193();
                if (ABPointWheelView.this.f3241 != null) {
                    ABPointWheelView.this.f3241.mo3196(ABPointWheelView.this.f3232);
                }
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.ABPointWheelView$Ԩ, reason: contains not printable characters */
    public class ViewOnClickListenerC1146 implements View.OnClickListener {
        public ViewOnClickListenerC1146() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ABPointWheelView.this.isEnabled() && ABPointWheelView.this.f3232 == 1) {
                ABPointWheelView.this.f3232 = 2;
                ABPointWheelView.this.m3187();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.ABPointWheelView$Ԫ, reason: contains not printable characters */
    public class C1147 extends TimerTask {

        /* renamed from: com.blink.academy.film.widgets.iso.ABPointWheelView$Ԫ$Ϳ, reason: contains not printable characters */
        public class RunnableC1148 implements Runnable {
            public RunnableC1148() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ABPointWheelView.this.m3190();
            }
        }

        /* renamed from: com.blink.academy.film.widgets.iso.ABPointWheelView$Ԫ$Ԩ, reason: contains not printable characters */
        public class RunnableC1149 implements Runnable {
            public RunnableC1149() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ABPointWheelView.this.m3190();
            }
        }

        /* renamed from: com.blink.academy.film.widgets.iso.ABPointWheelView$Ԫ$Ԫ, reason: contains not printable characters */
        public class RunnableC1150 implements Runnable {
            public RunnableC1150() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ABPointWheelView.this.m3190();
                C4535.m13880().m13915();
            }
        }

        public C1147() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (ABPointWheelView.this.f3233 == null) {
                ABPointWheelView.this.f3231.post(new RunnableC1148());
            }
            int type = ABPointWheelView.this.f3233.getType();
            long totalMs = ABPointWheelView.this.f3233.getTotalMs();
            long startMs = ABPointWheelView.this.f3233.getStartMs();
            long jCurrentTimeMillis = System.currentTimeMillis();
            float startFocusP = ABPointWheelView.this.f3233.getStartFocusP();
            float endFocusP = ABPointWheelView.this.f3233.getEndFocusP();
            float startZoomP = ABPointWheelView.this.f3233.getStartZoomP();
            float endZoomP = ABPointWheelView.this.f3233.getEndZoomP();
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
                if (ABPointWheelView.this.f3241 != null) {
                    ABPointWheelView.this.f3241.onZoomChange(C3947.m12727().m12754(endZoomP));
                }
            } else if (type == 2) {
                C3947.m12727().m12785(endFocusP);
                if (ABPointWheelView.this.f3241 != null) {
                    if (endFocusP > 1.0f || endFocusP < 0.0f) {
                        ABPointWheelView.this.f3241.onFocusChange(-1.0f);
                    } else {
                        ABPointWheelView.this.f3241.onFocusChange(C3947.m12727().m12756(endFocusP));
                    }
                }
            }
            if (jCurrentTimeMillis >= j) {
                ABPointWheelView.this.f3231.post(new RunnableC1150());
                return;
            }
            Message messageObtain = Message.obtain();
            messageObtain.obj = ABPointWheelView.this.f3233;
            messageObtain.what = 200;
            ABPointWheelView.this.f3231.sendMessage(messageObtain);
            if (type == 2) {
                if (endFocusP > 1.0f || endFocusP < 0.0f) {
                    ABPointWheelView.this.f3231.post(new RunnableC1149());
                }
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.ABPointWheelView$Ԭ, reason: contains not printable characters */
    public interface InterfaceC1151 {
        void onFocusChange(float f);

        void onZoomChange(float f);

        /* renamed from: Ϳ, reason: contains not printable characters */
        boolean mo3195();

        /* renamed from: Ԩ, reason: contains not printable characters */
        void mo3196(int i);
    }

    public ABPointWheelView(@NonNull Context context) {
        this(context, null);
    }

    private float getDuration() {
        float f = this.f3239;
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        float f2 = this.f3240;
        float f3 = f2 >= 0.0f ? f2 : 0.0f;
        float fAbs = Math.abs((f3 <= 1.0f ? f3 : 1.0f) - f);
        float f4 = this.f3235;
        return f4 + ((this.f3236 - f4) * fAbs);
    }

    public int getCurrentState() {
        return this.f3232;
    }

    public void setCardWidth(int i) {
        this.f3242 = i;
    }

    public void setDegree(float f) {
        if (this.f3232 != 0) {
            this.f3230.f13099.setRotation(-(f - this.f3238));
            if (Math.abs(-(f - this.f3238)) > 5.0f) {
                this.f3230.f13097.setVisibility(0);
            } else {
                this.f3230.f13097.setVisibility(8);
            }
        }
    }

    public void setHandler(WeakHandler weakHandler) {
        this.f3231 = weakHandler;
    }

    public void setOnABStateChange(InterfaceC1151 interfaceC1151) {
        this.f3241 = interfaceC1151;
    }

    public void setStartDegree(float f) {
        this.f3238 = f;
    }

    public void setZoom(boolean z) {
        this.f3237 = z;
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final void m3187() {
        if (this.f3237) {
            this.f3239 = C3947.m12727().m12742();
            InterfaceC1151 interfaceC1151 = this.f3241;
            if (interfaceC1151 != null) {
                j.m7053(interfaceC1151.mo3195() ? 1 : 0);
            }
        } else {
            this.f3239 = C3947.m12727().m12736();
            InterfaceC1151 interfaceC11512 = this.f3241;
            if (interfaceC11512 != null) {
                j.m7052(interfaceC11512.mo3195() ? 1 : 0);
            }
        }
        if (this.f3239 > 1.0f) {
            this.f3239 = 1.0f;
        }
        if (this.f3239 < 0.0f) {
            this.f3239 = 0.0f;
        }
        float duration = getDuration();
        this.f3234 = duration;
        this.f3233 = new ABPointMessage();
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.f3233.setStartMs(jCurrentTimeMillis);
        this.f3233.setEndMs(jCurrentTimeMillis + ((long) (duration * 1000.0f)));
        int i = 0;
        if (this.f3237) {
            this.f3233.setStartZoomP(this.f3239);
            this.f3233.setEndZoomP(this.f3240);
            if (this.f3239 != this.f3240) {
                i = 1;
            }
        } else {
            this.f3233.setStartFocusP(this.f3239);
            this.f3233.setEndFocusP(this.f3240);
            if (this.f3239 != this.f3240) {
                i = 2;
            }
        }
        this.f3233.setType(i);
        long endMs = this.f3233.getEndMs() - this.f3233.getStartMs();
        if (endMs < 0) {
            endMs = 0;
        }
        this.f3233.setTotalMs(endMs);
        Message messageObtain = Message.obtain();
        ABPointMessage aBPointMessage = this.f3233;
        messageObtain.obj = aBPointMessage;
        messageObtain.what = 200;
        if (aBPointMessage.getType() == 0) {
            this.f3232 = 1;
            return;
        }
        this.f3231.sendMessage(messageObtain);
        this.f3243 = new Timer();
        this.f3243.schedule(new C1147(), 0L, (1000 / (Math.min(C3947.m12727().m12747(), 60) != 0 ? r0 : 60)) / 2);
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public void m3188(int i) {
        C4008.m12886(this, this.f3242, 0.0f, i, null);
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public final void m3189() {
        this.f3230 = AbstractC3824.m12135(LayoutInflater.from(getContext()), this, true);
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public void m3190() {
        if (this.f3232 != 0) {
            this.f3232 = 0;
            this.f3230.f13098.setAlpha(0.2f);
            this.f3230.f13097.setVisibility(8);
        }
        Timer timer = this.f3243;
        if (timer != null) {
            timer.cancel();
            this.f3243 = null;
        }
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public void m3191() {
        this.f3230.f13099.setRotation(0.0f);
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public void m3192(int i) {
        C4008.m12886(this, 0.0f, 0.0f, i, null);
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public final void m3193() {
        if (this.f3232 == 0) {
            this.f3232 = 1;
            this.f3230.f13098.setAlpha(1.0f);
            if (this.f3237) {
                this.f3240 = C3947.m12727().m12742();
            } else {
                this.f3240 = C3947.m12727().m12736();
            }
        }
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public void m3194() {
        float fM14434 = C4792.m14375().m14434();
        int iM14476 = (int) ((C4792.m14375().m14476(C4792.m14375().m14401()) * fM14434) + 0.5f);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f3230.f13097.getLayoutParams();
        float f = iM14476 * 2;
        layoutParams.width = (int) ((C4792.m14375().m14476(C4792.m14375().m14400()) * fM14434) + 0.5f + f);
        layoutParams.height = (int) ((C4792.m14375().m14476(C4792.m14375().m14400()) * fM14434) + 0.5f + f);
        this.f3230.f13097.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f3230.f13098.getLayoutParams();
        layoutParams2.width = (int) ((C4792.m14375().m14476(C4792.m14375().m14399()) * fM14434) + 0.5f + f);
        layoutParams2.height = (int) ((C4792.m14375().m14476(C4792.m14375().m14399()) * fM14434) + 0.5f + f);
        this.f3230.f13098.setLayoutParams(layoutParams2);
        int i = (int) ((iM14476 * 0.35f) + 0.5f);
        int i2 = iM14476 - i;
        int i3 = iM14476 + i;
        this.f3230.f13097.setPadding(i2, 0, i3, 0);
        this.f3230.f13098.setPadding(i2, 0, i3, 0);
        this.f3230.f13098.setAlpha(0.2f);
        this.f3230.f13097.setVisibility(8);
        this.f3230.f13098.setOnClickListener(new ViewOnClickListenerC1145());
        this.f3230.f13097.setOnClickListener(new ViewOnClickListenerC1146());
    }

    public ABPointWheelView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ABPointWheelView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3232 = 0;
        this.f3235 = 0.5f;
        this.f3236 = 5.0f;
        m3189();
    }
}
