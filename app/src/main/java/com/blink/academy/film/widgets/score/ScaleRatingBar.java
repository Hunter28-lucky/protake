package com.blink.academy.film.widgets.score;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public class ScaleRatingBar extends AnimationRatingBar {

    /* renamed from: com.blink.academy.film.widgets.score.ScaleRatingBar$Ϳ, reason: contains not printable characters */
    public class RunnableC1365 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ int f3903;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ double f3904;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final /* synthetic */ PartialView f3905;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final /* synthetic */ float f3906;

        public RunnableC1365(int i, double d, PartialView partialView, float f) {
            this.f3903 = i;
            this.f3904 = d;
            this.f3905 = partialView;
            this.f3906 = f;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f3903 == this.f3904) {
                this.f3905.m3898(this.f3906);
            } else {
                this.f3905.m3896();
            }
        }
    }

    public ScaleRatingBar(Context context) {
        super(context);
    }

    @Override // com.blink.academy.film.widgets.score.BaseRatingBar
    /* renamed from: Ϳ */
    public void mo3881(float f) {
        if (this.f3877 != null) {
            this.f3876.removeCallbacksAndMessages(this.f3878);
        }
        for (PartialView partialView : this.f3896) {
            int iIntValue = ((Integer) partialView.getTag()).intValue();
            double dCeil = Math.ceil(f);
            if (iIntValue > dCeil) {
                partialView.m3894();
            } else {
                Runnable runnableM3905 = m3905(f, partialView, iIntValue, dCeil);
                this.f3877 = runnableM3905;
                m3880(runnableM3905, 15L);
            }
        }
    }

    @NonNull
    /* renamed from: ހ, reason: contains not printable characters */
    public final Runnable m3905(float f, PartialView partialView, int i, double d) {
        return new RunnableC1365(i, d, partialView, f);
    }

    public ScaleRatingBar(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScaleRatingBar(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
