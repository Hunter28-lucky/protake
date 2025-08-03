package defpackage;

import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* compiled from: DataCacheKey.java */
/* renamed from: Ϩ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C2851 implements InterfaceC3773 {

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final InterfaceC3773 f10335;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final InterfaceC3773 f10336;

    public C2851(InterfaceC3773 interfaceC3773, InterfaceC3773 interfaceC37732) {
        this.f10335 = interfaceC3773;
        this.f10336 = interfaceC37732;
    }

    @Override // defpackage.InterfaceC3773
    public boolean equals(Object obj) {
        if (!(obj instanceof C2851)) {
            return false;
        }
        C2851 c2851 = (C2851) obj;
        return this.f10335.equals(c2851.f10335) && this.f10336.equals(c2851.f10336);
    }

    @Override // defpackage.InterfaceC3773
    public int hashCode() {
        return (this.f10335.hashCode() * 31) + this.f10336.hashCode();
    }

    public String toString() {
        return "DataCacheKey{sourceKey=" + this.f10335 + ", signature=" + this.f10336 + '}';
    }

    @Override // defpackage.InterfaceC3773
    /* renamed from: Ԩ */
    public void mo7626(@NonNull MessageDigest messageDigest) {
        this.f10335.mo7626(messageDigest);
        this.f10336.mo7626(messageDigest);
    }
}
