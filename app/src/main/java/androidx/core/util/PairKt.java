package androidx.core.util;

import android.annotation.SuppressLint;
import defpackage.C3921;

/* compiled from: Pair.kt */
/* loaded from: classes.dex */
public final class PairKt {
    @SuppressLint({"UnknownNullness"})
    public static final <F, S> F component1(Pair<F, S> pair) {
        C3921.m12666(pair, "<this>");
        return pair.first;
    }

    @SuppressLint({"UnknownNullness"})
    public static final <F, S> S component2(Pair<F, S> pair) {
        C3921.m12666(pair, "<this>");
        return pair.second;
    }

    public static final <F, S> android.util.Pair<F, S> toAndroidPair(kotlin.Pair<? extends F, ? extends S> pair) {
        C3921.m12666(pair, "<this>");
        return new android.util.Pair<>(pair.m7209(), pair.m7210());
    }

    public static final <F, S> Pair<F, S> toAndroidXPair(kotlin.Pair<? extends F, ? extends S> pair) {
        C3921.m12666(pair, "<this>");
        return new Pair<>(pair.m7209(), pair.m7210());
    }

    public static final <F, S> kotlin.Pair<F, S> toKotlinPair(Pair<F, S> pair) {
        C3921.m12666(pair, "<this>");
        return new kotlin.Pair<>(pair.first, pair.second);
    }

    @SuppressLint({"UnknownNullness"})
    public static final <F, S> F component1(android.util.Pair<F, S> pair) {
        C3921.m12666(pair, "<this>");
        return (F) pair.first;
    }

    @SuppressLint({"UnknownNullness"})
    public static final <F, S> S component2(android.util.Pair<F, S> pair) {
        C3921.m12666(pair, "<this>");
        return (S) pair.second;
    }

    public static final <F, S> kotlin.Pair<F, S> toKotlinPair(android.util.Pair<F, S> pair) {
        C3921.m12666(pair, "<this>");
        return new kotlin.Pair<>(pair.first, pair.second);
    }
}
