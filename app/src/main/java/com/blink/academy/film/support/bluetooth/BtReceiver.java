package com.blink.academy.film.support.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/* loaded from: classes.dex */
public class BtReceiver extends BroadcastReceiver {

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final String f1522 = BtReceiver.class.getSimpleName();

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final InterfaceC0784 f1523;

    /* renamed from: com.blink.academy.film.support.bluetooth.BtReceiver$Ϳ, reason: contains not printable characters */
    public interface InterfaceC0784 {
        /* renamed from: Ϳ, reason: contains not printable characters */
        void m1878(BluetoothDevice bluetoothDevice);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String str;
        BluetoothDevice bluetoothDevice;
        String action = intent.getAction();
        if (action == null) {
        }
        str = f1522;
        Log.i(str, "===" + action);
        bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        if (bluetoothDevice != null) {
            Log.i(str, "BluetoothDevice: " + bluetoothDevice.getName() + ", " + bluetoothDevice.getAddress());
        }
        switch (action) {
            case "android.bluetooth.adapter.action.STATE_CHANGED":
                Log.i(str, "STATE: " + intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 0));
                break;
            case "android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED":
                Log.i(str, "CONN_STATE: " + intent.getIntExtra("android.bluetooth.profile.extra.STATE", 0));
                break;
            case "android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED":
                Log.i(str, "CONN_STATE: " + intent.getIntExtra("android.bluetooth.adapter.extra.CONNECTION_STATE", 0));
                break;
            case "android.bluetooth.device.action.FOUND":
                Log.i(str, "EXTRA_RSSI:" + ((int) intent.getShortExtra("android.bluetooth.device.extra.RSSI", Short.MAX_VALUE)));
                this.f1523.m1878(bluetoothDevice);
                break;
            case "android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED":
                Log.i(str, "CONN_STATE: " + intent.getIntExtra("android.bluetooth.profile.extra.STATE", 0));
                break;
            case "android.bluetooth.device.action.BOND_STATE_CHANGED":
                Log.i(str, "BOND_STATE: " + intent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", 0));
                break;
        }
    }
}
