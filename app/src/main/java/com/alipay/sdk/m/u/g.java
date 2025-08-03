package com.alipay.sdk.m.u;

import com.efs.sdk.base.Constants;

/* loaded from: classes.dex */
public enum g {
    WIFI(0, "WIFI"),
    NETWORK_TYPE_1(1, "unicom2G"),
    NETWORK_TYPE_2(2, "mobile2G"),
    NETWORK_TYPE_4(4, "telecom2G"),
    NETWORK_TYPE_5(5, "telecom3G"),
    NETWORK_TYPE_6(6, "telecom3G"),
    NETWORK_TYPE_12(12, "telecom3G"),
    NETWORK_TYPE_8(8, "unicom3G"),
    NETWORK_TYPE_3(3, "unicom3G"),
    NETWORK_TYPE_13(13, "LTE"),
    NETWORK_TYPE_11(11, "IDEN"),
    NETWORK_TYPE_9(9, "HSUPA"),
    NETWORK_TYPE_10(10, "HSPA"),
    NETWORK_TYPE_15(15, "HSPAP"),
    NETWORK_TYPE_20(20, "5G"),
    NONE(-1, Constants.CP_NONE);

    public int a;
    public String b;

    g(int i, String str) {
        this.a = i;
        this.b = str;
    }

    public static g a(int i) {
        for (g gVar : values()) {
            if (gVar.m343() == i) {
                return gVar;
            }
        }
        return NONE;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final int m343() {
        return this.a;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final String m344() {
        return this.b;
    }
}
