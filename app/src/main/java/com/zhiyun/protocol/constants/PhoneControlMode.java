package com.zhiyun.protocol.constants;

/* loaded from: classes2.dex */
public enum PhoneControlMode {
    END,
    BEGIN;

    private static final int BEGIN_COIDE = 1;
    private static final int END_COIDE = 0;

    /* renamed from: com.zhiyun.protocol.constants.PhoneControlMode$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$zhiyun$protocol$constants$PhoneControlMode;

        static {
            int[] iArr = new int[PhoneControlMode.values().length];
            $SwitchMap$com$zhiyun$protocol$constants$PhoneControlMode = iArr;
            try {
                iArr[PhoneControlMode.BEGIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$zhiyun$protocol$constants$PhoneControlMode[PhoneControlMode.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static PhoneControlMode from(int i) {
        return i != 1 ? END : BEGIN;
    }

    public static int to(PhoneControlMode phoneControlMode) {
        return AnonymousClass1.$SwitchMap$com$zhiyun$protocol$constants$PhoneControlMode[phoneControlMode.ordinal()] != 1 ? 0 : 1;
    }
}
