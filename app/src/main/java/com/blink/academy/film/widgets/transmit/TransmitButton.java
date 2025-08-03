package com.blink.academy.film.widgets.transmit;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.blink.academy.protake.R;
import defpackage.AbstractC3926;
import defpackage.C4792;

/* loaded from: classes.dex */
public class TransmitButton extends FrameLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC3926 f4268;

    public TransmitButton(Context context) {
        super(context);
        m4258();
    }

    public void setState(boolean z) {
        if (z) {
            this.f4268.f13552.setBackgroundColor(getResources().getColor(R.color.colorTransmitButton, null));
            this.f4268.f13553.setContentTextColor(getResources().getColor(R.color.colorWhite, null));
            this.f4268.f13553.setText(getResources().getString(R.string.MONITOR_BUTTON_STOP));
        } else {
            this.f4268.f13552.setBackgroundColor(getResources().getColor(R.color.colorGold, null));
            this.f4268.f13553.setContentTextColor(getResources().getColor(R.color.colorBlack, null));
            this.f4268.f13553.setText(getResources().getString(R.string.MONITOR_BUTTON_START));
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m4258() {
        this.f4268 = AbstractC3926.m12684(LayoutInflater.from(getContext()), this, true);
        this.f4268.f13553.m2562(0, (int) ((C4792.m14375().m14384() * C4792.m14375().m14471()) + 0.5f));
        this.f4268.f13553.setDrawBorder(false);
    }

    public TransmitButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m4258();
    }

    public TransmitButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m4258();
    }
}
