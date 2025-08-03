package defpackage;

import android.text.TextUtils;
import android.util.Log;

/* compiled from: BaseLog.java */
/* renamed from: ၮ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C5164 implements InterfaceC2469 {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static boolean m15090(String str) {
        return TextUtils.isEmpty(str) || str.equals("\n") || str.equals("\t") || TextUtils.isEmpty(str.trim());
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static void m15091(int i, String str, String str2) {
        switch (i) {
            case 1:
                Log.v(str, str2);
                break;
            case 2:
                Log.d(str, str2);
                break;
            case 3:
                Log.i(str, str2);
                break;
            case 4:
                Log.w(str, str2);
                break;
            case 5:
                Log.e(str, str2);
                break;
            case 6:
                Log.wtf(str, str2);
                break;
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static void m15092(String str, boolean z) {
        if (z) {
            Log.d(str, "╔═══════════════════════════════════════════════════════════════════════════════════════");
        } else {
            Log.d(str, "╚═══════════════════════════════════════════════════════════════════════════════════════");
        }
    }
}
