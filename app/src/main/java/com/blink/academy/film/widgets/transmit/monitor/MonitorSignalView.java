package com.blink.academy.film.widgets.transmit.monitor;

import android.content.Context;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.netbean.store.NvtInfoCallbackEntity;
import com.blink.academy.film.support.socket.TransmitHelper;
import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import com.blink.academy.protake.R;
import defpackage.AbstractC3772;
import defpackage.C4792;
import defpackage.n;
import defpackage.r1;

/* loaded from: classes.dex */
public class MonitorSignalView extends FrameLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC3772 f4793;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public float f4794;

    /* renamed from: ԭ, reason: contains not printable characters */
    public TextPaint f4795;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public int f4796;

    /* renamed from: ԯ, reason: contains not printable characters */
    public int f4797;

    /* renamed from: ՠ, reason: contains not printable characters */
    public String f4798;

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorSignalView$Ϳ, reason: contains not printable characters */
    public class RunnableC1748 implements Runnable {
        public RunnableC1748() {
        }

        @Override // java.lang.Runnable
        public void run() {
            float fMeasureText = MonitorSignalView.this.f4793.f13026.getPaint().measureText(MonitorSignalView.this.f4798);
            ViewGroup.LayoutParams layoutParams = MonitorSignalView.this.f4793.f13026.getLayoutParams();
            layoutParams.width = (int) (fMeasureText + C4792.f16138 + 10.0f);
            MonitorSignalView.this.f4793.f13026.setLayoutParams(layoutParams);
        }
    }

    public MonitorSignalView(@NonNull Context context) {
        super(context);
        this.f4796 = -1;
        this.f4797 = -1;
        this.f4798 = "";
        m4623();
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public void m4622() {
        this.f4796 = -1;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final void m4623() {
        this.f4793 = AbstractC3772.m12076(LayoutInflater.from(getContext()), this, true);
        m4624();
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final void m4624() {
        int iM14432 = C4792.m14375().m14432();
        this.f4794 = C4792.m14375().m14434();
        int iM14377 = (int) ((C4792.m14375().m14377() * this.f4794) + 0.5f);
        this.f4793.f13025.setContentTypeFace(FilmApp.m403());
        this.f4793.f13025.m2562(0, iM14377);
        TextPaint paint = this.f4793.f13025.getPaint();
        this.f4795 = paint;
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f4793.f13025.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).height = (int) ((fontMetrics.bottom - fontMetrics.top) + C4792.f16138);
        this.f4793.f13025.setLayoutParams(layoutParams);
        this.f4793.f13025.setDrawBorder(true);
        this.f4793.f13026.setContentTypeFace(FilmApp.m403());
        this.f4793.f13026.m2562(0, C4792.m14375().m14394());
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f4793.f13026.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = C4792.m14375().m14480(10.0f, this.f4794);
        this.f4793.f13026.setLayoutParams(layoutParams2);
        this.f4793.f13026.setDrawBorder(true);
        Paint.FontMetrics fontMetrics2 = this.f4793.f13026.getPaint().getFontMetrics();
        int i = (int) ((fontMetrics2.bottom - fontMetrics2.top) + C4792.f16138);
        ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) this.f4793.f13024.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams3).width = iM14432;
        ((ViewGroup.MarginLayoutParams) layoutParams3).height = iM14432;
        ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin = ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin + i;
        this.f4793.f13024.setLayoutParams(layoutParams3);
        this.f4793.f13024.m4163(0);
        this.f4793.f13024.setCenterState(2);
        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) this.f4793.f13021.getLayoutParams();
        int iM14476 = C4792.m14375().m14476(36);
        ((ViewGroup.MarginLayoutParams) layoutParams4).width = iM14476;
        ((ViewGroup.MarginLayoutParams) layoutParams4).height = iM14476;
        ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin = (i - C4792.m14375().m14480(10.0f, this.f4794)) + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin;
        this.f4793.f13021.setLayoutParams(layoutParams4);
        this.f4793.f13026.setContentTextColor(-1);
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public void m4625() {
        this.f4793.f13024.m4160();
        this.f4793.f13025.setContentTextColor(getResources().getColor(TransmitHelper.getSignalColor(1), null));
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final void m4626() {
        if (r1.m8143(this.f4798)) {
            this.f4793.f13026.post(new RunnableC1748());
        }
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public void m4627(String str) {
        this.f4793.f13025.m2561(str);
        ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.LayoutParams) this.f4793.f13025.getLayoutParams())).width = (int) (this.f4795.measureText(str) + C4792.f16138);
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public void m4628(int i) {
        if (this.f4797 == i) {
            return;
        }
        this.f4797 = i;
        int i2 = R.color.colorWhite;
        if (i == 1) {
            i2 = R.color.colorTransmitGreen;
        } else if (i == 2) {
            i2 = R.color.colorTransmitYellow;
        } else if (i == 3) {
            i2 = R.color.colorTransmitButton;
        } else if (i == 4) {
            i2 = R.color.color30White;
        }
        this.f4793.f13022.setColorFilter(getResources().getColor(i2, null));
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public void m4629(int i) {
        if (this.f4796 == i) {
            return;
        }
        this.f4796 = i;
        this.f4793.f13024.m4168(i);
        this.f4793.f13025.setContentTextColor(getResources().getColor(TransmitHelper.getSignalColor(i), null));
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public void m4630(int i, boolean z) {
        this.f4793.f13024.m4163(i);
        if (z) {
            this.f4793.f13021.setVisibility(0);
        } else {
            this.f4793.f13021.setVisibility(4);
        }
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public void m4631(String str) {
        this.f4793.f13024.m4167(str);
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public void m4632() {
        NvtInfoCallbackEntity nvtInfoCallbackEntityM7595 = n.m7588().m7595();
        if (nvtInfoCallbackEntityM7595 == null) {
            if ("N/A".equals(this.f4798)) {
                return;
            }
            this.f4798 = "N/A";
            this.f4793.f13026.setContentTextColor(-1);
            this.f4793.f13026.m2561("N/A");
            m4626();
            return;
        }
        int iMax = (int) (Math.max(0L, nvtInfoCallbackEntityM7595.getBalance()) / 60);
        String str = iMax + MyUTIL.white_space + getResources().getString(R.string.MONITOR_MIN);
        if (str.equals(this.f4798)) {
            return;
        }
        this.f4798 = str;
        if (iMax < 5) {
            this.f4793.f13026.setContentTextColor(getResources().getColor(R.color.colorRed, null));
        } else {
            this.f4793.f13026.setContentTextColor(-1);
        }
        this.f4793.f13026.m2561(this.f4798);
        m4626();
    }

    public MonitorSignalView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4796 = -1;
        this.f4797 = -1;
        this.f4798 = "";
        m4623();
    }

    public MonitorSignalView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4796 = -1;
        this.f4797 = -1;
        this.f4798 = "";
        m4623();
    }
}
