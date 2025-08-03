package defpackage;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.Collection;
import java.util.concurrent.Callable;

/* compiled from: ObservableDistinct.java */
/* renamed from: ங, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4466<T, K> extends AbstractC3414<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super T, K> f15363;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final Callable<? extends Collection<? super K>> f15364;

    /* compiled from: ObservableDistinct.java */
    /* renamed from: ங$Ϳ, reason: contains not printable characters */
    public static final class C4467<T, K> extends AbstractC5178<T, T> {

        /* renamed from: ՠ, reason: contains not printable characters */
        public final Collection<? super K> f15365;

        /* renamed from: ֈ, reason: contains not printable characters */
        public final InterfaceC2368<? super T, K> f15366;

        public C4467(InterfaceC5102<? super T> interfaceC5102, InterfaceC2368<? super T, K> interfaceC2368, Collection<? super K> collection) {
            super(interfaceC5102);
            this.f15366 = interfaceC2368;
            this.f15365 = collection;
        }

        @Override // defpackage.AbstractC5178, defpackage.InterfaceC4851
        public void clear() {
            this.f15365.clear();
            super.clear();
        }

        @Override // defpackage.AbstractC5178, defpackage.InterfaceC5102
        public void onComplete() {
            if (this.f17143) {
                return;
            }
            this.f17143 = true;
            this.f15365.clear();
            this.f17140.onComplete();
        }

        @Override // defpackage.AbstractC5178, defpackage.InterfaceC5102
        public void onError(Throwable th) {
            if (this.f17143) {
                C3671.m11803(th);
                return;
            }
            this.f17143 = true;
            this.f15365.clear();
            this.f17140.onError(th);
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            if (this.f17143) {
                return;
            }
            if (this.f17144 != 0) {
                this.f17140.onNext(null);
                return;
            }
            try {
                if (this.f15365.add(C4246.m13353(this.f15366.apply(t), "The keySelector returned a null key"))) {
                    this.f17140.onNext(t);
                }
            } catch (Throwable th) {
                m15124(th);
            }
        }

        @Override // defpackage.InterfaceC4851
        public T poll() throws Exception {
            T tPoll;
            do {
                tPoll = this.f17142.poll();
                if (tPoll == null) {
                    break;
                }
            } while (!this.f15365.add((Object) C4246.m13353(this.f15366.apply(tPoll), "The keySelector returned a null key")));
            return tPoll;
        }

        @Override // defpackage.InterfaceC3460
        /* renamed from: ԩ */
        public int mo6310(int i) {
            return m15125(i);
        }
    }

    public C4466(InterfaceC2856<T> interfaceC2856, InterfaceC2368<? super T, K> interfaceC2368, Callable<? extends Collection<? super K>> callable) {
        super(interfaceC2856);
        this.f15363 = interfaceC2368;
        this.f15364 = callable;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        try {
            this.f11778.subscribe(new C4467(interfaceC5102, this.f15363, (Collection) C4246.m13353(this.f15364.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th) {
            C4089.m13026(th);
            EmptyDisposable.error(th, interfaceC5102);
        }
    }
}
