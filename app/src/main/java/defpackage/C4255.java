package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: LockFreeTaskQueue.kt */
/* renamed from: ਠ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C4255<E> {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f14608 = AtomicReferenceFieldUpdater.newUpdater(C4255.class, Object.class, "_cur");
    private volatile /* synthetic */ Object _cur;

    public C4255(boolean z) {
        this._cur = new C3727(8, z);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final boolean m13368(E e2) {
        while (true) {
            C3727 c3727 = (C3727) this._cur;
            int iM11923 = c3727.m11923(e2);
            if (iM11923 == 0) {
                return true;
            }
            if (iM11923 == 1) {
                C3777.m12082(f14608, this, c3727, c3727.m11931());
            } else if (iM11923 == 2) {
                return false;
            }
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final void m13369() {
        while (true) {
            C3727 c3727 = (C3727) this._cur;
            if (c3727.m11926()) {
                return;
            } else {
                C3777.m12082(f14608, this, c3727, c3727.m11931());
            }
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final int m13370() {
        return ((C3727) this._cur).m11928();
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final E m13371() {
        while (true) {
            C3727 c3727 = (C3727) this._cur;
            E e2 = (E) c3727.m11932();
            if (e2 != C3727.f12921) {
                return e2;
            }
            C3777.m12082(f14608, this, c3727, c3727.m11931());
        }
    }
}
