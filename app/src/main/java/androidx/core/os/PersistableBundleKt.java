package androidx.core.os;

import android.os.PersistableBundle;
import androidx.annotation.RequiresApi;
import defpackage.C3921;
import java.util.Map;
import kotlin.Pair;

/* compiled from: PersistableBundle.kt */
/* loaded from: classes.dex */
public final class PersistableBundleKt {
    @RequiresApi(21)
    public static final PersistableBundle persistableBundleOf(Pair<String, ? extends Object>... pairArr) {
        C3921.m12666(pairArr, "pairs");
        PersistableBundle persistableBundleCreatePersistableBundle = PersistableBundleApi21ImplKt.createPersistableBundle(pairArr.length);
        for (Pair<String, ? extends Object> pair : pairArr) {
            PersistableBundleApi21ImplKt.putValue(persistableBundleCreatePersistableBundle, pair.m7207(), pair.m7208());
        }
        return persistableBundleCreatePersistableBundle;
    }

    @RequiresApi(21)
    public static final PersistableBundle toPersistableBundle(Map<String, ? extends Object> map) {
        C3921.m12666(map, "<this>");
        PersistableBundle persistableBundleCreatePersistableBundle = PersistableBundleApi21ImplKt.createPersistableBundle(map.size());
        for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
            PersistableBundleApi21ImplKt.putValue(persistableBundleCreatePersistableBundle, entry.getKey(), entry.getValue());
        }
        return persistableBundleCreatePersistableBundle;
    }

    @RequiresApi(21)
    public static final PersistableBundle persistableBundleOf() {
        return PersistableBundleApi21ImplKt.createPersistableBundle(0);
    }
}
