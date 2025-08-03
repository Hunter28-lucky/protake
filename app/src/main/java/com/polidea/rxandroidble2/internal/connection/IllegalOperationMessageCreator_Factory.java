package com.polidea.rxandroidble2.internal.connection;

import com.polidea.rxandroidble2.internal.util.CharacteristicPropertiesParser;
import defpackage.InterfaceC3628;
import defpackage.InterfaceC4461;

/* loaded from: classes2.dex */
public final class IllegalOperationMessageCreator_Factory implements InterfaceC3628<IllegalOperationMessageCreator> {
    private final InterfaceC4461<CharacteristicPropertiesParser> propertiesParserProvider;

    public IllegalOperationMessageCreator_Factory(InterfaceC4461<CharacteristicPropertiesParser> interfaceC4461) {
        this.propertiesParserProvider = interfaceC4461;
    }

    public static IllegalOperationMessageCreator_Factory create(InterfaceC4461<CharacteristicPropertiesParser> interfaceC4461) {
        return new IllegalOperationMessageCreator_Factory(interfaceC4461);
    }

    @Override // defpackage.InterfaceC4461
    public IllegalOperationMessageCreator get() {
        return new IllegalOperationMessageCreator(this.propertiesParserProvider.get());
    }
}
