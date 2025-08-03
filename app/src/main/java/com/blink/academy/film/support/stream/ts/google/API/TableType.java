package com.blink.academy.film.support.stream.ts.google.API;

import androidx.core.view.InputDeviceCompat;
import com.blink.academy.film.support.stream.ts.TsConstants;
import com.polidea.rxandroidble2.RxBleConnection;

/* loaded from: classes.dex */
public enum TableType {
    Terrestrial_VCT_with_current_next_indicator_1(0),
    Terrestrial_VCT_with_current_next_indicator_0(1),
    Cable_VCT_with_current_next_indicator_1(2),
    Cable_VCT_with_current_next_indicator_0(3),
    Channel_ETT(4),
    DCCSCT(5),
    EIT0(256),
    EIT1(257),
    EIT2(TsConstants.kTS_PID_Data),
    EIT3(259),
    EIT4(260),
    EIT5(261),
    EIT6(262),
    EIT7(263),
    EIT8(264),
    ETT0(512),
    ETT1(InputDeviceCompat.SOURCE_DPAD),
    ETT2(514),
    ETT3(515),
    ETT4(516),
    ETT5(RxBleConnection.GATT_MTU_MAXIMUM),
    ETT6(518),
    ETT7(519),
    ETT8(520);

    private int value;

    TableType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
