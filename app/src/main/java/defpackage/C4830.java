package defpackage;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import defpackage.C2380;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: SafeKeyGenerator.java */
/* renamed from: න, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4830 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final C4658<InterfaceC3773, String> f16331 = new C4658<>(1000);

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final Pools.Pool<C4832> f16332 = C2380.m8868(10, new C4831());

    /* compiled from: SafeKeyGenerator.java */
    /* renamed from: න$Ϳ, reason: contains not printable characters */
    public class C4831 implements C2380.InterfaceC2384<C4832> {
        public C4831() {
        }

        @Override // defpackage.C2380.InterfaceC2384
        /* renamed from: Ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public C4832 mo4957() {
            try {
                return new C4832(MessageDigest.getInstance("SHA-256"));
            } catch (NoSuchAlgorithmException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    /* compiled from: SafeKeyGenerator.java */
    /* renamed from: න$Ԩ, reason: contains not printable characters */
    public static final class C4832 implements C2380.InterfaceC2386 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final MessageDigest f16334;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final i f16335 = i.m6228();

        public C4832(MessageDigest messageDigest) {
            this.f16334 = messageDigest;
        }

        @Override // defpackage.C2380.InterfaceC2386
        @NonNull
        /* renamed from: Ԭ */
        public i mo4858() {
            return this.f16335;
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final String m14563(InterfaceC3773 interfaceC3773) {
        C4832 c4832 = (C4832) C4513.m13867(this.f16332.acquire());
        try {
            interfaceC3773.mo7626(c4832.f16334);
            return j5.m7102(c4832.f16334.digest());
        } finally {
            this.f16332.release(c4832);
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public String m14564(InterfaceC3773 interfaceC3773) {
        String strM14137;
        synchronized (this.f16331) {
            strM14137 = this.f16331.m14137(interfaceC3773);
        }
        if (strM14137 == null) {
            strM14137 = m14563(interfaceC3773);
        }
        synchronized (this.f16331) {
            this.f16331.m14139(interfaceC3773, strM14137);
        }
        return strM14137;
    }
}
