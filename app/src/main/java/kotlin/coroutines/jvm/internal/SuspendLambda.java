package kotlin.coroutines.jvm.internal;

import defpackage.C3921;
import defpackage.C4725;
import defpackage.InterfaceC4355;
import defpackage.InterfaceC5139;

/* compiled from: ContinuationImpl.kt */
/* loaded from: classes2.dex */
public abstract class SuspendLambda extends ContinuationImpl implements InterfaceC5139<Object> {
    private final int arity;

    public SuspendLambda(int i, InterfaceC4355<Object> interfaceC4355) {
        super(interfaceC4355);
        this.arity = i;
    }

    @Override // defpackage.InterfaceC5139
    public int getArity() {
        return this.arity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        String strM14267 = C4725.m14267(this);
        C3921.m12665(strM14267, "renderLambdaToString(this)");
        return strM14267;
    }

    public SuspendLambda(int i) {
        this(i, null);
    }
}
