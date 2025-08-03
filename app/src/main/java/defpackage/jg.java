package defpackage;

import android.content.Context;

/* loaded from: classes.dex */
public class jg implements xc {
    @Override // defpackage.xc
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        boolean zM8130 = qf.m8130(context);
        ib.m6286("getOAID", "isSupported", Boolean.valueOf(zM8130));
        if (zM8130) {
            return qf.m8129(context);
        }
        return null;
    }
}
