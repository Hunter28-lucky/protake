package com.blink.academy.film.widgets.dialog;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import defpackage.AbstractC5211;
import defpackage.C2579;

/* loaded from: classes.dex */
public class SettingCodeDialog extends RelativeLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC5211 f2918;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public InterfaceC1025 f2919;

    /* renamed from: com.blink.academy.film.widgets.dialog.SettingCodeDialog$Ϳ, reason: contains not printable characters */
    public class ViewOnClickListenerC1023 implements View.OnClickListener {
        public ViewOnClickListenerC1023() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SettingCodeDialog.this.f2919 != null) {
                SettingCodeDialog.this.f2919.mo1723();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.SettingCodeDialog$Ԩ, reason: contains not printable characters */
    public class ViewOnClickListenerC1024 implements View.OnClickListener {
        public ViewOnClickListenerC1024() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.SettingCodeDialog$Ԫ, reason: contains not printable characters */
    public interface InterfaceC1025 {
        /* renamed from: Ϳ */
        void mo1723();
    }

    public SettingCodeDialog(Context context) {
        this(context, null);
    }

    public void setBitmap(Bitmap bitmap) {
        this.f2918.f17264.setImageBitmap(bitmap);
    }

    public void setOnButtonClick(InterfaceC1025 interfaceC1025) {
        this.f2919 = interfaceC1025;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final void m2882() {
        this.f2918 = AbstractC5211.m15204(LayoutInflater.from(getContext()), this, true);
        m2883();
        this.f2918.f17266.setOnClickListener(new ViewOnClickListenerC1023());
        this.f2918.f17264.setOnClickListener(new ViewOnClickListenerC1024());
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final void m2883() {
        int iM9440 = (int) (C2579.m9440(getContext()) * 0.75567424f);
        ViewGroup.LayoutParams layoutParams = this.f2918.f17265.getLayoutParams();
        layoutParams.height = iM9440;
        layoutParams.width = iM9440;
        this.f2918.f17265.setLayoutParams(layoutParams);
    }

    public SettingCodeDialog(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SettingCodeDialog(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2882();
    }
}
