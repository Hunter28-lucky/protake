package com.polidea.rxandroidble2.internal.connection;

import com.polidea.rxandroidble2.internal.util.CharacteristicPropertiesParser;
import defpackage.C4618;
import defpackage.InterfaceC3628;

/* loaded from: classes2.dex */
public final class ConnectionModule_ProvideCharacteristicPropertiesParserFactory implements InterfaceC3628<CharacteristicPropertiesParser> {
    private static final ConnectionModule_ProvideCharacteristicPropertiesParserFactory INSTANCE = new ConnectionModule_ProvideCharacteristicPropertiesParserFactory();

    public static ConnectionModule_ProvideCharacteristicPropertiesParserFactory create() {
        return INSTANCE;
    }

    public static CharacteristicPropertiesParser proxyProvideCharacteristicPropertiesParser() {
        return (CharacteristicPropertiesParser) C4618.m14073(ConnectionModule.provideCharacteristicPropertiesParser(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // defpackage.InterfaceC4461
    public CharacteristicPropertiesParser get() {
        return (CharacteristicPropertiesParser) C4618.m14073(ConnectionModule.provideCharacteristicPropertiesParser(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
