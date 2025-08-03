package com.zhiyun.protocol.constants;

/* loaded from: classes2.dex */
public enum ExpandInterface {
    CLOSED,
    GENERAL,
    SONY,
    PANASONIC;

    private static final int CLOSED_CODE = 0;
    private static final int GENERAL_CODE = 1;
    private static final int PANASONIC_CODE = 3;
    private static final int SONY_CODE = 2;

    /* renamed from: com.zhiyun.protocol.constants.ExpandInterface$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$zhiyun$protocol$constants$ExpandInterface;

        static {
            int[] iArr = new int[ExpandInterface.values().length];
            $SwitchMap$com$zhiyun$protocol$constants$ExpandInterface = iArr;
            try {
                iArr[ExpandInterface.CLOSED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$zhiyun$protocol$constants$ExpandInterface[ExpandInterface.GENERAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$zhiyun$protocol$constants$ExpandInterface[ExpandInterface.SONY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$zhiyun$protocol$constants$ExpandInterface[ExpandInterface.PANASONIC.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static ExpandInterface from(int i) {
        return i != 0 ? i != 1 ? i != 2 ? PANASONIC : SONY : GENERAL : CLOSED;
    }

    public static int to(ExpandInterface expandInterface) {
        int i = AnonymousClass1.$SwitchMap$com$zhiyun$protocol$constants$ExpandInterface[expandInterface.ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i != 2) {
            return i != 3 ? 3 : 2;
        }
        return 1;
    }
}
