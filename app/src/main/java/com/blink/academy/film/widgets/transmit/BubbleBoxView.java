package com.blink.academy.film.widgets.transmit;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import com.blink.academy.film.FilmApp;
import com.blink.academy.protake.R;
import defpackage.AbstractC4898;
import defpackage.C2579;
import defpackage.C4792;

/* loaded from: classes.dex */
public class BubbleBoxView extends FrameLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC4898 f4181;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public InterfaceC1550 f4182;

    /* renamed from: com.blink.academy.film.widgets.transmit.BubbleBoxView$Ϳ, reason: contains not printable characters */
    public interface InterfaceC1550 {
        /* renamed from: Ϳ, reason: contains not printable characters */
        void m4156(int i, int i2);
    }

    public BubbleBoxView(@NonNull Context context) {
        super(context);
        m4155();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        InterfaceC1550 interfaceC1550 = this.f4182;
        if (interfaceC1550 != null) {
            interfaceC1550.m4156(i, i2);
        }
    }

    public void setBubbleTextViewHelper(InterfaceC1550 interfaceC1550) {
        this.f4182 = interfaceC1550;
    }

    public void setTextViewRotation(float f) {
        this.f4181.f16540.setRotation(f);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m4155() {
        AbstractC4898 abstractC4898M14624 = AbstractC4898.m14624(LayoutInflater.from(getContext()), this, true);
        this.f4181 = abstractC4898M14624;
        abstractC4898M14624.f16541.setColor(getResources().getColor(R.color.colorGold, null));
        this.f4181.f16540.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.f4181.f16540.setTypeface(FilmApp.m403());
        this.f4181.f16540.setTextSize(0, (int) ((C4792.m14375().m14378() * C4792.m14375().m14434()) + 0.5f));
        Paint.FontMetrics fontMetrics = this.f4181.f16540.getPaint().getFontMetrics();
        float f = fontMetrics.descent - fontMetrics.ascent;
        float f2 = fontMetrics.bottom - fontMetrics.top;
        int iM9438 = C2579.m9438(10.0f);
        int iM94382 = C2579.m9438(8.0f);
        float fMeasureText = this.f4181.f16540.getPaint().measureText(getResources().getString(R.string.POPUP_WIRELESS_VIDEO)) + (iM9438 * 2);
        float f3 = (fontMetrics.bottom - fontMetrics.top) + C4792.f16138 + (iM94382 * 2);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f4181.f16540.getLayoutParams();
        layoutParams.height = (int) ((fontMetrics.bottom - fontMetrics.top) + C4792.f16138);
        layoutParams.topMargin = (int) (((f3 - f) / 2.0f) - ((f2 - f) / 2.0f));
        layoutParams.leftMargin = iM9438;
        this.f4181.f16540.setLayoutParams(layoutParams);
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f4181.f16541.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = C2579.m9438(12.0f);
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = C2579.m9438(12.0f);
        ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = (int) (f3 - C4792.f16138);
        this.f4181.f16541.setLayoutParams(layoutParams2);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.f4181.f16539.getLayoutParams();
        layoutParams3.width = (int) fMeasureText;
        layoutParams3.height = (int) f3;
        this.f4181.f16539.setLayoutParams(layoutParams3);
        this.f4181.f16539.m4154(fMeasureText, f3, C2579.m9438(20.0f));
    }

    public BubbleBoxView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m4155();
    }

    public BubbleBoxView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m4155();
    }
}
