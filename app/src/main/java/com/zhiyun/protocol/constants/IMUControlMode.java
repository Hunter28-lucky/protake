package com.zhiyun.protocol.constants;

/* loaded from: classes2.dex */
public enum IMUControlMode {
    CLEAR,
    CAPTURE_1,
    CAPTURE_2,
    CAPTURE_3,
    CAPTURE_4,
    CAPTURE_5,
    CAPTURE_6,
    CALCULATION,
    CALIBRATION;

    private static final int CALCULATION_CODE = 7;
    private static final int CALIBRATION_CODE = 8;
    private static final int CAPTURE_1_CODE = 1;
    private static final int CAPTURE_2_CODE = 2;
    private static final int CAPTURE_3_CODE = 3;
    private static final int CAPTURE_4_CODE = 4;
    private static final int CAPTURE_5_CODE = 5;
    private static final int CAPTURE_6_CODE = 6;
    private static final int CLEAR_CODE = 0;

    /* renamed from: com.zhiyun.protocol.constants.IMUControlMode$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$zhiyun$protocol$constants$IMUControlMode;

        static {
            int[] iArr = new int[IMUControlMode.values().length];
            $SwitchMap$com$zhiyun$protocol$constants$IMUControlMode = iArr;
            try {
                iArr[IMUControlMode.CAPTURE_1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$zhiyun$protocol$constants$IMUControlMode[IMUControlMode.CAPTURE_2.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$zhiyun$protocol$constants$IMUControlMode[IMUControlMode.CAPTURE_3.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$zhiyun$protocol$constants$IMUControlMode[IMUControlMode.CAPTURE_4.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$zhiyun$protocol$constants$IMUControlMode[IMUControlMode.CAPTURE_5.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$zhiyun$protocol$constants$IMUControlMode[IMUControlMode.CAPTURE_6.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$zhiyun$protocol$constants$IMUControlMode[IMUControlMode.CALCULATION.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$zhiyun$protocol$constants$IMUControlMode[IMUControlMode.CALIBRATION.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$zhiyun$protocol$constants$IMUControlMode[IMUControlMode.CLEAR.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public static IMUControlMode from(int i) {
        switch (i) {
            case 1:
                return CAPTURE_1;
            case 2:
                return CAPTURE_2;
            case 3:
                return CAPTURE_3;
            case 4:
                return CAPTURE_4;
            case 5:
                return CAPTURE_5;
            case 6:
                return CAPTURE_6;
            case 7:
                return CALCULATION;
            case 8:
                return CALIBRATION;
            default:
                return CLEAR;
        }
    }

    public static int to(IMUControlMode iMUControlMode) {
        switch (AnonymousClass1.$SwitchMap$com$zhiyun$protocol$constants$IMUControlMode[iMUControlMode.ordinal()]) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 5;
            case 6:
                return 6;
            case 7:
                return 7;
            case 8:
                return 8;
            default:
                return 0;
        }
    }
}
