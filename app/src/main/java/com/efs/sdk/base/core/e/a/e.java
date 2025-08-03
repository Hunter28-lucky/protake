package com.efs.sdk.base.core.e.a;

import com.efs.sdk.base.core.f.f;
import com.efs.sdk.base.http.HttpResponse;

/* loaded from: classes.dex */
public final class e extends a {
    @Override // com.efs.sdk.base.core.e.a.a
    public final void a(com.efs.sdk.base.core.d.b bVar) {
        HttpResponse httpResponseA;
        if (!bVar.b.a) {
            b(bVar);
            return;
        }
        com.efs.sdk.base.core.c.d dVarA = com.efs.sdk.base.core.c.d.a();
        if (!bVar.b.b || com.efs.sdk.base.core.c.b.a().a(bVar.a.a, bVar.a())) {
            f.a.a.c.b();
            f.a.a.c.c();
            httpResponseA = dVarA.b.a(bVar, false);
        } else {
            httpResponseA = new HttpResponse();
            httpResponseA.data = "flow_limit";
        }
        bVar.b.c = httpResponseA;
        b(bVar);
    }
}
