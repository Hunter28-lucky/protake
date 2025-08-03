package com.zhiyun.protocol.constants;

/* loaded from: classes2.dex */
public enum FunctionEvent {
    BACK_CENTER,
    BACK_HEAD;

    public static final int BACK_CENTER_CODE = 0;
    public static final int BACK_HEAD_CODE = 1;

    /* renamed from: com.zhiyun.protocol.constants.FunctionEvent$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$zhiyun$protocol$constants$FunctionEvent;

        static {
            int[] iArr = new int[FunctionEvent.values().length];
            $SwitchMap$com$zhiyun$protocol$constants$FunctionEvent = iArr;
            try {
                iArr[FunctionEvent.BACK_HEAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$zhiyun$protocol$constants$FunctionEvent[FunctionEvent.BACK_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static FunctionEvent from(int i) {
        return i != 1 ? BACK_CENTER : BACK_HEAD;
    }

    public static int to(FunctionEvent functionEvent) {
        return AnonymousClass1.$SwitchMap$com$zhiyun$protocol$constants$FunctionEvent[functionEvent.ordinal()] != 1 ? 0 : 1;
    }
}
