package defpackage;

import defpackage.C3469;
import kotlinx.coroutines.channels.ClosedReceiveChannelException;
import kotlinx.coroutines.channels.ClosedSendChannelException;

/* compiled from: AbstractChannel.kt */
/* renamed from: į, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2340<E> extends AbstractC4669 implements InterfaceC5097<E> {

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final Throwable f8870;

    public C2340(Throwable th) {
        this.f8870 = th;
    }

    @Override // defpackage.C3469
    public String toString() {
        return "Closed@" + C2316.m8691(this) + '[' + this.f8870 + ']';
    }

    @Override // defpackage.InterfaceC5097
    /* renamed from: Ԭ */
    public void mo7347(E e2) {
    }

    @Override // defpackage.InterfaceC5097
    /* renamed from: ԭ */
    public r0 mo7348(E e2, C3469.C3471 c3471) {
        return C5006.f16769;
    }

    @Override // defpackage.AbstractC4669
    /* renamed from: ފ, reason: contains not printable characters */
    public void mo8752() {
    }

    @Override // defpackage.AbstractC4669
    /* renamed from: ތ, reason: contains not printable characters */
    public void mo8754(C2340<?> c2340) {
    }

    @Override // defpackage.AbstractC4669
    /* renamed from: ލ, reason: contains not printable characters */
    public r0 mo8755(C3469.C3471 c3471) {
        return C5006.f16769;
    }

    @Override // defpackage.InterfaceC5097
    /* renamed from: ޏ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public C2340<E> mo8751() {
        return this;
    }

    @Override // defpackage.AbstractC4669
    /* renamed from: ސ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public C2340<E> mo8753() {
        return this;
    }

    /* renamed from: ޑ, reason: contains not printable characters */
    public final Throwable m8758() {
        Throwable th = this.f8870;
        return th == null ? new ClosedReceiveChannelException("Channel was closed") : th;
    }

    /* renamed from: ޒ, reason: contains not printable characters */
    public final Throwable m8759() {
        Throwable th = this.f8870;
        return th == null ? new ClosedSendChannelException("Channel was closed") : th;
    }
}
