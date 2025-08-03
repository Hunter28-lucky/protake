package kotlin.jvm.internal;

import defpackage.C4725;
import defpackage.InterfaceC2537;
import defpackage.InterfaceC3179;
import defpackage.InterfaceC3686;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.reflect.KVisibility;

/* loaded from: classes2.dex */
public abstract class CallableReference implements InterfaceC2537, Serializable {
    public static final Object NO_RECEIVER = NoReceiver.f7840;
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    public final Object receiver;
    private transient InterfaceC2537 reflected;
    private final String signature;

    public static class NoReceiver implements Serializable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public static final NoReceiver f7840 = new NoReceiver();

        private NoReceiver() {
        }

        private Object readResolve() throws ObjectStreamException {
            return f7840;
        }
    }

    public CallableReference() {
        this(NO_RECEIVER);
    }

    @Override // defpackage.InterfaceC2537
    public Object call(Object... objArr) {
        return getReflected().call(objArr);
    }

    @Override // defpackage.InterfaceC2537
    public Object callBy(Map map) {
        return getReflected().callBy(map);
    }

    public InterfaceC2537 compute() {
        InterfaceC2537 interfaceC2537 = this.reflected;
        if (interfaceC2537 != null) {
            return interfaceC2537;
        }
        InterfaceC2537 interfaceC2537ComputeReflected = computeReflected();
        this.reflected = interfaceC2537ComputeReflected;
        return interfaceC2537ComputeReflected;
    }

    public abstract InterfaceC2537 computeReflected();

    @Override // defpackage.InterfaceC5017
    public List<Annotation> getAnnotations() {
        return getReflected().getAnnotations();
    }

    public Object getBoundReceiver() {
        return this.receiver;
    }

    public String getName() {
        return this.name;
    }

    public InterfaceC3686 getOwner() {
        Class cls = this.owner;
        if (cls == null) {
            return null;
        }
        return this.isTopLevel ? C4725.m14266(cls) : C4725.m14265(cls);
    }

    @Override // defpackage.InterfaceC2537
    public List<Object> getParameters() {
        return getReflected().getParameters();
    }

    public InterfaceC2537 getReflected() {
        InterfaceC2537 interfaceC2537Compute = compute();
        if (interfaceC2537Compute != this) {
            return interfaceC2537Compute;
        }
        throw new KotlinReflectionNotSupportedError();
    }

    @Override // defpackage.InterfaceC2537
    public InterfaceC3179 getReturnType() {
        return getReflected().getReturnType();
    }

    public String getSignature() {
        return this.signature;
    }

    @Override // defpackage.InterfaceC2537
    public List<Object> getTypeParameters() {
        return getReflected().getTypeParameters();
    }

    @Override // defpackage.InterfaceC2537
    public KVisibility getVisibility() {
        return getReflected().getVisibility();
    }

    @Override // defpackage.InterfaceC2537
    public boolean isAbstract() {
        return getReflected().isAbstract();
    }

    @Override // defpackage.InterfaceC2537
    public boolean isFinal() {
        return getReflected().isFinal();
    }

    @Override // defpackage.InterfaceC2537
    public boolean isOpen() {
        return getReflected().isOpen();
    }

    @Override // defpackage.InterfaceC2537
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    public CallableReference(Object obj) {
        this(obj, null, null, null, false);
    }

    public CallableReference(Object obj, Class cls, String str, String str2, boolean z) {
        this.receiver = obj;
        this.owner = cls;
        this.name = str;
        this.signature = str2;
        this.isTopLevel = z;
    }
}
