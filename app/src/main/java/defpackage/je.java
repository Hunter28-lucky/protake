package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import defpackage.p9;
import java.util.Collections;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class je {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static InterfaceC2125 f7750;

    /* renamed from: je$Ϳ, reason: contains not printable characters */
    public interface InterfaceC2125 {
        /* renamed from: Ϳ */
        void mo376(boolean z, JSONObject jSONObject, String str);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static boolean m7115(pa paVar, int i, int i2, Intent intent) {
        if (i != 1010 || intent == null) {
            return false;
        }
        InterfaceC2125 interfaceC2125 = f7750;
        if (interfaceC2125 == null) {
            return true;
        }
        f7750 = null;
        if (i2 == -1) {
            q9.m8086(paVar, "biz", "TbOk", intent.toUri(1));
            interfaceC2125.mo376(true, ug.m8416(intent), "OK");
        } else if (i2 != 0) {
            q9.m8091(paVar, "biz", "TbUnknown", "" + i2);
        } else {
            q9.m8086(paVar, "biz", "TbCancel", intent.toUri(1));
            interfaceC2125.mo376(false, null, "CANCELED");
        }
        return true;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static boolean m7116(pa paVar, Activity activity, int i, String str, String str2, InterfaceC2125 interfaceC2125) {
        try {
            q9.m8085(paVar, "biz", "TbStart");
            activity.startActivityForResult(new Intent(str2, Uri.parse(str)), i);
            f7750 = interfaceC2125;
            return true;
        } catch (Throwable th) {
            interfaceC2125.mo376(false, null, "UNKNOWN_ERROR");
            q9.m8087(paVar, "biz", "TbActFail", th);
            return false;
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static boolean m7117(pa paVar, Context context) {
        return ug.m8419(paVar, context, Collections.singletonList(new p9.C2226("com.taobao.taobao", 0, "")), false);
    }
}
