package com.blink.academy.film.widgets.looks;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.blink.academy.film.FilmApp;
import defpackage.AbstractC4405;
import defpackage.C4792;

/* loaded from: classes.dex */
public class StyleUpdateView extends FrameLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC4405 f3857;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public float f3858;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f3859;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public InterfaceC1357 f3860;

    /* renamed from: com.blink.academy.film.widgets.looks.StyleUpdateView$Ϳ, reason: contains not printable characters */
    public class ViewOnClickListenerC1356 implements View.OnClickListener {
        public ViewOnClickListenerC1356() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InterfaceC1357 interfaceC1357 = StyleUpdateView.this.f3860;
            if (interfaceC1357 != null) {
                interfaceC1357.mo3733();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.looks.StyleUpdateView$Ԩ, reason: contains not printable characters */
    public interface InterfaceC1357 {
        /* renamed from: Ϳ */
        void mo3733();
    }

    public StyleUpdateView(@NonNull Context context) {
        this(context, null);
    }

    public float getUpdateHeight() {
        return this.f3859;
    }

    public void setContentText(String str) {
        this.f3857.f15179.setText(str);
    }

    public void setOnUpdateListener(InterfaceC1357 interfaceC1357) {
        this.f3860 = interfaceC1357;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public int m3864(int i) {
        return C4792.m14375().m14477(i, this.f3858);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final void m3865() {
        this.f3857 = AbstractC4405.m13598(LayoutInflater.from(getContext()), this, true);
        m3866();
        m3867();
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final void m3866() {
        this.f3858 = C4792.m14375().m14434();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f3857.f15178.getLayoutParams();
        int iM3864 = (int) (m3864(36) * this.f3858);
        layoutParams.width = iM3864;
        layoutParams.height = iM3864;
        layoutParams.rightMargin = (int) (m3864(10) * this.f3858);
        this.f3857.f15178.setLayoutParams(layoutParams);
        this.f3857.f15179.setTextSize(0, C4792.m14375().m14396() * this.f3858);
        this.f3857.f15179.setTypeface(FilmApp.m404());
        int iM38642 = (int) (m3864(30) * this.f3858);
        int iM38643 = (int) (m3864(10) * this.f3858);
        this.f3857.f15180.setPadding(iM38642, iM38643, iM38642, iM38643);
        this.f3859 = layoutParams.height + (iM38643 * 2);
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final void m3867() {
        setOnClickListener(new ViewOnClickListenerC1356());
    }

    public StyleUpdateView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StyleUpdateView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m3865();
    }
}
