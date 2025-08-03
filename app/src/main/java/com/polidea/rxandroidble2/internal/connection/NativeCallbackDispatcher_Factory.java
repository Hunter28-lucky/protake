package com.polidea.rxandroidble2.internal.connection;

import defpackage.InterfaceC3628;

/* loaded from: classes2.dex */
public final class NativeCallbackDispatcher_Factory implements InterfaceC3628<NativeCallbackDispatcher> {
    private static final NativeCallbackDispatcher_Factory INSTANCE = new NativeCallbackDispatcher_Factory();

    public static NativeCallbackDispatcher_Factory create() {
        return INSTANCE;
    }

    public static NativeCallbackDispatcher newNativeCallbackDispatcher() {
        return new NativeCallbackDispatcher();
    }

    @Override // defpackage.InterfaceC4461
    public NativeCallbackDispatcher get() {
        return new NativeCallbackDispatcher();
    }
}
