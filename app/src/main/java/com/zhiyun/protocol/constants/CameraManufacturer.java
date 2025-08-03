package com.zhiyun.protocol.constants;

/* loaded from: classes2.dex */
public enum CameraManufacturer {
    CLOSE(0),
    CANON(1),
    SONY(2),
    PANASONIC(3),
    NIKON(4),
    CCS(5),
    FUJI(6),
    OLYMPUS(7),
    V_CANON(8),
    V_SONY(9),
    ZCAM(10),
    BMPCC(11),
    SIGMA(12);

    public final int value;

    CameraManufacturer(int i) {
        this.value = i;
    }

    public static CameraManufacturer from(int i) {
        for (CameraManufacturer cameraManufacturer : values()) {
            if (cameraManufacturer.value == i) {
                return cameraManufacturer;
            }
        }
        return CLOSE;
    }
}
