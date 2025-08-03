package defpackage;

import io.reactivex.internal.disposables.DisposableHelper;

/* compiled from: BasicFuseableObserver.java */
/* renamed from: ၹ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public abstract class AbstractC5178<T, R> implements InterfaceC5102<T>, InterfaceC3164<R> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC5102<? super R> f17140;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public InterfaceC4478 f17141;

    /* renamed from: ԭ, reason: contains not printable characters */
    public InterfaceC3164<T> f17142;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public boolean f17143;

    /* renamed from: ԯ, reason: contains not printable characters */
    public int f17144;

    public AbstractC5178(InterfaceC5102<? super R> interfaceC5102) {
        this.f17140 = interfaceC5102;
    }

    public void clear() {
        this.f17142.clear();
    }

    @Override // defpackage.InterfaceC4478
    public void dispose() {
        this.f17141.dispose();
    }

    @Override // defpackage.InterfaceC4478
    public boolean isDisposed() {
        return this.f17141.isDisposed();
    }

    @Override // defpackage.InterfaceC4851
    public boolean isEmpty() {
        return this.f17142.isEmpty();
    }

    @Override // defpackage.InterfaceC4851
    public final boolean offer(R r) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // defpackage.InterfaceC5102
    public void onComplete() {
        if (this.f17143) {
            return;
        }
        this.f17143 = true;
        this.f17140.onComplete();
    }

    @Override // defpackage.InterfaceC5102
    public void onError(Throwable th) {
        if (this.f17143) {
            C3671.m11803(th);
        } else {
            this.f17143 = true;
            this.f17140.onError(th);
        }
    }

    @Override // defpackage.InterfaceC5102
    public final void onSubscribe(InterfaceC4478 interfaceC4478) {
        if (DisposableHelper.validate(this.f17141, interfaceC4478)) {
            this.f17141 = interfaceC4478;
            if (interfaceC4478 instanceof InterfaceC3164) {
                this.f17142 = (InterfaceC3164) interfaceC4478;
            }
            if (m15123()) {
                this.f17140.onSubscribe(this);
                m15122();
            }
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m15122() {
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public boolean m15123() {
        return true;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final void m15124(Throwable th) {
        C4089.m13026(th);
        this.f17141.dispose();
        onError(th);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final int m15125(int i) {
        InterfaceC3164<T> interfaceC3164 = this.f17142;
        if (interfaceC3164 == null || (i & 4) != 0) {
            return 0;
        }
        int iMo6310 = interfaceC3164.mo6310(i);
        if (iMo6310 != 0) {
            this.f17144 = iMo6310;
        }
        return iMo6310;
    }
}
