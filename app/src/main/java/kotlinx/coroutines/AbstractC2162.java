package kotlinx.coroutines;

import defpackage.AbstractC3077;
import defpackage.C3538;
import defpackage.C3727;
import defpackage.C3777;
import defpackage.C3782;
import defpackage.C3921;
import defpackage.C4542;
import defpackage.InterfaceC2645;
import defpackage.e2;
import defpackage.f2;
import defpackage.g2;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.CoroutineContext;

/* compiled from: EventLoop.common.kt */
/* renamed from: kotlinx.coroutines.Ԫ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public abstract class AbstractC2162 extends AbstractC3077 {

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f7928 = AtomicReferenceFieldUpdater.newUpdater(AbstractC2162.class, Object.class, "_queue");

    /* renamed from: ԯ, reason: contains not printable characters */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f7929 = AtomicReferenceFieldUpdater.newUpdater(AbstractC2162.class, Object.class, "_delayed");
    private volatile /* synthetic */ Object _queue = null;
    private volatile /* synthetic */ Object _delayed = null;
    private volatile /* synthetic */ int _isCompleted = 0;

    /* compiled from: EventLoop.common.kt */
    /* renamed from: kotlinx.coroutines.Ԫ$Ϳ, reason: contains not printable characters */
    public static abstract class AbstractRunnableC2163 implements Runnable, Comparable<AbstractRunnableC2163>, InterfaceC2645, g2 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public long f7930;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public Object f7931;

        /* renamed from: ԭ, reason: contains not printable characters */
        public int f7932;

        @Override // defpackage.InterfaceC2645
        public final synchronized void dispose() {
            Object obj = this.f7931;
            if (obj == C3538.f12337) {
                return;
            }
            C2164 c2164 = obj instanceof C2164 ? (C2164) obj : null;
            if (c2164 != null) {
                c2164.m6042(this);
            }
            this.f7931 = C3538.f12337;
        }

        @Override // defpackage.g2
        public int getIndex() {
            return this.f7932;
        }

        @Override // defpackage.g2
        public void setIndex(int i) {
            this.f7932 = i;
        }

        public String toString() {
            return "Delayed[nanos=" + this.f7930 + ']';
        }

        @Override // defpackage.g2
        /* renamed from: Ϳ */
        public f2<?> mo6073() {
            Object obj = this.f7931;
            if (obj instanceof f2) {
                return (f2) obj;
            }
            return null;
        }

        @Override // defpackage.g2
        /* renamed from: Ԩ */
        public void mo6074(f2<?> f2Var) {
            if (!(this.f7931 != C3538.f12337)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            this.f7931 = f2Var;
        }

        @Override // java.lang.Comparable
        /* renamed from: ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public int compareTo(AbstractRunnableC2163 abstractRunnableC2163) {
            long j = this.f7930 - abstractRunnableC2163.f7930;
            if (j > 0) {
                return 1;
            }
            return j < 0 ? -1 : 0;
        }

        /* renamed from: ԫ, reason: contains not printable characters */
        public final synchronized int m7455(long j, C2164 c2164, AbstractC2162 abstractC2162) {
            if (this.f7931 == C3538.f12337) {
                return 2;
            }
            synchronized (c2164) {
                AbstractRunnableC2163 abstractRunnableC2163M6037 = c2164.m6037();
                if (abstractC2162.m7440()) {
                    return 1;
                }
                if (abstractRunnableC2163M6037 == null) {
                    c2164.f7933 = j;
                } else {
                    long j2 = abstractRunnableC2163M6037.f7930;
                    if (j2 - j < 0) {
                        j = j2;
                    }
                    if (j - c2164.f7933 > 0) {
                        c2164.f7933 = j;
                    }
                }
                long j3 = this.f7930;
                long j4 = c2164.f7933;
                if (j3 - j4 < 0) {
                    this.f7930 = j4;
                }
                c2164.m6036(this);
                return 0;
            }
        }

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final boolean m7456(long j) {
            return j - this.f7930 >= 0;
        }
    }

    /* compiled from: EventLoop.common.kt */
    /* renamed from: kotlinx.coroutines.Ԫ$Ԩ, reason: contains not printable characters */
    public static final class C2164 extends f2<AbstractRunnableC2163> {

        /* renamed from: Ԩ, reason: contains not printable characters */
        public long f7933;

        public C2164(long j) {
            this.f7933 = j;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    /* renamed from: ގ, reason: contains not printable characters */
    public final boolean m7440() {
        return this._isCompleted;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        m7444(runnable);
    }

    @Override // defpackage.AbstractC2333
    public void shutdown() {
        e2.f6600.m5986();
        m7452(true);
        m7442();
        while (m7447() <= 0) {
        }
        m7448();
    }

    @Override // defpackage.AbstractC2333
    /* renamed from: ՠ, reason: contains not printable characters */
    public long mo7441() {
        if (super.mo7441() == 0) {
            return 0L;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (!(obj instanceof C3727)) {
                return obj == C3538.f12338 ? Long.MAX_VALUE : 0L;
            }
            if (!((C3727) obj).m11929()) {
                return 0L;
            }
        }
        C2164 c2164 = (C2164) this._delayed;
        AbstractRunnableC2163 abstractRunnableC2163M6040 = c2164 == null ? null : c2164.m6040();
        if (abstractRunnableC2163M6040 == null) {
            return Long.MAX_VALUE;
        }
        long j = abstractRunnableC2163M6040.f7930;
        C3782.m12100();
        return C4542.m13944(j - System.nanoTime(), 0L);
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public final void m7442() {
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                if (C3777.m12082(f7928, this, null, C3538.f12338)) {
                    return;
                }
            } else if (obj instanceof C3727) {
                ((C3727) obj).m11926();
                return;
            } else {
                if (obj == C3538.f12338) {
                    return;
                }
                C3727 c3727 = new C3727(8, true);
                c3727.m11923((Runnable) obj);
                if (C3777.m12082(f7928, this, obj, c3727)) {
                    return;
                }
            }
        }
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public final Runnable m7443() {
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                return null;
            }
            if (obj instanceof C3727) {
                C3727 c3727 = (C3727) obj;
                Object objM11932 = c3727.m11932();
                if (objM11932 != C3727.f12921) {
                    return (Runnable) objM11932;
                }
                C3777.m12082(f7928, this, obj, c3727.m11931());
            } else {
                if (obj == C3538.f12338) {
                    return null;
                }
                if (C3777.m12082(f7928, this, obj, null)) {
                    return (Runnable) obj;
                }
            }
        }
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public final void m7444(Runnable runnable) {
        if (m7445(runnable)) {
            m10646();
        } else {
            RunnableC2161.f7926.m7444(runnable);
        }
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public final boolean m7445(Runnable runnable) {
        while (true) {
            Object obj = this._queue;
            if (m7440()) {
                return false;
            }
            if (obj == null) {
                if (C3777.m12082(f7928, this, null, runnable)) {
                    return true;
                }
            } else if (obj instanceof C3727) {
                C3727 c3727 = (C3727) obj;
                int iM11923 = c3727.m11923(runnable);
                if (iM11923 == 0) {
                    return true;
                }
                if (iM11923 == 1) {
                    C3777.m12082(f7928, this, obj, c3727.m11931());
                } else if (iM11923 == 2) {
                    return false;
                }
            } else {
                if (obj == C3538.f12338) {
                    return false;
                }
                C3727 c37272 = new C3727(8, true);
                c37272.m11923((Runnable) obj);
                c37272.m11923(runnable);
                if (C3777.m12082(f7928, this, obj, c37272)) {
                    return true;
                }
            }
        }
    }

    /* renamed from: ޏ, reason: contains not printable characters */
    public boolean m7446() {
        if (!m8744()) {
            return false;
        }
        C2164 c2164 = (C2164) this._delayed;
        if (c2164 != null && !c2164.m6039()) {
            return false;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (obj instanceof C3727) {
                return ((C3727) obj).m11929();
            }
            if (obj != C3538.f12338) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: ސ, reason: contains not printable characters */
    public long m7447() {
        AbstractRunnableC2163 abstractRunnableC2163M6043;
        if (m8745()) {
            return 0L;
        }
        C2164 c2164 = (C2164) this._delayed;
        if (c2164 != null && !c2164.m6039()) {
            C3782.m12100();
            long jNanoTime = System.nanoTime();
            do {
                synchronized (c2164) {
                    AbstractRunnableC2163 abstractRunnableC2163M6037 = c2164.m6037();
                    if (abstractRunnableC2163M6037 != null) {
                        AbstractRunnableC2163 abstractRunnableC2163 = abstractRunnableC2163M6037;
                        abstractRunnableC2163M6043 = abstractRunnableC2163.m7456(jNanoTime) ? m7445(abstractRunnableC2163) : false ? c2164.m6043(0) : null;
                    }
                }
            } while (abstractRunnableC2163M6043 != null);
        }
        Runnable runnableM7443 = m7443();
        if (runnableM7443 == null) {
            return mo7441();
        }
        runnableM7443.run();
        return 0L;
    }

    /* renamed from: ޑ, reason: contains not printable characters */
    public final void m7448() {
        C3782.m12100();
        long jNanoTime = System.nanoTime();
        while (true) {
            C2164 c2164 = (C2164) this._delayed;
            AbstractRunnableC2163 abstractRunnableC2163M6044 = c2164 == null ? null : c2164.m6044();
            if (abstractRunnableC2163M6044 == null) {
                return;
            } else {
                m10645(jNanoTime, abstractRunnableC2163M6044);
            }
        }
    }

    /* renamed from: ޒ, reason: contains not printable characters */
    public final void m7449() {
        this._queue = null;
        this._delayed = null;
    }

    /* renamed from: ޓ, reason: contains not printable characters */
    public final void m7450(long j, AbstractRunnableC2163 abstractRunnableC2163) {
        int iM7451 = m7451(j, abstractRunnableC2163);
        if (iM7451 == 0) {
            if (m7453(abstractRunnableC2163)) {
                m10646();
            }
        } else if (iM7451 == 1) {
            m10645(j, abstractRunnableC2163);
        } else if (iM7451 != 2) {
            throw new IllegalStateException("unexpected result".toString());
        }
    }

    /* renamed from: ޔ, reason: contains not printable characters */
    public final int m7451(long j, AbstractRunnableC2163 abstractRunnableC2163) {
        if (m7440()) {
            return 1;
        }
        C2164 c2164 = (C2164) this._delayed;
        if (c2164 == null) {
            C3777.m12082(f7929, this, null, new C2164(j));
            c2164 = (C2164) this._delayed;
            C3921.m12664(c2164);
        }
        return abstractRunnableC2163.m7455(j, c2164, this);
    }

    /* renamed from: ޕ, reason: contains not printable characters */
    public final void m7452(boolean z) {
        this._isCompleted = z ? 1 : 0;
    }

    /* renamed from: ޖ, reason: contains not printable characters */
    public final boolean m7453(AbstractRunnableC2163 abstractRunnableC2163) {
        C2164 c2164 = (C2164) this._delayed;
        return (c2164 == null ? null : c2164.m6040()) == abstractRunnableC2163;
    }
}
