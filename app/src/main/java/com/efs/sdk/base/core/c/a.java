package com.efs.sdk.base.core.c;

import androidx.annotation.NonNull;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.http.HttpResponse;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class a implements c {
    @Override // com.efs.sdk.base.core.c.c
    @NonNull
    public final HttpResponse a(com.efs.sdk.base.core.d.b bVar, boolean z) {
        HttpResponse httpResponseA;
        com.efs.sdk.base.core.a.c cVarA = com.efs.sdk.base.core.a.c.a();
        com.efs.sdk.base.core.d.a aVar = bVar.a;
        cVarA.d = aVar.d;
        cVarA.f17639e = aVar.f17646e;
        cVarA.g = aVar.b;
        cVarA.h = aVar.a;
        cVarA.m = bVar.a();
        String strA = com.efs.sdk.base.core.config.a.c.a().a(false);
        int i = bVar.a.c;
        if (i == 0) {
            com.efs.sdk.base.core.a.a aVarA = com.efs.sdk.base.core.a.a.a();
            byte[] bArr = bVar.c;
            boolean z2 = bVar.b.b;
            String strB = cVarA.b();
            String strA2 = com.efs.sdk.base.core.a.a.a(strA, cVarA);
            if (aVarA.a) {
                Log.i("efs.px.api", "upload buffer file, url is ".concat(String.valueOf(strA2)));
            }
            HashMap map = new HashMap(1);
            map.put("wpk-header", strB);
            com.efs.sdk.base.core.util.a.d dVarA = new com.efs.sdk.base.core.util.a.d(strA2).a(map);
            com.efs.sdk.base.core.util.a.b bVar2 = dVarA.a;
            bVar2.c = bArr;
            bVar2.g = true;
            com.efs.sdk.base.core.util.a.d dVarA2 = dVarA.a("type", cVarA.h);
            StringBuilder sb = new StringBuilder();
            sb.append(cVarA.m);
            httpResponseA = dVarA2.a("size", sb.toString()).a("flow_limit", Boolean.toString(z2)).a(com.efs.sdk.base.core.a.d.a()).a().b();
        } else {
            httpResponseA = 1 == i ? com.efs.sdk.base.core.a.a.a().a(strA, cVarA, bVar.d, bVar.b.b) : new HttpResponse();
        }
        if (httpResponseA.succ && z) {
            com.efs.sdk.base.core.util.b.b(bVar.d);
        }
        return httpResponseA;
    }
}
