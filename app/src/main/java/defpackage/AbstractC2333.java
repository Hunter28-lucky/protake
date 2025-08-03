package defpackage;

import java.lang.reflect.InvocationTargetException;
import kotlinx.coroutines.CoroutineDispatcher;

/* compiled from: EventLoop.common.kt */
/* renamed from: ĥ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public abstract class AbstractC2333 extends CoroutineDispatcher {

    /* renamed from: ԫ, reason: contains not printable characters */
    public long f8864;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public boolean f8865;

    /* renamed from: ԭ, reason: contains not printable characters */
    public C4951<AbstractC2893<?>> f8866;

    /* renamed from: ށ, reason: contains not printable characters */
    public static /* synthetic */ void m8738(AbstractC2333 abstractC2333, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
        }
        if ((i & 1) != 0) {
            z = false;
        }
        abstractC2333.m8742(z);
    }

    public void shutdown() {
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final void m8739(boolean z) {
        long jM8740 = this.f8864 - m8740(z);
        this.f8864 = jM8740;
        if (jM8740 <= 0 && this.f8865) {
            shutdown();
        }
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final long m8740(boolean z) {
        return z ? 4294967296L : 1L;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final void m8741(AbstractC2893<?> abstractC2893) {
        C4951<AbstractC2893<?>> c4951 = this.f8866;
        if (c4951 == null) {
            c4951 = new C4951<>();
            this.f8866 = c4951;
        }
        c4951.m14720(abstractC2893);
    }

    /* renamed from: ՠ */
    public long mo7441() {
        C4951<AbstractC2893<?>> c4951 = this.f8866;
        return (c4951 == null || c4951.m14722()) ? Long.MAX_VALUE : 0L;
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public final void m8742(boolean z) {
        this.f8864 += m8740(z);
        if (z) {
            return;
        }
        this.f8865 = true;
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public final boolean m8743() {
        return this.f8864 >= m8740(true);
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public final boolean m8744() {
        C4951<AbstractC2893<?>> c4951 = this.f8866;
        if (c4951 == null) {
            return true;
        }
        return c4951.m14722();
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public final boolean m8745() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        AbstractC2893<?> abstractC2893M14723;
        C4951<AbstractC2893<?>> c4951 = this.f8866;
        if (c4951 == null || (abstractC2893M14723 = c4951.m14723()) == null) {
            return false;
        }
        abstractC2893M14723.run();
        return true;
    }
}
