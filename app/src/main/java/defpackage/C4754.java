package defpackage;

import io.jsonwebtoken.JwtParser;

/* compiled from: Ranges.kt */
/* renamed from: ൻ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C4754 {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final void m14294(boolean z, Number number) {
        C3921.m12666(number, "step");
        if (z) {
            return;
        }
        throw new IllegalArgumentException("Step must be positive, was: " + number + JwtParser.SEPARATOR_CHAR);
    }
}
