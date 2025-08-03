package com.efs.sdk.base.core.d;

import com.efs.sdk.base.Constants;

/* loaded from: classes.dex */
public final class a {
    public String a;
    public byte b;
    public int c = 0;
    public String d = Constants.CP_NONE;

    /* renamed from: e, reason: collision with root package name */
    public int f17646e = 1;
    public long f = 0;
    public int g = 1;

    public a(String str, byte b) {
        this.b = (byte) 2;
        this.a = str;
        if (b <= 0 || 3 < b) {
            throw new IllegalArgumentException("log protocol flag invalid : ".concat(String.valueOf((int) b)));
        }
        this.b = b;
    }
}
