package com.blink.academy.film.widgets.looks;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.blink.academy.film.FilmApp;
import com.blink.academy.protake.R;
import defpackage.AbstractC4913;
import defpackage.C2579;
import defpackage.C4008;
import defpackage.C4792;

/* loaded from: classes.dex */
public class StyleDownloadingView extends FrameLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC4913 f3852;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f3853;

    /* renamed from: ԭ, reason: contains not printable characters */
    public float f3854;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public InterfaceC1355 f3855;

    /* renamed from: com.blink.academy.film.widgets.looks.StyleDownloadingView$Ϳ, reason: contains not printable characters */
    public class ViewOnClickListenerC1354 implements View.OnClickListener {
        public ViewOnClickListenerC1354() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InterfaceC1355 interfaceC1355 = StyleDownloadingView.this.f3855;
            if (interfaceC1355 != null) {
                interfaceC1355.mo3732();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.looks.StyleDownloadingView$Ԩ, reason: contains not printable characters */
    public interface InterfaceC1355 {
        /* renamed from: Ԩ */
        void mo3732();
    }

    public StyleDownloadingView(@NonNull Context context) {
        this(context, null);
    }

    private void setImageTint(int i) {
        Drawable drawableWrap = DrawableCompat.wrap(ContextCompat.getDrawable(getContext(), R.drawable.icon_25_download));
        DrawableCompat.setTint(drawableWrap, ContextCompat.getColor(getContext(), i));
        this.f3852.f16566.setImageDrawable(drawableWrap);
    }

    public void setContentText(String str) {
        this.f3852.f16568.setText(str);
        Paint paint = new Paint();
        paint.setTextSize(C4792.m14375().m14386() * this.f3854);
        paint.setTypeface(FilmApp.m404());
        float fMeasureText = paint.measureText(str) + (m3860(75) * this.f3854) + (m3860(40) * this.f3854) + (C2579.m9438(15.0f) * 2);
        float fM9450 = C2579.m9450(getContext());
        if (fMeasureText <= fM9450) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f3852.f16566.getLayoutParams();
            int iM3860 = (int) (m3860(75) * this.f3854);
            layoutParams.width = iM3860;
            layoutParams.height = iM3860;
            layoutParams.rightMargin = (int) (m3860(40) * this.f3854);
            this.f3852.f16566.setLayoutParams(layoutParams);
            this.f3852.f16568.m2562(0, C4792.m14375().m14386() * this.f3854);
            return;
        }
        float f = fM9450 / fMeasureText;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f3852.f16566.getLayoutParams();
        int iM38602 = (int) (m3860(75) * this.f3854 * f);
        layoutParams2.width = iM38602;
        layoutParams2.height = iM38602;
        layoutParams2.rightMargin = (int) (m3860(40) * this.f3854 * f);
        this.f3852.f16566.setLayoutParams(layoutParams2);
        this.f3852.f16568.m2562(0, C4792.m14375().m14386() * this.f3854 * f);
    }

    public void setOnDownloadListener(InterfaceC1355 interfaceC1355) {
        this.f3855 = interfaceC1355;
    }

    public void setShowType(int i) {
        this.f3853 = i;
        if (i == 0) {
            this.f3852.f16566.setImageResource(R.drawable.icon_25_download_yellow);
            this.f3852.f16568.setContentTextColor(C4792.m14375().m14431());
        } else if (i == 1) {
            this.f3852.f16566.setImageResource(R.drawable.icon_25_download);
            this.f3852.f16568.setContentTextColor(-1);
        } else {
            if (i != 2) {
                return;
            }
            C4008.m12876(this, 0.0f, 100, null);
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public int m3860(int i) {
        return C4792.m14375().m14477(i, this.f3854);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final void m3861() {
        this.f3852 = AbstractC4913.m14638(LayoutInflater.from(getContext()), this, true);
        m3862();
        m3863();
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final void m3862() {
        this.f3854 = C4792.m14375().m14434();
        this.f3852.f16568.setTextColor(-1);
        this.f3852.f16568.m2562(0, C4792.m14375().m14386() * this.f3854);
        this.f3852.f16568.setTypeface(FilmApp.m404());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f3852.f16566.getLayoutParams();
        int iM3860 = (int) (m3860(75) * this.f3854);
        layoutParams.width = iM3860;
        layoutParams.height = iM3860;
        layoutParams.rightMargin = (int) (m3860(40) * this.f3854);
        this.f3852.f16566.setLayoutParams(layoutParams);
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final void m3863() {
        this.f3852.f16567.setOnClickListener(new ViewOnClickListenerC1354());
    }

    public StyleDownloadingView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StyleDownloadingView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m3861();
    }
}
