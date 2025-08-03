package com.mob.commons.a;

import com.mob.commons.h;
import com.mob.commons.i;
import com.mob.commons.j;
import com.umeng.analytics.pro.am;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class c extends a {
    private static h c;

    public c() {
        super(am.ax, 0L, null, 0L);
        a(0);
        a();
    }

    private static synchronized boolean m() {
        if (c != null) {
            return false;
        }
        c = new h() { // from class: com.mob.commons.a.c.1
            @Override // com.mob.commons.h
            public void a(boolean z, boolean z2, long j) {
                if (z) {
                    d.a().a(0L, c.class, new Object[]{-1, Long.valueOf(System.currentTimeMillis())}, 0);
                }
            }
        };
        i.a().a(c);
        return true;
    }

    @Override // com.mob.commons.a.a
    public void h() {
        if (d()) {
            m();
            return;
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put(j.a("004b^bgAcg"), "PVMT");
        map.put(j.a("008fAbdJbgb*bc2jg"), this.a);
        com.mob.commons.d.a().a(System.currentTimeMillis(), map);
    }
}
