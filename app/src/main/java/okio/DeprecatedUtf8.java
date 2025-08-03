package okio;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import defpackage.C3921;

/* compiled from: -DeprecatedUtf8.kt */
/* renamed from: okio.-DeprecatedUtf8, reason: invalid class name */
/* loaded from: classes2.dex */
public final class DeprecatedUtf8 {
    public static final DeprecatedUtf8 INSTANCE = new DeprecatedUtf8();

    private DeprecatedUtf8() {
    }

    public final long size(String str) {
        C3921.m12667(str, TypedValues.Custom.S_STRING);
        return Utf8.size$default(str, 0, 0, 3, null);
    }

    public final long size(String str, int i, int i2) {
        C3921.m12667(str, TypedValues.Custom.S_STRING);
        return Utf8.size(str, i, i2);
    }
}
