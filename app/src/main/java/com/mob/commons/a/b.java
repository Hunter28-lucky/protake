package com.mob.commons.a;

import com.mob.MobSDK;
import com.mob.commons.h;
import com.mob.commons.i;
import com.mob.tools.MobLog;
import com.mob.tools.utils.SharePrefrenceHelper;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class b extends a {
    private static h c;
    private static final String d = i.a("014Efl6k'fkfffhfi)f3fgJlkAffgfgehh");

    /* renamed from: e, reason: collision with root package name */
    private SharePrefrenceHelper f17667e;

    public b() {
        super(i.a("002<hefg"), 0L, i.a("005RhefghhfhEg"), 30L);
        a();
        SharePrefrenceHelper sharePrefrenceHelper = new SharePrefrenceHelper(MobSDK.getContext());
        this.f17667e = sharePrefrenceHelper;
        sharePrefrenceHelper.open(i.a("008f2ge;g,ff-f%fgInk"));
    }

    private void a(long j, long j2) {
        try {
            SharePrefrenceHelper sharePrefrenceHelper = this.f17667e;
            String str = d;
            HashMap map = (HashMap) sharePrefrenceHelper.get(str);
            if (map == null) {
                map = new HashMap();
            }
            map.put(Long.valueOf(j), Long.valueOf(j2));
            this.f17667e.put(str, map);
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
        }
    }

    private void b(long j) {
        if (i.a().b()) {
            return;
        }
        d.a().a(k(), b.class, new Object[]{-1, new Long[]{3L, Long.valueOf(j)}}, 0);
    }

    private void m() {
        try {
            HashMap map = (HashMap) this.f17667e.get(d);
            if (map == null || map.isEmpty()) {
                return;
            }
            for (Map.Entry entry : map.entrySet()) {
                long jLongValue = ((Long) entry.getKey()).longValue();
                long jLongValue2 = ((Long) entry.getValue()).longValue();
                HashMap<String, Object> map2 = new HashMap<>();
                map2.put(i.a("005'fefm5f(fggf"), Long.valueOf(jLongValue2));
                map2.put(i.a("008-fjfefm8f5fg>nk'hi"), Long.valueOf(jLongValue2 - jLongValue));
                a("BKIOMT", map2);
            }
            this.f17667e.remove(d);
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
        }
    }

    private static synchronized boolean n() {
        if (c != null) {
            return false;
        }
        c = new h() { // from class: com.mob.commons.a.b.1
            private volatile long a = 0;

            @Override // com.mob.commons.h
            public void a(boolean z, boolean z2, long j) {
                if (z2) {
                    this.a = System.currentTimeMillis();
                    d.a().a(0L, b.class, new Object[]{-1, new Long[]{0L, Long.valueOf(this.a), Long.valueOf(System.currentTimeMillis())}}, 1);
                }
                if (!z) {
                    if (j > 0) {
                        d.a().a(0L, b.class, new Object[]{-1, new Long[]{2L, Long.valueOf(this.a), Long.valueOf(System.currentTimeMillis())}}, 1);
                    }
                } else {
                    if (z2) {
                        return;
                    }
                    this.a = System.currentTimeMillis();
                    d.a().a(0L, b.class, new Object[]{-1, new Long[]{1L, Long.valueOf(this.a), Long.valueOf(System.currentTimeMillis())}}, 0);
                }
            }
        };
        i.a().a(c);
        return true;
    }

    @Override // com.mob.commons.a.a
    public void h() {
        if (d()) {
            n();
            return;
        }
        Long[] lArr = (Long[]) this.a;
        long jLongValue = lArr[0].longValue();
        long jLongValue2 = lArr[1].longValue();
        long jLongValue3 = (jLongValue != 3 || lArr.length >= 3) ? lArr[2].longValue() : System.currentTimeMillis();
        if (jLongValue == 0) {
            m();
            a(jLongValue2, jLongValue3);
            b(jLongValue2);
        } else if (jLongValue == 1 || jLongValue == 3) {
            a(jLongValue2, jLongValue3);
            b(jLongValue2);
        } else if (jLongValue == 2) {
            a(jLongValue2, jLongValue3);
            m();
        }
    }

    @Override // com.mob.commons.a.a
    public void i() {
    }
}
