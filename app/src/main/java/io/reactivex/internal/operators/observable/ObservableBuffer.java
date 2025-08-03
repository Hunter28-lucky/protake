package io.reactivex.internal.operators.observable;

import defpackage.AbstractC3414;
import defpackage.C4089;
import defpackage.C4246;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5102;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public final class ObservableBuffer<T, U extends Collection<? super T>> extends AbstractC3414<T, U> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final int f7299;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final int f7300;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final Callable<U> f7301;

    public static final class BufferSkipObserver<T, U extends Collection<? super T>> extends AtomicBoolean implements InterfaceC5102<T>, InterfaceC4478 {
        private static final long serialVersionUID = -8223395059921494546L;
        public final Callable<U> bufferSupplier;
        public final ArrayDeque<U> buffers = new ArrayDeque<>();
        public final int count;
        public final InterfaceC5102<? super U> downstream;
        public long index;
        public final int skip;
        public InterfaceC4478 upstream;

        public BufferSkipObserver(InterfaceC5102<? super U> interfaceC5102, int i, int i2, Callable<U> callable) {
            this.downstream = interfaceC5102;
            this.count = i;
            this.skip = i2;
            this.bufferSupplier = callable;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.upstream.dispose();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            while (!this.buffers.isEmpty()) {
                this.downstream.onNext(this.buffers.poll());
            }
            this.downstream.onComplete();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            this.buffers.clear();
            this.downstream.onError(th);
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            long j = this.index;
            this.index = 1 + j;
            if (j % this.skip == 0) {
                try {
                    this.buffers.offer((Collection) C4246.m13353(this.bufferSupplier.call(), "The bufferSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources."));
                } catch (Throwable th) {
                    this.buffers.clear();
                    this.upstream.dispose();
                    this.downstream.onError(th);
                    return;
                }
            }
            Iterator<U> it = this.buffers.iterator();
            while (it.hasNext()) {
                U next = it.next();
                next.add(t);
                if (this.count <= next.size()) {
                    it.remove();
                    this.downstream.onNext(next);
                }
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.upstream, interfaceC4478)) {
                this.upstream = interfaceC4478;
                this.downstream.onSubscribe(this);
            }
        }
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableBuffer$Ϳ, reason: contains not printable characters */
    public static final class C2073<T, U extends Collection<? super T>> implements InterfaceC5102<T>, InterfaceC4478 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC5102<? super U> f7302;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final int f7303;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final Callable<U> f7304;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public U f7305;

        /* renamed from: ԯ, reason: contains not printable characters */
        public int f7306;

        /* renamed from: ՠ, reason: contains not printable characters */
        public InterfaceC4478 f7307;

        public C2073(InterfaceC5102<? super U> interfaceC5102, int i, Callable<U> callable) {
            this.f7302 = interfaceC5102;
            this.f7303 = i;
            this.f7304 = callable;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f7307.dispose();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f7307.isDisposed();
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            U u = this.f7305;
            if (u != null) {
                this.f7305 = null;
                if (!u.isEmpty()) {
                    this.f7302.onNext(u);
                }
                this.f7302.onComplete();
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            this.f7305 = null;
            this.f7302.onError(th);
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            U u = this.f7305;
            if (u != null) {
                u.add(t);
                int i = this.f7306 + 1;
                this.f7306 = i;
                if (i >= this.f7303) {
                    this.f7302.onNext(u);
                    this.f7306 = 0;
                    m6733();
                }
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.f7307, interfaceC4478)) {
                this.f7307 = interfaceC4478;
                this.f7302.onSubscribe(this);
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public boolean m6733() {
            try {
                this.f7305 = (U) C4246.m13353(this.f7304.call(), "Empty buffer supplied");
                return true;
            } catch (Throwable th) {
                C4089.m13026(th);
                this.f7305 = null;
                InterfaceC4478 interfaceC4478 = this.f7307;
                if (interfaceC4478 == null) {
                    EmptyDisposable.error(th, this.f7302);
                    return false;
                }
                interfaceC4478.dispose();
                this.f7302.onError(th);
                return false;
            }
        }
    }

    public ObservableBuffer(InterfaceC2856<T> interfaceC2856, int i, int i2, Callable<U> callable) {
        super(interfaceC2856);
        this.f7299 = i;
        this.f7300 = i2;
        this.f7301 = callable;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super U> interfaceC5102) {
        int i = this.f7300;
        int i2 = this.f7299;
        if (i != i2) {
            this.f11778.subscribe(new BufferSkipObserver(interfaceC5102, this.f7299, this.f7300, this.f7301));
            return;
        }
        C2073 c2073 = new C2073(interfaceC5102, i2, this.f7301);
        if (c2073.m6733()) {
            this.f11778.subscribe(c2073);
        }
    }
}
