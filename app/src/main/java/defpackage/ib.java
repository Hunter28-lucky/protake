package defpackage;

import android.util.Log;
import com.xiaomi.mipush.sdk.Constants;

/* loaded from: classes.dex */
public class ib {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static boolean f6776 = false;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static String m6284(Object obj, Object obj2) {
        Object[] objArr = new Object[2];
        if (obj == null) {
            obj = "";
        }
        objArr[0] = obj;
        if (obj2 == null) {
            obj2 = "";
        }
        objArr[1] = obj2;
        return String.format("%s:%s", objArr);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static String m6285(String str, Object... objArr) {
        if (str == null && objArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Object[] objArr2 = new Object[1];
        if (str == null) {
            str = Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        }
        int i = 0;
        objArr2[0] = str;
        sb.append(String.format("[%s] ", objArr2));
        if (objArr != null) {
            int length = objArr.length;
            while (true) {
                int i2 = i + 1;
                if (i2 >= objArr.length) {
                    break;
                }
                sb.append(m6284(objArr[i], objArr[i2]));
                if (i2 < length - 1) {
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                i = i2 + 1;
            }
            if (i == objArr.length - 1) {
                sb.append(objArr[i]);
            }
        }
        return sb.toString();
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static void m6286(String str, Object... objArr) {
        if (f6776) {
            Log.d("OpenId", m6285(str, objArr));
        }
    }
}
