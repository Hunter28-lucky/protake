package com.efs.sdk.base.core.e.a;

import com.efs.sdk.base.Constants;
import com.efs.sdk.base.core.util.Log;
import java.io.IOException;

/* loaded from: classes.dex */
public final class c extends a {
    private static boolean c(com.efs.sdk.base.core.d.b bVar) {
        if (!bVar.b()) {
            com.efs.sdk.base.core.d.a aVar = bVar.a;
            if ((1 != aVar.b || bVar.b.a) && 1 != aVar.c) {
                return false;
            }
        }
        return true;
    }

    @Override // com.efs.sdk.base.core.e.a.a
    public final void a(com.efs.sdk.base.core.d.b bVar) throws IOException {
        if (c(bVar)) {
            b(bVar);
            return;
        }
        byte[] bArrA = com.efs.sdk.base.core.util.c.a(bVar.c);
        if (bArrA == null) {
            Log.w("efs.base", "gzip error");
            b(bVar);
        } else {
            bVar.a(bArrA);
            bVar.a(Constants.CP_GZIP);
            b(bVar);
        }
    }
}
