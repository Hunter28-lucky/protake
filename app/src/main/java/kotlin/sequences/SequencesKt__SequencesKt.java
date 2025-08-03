package kotlin.sequences;

import defpackage.C2821;
import defpackage.C3278;
import defpackage.C3670;
import defpackage.C3672;
import defpackage.C3921;
import defpackage.InterfaceC2392;
import defpackage.InterfaceC4090;
import defpackage.InterfaceC4590;
import java.util.Iterator;

/* compiled from: Sequences.kt */
/* loaded from: classes2.dex */
public class SequencesKt__SequencesKt extends C3670 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Sequences.kt */
    /* renamed from: kotlin.sequences.SequencesKt__SequencesKt$Ϳ, reason: contains not printable characters */
    public static final class C2143<T> implements InterfaceC4590<T> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ Iterator f7849;

        public C2143(Iterator it) {
            this.f7849 = it;
        }

        @Override // defpackage.InterfaceC4590
        public Iterator<T> iterator() {
            return this.f7849;
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static final <T> InterfaceC4590<T> m7260(Iterator<? extends T> it) {
        C3921.m12666(it, "<this>");
        return m7261(new C2143(it));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: Ԫ, reason: contains not printable characters */
    public static final <T> InterfaceC4590<T> m7261(InterfaceC4590<? extends T> interfaceC4590) {
        C3921.m12666(interfaceC4590, "<this>");
        return interfaceC4590 instanceof C3672 ? interfaceC4590 : new C3672(interfaceC4590);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final <T> InterfaceC4590<T> m7262(final T t, InterfaceC2392<? super T, ? extends T> interfaceC2392) {
        C3921.m12666(interfaceC2392, "nextFunction");
        return t == null ? C2821.f10288 : new C3278(new InterfaceC4090<T>() { // from class: kotlin.sequences.SequencesKt__SequencesKt$generateSequence$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // defpackage.InterfaceC4090
            public final T invoke() {
                return t;
            }
        }, interfaceC2392);
    }
}
