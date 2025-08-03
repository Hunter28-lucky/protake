package defpackage;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: SingleEquals.java */
/* renamed from: ආ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4772<T> extends AbstractC4838<Boolean> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC3951<? extends T> f16098;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC3951<? extends T> f16099;

    /* compiled from: SingleEquals.java */
    /* renamed from: ආ$Ϳ, reason: contains not printable characters */
    public static class C4773<T> implements InterfaceC4782<T> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final int f16100;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final C2527 f16101;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final Object[] f16102;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final InterfaceC4782<? super Boolean> f16103;

        /* renamed from: ԯ, reason: contains not printable characters */
        public final AtomicInteger f16104;

        public C4773(int i, C2527 c2527, Object[] objArr, InterfaceC4782<? super Boolean> interfaceC4782, AtomicInteger atomicInteger) {
            this.f16100 = i;
            this.f16101 = c2527;
            this.f16102 = objArr;
            this.f16103 = interfaceC4782;
            this.f16104 = atomicInteger;
        }

        @Override // defpackage.InterfaceC4782
        public void onError(Throwable th) {
            int i;
            do {
                i = this.f16104.get();
                if (i >= 2) {
                    C3671.m11803(th);
                    return;
                }
            } while (!this.f16104.compareAndSet(i, 2));
            this.f16101.dispose();
            this.f16103.onError(th);
        }

        @Override // defpackage.InterfaceC4782
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            this.f16101.mo9333(interfaceC4478);
        }

        @Override // defpackage.InterfaceC4782
        public void onSuccess(T t) {
            this.f16102[this.f16100] = t;
            if (this.f16104.incrementAndGet() == 2) {
                InterfaceC4782<? super Boolean> interfaceC4782 = this.f16103;
                Object[] objArr = this.f16102;
                interfaceC4782.onSuccess(Boolean.valueOf(C4246.m13351(objArr[0], objArr[1])));
            }
        }
    }

    public C4772(InterfaceC3951<? extends T> interfaceC3951, InterfaceC3951<? extends T> interfaceC39512) {
        this.f16098 = interfaceC3951;
        this.f16099 = interfaceC39512;
    }

    @Override // defpackage.AbstractC4838
    public void subscribeActual(InterfaceC4782<? super Boolean> interfaceC4782) {
        AtomicInteger atomicInteger = new AtomicInteger();
        Object[] objArr = {null, null};
        C2527 c2527 = new C2527();
        interfaceC4782.onSubscribe(c2527);
        this.f16098.subscribe(new C4773(0, c2527, objArr, interfaceC4782, atomicInteger));
        this.f16099.subscribe(new C4773(1, c2527, objArr, interfaceC4782, atomicInteger));
    }
}
