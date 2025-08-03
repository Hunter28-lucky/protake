package com.mob.pushsdk.plugins.huawei;

import android.content.Context;
import com.mob.pushsdk.plugins.huawei.compat.PushHuaWeiCompat;

/* loaded from: classes2.dex */
public class c extends com.mob.pushsdk.plugins.a.a {
    private static final c a = new c();

    private c() {
    }

    public static c a() {
        return a;
    }

    @Override // com.mob.pushsdk.plugins.a.a
    public void doPluginRecevier(Context context, int i, Object obj) {
        if (i != 2) {
            return;
        }
        String str = (String) obj;
        com.mob.pushsdk.b.d.a().a("[HUAWEI] channel regId: " + str);
        bindPlugin(PushHuaWeiCompat.NAME, str);
    }
}
