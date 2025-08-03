package com.blink.academy.film.widgets.transmit.monitor;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.custom.WeakHandler;
import com.blink.academy.film.stream.ACUnitView;
import com.blink.academy.film.stream.LinkManager;
import com.blink.academy.film.support.socket.TransmitHelper;
import com.blink.academy.film.widgets.FilmPointView;
import com.blink.academy.film.widgets.transmit.CloudConnectView;
import com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView;
import com.blink.academy.protake.R;
import defpackage.AbstractC2536;
import defpackage.AbstractC4012;
import defpackage.C2462;
import defpackage.C2579;
import defpackage.C2650;
import defpackage.C4008;
import defpackage.C4041;
import defpackage.C4792;
import defpackage.e5;
import defpackage.z0;
import java.util.ArrayList;
import java.util.List;
import org.jcodec.codecs.mpeg12.MPEGConst;

/* loaded from: classes.dex */
public class MonitorView extends FrameLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC2536 f4818;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public boolean f4819;

    /* renamed from: ԭ, reason: contains not printable characters */
    public boolean f4820;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public ValueAnimator f4821;

    /* renamed from: ԯ, reason: contains not printable characters */
    public boolean f4822;

    /* renamed from: ՠ, reason: contains not printable characters */
    public boolean f4823;

    /* renamed from: ֈ, reason: contains not printable characters */
    public ValueAnimator f4824;

    /* renamed from: ֏, reason: contains not printable characters */
    public int f4825;

    /* renamed from: ׯ, reason: contains not printable characters */
    public WeakHandler f4826;

    /* renamed from: ؠ, reason: contains not printable characters */
    public int f4827;

    /* renamed from: ހ, reason: contains not printable characters */
    public int f4828;

    /* renamed from: ށ, reason: contains not printable characters */
    public boolean f4829;

    /* renamed from: ނ, reason: contains not printable characters */
    public boolean f4830;

    /* renamed from: ރ, reason: contains not printable characters */
    public boolean f4831;

    /* renamed from: ބ, reason: contains not printable characters */
    public ConstraintLayout.LayoutParams f4832;

    /* renamed from: ޅ, reason: contains not printable characters */
    public long f4833;

    /* renamed from: ކ, reason: contains not printable characters */
    public float f4834;

    /* renamed from: އ, reason: contains not printable characters */
    public float f4835;

    /* renamed from: ވ, reason: contains not printable characters */
    public int f4836;

    /* renamed from: މ, reason: contains not printable characters */
    public int f4837;

    /* renamed from: ފ, reason: contains not printable characters */
    public boolean f4838;

    /* renamed from: ދ, reason: contains not printable characters */
    public List<ACUnitView> f4839;

    /* renamed from: ތ, reason: contains not printable characters */
    public int f4840;

    /* renamed from: ލ, reason: contains not printable characters */
    public int f4841;

    /* renamed from: ގ, reason: contains not printable characters */
    public int f4842;

    /* renamed from: ޏ, reason: contains not printable characters */
    public int f4843;

    /* renamed from: ސ, reason: contains not printable characters */
    public float f4844;

    /* renamed from: ޑ, reason: contains not printable characters */
    public boolean f4845;

    /* renamed from: ޒ, reason: contains not printable characters */
    public int f4846;

    /* renamed from: ޓ, reason: contains not printable characters */
    public int f4847;

    /* renamed from: ޔ, reason: contains not printable characters */
    public final long f4848;

    /* renamed from: ޕ, reason: contains not printable characters */
    public InterfaceC1779 f4849;

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorView$Ϳ, reason: contains not printable characters */
    public class ViewOnTouchListenerC1758 implements View.OnTouchListener {
        public ViewOnTouchListenerC1758() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                MonitorView.this.f4818.f9371.setAlpha(0.3f);
                return false;
            }
            if (action != 1 && action != 3) {
                return false;
            }
            MonitorView.this.f4818.f9371.setAlpha(1.0f);
            return false;
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorView$Ԩ, reason: contains not printable characters */
    public class C1759 implements CloudConnectView.InterfaceC1576 {
        public C1759() {
        }

        @Override // com.blink.academy.film.widgets.transmit.CloudConnectView.InterfaceC1576
        /* renamed from: Ϳ */
        public void mo4212() {
            MonitorView.this.m4687();
        }

        @Override // com.blink.academy.film.widgets.transmit.CloudConnectView.InterfaceC1576
        /* renamed from: Ԩ */
        public void mo4213(int i) {
            MonitorView.this.f4818.f9373.m4500(i);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorView$Ԫ, reason: contains not printable characters */
    public class C1760 implements C4041.InterfaceC4050 {

        /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorView$Ԫ$Ϳ, reason: contains not printable characters */
        public class RunnableC1761 implements Runnable {
            public RunnableC1761() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (MonitorView.this.f4818.f9390.getVisibility() == 0 && MonitorView.this.f4818.f9390.isAvailable() && C4041.m12957()) {
                    C4041.m12965(MonitorView.this.f4818.f9390.getSurfaceTexture(), MonitorView.this.f4818.f9390.getWidth(), MonitorView.this.f4818.f9390.getHeight());
                }
            }
        }

        public C1760() {
        }

        @Override // defpackage.C4041.InterfaceC4050
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo4707() {
            MonitorView.this.post(new RunnableC1761());
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorView$Ԭ, reason: contains not printable characters */
    public class ViewOnClickListenerC1762 implements View.OnClickListener {

        /* renamed from: ԫ, reason: contains not printable characters */
        public boolean f4854 = false;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public boolean f4855;

        public ViewOnClickListenerC1762() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MonitorView.this.f4818.f9389.getVisibility() != 0 || MonitorView.this.f4818.f9389.getAlpha() == 0.0f || this.f4854) {
                return;
            }
            this.f4854 = true;
            MonitorView monitorView = MonitorView.this;
            monitorView.f4847 = C2650.m9788(monitorView.f4847);
            C4041.m12949(MonitorView.this.f4847);
            this.f4854 = false;
            MonitorView.this.m4698();
            this.f4855 = true ^ this.f4855;
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorView$Ԯ, reason: contains not printable characters */
    public class TextureViewSurfaceTextureListenerC1763 implements TextureView.SurfaceTextureListener {
        public TextureViewSurfaceTextureListenerC1763() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            C4041.m12966(i, i2);
            if (C4041.m12957()) {
                C4041.m12965(MonitorView.this.f4818.f9390.getSurfaceTexture(), i, i2);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorView$ՠ, reason: contains not printable characters */
    public class C1764 implements ValueAnimator.AnimatorUpdateListener {
        public C1764() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            MonitorView.this.f4818.f9378.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorView$ֈ, reason: contains not printable characters */
    public class C1765 extends AnimatorListenerAdapter {
        public C1765() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            MonitorView.this.f4820 = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (MonitorView.this.f4820) {
                return;
            }
            MonitorView.this.f4820 = false;
            MonitorView.this.f4826.sendEmptyMessageDelayed(101, 1000L);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            MonitorView.this.f4820 = false;
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorView$֏, reason: contains not printable characters */
    public class C1766 implements ValueAnimator.AnimatorUpdateListener {
        public C1766() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            MonitorView.this.f4818.f9378.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorView$ׯ, reason: contains not printable characters */
    public class C1767 extends AnimatorListenerAdapter {
        public C1767() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            MonitorView.this.f4823 = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (!MonitorView.this.f4823) {
                MonitorView.this.f4822 = false;
            }
            MonitorView.this.f4823 = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            MonitorView.this.f4823 = false;
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorView$ؠ, reason: contains not printable characters */
    public class C1768 implements LinkManager.OnCheckViewState {
        public C1768() {
        }

        @Override // com.blink.academy.film.stream.LinkManager.OnCheckViewState
        public List<ACUnitView> getViews() {
            return MonitorView.this.f4839;
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorView$ހ, reason: contains not printable characters */
    public class C1769 implements Handler.Callback {
        public C1769() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(@NonNull Message message) {
            if (message.what != 101) {
                return false;
            }
            if (MonitorView.this.f4822) {
                MonitorView.this.m4676(1.0f, 0.0f, 500L);
                return false;
            }
            MonitorView.this.m4676(0.0f, 0.0f, 0L);
            return false;
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorView$ށ, reason: contains not printable characters */
    public class C1770 extends AbstractC4012 {
        public C1770() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            MonitorView.this.setVisibility(8);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorView$ނ, reason: contains not printable characters */
    public class ViewOnClickListenerC1771 implements View.OnClickListener {
        public ViewOnClickListenerC1771() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MonitorView.this.f4819 = !r3.f4819;
            MonitorView monitorView = MonitorView.this;
            monitorView.m4700(monitorView.f4818.f9376, MonitorView.this.f4819);
            if (MonitorView.this.f4849 != null) {
                MonitorView.this.f4849.mo4710();
            }
            MonitorView monitorView2 = MonitorView.this;
            monitorView2.m4702(monitorView2.f4819 ? R.string.POPUP_BRIGHTNESS_MAX : R.string.POPUP_BRIGHTNESS_NORMAL);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorView$ރ, reason: contains not printable characters */
    public class ViewOnClickListenerC1772 implements View.OnClickListener {
        public ViewOnClickListenerC1772() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MonitorView.this.f4825 == 1 || MonitorView.this.f4818.f9373.m4498()) {
                return;
            }
            MonitorView.this.f4825 = 1;
            MonitorView.this.m4691(true);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorView$ބ, reason: contains not printable characters */
    public class ViewOnClickListenerC1773 implements View.OnClickListener {
        public ViewOnClickListenerC1773() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MonitorView.this.f4825 == 2 || MonitorView.this.f4818.f9373.m4498()) {
                return;
            }
            MonitorView.this.f4825 = 2;
            MonitorView.this.m4691(true);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorView$ޅ, reason: contains not printable characters */
    public class ViewOnClickListenerC1774 implements View.OnClickListener {
        public ViewOnClickListenerC1774() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MonitorView.this.f4825 == 3 || MonitorView.this.f4818.f9373.m4498()) {
                return;
            }
            MonitorView.this.f4825 = 3;
            MonitorView.this.m4691(true);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorView$ކ, reason: contains not printable characters */
    public class C1775 implements MonitorAnimateView.InterfaceC1728 {
        public C1775() {
        }

        @Override // com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView.InterfaceC1728
        /* renamed from: Ϳ */
        public void mo4550() {
            MonitorView.this.m4687();
        }

        @Override // com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView.InterfaceC1728
        /* renamed from: Ԩ */
        public void mo4551(boolean z) {
            MonitorView.this.m4702(z ? R.string.MONITOR_FACE_HINT_ON : R.string.MONITOR_FACE_HINT_OFF);
        }

        @Override // com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView.InterfaceC1728
        /* renamed from: ԩ */
        public void mo4552() {
            MonitorView.this.m4677();
        }

        @Override // com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView.InterfaceC1728
        /* renamed from: Ԫ */
        public void mo4553(boolean z) {
            if (C2579.m9451(MonitorView.this.getContext())) {
                if (z) {
                    C4008.m12876(MonitorView.this.f4818.f9389, 0.0f, 0, null);
                    C4008.m12876(MonitorView.this.f4818.f9391, 0.0f, 0, null);
                } else {
                    C4008.m12876(MonitorView.this.f4818.f9389, 1.0f, 0, null);
                    C4008.m12876(MonitorView.this.f4818.f9391, 1.0f, 0, null);
                }
            }
        }

        @Override // com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView.InterfaceC1728
        /* renamed from: ԫ */
        public void mo4554() {
            if (e5.m5988().m5994()) {
                MonitorView.this.m4701();
            } else {
                MonitorView.this.m4675();
            }
        }

        @Override // com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView.InterfaceC1728
        /* renamed from: Ԭ */
        public void mo4555() {
            if (MonitorView.this.f4825 != 1) {
                MonitorView.this.f4825 = 1;
                MonitorView.this.m4691(true);
            }
        }

        @Override // com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView.InterfaceC1728
        /* renamed from: ԭ */
        public void mo4556(boolean z) {
            if (MonitorView.this.f4818.f9389.getAlpha() != 1.0f || MonitorView.this.f4838 == z) {
                return;
            }
            if (z) {
                C4008.m12886(MonitorView.this.f4818.f9389, 0.0f, 0.0f, 0, null);
                C4008.m12886(MonitorView.this.f4818.f9391, 0.0f, 0.0f, 0, null);
            } else {
                float f = -C4792.m14375().m14476(280);
                C4008.m12886(MonitorView.this.f4818.f9389, f, 0.0f, 0, null);
                C4008.m12886(MonitorView.this.f4818.f9391, f, 0.0f, 0, null);
            }
            MonitorView.this.f4838 = z;
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorView$އ, reason: contains not printable characters */
    public class ViewOnClickListenerC1776 implements View.OnClickListener {
        public ViewOnClickListenerC1776() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MonitorView monitorView = MonitorView.this;
            monitorView.m4686(monitorView.f4818.f9367);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorView$ވ, reason: contains not printable characters */
    public class ViewOnClickListenerC1777 implements View.OnClickListener {
        public ViewOnClickListenerC1777() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MonitorView monitorView = MonitorView.this;
            monitorView.m4686(monitorView.f4818.f9371);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorView$މ, reason: contains not printable characters */
    public class ViewOnTouchListenerC1778 implements View.OnTouchListener {
        public ViewOnTouchListenerC1778() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                MonitorView.this.f4818.f9370.setAlpha(0.3f);
                MonitorView.this.f4818.f9387.setAlpha(0.3f);
                return false;
            }
            if (action != 1 && action != 3) {
                return false;
            }
            MonitorView.this.f4818.f9370.setAlpha(1.0f);
            MonitorView.this.f4818.f9387.setAlpha(1.0f);
            return false;
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorView$ފ, reason: contains not printable characters */
    public interface InterfaceC1779 {
        /* renamed from: Ϳ, reason: contains not printable characters */
        void mo4708();

        /* renamed from: Ԩ, reason: contains not printable characters */
        void mo4709();

        /* renamed from: ԩ, reason: contains not printable characters */
        void mo4710();
    }

    public MonitorView(@NonNull Context context) {
        super(context);
        this.f4825 = 1;
        this.f4826 = new WeakHandler(new C1769());
        this.f4838 = true;
        this.f4840 = 124;
        this.f4841 = 124;
        this.f4842 = 47;
        this.f4843 = 35;
        this.f4844 = C4792.m14375().m14455(1125.0f);
        this.f4845 = false;
        this.f4847 = 2;
        this.f4848 = 500L;
        m4678();
    }

    private boolean getRightActive() {
        return C2579.m9451(getContext()) || C4792.m14375().m14484() >= 2.0f;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (C2579.m9451(FilmApp.m402())) {
            this.f4818.f9375.setVisibility(0);
            this.f4818.f9374.setVisibility(0);
            return;
        }
        if (this.f4845) {
            this.f4818.f9375.setVisibility(0);
            this.f4818.f9374.setVisibility(0);
        } else {
            this.f4818.f9375.setVisibility(8);
            this.f4818.f9374.setVisibility(8);
        }
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f4818.f9383.getLayoutParams();
        ConstraintLayout.LayoutParams layoutParams2 = this.f4832;
        if (layoutParams2 != null) {
            ((ViewGroup.MarginLayoutParams) layoutParams).width = ((ViewGroup.MarginLayoutParams) layoutParams2).width;
            ((ViewGroup.MarginLayoutParams) layoutParams).height = ((ViewGroup.MarginLayoutParams) layoutParams2).height;
            layoutParams.bottomToBottom = R.id.monitor_right_parent;
            if (this.f4845) {
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = (int) (((ViewGroup.MarginLayoutParams) layoutParams2).topMargin + this.f4834 + ((ViewGroup.MarginLayoutParams) layoutParams2).height);
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin;
            }
            this.f4818.f9383.setLayoutParams(layoutParams);
        }
    }

    public void setOnChangeListener(InterfaceC1779 interfaceC1779) {
        this.f4849 = interfaceC1779;
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public final void m4675() {
        InterfaceC1779 interfaceC1779 = this.f4849;
        if (interfaceC1779 != null) {
            interfaceC1779.mo4709();
        }
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public final void m4676(float f, float f2, long j) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f, f2);
        this.f4824 = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(j);
        this.f4824.setInterpolator(C4008.m12881());
        this.f4824.addUpdateListener(new C1766());
        this.f4824.addListener(new C1767());
        this.f4824.start();
    }

    /* renamed from: ގ, reason: contains not printable characters */
    public void m4677() {
        if (this.f4829) {
            return;
        }
        this.f4830 = false;
        this.f4829 = true;
        C4008.m12876(this.f4818.f9369, 1.0f, 200, new C1770());
    }

    /* renamed from: ޏ, reason: contains not printable characters */
    public final void m4678() {
        this.f4818 = AbstractC2536.m9358(LayoutInflater.from(getContext()), this, true);
        this.f4819 = z0.m8637() == 1;
        m4680();
        m4681();
        m4683();
    }

    /* renamed from: ސ, reason: contains not printable characters */
    public void m4679() {
        int wifiStatus = TransmitHelper.getInstance().getWifiStatus();
        if (wifiStatus == 0) {
            wifiStatus = 1;
        }
        m4688();
        this.f4818.f9373.m4497(wifiStatus);
    }

    /* renamed from: ޑ, reason: contains not printable characters */
    public final void m4680() {
        this.f4827 = C2579.f9594;
        this.f4828 = C2579.f9593;
        this.f4836 = C2579.m9440(getContext());
        this.f4837 = C2579.m9439(getContext());
        this.f4835 = C4792.m14375().m14434();
        if (getRightActive()) {
            this.f4818.f9382.setVisibility(0);
            m4682();
            m4696();
        } else {
            this.f4818.f9382.setVisibility(8);
            this.f4818.f9389.setVisibility(8);
            this.f4818.f9391.setVisibility(8);
            this.f4818.f9367.setVisibility(8);
        }
        if (C2579.m9452(getContext())) {
            return;
        }
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f4818.f9381.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).width = C2579.m9439(getContext());
        ((ViewGroup.MarginLayoutParams) layoutParams).height = C2579.m9440(getContext());
        this.f4818.f9381.setLayoutParams(layoutParams);
    }

    /* renamed from: ޒ, reason: contains not printable characters */
    public final void m4681() {
        this.f4818.f9377.setOnClickListener(new ViewOnClickListenerC1771());
        this.f4818.f9380.setOnClickListener(new ViewOnClickListenerC1772());
        this.f4818.f9384.setOnClickListener(new ViewOnClickListenerC1773());
        this.f4818.f9375.setOnClickListener(new ViewOnClickListenerC1774());
        this.f4818.f9373.setOnChangeListener(new C1775());
        this.f4818.f9367.setOnClickListener(new ViewOnClickListenerC1776());
        this.f4818.f9372.setOnClickListener(new ViewOnClickListenerC1777());
        this.f4818.f9367.setOnTouchListener(new ViewOnTouchListenerC1778());
        this.f4818.f9372.setOnTouchListener(new ViewOnTouchListenerC1758());
    }

    /* renamed from: ޓ, reason: contains not printable characters */
    public final void m4682() {
        int i;
        int iM14476 = (int) (C4792.m14375().m14476(70) * this.f4835);
        if (!C2579.m9451(getContext())) {
            this.f4818.f9389.setVisibility(8);
            this.f4818.f9391.setVisibility(8);
            this.f4818.f9367.setVisibility(8);
            this.f4818.f9372.setVisibility(8);
            this.f4818.f9371.setVisibility(8);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f4818.f9382.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) layoutParams).width = (int) ((this.f4827 - C2579.f9598) / 2.0f);
            ((ViewGroup.MarginLayoutParams) layoutParams).height = this.f4836;
            C4792.m14375().m14503(((ViewGroup.MarginLayoutParams) layoutParams).width);
            ((ViewGroup.MarginLayoutParams) layoutParams).height = this.f4828;
            this.f4818.f9382.setLayoutParams(layoutParams);
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f4818.f9381.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) layoutParams2).width = C2579.f9598 + ((ViewGroup.MarginLayoutParams) layoutParams).width;
            this.f4818.f9381.setLayoutParams(layoutParams2);
            ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) this.f4818.f9371.getLayoutParams();
            this.f4832 = layoutParams3;
            float f = iM14476;
            int i2 = (int) (1.1f * f);
            ((ViewGroup.MarginLayoutParams) layoutParams3).width = i2;
            ((ViewGroup.MarginLayoutParams) layoutParams3).height = i2;
            ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin = (int) (C4792.m14375().m14476(67) * this.f4835);
            ConstraintLayout.LayoutParams layoutParams4 = this.f4832;
            ((ViewGroup.MarginLayoutParams) layoutParams4).leftMargin = (int) (f * 0.05f);
            this.f4818.f9371.setLayoutParams(layoutParams4);
            ConstraintLayout.LayoutParams layoutParams5 = (ConstraintLayout.LayoutParams) this.f4818.f9372.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) layoutParams5).width = C2579.m9438(44.0f);
            ((ViewGroup.MarginLayoutParams) layoutParams5).height = C2579.m9438(44.0f);
            this.f4818.f9372.setLayoutParams(layoutParams5);
            ConstraintLayout.LayoutParams layoutParams6 = (ConstraintLayout.LayoutParams) this.f4818.f9376.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) layoutParams6).width = iM14476;
            ((ViewGroup.MarginLayoutParams) layoutParams6).height = iM14476;
            ((ViewGroup.MarginLayoutParams) layoutParams6).topMargin = ((ViewGroup.MarginLayoutParams) this.f4832).topMargin;
            this.f4818.f9376.setLayoutParams(layoutParams6);
            this.f4834 = ((this.f4836 - (((ViewGroup.MarginLayoutParams) this.f4832).topMargin * 2)) - (((ViewGroup.MarginLayoutParams) layoutParams6).height * 4)) / 3.0f;
            ConstraintLayout.LayoutParams layoutParams7 = (ConstraintLayout.LayoutParams) this.f4818.f9377.getLayoutParams();
            int iM9438 = C2579.m9438(44.0f);
            ((ViewGroup.MarginLayoutParams) layoutParams7).width = iM9438;
            ((ViewGroup.MarginLayoutParams) layoutParams7).height = iM9438;
            this.f4818.f9377.setLayoutParams(layoutParams7);
            int i3 = C2579.f9593;
            int i4 = ((ViewGroup.MarginLayoutParams) this.f4832).topMargin;
            int iM14462 = (int) (C4792.m14375().m14462() * this.f4835);
            C2579.m9438(1.0f);
            int i5 = (((int) ((this.f4841 * this.f4844) * this.f4835)) - iM14462) / 2;
            ConstraintLayout.LayoutParams layoutParams8 = (ConstraintLayout.LayoutParams) this.f4818.f9379.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) layoutParams8).width = ((ViewGroup.MarginLayoutParams) layoutParams6).width;
            ((ViewGroup.MarginLayoutParams) layoutParams8).height = ((ViewGroup.MarginLayoutParams) layoutParams6).height;
            if (this.f4845) {
                ((ViewGroup.MarginLayoutParams) layoutParams8).bottomMargin = (int) (((ViewGroup.MarginLayoutParams) this.f4832).topMargin + (this.f4834 * 2.0f) + (((ViewGroup.MarginLayoutParams) layoutParams6).height * 2));
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams8).bottomMargin = (int) (((ViewGroup.MarginLayoutParams) this.f4832).topMargin + this.f4834 + ((ViewGroup.MarginLayoutParams) layoutParams6).height);
            }
            this.f4818.f9379.setLayoutParams(layoutParams8);
            ConstraintLayout.LayoutParams layoutParams9 = (ConstraintLayout.LayoutParams) this.f4818.f9380.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) layoutParams9).width = ((ViewGroup.MarginLayoutParams) layoutParams7).width;
            ((ViewGroup.MarginLayoutParams) layoutParams9).height = ((ViewGroup.MarginLayoutParams) layoutParams7).height;
            this.f4818.f9380.setLayoutParams(layoutParams9);
            ConstraintLayout.LayoutParams layoutParams10 = (ConstraintLayout.LayoutParams) this.f4818.f9383.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) layoutParams10).width = ((ViewGroup.MarginLayoutParams) layoutParams6).width;
            ((ViewGroup.MarginLayoutParams) layoutParams10).height = ((ViewGroup.MarginLayoutParams) layoutParams6).height;
            if (this.f4845) {
                ((ViewGroup.MarginLayoutParams) layoutParams10).bottomMargin = (int) (((ViewGroup.MarginLayoutParams) this.f4832).topMargin + this.f4834 + ((ViewGroup.MarginLayoutParams) layoutParams6).height);
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams10).bottomMargin = ((ViewGroup.MarginLayoutParams) this.f4832).topMargin;
            }
            this.f4818.f9383.setLayoutParams(layoutParams10);
            ConstraintLayout.LayoutParams layoutParams11 = (ConstraintLayout.LayoutParams) this.f4818.f9384.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) layoutParams11).width = ((ViewGroup.MarginLayoutParams) layoutParams7).width;
            ((ViewGroup.MarginLayoutParams) layoutParams11).height = ((ViewGroup.MarginLayoutParams) layoutParams7).height;
            this.f4818.f9384.setLayoutParams(layoutParams11);
            if (!this.f4845) {
                this.f4818.f9374.setVisibility(8);
                this.f4818.f9375.setVisibility(8);
                return;
            }
            this.f4818.f9374.setVisibility(0);
            this.f4818.f9375.setVisibility(0);
            ConstraintLayout.LayoutParams layoutParams12 = (ConstraintLayout.LayoutParams) this.f4818.f9374.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) layoutParams12).width = ((ViewGroup.MarginLayoutParams) layoutParams6).width;
            ((ViewGroup.MarginLayoutParams) layoutParams12).height = ((ViewGroup.MarginLayoutParams) layoutParams6).height;
            ((ViewGroup.MarginLayoutParams) layoutParams12).bottomMargin = ((ViewGroup.MarginLayoutParams) this.f4832).topMargin;
            this.f4818.f9374.setLayoutParams(layoutParams12);
            ConstraintLayout.LayoutParams layoutParams13 = (ConstraintLayout.LayoutParams) this.f4818.f9375.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) layoutParams13).width = ((ViewGroup.MarginLayoutParams) layoutParams7).width;
            ((ViewGroup.MarginLayoutParams) layoutParams13).height = ((ViewGroup.MarginLayoutParams) layoutParams7).height;
            this.f4818.f9375.setLayoutParams(layoutParams13);
            return;
        }
        C4041.m12967(new C1760());
        int iM14461 = C4792.m14375().m14461();
        ConstraintLayout.LayoutParams layoutParams14 = (ConstraintLayout.LayoutParams) this.f4818.f9367.getLayoutParams();
        int i6 = this.f4837;
        ((ViewGroup.MarginLayoutParams) layoutParams14).leftMargin = ((int) (i6 * 0.05f)) + ((this.f4827 - i6) / 2);
        ((ViewGroup.MarginLayoutParams) layoutParams14).height = (int) ((this.f4828 - C2579.m9440(getContext())) / 2.0f);
        this.f4818.f9367.setLayoutParams(layoutParams14);
        ConstraintLayout.LayoutParams layoutParams15 = (ConstraintLayout.LayoutParams) this.f4818.f9370.getLayoutParams();
        int iM144622 = (int) (C4792.m14375().m14462() * this.f4835);
        ((ViewGroup.MarginLayoutParams) layoutParams15).width = iM144622;
        ((ViewGroup.MarginLayoutParams) layoutParams15).height = iM144622;
        this.f4818.f9370.setLayoutParams(layoutParams15);
        ConstraintLayout.LayoutParams layoutParams16 = (ConstraintLayout.LayoutParams) this.f4818.f9387.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams16).leftMargin = C4792.m14375().m14476(20);
        this.f4818.f9387.setLayoutParams(layoutParams16);
        this.f4818.f9387.setContentTypeFace(FilmApp.m404());
        this.f4818.f9387.m2562(0, C4792.m14375().m14381());
        this.f4818.f9387.setTextColor(getResources().getColor(R.color.colorTransmitBlue, null));
        int iMeasureText = ((ViewGroup.MarginLayoutParams) layoutParams15).width + ((ViewGroup.MarginLayoutParams) layoutParams16).leftMargin + ((int) this.f4818.f9387.getPaint().measureText(getResources().getString(R.string.ADD_CLOUD_CAMERA))) + ((ViewGroup.MarginLayoutParams) layoutParams14).leftMargin;
        ConstraintLayout.LayoutParams layoutParams17 = (ConstraintLayout.LayoutParams) this.f4818.f9389.getLayoutParams();
        int iM9444 = (C2579.m9444() - (iM14476 * 5)) - (iM14461 * 4);
        int i7 = this.f4837;
        int i8 = iM9444 - (((int) (i7 * 0.05f)) + ((this.f4827 - i7) / 2));
        if (i8 < iMeasureText) {
            iM14461 -= (iMeasureText - i8) / 4;
            i = iM14476;
        } else {
            int i9 = iMeasureText - i8;
            i = i9 < iM14476 ? iM14476 - i9 : 0;
        }
        int i10 = iM14476 * 4;
        int i11 = iM14461 * 3;
        int iM94442 = (C2579.m9444() - i10) - i11;
        int i12 = this.f4837;
        ((ViewGroup.MarginLayoutParams) layoutParams17).leftMargin = (((iM94442 - (((int) (i12 * 0.05f)) + ((this.f4827 - i12) / 2))) - iM14461) - iM14476) + i;
        int iM14458 = C4792.m14375().m14458();
        ((ViewGroup.MarginLayoutParams) layoutParams17).leftMargin = (this.f4827 / 2) + ((((((this.f4827 / 2) - iM14458) - ((int) (((int) ((this.f4837 - (((this.f4836 * 16.0f) / 9.0f) * 0.9f)) / 2.0f)) - ((iM14458 * 57.0f) / 138.0f)))) - C4792.m14375().m14432()) - ((ViewGroup.MarginLayoutParams) layoutParams17).width) / 2);
        float f2 = this.f4844;
        int i13 = (((int) (320.0f * f2)) >> 1) << 1;
        int i14 = (((int) (f2 * 210.0f)) >> 1) << 1;
        ((ViewGroup.MarginLayoutParams) layoutParams17).width = (int) (i13 * 0.6f);
        ((ViewGroup.MarginLayoutParams) layoutParams17).height = (int) (i14 * 0.6f);
        ((ViewGroup.MarginLayoutParams) layoutParams17).bottomMargin = ((this.f4828 - this.f4836) / 2) + this.f4843;
        this.f4818.f9389.setLayoutParams(layoutParams17);
        int iM144762 = (int) (C4792.m14375().m14476(10) * 0.6f);
        this.f4818.f9389.setPadding(iM144762, iM144762, iM144762, iM144762);
        int i15 = (int) ((((i13 - r3) >> 1) << 1) * 0.6f);
        this.f4818.f9388.getLayoutParams().width = i15;
        this.f4818.f9388.getLayoutParams().height = (int) (((r10 >> 1) << 1) * 0.6f);
        this.f4818.f9390.getLayoutParams().width = i15;
        this.f4818.f9390.getLayoutParams().height = (int) (((((i14 - (iM144762 * 2)) - (((int) (C4792.m14375().m14476(3) * 0.6f)) * 2)) >> 1) << 1) * 0.6f);
        ConstraintLayout.LayoutParams layoutParams18 = (ConstraintLayout.LayoutParams) this.f4818.f9391.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams18).width = (int) (C4792.m14375().m14486() * 0.6f);
        ((ViewGroup.MarginLayoutParams) layoutParams18).height = (int) (C4792.m14375().m14485() * 0.6f);
        int childCount = this.f4818.f9391.getChildCount();
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = this.f4818.f9391.getChildAt(i16);
            LinearLayout.LayoutParams layoutParams19 = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            layoutParams19.width = (int) (C4792.m14375().m14395() * 0.6f);
            layoutParams19.height = (int) (C4792.m14375().m14395() * 0.6f);
            ((FilmPointView) childAt).setStrokeScale(0.6f);
            layoutParams19.leftMargin = (int) (C4792.m14375().m14388() * 0.6f);
            layoutParams19.rightMargin = (int) (C4792.m14375().m14388() * 0.6f);
            if (i16 == 0) {
                layoutParams19.leftMargin = (int) (C4792.m14375().m14388() * 0.6f);
            } else if (i16 == childCount - 1) {
                layoutParams19.rightMargin = (int) (C4792.m14375().m14388() * 0.6f);
            }
            childAt.setLayoutParams(layoutParams19);
        }
        C4041.m12968(this.f4847);
        m4698();
        if (!C2579.m9452(getContext())) {
            ConstraintLayout.LayoutParams layoutParams20 = (ConstraintLayout.LayoutParams) this.f4818.f9381.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) layoutParams20).width = this.f4837;
            ((ViewGroup.MarginLayoutParams) layoutParams20).height = this.f4836;
            this.f4818.f9381.setLayoutParams(layoutParams20);
        }
        this.f4818.f9390.setOpaque(false);
        this.f4818.f9389.setOnClickListener(new ViewOnClickListenerC1762());
        this.f4818.f9390.setSurfaceTextureListener(new TextureViewSurfaceTextureListenerC1763());
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this.f4818.f9386);
        constraintSet.connect(this.f4818.f9382.getId(), 4, 0, 4);
        constraintSet.applyTo(this.f4818.f9386);
        ConstraintLayout.LayoutParams layoutParams21 = (ConstraintLayout.LayoutParams) this.f4818.f9382.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams21).width = this.f4827;
        ((ViewGroup.MarginLayoutParams) layoutParams21).height = (int) ((this.f4828 - C2579.m9440(getContext())) / 2.0f);
        layoutParams21.bottomToBottom = R.id.root_parent;
        this.f4818.f9382.setLayoutParams(layoutParams21);
        this.f4846 = ((ViewGroup.MarginLayoutParams) layoutParams21).height;
        ConstraintSet constraintSet2 = new ConstraintSet();
        constraintSet2.clone(this.f4818.f9382);
        constraintSet2.clear(R.id.monitor_light);
        constraintSet2.connect(this.f4818.f9376.getId(), 1, 0, 1);
        constraintSet2.connect(this.f4818.f9376.getId(), 3, 0, 3);
        constraintSet2.applyTo(this.f4818.f9382);
        ConstraintLayout.LayoutParams layoutParams22 = (ConstraintLayout.LayoutParams) this.f4818.f9376.getLayoutParams();
        int iM94443 = (C2579.m9444() - i10) - i11;
        int i17 = this.f4837;
        ((ViewGroup.MarginLayoutParams) layoutParams22).leftMargin = iM94443 - (((int) (i17 * 0.05f)) + ((this.f4827 - i17) / 2));
        layoutParams22.topToTop = R.id.monitor_right_parent;
        layoutParams22.bottomToBottom = R.id.monitor_right_parent;
        ((ViewGroup.MarginLayoutParams) layoutParams22).width = iM14476;
        ((ViewGroup.MarginLayoutParams) layoutParams22).height = iM14476;
        this.f4818.f9376.setLayoutParams(layoutParams22);
        ConstraintSet constraintSet3 = new ConstraintSet();
        constraintSet3.clone(this.f4818.f9382);
        constraintSet3.clear(R.id.monitor_one);
        constraintSet3.connect(this.f4818.f9379.getId(), 1, R.id.monitor_light, 2);
        constraintSet3.connect(this.f4818.f9379.getId(), 3, 0, 3);
        constraintSet3.applyTo(this.f4818.f9382);
        ConstraintLayout.LayoutParams layoutParams23 = (ConstraintLayout.LayoutParams) this.f4818.f9379.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams23).width = ((ViewGroup.MarginLayoutParams) layoutParams22).width;
        ((ViewGroup.MarginLayoutParams) layoutParams23).height = ((ViewGroup.MarginLayoutParams) layoutParams22).height;
        layoutParams23.topToTop = R.id.monitor_right_parent;
        layoutParams23.bottomToBottom = R.id.monitor_right_parent;
        layoutParams23.leftToRight = R.id.monitor_light;
        ((ViewGroup.MarginLayoutParams) layoutParams23).leftMargin = iM14461;
        this.f4818.f9379.setLayoutParams(layoutParams23);
        ConstraintSet constraintSet4 = new ConstraintSet();
        constraintSet4.clone(this.f4818.f9382);
        constraintSet4.clear(R.id.monitor_two);
        constraintSet4.connect(this.f4818.f9383.getId(), 1, R.id.monitor_one, 2);
        constraintSet4.connect(this.f4818.f9383.getId(), 3, 0, 3);
        constraintSet4.applyTo(this.f4818.f9382);
        ConstraintLayout.LayoutParams layoutParams24 = (ConstraintLayout.LayoutParams) this.f4818.f9383.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams24).width = ((ViewGroup.MarginLayoutParams) layoutParams22).width;
        ((ViewGroup.MarginLayoutParams) layoutParams24).height = ((ViewGroup.MarginLayoutParams) layoutParams22).height;
        layoutParams24.topToTop = R.id.monitor_right_parent;
        layoutParams24.bottomToBottom = R.id.monitor_right_parent;
        ((ViewGroup.MarginLayoutParams) layoutParams24).leftMargin = iM14461;
        this.f4818.f9383.setLayoutParams(layoutParams24);
        ConstraintSet constraintSet5 = new ConstraintSet();
        constraintSet5.clone(this.f4818.f9382);
        constraintSet5.clear(R.id.monitor_four);
        constraintSet5.connect(this.f4818.f9374.getId(), 1, R.id.monitor_two, 2);
        constraintSet5.connect(this.f4818.f9374.getId(), 3, 0, 3);
        constraintSet5.applyTo(this.f4818.f9382);
        ConstraintLayout.LayoutParams layoutParams25 = (ConstraintLayout.LayoutParams) this.f4818.f9374.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams25).width = ((ViewGroup.MarginLayoutParams) layoutParams22).width;
        ((ViewGroup.MarginLayoutParams) layoutParams25).height = ((ViewGroup.MarginLayoutParams) layoutParams22).height;
        layoutParams25.topToTop = R.id.monitor_right_parent;
        layoutParams25.bottomToBottom = R.id.monitor_right_parent;
        ((ViewGroup.MarginLayoutParams) layoutParams25).leftMargin = iM14461;
        this.f4818.f9374.setLayoutParams(layoutParams25);
        ViewGroup.LayoutParams layoutParams26 = this.f4818.f9377.getLayoutParams();
        layoutParams26.width = C2579.m9438(44.0f);
        layoutParams26.height = C2579.m9438(44.0f);
        this.f4818.f9377.setLayoutParams(layoutParams26);
        ViewGroup.LayoutParams layoutParams27 = this.f4818.f9380.getLayoutParams();
        layoutParams27.width = C2579.m9438(44.0f);
        layoutParams27.height = C2579.m9438(44.0f);
        this.f4818.f9380.setLayoutParams(layoutParams27);
        ViewGroup.LayoutParams layoutParams28 = this.f4818.f9384.getLayoutParams();
        layoutParams28.width = C2579.m9438(44.0f);
        layoutParams28.height = C2579.m9438(44.0f);
        this.f4818.f9384.setLayoutParams(layoutParams28);
        ViewGroup.LayoutParams layoutParams29 = this.f4818.f9375.getLayoutParams();
        layoutParams29.width = C2579.m9438(44.0f);
        layoutParams29.height = C2579.m9438(44.0f);
        this.f4818.f9375.setLayoutParams(layoutParams29);
    }

    /* renamed from: ޔ, reason: contains not printable characters */
    public final void m4683() {
        this.f4839 = new ArrayList();
        this.f4839.addAll(this.f4818.f9373.getACUnitViewList());
    }

    /* renamed from: ޕ, reason: contains not printable characters */
    public boolean m4684() {
        return this.f4830;
    }

    /* renamed from: ޖ, reason: contains not printable characters */
    public void m4685() {
        m4686(C2579.m9451(getContext()) ? this.f4818.f9367 : this.f4818.f9371);
    }

    /* renamed from: ޗ, reason: contains not printable characters */
    public final void m4686(View view) {
        if (view.getVisibility() != 0 || view.getAlpha() <= 0.0f) {
            return;
        }
        if (e5.m5988().m5994()) {
            m4701();
        } else {
            m4675();
        }
    }

    /* renamed from: ޘ, reason: contains not printable characters */
    public final void m4687() {
        InterfaceC1779 interfaceC1779 = this.f4849;
        if (interfaceC1779 != null) {
            interfaceC1779.mo4708();
        }
    }

    /* renamed from: ޙ, reason: contains not printable characters */
    public final void m4688() {
        this.f4818.f9373.m4507(C2462.m9035().m9064());
    }

    /* renamed from: ޚ, reason: contains not printable characters */
    public void m4689() {
    }

    /* renamed from: ޛ, reason: contains not printable characters */
    public void m4690(boolean z) {
        this.f4819 = z;
        m4700(this.f4818.f9376, z);
    }

    /* renamed from: ޜ, reason: contains not printable characters */
    public final void m4691(boolean z) {
        m4692(z, false);
    }

    /* renamed from: ޝ, reason: contains not printable characters */
    public final void m4692(boolean z, boolean z2) {
        if (this.f4833 == 0) {
            this.f4833 = System.currentTimeMillis();
        } else {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.f4833 < 400) {
                return;
            } else {
                this.f4833 = jCurrentTimeMillis;
            }
        }
        int i = this.f4825;
        if (i == 1) {
            m4700(this.f4818.f9379, true);
            m4700(this.f4818.f9383, false);
            m4700(this.f4818.f9374, false);
            boolean zM4541 = this.f4818.f9373.m4541(z);
            if (!C2579.m9451(getContext()) || zM4541) {
                return;
            }
            C4008.m12876(this.f4818.f9389, 1.0f, z ? 100 : 0, null);
            C4008.m12876(this.f4818.f9391, 1.0f, z ? 100 : 0, null);
            return;
        }
        if (i == 2) {
            m4700(this.f4818.f9379, false);
            m4700(this.f4818.f9383, true);
            m4700(this.f4818.f9374, false);
            C4008.m12876(this.f4818.f9389, 0.0f, z ? 100 : 0, null);
            C4008.m12876(this.f4818.f9391, 0.0f, z ? 100 : 0, null);
            this.f4818.f9373.m4539();
            return;
        }
        if (i == 3) {
            m4700(this.f4818.f9379, false);
            m4700(this.f4818.f9383, false);
            m4700(this.f4818.f9374, true);
            C4008.m12876(this.f4818.f9389, 0.0f, z ? 100 : 0, null);
            C4008.m12876(this.f4818.f9391, 0.0f, z ? 100 : 0, null);
            this.f4818.f9373.m4540();
            return;
        }
        m4700(this.f4818.f9379, true);
        m4700(this.f4818.f9383, false);
        m4700(this.f4818.f9374, false);
        if (!z2) {
            C4008.m12876(this.f4818.f9389, 0.0f, z ? 100 : 0, null);
            C4008.m12876(this.f4818.f9391, 0.0f, z ? 100 : 0, null);
        }
        this.f4818.f9373.m4541(z);
    }

    /* renamed from: ޞ, reason: contains not printable characters */
    public void m4693() {
        this.f4818.f9373.m4510();
        this.f4825 = 1;
        this.f4818.f9373.m4473();
        m4691(false);
    }

    /* renamed from: ޟ, reason: contains not printable characters */
    public void m4694() {
        AbstractC2536 abstractC2536 = this.f4818;
        if (abstractC2536 != null) {
            abstractC2536.f9373.m4515();
            this.f4818.f9368.m4206();
        }
    }

    /* renamed from: ޠ, reason: contains not printable characters */
    public void m4695() {
        AbstractC2536 abstractC2536 = this.f4818;
        if (abstractC2536 != null) {
            abstractC2536.f9373.m4517(true);
        }
    }

    /* renamed from: ޡ, reason: contains not printable characters */
    public final void m4696() {
        m4700(this.f4818.f9376, this.f4819);
        m4692(false, true);
    }

    /* renamed from: ޢ, reason: contains not printable characters */
    public void m4697() {
        MonitorAnimateView monitorAnimateView = this.f4818.f9373;
        if (monitorAnimateView != null) {
            monitorAnimateView.m4529();
        }
    }

    /* renamed from: ޣ, reason: contains not printable characters */
    public final void m4698() {
        AbstractC2536 abstractC2536 = this.f4818;
        if (abstractC2536 == null) {
            return;
        }
        int childCount = abstractC2536.f9391.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ((FilmPointView) this.f4818.f9391.getChildAt(i)).m2292(false);
        }
        int i2 = this.f4847;
        if (i2 == 0) {
            ((FilmPointView) this.f4818.f9391.getChildAt(2)).m2292(true);
            return;
        }
        if (i2 == 1) {
            ((FilmPointView) this.f4818.f9391.getChildAt(3)).m2292(true);
            return;
        }
        if (i2 == 2) {
            ((FilmPointView) this.f4818.f9391.getChildAt(0)).m2292(true);
        } else if (i2 == 3) {
            ((FilmPointView) this.f4818.f9391.getChildAt(1)).m2292(true);
        } else {
            if (i2 != 4) {
                return;
            }
            ((FilmPointView) this.f4818.f9391.getChildAt(4)).m2292(true);
        }
    }

    /* renamed from: ޤ, reason: contains not printable characters */
    public void m4699(int i, int i2, boolean z, String str, int i3) {
        AbstractC2536 abstractC2536 = this.f4818;
        if (abstractC2536 != null) {
            abstractC2536.f9373.m4508(i, i2, z, str, i3);
        }
    }

    /* renamed from: ޥ, reason: contains not printable characters */
    public final void m4700(View view, boolean z) {
        C4008.m12876(view, z ? C4792.m14375().m14402() : 0.2f, 100, null);
    }

    /* renamed from: ޱ, reason: contains not printable characters */
    public final void m4701() {
        this.f4818.f9368.setVisibility(0);
        C4008.m12876(this.f4818.f9368, 0.0f, 0, null);
        C4008.m12876(this.f4818.f9368, 1.0f, 200, null);
        this.f4818.f9368.m4208(new C1759());
    }

    /* renamed from: ߾, reason: contains not printable characters */
    public final void m4702(int i) {
        this.f4818.f9378.m2580(getResources().getString(i), false);
        if (!this.f4822) {
            this.f4822 = true;
            this.f4820 = false;
            m4704(0.0f, 1.0f, 500L);
            return;
        }
        this.f4826.removeMessages(101);
        ValueAnimator valueAnimator = this.f4821;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f4820 = true;
        }
        ValueAnimator valueAnimator2 = this.f4824;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
            this.f4823 = true;
        }
        this.f4820 = false;
        m4704(0.0f, 1.0f, 0L);
    }

    /* renamed from: ߿, reason: contains not printable characters */
    public void m4703() {
        this.f4829 = false;
        this.f4830 = true;
        setVisibility(0);
        m4705();
        m4679();
        m4688();
        C4008.m12876(this.f4818.f9369, 0.0f, 200, null);
    }

    /* renamed from: ࡠ, reason: contains not printable characters */
    public final void m4704(float f, float f2, long j) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f, f2);
        this.f4821 = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(j);
        this.f4821.setInterpolator(C4008.m12881());
        this.f4821.addUpdateListener(new C1764());
        this.f4821.addListener(new C1765());
        this.f4821.start();
    }

    /* renamed from: ࡡ, reason: contains not printable characters */
    public final void m4705() {
        this.f4831 = true;
        LinkManager.getInstance().startLoop(new C1768());
        if (this.f4825 != 1 || C4041.m12959()) {
            return;
        }
        C4041.m12956(320, MPEGConst.SEQUENCE_ERROR_CODE);
    }

    /* renamed from: ࡢ, reason: contains not printable characters */
    public void m4706() {
        this.f4831 = false;
        m4693();
        LinkManager.getInstance().release();
        C4041.m12962(null);
    }

    public MonitorView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4825 = 1;
        this.f4826 = new WeakHandler(new C1769());
        this.f4838 = true;
        this.f4840 = 124;
        this.f4841 = 124;
        this.f4842 = 47;
        this.f4843 = 35;
        this.f4844 = C4792.m14375().m14455(1125.0f);
        this.f4845 = false;
        this.f4847 = 2;
        this.f4848 = 500L;
        m4678();
    }

    public MonitorView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4825 = 1;
        this.f4826 = new WeakHandler(new C1769());
        this.f4838 = true;
        this.f4840 = 124;
        this.f4841 = 124;
        this.f4842 = 47;
        this.f4843 = 35;
        this.f4844 = C4792.m14375().m14455(1125.0f);
        this.f4845 = false;
        this.f4847 = 2;
        this.f4848 = 500L;
        m4678();
    }
}
