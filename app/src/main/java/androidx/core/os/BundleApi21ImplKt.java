package androidx.core.os;

import android.os.Bundle;
import android.util.Size;
import android.util.SizeF;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import defpackage.C3921;

/* compiled from: Bundle.kt */
@RequiresApi(21)
/* loaded from: classes.dex */
final class BundleApi21ImplKt {
    public static final BundleApi21ImplKt INSTANCE = new BundleApi21ImplKt();

    private BundleApi21ImplKt() {
    }

    @DoNotInline
    public static final void putSize(Bundle bundle, String str, Size size) {
        C3921.m12666(bundle, "bundle");
        C3921.m12666(str, "key");
        bundle.putSize(str, size);
    }

    @DoNotInline
    public static final void putSizeF(Bundle bundle, String str, SizeF sizeF) {
        C3921.m12666(bundle, "bundle");
        C3921.m12666(str, "key");
        bundle.putSizeF(str, sizeF);
    }
}
