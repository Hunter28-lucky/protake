package com.polidea.rxandroidble2.internal.connection;

import com.polidea.rxandroidble2.exceptions.BleGattException;
import com.polidea.rxandroidble2.exceptions.BleGattOperationType;
import defpackage.AbstractC4262;
import defpackage.C4473;
import defpackage.InterfaceC2857;
import defpackage.InterfaceC4178;
import io.reactivex.internal.functions.Functions;

@ConnectionScope
/* loaded from: classes2.dex */
class MtuWatcher implements ConnectionSubscriptionWatcher, MtuProvider, InterfaceC2857<Integer> {
    private Integer currentMtu;
    private final AbstractC4262<Integer> mtuObservable;
    private final C4473 serialSubscription = new C4473();

    public MtuWatcher(RxBleGattCallback rxBleGattCallback, int i) {
        this.mtuObservable = rxBleGattCallback.getOnMtuChanged().retry(new InterfaceC4178<Throwable>() { // from class: com.polidea.rxandroidble2.internal.connection.MtuWatcher.1
            @Override // defpackage.InterfaceC4178
            public boolean test(Throwable th) {
                return (th instanceof BleGattException) && ((BleGattException) th).getBleGattOperationType() == BleGattOperationType.ON_MTU_CHANGED;
            }
        });
        this.currentMtu = Integer.valueOf(i);
    }

    @Override // com.polidea.rxandroidble2.internal.connection.MtuProvider
    public int getMtu() {
        return this.currentMtu.intValue();
    }

    @Override // com.polidea.rxandroidble2.internal.connection.ConnectionSubscriptionWatcher
    public void onConnectionSubscribed() {
        this.serialSubscription.m13727(this.mtuObservable.subscribe(this, Functions.m6320()));
    }

    @Override // com.polidea.rxandroidble2.internal.connection.ConnectionSubscriptionWatcher
    public void onConnectionUnsubscribed() {
        this.serialSubscription.dispose();
    }

    @Override // defpackage.InterfaceC2857
    public void accept(Integer num) {
        this.currentMtu = num;
    }
}
