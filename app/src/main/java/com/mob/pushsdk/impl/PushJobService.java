package com.mob.pushsdk.impl;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import com.mob.MobSDK;
import com.mob.pushsdk.MobPush;
import com.mob.pushsdk.base.PLog;
import java.util.concurrent.TimeUnit;

@TargetApi(21)
/* loaded from: classes2.dex */
public class PushJobService extends JobService {
    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        new Thread() { // from class: com.mob.pushsdk.impl.PushJobService.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                super.run();
                MobPush.initMobPush();
                PushJobService.this.a();
            }
        }.start();
        return false;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        try {
            JobScheduler jobScheduler = (JobScheduler) MobSDK.getContext().getSystemService("jobscheduler");
            JobInfo.Builder builder = new JobInfo.Builder(1, new ComponentName(MobSDK.getContext(), (Class<?>) PushJobService.class));
            builder.setMinimumLatency(TimeUnit.HOURS.toMillis(1L));
            builder.setOverrideDeadline(TimeUnit.DAYS.toMillis(1L));
            builder.setRequiredNetworkType(1);
            builder.setRequiresCharging(false);
            builder.setBackoffCriteria(TimeUnit.MINUTES.toMillis(1L), 0);
            jobScheduler.schedule(builder.build());
        } catch (Throwable th) {
            PLog.getInstance().e("PushJobService schedule error:" + th, new Object[0]);
        }
    }
}
