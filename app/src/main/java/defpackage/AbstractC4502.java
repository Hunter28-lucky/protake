package defpackage;

import androidx.annotation.NonNull;

/* compiled from: SimpleTarget.java */
/* renamed from: ఈ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC4502<Z> extends AbstractC5173<Z> {

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final int f15419;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final int f15420;

    public AbstractC4502() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override // defpackage.c1
    /* renamed from: Ϳ */
    public final void mo175(@NonNull InterfaceC4752 interfaceC4752) {
        if (j5.m7101(this.f15419, this.f15420)) {
            interfaceC4752.mo5029(this.f15419, this.f15420);
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + this.f15419 + " and height: " + this.f15420 + ", either provide dimensions in the constructor or call override()");
    }

    @Override // defpackage.c1
    /* renamed from: ԩ */
    public void mo177(@NonNull InterfaceC4752 interfaceC4752) {
    }

    public AbstractC4502(int i, int i2) {
        this.f15419 = i;
        this.f15420 = i2;
    }
}
