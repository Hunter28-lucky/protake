package io.reactivex.internal.operators.observable;

import defpackage.AbstractC4262;
import defpackage.InterfaceC5102;
import io.reactivex.internal.observers.BasicIntQueueDisposable;

/* loaded from: classes2.dex */
public final class ObservableRange extends AbstractC4262<Integer> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final int f7422;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final long f7423;

    public static final class RangeDisposable extends BasicIntQueueDisposable<Integer> {
        private static final long serialVersionUID = 396518478098735504L;
        public final InterfaceC5102<? super Integer> downstream;
        public final long end;
        public boolean fused;
        public long index;

        public RangeDisposable(InterfaceC5102<? super Integer> interfaceC5102, long j, long j2) {
            this.downstream = interfaceC5102;
            this.index = j;
            this.end = j2;
        }

        @Override // defpackage.InterfaceC4851
        public void clear() {
            this.index = this.end;
            lazySet(1);
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            set(1);
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return get() != 0;
        }

        @Override // defpackage.InterfaceC4851
        public boolean isEmpty() {
            return this.index == this.end;
        }

        public void run() {
            if (this.fused) {
                return;
            }
            InterfaceC5102<? super Integer> interfaceC5102 = this.downstream;
            long j = this.end;
            for (long j2 = this.index; j2 != j && get() == 0; j2++) {
                interfaceC5102.onNext(Integer.valueOf((int) j2));
            }
            if (get() == 0) {
                lazySet(1);
                interfaceC5102.onComplete();
            }
        }

        @Override // defpackage.InterfaceC4851
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public Integer poll() throws Exception {
            long j = this.index;
            if (j != this.end) {
                this.index = 1 + j;
                return Integer.valueOf((int) j);
            }
            lazySet(1);
            return null;
        }

        @Override // defpackage.InterfaceC3460
        /* renamed from: ԩ */
        public int mo6310(int i) {
            if ((i & 1) == 0) {
                return 0;
            }
            this.fused = true;
            return 1;
        }
    }

    public ObservableRange(int i, int i2) {
        this.f7422 = i;
        this.f7423 = i + i2;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super Integer> interfaceC5102) {
        RangeDisposable rangeDisposable = new RangeDisposable(interfaceC5102, this.f7422, this.f7423);
        interfaceC5102.onSubscribe(rangeDisposable);
        rangeDisposable.run();
    }
}
