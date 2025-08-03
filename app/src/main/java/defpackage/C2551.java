package defpackage;

import android.net.Uri;

/* compiled from: MediaStoreUtil.java */
/* renamed from: ȿ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C2551 {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static boolean m9391(Uri uri) {
        return m9392(uri) && !m9395(uri);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static boolean m9392(Uri uri) {
        return uri != null && "content".equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static boolean m9393(Uri uri) {
        return m9392(uri) && m9395(uri);
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static boolean m9394(int i, int i2) {
        return i != Integer.MIN_VALUE && i2 != Integer.MIN_VALUE && i <= 512 && i2 <= 384;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static boolean m9395(Uri uri) {
        return uri.getPathSegments().contains("video");
    }
}
