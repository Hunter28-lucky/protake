package com.polidea.rxandroidble2.internal.connection;

import defpackage.InterfaceC3628;
import defpackage.InterfaceC4461;

/* loaded from: classes2.dex */
public final class IllegalOperationChecker_Factory implements InterfaceC3628<IllegalOperationChecker> {
    private final InterfaceC4461<IllegalOperationHandler> resultHandlerProvider;

    public IllegalOperationChecker_Factory(InterfaceC4461<IllegalOperationHandler> interfaceC4461) {
        this.resultHandlerProvider = interfaceC4461;
    }

    public static IllegalOperationChecker_Factory create(InterfaceC4461<IllegalOperationHandler> interfaceC4461) {
        return new IllegalOperationChecker_Factory(interfaceC4461);
    }

    @Override // defpackage.InterfaceC4461
    public IllegalOperationChecker get() {
        return new IllegalOperationChecker(this.resultHandlerProvider.get());
    }
}
