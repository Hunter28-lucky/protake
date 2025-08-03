package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import defpackage.q9;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class cc {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public String f204;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public String f205;

    /* renamed from: ԩ, reason: contains not printable characters */
    public String f206;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public String f207;

    /* renamed from: ԫ, reason: contains not printable characters */
    public String f208;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public String f209;

    /* renamed from: ԭ, reason: contains not printable characters */
    public String f210;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public String f211 = "";

    /* renamed from: ԯ, reason: contains not printable characters */
    public String f212 = "";

    /* renamed from: ՠ, reason: contains not printable characters */
    public String f213;

    public cc(Context context, boolean z) {
        context = context != null ? context.getApplicationContext() : context;
        this.f204 = m281();
        this.f206 = m278(context);
        this.f207 = m277(z ? 0L : q9.C2253.m8105(context));
        this.f208 = m276();
        this.f209 = m282(context);
        this.f210 = Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        this.f213 = Constants.ACCEPT_TIME_SEPARATOR_SERVER;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static String m276() {
        return String.format("%s,%s,-,-,-", m285(qa.m8106(mc.m7550().m7554()).m8113()), m285(mc.m7550().m7555()));
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static String m277(long j) {
        return String.format("android,3,%s,%s,com.alipay.mcpay,5.0,-,%s,-", m285("15.8.11"), m285("h.a.3.8.11"), Constants.WAVE_SEPARATOR + j);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static String m278(Context context) {
        String packageName;
        String str = Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        if (context != null) {
            try {
                Context applicationContext = context.getApplicationContext();
                packageName = applicationContext.getPackageName();
                try {
                    PackageInfo packageInfo = applicationContext.getPackageManager().getPackageInfo(packageName, 64);
                    str = packageInfo.versionName + "|" + m279(packageInfo);
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
            }
        } else {
            packageName = Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        }
        return String.format("%s,%s,-,-,-", m285(packageName), m285(str));
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static String m279(PackageInfo packageInfo) {
        Signature[] signatureArr;
        String strSubstring;
        String strM8407;
        if (packageInfo == null || (signatureArr = packageInfo.signatures) == null || signatureArr.length == 0) {
            return "0";
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(packageInfo.signatures.length);
            for (Signature signature : packageInfo.signatures) {
                try {
                    strM8407 = ug.m8407(null, signature.toByteArray());
                } catch (Throwable unused) {
                }
                if (TextUtils.isEmpty(strM8407)) {
                    strSubstring = "?";
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    sb.append(strSubstring);
                } else {
                    strSubstring = ug.m8447(strM8407).substring(0, 8);
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    sb.append(strSubstring);
                }
            }
            return sb.toString();
        } catch (Throwable unused2) {
            return "?";
        }
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static String m280(Throwable th) {
        if (th == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            stringBuffer.append(th.getClass().getName());
            stringBuffer.append(Constants.COLON_SEPARATOR);
            stringBuffer.append(th.getMessage());
            stringBuffer.append(" 》 ");
            StackTraceElement[] stackTrace = th.getStackTrace();
            if (stackTrace != null) {
                int i = 0;
                for (StackTraceElement stackTraceElement : stackTrace) {
                    stringBuffer.append(stackTraceElement.toString());
                    stringBuffer.append(" 》 ");
                    i++;
                    if (i > 5) {
                        break;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return stringBuffer.toString();
    }

    @SuppressLint({"SimpleDateFormat"})
    /* renamed from: ֈ, reason: contains not printable characters */
    public static String m281() {
        return String.format("%s,%s", m287(), new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss").format(new Date()));
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public static String m282(Context context) {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,-", m285(ld.m7500(context)), "android", m285(Build.VERSION.RELEASE), m285(Build.MODEL), Constants.ACCEPT_TIME_SEPARATOR_SERVER, "0", m285(ld.m7501(context).m344()), "gw", m285(sb.m8224(null, context)));
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public static String m283(String str) {
        String string;
        String strReplace;
        if (str == null) {
            str = "";
        }
        String[] strArrSplit = str.split("&");
        String strReplace2 = null;
        if (strArrSplit != null) {
            string = null;
            strReplace = null;
            for (String str2 : strArrSplit) {
                String[] strArrSplit2 = str2.split("=");
                if (strArrSplit2 != null && strArrSplit2.length == 2) {
                    if (strArrSplit2[0].equalsIgnoreCase("partner")) {
                        strReplace2 = strArrSplit2[1].replace("\"", "");
                    } else if (strArrSplit2[0].equalsIgnoreCase("out_trade_no")) {
                        string = strArrSplit2[1].replace("\"", "");
                    } else if (strArrSplit2[0].equalsIgnoreCase("trade_no")) {
                        strReplace = strArrSplit2[1].replace("\"", "");
                    } else if (strArrSplit2[0].equalsIgnoreCase("biz_content")) {
                        try {
                            JSONObject jSONObject = new JSONObject(ug.m8440(pa.m7943(), strArrSplit2[1]));
                            if (TextUtils.isEmpty(string)) {
                                string = jSONObject.getString("out_trade_no");
                            }
                        } catch (Throwable unused) {
                        }
                    } else if (strArrSplit2[0].equalsIgnoreCase(Constants.APP_ID) && TextUtils.isEmpty(strReplace2)) {
                        strReplace2 = strArrSplit2[1];
                    }
                }
            }
        } else {
            string = null;
            strReplace = null;
        }
        return String.format("%s,%s,-,%s,-,-,-", m285(strReplace), m285(string), m285(strReplace2));
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public static String m284() {
        return new SimpleDateFormat("HH:mm:ss:SSS", Locale.getDefault()).format(new Date());
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public static String m285(String str) {
        return TextUtils.isEmpty(str) ? "" : str.replace("[", "【").replace("]", "】").replace("(", "（").replace(")", "）").replace(Constants.ACCEPT_TIME_SEPARATOR_SP, "，").replace("^", Constants.WAVE_SEPARATOR).replace("#", "＃");
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public static String m286(String str) {
        return TextUtils.isEmpty(str) ? Constants.ACCEPT_TIME_SEPARATOR_SERVER : str;
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public static String m287() {
        try {
            return UUID.randomUUID().toString();
        } catch (Throwable unused) {
            return "12345678uuid";
        }
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public String m288(String str) {
        String strM283 = m283(str);
        this.f205 = strM283;
        return String.format("[(%s),(%s),(%s),(%s),(%s),(%s),(%s),(%s),(%s),(%s)]", this.f204, strM283, this.f206, this.f207, this.f208, this.f209, this.f210, m286(this.f211), m286(this.f212), this.f213);
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public void m289(String str, String str2) {
        m294("", str, str2);
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public void m290(String str, String str2, String str3) {
        m294("", str, str2 + "|" + str3);
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public void m291(String str, String str2, Throwable th) {
        m295(str, str2, m280(th));
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public void m292(String str, String str2, Throwable th, String str3) {
        m295(str, str2, str3 + ": " + m280(th));
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public void m293(String str, String str2, String str3) {
        m295(str, str2, str3);
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public final synchronized void m294(String str, String str2, String str3) {
        hf.m6209("mspl", String.format("event %s %s %s", str, str2, str3));
        String str4 = "";
        if (!TextUtils.isEmpty(this.f211)) {
            str4 = "^";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str4);
        Object[] objArr = new Object[4];
        objArr[0] = TextUtils.isEmpty(str) ? Constants.ACCEPT_TIME_SEPARATOR_SERVER : m285(str);
        objArr[1] = m285(str2);
        objArr[2] = m285(str3);
        objArr[3] = m285(m284());
        sb.append(String.format("%s,%s,%s,-,-,-,-,-,-,-,-,-,-,%s", objArr));
        this.f211 += sb.toString();
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public final synchronized void m295(String str, String str2, String str3) {
        hf.m6208("mspl", String.format("err %s %s %s", str, str2, str3));
        String str4 = "";
        if (!TextUtils.isEmpty(this.f212)) {
            str4 = "^";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str4);
        Object[] objArr = new Object[4];
        objArr[0] = str;
        objArr[1] = str2;
        objArr[2] = TextUtils.isEmpty(str3) ? Constants.ACCEPT_TIME_SEPARATOR_SERVER : m285(str3);
        objArr[3] = m285(m284());
        sb.append(String.format("%s,%s,%s,%s", objArr));
        this.f212 += sb.toString();
    }
}
