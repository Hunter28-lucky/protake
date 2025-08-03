package com.zhiyun.protocol.constants;

/* loaded from: classes2.dex */
public enum BoxWorkingMode {
    SALVE,
    HOST,
    UNCONNECTED;

    private static final int CODE_HOST = 1;
    private static final int CODE_SALVE = 0;
    private static final int CODE_UNCONNECTED = 2;

    /* renamed from: com.zhiyun.protocol.constants.BoxWorkingMode$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$zhiyun$protocol$constants$BoxWorkingMode;

        static {
            int[] iArr = new int[BoxWorkingMode.values().length];
            $SwitchMap$com$zhiyun$protocol$constants$BoxWorkingMode = iArr;
            try {
                iArr[BoxWorkingMode.SALVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$zhiyun$protocol$constants$BoxWorkingMode[BoxWorkingMode.UNCONNECTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$zhiyun$protocol$constants$BoxWorkingMode[BoxWorkingMode.HOST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static BoxWorkingMode from(int i) {
        return i != 0 ? i != 2 ? HOST : UNCONNECTED : SALVE;
    }

    public static int to(BoxWorkingMode boxWorkingMode) {
        int i = AnonymousClass1.$SwitchMap$com$zhiyun$protocol$constants$BoxWorkingMode[boxWorkingMode.ordinal()];
        if (i != 1) {
            return i != 2 ? 1 : 2;
        }
        return 0;
    }
}
