package defpackage;

import defpackage.AbstractC4585;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.queue.MpscLinkedQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableBufferTimed.java */
/* renamed from: ӂ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3091<T, U extends Collection<? super T>> extends AbstractC3414<T, U> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final long f10987;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final long f10988;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final TimeUnit f10989;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final AbstractC4585 f10990;

    /* renamed from: ՠ, reason: contains not printable characters */
    public final Callable<U> f10991;

    /* renamed from: ֈ, reason: contains not printable characters */
    public final int f10992;

    /* renamed from: ֏, reason: contains not printable characters */
    public final boolean f10993;

    /* compiled from: ObservableBufferTimed.java */
    /* renamed from: ӂ$Ϳ, reason: contains not printable characters */
    public static final class RunnableC3092<T, U extends Collection<? super T>> extends AbstractC4701<T, U, U> implements Runnable, InterfaceC4478 {

        /* renamed from: ֈ, reason: contains not printable characters */
        public final Callable<U> f10994;

        /* renamed from: ֏, reason: contains not printable characters */
        public final long f10995;

        /* renamed from: ׯ, reason: contains not printable characters */
        public final TimeUnit f10996;

        /* renamed from: ؠ, reason: contains not printable characters */
        public final int f10997;

        /* renamed from: ހ, reason: contains not printable characters */
        public final boolean f10998;

        /* renamed from: ށ, reason: contains not printable characters */
        public final AbstractC4585.AbstractC4588 f10999;

        /* renamed from: ނ, reason: contains not printable characters */
        public U f11000;

        /* renamed from: ރ, reason: contains not printable characters */
        public InterfaceC4478 f11001;

        /* renamed from: ބ, reason: contains not printable characters */
        public InterfaceC4478 f11002;

        /* renamed from: ޅ, reason: contains not printable characters */
        public long f11003;

        /* renamed from: ކ, reason: contains not printable characters */
        public long f11004;

        public RunnableC3092(InterfaceC5102<? super U> interfaceC5102, Callable<U> callable, long j, TimeUnit timeUnit, int i, boolean z, AbstractC4585.AbstractC4588 abstractC4588) {
            super(interfaceC5102, new MpscLinkedQueue());
            this.f10994 = callable;
            this.f10995 = j;
            this.f10996 = timeUnit;
            this.f10997 = i;
            this.f10998 = z;
            this.f10999 = abstractC4588;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            if (this.f15960) {
                return;
            }
            this.f15960 = true;
            this.f11002.dispose();
            this.f10999.dispose();
            synchronized (this) {
                this.f11000 = null;
            }
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f15960;
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            U u;
            this.f10999.dispose();
            synchronized (this) {
                u = this.f11000;
                this.f11000 = null;
            }
            if (u != null) {
                this.f15959.offer(u);
                this.f15961 = true;
                if (m14234()) {
                    C5263.m15305(this.f15959, this.f15958, false, this, this);
                }
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            synchronized (this) {
                this.f11000 = null;
            }
            this.f15958.onError(th);
            this.f10999.dispose();
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            synchronized (this) {
                U u = this.f11000;
                if (u == null) {
                    return;
                }
                u.add(t);
                if (u.size() < this.f10997) {
                    return;
                }
                this.f11000 = null;
                this.f11003++;
                if (this.f10998) {
                    this.f11001.dispose();
                }
                m14237(u, false, this);
                try {
                    U u2 = (U) C4246.m13353(this.f10994.call(), "The buffer supplied is null");
                    synchronized (this) {
                        this.f11000 = u2;
                        this.f11004++;
                    }
                    if (this.f10998) {
                        AbstractC4585.AbstractC4588 abstractC4588 = this.f10999;
                        long j = this.f10995;
                        this.f11001 = abstractC4588.mo11922(this, j, j, this.f10996);
                    }
                } catch (Throwable th) {
                    C4089.m13026(th);
                    this.f15958.onError(th);
                    dispose();
                }
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.f11002, interfaceC4478)) {
                this.f11002 = interfaceC4478;
                try {
                    this.f11000 = (U) C4246.m13353(this.f10994.call(), "The buffer supplied is null");
                    this.f15958.onSubscribe(this);
                    AbstractC4585.AbstractC4588 abstractC4588 = this.f10999;
                    long j = this.f10995;
                    this.f11001 = abstractC4588.mo11922(this, j, j, this.f10996);
                } catch (Throwable th) {
                    C4089.m13026(th);
                    interfaceC4478.dispose();
                    EmptyDisposable.error(th, this.f15958);
                    this.f10999.dispose();
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                U u = (U) C4246.m13353(this.f10994.call(), "The bufferSupplier returned a null buffer");
                synchronized (this) {
                    U u2 = this.f11000;
                    if (u2 != null && this.f11003 == this.f11004) {
                        this.f11000 = u;
                        m14237(u2, false, this);
                    }
                }
            } catch (Throwable th) {
                C4089.m13026(th);
                dispose();
                this.f15958.onError(th);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // defpackage.AbstractC4701, defpackage.InterfaceC3556
        /* renamed from: ՠ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void mo10684(InterfaceC5102<? super U> interfaceC5102, U u) {
            interfaceC5102.onNext(u);
        }
    }

    /* compiled from: ObservableBufferTimed.java */
    /* renamed from: ӂ$Ԩ, reason: contains not printable characters */
    public static final class RunnableC3093<T, U extends Collection<? super T>> extends AbstractC4701<T, U, U> implements Runnable, InterfaceC4478 {

        /* renamed from: ֈ, reason: contains not printable characters */
        public final Callable<U> f11005;

        /* renamed from: ֏, reason: contains not printable characters */
        public final long f11006;

        /* renamed from: ׯ, reason: contains not printable characters */
        public final TimeUnit f11007;

        /* renamed from: ؠ, reason: contains not printable characters */
        public final AbstractC4585 f11008;

        /* renamed from: ހ, reason: contains not printable characters */
        public InterfaceC4478 f11009;

        /* renamed from: ށ, reason: contains not printable characters */
        public U f11010;

        /* renamed from: ނ, reason: contains not printable characters */
        public final AtomicReference<InterfaceC4478> f11011;

        public RunnableC3093(InterfaceC5102<? super U> interfaceC5102, Callable<U> callable, long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
            super(interfaceC5102, new MpscLinkedQueue());
            this.f11011 = new AtomicReference<>();
            this.f11005 = callable;
            this.f11006 = j;
            this.f11007 = timeUnit;
            this.f11008 = abstractC4585;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            DisposableHelper.dispose(this.f11011);
            this.f11009.dispose();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f11011.get() == DisposableHelper.DISPOSED;
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            U u;
            synchronized (this) {
                u = this.f11010;
                this.f11010 = null;
            }
            if (u != null) {
                this.f15959.offer(u);
                this.f15961 = true;
                if (m14234()) {
                    C5263.m15305(this.f15959, this.f15958, false, null, this);
                }
            }
            DisposableHelper.dispose(this.f11011);
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            synchronized (this) {
                this.f11010 = null;
            }
            this.f15958.onError(th);
            DisposableHelper.dispose(this.f11011);
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            synchronized (this) {
                U u = this.f11010;
                if (u == null) {
                    return;
                }
                u.add(t);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.f11009, interfaceC4478)) {
                this.f11009 = interfaceC4478;
                try {
                    this.f11010 = (U) C4246.m13353(this.f11005.call(), "The buffer supplied is null");
                    this.f15958.onSubscribe(this);
                    if (this.f15960) {
                        return;
                    }
                    AbstractC4585 abstractC4585 = this.f11008;
                    long j = this.f11006;
                    InterfaceC4478 interfaceC4478Mo6989 = abstractC4585.mo6989(this, j, j, this.f11007);
                    if (C4905.m14631(this.f11011, null, interfaceC4478Mo6989)) {
                        return;
                    }
                    interfaceC4478Mo6989.dispose();
                } catch (Throwable th) {
                    C4089.m13026(th);
                    dispose();
                    EmptyDisposable.error(th, this.f15958);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            U u;
            try {
                U u2 = (U) C4246.m13353(this.f11005.call(), "The bufferSupplier returned a null buffer");
                synchronized (this) {
                    u = this.f11010;
                    if (u != null) {
                        this.f11010 = u2;
                    }
                }
                if (u == null) {
                    DisposableHelper.dispose(this.f11011);
                } else {
                    m14236(u, false, this);
                }
            } catch (Throwable th) {
                C4089.m13026(th);
                this.f15958.onError(th);
                dispose();
            }
        }

        @Override // defpackage.AbstractC4701, defpackage.InterfaceC3556
        /* renamed from: ՠ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void mo10684(InterfaceC5102<? super U> interfaceC5102, U u) {
            this.f15958.onNext(u);
        }
    }

    /* compiled from: ObservableBufferTimed.java */
    /* renamed from: ӂ$Ԫ, reason: contains not printable characters */
    public static final class RunnableC3094<T, U extends Collection<? super T>> extends AbstractC4701<T, U, U> implements Runnable, InterfaceC4478 {

        /* renamed from: ֈ, reason: contains not printable characters */
        public final Callable<U> f11012;

        /* renamed from: ֏, reason: contains not printable characters */
        public final long f11013;

        /* renamed from: ׯ, reason: contains not printable characters */
        public final long f11014;

        /* renamed from: ؠ, reason: contains not printable characters */
        public final TimeUnit f11015;

        /* renamed from: ހ, reason: contains not printable characters */
        public final AbstractC4585.AbstractC4588 f11016;

        /* renamed from: ށ, reason: contains not printable characters */
        public final List<U> f11017;

        /* renamed from: ނ, reason: contains not printable characters */
        public InterfaceC4478 f11018;

        /* compiled from: ObservableBufferTimed.java */
        /* renamed from: ӂ$Ԫ$Ϳ, reason: contains not printable characters */
        public final class RunnableC3095 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final U f11019;

            public RunnableC3095(U u) {
                this.f11019 = u;
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (RunnableC3094.this) {
                    RunnableC3094.this.f11017.remove(this.f11019);
                }
                RunnableC3094 runnableC3094 = RunnableC3094.this;
                runnableC3094.m14237(this.f11019, false, runnableC3094.f11016);
            }
        }

        /* compiled from: ObservableBufferTimed.java */
        /* renamed from: ӂ$Ԫ$Ԩ, reason: contains not printable characters */
        public final class RunnableC3096 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final U f11021;

            public RunnableC3096(U u) {
                this.f11021 = u;
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (RunnableC3094.this) {
                    RunnableC3094.this.f11017.remove(this.f11021);
                }
                RunnableC3094 runnableC3094 = RunnableC3094.this;
                runnableC3094.m14237(this.f11021, false, runnableC3094.f11016);
            }
        }

        public RunnableC3094(InterfaceC5102<? super U> interfaceC5102, Callable<U> callable, long j, long j2, TimeUnit timeUnit, AbstractC4585.AbstractC4588 abstractC4588) {
            super(interfaceC5102, new MpscLinkedQueue());
            this.f11012 = callable;
            this.f11013 = j;
            this.f11014 = j2;
            this.f11015 = timeUnit;
            this.f11016 = abstractC4588;
            this.f11017 = new LinkedList();
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            if (this.f15960) {
                return;
            }
            this.f15960 = true;
            m10690();
            this.f11018.dispose();
            this.f11016.dispose();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f15960;
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            ArrayList arrayList;
            synchronized (this) {
                arrayList = new ArrayList(this.f11017);
                this.f11017.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.f15959.offer((Collection) it.next());
            }
            this.f15961 = true;
            if (m14234()) {
                C5263.m15305(this.f15959, this.f15958, false, this.f11016, this);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            this.f15961 = true;
            m10690();
            this.f15958.onError(th);
            this.f11016.dispose();
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            synchronized (this) {
                Iterator<U> it = this.f11017.iterator();
                while (it.hasNext()) {
                    it.next().add(t);
                }
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.f11018, interfaceC4478)) {
                this.f11018 = interfaceC4478;
                try {
                    Collection collection = (Collection) C4246.m13353(this.f11012.call(), "The buffer supplied is null");
                    this.f11017.add(collection);
                    this.f15958.onSubscribe(this);
                    AbstractC4585.AbstractC4588 abstractC4588 = this.f11016;
                    long j = this.f11014;
                    abstractC4588.mo11922(this, j, j, this.f11015);
                    this.f11016.mo6991(new RunnableC3096(collection), this.f11013, this.f11015);
                } catch (Throwable th) {
                    C4089.m13026(th);
                    interfaceC4478.dispose();
                    EmptyDisposable.error(th, this.f15958);
                    this.f11016.dispose();
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f15960) {
                return;
            }
            try {
                Collection collection = (Collection) C4246.m13353(this.f11012.call(), "The bufferSupplier returned a null buffer");
                synchronized (this) {
                    if (this.f15960) {
                        return;
                    }
                    this.f11017.add(collection);
                    this.f11016.mo6991(new RunnableC3095(collection), this.f11013, this.f11015);
                }
            } catch (Throwable th) {
                C4089.m13026(th);
                this.f15958.onError(th);
                dispose();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // defpackage.AbstractC4701, defpackage.InterfaceC3556
        /* renamed from: ՠ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void mo10684(InterfaceC5102<? super U> interfaceC5102, U u) {
            interfaceC5102.onNext(u);
        }

        /* renamed from: ׯ, reason: contains not printable characters */
        public void m10690() {
            synchronized (this) {
                this.f11017.clear();
            }
        }
    }

    public C3091(InterfaceC2856<T> interfaceC2856, long j, long j2, TimeUnit timeUnit, AbstractC4585 abstractC4585, Callable<U> callable, int i, boolean z) {
        super(interfaceC2856);
        this.f10987 = j;
        this.f10988 = j2;
        this.f10989 = timeUnit;
        this.f10990 = abstractC4585;
        this.f10991 = callable;
        this.f10992 = i;
        this.f10993 = z;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super U> interfaceC5102) {
        if (this.f10987 == this.f10988 && this.f10992 == Integer.MAX_VALUE) {
            this.f11778.subscribe(new RunnableC3093(new C5312(interfaceC5102), this.f10991, this.f10987, this.f10989, this.f10990));
            return;
        }
        AbstractC4585.AbstractC4588 abstractC4588Mo6986 = this.f10990.mo6986();
        if (this.f10987 == this.f10988) {
            this.f11778.subscribe(new RunnableC3092(new C5312(interfaceC5102), this.f10991, this.f10987, this.f10989, this.f10992, this.f10993, abstractC4588Mo6986));
        } else {
            this.f11778.subscribe(new RunnableC3094(new C5312(interfaceC5102), this.f10991, this.f10987, this.f10988, this.f10989, abstractC4588Mo6986));
        }
    }
}
