package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Map;

/* loaded from: classes.dex */
public final class sf {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static String m8239(Context context, String str, String str2, String str3) {
        return context.getSharedPreferences(str, 0).getString(str2, str3);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static void m8240(Context context, String str, Map<String, String> map) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(str, 0).edit();
        if (editorEdit != null) {
            for (String str2 : map.keySet()) {
                editorEdit.putString(str2, map.get(str2));
            }
            editorEdit.commit();
        }
    }
}
