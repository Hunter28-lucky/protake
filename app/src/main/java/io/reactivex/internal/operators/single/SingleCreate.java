package io.reactivex.internal.operators.single;

import defpackage.AbstractC4838;
import defpackage.C3671;
import defpackage.C4089;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC4671;
import defpackage.InterfaceC4782;
import defpackage.InterfaceC4807;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class SingleCreate<T> extends AbstractC4838<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC4807<T> f7573;

    public static final class Emitter<T> extends AtomicReference<InterfaceC4478> implements InterfaceC4671<T>, InterfaceC4478 {
        private static final long serialVersionUID = -2467358622224974244L;
        public final InterfaceC4782<? super T> downstream;

        public Emitter(InterfaceC4782<? super T> interfaceC4782) {
            this.downstream = interfaceC4782;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // defpackage.InterfaceC4671
        public void onSuccess(T t) {
            InterfaceC4478 andSet;
            InterfaceC4478 interfaceC4478 = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (interfaceC4478 == disposableHelper || (andSet = getAndSet(disposableHelper)) == disposableHelper) {
                return;
            }
            try {
                if (t == null) {
                    this.downstream.onError(new NullPointerException("onSuccess called with null. Null values are generally not allowed in 2.x operators and sources."));
                } else {
                    this.downstream.onSuccess(t);
                }
                if (andSet != null) {
                    andSet.dispose();
                }
            } catch (Throwable th) {
                if (andSet != null) {
                    andSet.dispose();
                }
                throw th;
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public String toString() {
            return String.format("%s{%s}", Emitter.class.getSimpleName(), super.toString());
        }

        @Override // defpackage.InterfaceC4671
        /* renamed from: Ϳ, reason: contains not printable characters */
        public boolean mo6948(Throwable th) {
            InterfaceC4478 andSet;
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            InterfaceC4478 interfaceC4478 = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (interfaceC4478 == disposableHelper || (andSet = getAndSet(disposableHelper)) == disposableHelper) {
                return false;
            }
            try {
                this.downstream.onError(th);
            } finally {
                if (andSet != null) {
                    andSet.dispose();
                }
            }
        }

        @Override // defpackage.InterfaceC4671
        /* renamed from: Ԩ, reason: contains not printable characters */
        public void mo6949(InterfaceC4478 interfaceC4478) {
            DisposableHelper.set(this, interfaceC4478);
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public void m6950(Throwable th) {
            if (mo6948(th)) {
                return;
            }
            C3671.m11803(th);
        }
    }

    public SingleCreate(InterfaceC4807<T> interfaceC4807) {
        this.f7573 = interfaceC4807;
    }

    @Override // defpackage.AbstractC4838
    public void subscribeActual(InterfaceC4782<? super T> interfaceC4782) {
        Emitter emitter = new Emitter(interfaceC4782);
        interfaceC4782.onSubscribe(emitter);
        try {
            this.f7573.subscribe(emitter);
        } catch (Throwable th) {
            C4089.m13026(th);
            emitter.m6950(th);
        }
    }
}
