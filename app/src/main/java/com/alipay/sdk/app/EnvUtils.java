package com.alipay.sdk.app;

/* loaded from: classes.dex */
public class EnvUtils {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static EnvEnum f224 = EnvEnum.ONLINE;

    public enum EnvEnum {
        ONLINE,
        SANDBOX
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static boolean m315() {
        return f224 == EnvEnum.SANDBOX;
    }
}
