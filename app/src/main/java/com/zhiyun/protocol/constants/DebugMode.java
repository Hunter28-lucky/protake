package com.zhiyun.protocol.constants;

/* loaded from: classes2.dex */
public enum DebugMode {
    NORMAL,
    SUB_POWER,
    IMU_DEBUG,
    IMU_COMPENSATE;

    private static final int IMU_COMPENSATE_CODE = 3;
    private static final int IMU_DEBUG_CODE = 2;
    private static final int NORMAL_CODE = 0;
    private static final int SUB_POWER_CODE = 1;

    /* renamed from: com.zhiyun.protocol.constants.DebugMode$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$zhiyun$protocol$constants$DebugMode;

        static {
            int[] iArr = new int[DebugMode.values().length];
            $SwitchMap$com$zhiyun$protocol$constants$DebugMode = iArr;
            try {
                iArr[DebugMode.SUB_POWER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$zhiyun$protocol$constants$DebugMode[DebugMode.IMU_DEBUG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$zhiyun$protocol$constants$DebugMode[DebugMode.IMU_COMPENSATE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$zhiyun$protocol$constants$DebugMode[DebugMode.NORMAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static DebugMode from(int i) {
        return i != 1 ? i != 2 ? i != 3 ? NORMAL : IMU_COMPENSATE : IMU_DEBUG : SUB_POWER;
    }

    public static int to(DebugMode debugMode) {
        int i = AnonymousClass1.$SwitchMap$com$zhiyun$protocol$constants$DebugMode[debugMode.ordinal()];
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                i2 = 3;
                if (i != 3) {
                    return 0;
                }
            }
        }
        return i2;
    }
}
