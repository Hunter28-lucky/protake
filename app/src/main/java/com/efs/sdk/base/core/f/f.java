package com.efs.sdk.base.core.f;

import com.efs.sdk.base.core.controller.ControllerCenter;

/* loaded from: classes.dex */
public final class f {
    public c a;
    public ControllerCenter b;
    public d c;
    public g d;

    public static class a {
        private static final f a = new f(0);
    }

    public /* synthetic */ f(byte b) {
        this();
    }

    public final void a(String str, String str2, String str3) {
        this.d.a(str, str2, str3);
    }

    private f() {
        this.a = new c();
        this.c = new d();
        this.d = new g();
    }

    public final void a(int i) {
        ControllerCenter controllerCenter = this.b;
        if (controllerCenter != null) {
            controllerCenter.send(a("flow_limit", i));
        }
    }

    public final void a(int i, String str) {
        if (this.b != null || ControllerCenter.getGlobalEnvStruct().isEnableWaStat()) {
            b bVarA = a("flow_limit_type", i);
            bVarA.put("code", str);
            this.b.send(bVarA);
        }
    }

    public final b a(String str, int i) {
        b bVar = new b("efs_core", str, this.a.c);
        bVar.put("cver", Integer.valueOf(i));
        return bVar;
    }
}
