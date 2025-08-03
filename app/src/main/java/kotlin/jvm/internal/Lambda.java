package kotlin.jvm.internal;

import defpackage.C3921;
import defpackage.C4725;
import defpackage.InterfaceC5139;
import java.io.Serializable;

/* compiled from: Lambda.kt */
/* loaded from: classes2.dex */
public abstract class Lambda<R> implements InterfaceC5139<R>, Serializable {
    private final int arity;

    public Lambda(int i) {
        this.arity = i;
    }

    @Override // defpackage.InterfaceC5139
    public int getArity() {
        return this.arity;
    }

    public String toString() {
        String strM14268 = C4725.m14268(this);
        C3921.m12665(strM14268, "renderLambdaToString(this)");
        return strM14268;
    }
}
