package com.polidea.rxandroidble2.internal.connection;

import defpackage.C4618;
import defpackage.InterfaceC3628;
import defpackage.InterfaceC4461;

/* loaded from: classes2.dex */
public final class ConnectionModule_ProvideIllegalOperationHandlerFactory implements InterfaceC3628<IllegalOperationHandler> {
    private final InterfaceC4461<LoggingIllegalOperationHandler> loggingIllegalOperationHandlerProvider;
    private final InterfaceC4461<Boolean> suppressOperationCheckProvider;
    private final InterfaceC4461<ThrowingIllegalOperationHandler> throwingIllegalOperationHandlerProvider;

    public ConnectionModule_ProvideIllegalOperationHandlerFactory(InterfaceC4461<Boolean> interfaceC4461, InterfaceC4461<LoggingIllegalOperationHandler> interfaceC44612, InterfaceC4461<ThrowingIllegalOperationHandler> interfaceC44613) {
        this.suppressOperationCheckProvider = interfaceC4461;
        this.loggingIllegalOperationHandlerProvider = interfaceC44612;
        this.throwingIllegalOperationHandlerProvider = interfaceC44613;
    }

    public static ConnectionModule_ProvideIllegalOperationHandlerFactory create(InterfaceC4461<Boolean> interfaceC4461, InterfaceC4461<LoggingIllegalOperationHandler> interfaceC44612, InterfaceC4461<ThrowingIllegalOperationHandler> interfaceC44613) {
        return new ConnectionModule_ProvideIllegalOperationHandlerFactory(interfaceC4461, interfaceC44612, interfaceC44613);
    }

    public static IllegalOperationHandler proxyProvideIllegalOperationHandler(boolean z, InterfaceC4461<LoggingIllegalOperationHandler> interfaceC4461, InterfaceC4461<ThrowingIllegalOperationHandler> interfaceC44612) {
        return (IllegalOperationHandler) C4618.m14073(ConnectionModule.provideIllegalOperationHandler(z, interfaceC4461, interfaceC44612), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // defpackage.InterfaceC4461
    public IllegalOperationHandler get() {
        return (IllegalOperationHandler) C4618.m14073(ConnectionModule.provideIllegalOperationHandler(this.suppressOperationCheckProvider.get().booleanValue(), this.loggingIllegalOperationHandlerProvider, this.throwingIllegalOperationHandlerProvider), "Cannot return null from a non-@Nullable @Provides method");
    }
}
