package defpackage;

/* compiled from: HttpMethod.kt */
/* renamed from: ݟ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3737 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final C3737 f12943 = new C3737();

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final boolean m11969(String str) {
        C3921.m12667(str, "method");
        return (C3921.m12662(str, "GET") || C3921.m12662(str, "HEAD")) ? false : true;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final boolean m11970(String str) {
        C3921.m12667(str, "method");
        return C3921.m12662(str, "POST") || C3921.m12662(str, "PUT") || C3921.m12662(str, "PATCH") || C3921.m12662(str, "PROPPATCH") || C3921.m12662(str, "REPORT");
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final boolean m11971(String str) {
        C3921.m12667(str, "method");
        return C3921.m12662(str, "POST") || C3921.m12662(str, "PATCH") || C3921.m12662(str, "PUT") || C3921.m12662(str, "DELETE") || C3921.m12662(str, "MOVE");
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final boolean m11972(String str) {
        C3921.m12667(str, "method");
        return !C3921.m12662(str, "PROPFIND");
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final boolean m11973(String str) {
        C3921.m12667(str, "method");
        return C3921.m12662(str, "PROPFIND");
    }
}
