package com.polidea.rxandroidble2.internal.util;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import defpackage.AbstractC4262;
import defpackage.C4877;
import defpackage.InterfaceC2672;
import defpackage.InterfaceC5201;
import defpackage.InterfaceC5245;

@TargetApi(19)
/* loaded from: classes2.dex */
public class LocationServicesOkObservableApi23Factory {
    public final Context context;
    public final LocationServicesStatus locationServicesStatus;

    public LocationServicesOkObservableApi23Factory(Context context, LocationServicesStatus locationServicesStatus) {
        this.context = context;
        this.locationServicesStatus = locationServicesStatus;
    }

    public AbstractC4262<Boolean> get() {
        return AbstractC4262.create(new InterfaceC5201<Boolean>() { // from class: com.polidea.rxandroidble2.internal.util.LocationServicesOkObservableApi23Factory.1
            @Override // defpackage.InterfaceC5201
            public void subscribe(final InterfaceC5245<Boolean> interfaceC5245) {
                boolean zIsLocationProviderOk = LocationServicesOkObservableApi23Factory.this.locationServicesStatus.isLocationProviderOk();
                final BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.polidea.rxandroidble2.internal.util.LocationServicesOkObservableApi23Factory.1.1
                    @Override // android.content.BroadcastReceiver
                    public void onReceive(Context context, Intent intent) {
                        interfaceC5245.onNext(Boolean.valueOf(LocationServicesOkObservableApi23Factory.this.locationServicesStatus.isLocationProviderOk()));
                    }
                };
                interfaceC5245.onNext(Boolean.valueOf(zIsLocationProviderOk));
                LocationServicesOkObservableApi23Factory.this.context.registerReceiver(broadcastReceiver, new IntentFilter("android.location.MODE_CHANGED"));
                interfaceC5245.mo6763(new InterfaceC2672() { // from class: com.polidea.rxandroidble2.internal.util.LocationServicesOkObservableApi23Factory.1.2
                    @Override // defpackage.InterfaceC2672
                    public void cancel() {
                        LocationServicesOkObservableApi23Factory.this.context.unregisterReceiver(broadcastReceiver);
                    }
                });
            }
        }).distinctUntilChanged().subscribeOn(C4877.m14604()).unsubscribeOn(C4877.m14604());
    }
}
