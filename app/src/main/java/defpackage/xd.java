package defpackage;

import android.content.Context;

/* loaded from: classes.dex */
public class xd implements xc {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public rb f8742;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public boolean f8743 = false;

    /* renamed from: ԩ, reason: contains not printable characters */
    public boolean f8744 = false;

    @Override // defpackage.xc
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        if (!this.f8743) {
            rb rbVar = new rb();
            this.f8742 = rbVar;
            this.f8744 = rbVar.m8162(context, null) == 1;
            this.f8743 = true;
        }
        ib.m6286("getOAID", "isSupported", Boolean.valueOf(this.f8744));
        if (this.f8744 && this.f8742.m8166()) {
            return this.f8742.m8164();
        }
        return null;
    }
}
