package defpackage;

/* compiled from: ZoomManager.java */
/* loaded from: classes.dex */
public class d9 {

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static d9 f6543;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public float f6544 = 1.0f;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static d9 m5921() {
        if (f6543 == null) {
            synchronized (d9.class) {
                if (f6543 == null) {
                    f6543 = new d9();
                }
            }
        }
        return f6543;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public float m5922() {
        return this.f6544;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public d9 m5923(float f) {
        this.f6544 = f;
        return this;
    }
}
