package com.blink.academy.film.widgets.transmit.monitor;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blink.academy.protake.R;
import defpackage.AbstractC4914;
import defpackage.C2579;
import defpackage.C4008;
import defpackage.C4792;
import defpackage.ViewOnTouchListenerC3426;
import defpackage.l5;

/* loaded from: classes.dex */
public class MonitorFlagView extends FrameLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC4914 f4733;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f4734;

    /* renamed from: ԭ, reason: contains not printable characters */
    public long f4735;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public long f4736;

    /* renamed from: ԯ, reason: contains not printable characters */
    public long f4737;

    /* renamed from: ՠ, reason: contains not printable characters */
    public long f4738;

    /* renamed from: ֈ, reason: contains not printable characters */
    public float f4739;

    /* renamed from: ֏, reason: contains not printable characters */
    public int f4740;

    /* renamed from: ׯ, reason: contains not printable characters */
    public float f4741;

    /* renamed from: ؠ, reason: contains not printable characters */
    public float f4742;

    /* renamed from: ހ, reason: contains not printable characters */
    public float f4743;

    /* renamed from: ށ, reason: contains not printable characters */
    public int f4744;

    /* renamed from: ނ, reason: contains not printable characters */
    public float f4745;

    /* renamed from: ރ, reason: contains not printable characters */
    public int f4746;

    /* renamed from: ބ, reason: contains not printable characters */
    public int f4747;

    /* renamed from: ޅ, reason: contains not printable characters */
    public boolean f4748;

    /* renamed from: ކ, reason: contains not printable characters */
    public InterfaceC1741 f4749;

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorFlagView$Ϳ, reason: contains not printable characters */
    public class C1731 implements l5 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ ConstraintLayout.LayoutParams f4750;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final /* synthetic */ int f4751;

        /* renamed from: ԩ, reason: contains not printable characters */
        public final /* synthetic */ int f4752;

        public C1731(ConstraintLayout.LayoutParams layoutParams, int i, int i2) {
            this.f4750 = layoutParams;
            this.f4751 = i;
            this.f4752 = i2;
        }

        @Override // defpackage.l5
        /* renamed from: Ϳ */
        public void mo1305() {
        }

        @Override // defpackage.l5
        /* renamed from: Ԩ */
        public void mo1306() {
        }

        @Override // defpackage.l5
        /* renamed from: ԩ */
        public void mo1307(float f) {
            ConstraintLayout.LayoutParams layoutParams = this.f4750;
            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = (int) (this.f4751 + ((this.f4752 - r1) * f));
            MonitorFlagView.this.f4733.f16571.setLayoutParams(this.f4750);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorFlagView$Ԩ, reason: contains not printable characters */
    public class RunnableC1732 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ boolean f4754;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ boolean f4755;

        public RunnableC1732(boolean z, boolean z2) {
            this.f4754 = z;
            this.f4755 = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z = this.f4754 && this.f4755;
            MonitorFlagView.this.f4733.f16577.setEnabled(z);
            MonitorFlagView.this.f4733.f16581.setEnabled(z);
            MonitorFlagView.this.f4733.f16579.setEnabled(z);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorFlagView$Ԫ, reason: contains not printable characters */
    public class ViewOnClickListenerC1733 implements View.OnClickListener {
        public ViewOnClickListenerC1733() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - MonitorFlagView.this.f4735 <= 200) {
                return;
            }
            MonitorFlagView.this.f4735 = jCurrentTimeMillis;
            if (MonitorFlagView.this.f4749 != null) {
                MonitorFlagView.this.f4749.mo4557();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorFlagView$Ԭ, reason: contains not printable characters */
    public class ViewOnClickListenerC1734 implements View.OnClickListener {

        /* renamed from: ԫ, reason: contains not printable characters */
        public long f4758;

        public ViewOnClickListenerC1734() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.f4758 <= 200) {
                return;
            }
            this.f4758 = jCurrentTimeMillis;
            if (MonitorFlagView.this.f4749 != null) {
                MonitorFlagView.this.f4749.mo4561();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorFlagView$Ԯ, reason: contains not printable characters */
    public class ViewOnTouchListenerC1735 implements View.OnTouchListener {

        /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorFlagView$Ԯ$Ϳ, reason: contains not printable characters */
        public class RunnableC1736 implements Runnable {
            public RunnableC1736() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MonitorFlagView.this.f4733.f16571.setAlpha(1.0f);
            }
        }

        public ViewOnTouchListenerC1735() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                MonitorFlagView.this.f4733.f16571.setAlpha(0.3f);
                return false;
            }
            if (action != 1 && action != 3) {
                return false;
            }
            new Handler().postDelayed(new RunnableC1736(), 100L);
            return false;
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorFlagView$ՠ, reason: contains not printable characters */
    public class ViewOnClickListenerC1737 implements View.OnClickListener {
        public ViewOnClickListenerC1737() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (System.currentTimeMillis() - MonitorFlagView.this.f4736 > 200 && MonitorFlagView.this.f4749 != null) {
                MonitorFlagView.this.f4749.mo4558();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorFlagView$ֈ, reason: contains not printable characters */
    public class ViewOnClickListenerC1738 implements View.OnClickListener {
        public ViewOnClickListenerC1738() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (System.currentTimeMillis() - MonitorFlagView.this.f4737 > 200 && MonitorFlagView.this.f4749 != null) {
                MonitorFlagView.this.f4749.mo4559();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorFlagView$֏, reason: contains not printable characters */
    public class ViewOnClickListenerC1739 implements View.OnClickListener {
        public ViewOnClickListenerC1739() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (System.currentTimeMillis() - MonitorFlagView.this.f4738 > 200 && MonitorFlagView.this.f4749 != null) {
                MonitorFlagView.this.f4749.mo4560();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorFlagView$ׯ, reason: contains not printable characters */
    public class C1740 implements l5 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ float f4765;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final /* synthetic */ float f4766;

        public C1740(float f, float f2) {
            this.f4765 = f;
            this.f4766 = f2;
        }

        @Override // defpackage.l5
        /* renamed from: Ϳ */
        public void mo1305() {
        }

        @Override // defpackage.l5
        /* renamed from: Ԩ */
        public void mo1306() {
        }

        @Override // defpackage.l5
        /* renamed from: ԩ */
        public void mo1307(float f) {
            float f2 = this.f4765;
            float f3 = f2 + ((this.f4766 - f2) * f);
            MonitorFlagView.this.f4733.f16574.setScaleX(f3);
            MonitorFlagView.this.f4733.f16574.setScaleY(f3);
            int i = (int) (MonitorFlagView.this.f4744 * f3);
            MonitorFlagView.this.f4733.f16570.m2215(i, i);
            MonitorFlagView.this.f4733.f16570.setTranslationX((MonitorFlagView.this.f4744 - i) / 2.0f);
            MonitorFlagView.this.f4733.f16570.setTranslationY((MonitorFlagView.this.f4744 - (MonitorFlagView.this.f4744 * f3)) / 2.0f);
            MonitorFlagView.this.f4733.f16574.setTranslationY((-MonitorFlagView.this.f4745) * (1.0f - f3));
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorFlagView$ؠ, reason: contains not printable characters */
    public interface InterfaceC1741 {
        /* renamed from: Ϳ */
        void mo4557();

        /* renamed from: Ԩ */
        void mo4558();

        /* renamed from: ԩ */
        void mo4559();

        /* renamed from: Ԫ */
        void mo4560();

        /* renamed from: ԫ */
        void mo4561();

        /* renamed from: Ԭ */
        void mo4562(int i);
    }

    public MonitorFlagView(@NonNull Context context) {
        super(context);
        this.f4735 = 0L;
        this.f4736 = 0L;
        this.f4737 = 0L;
        this.f4738 = 0L;
        this.f4747 = -1;
        m4578();
    }

    public float getNeedScale() {
        return this.f4743;
    }

    public float getOffsetHeight() {
        return this.f4742 + (this.f4745 * (1.0f - this.f4743));
    }

    public float getOffsetWidth() {
        return this.f4741;
    }

    public int getPlayerBtnCircleWidth() {
        return this.f4744;
    }

    public float getPlayerBtnWidth() {
        return this.f4739;
    }

    public float getTotalHeight() {
        return this.f4734;
    }

    public void setOnChangeClick(InterfaceC1741 interfaceC1741) {
        this.f4749 = interfaceC1741;
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public void m4577(boolean z, boolean z2) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f4733.f16571.getLayoutParams();
        if (!z2) {
            if (z) {
                ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = this.f4746;
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = (int) (this.f4746 * 0.6f);
            }
            this.f4733.f16571.setLayoutParams(layoutParams);
            return;
        }
        int i = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        int i2 = z ? this.f4746 : (int) (this.f4746 * 0.6f);
        if (i != i2) {
            C4008.m12880(0.0f, 1.0f, 400L, new C1731(layoutParams, i, i2));
        }
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final void m4578() {
        this.f4733 = AbstractC4914.m14640(LayoutInflater.from(getContext()), this, true);
        m4579();
        m4580();
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public final void m4579() {
        float fM14434 = C4792.m14375().m14434();
        C2579.m9440(getContext());
        int iM9439 = C2579.m9439(getContext());
        float fM14455 = C4792.m14375().m14455(1125.0f);
        float f = iM9439;
        this.f4740 = (int) (0.029213483f * f);
        int i = (int) (f * 0.037453182f);
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f4733.f16584.getLayoutParams();
        float f2 = 124.0f * fM14434 * fM14455;
        float f3 = i;
        ((ViewGroup.MarginLayoutParams) layoutParams).width = (int) ((f2 - C2579.m9438(2.0f)) + f3);
        ((ViewGroup.MarginLayoutParams) layoutParams).height = this.f4740 + i;
        this.f4733.f16584.setLayoutParams(layoutParams);
        this.f4739 = ((ViewGroup.MarginLayoutParams) layoutParams).width;
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f4733.f16569.getLayoutParams();
        int iM9438 = (int) (f2 - C2579.m9438(2.0f));
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = iM9438;
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = iM9438;
        this.f4733.f16569.setLayoutParams(layoutParams2);
        int i2 = ((ViewGroup.MarginLayoutParams) layoutParams2).width;
        this.f4744 = i2;
        this.f4733.f16570.m2215(i2, ((ViewGroup.MarginLayoutParams) layoutParams2).height);
        this.f4733.f16570.m2214(true);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.f4733.f16574.getLayoutParams();
        int i3 = (int) (((ViewGroup.MarginLayoutParams) layoutParams2).width * 0.6f);
        layoutParams3.width = i3;
        layoutParams3.height = i3;
        float f4 = i3 * 0.15f;
        this.f4745 = f4;
        layoutParams3.topMargin = (int) (((((ViewGroup.MarginLayoutParams) layoutParams2).height - i3) / 2) + f4);
        this.f4733.f16574.setLayoutParams(layoutParams3);
        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) this.f4733.f16582.getLayoutParams();
        int iM14462 = (int) (C4792.m14375().m14462() * fM14434);
        ((ViewGroup.MarginLayoutParams) layoutParams4).width = iM14462;
        ((ViewGroup.MarginLayoutParams) layoutParams4).height = iM14462;
        this.f4733.f16582.setLayoutParams(layoutParams4);
        int i4 = ((ViewGroup.MarginLayoutParams) layoutParams4).width;
        this.f4743 = (((i4 * 1.0f) + (i4 * 0.07638889f)) + C4792.f16138) / ((ViewGroup.MarginLayoutParams) layoutParams2).width;
        ConstraintLayout.LayoutParams layoutParams5 = (ConstraintLayout.LayoutParams) this.f4733.f16571.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams5).width = ((ViewGroup.MarginLayoutParams) layoutParams).width;
        ((ViewGroup.MarginLayoutParams) layoutParams5).height = ((ViewGroup.MarginLayoutParams) layoutParams).height;
        int i5 = ((ViewGroup.MarginLayoutParams) layoutParams).width;
        ((ViewGroup.MarginLayoutParams) layoutParams5).rightMargin = i5;
        this.f4746 = i5;
        this.f4733.f16571.setLayoutParams(layoutParams5);
        ConstraintLayout.LayoutParams layoutParams6 = (ConstraintLayout.LayoutParams) this.f4733.f16575.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams6).width = (int) (C4792.m14375().m14462() * fM14434);
        ((ViewGroup.MarginLayoutParams) layoutParams6).height = ((ViewGroup.MarginLayoutParams) layoutParams4).width;
        this.f4733.f16575.setLayoutParams(layoutParams6);
        ConstraintLayout.LayoutParams layoutParams7 = (ConstraintLayout.LayoutParams) this.f4733.f16572.getLayoutParams();
        int iM14476 = C4792.m14375().m14476(20);
        ((ViewGroup.MarginLayoutParams) layoutParams7).width = iM14476;
        ((ViewGroup.MarginLayoutParams) layoutParams7).height = iM14476;
        ((ViewGroup.MarginLayoutParams) layoutParams7).leftMargin = (((ViewGroup.MarginLayoutParams) layoutParams6).width / 2) + iM14476 + C4792.m14375().m14476(5);
        this.f4733.f16572.setLayoutParams(layoutParams7);
        this.f4733.f16572.setColor(getResources().getColor(R.color.colorTransmitGreen, null));
        ConstraintLayout.LayoutParams layoutParams8 = (ConstraintLayout.LayoutParams) this.f4733.f16580.getLayoutParams();
        int i6 = this.f4740;
        ((ViewGroup.MarginLayoutParams) layoutParams8).width = i6;
        ((ViewGroup.MarginLayoutParams) layoutParams8).height = i6;
        this.f4733.f16580.setLayoutParams(layoutParams8);
        ConstraintLayout.LayoutParams layoutParams9 = (ConstraintLayout.LayoutParams) this.f4733.f16578.getLayoutParams();
        int i7 = this.f4740;
        ((ViewGroup.MarginLayoutParams) layoutParams9).width = i7;
        ((ViewGroup.MarginLayoutParams) layoutParams9).height = i7;
        this.f4733.f16578.setLayoutParams(layoutParams9);
        ConstraintLayout.LayoutParams layoutParams10 = (ConstraintLayout.LayoutParams) this.f4733.f16576.getLayoutParams();
        int i8 = this.f4740;
        ((ViewGroup.MarginLayoutParams) layoutParams10).width = i8;
        ((ViewGroup.MarginLayoutParams) layoutParams10).height = i8;
        this.f4733.f16576.setLayoutParams(layoutParams10);
        ConstraintLayout.LayoutParams layoutParams11 = (ConstraintLayout.LayoutParams) this.f4733.f16581.getLayoutParams();
        int i9 = this.f4740 + i;
        ((ViewGroup.MarginLayoutParams) layoutParams11).width = i9;
        ((ViewGroup.MarginLayoutParams) layoutParams11).height = i9;
        this.f4733.f16581.setLayoutParams(layoutParams11);
        ConstraintLayout.LayoutParams layoutParams12 = (ConstraintLayout.LayoutParams) this.f4733.f16579.getLayoutParams();
        int i10 = this.f4740 + i;
        ((ViewGroup.MarginLayoutParams) layoutParams12).width = i10;
        ((ViewGroup.MarginLayoutParams) layoutParams12).height = i10;
        this.f4733.f16579.setLayoutParams(layoutParams12);
        ConstraintLayout.LayoutParams layoutParams13 = (ConstraintLayout.LayoutParams) this.f4733.f16577.getLayoutParams();
        int i11 = this.f4740 + i;
        ((ViewGroup.MarginLayoutParams) layoutParams13).width = i11;
        ((ViewGroup.MarginLayoutParams) layoutParams13).height = i11;
        this.f4733.f16577.setLayoutParams(layoutParams13);
        this.f4734 = ((ViewGroup.MarginLayoutParams) layoutParams13).width;
        this.f4733.f16569.setPivotX(1.0f);
        this.f4733.f16569.setPivotY(1.0f);
        this.f4741 = f3 / 2.0f;
        ConstraintLayout.LayoutParams layoutParams14 = (ConstraintLayout.LayoutParams) this.f4733.f16583.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams14).width = ((ViewGroup.MarginLayoutParams) layoutParams4).width;
        ((ViewGroup.MarginLayoutParams) layoutParams14).height = ((ViewGroup.MarginLayoutParams) layoutParams4).height;
        ((ViewGroup.MarginLayoutParams) layoutParams14).rightMargin = (int) ((((ViewGroup.MarginLayoutParams) layoutParams).width - ((ViewGroup.MarginLayoutParams) layoutParams4).width) / 2.0f);
        this.f4733.f16583.setLayoutParams(layoutParams14);
        this.f4742 = (Math.max(((ViewGroup.MarginLayoutParams) layoutParams11).height, ((ViewGroup.MarginLayoutParams) layoutParams).height) - ((ViewGroup.MarginLayoutParams) layoutParams2).height) / 2.0f;
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public final void m4580() {
        ConstraintLayout constraintLayout = this.f4733.f16584;
        constraintLayout.setOnTouchListener(new ViewOnTouchListenerC3426(constraintLayout));
        ConstraintLayout constraintLayout2 = this.f4733.f16577;
        constraintLayout2.setOnTouchListener(new ViewOnTouchListenerC3426(constraintLayout2));
        ConstraintLayout constraintLayout3 = this.f4733.f16579;
        constraintLayout3.setOnTouchListener(new ViewOnTouchListenerC3426(constraintLayout3));
        ConstraintLayout constraintLayout4 = this.f4733.f16581;
        constraintLayout4.setOnTouchListener(new ViewOnTouchListenerC3426(constraintLayout4));
        this.f4733.f16584.setOnClickListener(new ViewOnClickListenerC1733());
        this.f4733.f16571.setOnClickListener(new ViewOnClickListenerC1734());
        this.f4733.f16571.setOnTouchListener(new ViewOnTouchListenerC1735());
        this.f4733.f16577.setOnClickListener(new ViewOnClickListenerC1737());
        this.f4733.f16581.setOnClickListener(new ViewOnClickListenerC1738());
        this.f4733.f16579.setOnClickListener(new ViewOnClickListenerC1739());
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public void m4581(boolean z, int i, boolean z2) {
        float f = z ? z2 ? 1.0f : 0.3f : 0.0f;
        m4585(this.f4733.f16573, z);
        C4008.m12877(this.f4733.f16577, f, i, null);
        C4008.m12877(this.f4733.f16581, f, i, null);
        C4008.m12877(this.f4733.f16579, f, i, null);
        this.f4733.f16577.postDelayed(new RunnableC1732(z, z2), i);
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public void m4582(int i) {
        switch (i) {
            case 99:
                m4587(this.f4733.f16576, R.drawable.icon_30_player_good);
                m4587(this.f4733.f16578, R.drawable.icon_30_player_keep);
                m4587(this.f4733.f16580, R.drawable.icon_30_player_ng);
                break;
            case 100:
                m4587(this.f4733.f16576, R.drawable.icon_30_player_good_selected);
                m4587(this.f4733.f16578, R.drawable.icon_30_player_keep);
                m4587(this.f4733.f16580, R.drawable.icon_30_player_ng);
                break;
            case 101:
                m4587(this.f4733.f16576, R.drawable.icon_30_player_good);
                m4587(this.f4733.f16578, R.drawable.icon_30_player_keep_selected);
                m4587(this.f4733.f16580, R.drawable.icon_30_player_ng);
                break;
            case 102:
                m4587(this.f4733.f16576, R.drawable.icon_30_player_good);
                m4587(this.f4733.f16578, R.drawable.icon_30_player_keep);
                m4587(this.f4733.f16580, R.drawable.icon_30_player_ng_selected);
                break;
        }
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public void m4583(int i, boolean z) {
        if (this.f4747 == i && this.f4748 == z) {
            return;
        }
        this.f4747 = i;
        this.f4748 = z;
        if (i == 0) {
            this.f4733.f16582.setAlpha(1.0f);
            this.f4733.f16569.setAlpha(0.0f);
            m4584(this.f4733.f16584, true, z);
            this.f4733.f16571.setVisibility(0);
            m4584(this.f4733.f16571, true, true);
            m4584(this.f4733.f16577, false, z);
            m4584(this.f4733.f16581, false, z);
            m4584(this.f4733.f16579, false, z);
            m4589(false);
            InterfaceC1741 interfaceC1741 = this.f4749;
            if (interfaceC1741 != null) {
                interfaceC1741.mo4562(i);
                return;
            }
            return;
        }
        if (i == 1) {
            InterfaceC1741 interfaceC17412 = this.f4749;
            if (interfaceC17412 != null) {
                interfaceC17412.mo4562(i);
            }
            this.f4733.f16582.setAlpha(0.0f);
            this.f4733.f16569.setAlpha(1.0f);
            m4584(this.f4733.f16584, true, z);
            this.f4733.f16571.setVisibility(8);
            m4584(this.f4733.f16571, false, false);
            m4584(this.f4733.f16577, true, z);
            m4584(this.f4733.f16581, true, z);
            m4584(this.f4733.f16579, true, z);
            m4589(false);
            return;
        }
        if (i == 3) {
            this.f4733.f16582.setAlpha(0.0f);
            this.f4733.f16569.setAlpha(0.0f);
            m4584(this.f4733.f16569, false, z);
            m4589(true);
            InterfaceC1741 interfaceC17413 = this.f4749;
            if (interfaceC17413 != null) {
                interfaceC17413.mo4562(i);
                return;
            }
            return;
        }
        this.f4733.f16582.setAlpha(0.0f);
        this.f4733.f16569.setAlpha(0.0f);
        m4584(this.f4733.f16584, false, z);
        m4584(this.f4733.f16571, false, z);
        m4584(this.f4733.f16577, false, z);
        m4584(this.f4733.f16581, false, z);
        m4584(this.f4733.f16579, false, z);
        m4589(false);
        InterfaceC1741 interfaceC17414 = this.f4749;
        if (interfaceC17414 != null) {
            interfaceC17414.mo4562(i);
        }
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public final void m4584(View view, boolean z, boolean z2) {
        float f = z ? z2 ? 1.0f : 0.3f : 0.0f;
        if (z && z2) {
            view.setEnabled(true);
        }
        view.setAlpha(f);
        if (z && z2) {
            return;
        }
        view.setEnabled(false);
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public final void m4585(View view, boolean z) {
        float f = z ? 1.0f : 0.0f;
        if (z) {
            view.setEnabled(true);
        }
        view.setAlpha(f);
        if (z) {
            return;
        }
        view.setEnabled(false);
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public void m4586(float f, int i, int i2, boolean z) {
        if (f != 1.0f) {
            m4581(false, 0, z);
        } else if (i2 == 1) {
            m4581(true, i, z);
        }
        C4008.m12880(0.0f, 1.0f, i, new C1740(this.f4733.f16574.getScaleX(), f));
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public final void m4587(ImageView imageView, int i) {
        imageView.setImageResource(i);
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public void m4588(boolean z) {
        if (z) {
            this.f4733.f16572.setVisibility(0);
        } else {
            this.f4733.f16572.setVisibility(4);
        }
    }

    /* renamed from: އ, reason: contains not printable characters */
    public final void m4589(boolean z) {
        this.f4733.f16583.setVisibility(z ? 0 : 8);
    }

    public MonitorFlagView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4735 = 0L;
        this.f4736 = 0L;
        this.f4737 = 0L;
        this.f4738 = 0L;
        this.f4747 = -1;
        m4578();
    }

    public MonitorFlagView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4735 = 0L;
        this.f4736 = 0L;
        this.f4737 = 0L;
        this.f4738 = 0L;
        this.f4747 = -1;
        m4578();
    }
}
