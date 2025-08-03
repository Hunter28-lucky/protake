package com.efs.sdk.base.core.config;

import android.content.Context;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.NetworkUtil;

/* loaded from: classes.dex */
public final class b {
    public com.efs.sdk.base.core.config.a a;
    public Context b;

    public static class a {
        private static final b a = new b(0);
    }

    public /* synthetic */ b(byte b) {
        this();
    }

    public final String a() {
        return this.a.b("net", NetworkUtil.NETWORK_CLASS_DISCONNECTED).toString();
    }

    private b() {
        this.b = ControllerCenter.getGlobalEnvStruct().mAppContext;
    }
}
