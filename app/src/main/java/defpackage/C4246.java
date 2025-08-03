package defpackage;

/* compiled from: ObjectHelper.java */
/* renamed from: ਙ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4246 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final InterfaceC5324<Object, Object> f14577 = new C4247();

    /* compiled from: ObjectHelper.java */
    /* renamed from: ਙ$Ϳ, reason: contains not printable characters */
    public static final class C4247 implements InterfaceC5324<Object, Object> {
        @Override // defpackage.InterfaceC5324
        public boolean test(Object obj, Object obj2) {
            return C4246.m13351(obj, obj2);
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static int m13349(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i > i2 ? 1 : 0;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static int m13350(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j > j2 ? 1 : 0;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static boolean m13351(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static <T> InterfaceC5324<T, T> m13352() {
        return (InterfaceC5324<T, T>) f14577;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static <T> T m13353(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static int m13354(int i, String str) {
        if (i > 0) {
            return i;
        }
        throw new IllegalArgumentException(str + " > 0 required but it was " + i);
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static long m13355(long j, String str) {
        if (j > 0) {
            return j;
        }
        throw new IllegalArgumentException(str + " > 0 required but it was " + j);
    }
}
