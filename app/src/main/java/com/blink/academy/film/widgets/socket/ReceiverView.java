package com.blink.academy.film.widgets.socket;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blink.academy.film.bean.socket.SocketAddressBean;
import defpackage.AbstractC4187;
import defpackage.AbstractC4975;
import defpackage.C4194;
import defpackage.C4196;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class ReceiverView extends FrameLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC4187 f4169;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public C4194 f4170;

    /* renamed from: ԭ, reason: contains not printable characters */
    public ArrayList<C4196> f4171;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public InterfaceC1549 f4172;

    /* renamed from: com.blink.academy.film.widgets.socket.ReceiverView$Ϳ, reason: contains not printable characters */
    public class C1548 implements AbstractC4975.InterfaceC4979 {
        public C1548() {
        }

        @Override // defpackage.AbstractC4975.InterfaceC4979
        /* renamed from: ԫ, reason: contains not printable characters */
        public void mo4147(int i) {
        }

        @Override // defpackage.AbstractC4975.InterfaceC4979
        /* renamed from: Ԭ, reason: contains not printable characters */
        public void mo4148(int i) {
        }

        @Override // defpackage.AbstractC4975.InterfaceC4976
        /* renamed from: ԭ */
        public void mo1557(int i) {
        }

        @Override // defpackage.AbstractC4975.InterfaceC4976
        /* renamed from: Ԯ */
        public void mo1558(int i) {
        }

        @Override // defpackage.AbstractC4975.InterfaceC4979
        /* renamed from: ԯ, reason: contains not printable characters */
        public void mo4149(int i) {
            if (ReceiverView.this.f4172 != null) {
                ReceiverView.this.f4172.m4150(i, ((C4196) ReceiverView.this.f4171.get(i)).m13234());
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.socket.ReceiverView$Ԩ, reason: contains not printable characters */
    public interface InterfaceC1549 {
        /* renamed from: Ϳ, reason: contains not printable characters */
        void m4150(int i, SocketAddressBean socketAddressBean);
    }

    public ReceiverView(@NonNull Context context) {
        super(context);
        this.f4171 = new ArrayList<>();
        m4145();
    }

    public void setOnReceiverListener(InterfaceC1549 interfaceC1549) {
        this.f4172 = interfaceC1549;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final void m4145() {
        this.f4169 = AbstractC4187.m13212(LayoutInflater.from(getContext()), this, true);
        m4146();
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final void m4146() {
        this.f4170 = new C4194(getContext(), this.f4171, new C1548());
        this.f4169.f14449.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        this.f4169.f14449.setAdapter(this.f4170);
    }

    public ReceiverView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4171 = new ArrayList<>();
        m4145();
    }

    public ReceiverView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4171 = new ArrayList<>();
        m4145();
    }
}
