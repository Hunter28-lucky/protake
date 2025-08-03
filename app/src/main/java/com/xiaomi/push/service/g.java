package com.xiaomi.push.service;

import com.xiaomi.push.hf;

/* loaded from: classes2.dex */
public class g {
    private static a a;

    /* renamed from: a, reason: collision with other field name */
    private static b f6449a;

    public interface a {
        boolean a(hf hfVar);
    }

    public interface b {
    }

    public static void a(b bVar) {
        f6449a = bVar;
    }

    public static boolean a(hf hfVar) {
        if (a == null || hfVar == null) {
            com.xiaomi.channel.commonutils.logger.b.m5113a("rc params is null, not cpra");
            return false;
        }
        if (com.xiaomi.push.j.m5690a(com.xiaomi.push.s.m5702a())) {
            return a.a(hfVar);
        }
        com.xiaomi.channel.commonutils.logger.b.m5113a("rc app not permission to cpra");
        return false;
    }
}
