package com.alipay.android.phone.mrpc.core;

import java.lang.reflect.Method;

/* loaded from: classes.dex */
public abstract class a implements v {
    public Method a;
    public byte[] b;
    public String c;
    public int d;

    /* renamed from: e, reason: collision with root package name */
    public String f17625e;
    public boolean f;

    public a(Method method, int i, String str, byte[] bArr, String str2, boolean z) {
        this.a = method;
        this.d = i;
        this.c = str;
        this.b = bArr;
        this.f17625e = str2;
        this.f = z;
    }
}
