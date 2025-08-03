package com.zhiyun.protocol.constants;

/* loaded from: classes2.dex */
public enum Active {
    NONE(0),
    AES_SKIP(1),
    AES(2);

    public final int code;

    Active(int i) {
        this.code = i;
    }

    public static Active from(int i) {
        Active active = NONE;
        for (Active active2 : values()) {
            if (active2.code == i) {
                return active2;
            }
        }
        return active;
    }
}
