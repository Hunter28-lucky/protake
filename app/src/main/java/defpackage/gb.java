package defpackage;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.mob.pushsdk.MobPush;

/* loaded from: classes.dex */
public class gb {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static xc m6086(Context context) {
        String str = Build.BRAND;
        ib.m6286("Device", "Brand", str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.equalsIgnoreCase(MobPush.Channels.HUAWEI) || str.equalsIgnoreCase("honor") || str.equalsIgnoreCase("华为")) {
            return new zc();
        }
        if (str.equalsIgnoreCase(MobPush.Channels.XIAOMI) || str.equalsIgnoreCase("redmi") || str.equalsIgnoreCase("meitu") || str.equalsIgnoreCase("小米") || str.equalsIgnoreCase("blackshark")) {
            return new mg();
        }
        if (str.equalsIgnoreCase(MobPush.Channels.VIVO)) {
            return new jg();
        }
        if (str.equalsIgnoreCase(MobPush.Channels.OPPO) || str.equalsIgnoreCase("oneplus") || str.equalsIgnoreCase("realme")) {
            return new tf();
        }
        if (str.equalsIgnoreCase("lenovo") || str.equalsIgnoreCase("zuk")) {
            return new xd();
        }
        if (str.equalsIgnoreCase("nubia")) {
            return new jf();
        }
        if (str.equalsIgnoreCase("samsung")) {
            return new dg();
        }
        if (m6088()) {
            return new zc();
        }
        if (str.equalsIgnoreCase(MobPush.Channels.MEIZU) || str.equalsIgnoreCase("mblu")) {
            return new ze();
        }
        return null;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static String m6087(String str) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class).invoke(null, str);
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static boolean m6088() {
        return (TextUtils.isEmpty(m6087("ro.build.version.emui")) && TextUtils.isEmpty(m6087("hw_sc.build.platform.version"))) ? false : true;
    }
}
