package defpackage;

import kotlinx.coroutines.CoroutineDispatcher;

/* compiled from: MainCoroutineDispatcher.kt */
/* renamed from: ߛ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public abstract class AbstractC3847 extends CoroutineDispatcher {
    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        String strM12262 = m12262();
        if (strM12262 != null) {
            return strM12262;
        }
        return C2316.m8690(this) + '@' + C2316.m8691(this);
    }

    /* renamed from: Ԭ */
    public abstract AbstractC3847 mo10951();

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final String m12262() {
        AbstractC3847 abstractC3847Mo10951;
        AbstractC3847 abstractC3847M10244 = C2888.m10244();
        if (this == abstractC3847M10244) {
            return "Dispatchers.Main";
        }
        try {
            abstractC3847Mo10951 = abstractC3847M10244.mo10951();
        } catch (UnsupportedOperationException unused) {
            abstractC3847Mo10951 = null;
        }
        if (this == abstractC3847Mo10951) {
            return "Dispatchers.Main.immediate";
        }
        return null;
    }
}
