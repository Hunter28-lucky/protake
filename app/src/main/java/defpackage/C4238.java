package defpackage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.security.MessageDigest;

/* compiled from: Option.java */
/* renamed from: ਔ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C4238<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final InterfaceC4240<Object> f14566 = new C4239();

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final T f14567;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final InterfaceC4240<T> f14568;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final String f14569;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public volatile byte[] f14570;

    /* compiled from: Option.java */
    /* renamed from: ਔ$Ϳ, reason: contains not printable characters */
    public class C4239 implements InterfaceC4240<Object> {
        @Override // defpackage.C4238.InterfaceC4240
        /* renamed from: Ϳ */
        public void mo8352(@NonNull byte[] bArr, @NonNull Object obj, @NonNull MessageDigest messageDigest) {
        }
    }

    /* compiled from: Option.java */
    /* renamed from: ਔ$Ԩ, reason: contains not printable characters */
    public interface InterfaceC4240<T> {
        /* renamed from: Ϳ */
        void mo8352(@NonNull byte[] bArr, @NonNull T t, @NonNull MessageDigest messageDigest);
    }

    public C4238(@NonNull String str, @Nullable T t, @NonNull InterfaceC4240<T> interfaceC4240) {
        this.f14569 = C4513.m13865(str);
        this.f14567 = t;
        this.f14568 = (InterfaceC4240) C4513.m13867(interfaceC4240);
    }

    @NonNull
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static <T> C4238<T> m13339(@NonNull String str, @Nullable T t, @NonNull InterfaceC4240<T> interfaceC4240) {
        return new C4238<>(str, t, interfaceC4240);
    }

    @NonNull
    /* renamed from: Ԩ, reason: contains not printable characters */
    public static <T> InterfaceC4240<T> m13340() {
        return (InterfaceC4240<T>) f14566;
    }

    @NonNull
    /* renamed from: ԫ, reason: contains not printable characters */
    public static <T> C4238<T> m13341(@NonNull String str) {
        return new C4238<>(str, null, m13340());
    }

    @NonNull
    /* renamed from: Ԭ, reason: contains not printable characters */
    public static <T> C4238<T> m13342(@NonNull String str, @NonNull T t) {
        return new C4238<>(str, t, m13340());
    }

    public boolean equals(Object obj) {
        if (obj instanceof C4238) {
            return this.f14569.equals(((C4238) obj).f14569);
        }
        return false;
    }

    public int hashCode() {
        return this.f14569.hashCode();
    }

    public String toString() {
        return "Option{key='" + this.f14569 + "'}";
    }

    @Nullable
    /* renamed from: ԩ, reason: contains not printable characters */
    public T m13343() {
        return this.f14567;
    }

    @NonNull
    /* renamed from: Ԫ, reason: contains not printable characters */
    public final byte[] m13344() {
        if (this.f14570 == null) {
            this.f14570 = this.f14569.getBytes(InterfaceC3773.f13027);
        }
        return this.f14570;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public void m13345(@NonNull T t, @NonNull MessageDigest messageDigest) {
        this.f14568.mo8352(m13344(), t, messageDigest);
    }
}
