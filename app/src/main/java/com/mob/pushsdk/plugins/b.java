package com.mob.pushsdk.plugins;

import android.text.TextUtils;
import com.mob.pushsdk.b.d;
import com.mob.pushsdk.b.h;
import com.mob.pushsdk.base.PLog;
import com.mob.pushsdk.plugins.a.f;
import com.mob.pushsdk.plugins.huawei.compat.PushHuaWeiCompat;
import com.mob.pushsdk.plugins.oppo.PushOppo;

/* loaded from: classes2.dex */
public class b {
    private static a a;
    private static b b;

    static {
        h();
    }

    public static b a() {
        if (b == null) {
            synchronized (b.class) {
                if (b == null) {
                    b = new b();
                }
            }
        }
        return b;
    }

    public static a b() {
        return a;
    }

    private static void h() {
        try {
            String strC = h.a().c();
            PLog.getInstance().d("MobPush start init push plugin, push channel name :" + strC, new Object[0]);
            a bVar = null;
            if (strC.equalsIgnoreCase(PushHuaWeiCompat.NAME)) {
                if (f.c()) {
                    d.a().a("[HUAWEI] plugin ready");
                    bVar = new com.mob.pushsdk.plugins.huawei.d();
                } else if (f.b()) {
                    d.a().a("[HUAWEI] plugin compat ready");
                    bVar = new PushHuaWeiCompat();
                }
            } else if (strC.equalsIgnoreCase("XIAOMI") && f.d()) {
                bVar = new com.mob.pushsdk.plugins.xiaomi.b();
            } else if (strC.equalsIgnoreCase("MEIZU") && f.e()) {
                bVar = new com.mob.pushsdk.plugins.meizu.b();
            } else if (strC.equalsIgnoreCase(PushOppo.NAME) && f.g()) {
                bVar = new PushOppo();
            } else if (strC.equalsIgnoreCase("VIVO") && f.h()) {
                bVar = new com.mob.pushsdk.plugins.vivo.b();
            }
            if ((com.mob.pushsdk.b.f.a(bVar) || !bVar.isSupport()) && f.f()) {
                bVar = new com.mob.pushsdk.plugins.fcm.b();
            }
            if (com.mob.pushsdk.b.f.b(bVar) && bVar.isSupport()) {
                a = bVar;
            }
            if (com.mob.pushsdk.b.a.c()) {
                a aVar = a;
                if (aVar != null) {
                    aVar.pluginsInit();
                } else {
                    d.a().c("No more push channel, enter MobPush channel.");
                    PLog.getInstance().d("MobPush no Support Push Channel!!!", new Object[0]);
                }
            }
        } catch (Throwable th) {
            PLog.getInstance().e("MobPush init plugin error: " + th, new Object[0]);
        }
    }

    public void c() {
        try {
            a aVar = a;
            if (aVar == null) {
                return;
            }
            aVar.stopPush();
        } catch (Throwable th) {
            PLog.getInstance().d(th);
        }
    }

    public void d() {
        try {
            a aVar = a;
            if (aVar == null) {
                return;
            }
            aVar.restartPush();
        } catch (Throwable th) {
            PLog.getInstance().d(th);
        }
    }

    public void e(String str) {
        a aVar = a;
        if (aVar == null || (aVar instanceof com.mob.pushsdk.plugins.fcm.b) || (aVar instanceof PushOppo)) {
            return;
        }
        aVar.cleanTags(str);
    }

    public boolean f() {
        return a(com.mob.pushsdk.plugins.fcm.b.class.getName(), a);
    }

    public boolean g() {
        return a(com.mob.pushsdk.plugins.xiaomi.b.class.getName(), a);
    }

    public void b(String str) {
        a aVar = a;
        if (aVar == null) {
            return;
        }
        aVar.deleteAlias(str);
    }

    public void c(String str) {
        a aVar = a;
        if (aVar == null || (aVar instanceof com.mob.pushsdk.plugins.fcm.b) || (aVar instanceof PushOppo) || (aVar instanceof com.mob.pushsdk.plugins.vivo.b)) {
            return;
        }
        aVar.addTags(str);
    }

    public void d(String str) {
        a aVar = a;
        if (aVar == null || (aVar instanceof com.mob.pushsdk.plugins.fcm.b) || (aVar instanceof PushOppo)) {
            return;
        }
        aVar.deleteTags(str);
    }

    public boolean e() {
        return a(PushOppo.class.getName(), a);
    }

    public void a(String str) {
        a aVar = a;
        if (aVar == null) {
            return;
        }
        aVar.setAlias(str);
    }

    private boolean a(String str, a aVar) {
        try {
            if (!TextUtils.isEmpty(str) && !com.mob.pushsdk.b.f.a(aVar)) {
                return str.equalsIgnoreCase(aVar.getClass().getName());
            }
            return false;
        } catch (Throwable th) {
            PLog.getInstance().e(th);
            return false;
        }
    }
}
