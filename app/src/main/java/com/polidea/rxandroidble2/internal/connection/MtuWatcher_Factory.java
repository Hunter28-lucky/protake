package com.polidea.rxandroidble2.internal.connection;

import defpackage.InterfaceC3628;
import defpackage.InterfaceC4461;

/* loaded from: classes2.dex */
public final class MtuWatcher_Factory implements InterfaceC3628<MtuWatcher> {
    private final InterfaceC4461<Integer> initialValueProvider;
    private final InterfaceC4461<RxBleGattCallback> rxBleGattCallbackProvider;

    public MtuWatcher_Factory(InterfaceC4461<RxBleGattCallback> interfaceC4461, InterfaceC4461<Integer> interfaceC44612) {
        this.rxBleGattCallbackProvider = interfaceC4461;
        this.initialValueProvider = interfaceC44612;
    }

    public static MtuWatcher_Factory create(InterfaceC4461<RxBleGattCallback> interfaceC4461, InterfaceC4461<Integer> interfaceC44612) {
        return new MtuWatcher_Factory(interfaceC4461, interfaceC44612);
    }

    public static MtuWatcher newMtuWatcher(RxBleGattCallback rxBleGattCallback, int i) {
        return new MtuWatcher(rxBleGattCallback, i);
    }

    @Override // defpackage.InterfaceC4461
    public MtuWatcher get() {
        return new MtuWatcher(this.rxBleGattCallbackProvider.get(), this.initialValueProvider.get().intValue());
    }
}
