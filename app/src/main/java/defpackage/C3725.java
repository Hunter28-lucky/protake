package defpackage;

import defpackage.AbstractC4585;
import io.reactivex.disposables.C1972;
import java.util.concurrent.TimeUnit;

/* compiled from: ImmediateThinScheduler.java */
/* renamed from: ݗ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3725 extends AbstractC4585 {

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final AbstractC4585 f12915 = new C3725();

    /* renamed from: ԩ, reason: contains not printable characters */
    public static final AbstractC4585.AbstractC4588 f12916 = new C3726();

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static final InterfaceC4478 f12917;

    /* compiled from: ImmediateThinScheduler.java */
    /* renamed from: ݗ$Ϳ, reason: contains not printable characters */
    public static final class C3726 extends AbstractC4585.AbstractC4588 {
        @Override // defpackage.InterfaceC4478
        public void dispose() {
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return false;
        }

        @Override // defpackage.AbstractC4585.AbstractC4588
        /* renamed from: Ԩ */
        public InterfaceC4478 mo6990(Runnable runnable) {
            runnable.run();
            return C3725.f12917;
        }

        @Override // defpackage.AbstractC4585.AbstractC4588
        /* renamed from: ԩ */
        public InterfaceC4478 mo6991(Runnable runnable, long j, TimeUnit timeUnit) {
            throw new UnsupportedOperationException("This scheduler doesn't support delayed execution");
        }

        @Override // defpackage.AbstractC4585.AbstractC4588
        /* renamed from: Ԫ, reason: contains not printable characters */
        public InterfaceC4478 mo11922(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            throw new UnsupportedOperationException("This scheduler doesn't support periodic execution");
        }
    }

    static {
        InterfaceC4478 interfaceC4478M6300 = C1972.m6300();
        f12917 = interfaceC4478M6300;
        interfaceC4478M6300.dispose();
    }

    @Override // defpackage.AbstractC4585
    /* renamed from: Ϳ */
    public AbstractC4585.AbstractC4588 mo6986() {
        return f12916;
    }

    @Override // defpackage.AbstractC4585
    /* renamed from: ԩ */
    public InterfaceC4478 mo6987(Runnable runnable) {
        runnable.run();
        return f12917;
    }

    @Override // defpackage.AbstractC4585
    /* renamed from: Ԫ */
    public InterfaceC4478 mo6988(Runnable runnable, long j, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("This scheduler doesn't support delayed execution");
    }

    @Override // defpackage.AbstractC4585
    /* renamed from: ԫ */
    public InterfaceC4478 mo6989(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("This scheduler doesn't support periodic execution");
    }
}
