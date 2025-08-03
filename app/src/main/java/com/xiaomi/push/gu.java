package com.xiaomi.push;

/* loaded from: classes2.dex */
public enum gu {
    RegIdExpired(0),
    PackageUnregistered(1),
    Init(2);


    /* renamed from: a, reason: collision with other field name */
    private final int f6049a;

    gu(int i) {
        this.f6049a = i;
    }

    public int a() {
        return this.f6049a;
    }

    public static gu a(int i) {
        if (i == 0) {
            return RegIdExpired;
        }
        if (i == 1) {
            return PackageUnregistered;
        }
        if (i != 2) {
            return null;
        }
        return Init;
    }
}
