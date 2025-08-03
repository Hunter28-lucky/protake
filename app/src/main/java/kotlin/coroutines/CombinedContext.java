package kotlin.coroutines;

import defpackage.C3921;
import defpackage.C4184;
import defpackage.InterfaceC2849;
import defpackage.i4;
import java.io.Serializable;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Ref$IntRef;

/* compiled from: CoroutineContextImpl.kt */
/* loaded from: classes2.dex */
public final class CombinedContext implements CoroutineContext, Serializable {
    private final CoroutineContext.InterfaceC2140 element;
    private final CoroutineContext left;

    /* compiled from: CoroutineContextImpl.kt */
    public static final class Serialized implements Serializable {
        private static final long serialVersionUID = 0;

        /* renamed from: ԫ, reason: contains not printable characters */
        public static final C2139 f7832 = new C2139(null);
        private final CoroutineContext[] elements;

        /* compiled from: CoroutineContextImpl.kt */
        /* renamed from: kotlin.coroutines.CombinedContext$Serialized$Ϳ, reason: contains not printable characters */
        public static final class C2139 {
            public C2139() {
            }

            public /* synthetic */ C2139(C4184 c4184) {
                this();
            }
        }

        public Serialized(CoroutineContext[] coroutineContextArr) {
            C3921.m12666(coroutineContextArr, "elements");
            this.elements = coroutineContextArr;
        }

        private final Object readResolve() {
            CoroutineContext[] coroutineContextArr = this.elements;
            CoroutineContext coroutineContextPlus = EmptyCoroutineContext.f7835;
            for (CoroutineContext coroutineContext : coroutineContextArr) {
                coroutineContextPlus = coroutineContextPlus.plus(coroutineContext);
            }
            return coroutineContextPlus;
        }
    }

    public CombinedContext(CoroutineContext coroutineContext, CoroutineContext.InterfaceC2140 interfaceC2140) {
        C3921.m12666(coroutineContext, "left");
        C3921.m12666(interfaceC2140, "element");
        this.left = coroutineContext;
        this.element = interfaceC2140;
    }

    private final Object writeReplace() {
        int iM7244 = m7244();
        final CoroutineContext[] coroutineContextArr = new CoroutineContext[iM7244];
        final Ref$IntRef ref$IntRef = new Ref$IntRef();
        fold(i4.f6762, new InterfaceC2849<i4, CoroutineContext.InterfaceC2140, i4>() { // from class: kotlin.coroutines.CombinedContext.writeReplace.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // defpackage.InterfaceC2849
            public /* bridge */ /* synthetic */ i4 invoke(i4 i4Var, CoroutineContext.InterfaceC2140 interfaceC2140) {
                m7246(i4Var, interfaceC2140);
                return i4.f6762;
            }

            /* renamed from: Ϳ, reason: contains not printable characters */
            public final void m7246(i4 i4Var, CoroutineContext.InterfaceC2140 interfaceC2140) {
                C3921.m12666(i4Var, "<anonymous parameter 0>");
                C3921.m12666(interfaceC2140, "element");
                CoroutineContext[] coroutineContextArr2 = coroutineContextArr;
                Ref$IntRef ref$IntRef2 = ref$IntRef;
                int i = ref$IntRef2.element;
                ref$IntRef2.element = i + 1;
                coroutineContextArr2[i] = interfaceC2140;
            }
        });
        if (ref$IntRef.element == iM7244) {
            return new Serialized(coroutineContextArr);
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof CombinedContext) {
                CombinedContext combinedContext = (CombinedContext) obj;
                if (combinedContext.m7244() != m7244() || !combinedContext.m7243(this)) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, InterfaceC2849<? super R, ? super CoroutineContext.InterfaceC2140, ? extends R> interfaceC2849) {
        C3921.m12666(interfaceC2849, "operation");
        return interfaceC2849.invoke((Object) this.left.fold(r, interfaceC2849), this.element);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.InterfaceC2140> E get(CoroutineContext.InterfaceC2142<E> interfaceC2142) {
        C3921.m12666(interfaceC2142, "key");
        CombinedContext combinedContext = this;
        while (true) {
            E e2 = (E) combinedContext.element.get(interfaceC2142);
            if (e2 != null) {
                return e2;
            }
            CoroutineContext coroutineContext = combinedContext.left;
            if (!(coroutineContext instanceof CombinedContext)) {
                return (E) coroutineContext.get(interfaceC2142);
            }
            combinedContext = (CombinedContext) coroutineContext;
        }
    }

    public int hashCode() {
        return this.left.hashCode() + this.element.hashCode();
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.InterfaceC2142<?> interfaceC2142) {
        C3921.m12666(interfaceC2142, "key");
        if (this.element.get(interfaceC2142) != null) {
            return this.left;
        }
        CoroutineContext coroutineContextMinusKey = this.left.minusKey(interfaceC2142);
        return coroutineContextMinusKey == this.left ? this : coroutineContextMinusKey == EmptyCoroutineContext.f7835 ? this.element : new CombinedContext(coroutineContextMinusKey, this.element);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return CoroutineContext.DefaultImpls.m7247(this, coroutineContext);
    }

    public String toString() {
        return '[' + ((String) fold("", new InterfaceC2849<String, CoroutineContext.InterfaceC2140, String>() { // from class: kotlin.coroutines.CombinedContext.toString.1
            @Override // defpackage.InterfaceC2849
            /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
            public final String invoke(String str, CoroutineContext.InterfaceC2140 interfaceC2140) {
                C3921.m12666(str, "acc");
                C3921.m12666(interfaceC2140, "element");
                if (str.length() == 0) {
                    return interfaceC2140.toString();
                }
                return str + ", " + interfaceC2140;
            }
        })) + ']';
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final boolean m7242(CoroutineContext.InterfaceC2140 interfaceC2140) {
        return C3921.m12662(get(interfaceC2140.getKey()), interfaceC2140);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final boolean m7243(CombinedContext combinedContext) {
        while (m7242(combinedContext.element)) {
            CoroutineContext coroutineContext = combinedContext.left;
            if (!(coroutineContext instanceof CombinedContext)) {
                return m7242((CoroutineContext.InterfaceC2140) coroutineContext);
            }
            combinedContext = (CombinedContext) coroutineContext;
        }
        return false;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final int m7244() {
        int i = 2;
        CombinedContext combinedContext = this;
        while (true) {
            CoroutineContext coroutineContext = combinedContext.left;
            combinedContext = coroutineContext instanceof CombinedContext ? (CombinedContext) coroutineContext : null;
            if (combinedContext == null) {
                return i;
            }
            i++;
        }
    }
}
