package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Random;

/* loaded from: classes2.dex */
public class bi implements Runnable {
    private bi() {
    }

    public static void a(Context context) {
        if (context == null || !"com.xiaomi.xmsf".equals(context.getPackageName())) {
            return;
        }
        a aVar = new a(context);
        if (aVar.m5247a()) {
            new Thread(new bi()).start();
            aVar.m5246a();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0191  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            Method dump skipped, instructions count: 503
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.bi.run():void");
    }

    public static class a {
        public SharedPreferences a;

        /* renamed from: a, reason: collision with other field name */
        private final String f5620a = "dc_job_result_time_26";

        public a(Context context) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
            this.a = sharedPreferences;
            long j = sharedPreferences.getLong("dc_job_result_time_26", 0L);
            if (j <= 0 || j - System.currentTimeMillis() > 259200000) {
                this.a.edit().putLong("dc_job_result_time_26", a()).apply();
            }
        }

        private long a() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            Random random = new Random(jCurrentTimeMillis);
            return (((jCurrentTimeMillis / 86400000) + 1) * 86400000) + (random.nextInt(3) * 86400000) + random.nextInt(46800000);
        }

        /* renamed from: a, reason: collision with other method in class */
        public boolean m5247a() {
            return System.currentTimeMillis() - this.a.getLong("dc_job_result_time_26", 0L) > 0;
        }

        private a() {
        }

        /* renamed from: a, reason: collision with other method in class */
        public void m5246a() {
            long j = this.a.getLong("dc_job_result_time_26", 0L);
            long jCurrentTimeMillis = System.currentTimeMillis() - j;
            if (jCurrentTimeMillis >= 0) {
                this.a.edit().putLong("dc_job_result_time_26", j + (((jCurrentTimeMillis / 259200000) + 1) * 259200000)).apply();
            }
        }
    }

    private void a(be beVar, bd bdVar, Exception exc) {
        HashMap map = new HashMap();
        String strM5808a = com.xiaomi.push.service.q.m5808a(s.m5702a());
        if (!TextUtils.isEmpty(strM5808a)) {
            map.put("uuid", strM5808a);
        }
        map.put("appCount", Long.valueOf(beVar.m5244a()));
        map.put("channels", Long.valueOf(beVar.b()));
        map.put("packCount", Long.valueOf(beVar.c()));
        map.put("totalSize", Long.valueOf(beVar.d()));
        map.put("isBatch", Integer.valueOf(beVar.a()));
        map.put("maxCallTime", Long.valueOf(bdVar.a()));
        map.put("minCallTime", Long.valueOf(bdVar.b()));
        map.put("callAvg", Long.valueOf(bdVar.c()));
        map.put("duration", Long.valueOf(bdVar.d()));
        if (exc != null) {
            map.put("exception", exc.toString());
        }
        ei.a().a("app_switch_upload", map);
    }

    private void a(Context context, bh bhVar, be beVar) {
        gk gkVar = new gk();
        gkVar.d("category_app_channel_info");
        gkVar.c("app_channel_info");
        gkVar.b(bhVar.toString());
        gkVar.a(false);
        gkVar.a(1L);
        gkVar.a("xmsf_channel");
        gkVar.b(System.currentTimeMillis());
        gkVar.g("com.xiaomi.xmsf");
        gkVar.e("com.xiaomi.xmsf");
        gkVar.f(com.xiaomi.push.service.az.a());
        com.xiaomi.push.service.ba.a(context, gkVar);
    }
}
