package defpackage;

import com.blink.academy.filter.core.C1793;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* renamed from: Ÿ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2398 extends C1793 {

    /* renamed from: ށ, reason: contains not printable characters */
    public HashMap<String, C4424> f8968;

    /* renamed from: ނ, reason: contains not printable characters */
    public ArrayList<C4424> f8969;

    /* renamed from: ރ, reason: contains not printable characters */
    public HashMap<C4424, Integer> f8970;

    /* renamed from: ބ, reason: contains not printable characters */
    public HashMap<Integer, C4424> f8971;

    public C2398(String str) {
        super(C1793.m4808(), m8887(str));
        m8889();
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public static String m8887(String str) {
        return C4596.m14056(str);
    }

    @Override // com.blink.academy.filter.core.C1793
    /* renamed from: ׯ */
    public void mo4803() {
        super.mo4803();
        m8888();
    }

    /* renamed from: އ, reason: contains not printable characters */
    public final void m8888() {
        int iM4811;
        ArrayList<C4424> arrayList = this.f8969;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Iterator<C4424> it = this.f8969.iterator();
        while (it.hasNext()) {
            C4424 next = it.next();
            String strM13654 = next.m13654();
            int iM13655 = next.m13655();
            next.m13656();
            if (iM13655 == 1) {
                iM4811 = m4811(strM13654);
            } else if (iM13655 == 2) {
                iM4811 = m4815(strM13654);
            }
            this.f8970.put(next, Integer.valueOf(iM4811));
        }
    }

    /* renamed from: މ, reason: contains not printable characters */
    public final void m8889() {
        this.f8968 = new HashMap<>();
        this.f8969 = new ArrayList<>();
        this.f8970 = new HashMap<>();
        this.f8971 = new HashMap<>();
    }
}
