package defpackage;

import java.util.List;

/* compiled from: ClipBeanManager.java */
/* renamed from: ཛ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C5049 {

    /* renamed from: ԩ, reason: contains not printable characters */
    public static C5049 f16821;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public List<C2628> f16822 = C3184.m10827().m10851();

    /* renamed from: Ԩ, reason: contains not printable characters */
    public boolean f16823;

    /* renamed from: ԫ, reason: contains not printable characters */
    public static C5049 m14852() {
        if (f16821 == null) {
            synchronized (C5049.class) {
                if (f16821 == null) {
                    f16821 = new C5049();
                }
            }
        }
        return f16821;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m14853(C2628 c2628) {
        this.f16822.add(0, c2628);
        C3184.m10827().m10829(c2628);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m14854(C2628 c2628) {
        this.f16822.remove(c2628);
        C3184.m10827().m10841(c2628);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public void m14855(List<C2628> list) {
        this.f16822.removeAll(list);
        C3184.m10827().m10842(list);
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public List<C2628> m14856() {
        return this.f16822;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public String m14857(int i) {
        return i == 540 ? "480P" : i == 720 ? "720P" : i == 1080 ? "1080P" : i == 2160 ? "4K" : "6K";
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public boolean m14858() {
        return this.f16823;
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public void m14859(boolean z) {
        this.f16823 = z;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public void m14860(C2628 c2628) {
        C3184.m10827().m10865(c2628);
    }
}
