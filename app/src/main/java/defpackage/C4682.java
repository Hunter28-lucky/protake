package defpackage;

/* compiled from: SocketClientParams.kt */
/* renamed from: ഏ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C4682 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final String f15894;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final int f15895;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final String f15896;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final String f15897;

    /* renamed from: ԫ, reason: contains not printable characters */
    public int f15898;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f15899;

    public C4682(String str, int i, String str2, String str3) {
        C3921.m12666(str, "ip");
        C3921.m12666(str2, "passphrase");
        C3921.m12666(str3, "stream_id");
        this.f15894 = str;
        this.f15895 = i;
        this.f15896 = str2;
        this.f15897 = str3;
        this.f15898 = 1;
        this.f15899 = 1;
    }

    public String toString() {
        return "ip:" + this.f15894 + ",port:" + this.f15895 + ",passphrase:" + this.f15896 + ",stream_id:" + this.f15897 + ",peerLatency:" + this.f15898 + ",rcvLatency:" + this.f15899;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final String m14185() {
        return this.f15894;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final String m14186() {
        return this.f15896;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final int m14187() {
        return this.f15898;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final int m14188() {
        return this.f15895;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final int m14189() {
        return this.f15899;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final String m14190() {
        return this.f15897;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final void m14191(int i) {
        this.f15898 = i;
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final void m14192(int i) {
        this.f15899 = i;
    }
}
