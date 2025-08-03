package kotlin.jvm.internal;

import defpackage.C3921;
import defpackage.C4725;
import defpackage.InterfaceC2457;
import defpackage.InterfaceC2537;
import defpackage.InterfaceC5139;

/* loaded from: classes2.dex */
public class FunctionReference extends CallableReference implements InterfaceC5139, InterfaceC2457 {
    private final int arity;
    private final int flags;

    public FunctionReference(int i) {
        this(i, CallableReference.NO_RECEIVER, null, null, null, 0);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public InterfaceC2537 computeReflected() {
        return C4725.m14264(this);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof FunctionReference) {
            FunctionReference functionReference = (FunctionReference) obj;
            return getName().equals(functionReference.getName()) && getSignature().equals(functionReference.getSignature()) && this.flags == functionReference.flags && this.arity == functionReference.arity && C3921.m12662(getBoundReceiver(), functionReference.getBoundReceiver()) && C3921.m12662(getOwner(), functionReference.getOwner());
        }
        if (obj instanceof InterfaceC2457) {
            return obj.equals(compute());
        }
        return false;
    }

    @Override // defpackage.InterfaceC5139
    public int getArity() {
        return this.arity;
    }

    public int hashCode() {
        return (((getOwner() == null ? 0 : getOwner().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    @Override // defpackage.InterfaceC2457
    public boolean isExternal() {
        return getReflected().isExternal();
    }

    @Override // defpackage.InterfaceC2457
    public boolean isInfix() {
        return getReflected().isInfix();
    }

    @Override // defpackage.InterfaceC2457
    public boolean isInline() {
        return getReflected().isInline();
    }

    @Override // defpackage.InterfaceC2457
    public boolean isOperator() {
        return getReflected().isOperator();
    }

    @Override // kotlin.jvm.internal.CallableReference, defpackage.InterfaceC2537
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    public String toString() {
        InterfaceC2537 interfaceC2537Compute = compute();
        if (interfaceC2537Compute != this) {
            return interfaceC2537Compute.toString();
        }
        if ("<init>".equals(getName())) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + getName() + " (Kotlin reflection is not available)";
    }

    public FunctionReference(int i, Object obj) {
        this(i, obj, null, null, null, 0);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public InterfaceC2457 getReflected() {
        return (InterfaceC2457) super.getReflected();
    }

    public FunctionReference(int i, Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, (i2 & 1) == 1);
        this.arity = i;
        this.flags = i2 >> 1;
    }
}
