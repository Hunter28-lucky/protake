package com.polidea.rxandroidble2.internal.connection;

import com.jakewharton.rxrelay2.BehaviorRelay;
import com.polidea.rxandroidble2.RxBleAdapterStateObservable;
import com.polidea.rxandroidble2.exceptions.BleDisconnectedException;
import com.polidea.rxandroidble2.exceptions.BleException;
import com.polidea.rxandroidble2.exceptions.BleGattException;
import com.polidea.rxandroidble2.internal.RxBleLog;
import com.polidea.rxandroidble2.internal.util.RxBleAdapterWrapper;
import defpackage.AbstractC4262;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC2857;
import defpackage.InterfaceC3809;
import defpackage.InterfaceC4178;
import defpackage.InterfaceC4478;

@ConnectionScope
/* loaded from: classes2.dex */
class DisconnectionRouter implements DisconnectionRouterInput, DisconnectionRouterOutput {
    private final BehaviorRelay<BleException> bleExceptionBehaviorRelay;
    private final AbstractC4262<Object> firstDisconnectionExceptionObs;
    private final AbstractC4262<BleException> firstDisconnectionValueObs;

    public DisconnectionRouter(final String str, RxBleAdapterWrapper rxBleAdapterWrapper, AbstractC4262<RxBleAdapterStateObservable.BleAdapterState> abstractC4262) {
        BehaviorRelay<BleException> behaviorRelayCreate = BehaviorRelay.create();
        this.bleExceptionBehaviorRelay = behaviorRelayCreate;
        final InterfaceC4478 interfaceC4478Subscribe = awaitAdapterNotUsable(rxBleAdapterWrapper, abstractC4262).map(new InterfaceC2368<Boolean, BleException>() { // from class: com.polidea.rxandroidble2.internal.connection.DisconnectionRouter.3
            @Override // defpackage.InterfaceC2368
            public BleException apply(Boolean bool) {
                return BleDisconnectedException.adapterDisabled(str);
            }
        }).doOnNext(new InterfaceC2857<BleException>() { // from class: com.polidea.rxandroidble2.internal.connection.DisconnectionRouter.2
            @Override // defpackage.InterfaceC2857
            public void accept(BleException bleException) {
                RxBleLog.v("An exception received, indicating that the adapter has became unusable.", new Object[0]);
            }
        }).subscribe(behaviorRelayCreate, new InterfaceC2857<Throwable>() { // from class: com.polidea.rxandroidble2.internal.connection.DisconnectionRouter.1
            @Override // defpackage.InterfaceC2857
            public void accept(Throwable th) {
                RxBleLog.e(th, "Failed to monitor adapter state.", new Object[0]);
            }
        });
        AbstractC4262<BleException> abstractC4262M14715 = behaviorRelayCreate.firstElement().m13390().doOnTerminate(new InterfaceC3809() { // from class: com.polidea.rxandroidble2.internal.connection.DisconnectionRouter.4
            @Override // defpackage.InterfaceC3809
            public void run() {
                interfaceC4478Subscribe.dispose();
            }
        }).replay().m14715(0);
        this.firstDisconnectionValueObs = abstractC4262M14715;
        this.firstDisconnectionExceptionObs = abstractC4262M14715.flatMap(new InterfaceC2368<BleException, InterfaceC2856<?>>() { // from class: com.polidea.rxandroidble2.internal.connection.DisconnectionRouter.5
            @Override // defpackage.InterfaceC2368
            public InterfaceC2856<?> apply(BleException bleException) {
                return AbstractC4262.error(bleException);
            }
        });
    }

    private static AbstractC4262<Boolean> awaitAdapterNotUsable(RxBleAdapterWrapper rxBleAdapterWrapper, AbstractC4262<RxBleAdapterStateObservable.BleAdapterState> abstractC4262) {
        return abstractC4262.map(new InterfaceC2368<RxBleAdapterStateObservable.BleAdapterState, Boolean>() { // from class: com.polidea.rxandroidble2.internal.connection.DisconnectionRouter.7
            @Override // defpackage.InterfaceC2368
            public Boolean apply(RxBleAdapterStateObservable.BleAdapterState bleAdapterState) {
                return Boolean.valueOf(bleAdapterState.isUsable());
            }
        }).startWith((AbstractC4262<R>) Boolean.valueOf(rxBleAdapterWrapper.isBluetoothEnabled())).filter(new InterfaceC4178<Boolean>() { // from class: com.polidea.rxandroidble2.internal.connection.DisconnectionRouter.6
            @Override // defpackage.InterfaceC4178
            public boolean test(Boolean bool) {
                return !bool.booleanValue();
            }
        });
    }

    @Override // com.polidea.rxandroidble2.internal.connection.DisconnectionRouterOutput
    public <T> AbstractC4262<T> asErrorOnlyObservable() {
        return (AbstractC4262<T>) this.firstDisconnectionExceptionObs;
    }

    @Override // com.polidea.rxandroidble2.internal.connection.DisconnectionRouterOutput
    public AbstractC4262<BleException> asValueOnlyObservable() {
        return this.firstDisconnectionValueObs;
    }

    @Override // com.polidea.rxandroidble2.internal.connection.DisconnectionRouterInput
    public void onDisconnectedException(BleDisconnectedException bleDisconnectedException) {
        this.bleExceptionBehaviorRelay.accept(bleDisconnectedException);
    }

    @Override // com.polidea.rxandroidble2.internal.connection.DisconnectionRouterInput
    public void onGattConnectionStateException(BleGattException bleGattException) {
        this.bleExceptionBehaviorRelay.accept(bleGattException);
    }
}
