package defpackage;

import android.content.Context;
import android.text.TextUtils;
import java.util.Random;

/* loaded from: classes.dex */
public class ke {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static String m7200() {
        int iCurrentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int iNanoTime = (int) System.nanoTime();
        int iNextInt = new Random().nextInt();
        int iNextInt2 = new Random().nextInt();
        byte[] bArrM6201 = hd.m6201(iCurrentTimeMillis);
        byte[] bArrM62012 = hd.m6201(iNanoTime);
        byte[] bArrM62013 = hd.m6201(iNextInt);
        byte[] bArrM62014 = hd.m6201(iNextInt2);
        byte[] bArr = new byte[16];
        System.arraycopy(bArrM6201, 0, bArr, 0, 4);
        System.arraycopy(bArrM62012, 0, bArr, 4, 4);
        System.arraycopy(bArrM62013, 0, bArr, 8, 4);
        System.arraycopy(bArrM62014, 0, bArr, 12, 4);
        return dc.m5940(bArr, 2);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static String m7201(Context context) {
        String strM7202 = xf.m8613(null) ? m7202() : null;
        return xf.m8613(strM7202) ? m7200() : strM7202;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static String m7202() throws ClassNotFoundException {
        String strM6069 = fg.m6069("ro.aliyun.clouduuid", "");
        if (TextUtils.isEmpty(strM6069)) {
            strM6069 = fg.m6069("ro.sys.aliyun.clouduuid", "");
        }
        return TextUtils.isEmpty(strM6069) ? m7204() : strM6069;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static String m7203(Context context) {
        return "";
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static String m7204() {
        try {
            return (String) Class.forName("com.yunos.baseservice.clouduuid.CloudUUID").getMethod("getCloudUUID", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return "";
        }
    }
}
