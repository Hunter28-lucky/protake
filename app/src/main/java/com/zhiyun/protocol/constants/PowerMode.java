package com.zhiyun.protocol.constants;

/* loaded from: classes2.dex */
public enum PowerMode {
    ON,
    OFF;

    public static final int OFF_CODE = 0;
    public static final int ON_CODE = 1;

    /* renamed from: com.zhiyun.protocol.constants.PowerMode$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$zhiyun$protocol$constants$PowerMode;

        static {
            int[] iArr = new int[PowerMode.values().length];
            $SwitchMap$com$zhiyun$protocol$constants$PowerMode = iArr;
            try {
                iArr[PowerMode.ON.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$zhiyun$protocol$constants$PowerMode[PowerMode.OFF.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static PowerMode from(int i) {
        return i != 1 ? OFF : ON;
    }

    public static int to(PowerMode powerMode) {
        return AnonymousClass1.$SwitchMap$com$zhiyun$protocol$constants$PowerMode[powerMode.ordinal()] != 1 ? 0 : 1;
    }
}
