package com.xiaomi.push;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.SystemClock;
import com.xiaomi.push.ea;
import com.xiaomi.push.service.XMJobService;

@TargetApi(21)
/* loaded from: classes2.dex */
public class ec implements ea.a {
    public JobScheduler a;

    /* renamed from: a, reason: collision with other field name */
    public Context f5827a;

    /* renamed from: a, reason: collision with other field name */
    private boolean f5828a = false;

    public ec(Context context) {
        this.f5827a = context;
        this.a = (JobScheduler) context.getSystemService("jobscheduler");
    }

    public void a(long j) {
        JobInfo.Builder builder = new JobInfo.Builder(1, new ComponentName(this.f5827a.getPackageName(), XMJobService.class.getName()));
        builder.setMinimumLatency(j);
        builder.setOverrideDeadline(j);
        builder.setRequiredNetworkType(1);
        com.xiaomi.channel.commonutils.logger.b.c("schedule Job = " + builder.build().getId() + " in " + j);
        this.a.schedule(builder.build());
    }

    @Override // com.xiaomi.push.ea.a
    public void a(boolean z) {
        if (z || this.f5828a) {
            long jB = fh.b();
            if (z) {
                a();
                jB -= SystemClock.elapsedRealtime() % jB;
            }
            this.f5828a = true;
            a(jB);
        }
    }

    @Override // com.xiaomi.push.ea.a
    public void a() {
        this.f5828a = false;
        this.a.cancel(1);
    }

    @Override // com.xiaomi.push.ea.a
    /* renamed from: a */
    public boolean mo5439a() {
        return this.f5828a;
    }
}
