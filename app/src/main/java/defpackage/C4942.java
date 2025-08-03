package defpackage;

import java.util.concurrent.locks.ReentrantLock;
import kotlin.NoWhenBranchMatchedException;
import kotlinx.coroutines.channels.AbstractChannel;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.UndeliveredElementException;

/* compiled from: ArrayChannel.kt */
/* renamed from: ຆ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C4942<E> extends AbstractChannel<E> {
    private volatile /* synthetic */ int size;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final int f16656;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final BufferOverflow f16657;

    /* renamed from: ՠ, reason: contains not printable characters */
    public final ReentrantLock f16658;

    /* renamed from: ֈ, reason: contains not printable characters */
    public Object[] f16659;

    /* renamed from: ֏, reason: contains not printable characters */
    public int f16660;

    /* compiled from: ArrayChannel.kt */
    /* renamed from: ຆ$Ϳ, reason: contains not printable characters */
    public /* synthetic */ class C4943 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public static final /* synthetic */ int[] f16661;

        static {
            int[] iArr = new int[BufferOverflow.valuesCustom().length];
            iArr[BufferOverflow.SUSPEND.ordinal()] = 1;
            iArr[BufferOverflow.DROP_LATEST.ordinal()] = 2;
            iArr[BufferOverflow.DROP_OLDEST.ordinal()] = 3;
            f16661 = iArr;
        }
    }

    public C4942(int i, BufferOverflow bufferOverflow, InterfaceC2392<? super E, i4> interfaceC2392) {
        super(interfaceC2392);
        this.f16656 = i;
        this.f16657 = bufferOverflow;
        if (!(i >= 1)) {
            throw new IllegalArgumentException(("ArrayChannel capacity must be at least 1, but " + i + " was specified").toString());
        }
        this.f16658 = new ReentrantLock();
        Object[] objArr = new Object[Math.min(i, 8)];
        C4955.m14733(objArr, C3172.f11246, 0, 0, 6, null);
        i4 i4Var = i4.f6762;
        this.f16659 = objArr;
        this.size = 0;
    }

    @Override // defpackage.AbstractC3778
    /* renamed from: ԫ */
    public Object mo12086(AbstractC4669 abstractC4669) {
        ReentrantLock reentrantLock = this.f16658;
        reentrantLock.lock();
        try {
            return super.mo12086(abstractC4669);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // defpackage.AbstractC3778
    /* renamed from: ԭ */
    public String mo11835() {
        return "(buffer:capacity=" + this.f16656 + ",size=" + this.size + ')';
    }

    @Override // defpackage.AbstractC3778
    /* renamed from: ރ */
    public final boolean mo11836() {
        return false;
    }

    @Override // defpackage.AbstractC3778
    /* renamed from: ބ */
    public final boolean mo11837() {
        return this.size == this.f16656 && this.f16657 == BufferOverflow.SUSPEND;
    }

    @Override // defpackage.AbstractC3778
    /* renamed from: ކ */
    public Object mo11838(E e2) {
        InterfaceC5097<E> interfaceC5097Mo7333;
        ReentrantLock reentrantLock = this.f16658;
        reentrantLock.lock();
        try {
            int i = this.size;
            C2340<?> c2340M12088 = m12088();
            if (c2340M12088 != null) {
                return c2340M12088;
            }
            r0 r0VarM14714 = m14714(i);
            if (r0VarM14714 != null) {
                return r0VarM14714;
            }
            if (i == 0) {
                do {
                    interfaceC5097Mo7333 = mo7333();
                    if (interfaceC5097Mo7333 != null) {
                        if (interfaceC5097Mo7333 instanceof C2340) {
                            this.size = i;
                            return interfaceC5097Mo7333;
                        }
                    }
                } while (interfaceC5097Mo7333.mo7348(e2, null) == null);
                this.size = i;
                i4 i4Var = i4.f6762;
                reentrantLock.unlock();
                interfaceC5097Mo7333.mo7347(e2);
                return interfaceC5097Mo7333.mo8751();
            }
            m14712(i, e2);
            return C3172.f11247;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    /* renamed from: ސ */
    public boolean mo7336(AbstractC3759<? super E> abstractC3759) {
        ReentrantLock reentrantLock = this.f16658;
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
        return this.size == 0;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    /* renamed from: ޓ */
    public boolean mo7339() {
        ReentrantLock reentrantLock = this.f16658;
        reentrantLock.lock();
        try {
            return super.mo7339();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    /* renamed from: ޔ */
    public void mo7340(boolean z) {
        InterfaceC2392<E, i4> interfaceC2392 = this.f13048;
        ReentrantLock reentrantLock = this.f16658;
        reentrantLock.lock();
        try {
            int i = this.size;
            UndeliveredElementException undeliveredElementExceptionM7368 = null;
            for (int i2 = 0; i2 < i; i2++) {
                Object obj = this.f16659[this.f16660];
                if (interfaceC2392 != null && obj != C3172.f11246) {
                    undeliveredElementExceptionM7368 = OnUndeliveredElementKt.m7368(interfaceC2392, obj, undeliveredElementExceptionM7368);
                }
                Object[] objArr = this.f16659;
                int i3 = this.f16660;
                objArr[i3] = C3172.f11246;
                this.f16660 = (i3 + 1) % objArr.length;
            }
            this.size = 0;
            i4 i4Var = i4.f6762;
            reentrantLock.unlock();
            super.mo7340(z);
            if (undeliveredElementExceptionM7368 != null) {
                throw undeliveredElementExceptionM7368;
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    /* renamed from: ޘ */
    public Object mo7344() {
        ReentrantLock reentrantLock = this.f16658;
        reentrantLock.lock();
        try {
            int i = this.size;
            if (i == 0) {
                Object objM12088 = m12088();
                if (objM12088 == null) {
                    objM12088 = C3172.f11249;
                }
                return objM12088;
            }
            Object[] objArr = this.f16659;
            int i2 = this.f16660;
            Object obj = objArr[i2];
            AbstractC4669 abstractC4669 = null;
            objArr[i2] = null;
            this.size = i - 1;
            Object objMo8753 = C3172.f11249;
            boolean z = false;
            if (i == this.f16656) {
                AbstractC4669 abstractC46692 = null;
                while (true) {
                    AbstractC4669 abstractC4669M12098 = m12098();
                    if (abstractC4669M12098 == null) {
                        abstractC4669 = abstractC46692;
                        break;
                    }
                    if (abstractC4669M12098.mo8755(null) != null) {
                        objMo8753 = abstractC4669M12098.mo8753();
                        z = true;
                        abstractC4669 = abstractC4669M12098;
                        break;
                    }
                    abstractC4669M12098.mo9076();
                    abstractC46692 = abstractC4669M12098;
                }
            }
            if (objMo8753 != C3172.f11249 && !(objMo8753 instanceof C2340)) {
                this.size = i;
                Object[] objArr2 = this.f16659;
                objArr2[(this.f16660 + i) % objArr2.length] = objMo8753;
            }
            this.f16660 = (this.f16660 + 1) % this.f16659.length;
            i4 i4Var = i4.f6762;
            if (z) {
                C3921.m12664(abstractC4669);
                abstractC4669.mo8752();
            }
            return obj;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* renamed from: ޛ, reason: contains not printable characters */
    public final void m14712(int i, E e2) {
        if (i < this.f16656) {
            m14713(i);
            Object[] objArr = this.f16659;
            objArr[(this.f16660 + i) % objArr.length] = e2;
        } else {
            Object[] objArr2 = this.f16659;
            int i2 = this.f16660;
            objArr2[i2 % objArr2.length] = null;
            objArr2[(i + i2) % objArr2.length] = e2;
            this.f16660 = (i2 + 1) % objArr2.length;
        }
    }

    /* renamed from: ޜ, reason: contains not printable characters */
    public final void m14713(int i) {
        Object[] objArr = this.f16659;
        if (i >= objArr.length) {
            int iMin = Math.min(objArr.length * 2, this.f16656);
            Object[] objArr2 = new Object[iMin];
            if (i > 0) {
                int i2 = 0;
                while (true) {
                    int i3 = i2 + 1;
                    Object[] objArr3 = this.f16659;
                    objArr2[i2] = objArr3[(this.f16660 + i2) % objArr3.length];
                    if (i3 >= i) {
                        break;
                    } else {
                        i2 = i3;
                    }
                }
            }
            C4955.m14732(objArr2, C3172.f11246, i, iMin);
            this.f16659 = objArr2;
            this.f16660 = 0;
        }
    }

    /* renamed from: ޝ, reason: contains not printable characters */
    public final r0 m14714(int i) {
        if (i < this.f16656) {
            this.size = i + 1;
            return null;
        }
        int i2 = C4943.f16661[this.f16657.ordinal()];
        if (i2 == 1) {
            return C3172.f11248;
        }
        if (i2 == 2) {
            return C3172.f11247;
        }
        if (i2 == 3) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }
}
