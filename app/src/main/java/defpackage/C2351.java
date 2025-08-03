package defpackage;

/* compiled from: Channel.kt */
/* renamed from: ļ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2351<T> {

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final C2353 f8892 = new C2353(null);

    /* renamed from: ԩ, reason: contains not printable characters */
    public static final C2354 f8893 = new C2354();

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final Object f8894;

    /* compiled from: Channel.kt */
    /* renamed from: ļ$Ϳ, reason: contains not printable characters */
    public static final class C2352 extends C2354 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final Throwable f8895;

        public C2352(Throwable th) {
            this.f8895 = th;
        }

        public boolean equals(Object obj) {
            return (obj instanceof C2352) && C3921.m12662(this.f8895, ((C2352) obj).f8895);
        }

        public int hashCode() {
            Throwable th = this.f8895;
            if (th != null) {
                return th.hashCode();
            }
            return 0;
        }

        @Override // defpackage.C2351.C2354
        public String toString() {
            return "Closed(" + this.f8895 + ')';
        }
    }

    /* compiled from: Channel.kt */
    /* renamed from: ļ$Ԩ, reason: contains not printable characters */
    public static final class C2353 {
        public C2353() {
        }

        public /* synthetic */ C2353(C4184 c4184) {
            this();
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final <E> Object m8808(Throwable th) {
            return C2351.m8800(new C2352(th));
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final <E> Object m8809(E e2) {
            return C2351.m8800(e2);
        }
    }

    /* compiled from: Channel.kt */
    /* renamed from: ļ$Ԫ, reason: contains not printable characters */
    public static class C2354 {
        public String toString() {
            return "Failed";
        }
    }

    public /* synthetic */ C2351(Object obj) {
        this.f8894 = obj;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final /* synthetic */ C2351 m8799(Object obj) {
        return new C2351(obj);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static <T> Object m8800(Object obj) {
        return obj;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static boolean m8801(Object obj, Object obj2) {
        return (obj2 instanceof C2351) && C3921.m12662(obj, ((C2351) obj2).m8807());
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static final Throwable m8802(Object obj) {
        C2352 c2352 = obj instanceof C2352 ? (C2352) obj : null;
        if (c2352 == null) {
            return null;
        }
        return c2352.f8895;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: ԫ, reason: contains not printable characters */
    public static final T m8803(Object obj) throws Throwable {
        Throwable th;
        if (!(obj instanceof C2354)) {
            return obj;
        }
        if (!(obj instanceof C2352) || (th = ((C2352) obj).f8895) == null) {
            throw new IllegalStateException(C3921.m12673("Trying to call 'getOrThrow' on a failed channel result: ", obj).toString());
        }
        throw th;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static int m8804(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static final boolean m8805(Object obj) {
        return obj instanceof C2352;
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static String m8806(Object obj) {
        if (obj instanceof C2352) {
            return obj.toString();
        }
        return "Value(" + obj + ')';
    }

    public boolean equals(Object obj) {
        return m8801(m8807(), obj);
    }

    public int hashCode() {
        return m8804(m8807());
    }

    public String toString() {
        return m8806(m8807());
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final /* synthetic */ Object m8807() {
        return this.f8894;
    }
}
