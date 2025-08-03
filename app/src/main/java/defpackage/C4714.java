package defpackage;

import io.jsonwebtoken.JwtParser;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: PlatformImplementations.kt */
/* renamed from: ഡ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4714 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final C4104 f15980;

    static {
        C4104 c4104;
        int iM14252 = m14252();
        if (iM14252 >= 65544 || iM14252 < 65536) {
            try {
                Object objNewInstance = C3170.class.newInstance();
                C3921.m12665(objNewInstance, "forName(\"kotlin.internal…entations\").newInstance()");
                try {
                    try {
                        if (objNewInstance == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                        }
                        c4104 = (C4104) objNewInstance;
                    } catch (ClassNotFoundException unused) {
                    }
                } catch (ClassCastException e2) {
                    ClassLoader classLoader = objNewInstance.getClass().getClassLoader();
                    ClassLoader classLoader2 = C4104.class.getClassLoader();
                    if (C3921.m12662(classLoader, classLoader2)) {
                        throw e2;
                    }
                    throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader + ", base type classloader: " + classLoader2, e2);
                }
            } catch (ClassNotFoundException unused2) {
                Object objNewInstance2 = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
                C3921.m12665(objNewInstance2, "forName(\"kotlin.internal…entations\").newInstance()");
                try {
                    if (objNewInstance2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    }
                    c4104 = (C4104) objNewInstance2;
                } catch (ClassCastException e3) {
                    ClassLoader classLoader3 = objNewInstance2.getClass().getClassLoader();
                    ClassLoader classLoader4 = C4104.class.getClassLoader();
                    if (C3921.m12662(classLoader3, classLoader4)) {
                        throw e3;
                    }
                    throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader3 + ", base type classloader: " + classLoader4, e3);
                }
            }
        } else if (iM14252 >= 65543 || iM14252 < 65536) {
            try {
                try {
                    Object objNewInstance3 = C3514.class.newInstance();
                    C3921.m12665(objNewInstance3, "forName(\"kotlin.internal…entations\").newInstance()");
                    try {
                        if (objNewInstance3 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                        }
                        c4104 = (C4104) objNewInstance3;
                    } catch (ClassCastException e4) {
                        ClassLoader classLoader5 = objNewInstance3.getClass().getClassLoader();
                        ClassLoader classLoader6 = C4104.class.getClassLoader();
                        if (C3921.m12662(classLoader5, classLoader6)) {
                            throw e4;
                        }
                        throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader5 + ", base type classloader: " + classLoader6, e4);
                    }
                } catch (ClassNotFoundException unused3) {
                }
            } catch (ClassNotFoundException unused4) {
                Object objNewInstance4 = Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();
                C3921.m12665(objNewInstance4, "forName(\"kotlin.internal…entations\").newInstance()");
                try {
                    if (objNewInstance4 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    }
                    c4104 = (C4104) objNewInstance4;
                } catch (ClassCastException e5) {
                    ClassLoader classLoader7 = objNewInstance4.getClass().getClassLoader();
                    ClassLoader classLoader8 = C4104.class.getClassLoader();
                    if (C3921.m12662(classLoader7, classLoader8)) {
                        throw e5;
                    }
                    throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader7 + ", base type classloader: " + classLoader8, e5);
                }
            }
        } else {
            c4104 = new C4104();
        }
        f15980 = c4104;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final int m14252() {
        String property = System.getProperty("java.specification.version");
        if (property == null) {
            return 65542;
        }
        int iM7285 = StringsKt__StringsKt.m7285(property, JwtParser.SEPARATOR_CHAR, 0, false, 6, null);
        if (iM7285 < 0) {
            try {
                return Integer.parseInt(property) * 65536;
            } catch (NumberFormatException unused) {
                return 65542;
            }
        }
        int i = iM7285 + 1;
        int iM72852 = StringsKt__StringsKt.m7285(property, JwtParser.SEPARATOR_CHAR, i, false, 4, null);
        if (iM72852 < 0) {
            iM72852 = property.length();
        }
        String strSubstring = property.substring(0, iM7285);
        C3921.m12665(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        String strSubstring2 = property.substring(i, iM72852);
        C3921.m12665(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
        try {
            return (Integer.parseInt(strSubstring) * 65536) + Integer.parseInt(strSubstring2);
        } catch (NumberFormatException unused2) {
            return 65542;
        }
    }
}
