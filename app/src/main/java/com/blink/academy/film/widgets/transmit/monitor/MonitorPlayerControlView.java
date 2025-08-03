package com.blink.academy.film.widgets.transmit.monitor;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blink.academy.protake.R;
import defpackage.AbstractC3675;
import defpackage.C2579;
import defpackage.C4792;
import defpackage.ViewOnTouchListenerC3426;

/* loaded from: classes.dex */
public class MonitorPlayerControlView extends FrameLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC3675 f4773;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f4774;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f4775;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public long f4776;

    /* renamed from: ԯ, reason: contains not printable characters */
    public long f4777;

    /* renamed from: ՠ, reason: contains not printable characters */
    public long f4778;

    /* renamed from: ֈ, reason: contains not printable characters */
    public long f4779;

    /* renamed from: ֏, reason: contains not printable characters */
    public long f4780;

    /* renamed from: ׯ, reason: contains not printable characters */
    public int f4781;

    /* renamed from: ؠ, reason: contains not printable characters */
    public float f4782;

    /* renamed from: ހ, reason: contains not printable characters */
    public int f4783;

    /* renamed from: ށ, reason: contains not printable characters */
    public InterfaceC1747 f4784;

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorPlayerControlView$Ϳ, reason: contains not printable characters */
    public class ViewOnClickListenerC1742 implements View.OnClickListener {
        public ViewOnClickListenerC1742() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - MonitorPlayerControlView.this.f4776 <= 200) {
                return;
            }
            MonitorPlayerControlView.this.f4776 = jCurrentTimeMillis;
            if (MonitorPlayerControlView.this.f4784 != null) {
                MonitorPlayerControlView.this.f4784.mo4563();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorPlayerControlView$Ԩ, reason: contains not printable characters */
    public class ViewOnClickListenerC1743 implements View.OnClickListener {
        public ViewOnClickListenerC1743() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - MonitorPlayerControlView.this.f4777 <= 200) {
                return;
            }
            MonitorPlayerControlView.this.f4777 = jCurrentTimeMillis;
            if (MonitorPlayerControlView.this.f4784 != null) {
                MonitorPlayerControlView.this.f4784.mo4565();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorPlayerControlView$Ԫ, reason: contains not printable characters */
    public class ViewOnClickListenerC1744 implements View.OnClickListener {
        public ViewOnClickListenerC1744() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - MonitorPlayerControlView.this.f4778 <= 200) {
                return;
            }
            MonitorPlayerControlView.this.f4778 = jCurrentTimeMillis;
            if (MonitorPlayerControlView.this.f4784 != null) {
                MonitorPlayerControlView.this.f4784.mo4564();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorPlayerControlView$Ԭ, reason: contains not printable characters */
    public class ViewOnClickListenerC1745 implements View.OnClickListener {
        public ViewOnClickListenerC1745() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - MonitorPlayerControlView.this.f4779 <= 200) {
                return;
            }
            MonitorPlayerControlView.this.f4779 = jCurrentTimeMillis;
            if (MonitorPlayerControlView.this.f4784 != null) {
                MonitorPlayerControlView.this.f4784.mo4566();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorPlayerControlView$Ԯ, reason: contains not printable characters */
    public class ViewOnClickListenerC1746 implements View.OnClickListener {
        public ViewOnClickListenerC1746() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - MonitorPlayerControlView.this.f4780 <= 200) {
                return;
            }
            MonitorPlayerControlView.this.f4780 = jCurrentTimeMillis;
            if (MonitorPlayerControlView.this.f4784 != null) {
                MonitorPlayerControlView.this.f4784.mo4567();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorPlayerControlView$ՠ, reason: contains not printable characters */
    public interface InterfaceC1747 {
        /* renamed from: Ϳ */
        void mo4563();

        /* renamed from: Ԩ */
        void mo4564();

        /* renamed from: ԩ */
        void mo4565();

        /* renamed from: Ԫ */
        void mo4566();

        /* renamed from: ԫ */
        void mo4567();
    }

    public MonitorPlayerControlView(@NonNull Context context) {
        super(context);
        this.f4776 = 0L;
        this.f4777 = 0L;
        this.f4778 = 0L;
        this.f4779 = 0L;
        this.f4780 = 0L;
        this.f4783 = -1;
        m4609();
    }

    public float getOffset() {
        return (this.f4775 - this.f4781) / 2.0f;
    }

    public float getTotalHeight() {
        return this.f4775;
    }

    public float getTotalWidth() {
        return this.f4774;
    }

    public void setOnChangeListener(InterfaceC1747 interfaceC1747) {
        this.f4784 = interfaceC1747;
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public void m4608(boolean z) {
        if (z) {
            this.f4773.f12755.setImageResource(R.drawable.icon_34_player_pause);
        } else {
            this.f4773.f12755.setImageResource(R.drawable.icon_34_player_play);
        }
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public final void m4609() {
        this.f4773 = AbstractC3675.m11820(LayoutInflater.from(getContext()), this, true);
        m4610();
        m4611();
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public final void m4610() {
        int iM9439 = C2579.m9439(getContext());
        C2579.m9440(getContext());
        float fM14434 = C4792.m14375().m14434();
        this.f4782 = fM14434;
        this.f4781 = (int) (iM9439 * 0.035205994f * fM14434);
        int iM14478 = C4792.m14375().m14478(101.0f, this.f4782);
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f4773.f12751.getLayoutParams();
        int i = this.f4781;
        ((ViewGroup.MarginLayoutParams) layoutParams).width = i;
        ((ViewGroup.MarginLayoutParams) layoutParams).height = i;
        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = iM14478;
        this.f4773.f12751.setLayoutParams(layoutParams);
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f4773.f12755.getLayoutParams();
        int i2 = this.f4781;
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = i2;
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = i2;
        this.f4773.f12755.setLayoutParams(layoutParams2);
        ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) this.f4773.f12753.getLayoutParams();
        int i3 = this.f4781;
        ((ViewGroup.MarginLayoutParams) layoutParams3).width = i3;
        ((ViewGroup.MarginLayoutParams) layoutParams3).height = i3;
        ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin = iM14478;
        this.f4773.f12753.setLayoutParams(layoutParams3);
        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) this.f4773.f12759.getLayoutParams();
        int i4 = this.f4781;
        ((ViewGroup.MarginLayoutParams) layoutParams4).width = i4;
        ((ViewGroup.MarginLayoutParams) layoutParams4).height = i4;
        ((ViewGroup.MarginLayoutParams) layoutParams4).rightMargin = iM14478;
        this.f4773.f12759.setLayoutParams(layoutParams4);
        ConstraintLayout.LayoutParams layoutParams5 = (ConstraintLayout.LayoutParams) this.f4773.f12757.getLayoutParams();
        int i5 = this.f4781;
        ((ViewGroup.MarginLayoutParams) layoutParams5).width = i5;
        ((ViewGroup.MarginLayoutParams) layoutParams5).height = i5;
        ((ViewGroup.MarginLayoutParams) layoutParams5).rightMargin = iM14478;
        this.f4773.f12757.setLayoutParams(layoutParams5);
        ConstraintLayout.LayoutParams layoutParams6 = (ConstraintLayout.LayoutParams) this.f4773.f12756.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams6).width = C2579.m9438(this.f4782 * 44.0f);
        ((ViewGroup.MarginLayoutParams) layoutParams6).height = C2579.m9438(this.f4782 * 44.0f);
        this.f4773.f12756.setLayoutParams(layoutParams6);
        ConstraintLayout.LayoutParams layoutParams7 = (ConstraintLayout.LayoutParams) this.f4773.f12760.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams7).width = ((ViewGroup.MarginLayoutParams) layoutParams6).width;
        ((ViewGroup.MarginLayoutParams) layoutParams7).height = ((ViewGroup.MarginLayoutParams) layoutParams6).width;
        this.f4773.f12760.setLayoutParams(layoutParams7);
        ConstraintLayout.LayoutParams layoutParams8 = (ConstraintLayout.LayoutParams) this.f4773.f12752.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams8).width = ((ViewGroup.MarginLayoutParams) layoutParams6).width;
        ((ViewGroup.MarginLayoutParams) layoutParams8).height = ((ViewGroup.MarginLayoutParams) layoutParams6).width;
        this.f4773.f12752.setLayoutParams(layoutParams8);
        ConstraintLayout.LayoutParams layoutParams9 = (ConstraintLayout.LayoutParams) this.f4773.f12754.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams9).width = ((ViewGroup.MarginLayoutParams) layoutParams6).width;
        ((ViewGroup.MarginLayoutParams) layoutParams9).height = ((ViewGroup.MarginLayoutParams) layoutParams6).width;
        this.f4773.f12754.setLayoutParams(layoutParams9);
        ConstraintLayout.LayoutParams layoutParams10 = (ConstraintLayout.LayoutParams) this.f4773.f12758.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams10).width = ((ViewGroup.MarginLayoutParams) layoutParams6).width;
        ((ViewGroup.MarginLayoutParams) layoutParams10).height = ((ViewGroup.MarginLayoutParams) layoutParams6).width;
        this.f4773.f12758.setLayoutParams(layoutParams10);
        this.f4774 = (((this.f4781 * 5) + (iM14478 * 4)) + ((ViewGroup.MarginLayoutParams) layoutParams6).width) - ((ViewGroup.MarginLayoutParams) layoutParams5).width;
        this.f4775 = ((ViewGroup.MarginLayoutParams) layoutParams6).height;
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public final void m4611() {
        AbstractC3675 abstractC3675 = this.f4773;
        abstractC3675.f12756.setOnTouchListener(new ViewOnTouchListenerC3426(abstractC3675.f12755));
        AbstractC3675 abstractC36752 = this.f4773;
        abstractC36752.f12752.setOnTouchListener(new ViewOnTouchListenerC3426(abstractC36752.f12751));
        AbstractC3675 abstractC36753 = this.f4773;
        abstractC36753.f12754.setOnTouchListener(new ViewOnTouchListenerC3426(abstractC36753.f12753));
        AbstractC3675 abstractC36754 = this.f4773;
        abstractC36754.f12758.setOnTouchListener(new ViewOnTouchListenerC3426(abstractC36754.f12757));
        AbstractC3675 abstractC36755 = this.f4773;
        abstractC36755.f12760.setOnTouchListener(new ViewOnTouchListenerC3426(abstractC36755.f12759));
        this.f4773.f12756.setOnClickListener(new ViewOnClickListenerC1742());
        this.f4773.f12754.setOnClickListener(new ViewOnClickListenerC1743());
        this.f4773.f12758.setOnClickListener(new ViewOnClickListenerC1744());
        this.f4773.f12752.setOnClickListener(new ViewOnClickListenerC1745());
        this.f4773.f12760.setOnClickListener(new ViewOnClickListenerC1746());
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public void m4612(int i) {
        if (i == this.f4783) {
            return;
        }
        this.f4783 = i;
        if (i == 0) {
            m4616(true);
            m4614(true);
            m4613(true);
            m4617(true);
            m4615(true);
            return;
        }
        if (i == 1) {
            m4616(true);
            m4614(false);
            m4613(true);
            m4617(true);
            m4615(true);
            return;
        }
        if (i == 2) {
            m4616(false);
            m4614(true);
            m4613(true);
            m4617(true);
            m4615(true);
            return;
        }
        if (i != 3) {
            return;
        }
        m4616(false);
        m4614(false);
        m4613(false);
        m4617(false);
        m4615(false);
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public final void m4613(boolean z) {
        float f = z ? 1.0f : 0.3f;
        if (z) {
            this.f4773.f12751.setEnabled(z);
            this.f4773.f12752.setEnabled(z);
        }
        this.f4773.f12751.setAlpha(f);
        if (z) {
            return;
        }
        this.f4773.f12751.setEnabled(z);
        this.f4773.f12752.setEnabled(z);
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public final void m4614(boolean z) {
        float f = z ? 1.0f : 0.3f;
        if (z) {
            this.f4773.f12753.setEnabled(z);
            this.f4773.f12754.setEnabled(z);
        }
        this.f4773.f12753.setAlpha(f);
        if (z) {
            return;
        }
        this.f4773.f12753.setEnabled(z);
        this.f4773.f12754.setEnabled(z);
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public final void m4615(boolean z) {
        float f = z ? 1.0f : 0.3f;
        if (z) {
            this.f4773.f12755.setEnabled(z);
            this.f4773.f12756.setEnabled(z);
        }
        this.f4773.f12755.setAlpha(f);
        if (z) {
            return;
        }
        this.f4773.f12755.setEnabled(z);
        this.f4773.f12756.setEnabled(z);
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public final void m4616(boolean z) {
        float f = z ? 1.0f : 0.3f;
        if (z) {
            this.f4773.f12757.setEnabled(true);
            this.f4773.f12758.setEnabled(true);
        }
        this.f4773.f12757.setAlpha(f);
        if (z) {
            return;
        }
        this.f4773.f12757.setEnabled(false);
        this.f4773.f12758.setEnabled(false);
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public final void m4617(boolean z) {
        float f = z ? 1.0f : 0.3f;
        if (z) {
            this.f4773.f12759.setEnabled(z);
            this.f4773.f12760.setEnabled(z);
        }
        this.f4773.f12759.setAlpha(f);
        if (z) {
            return;
        }
        this.f4773.f12759.setEnabled(z);
        this.f4773.f12760.setEnabled(z);
    }

    public MonitorPlayerControlView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4776 = 0L;
        this.f4777 = 0L;
        this.f4778 = 0L;
        this.f4779 = 0L;
        this.f4780 = 0L;
        this.f4783 = -1;
        m4609();
    }

    public MonitorPlayerControlView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4776 = 0L;
        this.f4777 = 0L;
        this.f4778 = 0L;
        this.f4779 = 0L;
        this.f4780 = 0L;
        this.f4783 = -1;
        m4609();
    }
}
