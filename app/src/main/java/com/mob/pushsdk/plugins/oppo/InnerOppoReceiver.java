package com.mob.pushsdk.plugins.oppo;

import android.content.Context;
import android.os.Bundle;
import com.mob.pushsdk.b.d;
import com.mob.pushsdk.plugins.a.a;

/* loaded from: classes2.dex */
public class InnerOppoReceiver extends a {
    private static final InnerOppoReceiver OPPO_RECEIVER = new InnerOppoReceiver();

    private InnerOppoReceiver() {
    }

    public static InnerOppoReceiver getInstance() {
        return OPPO_RECEIVER;
    }

    @Override // com.mob.pushsdk.plugins.a.a
    public void doPluginRecevier(Context context, int i, Object obj) {
        if (i == 2) {
            if (obj == null || !(obj instanceof String)) {
                return;
            }
            String str = (String) obj;
            d.a().a("[OPPO] channel regId: " + str);
            bindPlugin(PushOppo.NAME, str);
            return;
        }
        if (i == 4) {
            if (obj instanceof Integer) {
                Bundle bundle = new Bundle();
                bundle.putString("operation", "alias");
                bundle.putBoolean("result", ((Integer) obj).intValue() == 0);
                this.pushSDKImpl.b(bundle);
                return;
            }
            return;
        }
        if (i == 5 && (obj instanceof Integer)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("operation", "tags");
            bundle2.putBoolean("result", ((Integer) obj).intValue() == 0);
            this.pushSDKImpl.b(bundle2);
        }
    }
}
