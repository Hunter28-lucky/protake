package defpackage;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collection;

/* compiled from: Preconditions.java */
/* renamed from: ఔ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C4513 {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static void m13864(boolean z, @NonNull String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    @NonNull
    /* renamed from: Ԩ, reason: contains not printable characters */
    public static String m13865(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Must not be null or empty");
        }
        return str;
    }

    @NonNull
    /* renamed from: ԩ, reason: contains not printable characters */
    public static <T extends Collection<Y>, Y> T m13866(@NonNull T t) {
        if (t.isEmpty()) {
            throw new IllegalArgumentException("Must not be empty.");
        }
        return t;
    }

    @NonNull
    /* renamed from: Ԫ, reason: contains not printable characters */
    public static <T> T m13867(@Nullable T t) {
        return (T) m13868(t, "Argument must not be null");
    }

    @NonNull
    /* renamed from: ԫ, reason: contains not printable characters */
    public static <T> T m13868(@Nullable T t, @NonNull String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }
}
