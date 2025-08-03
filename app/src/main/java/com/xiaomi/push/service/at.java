package com.xiaomi.push.service;

import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.push.eh;
import com.xiaomi.push.ei;
import com.xiaomi.push.service.XMPushService;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public class at {
    private final ConcurrentHashMap<String, c> a = new ConcurrentHashMap<>();

    public static class a extends XMPushService.j {
        public a() {
            super(17);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "RecordTimeManager clear";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo5444a() {
            at.a().m5770a();
        }
    }

    public static class b {
        private static final at a = new at();
    }

    public static class c {
        public long a;
        public long b;
        public long c;
        public long d;

        private c() {
        }

        public long a() {
            long j = this.c;
            long j2 = this.b;
            if (j > j2) {
                return j - j2;
            }
            return 0L;
        }

        public long b() {
            long j = this.d;
            long j2 = this.c;
            if (j > j2) {
                return j - j2;
            }
            return 0L;
        }
    }

    public static at a() {
        return b.a;
    }

    public void b(String str, long j) {
        c cVarRemove = this.a.remove(str);
        if (cVarRemove != null) {
            cVarRemove.d = j;
            a(str, cVarRemove);
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m5770a() {
        if (this.a.isEmpty()) {
            return;
        }
        Iterator<Map.Entry<String, c>> it = this.a.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, c> next = it.next();
            if (next == null || next.getValue() == null) {
                it.remove();
            } else {
                c value = next.getValue();
                if (Math.abs(SystemClock.elapsedRealtime() - value.b) > 10000) {
                    a(next.getKey(), value);
                    it.remove();
                }
            }
        }
    }

    public void a(String str, long j, long j2) {
        c cVar = new c();
        cVar.a = j2;
        cVar.b = j;
        this.a.put(str, cVar);
    }

    public void a(String str, long j) {
        c cVar = this.a.get(str);
        if (cVar != null) {
            cVar.c = j;
        }
    }

    private void a(String str, c cVar) {
        if (TextUtils.isEmpty(str) || cVar == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put("xmsfVC", Long.valueOf(cVar.a));
        map.put("packetId", str);
        map.put("pTime", Long.valueOf(cVar.a()));
        map.put("bTime", Long.valueOf(cVar.b()));
        ei.a().a(new eh("msg_process_time", map));
    }
}
