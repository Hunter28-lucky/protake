package com.blink.academy.film.support.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;

/* loaded from: classes.dex */
public class BatteryChangedReceiver extends BroadcastReceiver {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public InterfaceC0793 f1598;

    /* renamed from: com.blink.academy.film.support.receiver.BatteryChangedReceiver$Ϳ, reason: contains not printable characters */
    public interface InterfaceC0793 {
        /* renamed from: Ϳ */
        void mo1366();

        /* renamed from: Ԩ */
        void mo1367(int i, int i2);

        /* renamed from: ԩ */
        void mo1368(int i);

        /* renamed from: Ԫ */
        void mo1369(int i, String str, int i2);

        /* renamed from: ԫ */
        void mo1370(int i);

        /* renamed from: Ԭ */
        void mo1371();

        /* renamed from: ԭ */
        void mo1372(int i);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (!action.equalsIgnoreCase("android.intent.action.BATTERY_CHANGED")) {
            if (action.equalsIgnoreCase("android.intent.action.BATTERY_LOW")) {
                this.f1598.mo1371();
                return;
            } else {
                if (action.equalsIgnoreCase("android.intent.action.BATTERY_OKAY")) {
                    this.f1598.mo1366();
                    return;
                }
                return;
            }
        }
        this.f1598.mo1368(intent.getIntExtra("health", -1));
        this.f1598.mo1367(intent.getIntExtra("level", -1), intent.getIntExtra("scale", -1));
        this.f1598.mo1370(intent.getIntExtra("plugged", -1));
        this.f1598.mo1372(intent.getIntExtra(NotificationCompat.CATEGORY_STATUS, -1));
        this.f1598.mo1369(intent.getIntExtra("voltage", -1), intent.getStringExtra("technology"), intent.getIntExtra("temperature", -1));
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m1906(InterfaceC0793 interfaceC0793) {
        this.f1598 = interfaceC0793;
    }
}
