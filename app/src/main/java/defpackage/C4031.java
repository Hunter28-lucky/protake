package defpackage;

/* compiled from: PackageReference.kt */
/* renamed from: ऋ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4031 implements InterfaceC3526 {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final Class<?> f14008;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final String f14009;

    public C4031(Class<?> cls, String str) {
        C3921.m12666(cls, "jClass");
        C3921.m12666(str, "moduleName");
        this.f14008 = cls;
        this.f14009 = str;
    }

    public boolean equals(Object obj) {
        return (obj instanceof C4031) && C3921.m12662(mo9911(), ((C4031) obj).mo9911());
    }

    public int hashCode() {
        return mo9911().hashCode();
    }

    public String toString() {
        return mo9911().toString() + " (Kotlin reflection is not available)";
    }

    @Override // defpackage.InterfaceC3526
    /* renamed from: Ϳ */
    public Class<?> mo9911() {
        return this.f14008;
    }
}
