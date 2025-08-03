package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.clientreport.manager.ClientReportClient;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class dt {
    private static a a;

    /* renamed from: a, reason: collision with other field name */
    private static Map<String, gq> f5808a;

    public interface a {
        void uploader(Context context, gk gkVar);
    }

    public static int a(int i) {
        if (i > 0) {
            return i + 1000;
        }
        return -1;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static String m5422a(int i) {
        return i == 1000 ? "E100000" : i == 3000 ? "E100002" : i == 2000 ? "E100001" : i == 6000 ? "E100003" : "";
    }

    public static void a(a aVar) {
        a = aVar;
    }

    private static void a(Context context, gk gkVar) {
        if (m5424a(context.getApplicationContext())) {
            com.xiaomi.push.service.ba.a(context.getApplicationContext(), gkVar);
            return;
        }
        a aVar = a;
        if (aVar != null) {
            aVar.uploader(context, gkVar);
        }
    }

    public static EventClientReport a(String str) {
        EventClientReport eventClientReport = new EventClientReport();
        eventClientReport.production = 1000;
        eventClientReport.reportType = 1001;
        eventClientReport.clientInterfaceId = str;
        return eventClientReport;
    }

    public static PerfClientReport a() {
        PerfClientReport perfClientReport = new PerfClientReport();
        perfClientReport.production = 1000;
        perfClientReport.reportType = 1000;
        perfClientReport.clientInterfaceId = "P100000";
        return perfClientReport;
    }

    public static EventClientReport a(Context context, String str, String str2, int i, long j, String str3) {
        EventClientReport eventClientReportA = a(str);
        eventClientReportA.eventId = str2;
        eventClientReportA.eventType = i;
        eventClientReportA.eventTime = j;
        eventClientReportA.eventContent = str3;
        return eventClientReportA;
    }

    public static PerfClientReport a(Context context, int i, long j, long j2) {
        PerfClientReport perfClientReportA = a();
        perfClientReportA.code = i;
        perfClientReportA.perfCounts = j;
        perfClientReportA.perfLatencies = j2;
        return perfClientReportA;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m5424a(Context context) {
        return (context == null || TextUtils.isEmpty(context.getPackageName()) || !"com.xiaomi.xmsf".equals(context.getPackageName())) ? false : true;
    }

    public static void a(Context context, List<String> list) {
        if (list == null) {
            return;
        }
        try {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                gk gkVarA = a(context, it.next());
                if (!com.xiaomi.push.service.az.a(gkVarA, false)) {
                    a(context, gkVarA);
                }
            }
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.d(th.getMessage());
        }
    }

    public static gk a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        gk gkVar = new gk();
        gkVar.d("category_client_report_data");
        gkVar.a("push_sdk_channel");
        gkVar.a(1L);
        gkVar.b(str);
        gkVar.a(true);
        gkVar.b(System.currentTimeMillis());
        gkVar.g(context.getPackageName());
        gkVar.e("com.xiaomi.xmsf");
        gkVar.f(com.xiaomi.push.service.az.a());
        gkVar.c("quality_support");
        return gkVar;
    }

    public static void a(Context context, Config config) {
        ClientReportClient.init(context, config, new dr(context), new ds(context));
    }

    /* renamed from: a, reason: collision with other method in class */
    public static void m5423a(Context context) {
        ClientReportClient.updateConfig(context, a(context));
    }

    public static Config a(Context context) {
        boolean zA = com.xiaomi.push.service.ah.a(context).a(gl.PerfUploadSwitch.a(), false);
        boolean zA2 = com.xiaomi.push.service.ah.a(context).a(gl.EventUploadNewSwitch.a(), false);
        return Config.getBuilder().setEventUploadSwitchOpen(zA2).setEventUploadFrequency(com.xiaomi.push.service.ah.a(context).a(gl.EventUploadFrequency.a(), 86400)).setPerfUploadSwitchOpen(zA).setPerfUploadFrequency(com.xiaomi.push.service.ah.a(context).a(gl.PerfUploadFrequency.a(), 86400)).build(context);
    }

    public static int a(Enum r1) {
        if (r1 != null) {
            if (r1 instanceof gg) {
                return r1.ordinal() + 1001;
            }
            if (r1 instanceof gq) {
                return r1.ordinal() + 2001;
            }
            if (r1 instanceof ee) {
                return r1.ordinal() + 3001;
            }
        }
        return -1;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static gq m5421a(String str) {
        if (f5808a == null) {
            synchronized (gq.class) {
                if (f5808a == null) {
                    f5808a = new HashMap();
                    for (gq gqVar : gq.values()) {
                        f5808a.put(gqVar.f6003a.toLowerCase(), gqVar);
                    }
                }
            }
        }
        gq gqVar2 = f5808a.get(str.toLowerCase());
        return gqVar2 != null ? gqVar2 : gq.Invalid;
    }
}
