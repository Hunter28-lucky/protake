package defpackage;

import java.util.concurrent.locks.ReentrantLock;
import kotlinx.coroutines.channels.AbstractChannel;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.UndeliveredElementException;

/* compiled from: ConflatedChannel.kt */
/* renamed from: ܪ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C3692<E> extends AbstractChannel<E> {

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final ReentrantLock f12817;

    /* renamed from: ԯ, reason: contains not printable characters */
    public Object f12818;

    public C3692(InterfaceC2392<? super E, i4> interfaceC2392) {
        super(interfaceC2392);
        this.f12817 = new ReentrantLock();
        this.f12818 = C3172.f11246;
    }

    @Override // defpackage.AbstractC3778
    /* renamed from: ԭ, reason: contains not printable characters */
    public String mo11835() {
        return "(value=" + this.f12818 + ')';
    }

    @Override // defpackage.AbstractC3778
    /* renamed from: ރ, reason: contains not printable characters */
    public final boolean mo11836() {
        return false;
    }

    @Override // defpackage.AbstractC3778
    /* renamed from: ބ, reason: contains not printable characters */
    public final boolean mo11837() {
        return false;
    }

    @Override // defpackage.AbstractC3778
    /* renamed from: ކ, reason: contains not printable characters */
    public Object mo11838(E e2) {
        InterfaceC5097<E> interfaceC5097Mo7333;
        ReentrantLock reentrantLock = this.f12817;
        reentrantLock.lock();
        try {
            C2340<?> c2340M12088 = m12088();
            if (c2340M12088 != null) {
                return c2340M12088;
            }
            if (this.f12818 == C3172.f11246) {
                do {
                    interfaceC5097Mo7333 = mo7333();
                    if (interfaceC5097Mo7333 != null) {
                        if (interfaceC5097Mo7333 instanceof C2340) {
                            return interfaceC5097Mo7333;
                        }
                    }
                } while (interfaceC5097Mo7333.mo7348(e2, null) == null);
                i4 i4Var = i4.f6762;
                reentrantLock.unlock();
                interfaceC5097Mo7333.mo7347(e2);
                return interfaceC5097Mo7333.mo8751();
            }
            UndeliveredElementException undeliveredElementExceptionM11839 = m11839(e2);
            if (undeliveredElementExceptionM11839 == null) {
                return C3172.f11247;
            }
            throw undeliveredElementExceptionM11839;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    /* renamed from: ސ */
    public boolean mo7336(AbstractC3759<? super E> abstractC3759) {
        ReentrantLock reentrantLock = this.f12817;
        reentrantLock.lock();
        try {
            return super.mo7336(abstractC3759);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    /* renamed from: ޑ */
    public final boolean mo7337() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    /* renamed from: ޒ */
    public final boolean mo7338() {
        return this.f12818 == C3172.f11246;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    /* renamed from: ޔ */
    public void mo7340(boolean z) {
        ReentrantLock reentrantLock = this.f12817;
        reentrantLock.lock();
        try {
            UndeliveredElementException undeliveredElementExceptionM11839 = m11839(C3172.f11246);
            i4 i4Var = i4.f6762;
            reentrantLock.unlock();
            super.mo7340(z);
            if (undeliveredElementExceptionM11839 != null) {
                throw undeliveredElementExceptionM11839;
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    /* renamed from: ޘ */
    public Object mo7344() {
        ReentrantLock reentrantLock = this.f12817;
        reentrantLock.lock();
        try {
            Object obj = this.f12818;
            r0 r0Var = C3172.f11246;
            if (obj != r0Var) {
                this.f12818 = r0Var;
                i4 i4Var = i4.f6762;
                return obj;
            }
            Object objM12088 = m12088();
            if (objM12088 == null) {
                objM12088 = C3172.f11249;
            }
            return objM12088;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* renamed from: ޛ, reason: contains not printable characters */
    public final UndeliveredElementException m11839(Object obj) {
        InterfaceC2392<E, i4> interfaceC2392;
        Object obj2 = this.f12818;
        UndeliveredElementException undeliveredElementExceptionM7369 = null;
        if (obj2 != C3172.f11246 && (interfaceC2392 = this.f13048) != null) {
            undeliveredElementExceptionM7369 = OnUndeliveredElementKt.m7369(interfaceC2392, obj2, null, 2, null);
        }
        this.f12818 = obj;
        return undeliveredElementExceptionM7369;
    }
}
