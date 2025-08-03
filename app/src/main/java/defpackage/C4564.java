package defpackage;

import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* compiled from: ResourceCacheKey.java */
/* renamed from: హ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C4564 implements InterfaceC3773 {

    /* renamed from: ՠ, reason: contains not printable characters */
    public static final C4658<Class<?>, byte[]> f15602 = new C4658<>(50);

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final InterfaceC4950 f15603;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final InterfaceC3773 f15604;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final InterfaceC3773 f15605;

    /* renamed from: ԫ, reason: contains not printable characters */
    public final int f15606;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final int f15607;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final Class<?> f15608;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final C3475 f15609;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final a3<?> f15610;

    public C4564(InterfaceC4950 interfaceC4950, InterfaceC3773 interfaceC3773, InterfaceC3773 interfaceC37732, int i, int i2, a3<?> a3Var, Class<?> cls, C3475 c3475) {
        this.f15603 = interfaceC4950;
        this.f15604 = interfaceC3773;
        this.f15605 = interfaceC37732;
        this.f15606 = i;
        this.f15607 = i2;
        this.f15610 = a3Var;
        this.f15608 = cls;
        this.f15609 = c3475;
    }

    @Override // defpackage.InterfaceC3773
    public boolean equals(Object obj) {
        if (!(obj instanceof C4564)) {
            return false;
        }
        C4564 c4564 = (C4564) obj;
        return this.f15607 == c4564.f15607 && this.f15606 == c4564.f15606 && j5.m7086(this.f15610, c4564.f15610) && this.f15608.equals(c4564.f15608) && this.f15604.equals(c4564.f15604) && this.f15605.equals(c4564.f15605) && this.f15609.equals(c4564.f15609);
    }

    @Override // defpackage.InterfaceC3773
    public int hashCode() {
        int iHashCode = (((((this.f15604.hashCode() * 31) + this.f15605.hashCode()) * 31) + this.f15606) * 31) + this.f15607;
        a3<?> a3Var = this.f15610;
        if (a3Var != null) {
            iHashCode = (iHashCode * 31) + a3Var.hashCode();
        }
        return (((iHashCode * 31) + this.f15608.hashCode()) * 31) + this.f15609.hashCode();
    }

    public String toString() {
        return "ResourceCacheKey{sourceKey=" + this.f15604 + ", signature=" + this.f15605 + ", width=" + this.f15606 + ", height=" + this.f15607 + ", decodedResourceClass=" + this.f15608 + ", transformation='" + this.f15610 + "', options=" + this.f15609 + '}';
    }

    @Override // defpackage.InterfaceC3773
    /* renamed from: Ԩ */
    public void mo7626(@NonNull MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.f15603.mo9473(8, byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.f15606).putInt(this.f15607).array();
        this.f15605.mo7626(messageDigest);
        this.f15604.mo7626(messageDigest);
        messageDigest.update(bArr);
        a3<?> a3Var = this.f15610;
        if (a3Var != null) {
            a3Var.mo7626(messageDigest);
        }
        this.f15609.mo7626(messageDigest);
        messageDigest.update(m13986());
        this.f15603.put(bArr);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final byte[] m13986() {
        C4658<Class<?>, byte[]> c4658 = f15602;
        byte[] bArrM14137 = c4658.m14137(this.f15608);
        if (bArrM14137 != null) {
            return bArrM14137;
        }
        byte[] bytes = this.f15608.getName().getBytes(InterfaceC3773.f13027);
        c4658.m14139(this.f15608, bytes);
        return bytes;
    }
}
