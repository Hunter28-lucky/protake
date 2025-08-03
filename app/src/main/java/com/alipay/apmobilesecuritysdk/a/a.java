package com.alipay.apmobilesecuritysdk.a;

import android.content.Context;
import android.os.Environment;
import com.alipay.apmobilesecuritysdk.d.e;
import com.alipay.apmobilesecuritysdk.e.b;
import com.alipay.apmobilesecuritysdk.e.c;
import com.alipay.apmobilesecuritysdk.e.d;
import com.alipay.apmobilesecuritysdk.e.g;
import com.alipay.apmobilesecuritysdk.e.h;
import com.alipay.apmobilesecuritysdk.e.i;
import com.alipay.apmobilesecuritysdk.otherid.UmidSdkWrapper;
import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import defpackage.be;
import defpackage.bf;
import defpackage.df;
import defpackage.ua;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/* loaded from: classes.dex */
public final class a {
    public Context a;
    public com.alipay.apmobilesecuritysdk.b.a b = com.alipay.apmobilesecuritysdk.b.a.a();
    public int c = 4;

    public a(Context context) {
        this.a = context;
    }

    public static String a(Context context) {
        String strB = b(context);
        return ua.m8370(strB) ? h.f(context) : strB;
    }

    public static String a(Context context, String str) {
        try {
            b();
            String strA = i.a(str);
            if (!ua.m8370(strA)) {
                return strA;
            }
            String strA2 = g.a(context, str);
            i.a(str, strA2);
            return !ua.m8370(strA2) ? strA2 : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean a() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String[] strArr = {"2017-01-27 2017-01-28", "2017-11-10 2017-11-11", "2017-12-11 2017-12-12"};
        int iRandom = ((int) (Math.random() * 24.0d * 60.0d * 60.0d)) * 1;
        for (int i = 0; i < 3; i++) {
            try {
                String[] strArrSplit = strArr[i].split(MyUTIL.white_space);
                if (strArrSplit != null && strArrSplit.length == 2) {
                    Date date = new Date();
                    Date date2 = simpleDateFormat.parse(strArrSplit[0] + " 00:00:00");
                    Date date3 = simpleDateFormat.parse(strArrSplit[1] + " 23:59:59");
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(date3);
                    calendar.add(13, iRandom);
                    Date time = calendar.getTime();
                    if (date.after(date2) && date.before(time)) {
                        return true;
                    }
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private be b(Map<String, String> map) {
        String str;
        String str2;
        String str3;
        b bVarB;
        b bVarC;
        String str4 = "";
        try {
            Context context = this.a;
            df dfVar = new df();
            String strM8369 = ua.m8369(map, "appName", "");
            String strM83692 = ua.m8369(map, "sessionId", "");
            String strM83693 = ua.m8369(map, "rpcVersion", "");
            String strA = a(context, strM8369);
            String securityToken = UmidSdkWrapper.getSecurityToken(context);
            String strD = h.d(context);
            if (ua.m8373(strM83692)) {
                dfVar.f6569 = strM83692;
            } else {
                dfVar.f6569 = strA;
            }
            dfVar.f6570 = securityToken;
            dfVar.f6571 = strD;
            dfVar.f6567 = "android";
            c cVarC = d.c(context);
            if (cVarC != null) {
                str2 = cVarC.a;
                str = cVarC.c;
            } else {
                str = "";
                str2 = str;
            }
            if (ua.m8370(str2) && (bVarC = com.alipay.apmobilesecuritysdk.e.a.c(context)) != null) {
                str2 = bVarC.a;
                str = bVarC.c;
            }
            c cVarB = d.b();
            if (cVarB != null) {
                str4 = cVarB.a;
                str3 = cVarB.c;
            } else {
                str3 = "";
            }
            if (ua.m8370(str4) && (bVarB = com.alipay.apmobilesecuritysdk.e.a.b()) != null) {
                str4 = bVarB.a;
                str3 = bVarB.c;
            }
            dfVar.f6574 = str2;
            dfVar.f6573 = str4;
            dfVar.f6576 = strM83693;
            if (ua.m8370(str2)) {
                dfVar.f6568 = str4;
                str = str3;
            } else {
                dfVar.f6568 = str2;
            }
            dfVar.f6575 = str;
            dfVar.f6572 = e.a(context, map);
            return bf.m171(this.a, this.b.c()).mo8595(dfVar);
        } catch (Throwable th) {
            th.printStackTrace();
            com.alipay.apmobilesecuritysdk.c.a.a(th);
            return null;
        }
    }

    public static String b(Context context) {
        try {
            String strB = i.b();
            if (!ua.m8370(strB)) {
                return strB;
            }
            c cVarB = d.b(context);
            if (cVarB != null) {
                i.a(cVarB);
                String str = cVarB.a;
                if (ua.m8373(str)) {
                    return str;
                }
            }
            b bVarB = com.alipay.apmobilesecuritysdk.e.a.b(context);
            if (bVarB == null) {
                return "";
            }
            i.a(bVarB);
            String str2 = bVarB.a;
            return ua.m8373(str2) ? str2 : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void b() {
        try {
            String[] strArr = {"device_feature_file_name", "wallet_times", "wxcasxx_v3", "wxcasxx_v4", "wxxzyy_v1"};
            for (int i = 0; i < 5; i++) {
                String str = strArr[i];
                File file = new File(Environment.getExternalStorageDirectory(), ".SystemConfig/" + str);
                if (file.exists() && file.canWrite()) {
                    file.delete();
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x01fd A[Catch: Exception -> 0x023a, TryCatch #0 {Exception -> 0x023a, blocks: (B:3:0x0006, B:5:0x0037, B:8:0x0040, B:37:0x00be, B:69:0x01e2, B:71:0x01fd, B:73:0x0203, B:75:0x0209, B:79:0x0212, B:81:0x0218, B:40:0x00d2, B:42:0x00ea, B:48:0x00f7, B:49:0x0107, B:51:0x010e, B:55:0x0120, B:57:0x0170, B:59:0x017a, B:61:0x0182, B:63:0x018f, B:65:0x0199, B:67:0x01a1, B:66:0x019d, B:60:0x017e, B:11:0x0055, B:13:0x0063, B:16:0x006e, B:18:0x0074, B:21:0x007f, B:24:0x0088, B:27:0x0095, B:30:0x00a2, B:33:0x00af), top: B:87:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int a(java.util.Map<java.lang.String, java.lang.String> r10) {
        /*
            Method dump skipped, instructions count: 577
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.apmobilesecuritysdk.a.a.a(java.util.Map):int");
    }
}
