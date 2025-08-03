package defpackage;

import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes.dex */
public class hf {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static InterfaceC4604 f6738;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static String m6202(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        return String.format("[%s][%s]", str, str2);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static void m6203(String str) {
        try {
            InterfaceC4604 interfaceC4604 = f6738;
            if (interfaceC4604 != null) {
                interfaceC4604.m14060(String.format("[AlipaySDK] %s %s", new SimpleDateFormat("hh:mm:ss.SSS", Locale.getDefault()).format(new Date()), str));
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static void m6204(String str, String str2, Throwable th) {
        m6203(m6202(str, str2) + MyUTIL.white_space + m6206(th));
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static void m6205(Throwable th) {
        if (th == null) {
            return;
        }
        try {
            m6203(m6206(th));
        } catch (Throwable unused) {
        }
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static String m6206(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static void m6207(String str, String str2) {
        m6203(m6202(str, str2));
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static void m6208(String str, String str2) {
        m6203(m6202(str, str2));
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static void m6209(String str, String str2) {
        m6203(m6202(str, str2));
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public static void m6210(String str, String str2) {
        m6203(m6202(str, str2));
    }
}
