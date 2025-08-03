package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.widget.TextView;
import com.blink.academy.film.stream.FinderManager;
import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import java.io.IOException;
import java.util.Random;

/* loaded from: classes.dex */
public class ec {

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static volatile ec f6611;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public String f6612;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public String f6613 = "sdk-and-lite";

    /* renamed from: ԩ, reason: contains not printable characters */
    public String f6614;

    public ec() {
        String strM159 = ba.m159();
        if (ba.m161()) {
            return;
        }
        this.f6613 += '_' + strM159;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static String m6002(pa paVar, Context context, boolean z) {
        if (z) {
            return "00";
        }
        try {
            WifiInfo wifiInfoM8226 = sb.m8226(paVar, context);
            return wifiInfoM8226 != null ? wifiInfoM8226.getBSSID() : "00";
        } catch (Throwable th) {
            q9.m8087(paVar, "biz", "lacking_per_2", th);
            return "00";
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static String m6003(Context context) {
        return Float.toString(new TextView(context).getTextSize());
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static synchronized void m6004(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        PreferenceManager.getDefaultSharedPreferences(mc.m7550().m7554()).edit().putString("trideskey", str).apply();
        ea.f6608 = str;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static synchronized ec m6005() {
        if (f6611 == null) {
            f6611 = new ec();
        }
        return f6611;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static String m6006(pa paVar, Context context, boolean z) {
        if (z) {
            return FinderManager.MACHINE_NOT_VALID;
        }
        try {
            WifiInfo wifiInfoM8226 = sb.m8226(paVar, context);
            return wifiInfoM8226 != null ? wifiInfoM8226.getSSID() : FinderManager.MACHINE_NOT_VALID;
        } catch (Throwable th) {
            q9.m8087(paVar, "biz", "lacking_per_1", th);
            return FinderManager.MACHINE_NOT_VALID;
        }
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static String m6007(Context context) throws PackageManager.NameNotFoundException {
        if (context == null) {
            return "";
        }
        try {
            StringBuilder sb = new StringBuilder();
            String packageName = context.getPackageName();
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            sb.append("(");
            sb.append(packageName);
            sb.append(";");
            sb.append(packageInfo.versionCode);
            sb.append(")");
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static String m6008() {
        return Long.toHexString(System.currentTimeMillis()) + (new Random().nextInt(9000) + 1000);
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public static String m6009() {
        return "-1;-1";
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public static String m6010() {
        return "1";
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public static String m6011() {
        Context contextM7554 = mc.m7550().m7554();
        SharedPreferences sharedPreferences = contextM7554.getSharedPreferences("virtualImeiAndImsi", 0);
        String string = sharedPreferences.getString("virtual_imei", null);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        String strM6008 = TextUtils.isEmpty(qa.m8106(contextM7554).m8113()) ? m6008() : ld.m7499(contextM7554).m7502();
        sharedPreferences.edit().putString("virtual_imei", strM6008).apply();
        return strM6008;
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public static String m6012() {
        String strM7503;
        Context contextM7554 = mc.m7550().m7554();
        SharedPreferences sharedPreferences = contextM7554.getSharedPreferences("virtualImeiAndImsi", 0);
        String string = sharedPreferences.getString("virtual_imsi", null);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        if (TextUtils.isEmpty(qa.m8106(contextM7554).m8113())) {
            String strM7555 = mc.m7550().m7555();
            strM7503 = (TextUtils.isEmpty(strM7555) || strM7555.length() < 18) ? m6008() : strM7555.substring(3, 18);
        } else {
            strM7503 = ld.m7499(contextM7554).m7503();
        }
        String str = strM7503;
        sharedPreferences.edit().putString("virtual_imsi", str).apply();
        return str;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public String m6013(pa paVar, qa qaVar, boolean z) throws IOException {
        Context contextM7554 = mc.m7550().m7554();
        ld ldVarM7499 = ld.m7499(contextM7554);
        if (TextUtils.isEmpty(this.f6612)) {
            this.f6612 = "Msp/15.8.11 (" + ug.m8442() + ";" + ug.m8439() + ";" + ug.m8432(contextM7554) + ";" + ug.m8441(contextM7554) + ";" + ug.m8443(contextM7554) + ";" + m6003(contextM7554);
        }
        String strM344 = ld.m7501(contextM7554).m344();
        String strM8426 = ug.m8426(contextM7554);
        String strM6010 = m6010();
        String strM7503 = ldVarM7499.m7503();
        String strM7502 = ldVarM7499.m7502();
        String strM6012 = m6012();
        String strM6011 = m6011();
        if (qaVar != null) {
            this.f6614 = qaVar.m8112();
        }
        String strReplace = Build.MANUFACTURER.replace(";", MyUTIL.white_space);
        String strReplace2 = Build.MODEL.replace(";", MyUTIL.white_space);
        boolean zM7551 = mc.m7551();
        String strM7504 = ldVarM7499.m7504();
        String strM6006 = m6006(paVar, contextM7554, z);
        String strM6002 = m6002(paVar, contextM7554, z);
        StringBuilder sb = new StringBuilder();
        sb.append(this.f6612);
        sb.append(";");
        sb.append(strM344);
        sb.append(";");
        sb.append(strM8426);
        sb.append(";");
        sb.append(strM6010);
        sb.append(";");
        sb.append(strM7503);
        sb.append(";");
        sb.append(strM7502);
        sb.append(";");
        sb.append(this.f6614);
        sb.append(";");
        sb.append(strReplace);
        sb.append(";");
        sb.append(strReplace2);
        sb.append(";");
        sb.append(zM7551);
        sb.append(";");
        sb.append(strM7504);
        sb.append(";");
        sb.append(m6009());
        sb.append(";");
        sb.append(this.f6613);
        sb.append(";");
        sb.append(strM6012);
        sb.append(";");
        sb.append(strM6011);
        sb.append(";");
        sb.append(strM6006);
        sb.append(";");
        sb.append(strM6002);
        if (qaVar != null) {
            String strM8223 = sb.m8223(paVar, contextM7554, qa.m8106(contextM7554).m8113(), sb.m8225(paVar, contextM7554));
            if (!TextUtils.isEmpty(strM8223)) {
                sb.append(";;;");
                sb.append(strM8223);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
