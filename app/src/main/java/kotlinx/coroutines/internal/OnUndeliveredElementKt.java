package kotlinx.coroutines.internal;

import defpackage.C3921;
import defpackage.C4084;
import defpackage.C4147;
import defpackage.InterfaceC2392;
import defpackage.i4;
import java.lang.reflect.InvocationTargetException;
import kotlin.coroutines.CoroutineContext;

/* compiled from: OnUndeliveredElement.kt */
/* loaded from: classes2.dex */
public final class OnUndeliveredElementKt {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final <E> InterfaceC2392<Throwable, i4> m7366(final InterfaceC2392<? super E, i4> interfaceC2392, final E e2, final CoroutineContext coroutineContext) {
        return new InterfaceC2392<Throwable, i4>() { // from class: kotlinx.coroutines.internal.OnUndeliveredElementKt$bindCancellationFun$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // defpackage.InterfaceC2392
            public /* bridge */ /* synthetic */ i4 invoke(Throwable th) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                invoke2(th);
                return i4.f6762;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                OnUndeliveredElementKt.m7367(interfaceC2392, e2, coroutineContext);
            }
        };
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final <E> void m7367(InterfaceC2392<? super E, i4> interfaceC2392, E e2, CoroutineContext coroutineContext) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        UndeliveredElementException undeliveredElementExceptionM7368 = m7368(interfaceC2392, e2, null);
        if (undeliveredElementExceptionM7368 == null) {
            return;
        }
        C4084.m13020(coroutineContext, undeliveredElementExceptionM7368);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: ԩ, reason: contains not printable characters */
    public static final <E> UndeliveredElementException m7368(InterfaceC2392<? super E, i4> interfaceC2392, E e2, UndeliveredElementException undeliveredElementException) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            interfaceC2392.invoke(e2);
        } catch (Throwable th) {
            if (undeliveredElementException == null || undeliveredElementException.getCause() == th) {
                return new UndeliveredElementException(C3921.m12673("Exception in undelivered element handler for ", e2), th);
            }
            C4147.m13130(undeliveredElementException, th);
        }
        return undeliveredElementException;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static /* synthetic */ UndeliveredElementException m7369(InterfaceC2392 interfaceC2392, Object obj, UndeliveredElementException undeliveredElementException, int i, Object obj2) {
        if ((i & 2) != 0) {
            undeliveredElementException = null;
        }
        return m7368(interfaceC2392, obj, undeliveredElementException);
    }
}
