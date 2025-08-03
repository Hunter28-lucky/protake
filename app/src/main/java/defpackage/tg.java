package defpackage;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.app.EnvUtils;

/* loaded from: classes.dex */
public class tg {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static String m8326(Context context) {
        if (EnvUtils.m315()) {
            return "https://mobilegw.alipaydev.com/mgw.htm";
        }
        if (context == null) {
            return ea.f6607;
        }
        String str = ea.f6607;
        return TextUtils.isEmpty(str) ? ea.f6607 : str;
    }
}
