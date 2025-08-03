package defpackage;

import android.content.Context;

/* loaded from: classes.dex */
public class mg implements xc {
    @Override // defpackage.xc
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        boolean zM164 = bc.m164();
        ib.m6286("getOAID", "isSupported", Boolean.valueOf(zM164));
        if (zM164) {
            return bc.m165(context);
        }
        return null;
    }
}
