package com.zhiyun.protocol.constants;

/* loaded from: classes2.dex */
public enum WorkingMode {
    PF(0),
    L(1),
    F(2),
    POV(3),
    GO(4),
    THREE_DIMENSION(5);

    public final int code;

    WorkingMode(int i) {
        this.code = i;
    }

    public static WorkingMode from(int i) {
        WorkingMode workingMode = PF;
        for (WorkingMode workingMode2 : values()) {
            if (workingMode2.code == i) {
                return workingMode2;
            }
        }
        return workingMode;
    }
}
