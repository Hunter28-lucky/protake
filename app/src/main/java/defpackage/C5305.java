package defpackage;

import defpackage.C3469;
import kotlin.Result;

/* compiled from: AbstractChannel.kt */
/* renamed from: ჯ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C5305<E> extends AbstractC4669 {

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final E f17550;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final InterfaceC5005<i4> f17551;

    /* JADX WARN: Multi-variable type inference failed */
    public C5305(E e2, InterfaceC5005<? super i4> interfaceC5005) {
        this.f17550 = e2;
        this.f17551 = interfaceC5005;
    }

    @Override // defpackage.C3469
    public String toString() {
        return C2316.m8690(this) + '@' + C2316.m8691(this) + '(' + mo8753() + ')';
    }

    @Override // defpackage.AbstractC4669
    /* renamed from: ފ */
    public void mo8752() {
        this.f17551.mo13680(C5006.f16769);
    }

    @Override // defpackage.AbstractC4669
    /* renamed from: ދ */
    public E mo8753() {
        return this.f17550;
    }

    @Override // defpackage.AbstractC4669
    /* renamed from: ތ */
    public void mo8754(C2340<?> c2340) {
        InterfaceC5005<i4> interfaceC5005 = this.f17551;
        Throwable thM8759 = c2340.m8759();
        Result.C2137 c2137 = Result.f7828;
        interfaceC5005.resumeWith(Result.m7211(C4817.m14541(thM8759)));
    }

    @Override // defpackage.AbstractC4669
    /* renamed from: ލ */
    public r0 mo8755(C3469.C3471 c3471) {
        if (this.f17551.mo13669(i4.f6762, null) == null) {
            return null;
        }
        return C5006.f16769;
    }
}
