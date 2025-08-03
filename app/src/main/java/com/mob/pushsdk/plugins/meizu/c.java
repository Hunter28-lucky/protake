package com.mob.pushsdk.plugins.meizu;

import com.mob.pushsdk.base.PLog;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes2.dex */
public class c {
    private static volatile c a;
    private ConcurrentLinkedQueue<a> b = new ConcurrentLinkedQueue<>();

    public static class a {
        private String a;
        private int b;
        private int c;

        public a(String str, int i, int i2) {
            this.a = str;
            this.b = i;
            this.c = i2;
        }

        public String a() {
            return this.a;
        }

        public int b() {
            return this.b;
        }

        public int c() {
            return this.c;
        }
    }

    private c() {
    }

    public static c a() {
        if (a == null) {
            synchronized (c.class) {
                if (a == null) {
                    a = new c();
                }
            }
        }
        return a;
    }

    public void b() {
        synchronized (this.b) {
            if (this.b.isEmpty()) {
                return;
            }
            while (!this.b.isEmpty()) {
                a aVarPeek = this.b.peek();
                if (aVarPeek == null) {
                    return;
                }
                b(aVarPeek);
                try {
                    this.b.remove(aVarPeek);
                } catch (Throwable th) {
                    PLog.getInstance().d("MobPush-MEIZU: synchronize meizu strategy error：" + th, new Object[0]);
                }
            }
        }
    }

    public void a(a aVar) {
        if (aVar != null) {
            this.b.add(aVar);
        }
    }

    private void b(a aVar) {
        if (aVar == null) {
            return;
        }
        int iB = aVar.b();
        if (iB == 4) {
            if (aVar.c() == 1) {
                com.mob.pushsdk.plugins.b.b().setAlias(aVar.a());
                return;
            } else {
                if (aVar.c() == 2) {
                    com.mob.pushsdk.plugins.b.b().deleteAlias(aVar.a());
                    return;
                }
                return;
            }
        }
        if (iB != 5) {
            return;
        }
        if (aVar.c() == 1) {
            com.mob.pushsdk.plugins.b.b().addTags(aVar.a());
        } else if (aVar.c() == 2) {
            com.mob.pushsdk.plugins.b.b().deleteTags(aVar.a());
        } else if (aVar.c() == 3) {
            com.mob.pushsdk.plugins.b.b().cleanTags(aVar.a());
        }
    }
}
