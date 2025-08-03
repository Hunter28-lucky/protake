package com.tencent.mm.opensdk.diffdev.a;

import androidx.constraintlayout.core.motion.utils.TypedValues;

/* loaded from: classes2.dex */
public enum d {
    UUID_EXPIRED(TypedValues.CycleType.TYPE_VISIBILITY),
    UUID_CANCELED(TypedValues.CycleType.TYPE_ALPHA),
    UUID_SCANED(404),
    UUID_CONFIRM(405),
    UUID_KEEP_CONNECT(408),
    UUID_ERROR(500);

    private int a;

    d(int i) {
        this.a = i;
    }

    public int a() {
        return this.a;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "UUIDStatusCode:" + this.a;
    }
}
