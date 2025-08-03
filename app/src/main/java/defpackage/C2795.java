package defpackage;

import defpackage.InterfaceC3238;
import java.io.File;

/* compiled from: DiskLruCacheFactory.java */
/* renamed from: Ρ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2795 implements InterfaceC3238.InterfaceC3239 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final long f10203;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final InterfaceC2796 f10204;

    /* compiled from: DiskLruCacheFactory.java */
    /* renamed from: Ρ$Ϳ, reason: contains not printable characters */
    public interface InterfaceC2796 {
        /* renamed from: Ϳ, reason: contains not printable characters */
        File mo10107();
    }

    public C2795(InterfaceC2796 interfaceC2796, long j) {
        this.f10203 = j;
        this.f10204 = interfaceC2796;
    }

    @Override // defpackage.InterfaceC3238.InterfaceC3239
    public InterfaceC3238 build() {
        File fileMo10107 = this.f10204.mo10107();
        if (fileMo10107 == null) {
            return null;
        }
        if (fileMo10107.mkdirs() || (fileMo10107.exists() && fileMo10107.isDirectory())) {
            return C2869.m10206(fileMo10107, this.f10203);
        }
        return null;
    }
}
