package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.service.XMJobService;

/* loaded from: classes2.dex */
public final class ea {

    /* renamed from: a, reason: collision with other field name */
    private static a f5823a;

    /* renamed from: a, reason: collision with other field name */
    private static final String f5824a = XMJobService.class.getCanonicalName();
    private static int a = 0;

    public interface a {
        void a();

        void a(boolean z);

        /* renamed from: a, reason: collision with other method in class */
        boolean mo5439a();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007a A[EDGE_INSN: B:48:0x007a->B:29:0x007a BREAK  A[LOOP:0: B:10:0x0030->B:26:0x0074], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(android.content.Context r9) {
        /*
            java.lang.String r0 = "android.permission.BIND_JOB_SERVICE"
            android.content.Context r9 = r9.getApplicationContext()
            java.lang.String r1 = r9.getPackageName()
            java.lang.String r2 = "com.xiaomi.xmsf"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L1b
            com.xiaomi.push.eb r0 = new com.xiaomi.push.eb
            r0.<init>(r9)
            com.xiaomi.push.ea.f5823a = r0
            goto Lcb
        L1b:
            android.content.pm.PackageManager r1 = r9.getPackageManager()
            r2 = 0
            java.lang.String r3 = r9.getPackageName()     // Catch: java.lang.Exception -> L7c
            r4 = 4
            android.content.pm.PackageInfo r1 = r1.getPackageInfo(r3, r4)     // Catch: java.lang.Exception -> L7c
            android.content.pm.ServiceInfo[] r1 = r1.services     // Catch: java.lang.Exception -> L7c
            r3 = 1
            if (r1 == 0) goto L95
            int r4 = r1.length     // Catch: java.lang.Exception -> L7c
            r5 = r2
        L30:
            if (r2 >= r4) goto L7a
            r6 = r1[r2]     // Catch: java.lang.Exception -> L77
            java.lang.String r7 = r6.permission     // Catch: java.lang.Exception -> L77
            boolean r7 = r0.equals(r7)     // Catch: java.lang.Exception -> L77
            if (r7 == 0) goto L60
            java.lang.String r7 = com.xiaomi.push.ea.f5824a     // Catch: java.lang.Exception -> L77
            java.lang.String r8 = r6.name     // Catch: java.lang.Exception -> L77
            boolean r8 = r7.equals(r8)     // Catch: java.lang.Exception -> L77
            if (r8 == 0) goto L48
        L46:
            r5 = r3
            goto L5d
        L48:
            java.lang.String r8 = r6.name     // Catch: java.lang.Exception -> L5d
            java.lang.Class r8 = com.xiaomi.push.s.a(r9, r8)     // Catch: java.lang.Exception -> L5d
            java.lang.Class r8 = r8.getSuperclass()     // Catch: java.lang.Exception -> L5d
            java.lang.String r8 = r8.getCanonicalName()     // Catch: java.lang.Exception -> L5d
            boolean r7 = r7.equals(r8)     // Catch: java.lang.Exception -> L5d
            if (r7 == 0) goto L5d
            goto L46
        L5d:
            if (r5 != r3) goto L60
            goto L7a
        L60:
            java.lang.String r7 = com.xiaomi.push.ea.f5824a     // Catch: java.lang.Exception -> L77
            java.lang.String r8 = r6.name     // Catch: java.lang.Exception -> L77
            boolean r7 = r7.equals(r8)     // Catch: java.lang.Exception -> L77
            if (r7 == 0) goto L74
            java.lang.String r6 = r6.permission     // Catch: java.lang.Exception -> L77
            boolean r6 = r0.equals(r6)     // Catch: java.lang.Exception -> L77
            if (r6 == 0) goto L74
            r2 = r3
            goto L95
        L74:
            int r2 = r2 + 1
            goto L30
        L77:
            r1 = move-exception
            r2 = r5
            goto L7d
        L7a:
            r2 = r5
            goto L95
        L7c:
            r1 = move-exception
        L7d:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "check service err : "
            r3.append(r4)
            java.lang.String r1 = r1.getMessage()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            com.xiaomi.channel.commonutils.logger.b.m5113a(r1)
        L95:
            if (r2 != 0) goto Lc4
            boolean r1 = com.xiaomi.push.s.m5705a(r9)
            if (r1 != 0) goto L9e
            goto Lc4
        L9e:
            java.lang.RuntimeException r9 = new java.lang.RuntimeException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Should export service: "
            r1.append(r2)
            java.lang.String r2 = com.xiaomi.push.ea.f5824a
            r1.append(r2)
            java.lang.String r2 = " with permission "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = " in AndroidManifest.xml file"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r9.<init>(r0)
            throw r9
        Lc4:
            com.xiaomi.push.eb r0 = new com.xiaomi.push.eb
            r0.<init>(r9)
            com.xiaomi.push.ea.f5823a = r0
        Lcb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.ea.a(android.content.Context):void");
    }

    public static synchronized void a(Context context, int i) {
        int i2 = a;
        if (!"com.xiaomi.xmsf".equals(context.getPackageName())) {
            if (i == 2) {
                a = 2;
            } else {
                a = 0;
            }
        }
        int i3 = a;
        if (i2 != i3 && i3 == 2) {
            a();
            f5823a = new ed(context);
        }
    }

    public static synchronized void a(boolean z) {
        if (f5823a == null) {
            com.xiaomi.channel.commonutils.logger.b.m5113a("timer is not initialized");
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m5113a("[Alarm] register alarm. (" + z + ")");
        f5823a.a(z);
    }

    public static synchronized void a() {
        if (f5823a == null) {
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m5113a("[Alarm] stop alarm.");
        f5823a.a();
    }

    /* renamed from: a, reason: collision with other method in class */
    public static synchronized boolean m5438a() {
        a aVar = f5823a;
        if (aVar == null) {
            return false;
        }
        return aVar.mo5439a();
    }
}
