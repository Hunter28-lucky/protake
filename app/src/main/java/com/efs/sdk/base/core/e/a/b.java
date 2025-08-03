package com.efs.sdk.base.core.e.a;

import com.efs.sdk.base.core.b.a;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.f.f;

/* loaded from: classes.dex */
public final class b extends a {
    @Override // com.efs.sdk.base.core.e.a.a
    public final void a(com.efs.sdk.base.core.d.b bVar) {
        com.efs.sdk.base.core.b.e eVarA;
        byte[] bArr;
        if (bVar.b.a) {
            b(bVar);
            return;
        }
        com.efs.sdk.base.core.b.a aVar = a.b.a;
        if ("wa".equals(bVar.a.a) || com.efs.sdk.base.core.b.c.a().a) {
            com.efs.sdk.base.core.d.a aVar2 = bVar.a;
            if ((aVar2.c == 0 && ((bArr = bVar.c) == null || bArr.length == 0)) || (eVarA = aVar.c.a(aVar2.b)) == null) {
                return;
            }
            eVarA.a(bVar);
            return;
        }
        if (!aVar.a) {
            com.efs.sdk.base.core.f.f fVar = f.a.a;
            int i = com.efs.sdk.base.core.config.a.c.a().d.a;
            if (fVar.b != null || ControllerCenter.getGlobalEnvStruct().isEnableWaStat()) {
                fVar.b.send(fVar.a("disk_limit", i));
            }
        }
        aVar.a = true;
    }
}
