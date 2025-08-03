package defpackage;

import android.content.Context;

/* loaded from: classes2.dex */
public class ue {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static void m8394(Context context, boolean z) {
        context.getSharedPreferences("shared_msg_sdk", 0).edit().putBoolean("hasDefaultChannelCreated", z).commit();
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static boolean m8395(Context context) {
        return context.getSharedPreferences("shared_msg_sdk", 0).getBoolean("hasDefaultChannelCreated", false);
    }
}
