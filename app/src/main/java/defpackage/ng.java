package defpackage;

import android.content.Context;
import android.preference.PreferenceManager;
import android.text.TextUtils;

/* loaded from: classes.dex */
public class ng {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static String f8071;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static synchronized String m7657(pa paVar, Context context, String str, String str2) {
        String strM7653;
        try {
            String string = PreferenceManager.getDefaultSharedPreferences(context).getString(str, str2);
            strM7653 = TextUtils.isEmpty(string) ? null : nf.m7653(m7658(context), string, str);
            if (!TextUtils.isEmpty(string) && TextUtils.isEmpty(strM7653)) {
                q9.m8091(paVar, "cp", "TriDesEncryptError", String.format("%s,%s", str, string));
            }
        } catch (Exception e2) {
            hf.m6205(e2);
        }
        return strM7653;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static String m7658(Context context) {
        String packageName;
        if (TextUtils.isEmpty(f8071)) {
            try {
                packageName = context.getApplicationContext().getPackageName();
            } catch (Throwable th) {
                hf.m6205(th);
                packageName = "";
            }
            f8071 = (packageName + "0000000000000000000000000000").substring(0, 24);
        }
        return f8071;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static synchronized void m7659(pa paVar, Context context, String str, String str2) {
        try {
            String strM7655 = nf.m7655(m7658(context), str2, str);
            if (!TextUtils.isEmpty(str2) && TextUtils.isEmpty(strM7655)) {
                q9.m8091(paVar, "cp", "TriDesDecryptError", String.format("%s,%s", str, str2));
            }
            PreferenceManager.getDefaultSharedPreferences(context).edit().putString(str, strM7655).apply();
        } catch (Throwable th) {
            hf.m6205(th);
        }
    }
}
