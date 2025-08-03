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
import com.blink.academy.film.widgets.RecordTimeFrameView;
import com.blink.academy.film.widgets.StrokeTextView;
import defpackage.AbstractC3512;
import defpackage.AbstractC4012;
import defpackage.C4008;
import defpackage.C4792;

/* loaded from: classes.dex */
public class RecordTimeLayout extends FrameLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC3512 f4873;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public TextPaint f4874;

    /* renamed from: ԭ, reason: contains not printable characters */
    public float f4875;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public boolean f4876;

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.RecordTimeLayout$Ϳ, reason: contains not printable characters */
    public class C1780 extends AbstractC4012 {
        public C1780() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.RecordTimeLayout$Ԩ, reason: contains not printable characters */
    public class C1781 extends AbstractC4012 {
        public C1781() {
        }
    }

    public RecordTimeLayout(@NonNull Context context) {
        super(context);
        this.f4876 = true;
        m4712();
    }

    public StrokeTextView getRecordDeviceNum() {
        return this.f4873.f12283;
    }

    public RecordTimeFrameView getRecordTimeFrame() {
        return this.f4873.f12284;
    }

    public int getViewRealHeight() {
        int i = this.f4873.f12284.getLayoutParams().height;
        Paint.FontMetrics fontMetrics = this.f4873.f12283.getPaint().getFontMetrics();
        return i + ((int) (fontMetrics.bottom - fontMetrics.top));
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m4711(boolean z, int i) {
        if (z == this.f4876) {
            return;
        }
        this.f4876 = z;
        if (z) {
            C4008.m12886(this.f4873.f12283, 0.0f, 0.0f, i, new C1780());
            return;
        }
        int measuredWidth = this.f4873.f12283.getMeasuredWidth();
        if (measuredWidth == 0) {
            measuredWidth = (int) this.f4874.measureText("A001 A00000");
        }
        AbstractC3512 abstractC3512 = this.f4873;
        C4008.m12886(abstractC3512.f12283, (abstractC3512.f12284.getLayoutWidth() - measuredWidth) * 0.9f, -C4792.m14375().m14476(5), i, new C1781());
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final void m4712() {
        AbstractC3512 abstractC3512M11459 = AbstractC3512.m11459(LayoutInflater.from(getContext()), this, true);
        this.f4873 = abstractC3512M11459;
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) abstractC3512M11459.f12284.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).width = (int) (this.f4873.f12284.getLayoutWidth() + C4792.f16138);
        ((ViewGroup.MarginLayoutParams) layoutParams).height = (int) (this.f4873.f12284.getLayoutHeight() + C4792.f16138);
        this.f4873.f12284.setLayoutParams(layoutParams);
        this.f4873.f12284.m2513("");
        this.f4873.f12283.m2562(0, C4792.m14375().m14397());
        this.f4873.f12283.setContentTypeFace(FilmApp.m404());
        this.f4873.f12283.setContentTextColor(-1);
        TextPaint paint = this.f4873.f12283.getPaint();
        this.f4874 = paint;
        this.f4875 = paint.measureText("WWWWW WWWWWW");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f4873.f12283.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin = (int) C4792.f16138;
        this.f4873.f12283.setLayoutParams(layoutParams2);
    }

    public RecordTimeLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4876 = true;
        m4712();
    }

    public RecordTimeLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4876 = true;
        m4712();
    }
}
