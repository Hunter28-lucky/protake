package defpackage;

/* compiled from: ComposerNode.java */
/* renamed from: ฯ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4919 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public int f16599;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public String f16600;

    /* renamed from: ԩ, reason: contains not printable characters */
    public String f16601;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public float f16602;

    public C4919(int i) {
        this(i, null, null, 0.0f);
    }

    public boolean equals(Object obj) {
        return (obj instanceof C4919) && ((C4919) obj).f16599 == this.f16599;
    }

    public int hashCode() {
        return this.f16599;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public String m14643() {
        return this.f16601;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public String m14644() {
        return this.f16600;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public float m14645() {
        return this.f16602;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public void m14646(float f) {
        this.f16602 = f;
    }

    public C4919(int i, String str, String str2) {
        this(i, str, str2, 0.0f);
    }

    public C4919(int i, String str, String str2, float f) {
        this.f16599 = i;
        this.f16600 = str;
        this.f16601 = str2;
        this.f16602 = f;
    }
}
