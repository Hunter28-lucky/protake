package cn.smssdk.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.mob.MobSDK;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Method;

/* compiled from: Utils.java */
/* loaded from: classes.dex */
public class e {
    public static String a() {
        if (!c()) {
            return "NOSIM";
        }
        if (!a(MobSDK.getContext())) {
            return "CELLULAR_DISABLED";
        }
        try {
            String carrier = DHelper.getCarrier();
            if (!"46001".equals(carrier) && !"46006".equals(carrier) && !"46009".equals(carrier)) {
                if (!"46000".equals(carrier) && !"46002".equals(carrier) && !"46004".equals(carrier) && !"46007".equals(carrier)) {
                    if (!"46003".equals(carrier) && !"46005".equals(carrier)) {
                        if (!"46011".equals(carrier)) {
                            return "UNKNOWN";
                        }
                    }
                    return "CTCC";
                }
                return "CMCC";
            }
            return "CUCC";
        } catch (Throwable unused) {
            SMSLog.getInstance().d(SMSLog.FORMAT, "Utils", "Util", "isMobileDataEnabled", "Check mobile data encountered exception");
            return "";
        }
    }

    public static int b() {
        String[] strArrSplit;
        StringBuffer stringBuffer = new StringBuffer();
        if (!TextUtils.isEmpty("3.7.8") && (strArrSplit = "3.7.8".split("\\.")) != null && strArrSplit.length > 0) {
            stringBuffer.append(strArrSplit[0]);
            for (int i = 1; i < strArrSplit.length; i++) {
                if (!TextUtils.isEmpty(strArrSplit[i]) && strArrSplit[i].length() < 2) {
                    stringBuffer.append("0");
                    stringBuffer.append(strArrSplit[i]);
                } else if (!TextUtils.isEmpty(strArrSplit[i]) && strArrSplit[i].length() >= 2) {
                    stringBuffer.append(strArrSplit[i]);
                }
            }
        }
        return Integer.valueOf(stringBuffer.toString().trim()).intValue();
    }

    public static boolean c() {
        return ((TelephonyManager) MobSDK.getContext().getSystemService("phone")).getSimState() == 5;
    }

    public static boolean a(Context context) {
        try {
            Method declaredMethod = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke((ConnectivityManager) context.getSystemService("connectivity"), new Object[0])).booleanValue();
        } catch (Throwable unused) {
            SMSLog.getInstance().d(SMSLog.FORMAT, "Utils", "Util", "isMobileDataEnabled", "Check mobile data encountered exception");
            return false;
        }
    }

    public static String a(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter((Writer) stringWriter, true));
        stringWriter.getBuffer().toString();
        return stringWriter.getBuffer().toString();
    }
}
