package defpackage;

/* compiled from: Channel.kt */
/* renamed from: ȡ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public interface InterfaceC2529<E> {

    /* compiled from: Channel.kt */
    /* renamed from: ȡ$Ϳ, reason: contains not printable characters */
    public static final class C2530 {
        /* renamed from: Ϳ, reason: contains not printable characters */
        public static /* synthetic */ boolean m9344(InterfaceC2529 interfaceC2529, Throwable th, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: close");
            }
            if ((i & 1) != 0) {
                th = null;
            }
            return interfaceC2529.mo9342(th);
        }
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    Object mo9341(E e2, InterfaceC4355<? super i4> interfaceC4355);

    /* renamed from: ՠ, reason: contains not printable characters */
    boolean mo9342(Throwable th);

    /* renamed from: ށ, reason: contains not printable characters */
    boolean mo9343();
}
