package defpackage;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.Looper;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.alipay.sdk.app.EnvUtils;
import com.alipay.sdk.m.j.c;
import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import com.umeng.analytics.pro.cb;
import com.xiaomi.mipush.sdk.Constants;
import defpackage.p9;
import io.michaelrocks.libphonenumber.android.PhoneNumberUtil;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ug {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final String[] f8650 = {"10.1.5.1013151", "10.1.5.1013148"};

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final char[] f8651 = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', PhoneNumberUtil.PLUS_SIGN, '/'};

    /* renamed from: ug$Ϳ, reason: contains not printable characters */
    public static class RunnableC2296 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ Activity f8652;

        public RunnableC2296(Activity activity) {
            this.f8652 = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f8652.finish();
        }
    }

    /* renamed from: ug$Ԩ, reason: contains not printable characters */
    public static class RunnableC2297 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ Runnable f8653;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ ConditionVariable f8654;

        public RunnableC2297(Runnable runnable, ConditionVariable conditionVariable) {
            this.f8653 = runnable;
            this.f8654 = conditionVariable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f8653.run();
            } finally {
                this.f8654.open();
            }
        }
    }

    /* renamed from: ug$Ԫ, reason: contains not printable characters */
    public static final class C2298 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final PackageInfo f8655;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final int f8656;

        /* renamed from: ԩ, reason: contains not printable characters */
        public final String f8657;

        public C2298(PackageInfo packageInfo, int i, String str) {
            this.f8655 = packageInfo;
            this.f8656 = i;
            this.f8657 = str;
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public boolean m8453() {
            return this.f8655.versionCode < this.f8656;
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public boolean m8454(pa paVar) {
            Signature[] signatureArr = this.f8655.signatures;
            if (signatureArr == null || signatureArr.length == 0) {
                return false;
            }
            for (Signature signature : signatureArr) {
                String strM8407 = ug.m8407(paVar, signature.toByteArray());
                if (strM8407 != null && !TextUtils.equals(strM8407, this.f8657)) {
                    q9.m8091(paVar, "biz", "PublicKeyUnmatch", String.format("Got %s, expected %s", strM8407, this.f8657));
                    return true;
                }
            }
            return false;
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static int m8398() {
        String strM7555 = mc.m7550().m7555();
        if (TextUtils.isEmpty(strM7555)) {
            return -1;
        }
        String strReplaceAll = strM7555.replaceAll("=", "");
        if (strReplaceAll.length() >= 5) {
            strReplaceAll = strReplaceAll.substring(0, 5);
        }
        int iM8399 = (int) (m8399(strReplaceAll) % 10000);
        return iM8399 < 0 ? iM8399 * (-1) : iM8399;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static long m8399(String str) {
        return m8400(str, 6);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static long m8400(String str, int i) {
        int iPow = (int) Math.pow(2.0d, i);
        int length = str.length();
        long j = 0;
        int i2 = length;
        for (int i3 = 0; i3 < length; i3++) {
            j += Integer.parseInt(String.valueOf(m8434(str.substring(i3, r5)))) * ((long) Math.pow(iPow, i2 - 1));
            i2--;
        }
        return j;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static ActivityInfo m8401(Context context) {
        try {
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                for (ActivityInfo activityInfo : context.getPackageManager().getPackageInfo(context.getPackageName(), 1).activities) {
                    if (TextUtils.equals(activityInfo.name, activity.getClass().getName())) {
                        return activityInfo;
                    }
                }
            }
            return null;
        } catch (Throwable th) {
            hf.m6205(th);
            return null;
        }
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static PackageInfo m8402(Context context, String str) throws PackageManager.NameNotFoundException {
        return context.getPackageManager().getPackageInfo(str, 192);
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static <T> T m8403(WeakReference<T> weakReference) {
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static String m8404(int i) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            int iNextInt = random.nextInt(3);
            if (iNextInt == 0) {
                sb.append(String.valueOf((char) Math.round((Math.random() * 25.0d) + 65.0d)));
            } else if (iNextInt == 1) {
                sb.append(String.valueOf((char) Math.round((Math.random() * 25.0d) + 97.0d)));
            } else if (iNextInt == 2) {
                sb.append(String.valueOf(new Random().nextInt(10)));
            }
        }
        return sb.toString();
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static String m8405(pa paVar) {
        return m8431(paVar, "ro.build.fingerprint");
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public static String m8406(pa paVar, Context context) {
        try {
            String strM7657 = ng.m7657(paVar, context, "alipay_cashier_ap_fi", "");
            if (!TextUtils.isEmpty(strM7657)) {
                return strM7657;
            }
            try {
                ng.m7659(paVar, context, "alipay_cashier_ap_fi", y9.m8629("FU", System.currentTimeMillis(), new ef(), (short) 0, new vf()).m8523());
                String strM76572 = ng.m7657(paVar, context, "alipay_cashier_ap_fi", "");
                if (!TextUtils.isEmpty(strM76572)) {
                    return strM76572;
                }
                q9.m8091(paVar, "biz", "e_regen_empty", "");
                return "";
            } catch (Exception e2) {
                q9.m8091(paVar, "biz", "e_gen", e2.getClass().getSimpleName());
                return "";
            }
        } catch (Exception e3) {
            q9.m8087(paVar, "biz", "e_gen_err", e3);
            return "";
        }
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public static String m8407(pa paVar, byte[] bArr) {
        BigInteger modulus;
        try {
            PublicKey publicKey = ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(bArr))).getPublicKey();
            if (!(publicKey instanceof RSAPublicKey) || (modulus = ((RSAPublicKey) publicKey).getModulus()) == null) {
                return null;
            }
            return modulus.toString(16);
        } catch (Exception e2) {
            q9.m8087(paVar, "auth", "GetPublicKeyFromSignEx", e2);
            return null;
        }
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public static String m8408(String str, String str2) {
        return str + str2;
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public static String m8409(String str, String str2, String str3) {
        try {
            int iIndexOf = str3.indexOf(str) + str.length();
            if (iIndexOf <= str.length()) {
                return "";
            }
            int iIndexOf2 = TextUtils.isEmpty(str2) ? 0 : str3.indexOf(str2, iIndexOf);
            return iIndexOf2 < 1 ? str3.substring(iIndexOf) : str3.substring(iIndexOf, iIndexOf2);
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public static String m8410(String str, boolean z) throws NoSuchAlgorithmException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes());
            byte[] bArrDigest = messageDigest.digest();
            if (!z || bArrDigest.length <= 16) {
                return m8411(bArrDigest);
            }
            byte[] bArr = new byte[16];
            System.arraycopy(bArrDigest, 0, bArr, 0, 16);
            return m8411(bArr);
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public static String m8411(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            sb.append(Character.forDigit((b & 240) >> 4, 16));
            sb.append(Character.forDigit(b & cb.m, 16));
        }
        return sb.toString();
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public static Map<String, String> m8412(JSONObject jSONObject) {
        HashMap map = new HashMap();
        if (jSONObject == null) {
            return map;
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            try {
                map.put(next, jSONObject.optString(next));
            } catch (Throwable th) {
                hf.m6205(th);
            }
        }
        return map;
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public static C2298 m8413(pa paVar, Context context, String str, int i, String str2) {
        PackageInfo packageInfoM8402;
        if (EnvUtils.m315() && "com.eg.android.AlipayGphone".equals(str)) {
            str = "com.eg.android.AlipayGphoneRC";
        }
        try {
            packageInfoM8402 = m8402(context, str);
        } catch (Throwable th) {
            q9.m8091(paVar, "auth", "GetPackageInfoEx", th.getMessage());
            packageInfoM8402 = null;
        }
        if (m8420(paVar, packageInfoM8402)) {
            return m8415(packageInfoM8402, i, str2);
        }
        return null;
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public static C2298 m8414(pa paVar, Context context, List<p9.C2226> list) {
        C2298 c2298M8413;
        if (list == null) {
            return null;
        }
        for (p9.C2226 c2226 : list) {
            if (c2226 != null && (c2298M8413 = m8413(paVar, context, c2226.f8285, c2226.f8286, c2226.f8287)) != null && !c2298M8413.m8454(paVar) && !c2298M8413.m8453()) {
                return c2298M8413;
            }
        }
        return null;
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public static C2298 m8415(PackageInfo packageInfo, int i, String str) {
        if (packageInfo == null) {
            return null;
        }
        return new C2298(packageInfo, i, str);
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public static JSONObject m8416(Intent intent) {
        Bundle extras;
        JSONObject jSONObject = new JSONObject();
        if (intent != null && (extras = intent.getExtras()) != null) {
            for (String str : extras.keySet()) {
                try {
                    jSONObject.put(str, String.valueOf(extras.get(str)));
                } catch (Throwable unused) {
                }
            }
        }
        return jSONObject;
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public static void m8417(String str, String str2, Context context, pa paVar) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || m8430(paVar) || !p9.m7898().m7932()) {
            return;
        }
        try {
            Intent intent = new Intent("android.app.intent.action.APP_EXCEPTION_OCCUR");
            intent.putExtra("bizType", str);
            intent.putExtra("exName", str2);
            intent.setPackage(context.getPackageName());
            context.sendBroadcast(intent);
            q9.m8086(paVar, "biz", "AppNotify", str + "|" + str2);
        } catch (Exception unused) {
        }
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public static boolean m8418(long j, Runnable runnable, String str) {
        if (runnable == null) {
            return false;
        }
        ConditionVariable conditionVariable = new ConditionVariable();
        Thread thread = new Thread(new RunnableC2297(runnable, conditionVariable));
        if (!TextUtils.isEmpty(str)) {
            thread.setName(str);
        }
        thread.start();
        boolean zBlock = true;
        try {
            if (j <= 0) {
                conditionVariable.block();
            } else {
                zBlock = conditionVariable.block(j);
            }
        } catch (Throwable unused) {
        }
        return zBlock;
    }

    /* renamed from: އ, reason: contains not printable characters */
    public static boolean m8419(pa paVar, Context context, List<p9.C2226> list, boolean z) {
        try {
            for (p9.C2226 c2226 : list) {
                if (c2226 != null) {
                    String str = c2226.f8285;
                    if (EnvUtils.m315() && "com.eg.android.AlipayGphone".equals(str)) {
                        str = "com.eg.android.AlipayGphoneRC";
                    }
                    try {
                        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 128);
                        if (packageInfo != null) {
                            if (!z) {
                                return true;
                            }
                            q9.m8086(paVar, "biz", "PgWltVer", packageInfo.packageName + "|" + packageInfo.versionName);
                            return true;
                        }
                        continue;
                    } catch (PackageManager.NameNotFoundException unused) {
                        continue;
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            q9.m8087(paVar, "biz", "CheckLaunchAppExistEx", th);
            return false;
        }
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public static boolean m8420(pa paVar, PackageInfo packageInfo) {
        String str = "";
        boolean z = false;
        if (packageInfo == null) {
            str = "info == null";
        } else {
            Signature[] signatureArr = packageInfo.signatures;
            if (signatureArr == null) {
                str = "info.signatures == null";
            } else if (signatureArr.length <= 0) {
                str = "info.signatures.length <= 0";
            } else {
                z = true;
            }
        }
        if (!z) {
            q9.m8091(paVar, "auth", "NotIncludeSignatures", str);
        }
        return z;
    }

    /* renamed from: މ, reason: contains not printable characters */
    public static boolean m8421(pa paVar, String str) {
        try {
            String host = new URL(str).getHost();
            if (host.endsWith("alipay.com")) {
                return true;
            }
            return host.endsWith("alipay.net");
        } catch (Throwable th) {
            q9.m8087(paVar, "biz", "ckUrlErr", th);
            return false;
        }
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public static boolean m8422(pa paVar, String str, Activity activity) throws NumberFormatException {
        String strSubstring;
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        if (activity == null) {
            return false;
        }
        if (str.toLowerCase().startsWith("alipays://platformapi/startApp?".toLowerCase()) || str.toLowerCase().startsWith("intent://platformapi/startapp?".toLowerCase())) {
            try {
                C2298 c2298M8414 = m8414(paVar, activity, ba.f140);
                if (c2298M8414 != null && !c2298M8414.m8453() && !c2298M8414.m8454(paVar)) {
                    if (str.startsWith("intent://platformapi/startapp")) {
                        str = str.replaceFirst("intent://platformapi/startapp\\?", "alipays://platformapi/startApp?");
                    }
                    activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                }
            } catch (Throwable unused) {
            }
            return true;
        }
        if (TextUtils.equals(str, "sdklite://h5quit") || TextUtils.equals(str, m8408("http", "://m.alipay.com/?action=h5quit"))) {
            ac.m25(ac.m23());
            activity.finish();
            return true;
        }
        if (!str.startsWith("sdklite://h5quit?result=")) {
            return false;
        }
        try {
            String strSubstring2 = str.substring(str.indexOf("sdklite://h5quit?result=") + 24);
            int i = Integer.parseInt(strSubstring2.substring(strSubstring2.lastIndexOf("&end_code=") + 10));
            if (i == c.SUCCEEDED.m342() || i == c.PAY_WAITTING.m342()) {
                if (ea.f6609) {
                    StringBuilder sb = new StringBuilder();
                    String strDecode = URLDecoder.decode(str);
                    String strDecode2 = URLDecoder.decode(strDecode);
                    String str2 = strDecode2.substring(strDecode2.indexOf("sdklite://h5quit?result=") + 24, strDecode2.lastIndexOf("&end_code=")).split("&return_url=")[0];
                    int iIndexOf = strDecode.indexOf("&return_url=") + 12;
                    sb.append(str2);
                    sb.append("&return_url=");
                    sb.append(strDecode.substring(iIndexOf, strDecode.indexOf("&", iIndexOf)));
                    sb.append(strDecode.substring(strDecode.indexOf("&", iIndexOf)));
                    strSubstring = sb.toString();
                } else {
                    String strDecode3 = URLDecoder.decode(str);
                    strSubstring = strDecode3.substring(strDecode3.indexOf("sdklite://h5quit?result=") + 24, strDecode3.lastIndexOf("&end_code="));
                }
                c cVarB = c.b(i);
                ac.m25(ac.m24(cVarB.m342(), cVarB.m341(), strSubstring));
            } else {
                c cVarB2 = c.b(c.FAILED.m342());
                ac.m25(ac.m24(cVarB2.m342(), cVarB2.m341(), ""));
            }
        } catch (Exception unused2) {
            ac.m25(ac.m30());
        }
        activity.runOnUiThread(new RunnableC2296(activity));
        return true;
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public static boolean m8423(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        try {
            String str = packageInfo.versionName;
            String[] strArr = f8650;
            if (!TextUtils.equals(str, strArr[0])) {
                if (!TextUtils.equals(str, strArr[1])) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public static int m8424(int i) {
        return i / 100000;
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public static String m8425() {
        if (EnvUtils.m315()) {
            return "com.eg.android.AlipayGphoneRC";
        }
        try {
            return ba.f140.get(0).f8285;
        } catch (Throwable unused) {
            return "com.eg.android.AlipayGphone";
        }
    }

    /* renamed from: ގ, reason: contains not printable characters */
    public static String m8426(Context context) {
        return "-1;-1";
    }

    /* renamed from: ޏ, reason: contains not printable characters */
    public static String m8427(String str, String str2) {
        String string = Settings.Secure.getString(((Application) mc.m7550().m7554()).getContentResolver(), str);
        return string != null ? string : str2;
    }

    /* renamed from: ސ, reason: contains not printable characters */
    public static Map<String, String> m8428(pa paVar, String str) {
        HashMap map = new HashMap(4);
        int iIndexOf = str.indexOf(63);
        if (iIndexOf != -1 && iIndexOf < str.length() - 1) {
            for (String str2 : str.substring(iIndexOf + 1).split("&")) {
                int iIndexOf2 = str2.indexOf(61, 1);
                if (iIndexOf2 != -1 && iIndexOf2 < str2.length() - 1) {
                    map.put(str2.substring(0, iIndexOf2), m8440(paVar, str2.substring(iIndexOf2 + 1)));
                }
            }
        }
        return map;
    }

    /* renamed from: ޑ, reason: contains not printable characters */
    public static Map<String, String> m8429(String str) {
        HashMap map = new HashMap();
        for (String str2 : str.split("&")) {
            int iIndexOf = str2.indexOf("=", 1);
            if (-1 != iIndexOf) {
                map.put(str2.substring(0, iIndexOf), URLDecoder.decode(str2.substring(iIndexOf + 1)));
            }
        }
        return map;
    }

    /* renamed from: ޒ, reason: contains not printable characters */
    public static boolean m8430(pa paVar) {
        if (paVar == null || TextUtils.isEmpty(paVar.f8294)) {
            return false;
        }
        return paVar.f8294.toLowerCase().contains("auth");
    }

    /* renamed from: ޓ, reason: contains not printable characters */
    public static String m8431(pa paVar, String str) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
        } catch (Exception e2) {
            q9.m8091(paVar, "biz", "rflex", e2.getClass().getSimpleName());
            return null;
        }
    }

    /* renamed from: ޔ, reason: contains not printable characters */
    public static String m8432(Context context) {
        return context.getResources().getConfiguration().locale.toString();
    }

    /* renamed from: ޕ, reason: contains not printable characters */
    public static String m8433(String str) {
        return (EnvUtils.m315() && TextUtils.equals(str, "com.eg.android.AlipayGphoneRC")) ? "com.eg.android.AlipayGphoneRC.IAlixPay" : "com.eg.android.AlipayGphone.IAlixPay";
    }

    /* renamed from: ޖ, reason: contains not printable characters */
    public static int m8434(String str) {
        for (int i = 0; i < 64; i++) {
            if (str.equals(String.valueOf(f8651[i]))) {
                return i;
            }
        }
        return 0;
    }

    /* renamed from: ޗ, reason: contains not printable characters */
    public static DisplayMetrics m8435(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    /* renamed from: ޘ, reason: contains not printable characters */
    public static String m8436() throws IOException {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/version"), 256);
            try {
                String line = bufferedReader.readLine();
                bufferedReader.close();
                Matcher matcher = Pattern.compile("\\w+\\s+\\w+\\s+([^\\s]+)\\s+\\(([^\\s@]+(?:@[^\\s.]+)?)[^)]*\\)\\s+\\((?:[^(]*\\([^)]*\\))?[^)]*\\)\\s+([^\\s]+)\\s+(?:PREEMPT\\s+)?(.+)").matcher(line);
                if (!matcher.matches() || matcher.groupCount() < 4) {
                    return "Unavailable";
                }
                return matcher.group(1) + "\n" + matcher.group(2) + MyUTIL.white_space + matcher.group(3) + "\n" + matcher.group(4);
            } catch (Throwable th) {
                bufferedReader.close();
                throw th;
            }
        } catch (IOException unused) {
            return "Unavailable";
        }
    }

    /* renamed from: ޙ, reason: contains not printable characters */
    public static boolean m8437(pa paVar, String str) {
        try {
            int iM8438 = m8438(str);
            q9.m8086(paVar, "biz", "bindExt", "" + iM8438);
            return p9.m7898().m7925() && (iM8438 & 2) == 2;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: ޚ, reason: contains not printable characters */
    public static int m8438(String str) {
        try {
            String strM7920 = p9.m7898().m7920();
            if (TextUtils.isEmpty(strM7920)) {
                return 0;
            }
            return (m8427(strM7920, "").contains(str) ? 2 : 0) | 1;
        } catch (Throwable unused) {
            return 61440;
        }
    }

    /* renamed from: ޛ, reason: contains not printable characters */
    public static String m8439() throws IOException {
        String strM8436 = m8436();
        int iIndexOf = strM8436.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        if (iIndexOf != -1) {
            strM8436 = strM8436.substring(0, iIndexOf);
        }
        int iIndexOf2 = strM8436.indexOf("\n");
        if (iIndexOf2 != -1) {
            strM8436 = strM8436.substring(0, iIndexOf2);
        }
        return "Linux " + strM8436;
    }

    /* renamed from: ޜ, reason: contains not printable characters */
    public static String m8440(pa paVar, String str) {
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e2) {
            q9.m8087(paVar, "biz", "H5PayDataAnalysisError", e2);
            return "";
        }
    }

    /* renamed from: ޝ, reason: contains not printable characters */
    public static String m8441(Context context) {
        String strM8326 = tg.m8326(context);
        return strM8326.substring(0, strM8326.indexOf("://"));
    }

    /* renamed from: ޞ, reason: contains not printable characters */
    public static String m8442() {
        return "Android " + Build.VERSION.RELEASE;
    }

    /* renamed from: ޟ, reason: contains not printable characters */
    public static String m8443(Context context) {
        DisplayMetrics displayMetricsM8435 = m8435(context);
        return displayMetricsM8435.widthPixels + "*" + displayMetricsM8435.heightPixels;
    }

    /* renamed from: ޠ, reason: contains not printable characters */
    public static boolean m8444(String str) {
        return Pattern.compile("^http(s)?://([a-z0-9_\\-]+\\.)*(alipaydev|alipay|taobao)\\.(com|net)(:\\d+)?(/.*)?$").matcher(str).matches();
    }

    /* renamed from: ޡ, reason: contains not printable characters */
    public static int m8445() {
        try {
            return Process.myUid();
        } catch (Throwable th) {
            hf.m6205(th);
            return -200;
        }
    }

    /* renamed from: ޢ, reason: contains not printable characters */
    public static String m8446(Context context) throws IOException {
        return " (" + m8442() + ";" + m8439() + ";" + m8432(context) + ";;" + m8443(context) + ")(sdk android)";
    }

    /* renamed from: ޣ, reason: contains not printable characters */
    public static String m8447(String str) {
        return m8410(str, true);
    }

    /* renamed from: ޤ, reason: contains not printable characters */
    public static JSONObject m8448(String str) {
        try {
            return new JSONObject(str);
        } catch (Throwable unused) {
            return new JSONObject();
        }
    }

    /* renamed from: ޥ, reason: contains not printable characters */
    public static boolean m8449() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    /* renamed from: ޱ, reason: contains not printable characters */
    public static boolean m8450(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.alipay.android.app", 128) != null;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    /* renamed from: ߾, reason: contains not printable characters */
    public static String m8451(String str) {
        try {
            Uri uri = Uri.parse(str);
            return String.format("%s%s", uri.getAuthority(), uri.getPath());
        } catch (Throwable th) {
            hf.m6205(th);
            return Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        }
    }

    /* renamed from: ߿, reason: contains not printable characters */
    public static boolean m8452() {
        try {
            String[] strArrSplit = p9.m7898().m7917().split("\\|");
            String str = Build.MODEL;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            for (String str2 : strArrSplit) {
                if (TextUtils.equals(str, str2) || TextUtils.equals(str2, "all")) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            hf.m6205(th);
            return false;
        }
    }
}
