package com.polidea.rxandroidble2;

import android.bluetooth.BluetoothManager;
import android.content.Context;
import com.polidea.rxandroidble2.ClientComponent;
import defpackage.C4618;
import defpackage.InterfaceC3628;
import defpackage.InterfaceC4461;

/* loaded from: classes2.dex */
public final class ClientComponent_ClientModule_ProvideBluetoothManagerFactory implements InterfaceC3628<BluetoothManager> {
    private final InterfaceC4461<Context> contextProvider;

    public ClientComponent_ClientModule_ProvideBluetoothManagerFactory(InterfaceC4461<Context> interfaceC4461) {
        this.contextProvider = interfaceC4461;
    }

    public static ClientComponent_ClientModule_ProvideBluetoothManagerFactory create(InterfaceC4461<Context> interfaceC4461) {
        return new ClientComponent_ClientModule_ProvideBluetoothManagerFactory(interfaceC4461);
    }

    public static BluetoothManager proxyProvideBluetoothManager(Context context) {
        return (BluetoothManager) C4618.m14073(ClientComponent.ClientModule.provideBluetoothManager(context), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // defpackage.InterfaceC4461
    public BluetoothManager get() {
        return (BluetoothManager) C4618.m14073(ClientComponent.ClientModule.provideBluetoothManager(this.contextProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
