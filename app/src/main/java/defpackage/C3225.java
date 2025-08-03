package defpackage;

import androidx.annotation.NonNull;
import java.security.MessageDigest;
import java.util.Map;

/* compiled from: EngineKey.java */
/* renamed from: Տ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3225 implements InterfaceC3773 {

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final Object f11367;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final int f11368;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final int f11369;

    /* renamed from: ԫ, reason: contains not printable characters */
    public final Class<?> f11370;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final Class<?> f11371;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final InterfaceC3773 f11372;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final Map<Class<?>, a3<?>> f11373;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final C3475 f11374;

    /* renamed from: ՠ, reason: contains not printable characters */
    public int f11375;

    public C3225(Object obj, InterfaceC3773 interfaceC3773, int i, int i2, Map<Class<?>, a3<?>> map, Class<?> cls, Class<?> cls2, C3475 c3475) {
        this.f11367 = C4513.m13867(obj);
        this.f11372 = (InterfaceC3773) C4513.m13868(interfaceC3773, "Signature must not be null");
        this.f11368 = i;
        this.f11369 = i2;
        this.f11373 = (Map) C4513.m13867(map);
        this.f11370 = (Class) C4513.m13868(cls, "Resource class must not be null");
        this.f11371 = (Class) C4513.m13868(cls2, "Transcode class must not be null");
        this.f11374 = (C3475) C4513.m13867(c3475);
    }

    @Override // defpackage.InterfaceC3773
    public boolean equals(Object obj) {
        if (!(obj instanceof C3225)) {
            return false;
        }
        C3225 c3225 = (C3225) obj;
        return this.f11367.equals(c3225.f11367) && this.f11372.equals(c3225.f11372) && this.f11369 == c3225.f11369 && this.f11368 == c3225.f11368 && this.f11373.equals(c3225.f11373) && this.f11370.equals(c3225.f11370) && this.f11371.equals(c3225.f11371) && this.f11374.equals(c3225.f11374);
    }

    @Override // defpackage.InterfaceC3773
    public int hashCode() {
        if (this.f11375 == 0) {
            int iHashCode = this.f11367.hashCode();
            this.f11375 = iHashCode;
            int iHashCode2 = (((((iHashCode * 31) + this.f11372.hashCode()) * 31) + this.f11368) * 31) + this.f11369;
            this.f11375 = iHashCode2;
            int iHashCode3 = (iHashCode2 * 31) + this.f11373.hashCode();
            this.f11375 = iHashCode3;
            int iHashCode4 = (iHashCode3 * 31) + this.f11370.hashCode();
            this.f11375 = iHashCode4;
            int iHashCode5 = (iHashCode4 * 31) + this.f11371.hashCode();
            this.f11375 = iHashCode5;
            this.f11375 = (iHashCode5 * 31) + this.f11374.hashCode();
        }
        return this.f11375;
    }

    public String toString() {
        return "EngineKey{model=" + this.f11367 + ", width=" + this.f11368 + ", height=" + this.f11369 + ", resourceClass=" + this.f11370 + ", transcodeClass=" + this.f11371 + ", signature=" + this.f11372 + ", hashCode=" + this.f11375 + ", transformations=" + this.f11373 + ", options=" + this.f11374 + '}';
    }

    @Override // defpackage.InterfaceC3773
    /* renamed from: Ԩ */
    public void mo7626(@NonNull MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }
}
