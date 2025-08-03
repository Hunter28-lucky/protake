package com.polidea.rxandroidble2;

import android.bluetooth.BluetoothAdapter;
import androidx.annotation.Nullable;
import com.polidea.rxandroidble2.ClientComponent;
import defpackage.InterfaceC3628;

/* loaded from: classes2.dex */
public final class ClientComponent_ClientModule_ProvideBluetoothAdapterFactory implements InterfaceC3628<BluetoothAdapter> {
    private static final ClientComponent_ClientModule_ProvideBluetoothAdapterFactory INSTANCE = new ClientComponent_ClientModule_ProvideBluetoothAdapterFactory();

    public static ClientComponent_ClientModule_ProvideBluetoothAdapterFactory create() {
        return INSTANCE;
    }

    @Nullable
    public static BluetoothAdapter proxyProvideBluetoothAdapter() {
        return ClientComponent.ClientModule.provideBluetoothAdapter();
    }

    @Override // defpackage.InterfaceC4461
    @Nullable
    public BluetoothAdapter get() {
        return ClientComponent.ClientModule.provideBluetoothAdapter();
    }
}
