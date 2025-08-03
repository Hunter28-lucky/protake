package defpackage;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: AbstractCoroutine.kt */
/* renamed from: Ԫ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public abstract class AbstractC3173<T> extends C2680 implements InterfaceC4355<T>, InterfaceC3539 {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final CoroutineContext f11252;

    public AbstractC3173(CoroutineContext coroutineContext, boolean z, boolean z2) {
        super(z2);
        if (z) {
            m9860((InterfaceC5238) coroutineContext.get(InterfaceC5238.f17362));
        }
        this.f11252 = coroutineContext.plus(this);
    }

    @Override // defpackage.InterfaceC4355
    public final CoroutineContext getContext() {
        return this.f11252;
    }

    @Override // defpackage.InterfaceC3539
    public CoroutineContext getCoroutineContext() {
        return this.f11252;
    }

    @Override // defpackage.InterfaceC4355
    public final void resumeWith(Object obj) {
        Object objM9866 = m9866(C2609.m9544(obj, null, 1, null));
        if (objM9866 == C4479.f15381) {
            return;
        }
        mo6049(objM9866);
    }

    @Override // defpackage.C2680, defpackage.InterfaceC5238
    /* renamed from: Ϳ */
    public boolean mo9831() {
        return super.mo9831();
    }

    @Override // defpackage.C2680
    /* renamed from: ގ */
    public String mo9846() {
        return C3921.m12673(C2316.m8690(this), " was cancelled");
    }

    @Override // defpackage.C2680
    /* renamed from: ޝ */
    public final void mo9859(Throwable th) {
        C4084.m13020(this.f11252, th);
    }

    @Override // defpackage.C2680
    /* renamed from: ޱ */
    public String mo9868() {
        String strM10650 = C3079.m10650(this.f11252);
        if (strM10650 == null) {
            return super.mo9868();
        }
        return '\"' + strM10650 + "\":" + super.mo9868();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.C2680
    /* renamed from: ࡢ */
    public final void mo9873(Object obj) {
        if (!(obj instanceof C2823)) {
            mo10780(obj);
        } else {
            C2823 c2823 = (C2823) obj;
            mo10779(c2823.f10293, c2823.m10167());
        }
    }

    /* renamed from: ࢧ */
    public void mo6049(Object obj) {
        mo9840(obj);
    }

    /* renamed from: ࢨ, reason: contains not printable characters */
    public void mo10779(Throwable th, boolean z) {
    }

    /* renamed from: ࢩ, reason: contains not printable characters */
    public void mo10780(T t) {
    }

    /* renamed from: ࢪ, reason: contains not printable characters */
    public final <R> void m10781(CoroutineStart coroutineStart, R r, InterfaceC2849<? super R, ? super InterfaceC4355<? super T>, ? extends Object> interfaceC2849) {
        coroutineStart.m7326(interfaceC2849, r, this);
    }
}
