package com.xiaomi.push;

import com.xiaomi.push.ag;

/* loaded from: classes2.dex */
public class fz {
    private static ag a = new ag(true, 20);

    public static void a(final Runnable runnable) {
        a.a(new ag.b() { // from class: com.xiaomi.push.fz.1
            @Override // com.xiaomi.push.ag.b
            public void b() {
                runnable.run();
            }
        });
    }

    public static void a(ag.b bVar) {
        a.a(bVar);
    }

    public static void a(ag.b bVar, long j) {
        a.a(bVar, j);
    }
}
