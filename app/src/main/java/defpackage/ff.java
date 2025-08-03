package defpackage;

/* loaded from: classes.dex */
public class ff {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public String f6639;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public int f6640;

    /* renamed from: ԩ, reason: contains not printable characters */
    public long f6641 = System.currentTimeMillis() + 86400000;

    public ff(String str, int i) {
        this.f6639 = str;
        this.f6640 = i;
    }

    public String toString() {
        return "ValueData{value='" + this.f6639 + "', code=" + this.f6640 + ", expired=" + this.f6641 + '}';
    }
}
