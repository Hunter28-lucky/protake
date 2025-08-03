package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.analytics.pro.am;

/* loaded from: classes.dex */
public class ga {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public String f6648;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public SharedPreferences f6649;

    /* renamed from: ԩ, reason: contains not printable characters */
    public SharedPreferences.Editor f6650 = null;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public Context f6651;

    /* renamed from: ԫ, reason: contains not printable characters */
    public boolean f6652;

    public ga(Context context, String str, String str2, boolean z, boolean z2) {
        this.f6649 = null;
        this.f6652 = z2;
        this.f6648 = str2;
        this.f6651 = context;
        if (context != null) {
            this.f6649 = context.getSharedPreferences(str2, 0);
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public String m6081(String str) {
        SharedPreferences sharedPreferences = this.f6649;
        if (sharedPreferences != null) {
            String string = sharedPreferences.getString(str, "");
            if (!xf.m8613(string)) {
                return string;
            }
        }
        return "";
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m6082(String str, String str2) {
        if (xf.m8613(str) || str.equals(am.aI)) {
            return;
        }
        m6084();
        SharedPreferences.Editor editor = this.f6650;
        if (editor != null) {
            editor.putString(str, str2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0020  */
    /* renamed from: ԩ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m6083() {
        /*
            r5 = this;
            long r0 = java.lang.System.currentTimeMillis()
            android.content.SharedPreferences$Editor r2 = r5.f6650
            r3 = 0
            if (r2 == 0) goto L20
            boolean r4 = r5.f6652
            if (r4 != 0) goto L16
            android.content.SharedPreferences r4 = r5.f6649
            if (r4 == 0) goto L16
            java.lang.String r4 = "t"
            r2.putLong(r4, r0)
        L16:
            android.content.SharedPreferences$Editor r0 = r5.f6650
            boolean r0 = r0.commit()
            if (r0 != 0) goto L20
            r0 = r3
            goto L21
        L20:
            r0 = 1
        L21:
            android.content.SharedPreferences r1 = r5.f6649
            if (r1 == 0) goto L31
            android.content.Context r1 = r5.f6651
            if (r1 == 0) goto L31
            java.lang.String r2 = r5.f6648
            android.content.SharedPreferences r1 = r1.getSharedPreferences(r2, r3)
            r5.f6649 = r1
        L31:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ga.m6083():boolean");
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final void m6084() {
        SharedPreferences sharedPreferences;
        if (this.f6650 != null || (sharedPreferences = this.f6649) == null) {
            return;
        }
        this.f6650 = sharedPreferences.edit();
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public void m6085(String str) {
        if (xf.m8613(str) || str.equals(am.aI)) {
            return;
        }
        m6084();
        SharedPreferences.Editor editor = this.f6650;
        if (editor != null) {
            editor.remove(str);
        }
    }
}
