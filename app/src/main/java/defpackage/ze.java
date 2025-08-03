package defpackage;

import android.content.Context;

/* loaded from: classes.dex */
public class ze implements xc {
    @Override // defpackage.xc
    public String a(Context context) throws NoSuchMethodException, SecurityException {
        if (context == null) {
            return null;
        }
        boolean zM8669 = zb.m8669();
        ib.m6286("getOAID", "isSupported", Boolean.valueOf(zM8669));
        if (zM8669) {
            return zb.m8670(context);
        }
        return null;
    }
}
