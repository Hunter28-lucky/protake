package com.blink.academy.film.widgets.socket;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.blink.academy.film.FilmApp;
import defpackage.AbstractC3134;

/* loaded from: classes.dex */
public class SocketAddressItem extends FrameLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC3134 f4174;

    public SocketAddressItem(@NonNull Context context) {
        super(context);
        m4151();
    }

    public void setAddress(String str) {
        this.f4174.f11136.setText(str);
    }

    public void setConnectMsg(String str) {
        this.f4174.f11135.setText(str);
    }

    public void setOnConnectListener(View.OnClickListener onClickListener) {
        this.f4174.f11135.setOnClickListener(onClickListener);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m4151() {
        AbstractC3134 abstractC3134M10724 = AbstractC3134.m10724(LayoutInflater.from(getContext()), this, true);
        this.f4174 = abstractC3134M10724;
        abstractC3134M10724.f11136.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.f4174.f11136.setTypeface(FilmApp.m404());
        this.f4174.f11135.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.f4174.f11135.setTypeface(FilmApp.m404());
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m4152(boolean z) {
        if (z) {
            this.f4174.f11135.setVisibility(0);
        } else {
            this.f4174.f11135.setVisibility(8);
        }
    }

    public SocketAddressItem(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m4151();
    }

    public SocketAddressItem(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m4151();
    }
}
