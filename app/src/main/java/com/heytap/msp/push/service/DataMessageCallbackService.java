package com.heytap.msp.push.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import defpackage.C2318;
import defpackage.InterfaceC5278;
import defpackage.dd;

/* loaded from: classes2.dex */
public class DataMessageCallbackService extends Service implements InterfaceC5278 {
    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        dd.m5943(getApplicationContext(), intent, this);
        return 2;
    }

    @Override // defpackage.InterfaceC5278
    /* renamed from: Ϳ */
    public void mo5110(Context context, C2318 c2318) {
    }
}
