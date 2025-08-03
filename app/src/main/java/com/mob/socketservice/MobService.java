package com.mob.socketservice;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import com.mob.tools.proguard.ClassKeeper;

/* loaded from: classes2.dex */
public class MobService extends Service implements ClassKeeper {
    private e serviceInit;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        this.serviceInit.a(intent, 0, -1);
        return this.serviceInit.a(intent);
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.serviceInit.a(configuration);
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.serviceInit = new e(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.serviceInit.a();
        super.onDestroy();
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onLowMemory() {
        this.serviceInit.b();
        super.onLowMemory();
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        this.serviceInit.d(intent);
        super.onRebind(intent);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return this.serviceInit.a(intent, i, i2);
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        this.serviceInit.b(intent);
        super.onTaskRemoved(intent);
    }

    @Override // android.app.Service, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        this.serviceInit.a(i);
        super.onTrimMemory(i);
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        this.serviceInit.c(intent);
        return super.onUnbind(intent);
    }
}
