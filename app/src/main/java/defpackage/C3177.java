package defpackage;

import kotlin.Result;

/* compiled from: FastServiceLoader.kt */
/* renamed from: Գ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3177 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final boolean f11255;

    static {
        Object objM7211;
        try {
            Result.C2137 c2137 = Result.f7828;
            objM7211 = Result.m7211(Class.forName("android.os.Build"));
        } catch (Throwable th) {
            Result.C2137 c21372 = Result.f7828;
            objM7211 = Result.m7211(C4817.m14541(th));
        }
        f11255 = Result.m7216(objM7211);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final boolean m10785() {
        return f11255;
    }
}
