package kotlin.coroutines.intrinsics;

import defpackage.C3921;
import defpackage.C4817;
import defpackage.C5148;
import defpackage.InterfaceC2849;
import defpackage.InterfaceC4355;
import defpackage.i4;
import defpackage.u3;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.RestrictedContinuationImpl;

/* compiled from: IntrinsicsJvm.kt */
/* loaded from: classes2.dex */
public class IntrinsicsKt__IntrinsicsJvmKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final <R, T> InterfaceC4355<i4> m7254(final InterfaceC2849<? super R, ? super InterfaceC4355<? super T>, ? extends Object> interfaceC2849, final R r, InterfaceC4355<? super T> interfaceC4355) {
        C3921.m12666(interfaceC2849, "<this>");
        C3921.m12666(interfaceC4355, "completion");
        final InterfaceC4355<?> interfaceC4355M15059 = C5148.m15059(interfaceC4355);
        if (interfaceC2849 instanceof BaseContinuationImpl) {
            return ((BaseContinuationImpl) interfaceC2849).create(r, interfaceC4355M15059);
        }
        final CoroutineContext context = interfaceC4355M15059.getContext();
        return context == EmptyCoroutineContext.f7835 ? new RestrictedContinuationImpl(interfaceC4355M15059) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$3
            private int label;

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public Object invokeSuspend(Object obj) throws Throwable {
                int i = this.label;
                if (i == 0) {
                    this.label = 1;
                    C4817.m14542(obj);
                    return ((InterfaceC2849) u3.m8339(interfaceC2849, 2)).invoke(r, this);
                }
                if (i != 1) {
                    throw new IllegalStateException("This coroutine had already completed".toString());
                }
                this.label = 2;
                C4817.m14542(obj);
                return obj;
            }
        } : new ContinuationImpl(interfaceC4355M15059, context) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$4
            private int label;

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public Object invokeSuspend(Object obj) throws Throwable {
                int i = this.label;
                if (i == 0) {
                    this.label = 1;
                    C4817.m14542(obj);
                    return ((InterfaceC2849) u3.m8339(interfaceC2849, 2)).invoke(r, this);
                }
                if (i != 1) {
                    throw new IllegalStateException("This coroutine had already completed".toString());
                }
                this.label = 2;
                C4817.m14542(obj);
                return obj;
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final <T> InterfaceC4355<T> m7255(InterfaceC4355<? super T> interfaceC4355) {
        InterfaceC4355<T> interfaceC43552;
        C3921.m12666(interfaceC4355, "<this>");
        ContinuationImpl continuationImpl = interfaceC4355 instanceof ContinuationImpl ? (ContinuationImpl) interfaceC4355 : null;
        return (continuationImpl == null || (interfaceC43552 = (InterfaceC4355<T>) continuationImpl.intercepted()) == null) ? interfaceC4355 : interfaceC43552;
    }
}
