package defpackage;

import java.util.Arrays;
import kotlin.KotlinNullPointerException;
import kotlin.UninitializedPropertyAccessException;

/* compiled from: Intrinsics.java */
/* renamed from: ࡃ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C3921 {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static boolean m12662(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static void m12663(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw ((IllegalStateException) m12671(new IllegalStateException(str + " must not be null")));
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static void m12664(Object obj) {
        if (obj == null) {
            m12674();
        }
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static void m12665(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw ((NullPointerException) m12671(new NullPointerException(str + " must not be null")));
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static void m12666(Object obj, String str) {
        if (obj == null) {
            m12677(str);
        }
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static void m12667(Object obj, String str) {
        if (obj == null) {
            m12676(str);
        }
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static int m12668(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static String m12669(String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[4];
        return "Parameter specified as non-null is null: method " + stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + ", parameter " + str;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public static void m12670(int i, String str) {
        m12678();
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public static <T extends Throwable> T m12671(T t) {
        return (T) m12672(t, C3921.class.getName());
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public static <T extends Throwable> T m12672(T t, String str) {
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(stackTrace[i2].getClassName())) {
                i = i2;
            }
        }
        t.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i + 1, length));
        return t;
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public static String m12673(String str, Object obj) {
        return str + obj;
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public static void m12674() {
        throw ((NullPointerException) m12671(new NullPointerException()));
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public static void m12675() {
        throw ((KotlinNullPointerException) m12671(new KotlinNullPointerException()));
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public static void m12676(String str) {
        throw ((IllegalArgumentException) m12671(new IllegalArgumentException(m12669(str))));
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public static void m12677(String str) {
        throw ((NullPointerException) m12671(new NullPointerException(m12669(str))));
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public static void m12678() {
        m12679("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public static void m12679(String str) {
        throw new UnsupportedOperationException(str);
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public static void m12680(String str) {
        throw ((UninitializedPropertyAccessException) m12671(new UninitializedPropertyAccessException(str)));
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public static void m12681(String str) {
        m12680("lateinit property " + str + " has not been initialized");
    }
}
