package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.clientreport.manager.ClientReportClient;

/* loaded from: classes2.dex */
public class du {
    private static volatile du a;

    /* renamed from: a, reason: collision with other field name */
    private Context f5809a;

    private du(Context context) {
        this.f5809a = context;
    }

    public static du a(Context context) {
        if (a == null) {
            synchronized (du.class) {
                if (a == null) {
                    a = new du(context);
                }
            }
        }
        return a;
    }

    public void b(String str, String str2, String str3, String str4) {
        a(str, str2, str3, 5001, System.currentTimeMillis(), str4);
    }

    public void c(String str, String str2, String str3, String str4) {
        a(str, str2, str3, 4002, System.currentTimeMillis(), str4);
    }

    public void a(String str, String str2, String str3, int i, long j, String str4) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        EventClientReport eventClientReportA = dt.a(this.f5809a, str2, str3, i, j, str4);
        eventClientReportA.setAppPackageName(str);
        eventClientReportA.setSdkVersion(BuildConfig.VERSION_NAME);
        a(eventClientReportA);
    }

    public void a(String str, String str2, String str3, int i, String str4) {
        a(str, str2, str3, i, System.currentTimeMillis(), str4);
    }

    public void a(String str, Intent intent, int i, String str2) {
        if (intent == null) {
            return;
        }
        a(str, dt.m5422a(intent.getIntExtra("eventMessageType", -1)), intent.getStringExtra("messageId"), i, System.currentTimeMillis(), str2);
    }

    public void a(String str, String str2, String str3, String str4) {
        a(str, str2, str3, 5002, System.currentTimeMillis(), str4);
    }

    public void a(String str, Intent intent, String str2) {
        if (intent == null) {
            return;
        }
        a(str, dt.m5422a(intent.getIntExtra("eventMessageType", -1)), intent.getStringExtra("messageId"), 5001, System.currentTimeMillis(), str2);
    }

    public void a(String str, int i, long j, long j2) {
        if (i < 0 || j2 < 0 || j <= 0) {
            return;
        }
        PerfClientReport perfClientReportA = dt.a(this.f5809a, i, j, j2);
        perfClientReportA.setAppPackageName(str);
        perfClientReportA.setSdkVersion(BuildConfig.VERSION_NAME);
        a(perfClientReportA);
    }

    private void a(com.xiaomi.clientreport.data.a aVar) {
        if (aVar instanceof PerfClientReport) {
            ClientReportClient.reportPerf(this.f5809a, (PerfClientReport) aVar);
        } else if (aVar instanceof EventClientReport) {
            ClientReportClient.reportEvent(this.f5809a, (EventClientReport) aVar);
        }
    }
}
