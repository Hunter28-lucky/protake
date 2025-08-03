package kotlin;

import defpackage.C3921;
import defpackage.C4184;
import java.io.Serializable;

/* compiled from: Result.kt */
/* loaded from: classes2.dex */
public final class Result<T> implements Serializable {

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final C2137 f7828 = new C2137(null);
    private final Object value;

    /* compiled from: Result.kt */
    public static final class Failure implements Serializable {
        public final Throwable exception;

        public Failure(Throwable th) {
            C3921.m12666(th, "exception");
            this.exception = th;
        }

        public boolean equals(Object obj) {
            return (obj instanceof Failure) && C3921.m12662(this.exception, ((Failure) obj).exception);
        }

        public int hashCode() {
            return this.exception.hashCode();
        }

        public String toString() {
            return "Failure(" + this.exception + ')';
        }
    }

    /* compiled from: Result.kt */
    /* renamed from: kotlin.Result$Ϳ, reason: contains not printable characters */
    public static final class C2137 {
        public C2137() {
        }

        public /* synthetic */ C2137(C4184 c4184) {
            this();
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static <T> Object m7211(Object obj) {
        return obj;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static boolean m7212(Object obj, Object obj2) {
        return (obj2 instanceof Result) && C3921.m12662(obj, ((Result) obj2).m7218());
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static final Throwable m7213(Object obj) {
        if (obj instanceof Failure) {
            return ((Failure) obj).exception;
        }
        return null;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static int m7214(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final boolean m7215(Object obj) {
        return obj instanceof Failure;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static final boolean m7216(Object obj) {
        return !(obj instanceof Failure);
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static String m7217(Object obj) {
        if (obj instanceof Failure) {
            return ((Failure) obj).toString();
        }
        return "Success(" + obj + ')';
    }

    public boolean equals(Object obj) {
        return m7212(this.value, obj);
    }

    public int hashCode() {
        return m7214(this.value);
    }

    public String toString() {
        return m7217(this.value);
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final /* synthetic */ Object m7218() {
        return this.value;
    }
}
