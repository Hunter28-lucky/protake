package defpackage;

import com.alipay.sdk.m.j.c;

/* loaded from: classes.dex */
public class ac {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static boolean f25 = false;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static String f26;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static String m23() {
        c cVarB = c.b(c.CANCELED.m342());
        return m24(cVarB.m342(), cVarB.m341(), "");
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static String m24(int i, String str, String str2) {
        return "resultStatus={" + i + "};memo={" + str + "};result={" + str2 + "}";
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static void m25(String str) {
        f26 = str;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static void m26(boolean z) {
        f25 = z;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static String m27() {
        c cVarB = c.b(c.DOUBLE_REQUEST.m342());
        return m24(cVarB.m342(), cVarB.m341(), "");
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static boolean m28() {
        return f25;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static String m29() {
        return f26;
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static String m30() {
        c cVarB = c.b(c.PARAMS_ERROR.m342());
        return m24(cVarB.m342(), cVarB.m341(), "");
    }
}
