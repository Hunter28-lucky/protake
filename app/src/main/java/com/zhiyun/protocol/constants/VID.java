package com.zhiyun.protocol.constants;

/* loaded from: classes2.dex */
public enum VID {
    CANON,
    SONY,
    NIKON,
    GENERAL;

    private static final int CANON_CODE = 0;
    private static final int GENERAL_CODE = 3;
    private static final int NIKON_CODE = 2;
    private static final int SONY_CODE = 1;

    /* renamed from: com.zhiyun.protocol.constants.VID$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$zhiyun$protocol$constants$VID;

        static {
            int[] iArr = new int[VID.values().length];
            $SwitchMap$com$zhiyun$protocol$constants$VID = iArr;
            try {
                iArr[VID.CANON.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$zhiyun$protocol$constants$VID[VID.SONY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$zhiyun$protocol$constants$VID[VID.NIKON.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$zhiyun$protocol$constants$VID[VID.GENERAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static VID from(int i) {
        return i != 0 ? i != 1 ? i != 2 ? GENERAL : NIKON : SONY : CANON;
    }

    public static int to(VID vid) {
        int i = AnonymousClass1.$SwitchMap$com$zhiyun$protocol$constants$VID[vid.ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i != 2) {
            return i != 3 ? 3 : 2;
        }
        return 1;
    }
}
