package com.polidea.rxandroidble2.internal.util;

import androidx.annotation.NonNull;
import com.polidea.rxandroidble2.RxBleAdapterStateObservable;
import com.polidea.rxandroidble2.RxBleClient;
import defpackage.AbstractC4262;
import defpackage.AbstractC4585;
import defpackage.AbstractC4838;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC4178;
import defpackage.InterfaceC5102;
import io.reactivex.disposables.C1972;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class ClientStateObservable extends AbstractC4262<RxBleClient.State> {
    public final AbstractC4262<RxBleAdapterStateObservable.BleAdapterState> bleAdapterStateObservable;
    public final AbstractC4262<Boolean> locationServicesOkObservable;
    private final LocationServicesStatus locationServicesStatus;
    public final RxBleAdapterWrapper rxBleAdapterWrapper;
    private final AbstractC4585 timerScheduler;

    public ClientStateObservable(RxBleAdapterWrapper rxBleAdapterWrapper, AbstractC4262<RxBleAdapterStateObservable.BleAdapterState> abstractC4262, AbstractC4262<Boolean> abstractC42622, LocationServicesStatus locationServicesStatus, AbstractC4585 abstractC4585) {
        this.rxBleAdapterWrapper = rxBleAdapterWrapper;
        this.bleAdapterStateObservable = abstractC4262;
        this.locationServicesOkObservable = abstractC42622;
        this.locationServicesStatus = locationServicesStatus;
        this.timerScheduler = abstractC4585;
    }

    @NonNull
    public static AbstractC4262<RxBleClient.State> checkAdapterAndServicesState(RxBleAdapterWrapper rxBleAdapterWrapper, AbstractC4262<RxBleAdapterStateObservable.BleAdapterState> abstractC4262, final AbstractC4262<Boolean> abstractC42622) {
        return abstractC4262.startWith((AbstractC4262<RxBleAdapterStateObservable.BleAdapterState>) (rxBleAdapterWrapper.isBluetoothEnabled() ? RxBleAdapterStateObservable.BleAdapterState.STATE_ON : RxBleAdapterStateObservable.BleAdapterState.STATE_OFF)).switchMap(new InterfaceC2368<RxBleAdapterStateObservable.BleAdapterState, AbstractC4262<RxBleClient.State>>() { // from class: com.polidea.rxandroidble2.internal.util.ClientStateObservable.3
            @Override // defpackage.InterfaceC2368
            public AbstractC4262<RxBleClient.State> apply(RxBleAdapterStateObservable.BleAdapterState bleAdapterState) {
                return bleAdapterState != RxBleAdapterStateObservable.BleAdapterState.STATE_ON ? AbstractC4262.just(RxBleClient.State.BLUETOOTH_NOT_ENABLED) : abstractC42622.map(new InterfaceC2368<Boolean, RxBleClient.State>() { // from class: com.polidea.rxandroidble2.internal.util.ClientStateObservable.3.1
                    @Override // defpackage.InterfaceC2368
                    public RxBleClient.State apply(Boolean bool) {
                        return bool.booleanValue() ? RxBleClient.State.READY : RxBleClient.State.LOCATION_SERVICES_NOT_ENABLED;
                    }
                });
            }
        });
    }

    @NonNull
    private static AbstractC4838<Boolean> checkPermissionUntilGranted(final LocationServicesStatus locationServicesStatus, AbstractC4585 abstractC4585) {
        return AbstractC4262.interval(0L, 1L, TimeUnit.SECONDS, abstractC4585).takeWhile(new InterfaceC4178<Long>() { // from class: com.polidea.rxandroidble2.internal.util.ClientStateObservable.2
            @Override // defpackage.InterfaceC4178
            public boolean test(Long l) {
                return !locationServicesStatus.isLocationPermissionOk();
            }
        }).count().map(new InterfaceC2368<Long, Boolean>() { // from class: com.polidea.rxandroidble2.internal.util.ClientStateObservable.1
            @Override // defpackage.InterfaceC2368
            public Boolean apply(Long l) {
                return Boolean.valueOf(l.longValue() == 0);
            }
        });
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super RxBleClient.State> interfaceC5102) {
        if (this.rxBleAdapterWrapper.hasBluetoothAdapter()) {
            checkPermissionUntilGranted(this.locationServicesStatus, this.timerScheduler).flatMapObservable(new InterfaceC2368<Boolean, AbstractC4262<RxBleClient.State>>() { // from class: com.polidea.rxandroidble2.internal.util.ClientStateObservable.4
                @Override // defpackage.InterfaceC2368
                public AbstractC4262<RxBleClient.State> apply(Boolean bool) {
                    ClientStateObservable clientStateObservable = ClientStateObservable.this;
                    AbstractC4262<RxBleClient.State> abstractC4262DistinctUntilChanged = ClientStateObservable.checkAdapterAndServicesState(clientStateObservable.rxBleAdapterWrapper, clientStateObservable.bleAdapterStateObservable, clientStateObservable.locationServicesOkObservable).distinctUntilChanged();
                    return bool.booleanValue() ? abstractC4262DistinctUntilChanged.skip(1L) : abstractC4262DistinctUntilChanged;
                }
            }).subscribe(interfaceC5102);
        } else {
            interfaceC5102.onSubscribe(C1972.m6300());
            interfaceC5102.onComplete();
        }
    }
}
