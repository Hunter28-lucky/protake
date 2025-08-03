package kotlin.jvm.internal;

import defpackage.InterfaceC2623;
import defpackage.InterfaceC3526;
import defpackage.InterfaceC3686;

/* loaded from: classes2.dex */
public class FunctionReferenceImpl extends FunctionReference {
    public FunctionReferenceImpl(int i, InterfaceC3686 interfaceC3686, String str, String str2) {
        super(i, CallableReference.NO_RECEIVER, ((InterfaceC3526) interfaceC3686).mo9911(), str, str2, !(interfaceC3686 instanceof InterfaceC2623) ? 1 : 0);
    }

    public FunctionReferenceImpl(int i, Class cls, String str, String str2, int i2) {
        super(i, CallableReference.NO_RECEIVER, cls, str, str2, i2);
    }

    public FunctionReferenceImpl(int i, Object obj, Class cls, String str, String str2, int i2) {
        super(i, obj, cls, str, str2, i2);
    }
}
