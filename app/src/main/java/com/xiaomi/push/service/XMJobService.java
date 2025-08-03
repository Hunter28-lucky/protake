package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.xiaomi.push.ea;

/* loaded from: classes2.dex */
public class XMJobService extends Service {
    public static Service a;

    /* renamed from: a, reason: collision with other field name */
    private IBinder f6336a = null;

    @TargetApi(21)
    public static class a extends JobService {
        public Binder a;

        /* renamed from: a, reason: collision with other field name */
        private Handler f6337a;

        /* renamed from: com.xiaomi.push.service.XMJobService$a$a, reason: collision with other inner class name */
        public static class HandlerC1937a extends Handler {
            public JobService a;

            public HandlerC1937a(JobService jobService) {
                super(jobService.getMainLooper());
                this.a = jobService;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 1) {
                    return;
                }
                JobParameters jobParameters = (JobParameters) message.obj;
                com.xiaomi.channel.commonutils.logger.b.m5113a("Job finished " + jobParameters.getJobId());
                this.a.jobFinished(jobParameters, false);
                if (jobParameters.getJobId() == 1) {
                    ea.a(false);
                }
            }
        }

        public a(Service service) {
            this.a = null;
            this.a = (Binder) com.xiaomi.push.ax.a((Object) this, "onBind", new Intent());
            com.xiaomi.push.ax.a((Object) this, "attachBaseContext", service);
        }

        @Override // android.app.job.JobService
        public boolean onStartJob(JobParameters jobParameters) {
            com.xiaomi.channel.commonutils.logger.b.m5113a("Job started " + jobParameters.getJobId());
            Intent intent = new Intent(this, (Class<?>) XMPushService.class);
            intent.setAction("com.xiaomi.push.timer");
            intent.setPackage(getPackageName());
            startService(intent);
            if (this.f6337a == null) {
                this.f6337a = new HandlerC1937a(this);
            }
            Handler handler = this.f6337a;
            handler.sendMessage(Message.obtain(handler, 1, jobParameters));
            return true;
        }

        @Override // android.app.job.JobService
        public boolean onStopJob(JobParameters jobParameters) {
            com.xiaomi.channel.commonutils.logger.b.m5113a("Job stop " + jobParameters.getJobId());
            return false;
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        IBinder iBinder = this.f6336a;
        return iBinder != null ? iBinder : new Binder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f6336a = new a(this).a;
        a = this;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        a = null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        int iOnStartCommand = super.onStartCommand(intent, i, i2);
        if (com.xiaomi.push.j.m5690a((Context) this)) {
            return iOnStartCommand;
        }
        return 2;
    }
}
