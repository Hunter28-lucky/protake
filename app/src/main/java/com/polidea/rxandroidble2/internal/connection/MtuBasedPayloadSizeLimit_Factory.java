package com.polidea.rxandroidble2.internal.connection;

import com.polidea.rxandroidble2.RxBleConnection;
import defpackage.InterfaceC3628;
import defpackage.InterfaceC4461;

/* loaded from: classes2.dex */
public final class MtuBasedPayloadSizeLimit_Factory implements InterfaceC3628<MtuBasedPayloadSizeLimit> {
    private final InterfaceC4461<Integer> gattWriteMtuOverheadProvider;
    private final InterfaceC4461<RxBleConnection> rxBleConnectionProvider;

    public MtuBasedPayloadSizeLimit_Factory(InterfaceC4461<RxBleConnection> interfaceC4461, InterfaceC4461<Integer> interfaceC44612) {
        this.rxBleConnectionProvider = interfaceC4461;
        this.gattWriteMtuOverheadProvider = interfaceC44612;
    }

    public static MtuBasedPayloadSizeLimit_Factory create(InterfaceC4461<RxBleConnection> interfaceC4461, InterfaceC4461<Integer> interfaceC44612) {
        return new MtuBasedPayloadSizeLimit_Factory(interfaceC4461, interfaceC44612);
    }

    public static MtuBasedPayloadSizeLimit newMtuBasedPayloadSizeLimit(RxBleConnection rxBleConnection, int i) {
        return new MtuBasedPayloadSizeLimit(rxBleConnection, i);
    }

    @Override // defpackage.InterfaceC4461
    public MtuBasedPayloadSizeLimit get() {
        return new MtuBasedPayloadSizeLimit(this.rxBleConnectionProvider.get(), this.gattWriteMtuOverheadProvider.get().intValue());
    }
}
