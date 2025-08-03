package com.zhiyun.protocol.constants;

/* loaded from: classes2.dex */
public enum ParamType {
    APERTURE,
    SHUTTER,
    ISO,
    EV;

    private static final int AV_CODE = 0;
    private static final int EV_CODE = 3;
    private static final int ISO_CODE = 2;
    private static final int TV_CODE = 1;

    /* renamed from: com.zhiyun.protocol.constants.ParamType$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$zhiyun$protocol$constants$ParamType;

        static {
            int[] iArr = new int[ParamType.values().length];
            $SwitchMap$com$zhiyun$protocol$constants$ParamType = iArr;
            try {
                iArr[ParamType.APERTURE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$zhiyun$protocol$constants$ParamType[ParamType.SHUTTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$zhiyun$protocol$constants$ParamType[ParamType.ISO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$zhiyun$protocol$constants$ParamType[ParamType.EV.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static ParamType from(int i) {
        return i != 0 ? i != 1 ? i != 2 ? EV : ISO : SHUTTER : APERTURE;
    }

    public static int to(ParamType paramType) {
        int i = AnonymousClass1.$SwitchMap$com$zhiyun$protocol$constants$ParamType[paramType.ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i != 2) {
            return i != 3 ? 3 : 2;
        }
        return 1;
    }
}
