package defpackage;

import java.util.Iterator;
import java.util.List;

/* compiled from: LensInfoManager.java */
/* renamed from: ࡘ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3952 {

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static C3952 f13651;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public List<C2949> f13652 = C3184.m10827().m10853();

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static C3952 m12801() {
        if (f13651 == null) {
            synchronized (C3952.class) {
                if (f13651 == null) {
                    f13651 = new C3952();
                }
            }
        }
        return f13651;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m12802(C2949 c2949) {
        if (r1.m8144(this.f13652)) {
            Iterator<C2949> it = this.f13652.iterator();
            while (it.hasNext()) {
                if (c2949.m10351().equalsIgnoreCase(it.next().m10351())) {
                    C3184.m10827().m10867(c2949);
                    return;
                }
            }
        }
        this.f13652.add(c2949);
        C3184.m10827().m10831(c2949);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public C2949 m12803(String str) {
        if (!r1.m8144(this.f13652)) {
            return null;
        }
        for (C2949 c2949 : this.f13652) {
            if (str.equalsIgnoreCase(c2949.m10351())) {
                return c2949;
            }
        }
        return null;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public void m12804(C2949 c2949) {
        C3184.m10827().m10867(c2949);
    }
}
