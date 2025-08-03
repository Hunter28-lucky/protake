package com.polidea.rxandroidble2.internal.logger;

import com.polidea.rxandroidble2.internal.util.CharacteristicPropertiesParser;
import defpackage.InterfaceC3628;
import defpackage.InterfaceC4461;

/* loaded from: classes2.dex */
public final class LoggerUtilBluetoothServices_Factory implements InterfaceC3628<LoggerUtilBluetoothServices> {
    private final InterfaceC4461<CharacteristicPropertiesParser> characteristicPropertiesParserProvider;

    public LoggerUtilBluetoothServices_Factory(InterfaceC4461<CharacteristicPropertiesParser> interfaceC4461) {
        this.characteristicPropertiesParserProvider = interfaceC4461;
    }

    public static LoggerUtilBluetoothServices_Factory create(InterfaceC4461<CharacteristicPropertiesParser> interfaceC4461) {
        return new LoggerUtilBluetoothServices_Factory(interfaceC4461);
    }

    public static LoggerUtilBluetoothServices newLoggerUtilBluetoothServices(CharacteristicPropertiesParser characteristicPropertiesParser) {
        return new LoggerUtilBluetoothServices(characteristicPropertiesParser);
    }

    @Override // defpackage.InterfaceC4461
    public LoggerUtilBluetoothServices get() {
        return new LoggerUtilBluetoothServices(this.characteristicPropertiesParserProvider.get());
    }
}
