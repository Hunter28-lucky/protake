package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.clientreport.processor.IEventProcessor;
import com.xiaomi.clientreport.processor.IPerfProcessor;

/* loaded from: classes2.dex */
public class bl implements Runnable {
    private Context a;

    /* renamed from: a, reason: collision with other field name */
    private com.xiaomi.clientreport.processor.c f5621a;

    public void a(com.xiaomi.clientreport.processor.c cVar) {
        this.f5621a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            com.xiaomi.clientreport.processor.c cVar = this.f5621a;
            if (cVar != null) {
                cVar.a();
            }
            com.xiaomi.channel.commonutils.logger.b.c("begin read and send perf / event");
            com.xiaomi.clientreport.processor.c cVar2 = this.f5621a;
            if (cVar2 instanceof IEventProcessor) {
                bn.a(this.a).m5252a("sp_client_report_status", "event_last_upload_time", System.currentTimeMillis());
            } else if (cVar2 instanceof IPerfProcessor) {
                bn.a(this.a).m5252a("sp_client_report_status", "perf_last_upload_time", System.currentTimeMillis());
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
        }
    }

    public void a(Context context) {
        this.a = context;
    }
}
