package com.blink.academy.film.widgets.transmit;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blink.academy.film.widgets.StrokeTextView;
import defpackage.AbstractC3413;
import defpackage.C2579;
import defpackage.C4792;
import defpackage.ViewOnTouchListenerC3426;

/* loaded from: classes.dex */
public class ConnectedDeviceItem extends FrameLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC3413 f4252;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f4253;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f4254;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public String f4255;

    /* renamed from: ԯ, reason: contains not printable characters */
    public InterfaceC1586 f4256;

    /* renamed from: com.blink.academy.film.widgets.transmit.ConnectedDeviceItem$Ϳ, reason: contains not printable characters */
    public class ViewOnClickListenerC1584 implements View.OnClickListener {
        public ViewOnClickListenerC1584() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ConnectedDeviceItem.this.f4256 != null) {
                ConnectedDeviceItem.this.f4256.mo4239();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.ConnectedDeviceItem$Ԩ, reason: contains not printable characters */
    public class ViewOnClickListenerC1585 implements View.OnClickListener {
        public ViewOnClickListenerC1585() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ConnectedDeviceItem.this.f4256 != null) {
                ConnectedDeviceItem.this.f4256.mo4238();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.ConnectedDeviceItem$Ԫ, reason: contains not printable characters */
    public interface InterfaceC1586 {
        /* renamed from: Ϳ, reason: contains not printable characters */
        void mo4238();

        /* renamed from: Ԩ, reason: contains not printable characters */
        void mo4239();
    }

    public ConnectedDeviceItem(@NonNull Context context) {
        super(context);
        this.f4253 = -100;
        this.f4254 = -199;
        this.f4255 = "";
        m4232();
    }

    public void setControlState(int i) {
        if (this.f4254 == i) {
            return;
        }
        this.f4252.f11772.m4166(i);
        if (i == 4) {
            this.f4252.f11772.setAlpha(0.2f);
        } else {
            this.f4252.f11772.setAlpha(1.0f);
        }
        this.f4254 = i;
    }

    public void setDeviceContent(String str) {
        if (this.f4255.equals(str)) {
            return;
        }
        this.f4252.f11777.m2561(str);
        this.f4255 = str;
    }

    public void setOnChangeListener(InterfaceC1586 interfaceC1586) {
        this.f4256 = interfaceC1586;
    }

    public void setWifiState(int i) {
        if (this.f4253 == i) {
            return;
        }
        this.f4252.f11775.m4171(i);
        if (i == 4) {
            this.f4252.f11775.setAlpha(0.2f);
        } else {
            this.f4252.f11775.setAlpha(1.0f);
        }
        this.f4253 = i;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final void m4232() {
        this.f4252 = AbstractC3413.m11195(LayoutInflater.from(getContext()), this, true);
        float fM14471 = C4792.m14375().m14471();
        int iM14384 = (int) ((C4792.m14375().m14384() * fM14471) + 0.5f);
        float fM14386 = C4792.m14375().m14386();
        float fM143862 = C4792.m14375().m14386();
        C4792.m14375().m14468();
        C2579.m9444();
        C2579.m9439(getContext());
        this.f4252.f11775.setPadding(0, 0, 0, 0);
        this.f4252.f11775.m4170(fM14386, fM143862);
        this.f4252.f11772.m4170(fM14386, fM143862);
        int iM14480 = C4792.m14375().m14480(30.0f, fM14471);
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f4252.f11776.getLayoutParams();
        float f = fM14386 + iM14480;
        int i = (int) (0 + f);
        ((ViewGroup.MarginLayoutParams) layoutParams).width = i;
        this.f4252.f11776.setLayoutParams(layoutParams);
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f4252.f11773.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = i;
        this.f4252.f11773.setLayoutParams(layoutParams2);
        ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) this.f4252.f11774.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams3).width = (int) f;
        ((ViewGroup.MarginLayoutParams) layoutParams3).height = C2579.m9438(44.0f);
        this.f4252.f11774.setLayoutParams(layoutParams3);
        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) this.f4252.f11771.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams4).width = i;
        ((ViewGroup.MarginLayoutParams) layoutParams4).height = C2579.m9438(44.0f);
        this.f4252.f11771.setLayoutParams(layoutParams4);
        this.f4252.f11777.setLayoutParams((ConstraintLayout.LayoutParams) this.f4252.f11777.getLayoutParams());
        m4237(this.f4252.f11777, iM14384);
        this.f4252.f11777.setDrawBorder(false);
        this.f4252.f11775.m4164(0);
        this.f4252.f11772.m4158();
        this.f4252.f11774.setOnClickListener(new ViewOnClickListenerC1584());
        this.f4252.f11771.setOnClickListener(new ViewOnClickListenerC1585());
        AbstractC3413 abstractC3413 = this.f4252;
        abstractC3413.f11774.setOnTouchListener(new ViewOnTouchListenerC3426(abstractC3413.f11776));
        AbstractC3413 abstractC34132 = this.f4252;
        abstractC34132.f11771.setOnTouchListener(new ViewOnTouchListenerC3426(abstractC34132.f11773));
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public void m4233(boolean z) {
        this.f4252.f11775.m4164(!z ? 1 : 0);
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public void m4234(boolean z) {
        float f = z ? 1.0f : 0.2f;
        if (this.f4252.f11777.getAlpha() != f) {
            this.f4252.f11777.setAlpha(f);
        }
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public void m4235() {
        setWifiState(4);
        setControlState(4);
        m4234(false);
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public void m4236(int i, int i2) {
        setWifiState(i);
        setControlState(i2);
        m4234(true);
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final void m4237(StrokeTextView strokeTextView, float f) {
        strokeTextView.m2562(0, f);
        strokeTextView.setContentTextColor(-1);
    }

    public ConnectedDeviceItem(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4253 = -100;
        this.f4254 = -199;
        this.f4255 = "";
        m4232();
    }

    public ConnectedDeviceItem(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4253 = -100;
        this.f4254 = -199;
        this.f4255 = "";
        m4232();
    }
}
