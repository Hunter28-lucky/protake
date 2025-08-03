package defpackage;

import io.reactivex.exceptions.CompositeException;

/* compiled from: SingleOnErrorReturn.java */
/* renamed from: ဤ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C5135<T> extends AbstractC4838<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC3951<? extends T> f17051;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super Throwable, ? extends T> f17052;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final T f17053;

    /* compiled from: SingleOnErrorReturn.java */
    /* renamed from: ဤ$Ϳ, reason: contains not printable characters */
    public final class C5136 implements InterfaceC4782<T> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC4782<? super T> f17054;

        public C5136(InterfaceC4782<? super T> interfaceC4782) {
            this.f17054 = interfaceC4782;
        }

        @Override // defpackage.InterfaceC4782
        public void onError(Throwable th) {
            T tApply;
            C5135 c5135 = C5135.this;
            InterfaceC2368<? super Throwable, ? extends T> interfaceC2368 = c5135.f17052;
            if (interfaceC2368 != null) {
                try {
                    tApply = interfaceC2368.apply(th);
                } catch (Throwable th2) {
                    C4089.m13026(th2);
                    this.f17054.onError(new CompositeException(th, th2));
                    return;
                }
            } else {
                tApply = c5135.f17053;
            }
            if (tApply != null) {
                this.f17054.onSuccess(tApply);
                return;
            }
            NullPointerException nullPointerException = new NullPointerException("Value supplied was null");
            nullPointerException.initCause(th);
            this.f17054.onError(nullPointerException);
        }

        @Override // defpackage.InterfaceC4782
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            this.f17054.onSubscribe(interfaceC4478);
        }

        @Override // defpackage.InterfaceC4782
        public void onSuccess(T t) {
            this.f17054.onSuccess(t);
        }
    }

    public C5135(InterfaceC3951<? extends T> interfaceC3951, InterfaceC2368<? super Throwable, ? extends T> interfaceC2368, T t) {
        this.f17051 = interfaceC3951;
        this.f17052 = interfaceC2368;
        this.f17053 = t;
    }

    @Override // defpackage.AbstractC4838
    public void subscribeActual(InterfaceC4782<? super T> interfaceC4782) {
        this.f17051.subscribe(new C5136(interfaceC4782));
    }
}
