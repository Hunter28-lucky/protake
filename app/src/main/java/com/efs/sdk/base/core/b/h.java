package com.efs.sdk.base.core.b;

import com.efs.sdk.base.core.b.a;
import java.io.File;

/* loaded from: classes.dex */
public final class h implements f {
    @Override // com.efs.sdk.base.core.b.f
    public final boolean a(File file) {
        com.efs.sdk.base.core.d.b bVarB = com.efs.sdk.base.core.util.b.b(file.getName());
        if (bVarB != null) {
            return ("wa".equals(bVarB.a.a) || com.efs.sdk.base.core.c.b.a().a(bVarB.a.a, file.length())) ? false : true;
        }
        a unused = a.b.a;
        a.b(file);
        return true;
    }
}
