package com.blink.academy.film.widgets.transmit.monitor;

import android.content.Context;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blink.academy.film.FilmApp;
import com.blink.academy.protake.R;
import defpackage.AbstractC4148;
import defpackage.C4792;
import defpackage.ViewOnTouchListenerC3426;

/* loaded from: classes.dex */
public class ExtendView extends ConstraintLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC4148 f4355;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f4356;

    /* renamed from: ԭ, reason: contains not printable characters */
    public InterfaceC1642 f4357;

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.ExtendView$Ϳ, reason: contains not printable characters */
    public class ViewOnClickListenerC1641 implements View.OnClickListener {
        public ViewOnClickListenerC1641() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ExtendView.this.f4357 != null) {
                ExtendView.this.f4357.mo4393();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.ExtendView$Ԩ, reason: contains not printable characters */
    public interface InterfaceC1642 {
        /* renamed from: Ϳ, reason: contains not printable characters */
        void mo4393();
    }

    public ExtendView(@NonNull Context context) {
        this(context, null);
    }

    public int getViewHeight() {
        int i = this.f4356;
        return i == 0 ? this.f4355.f14375.getLayoutParams().height : i;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f4356 = i2;
    }

    public void setOnCallback(InterfaceC1642 interfaceC1642) {
        this.f4357 = interfaceC1642;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final void m4390() {
        this.f4355 = AbstractC4148.m13131(LayoutInflater.from(getContext()), this, true);
        m4391();
        m4392();
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final void m4391() {
        this.f4355.f14377.setContentTypeFace(FilmApp.m403());
        this.f4355.f14377.setTextColor(-65536);
        this.f4355.f14377.m2562(0, C4792.m14375().m14377());
        this.f4355.f14376.setTypeface(FilmApp.m403());
        this.f4355.f14376.setTextSize(0, C4792.m14375().m14377());
        this.f4355.f14376.setText(R.string.BUTTON_EXTEND);
        TextPaint paint = this.f4355.f14377.getPaint();
        int iM14476 = C4792.m14375().m14476(15);
        int iM144762 = C4792.m14375().m14476(25);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float f = (int) (fontMetrics.descent - fontMetrics.ascent);
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f4355.f14375.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = C4792.m14375().m14479(30.0f, C4792.m14375().m14471());
        ((ViewGroup.MarginLayoutParams) layoutParams).width = (int) (paint.measureText(getContext().getString(R.string.BUTTON_EXTEND).toUpperCase()) + (iM144762 * 2));
        ((ViewGroup.MarginLayoutParams) layoutParams).height = (int) (f + (iM14476 * 2));
        this.f4355.f14375.setLayoutParams(layoutParams);
        this.f4355.f14377.m2561(String.format(getResources().getString(R.string.MONITOR_TIME_LEFT_TIME2), "0"));
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final void m4392() {
        FrameLayout frameLayout = this.f4355.f14375;
        frameLayout.setOnTouchListener(new ViewOnTouchListenerC3426(frameLayout));
        this.f4355.f14375.setOnClickListener(new ViewOnClickListenerC1641());
    }

    public ExtendView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ExtendView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m4390();
    }
}
