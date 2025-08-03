package androidx.core.os;

import android.os.PersistableBundle;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import defpackage.C3921;

/* compiled from: PersistableBundle.kt */
@RequiresApi(22)
/* loaded from: classes.dex */
final class PersistableBundleApi22ImplKt {
    public static final PersistableBundleApi22ImplKt INSTANCE = new PersistableBundleApi22ImplKt();

    private PersistableBundleApi22ImplKt() {
    }

    @DoNotInline
    public static final void putBoolean(PersistableBundle persistableBundle, String str, boolean z) {
        C3921.m12666(persistableBundle, "persistableBundle");
        persistableBundle.putBoolean(str, z);
    }

    @DoNotInline
    public static final void putBooleanArray(PersistableBundle persistableBundle, String str, boolean[] zArr) {
        C3921.m12666(persistableBundle, "persistableBundle");
        C3921.m12666(zArr, "value");
        persistableBundle.putBooleanArray(str, zArr);
    }
}
