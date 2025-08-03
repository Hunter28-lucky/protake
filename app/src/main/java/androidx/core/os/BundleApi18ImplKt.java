package androidx.core.os;

import android.os.Bundle;
import android.os.IBinder;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import defpackage.C3921;

/* compiled from: Bundle.kt */
@RequiresApi(18)
/* loaded from: classes.dex */
final class BundleApi18ImplKt {
    public static final BundleApi18ImplKt INSTANCE = new BundleApi18ImplKt();

    private BundleApi18ImplKt() {
    }

    @DoNotInline
    public static final void putBinder(Bundle bundle, String str, IBinder iBinder) {
        C3921.m12666(bundle, "bundle");
        C3921.m12666(str, "key");
        bundle.putBinder(str, iBinder);
    }
}
