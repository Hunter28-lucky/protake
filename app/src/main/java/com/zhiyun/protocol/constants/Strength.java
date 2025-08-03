package com.zhiyun.protocol.constants;

/* loaded from: classes2.dex */
public enum Strength {
    LOW(0),
    MEDIUM(1),
    HIGH(2),
    N_CALIBRATION(3),
    N_CALIBRATED(4),
    N_LOW(5),
    N_MID_LOW(6),
    N_MEDIUM(7),
    N_MEDIUM_HIGH(8),
    N_HIGH(9),
    N_ULTRA(10);

    public final int value;

    Strength(int i) {
        this.value = i;
    }

    public static Strength from(int i) {
        Strength strength = LOW;
        for (Strength strength2 : values()) {
            if (strength2.value == i) {
                return strength2;
            }
        }
        return strength;
    }
}
