package kotlin.coroutines;

import com.umeng.analytics.pro.d;
import defpackage.C3921;
import defpackage.InterfaceC2849;
import defpackage.InterfaceC3235;

/* compiled from: CoroutineContext.kt */
/* loaded from: classes2.dex */
public interface CoroutineContext {

    /* compiled from: CoroutineContext.kt */
    public static final class DefaultImpls {
        /* renamed from: Ϳ, reason: contains not printable characters */
        public static CoroutineContext m7247(CoroutineContext coroutineContext, CoroutineContext coroutineContext2) {
            C3921.m12666(coroutineContext2, d.R);
            return coroutineContext2 == EmptyCoroutineContext.f7835 ? coroutineContext : (CoroutineContext) coroutineContext2.fold(coroutineContext, new InterfaceC2849<CoroutineContext, InterfaceC2140, CoroutineContext>() { // from class: kotlin.coroutines.CoroutineContext.plus.1
                @Override // defpackage.InterfaceC2849
                /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
                public final CoroutineContext invoke(CoroutineContext coroutineContext3, InterfaceC2140 interfaceC2140) {
                    CombinedContext combinedContext;
                    C3921.m12666(coroutineContext3, "acc");
                    C3921.m12666(interfaceC2140, "element");
                    CoroutineContext coroutineContextMinusKey = coroutineContext3.minusKey(interfaceC2140.getKey());
                    EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.f7835;
                    if (coroutineContextMinusKey == emptyCoroutineContext) {
                        return interfaceC2140;
                    }
                    InterfaceC3235.C3237 c3237 = InterfaceC3235.f11395;
                    InterfaceC3235 interfaceC3235 = (InterfaceC3235) coroutineContextMinusKey.get(c3237);
                    if (interfaceC3235 == null) {
                        combinedContext = new CombinedContext(coroutineContextMinusKey, interfaceC2140);
                    } else {
                        CoroutineContext coroutineContextMinusKey2 = coroutineContextMinusKey.minusKey(c3237);
                        if (coroutineContextMinusKey2 == emptyCoroutineContext) {
                            return new CombinedContext(interfaceC2140, interfaceC3235);
                        }
                        combinedContext = new CombinedContext(new CombinedContext(coroutineContextMinusKey2, interfaceC2140), interfaceC3235);
                    }
                    return combinedContext;
                }
            });
        }
    }

    /* compiled from: CoroutineContext.kt */
    /* renamed from: kotlin.coroutines.CoroutineContext$Ϳ, reason: contains not printable characters */
    public interface InterfaceC2140 extends CoroutineContext {

        /* compiled from: CoroutineContext.kt */
        /* renamed from: kotlin.coroutines.CoroutineContext$Ϳ$Ϳ, reason: contains not printable characters */
        public static final class C2141 {
            /* renamed from: Ϳ, reason: contains not printable characters */
            public static <R> R m7249(InterfaceC2140 interfaceC2140, R r, InterfaceC2849<? super R, ? super InterfaceC2140, ? extends R> interfaceC2849) {
                C3921.m12666(interfaceC2849, "operation");
                return interfaceC2849.invoke(r, interfaceC2140);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: Ԩ, reason: contains not printable characters */
            public static <E extends InterfaceC2140> E m7250(InterfaceC2140 interfaceC2140, InterfaceC2142<E> interfaceC2142) {
                C3921.m12666(interfaceC2142, "key");
                if (C3921.m12662(interfaceC2140.getKey(), interfaceC2142)) {
                    return interfaceC2140;
                }
                return null;
            }

            /* renamed from: ԩ, reason: contains not printable characters */
            public static CoroutineContext m7251(InterfaceC2140 interfaceC2140, InterfaceC2142<?> interfaceC2142) {
                C3921.m12666(interfaceC2142, "key");
                return C3921.m12662(interfaceC2140.getKey(), interfaceC2142) ? EmptyCoroutineContext.f7835 : interfaceC2140;
            }

            /* renamed from: Ԫ, reason: contains not printable characters */
            public static CoroutineContext m7252(InterfaceC2140 interfaceC2140, CoroutineContext coroutineContext) {
                C3921.m12666(coroutineContext, d.R);
                return DefaultImpls.m7247(interfaceC2140, coroutineContext);
            }
        }

        @Override // kotlin.coroutines.CoroutineContext
        <E extends InterfaceC2140> E get(InterfaceC2142<E> interfaceC2142);

        InterfaceC2142<?> getKey();
    }

    /* compiled from: CoroutineContext.kt */
    /* renamed from: kotlin.coroutines.CoroutineContext$Ԩ, reason: contains not printable characters */
    public interface InterfaceC2142<E extends InterfaceC2140> {
    }

    <R> R fold(R r, InterfaceC2849<? super R, ? super InterfaceC2140, ? extends R> interfaceC2849);

    <E extends InterfaceC2140> E get(InterfaceC2142<E> interfaceC2142);

    CoroutineContext minusKey(InterfaceC2142<?> interfaceC2142);

    CoroutineContext plus(CoroutineContext coroutineContext);
}
