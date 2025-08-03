package com.polidea.rxandroidble2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.NonNull;
import com.polidea.rxandroidble2.internal.RxBleLog;
import defpackage.AbstractC4262;
import defpackage.C4877;
import defpackage.InterfaceC2672;
import defpackage.InterfaceC5102;
import defpackage.InterfaceC5201;
import defpackage.InterfaceC5245;

/* loaded from: classes2.dex */
public class RxBleAdapterStateObservable extends AbstractC4262<BleAdapterState> {

    @NonNull
    private final AbstractC4262<BleAdapterState> bleAdapterStateObservable;

    public static class BleAdapterState {
        private final boolean isUsable;
        private final String stateName;
        public static final BleAdapterState STATE_ON = new BleAdapterState(true, "STATE_ON");
        public static final BleAdapterState STATE_OFF = new BleAdapterState(false, "STATE_OFF");
        public static final BleAdapterState STATE_TURNING_ON = new BleAdapterState(false, "STATE_TURNING_ON");
        public static final BleAdapterState STATE_TURNING_OFF = new BleAdapterState(false, "STATE_TURNING_OFF");

        private BleAdapterState(boolean z, String str) {
            this.isUsable = z;
            this.stateName = str;
        }

        public boolean isUsable() {
            return this.isUsable;
        }

        @NonNull
        public String toString() {
            return this.stateName;
        }
    }

    public RxBleAdapterStateObservable(@NonNull final Context context) {
        this.bleAdapterStateObservable = AbstractC4262.create(new InterfaceC5201<BleAdapterState>() { // from class: com.polidea.rxandroidble2.RxBleAdapterStateObservable.1
            @Override // defpackage.InterfaceC5201
            public void subscribe(final InterfaceC5245<BleAdapterState> interfaceC5245) {
                final BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.polidea.rxandroidble2.RxBleAdapterStateObservable.1.1
                    @Override // android.content.BroadcastReceiver
                    public void onReceive(Context context2, Intent intent) {
                        BleAdapterState bleAdapterStateMapToBleAdapterState = RxBleAdapterStateObservable.mapToBleAdapterState(intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1));
                        RxBleLog.i("Adapter state changed: %s", bleAdapterStateMapToBleAdapterState);
                        interfaceC5245.onNext(bleAdapterStateMapToBleAdapterState);
                    }
                };
                context.registerReceiver(broadcastReceiver, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
                interfaceC5245.mo6763(new InterfaceC2672() { // from class: com.polidea.rxandroidble2.RxBleAdapterStateObservable.1.2
                    @Override // defpackage.InterfaceC2672
                    public void cancel() {
                        context.unregisterReceiver(broadcastReceiver);
                    }
                });
            }
        }).subscribeOn(C4877.m14604()).unsubscribeOn(C4877.m14604()).share();
    }

    public static BleAdapterState mapToBleAdapterState(int i) {
        switch (i) {
            case 11:
                return BleAdapterState.STATE_TURNING_ON;
            case 12:
                return BleAdapterState.STATE_ON;
            case 13:
                return BleAdapterState.STATE_TURNING_OFF;
            default:
                return BleAdapterState.STATE_OFF;
        }
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super BleAdapterState> interfaceC5102) {
        this.bleAdapterStateObservable.subscribe(interfaceC5102);
    }
}
