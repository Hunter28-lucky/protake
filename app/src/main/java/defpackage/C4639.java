package defpackage;

import defpackage.AbstractC4585;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.subjects.UnicastSubject;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* compiled from: ObservableWindowTimed.java */
/* renamed from: ಭ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4639<T> extends AbstractC3414<T, AbstractC4262<T>> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final long f15771;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final long f15772;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final TimeUnit f15773;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final AbstractC4585 f15774;

    /* renamed from: ՠ, reason: contains not printable characters */
    public final long f15775;

    /* renamed from: ֈ, reason: contains not printable characters */
    public final int f15776;

    /* renamed from: ֏, reason: contains not printable characters */
    public final boolean f15777;

    /* compiled from: ObservableWindowTimed.java */
    /* renamed from: ಭ$Ϳ, reason: contains not printable characters */
    public static final class C4640<T> extends AbstractC4701<T, Object, AbstractC4262<T>> implements InterfaceC4478 {

        /* renamed from: ֈ, reason: contains not printable characters */
        public final long f15778;

        /* renamed from: ֏, reason: contains not printable characters */
        public final TimeUnit f15779;

        /* renamed from: ׯ, reason: contains not printable characters */
        public final AbstractC4585 f15780;

        /* renamed from: ؠ, reason: contains not printable characters */
        public final int f15781;

        /* renamed from: ހ, reason: contains not printable characters */
        public final boolean f15782;

        /* renamed from: ށ, reason: contains not printable characters */
        public final long f15783;

        /* renamed from: ނ, reason: contains not printable characters */
        public final AbstractC4585.AbstractC4588 f15784;

        /* renamed from: ރ, reason: contains not printable characters */
        public long f15785;

        /* renamed from: ބ, reason: contains not printable characters */
        public long f15786;

        /* renamed from: ޅ, reason: contains not printable characters */
        public InterfaceC4478 f15787;

        /* renamed from: ކ, reason: contains not printable characters */
        public UnicastSubject<T> f15788;

        /* renamed from: އ, reason: contains not printable characters */
        public volatile boolean f15789;

        /* renamed from: ވ, reason: contains not printable characters */
        public final SequentialDisposable f15790;

        /* compiled from: ObservableWindowTimed.java */
        /* renamed from: ಭ$Ϳ$Ϳ, reason: contains not printable characters */
        public static final class RunnableC4641 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final long f15791;

            /* renamed from: Ԭ, reason: contains not printable characters */
            public final C4640<?> f15792;

            public RunnableC4641(long j, C4640<?> c4640) {
                this.f15791 = j;
                this.f15792 = c4640;
            }

            @Override // java.lang.Runnable
            public void run() {
                C4640<?> c4640 = this.f15792;
                if (c4640.f15960) {
                    c4640.f15789 = true;
                } else {
                    c4640.f15959.offer(this);
                }
                if (c4640.m14234()) {
                    c4640.m14113();
                }
            }
        }

        public C4640(InterfaceC5102<? super AbstractC4262<T>> interfaceC5102, long j, TimeUnit timeUnit, AbstractC4585 abstractC4585, int i, long j2, boolean z) {
            super(interfaceC5102, new MpscLinkedQueue());
            this.f15790 = new SequentialDisposable();
            this.f15778 = j;
            this.f15779 = timeUnit;
            this.f15780 = abstractC4585;
            this.f15781 = i;
            this.f15783 = j2;
            this.f15782 = z;
            if (z) {
                this.f15784 = abstractC4585.mo6986();
            } else {
                this.f15784 = null;
            }
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f15960 = true;
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f15960;
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            this.f15961 = true;
            if (m14234()) {
                m14113();
            }
            this.f15958.onComplete();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            this.f15962 = th;
            this.f15961 = true;
            if (m14234()) {
                m14113();
            }
            this.f15958.onError(th);
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            if (this.f15789) {
                return;
            }
            if (m14235()) {
                UnicastSubject<T> unicastSubject = this.f15788;
                unicastSubject.onNext(t);
                long j = this.f15785 + 1;
                if (j >= this.f15783) {
                    this.f15786++;
                    this.f15785 = 0L;
                    unicastSubject.onComplete();
                    UnicastSubject<T> unicastSubjectM7041 = UnicastSubject.m7041(this.f15781);
                    this.f15788 = unicastSubjectM7041;
                    this.f15958.onNext(unicastSubjectM7041);
                    if (this.f15782) {
                        this.f15790.get().dispose();
                        AbstractC4585.AbstractC4588 abstractC4588 = this.f15784;
                        RunnableC4641 runnableC4641 = new RunnableC4641(this.f15786, this);
                        long j2 = this.f15778;
                        DisposableHelper.replace(this.f15790, abstractC4588.mo11922(runnableC4641, j2, j2, this.f15779));
                    }
                } else {
                    this.f15785 = j;
                }
                if (mo11502(-1) == 0) {
                    return;
                }
            } else {
                this.f15959.offer(NotificationLite.next(t));
                if (!m14234()) {
                    return;
                }
            }
            m14113();
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            InterfaceC4478 interfaceC4478Mo6989;
            if (DisposableHelper.validate(this.f15787, interfaceC4478)) {
                this.f15787 = interfaceC4478;
                InterfaceC5102<? super V> interfaceC5102 = this.f15958;
                interfaceC5102.onSubscribe(this);
                if (this.f15960) {
                    return;
                }
                UnicastSubject<T> unicastSubjectM7041 = UnicastSubject.m7041(this.f15781);
                this.f15788 = unicastSubjectM7041;
                interfaceC5102.onNext(unicastSubjectM7041);
                RunnableC4641 runnableC4641 = new RunnableC4641(this.f15786, this);
                if (this.f15782) {
                    AbstractC4585.AbstractC4588 abstractC4588 = this.f15784;
                    long j = this.f15778;
                    interfaceC4478Mo6989 = abstractC4588.mo11922(runnableC4641, j, j, this.f15779);
                } else {
                    AbstractC4585 abstractC4585 = this.f15780;
                    long j2 = this.f15778;
                    interfaceC4478Mo6989 = abstractC4585.mo6989(runnableC4641, j2, j2, this.f15779);
                }
                this.f15790.m6311(interfaceC4478Mo6989);
            }
        }

        /* renamed from: ֏, reason: contains not printable characters */
        public void m14112() {
            DisposableHelper.dispose(this.f15790);
            AbstractC4585.AbstractC4588 abstractC4588 = this.f15784;
            if (abstractC4588 != null) {
                abstractC4588.dispose();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [io.reactivex.subjects.UnicastSubject<T>] */
        /* renamed from: ׯ, reason: contains not printable characters */
        public void m14113() {
            MpscLinkedQueue mpscLinkedQueue = (MpscLinkedQueue) this.f15959;
            InterfaceC5102<? super V> interfaceC5102 = this.f15958;
            UnicastSubject<T> unicastSubject = this.f15788;
            int iMo11502 = 1;
            while (!this.f15789) {
                boolean z = this.f15961;
                Object objPoll = mpscLinkedQueue.poll();
                boolean z2 = objPoll == null;
                boolean z3 = objPoll instanceof RunnableC4641;
                if (z && (z2 || z3)) {
                    this.f15788 = null;
                    mpscLinkedQueue.clear();
                    Throwable th = this.f15962;
                    if (th != null) {
                        unicastSubject.onError(th);
                    } else {
                        unicastSubject.onComplete();
                    }
                    m14112();
                    return;
                }
                if (z2) {
                    iMo11502 = mo11502(-iMo11502);
                    if (iMo11502 == 0) {
                        return;
                    }
                } else if (z3) {
                    RunnableC4641 runnableC4641 = (RunnableC4641) objPoll;
                    if (!this.f15782 || this.f15786 == runnableC4641.f15791) {
                        unicastSubject.onComplete();
                        this.f15785 = 0L;
                        unicastSubject = (UnicastSubject<T>) UnicastSubject.m7041(this.f15781);
                        this.f15788 = unicastSubject;
                        interfaceC5102.onNext(unicastSubject);
                    }
                } else {
                    unicastSubject.onNext(NotificationLite.getValue(objPoll));
                    long j = this.f15785 + 1;
                    if (j >= this.f15783) {
                        this.f15786++;
                        this.f15785 = 0L;
                        unicastSubject.onComplete();
                        unicastSubject = (UnicastSubject<T>) UnicastSubject.m7041(this.f15781);
                        this.f15788 = unicastSubject;
                        this.f15958.onNext(unicastSubject);
                        if (this.f15782) {
                            InterfaceC4478 interfaceC4478 = this.f15790.get();
                            interfaceC4478.dispose();
                            AbstractC4585.AbstractC4588 abstractC4588 = this.f15784;
                            RunnableC4641 runnableC46412 = new RunnableC4641(this.f15786, this);
                            long j2 = this.f15778;
                            InterfaceC4478 interfaceC4478Mo11922 = abstractC4588.mo11922(runnableC46412, j2, j2, this.f15779);
                            if (!this.f15790.compareAndSet(interfaceC4478, interfaceC4478Mo11922)) {
                                interfaceC4478Mo11922.dispose();
                            }
                        }
                    } else {
                        this.f15785 = j;
                    }
                }
            }
            this.f15787.dispose();
            mpscLinkedQueue.clear();
            m14112();
        }
    }

    /* compiled from: ObservableWindowTimed.java */
    /* renamed from: ಭ$Ԩ, reason: contains not printable characters */
    public static final class RunnableC4642<T> extends AbstractC4701<T, Object, AbstractC4262<T>> implements InterfaceC4478, Runnable {

        /* renamed from: ބ, reason: contains not printable characters */
        public static final Object f15793 = new Object();

        /* renamed from: ֈ, reason: contains not printable characters */
        public final long f15794;

        /* renamed from: ֏, reason: contains not printable characters */
        public final TimeUnit f15795;

        /* renamed from: ׯ, reason: contains not printable characters */
        public final AbstractC4585 f15796;

        /* renamed from: ؠ, reason: contains not printable characters */
        public final int f15797;

        /* renamed from: ހ, reason: contains not printable characters */
        public InterfaceC4478 f15798;

        /* renamed from: ށ, reason: contains not printable characters */
        public UnicastSubject<T> f15799;

        /* renamed from: ނ, reason: contains not printable characters */
        public final SequentialDisposable f15800;

        /* renamed from: ރ, reason: contains not printable characters */
        public volatile boolean f15801;

        public RunnableC4642(InterfaceC5102<? super AbstractC4262<T>> interfaceC5102, long j, TimeUnit timeUnit, AbstractC4585 abstractC4585, int i) {
            super(interfaceC5102, new MpscLinkedQueue());
            this.f15800 = new SequentialDisposable();
            this.f15794 = j;
            this.f15795 = timeUnit;
            this.f15796 = abstractC4585;
            this.f15797 = i;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f15960 = true;
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f15960;
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            this.f15961 = true;
            if (m14234()) {
                m14114();
            }
            this.f15958.onComplete();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            this.f15962 = th;
            this.f15961 = true;
            if (m14234()) {
                m14114();
            }
            this.f15958.onError(th);
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            if (this.f15801) {
                return;
            }
            if (m14235()) {
                this.f15799.onNext(t);
                if (mo11502(-1) == 0) {
                    return;
                }
            } else {
                this.f15959.offer(NotificationLite.next(t));
                if (!m14234()) {
                    return;
                }
            }
            m14114();
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.f15798, interfaceC4478)) {
                this.f15798 = interfaceC4478;
                this.f15799 = UnicastSubject.m7041(this.f15797);
                InterfaceC5102<? super V> interfaceC5102 = this.f15958;
                interfaceC5102.onSubscribe(this);
                interfaceC5102.onNext(this.f15799);
                if (this.f15960) {
                    return;
                }
                AbstractC4585 abstractC4585 = this.f15796;
                long j = this.f15794;
                this.f15800.m6311(abstractC4585.mo6989(this, j, j, this.f15795));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f15960) {
                this.f15801 = true;
            }
            this.f15959.offer(f15793);
            if (m14234()) {
                m14114();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0023, code lost:
        
            r2.onError(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x0027, code lost:
        
            r2.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x002a, code lost:
        
            r7.f15800.dispose();
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x002f, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x0019, code lost:
        
            r7.f15799 = null;
            r0.clear();
            r0 = r7.f15962;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0021, code lost:
        
            if (r0 == null) goto L11;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [io.reactivex.subjects.UnicastSubject<T>] */
        /* renamed from: ՠ, reason: contains not printable characters */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void m14114() {
            /*
                r7 = this;
                ǅ<U> r0 = r7.f15959
                io.reactivex.internal.queue.MpscLinkedQueue r0 = (io.reactivex.internal.queue.MpscLinkedQueue) r0
                ဏ<? super V> r1 = r7.f15958
                io.reactivex.subjects.UnicastSubject<T> r2 = r7.f15799
                r3 = 1
            L9:
                boolean r4 = r7.f15801
                boolean r5 = r7.f15961
                java.lang.Object r6 = r0.poll()
                if (r5 == 0) goto L30
                if (r6 == 0) goto L19
                java.lang.Object r5 = defpackage.C4639.RunnableC4642.f15793
                if (r6 != r5) goto L30
            L19:
                r1 = 0
                r7.f15799 = r1
                r0.clear()
                java.lang.Throwable r0 = r7.f15962
                if (r0 == 0) goto L27
                r2.onError(r0)
                goto L2a
            L27:
                r2.onComplete()
            L2a:
                io.reactivex.internal.disposables.SequentialDisposable r0 = r7.f15800
                r0.dispose()
                return
            L30:
                if (r6 != 0) goto L3a
                int r3 = -r3
                int r3 = r7.mo11502(r3)
                if (r3 != 0) goto L9
                return
            L3a:
                java.lang.Object r5 = defpackage.C4639.RunnableC4642.f15793
                if (r6 != r5) goto L55
                r2.onComplete()
                if (r4 != 0) goto L4f
                int r2 = r7.f15797
                io.reactivex.subjects.UnicastSubject r2 = io.reactivex.subjects.UnicastSubject.m7041(r2)
                r7.f15799 = r2
                r1.onNext(r2)
                goto L9
            L4f:
                ப r4 = r7.f15798
                r4.dispose()
                goto L9
            L55:
                java.lang.Object r4 = io.reactivex.internal.util.NotificationLite.getValue(r6)
                r2.onNext(r4)
                goto L9
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.C4639.RunnableC4642.m14114():void");
        }
    }

    /* compiled from: ObservableWindowTimed.java */
    /* renamed from: ಭ$Ԫ, reason: contains not printable characters */
    public static final class RunnableC4643<T> extends AbstractC4701<T, Object, AbstractC4262<T>> implements InterfaceC4478, Runnable {

        /* renamed from: ֈ, reason: contains not printable characters */
        public final long f15802;

        /* renamed from: ֏, reason: contains not printable characters */
        public final long f15803;

        /* renamed from: ׯ, reason: contains not printable characters */
        public final TimeUnit f15804;

        /* renamed from: ؠ, reason: contains not printable characters */
        public final AbstractC4585.AbstractC4588 f15805;

        /* renamed from: ހ, reason: contains not printable characters */
        public final int f15806;

        /* renamed from: ށ, reason: contains not printable characters */
        public final List<UnicastSubject<T>> f15807;

        /* renamed from: ނ, reason: contains not printable characters */
        public InterfaceC4478 f15808;

        /* renamed from: ރ, reason: contains not printable characters */
        public volatile boolean f15809;

        /* compiled from: ObservableWindowTimed.java */
        /* renamed from: ಭ$Ԫ$Ϳ, reason: contains not printable characters */
        public final class RunnableC4644 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final UnicastSubject<T> f15810;

            public RunnableC4644(UnicastSubject<T> unicastSubject) {
                this.f15810 = unicastSubject;
            }

            @Override // java.lang.Runnable
            public void run() {
                RunnableC4643.this.m14115(this.f15810);
            }
        }

        /* compiled from: ObservableWindowTimed.java */
        /* renamed from: ಭ$Ԫ$Ԩ, reason: contains not printable characters */
        public static final class C4645<T> {

            /* renamed from: Ϳ, reason: contains not printable characters */
            public final UnicastSubject<T> f15812;

            /* renamed from: Ԩ, reason: contains not printable characters */
            public final boolean f15813;

            public C4645(UnicastSubject<T> unicastSubject, boolean z) {
                this.f15812 = unicastSubject;
                this.f15813 = z;
            }
        }

        public RunnableC4643(InterfaceC5102<? super AbstractC4262<T>> interfaceC5102, long j, long j2, TimeUnit timeUnit, AbstractC4585.AbstractC4588 abstractC4588, int i) {
            super(interfaceC5102, new MpscLinkedQueue());
            this.f15802 = j;
            this.f15803 = j2;
            this.f15804 = timeUnit;
            this.f15805 = abstractC4588;
            this.f15806 = i;
            this.f15807 = new LinkedList();
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f15960 = true;
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f15960;
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            this.f15961 = true;
            if (m14234()) {
                m14116();
            }
            this.f15958.onComplete();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            this.f15962 = th;
            this.f15961 = true;
            if (m14234()) {
                m14116();
            }
            this.f15958.onError(th);
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            if (m14235()) {
                Iterator<UnicastSubject<T>> it = this.f15807.iterator();
                while (it.hasNext()) {
                    it.next().onNext(t);
                }
                if (mo11502(-1) == 0) {
                    return;
                }
            } else {
                this.f15959.offer(t);
                if (!m14234()) {
                    return;
                }
            }
            m14116();
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.f15808, interfaceC4478)) {
                this.f15808 = interfaceC4478;
                this.f15958.onSubscribe(this);
                if (this.f15960) {
                    return;
                }
                UnicastSubject<T> unicastSubjectM7041 = UnicastSubject.m7041(this.f15806);
                this.f15807.add(unicastSubjectM7041);
                this.f15958.onNext(unicastSubjectM7041);
                this.f15805.mo6991(new RunnableC4644(unicastSubjectM7041), this.f15802, this.f15804);
                AbstractC4585.AbstractC4588 abstractC4588 = this.f15805;
                long j = this.f15803;
                abstractC4588.mo11922(this, j, j, this.f15804);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            C4645 c4645 = new C4645(UnicastSubject.m7041(this.f15806), true);
            if (!this.f15960) {
                this.f15959.offer(c4645);
            }
            if (m14234()) {
                m14116();
            }
        }

        /* renamed from: ՠ, reason: contains not printable characters */
        public void m14115(UnicastSubject<T> unicastSubject) {
            this.f15959.offer(new C4645(unicastSubject, false));
            if (m14234()) {
                m14116();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: ֈ, reason: contains not printable characters */
        public void m14116() {
            MpscLinkedQueue mpscLinkedQueue = (MpscLinkedQueue) this.f15959;
            InterfaceC5102<? super V> interfaceC5102 = this.f15958;
            List<UnicastSubject<T>> list = this.f15807;
            int iMo11502 = 1;
            while (!this.f15809) {
                boolean z = this.f15961;
                Object objPoll = mpscLinkedQueue.poll();
                boolean z2 = objPoll == null;
                boolean z3 = objPoll instanceof C4645;
                if (z && (z2 || z3)) {
                    mpscLinkedQueue.clear();
                    Throwable th = this.f15962;
                    if (th != null) {
                        Iterator<UnicastSubject<T>> it = list.iterator();
                        while (it.hasNext()) {
                            it.next().onError(th);
                        }
                    } else {
                        Iterator<UnicastSubject<T>> it2 = list.iterator();
                        while (it2.hasNext()) {
                            it2.next().onComplete();
                        }
                    }
                    list.clear();
                    this.f15805.dispose();
                    return;
                }
                if (z2) {
                    iMo11502 = mo11502(-iMo11502);
                    if (iMo11502 == 0) {
                        return;
                    }
                } else if (z3) {
                    C4645 c4645 = (C4645) objPoll;
                    if (!c4645.f15813) {
                        list.remove(c4645.f15812);
                        c4645.f15812.onComplete();
                        if (list.isEmpty() && this.f15960) {
                            this.f15809 = true;
                        }
                    } else if (!this.f15960) {
                        UnicastSubject<T> unicastSubjectM7041 = UnicastSubject.m7041(this.f15806);
                        list.add(unicastSubjectM7041);
                        interfaceC5102.onNext(unicastSubjectM7041);
                        this.f15805.mo6991(new RunnableC4644(unicastSubjectM7041), this.f15802, this.f15804);
                    }
                } else {
                    Iterator<UnicastSubject<T>> it3 = list.iterator();
                    while (it3.hasNext()) {
                        it3.next().onNext(objPoll);
                    }
                }
            }
            this.f15808.dispose();
            mpscLinkedQueue.clear();
            list.clear();
            this.f15805.dispose();
        }
    }

    public C4639(InterfaceC2856<T> interfaceC2856, long j, long j2, TimeUnit timeUnit, AbstractC4585 abstractC4585, long j3, int i, boolean z) {
        super(interfaceC2856);
        this.f15771 = j;
        this.f15772 = j2;
        this.f15773 = timeUnit;
        this.f15774 = abstractC4585;
        this.f15775 = j3;
        this.f15776 = i;
        this.f15777 = z;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super AbstractC4262<T>> interfaceC5102) {
        C5312 c5312 = new C5312(interfaceC5102);
        long j = this.f15771;
        long j2 = this.f15772;
        if (j != j2) {
            this.f11778.subscribe(new RunnableC4643(c5312, j, j2, this.f15773, this.f15774.mo6986(), this.f15776));
            return;
        }
        long j3 = this.f15775;
        if (j3 == Long.MAX_VALUE) {
            this.f11778.subscribe(new RunnableC4642(c5312, this.f15771, this.f15773, this.f15774, this.f15776));
        } else {
            this.f11778.subscribe(new C4640(c5312, j, this.f15773, this.f15774, this.f15776, j3, this.f15777));
        }
    }
}
