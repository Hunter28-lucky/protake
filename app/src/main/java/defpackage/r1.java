package defpackage;

import java.util.Collection;
import java.util.Map;

/* compiled from: TextUtil.java */
/* loaded from: classes.dex */
public class r1 {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static boolean m8137(Object obj) {
        return !m8142(obj);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static boolean m8138(String str) {
        return !m8143(str);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static boolean m8139(Collection<?> collection) {
        return !m8144(collection);
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static boolean m8140(int i) {
        return i != 0 && i > 0;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static boolean m8141(CharSequence charSequence) {
        return charSequence != null && charSequence.length() > 0;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static boolean m8142(Object obj) {
        return obj != null;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static boolean m8143(String str) {
        return (str == null || "".equals(str.trim())) ? false : true;
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static boolean m8144(Collection<?> collection) {
        return collection != null && collection.size() > 0;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public static boolean m8145(Map<String, String> map) {
        return (map == null || map.isEmpty()) ? false : true;
    }
}
