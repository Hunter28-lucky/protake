package com.polidea.rxandroidble2.internal.connection;

import defpackage.InterfaceC3628;
import defpackage.InterfaceC4461;

/* loaded from: classes2.dex */
public final class ThrowingIllegalOperationHandler_Factory implements InterfaceC3628<ThrowingIllegalOperationHandler> {
    private final InterfaceC4461<IllegalOperationMessageCreator> messageCreatorProvider;

    public ThrowingIllegalOperationHandler_Factory(InterfaceC4461<IllegalOperationMessageCreator> interfaceC4461) {
        this.messageCreatorProvider = interfaceC4461;
    }

    public static ThrowingIllegalOperationHandler_Factory create(InterfaceC4461<IllegalOperationMessageCreator> interfaceC4461) {
        return new ThrowingIllegalOperationHandler_Factory(interfaceC4461);
    }

    @Override // defpackage.InterfaceC4461
    public ThrowingIllegalOperationHandler get() {
        return new ThrowingIllegalOperationHandler(this.messageCreatorProvider.get());
    }
}
