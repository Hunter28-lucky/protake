package com.polidea.rxandroidble2.internal.connection;

import defpackage.InterfaceC3628;
import defpackage.InterfaceC4461;

/* loaded from: classes2.dex */
public final class LoggingIllegalOperationHandler_Factory implements InterfaceC3628<LoggingIllegalOperationHandler> {
    private final InterfaceC4461<IllegalOperationMessageCreator> messageCreatorProvider;

    public LoggingIllegalOperationHandler_Factory(InterfaceC4461<IllegalOperationMessageCreator> interfaceC4461) {
        this.messageCreatorProvider = interfaceC4461;
    }

    public static LoggingIllegalOperationHandler_Factory create(InterfaceC4461<IllegalOperationMessageCreator> interfaceC4461) {
        return new LoggingIllegalOperationHandler_Factory(interfaceC4461);
    }

    @Override // defpackage.InterfaceC4461
    public LoggingIllegalOperationHandler get() {
        return new LoggingIllegalOperationHandler(this.messageCreatorProvider.get());
    }
}
