package defpackage;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.ArrayList;

/* compiled from: CompositeDisposable.java */
/* renamed from: Ȝ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2527 implements InterfaceC4478, InterfaceC2806 {

    /* renamed from: ԫ, reason: contains not printable characters */
    public C4541<InterfaceC4478> f9351;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public volatile boolean f9352;

    @Override // defpackage.InterfaceC4478
    public void dispose() {
        if (this.f9352) {
            return;
        }
        synchronized (this) {
            if (this.f9352) {
                return;
            }
            this.f9352 = true;
            C4541<InterfaceC4478> c4541 = this.f9351;
            this.f9351 = null;
            m9337(c4541);
        }
    }

    @Override // defpackage.InterfaceC4478
    public boolean isDisposed() {
        return this.f9352;
    }

    @Override // defpackage.InterfaceC2806
    /* renamed from: Ϳ, reason: contains not printable characters */
    public boolean mo9333(InterfaceC4478 interfaceC4478) {
        C4246.m13353(interfaceC4478, "disposable is null");
        if (!this.f9352) {
            synchronized (this) {
                if (!this.f9352) {
                    C4541<InterfaceC4478> c4541 = this.f9351;
                    if (c4541 == null) {
                        c4541 = new C4541<>();
                        this.f9351 = c4541;
                    }
                    c4541.m13937(interfaceC4478);
                    return true;
                }
            }
        }
        interfaceC4478.dispose();
        return false;
    }

    @Override // defpackage.InterfaceC2806
    /* renamed from: Ԩ, reason: contains not printable characters */
    public boolean mo9334(InterfaceC4478 interfaceC4478) {
        if (!mo9335(interfaceC4478)) {
            return false;
        }
        interfaceC4478.dispose();
        return true;
    }

    @Override // defpackage.InterfaceC2806
    /* renamed from: ԩ, reason: contains not printable characters */
    public boolean mo9335(InterfaceC4478 interfaceC4478) {
        C4246.m13353(interfaceC4478, "disposables is null");
        if (this.f9352) {
            return false;
        }
        synchronized (this) {
            if (this.f9352) {
                return false;
            }
            C4541<InterfaceC4478> c4541 = this.f9351;
            if (c4541 != null && c4541.m13940(interfaceC4478)) {
                return true;
            }
            return false;
        }
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public void m9336() {
        if (this.f9352) {
            return;
        }
        synchronized (this) {
            if (this.f9352) {
                return;
            }
            C4541<InterfaceC4478> c4541 = this.f9351;
            this.f9351 = null;
            m9337(c4541);
        }
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public void m9337(C4541<InterfaceC4478> c4541) {
        if (c4541 == null) {
            return;
        }
        ArrayList arrayList = null;
        for (Object obj : c4541.m13938()) {
            if (obj instanceof InterfaceC4478) {
                try {
                    ((InterfaceC4478) obj).dispose();
                } catch (Throwable th) {
                    C4089.m13026(th);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th);
                }
            }
        }
        if (arrayList != null) {
            if (arrayList.size() != 1) {
                throw new CompositeException(arrayList);
            }
            throw ExceptionHelper.m7024((Throwable) arrayList.get(0));
        }
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int m9338() {
        if (this.f9352) {
            return 0;
        }
        synchronized (this) {
            if (this.f9352) {
                return 0;
            }
            C4541<InterfaceC4478> c4541 = this.f9351;
            return c4541 != null ? c4541.m13942() : 0;
        }
    }
}
