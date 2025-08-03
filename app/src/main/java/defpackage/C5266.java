package defpackage;

import defpackage.AbstractC3778;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import kotlinx.coroutines.channels.AbstractChannel;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.UndeliveredElementException;

/* compiled from: LinkedListChannel.kt */
/* renamed from: კ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C5266<E> extends AbstractChannel<E> {
    public C5266(InterfaceC2392<? super E, i4> interfaceC2392) {
        super(interfaceC2392);
    }

    @Override // defpackage.AbstractC3778
    /* renamed from: ރ */
    public final boolean mo11836() {
        return false;
    }

    @Override // defpackage.AbstractC3778
    /* renamed from: ބ */
    public final boolean mo11837() {
        return false;
    }

    @Override // defpackage.AbstractC3778
    /* renamed from: ކ */
    public Object mo11838(E e2) {
        InterfaceC5097<?> interfaceC5097M12096;
        do {
            Object objMo11838 = super.mo11838(e2);
            r0 r0Var = C3172.f11247;
            if (objMo11838 == r0Var) {
                return r0Var;
            }
            if (objMo11838 != C3172.f11248) {
                if (objMo11838 instanceof C2340) {
                    return objMo11838;
                }
                throw new IllegalStateException(C3921.m12673("Invalid offerInternal result ", objMo11838).toString());
            }
            interfaceC5097M12096 = m12096(e2);
            if (interfaceC5097M12096 == null) {
                return r0Var;
            }
        } while (!(interfaceC5097M12096 instanceof C2340));
        return interfaceC5097M12096;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    /* renamed from: ޑ */
    public final boolean mo7337() {
        return true;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    /* renamed from: ޒ */
    public final boolean mo7338() {
        return true;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    /* renamed from: ޕ */
    public void mo7341(Object obj, C2340<?> c2340) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        UndeliveredElementException undeliveredElementExceptionM7368 = null;
        if (obj != null) {
            if (obj instanceof ArrayList) {
                ArrayList arrayList = (ArrayList) obj;
                int size = arrayList.size() - 1;
                if (size >= 0) {
                    UndeliveredElementException undeliveredElementExceptionM73682 = null;
                    while (true) {
                        int i = size - 1;
                        AbstractC4669 abstractC4669 = (AbstractC4669) arrayList.get(size);
                        if (abstractC4669 instanceof AbstractC3778.C3779) {
                            InterfaceC2392<E, i4> interfaceC2392 = this.f13048;
                            undeliveredElementExceptionM73682 = interfaceC2392 == null ? null : OnUndeliveredElementKt.m7368(interfaceC2392, ((AbstractC3778.C3779) abstractC4669).f13050, undeliveredElementExceptionM73682);
                        } else {
                            abstractC4669.mo8754(c2340);
                        }
                        if (i < 0) {
                            break;
                        } else {
                            size = i;
                        }
                    }
                    undeliveredElementExceptionM7368 = undeliveredElementExceptionM73682;
                }
            } else {
                AbstractC4669 abstractC46692 = (AbstractC4669) obj;
                if (abstractC46692 instanceof AbstractC3778.C3779) {
                    InterfaceC2392<E, i4> interfaceC23922 = this.f13048;
                    if (interfaceC23922 != null) {
                        undeliveredElementExceptionM7368 = OnUndeliveredElementKt.m7368(interfaceC23922, ((AbstractC3778.C3779) abstractC46692).f13050, null);
                    }
                } else {
                    abstractC46692.mo8754(c2340);
                }
            }
        }
        if (undeliveredElementExceptionM7368 != null) {
            throw undeliveredElementExceptionM7368;
        }
    }
}
