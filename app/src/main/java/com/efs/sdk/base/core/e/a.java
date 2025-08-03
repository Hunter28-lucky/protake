package com.efs.sdk.base.core.e;

import com.efs.sdk.base.core.util.Log;

/* loaded from: classes.dex */
public abstract class a {
    private com.efs.sdk.base.core.e.a.a a;

    public abstract com.efs.sdk.base.core.e.a.a a();

    public final void a(com.efs.sdk.base.core.d.b bVar) {
        try {
            if (this.a == null) {
                synchronized (this) {
                    if (this.a == null) {
                        com.efs.sdk.base.core.e.a.a aVarA = a();
                        this.a = aVarA;
                        if (aVarA == null) {
                            return;
                        }
                    }
                }
            }
            this.a.a(bVar);
        } catch (Throwable th) {
            Log.e("efs.processor", "log handle error", th);
        }
    }
}
