package cn.smssdk.net;

import android.text.TextUtils;
import cn.smssdk.utils.SMSLog;
import cn.smssdk.utils.SPHelper;
import com.xiaomi.mipush.sdk.Constants;
import io.jsonwebtoken.Header;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: ServiceApi.java */
/* loaded from: classes.dex */
public class g extends a {
    private int k;
    private long l;
    private SPHelper m = SPHelper.getInstance();

    private String b(HashMap<String, Object> map) {
        StringBuffer stringBuffer = new StringBuffer();
        String str = (String) map.get("host");
        int iIntValue = ((Integer) map.get("port")).intValue();
        String str2 = (String) map.get("action");
        if (!TextUtils.isEmpty(str) && !str.contains("http://")) {
            stringBuffer.append("http://");
        }
        stringBuffer.append(str);
        stringBuffer.append(Constants.COLON_SEPARATOR);
        stringBuffer.append(iIntValue);
        stringBuffer.append(str2);
        return stringBuffer.toString();
    }

    private void e() {
        if (this.f) {
            this.l = this.m.getLastRequestTimeMillis(this.b);
        }
    }

    private void f() {
        this.m.setLastRequestTimeMillis(this.b, this.l);
    }

    public void a(HashMap<String, Object> map) throws Throwable {
        String str = (String) map.get("name");
        this.b = str;
        if (TextUtils.isEmpty(str)) {
            throw new Throwable("GET API NAME ERROR");
        }
        if (this.b.equals("getZoneList")) {
            this.a = 2;
        } else if (this.b.equals("getToken")) {
            this.a = 3;
        } else if (this.b.equals("submitUser")) {
            this.a = 4;
        } else if (this.b.equals("logCollect")) {
            this.a = 7;
        } else if (this.b.equals("logInstall")) {
            this.a = 8;
        } else if (this.b.equals("sendTextSMS")) {
            this.a = 9;
        } else if (this.b.equals("sendVoiceSMS")) {
            this.a = 10;
        } else if (this.b.equals("verifyCode")) {
            this.a = 11;
        } else if (this.b.equals("uploadCollectData")) {
            this.a = 12;
        } else if (this.b.equals("sdkLog")) {
            this.a = 13;
        } else {
            SMSLog.getInstance().w(SMSLog.FORMAT, "ServiceApi", "parseConfig", "Unknown api type. name: " + this.b);
            this.a = 0;
        }
        this.c = b(map);
        ArrayList<String> arrayList = (ArrayList) map.get("params");
        this.h = arrayList;
        if (arrayList == null || arrayList.isEmpty()) {
            throw new Throwable("GET API PARAMS ERROR");
        }
        Integer num = (Integer) map.get(Header.COMPRESSION_ALGORITHM);
        if (num == null || num.intValue() != 1) {
            this.d = false;
        } else {
            this.d = true;
        }
        Integer num2 = (Integer) map.get("request");
        if (num2 == null || num2.intValue() != 1) {
            this.f17619e = false;
        } else {
            this.f17619e = true;
        }
        int iIntValue = ((Integer) map.get("frequency")).intValue();
        this.k = iIntValue;
        if (iIntValue != 0) {
            this.f = true;
        }
        e();
    }

    public void d() {
        if (this.f) {
            this.l = System.currentTimeMillis();
            f();
        }
    }

    @Override // cn.smssdk.net.a
    public boolean a() throws Throwable {
        if (this.f17619e) {
            if (this.f) {
                long jCurrentTimeMillis = System.currentTimeMillis() - this.l;
                if (jCurrentTimeMillis >= this.k) {
                    SMSLog.getInstance().d(SMSLog.FORMAT, "ServiceApi", "checkLimit", "[" + this.b + "]interval > frequency.");
                } else {
                    SMSLog.getInstance().w(SMSLog.FORMAT, "ServiceApi", "checkLimit", "[" + this.b + "]Request too frequently, terminate this request. Interval: " + jCurrentTimeMillis + ", frequency: " + this.k);
                    throw new Throwable("{\"status\":600}");
                }
            } else {
                SMSLog.getInstance().d(SMSLog.FORMAT, "ServiceApi", "checkLimit", "[" + this.b + "]Not limited for this api.");
            }
            SMSLog.getInstance().d(SMSLog.FORMAT, "ServiceApi", "checkLimit", "[" + this.b + "]Check OK, allow sending request.");
            return false;
        }
        SMSLog.getInstance().w(SMSLog.FORMAT, "ServiceApi", "checkLimit", "[" + this.b + "]No access permission for this api, terminate this request.");
        throw new Throwable("{\"status\":606}");
    }

    @Override // cn.smssdk.net.a
    public HashMap<String, Object> a(String str, String str2, HashMap<String, Object> map) throws Throwable {
        ArrayList<String> arrayList = this.h;
        if (arrayList != null && arrayList.size() > 0) {
            return e.a().a(this.a, this.h, str, str2, map);
        }
        SMSLog.getInstance().e(SMSLog.FORMAT, "ServiceApi", "buildParams", "[" + this.b + "]Can not build request params since listParam is null.");
        throw new Throwable("Can not build request params since listParam is null.");
    }
}
