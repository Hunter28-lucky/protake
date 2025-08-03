package defpackage;

import android.util.Log;

/* compiled from: LogUtil.java */
/* renamed from: ಬ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4638 implements InterfaceC2469 {

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static boolean f15770 = true;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static void m14097() {
        m14106(2, null, "execute");
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static void m14098(Object obj) {
        m14106(2, null, obj);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static void m14099(String str, Object obj) {
        m14106(2, str, obj);
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static void m14100(Object obj) {
        m14106(5, null, obj);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static void m14101(String str, Object obj) {
        m14106(5, str, obj);
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static void m14102(String str, String str2, Throwable th) {
        Log.e(str, str2, th);
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static void m14103(Object obj) {
        m14106(3, null, obj);
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static void m14104(String str, Object obj) {
        m14106(3, str, obj);
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public static void m14105(boolean z) {
        f15770 = z;
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public static void m14106(int i, String str, Object obj) {
        if (f15770) {
            String[] strArrM14109 = m14109(str, obj);
            String str2 = strArrM14109[0];
            String str3 = strArrM14109[1];
            String str4 = strArrM14109[2];
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    C5164.m15091(i, str2, str4 + str3);
                    break;
                case 7:
                    C2967.m10379(str2, str3, str4);
                    break;
                case 8:
                    a9.m17(str2, str3, str4);
                    break;
            }
        }
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public static void m14107(String str, String str2) {
        m14106(1, str, str2);
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public static void m14108(String str, Object obj) {
        m14106(4, str, obj);
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public static String[] m14109(String str, Object obj) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String fileName = stackTrace[5].getFileName();
        String methodName = stackTrace[5].getMethodName();
        int lineNumber = stackTrace[5].getLineNumber();
        String str2 = methodName.substring(0, 1).toUpperCase() + methodName.substring(1);
        if (str == null) {
            str = fileName;
        }
        return new String[]{str, obj == null ? "Log with null object" : obj.toString(), String.format("[ # (%1$s:%2$s) # %3$s ] ", fileName, Integer.valueOf(lineNumber), str2)};
    }
}
