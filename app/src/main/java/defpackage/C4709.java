package defpackage;

import java.util.Iterator;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;

/* compiled from: SequenceBuilder.kt */
/* renamed from: ഞ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C4709 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Sequences.kt */
    /* renamed from: ഞ$Ϳ, reason: contains not printable characters */
    public static final class C4710<T> implements InterfaceC4590<T> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ InterfaceC2849 f15976;

        public C4710(InterfaceC2849 interfaceC2849) {
            this.f15976 = interfaceC2849;
        }

        @Override // defpackage.InterfaceC4590
        public Iterator<T> iterator() {
            return C4709.m14247(this.f15976);
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final <T> Iterator<T> m14247(InterfaceC2849<? super AbstractC4232<? super T>, ? super InterfaceC4355<? super i4>, ? extends Object> interfaceC2849) {
        C3921.m12666(interfaceC2849, "block");
        C5288 c5288 = new C5288();
        c5288.m15329(IntrinsicsKt__IntrinsicsJvmKt.m7254(interfaceC2849, c5288, c5288));
        return c5288;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final <T> InterfaceC4590<T> m14248(InterfaceC2849<? super AbstractC4232<? super T>, ? super InterfaceC4355<? super i4>, ? extends Object> interfaceC2849) {
        C3921.m12666(interfaceC2849, "block");
        return new C4710(interfaceC2849);
    }
}
