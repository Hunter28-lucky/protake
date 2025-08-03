package defpackage;

import android.content.Context;

/* loaded from: classes.dex */
public class tf implements xc {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public boolean f8612 = false;

    @Override // defpackage.xc
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        if (!this.f8612) {
            z9.m8663(context);
            this.f8612 = true;
        }
        boolean zM8661 = z9.m8661();
        ib.m6286("getOAID", "isSupported", Boolean.valueOf(zM8661));
        if (zM8661) {
            return z9.m8662(context);
        }
        return null;
    }
}
