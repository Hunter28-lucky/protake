package defpackage;

import android.content.Context;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.alipay.sdk.m.u.g;

/* loaded from: classes.dex */
public class ld {

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static ld f7955;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public String f7956;

    public ld(Context context) {
        try {
            try {
                String macAddress = sb.m8226(null, context).getMacAddress();
                this.f7956 = macAddress;
                if (!TextUtils.isEmpty(macAddress)) {
                    return;
                }
            } catch (Exception e2) {
                hf.m6205(e2);
                if (!TextUtils.isEmpty(this.f7956)) {
                    return;
                }
            }
            this.f7956 = "00:00:00:00:00:00";
        } catch (Throwable th) {
            if (TextUtils.isEmpty(this.f7956)) {
                this.f7956 = "00:00:00:00:00:00";
            }
            throw th;
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static ld m7499(Context context) {
        if (f7955 == null) {
            f7955 = new ld(context);
        }
        return f7955;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static String m7500(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return context.getResources().getConfiguration().locale.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static g m7501(Context context) {
        try {
            NetworkInfo networkInfoM8222 = sb.m8222(null, context);
            return (networkInfoM8222 == null || networkInfoM8222.getType() != 0) ? (networkInfoM8222 == null || networkInfoM8222.getType() != 1) ? g.NONE : g.WIFI : g.a(networkInfoM8222.getSubtype());
        } catch (Exception unused) {
            return g.NONE;
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public String m7502() {
        return "000000000000000";
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public String m7503() {
        return "000000000000000";
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public String m7504() {
        return this.f7956;
    }
}
