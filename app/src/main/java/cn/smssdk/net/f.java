package cn.smssdk.net;

import android.text.TextUtils;
import cn.smssdk.utils.SMSLog;
import cn.smssdk.utils.SPHelper;
import com.mob.tools.utils.Hashon;
import com.umeng.analytics.pro.am;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: Protocols.java */
/* loaded from: classes.dex */
public class f {
    private static f d;
    private Hashon a = new Hashon();
    private SPHelper b = SPHelper.getInstance();
    private b c = b.g();

    private f() {
        e.b();
    }

    public static f d() {
        if (d == null) {
            d = new f();
        }
        return d;
    }

    public void a(String str, String str2, String str3) throws Throwable {
        if (TextUtils.isEmpty(str2)) {
            throw new Throwable("{\"detail\":\"country code cant be empty\"}");
        }
        if (TextUtils.isEmpty(str)) {
            throw new Throwable("{\"detail\":\"phone number cant be empty\"}");
        }
        HashMap<String, Object> map = new HashMap<>();
        HashMap map2 = new HashMap();
        if (!TextUtils.isEmpty(str3)) {
            map2.put("extKey", str3);
        }
        map.put("phone", str);
        map.put("zone", str2);
        map.put("attr", map2);
        map.put("tempCode", "Nul2");
        this.c.a(10, map);
    }

    public void b() {
        try {
            this.c.a(true);
        } catch (Throwable th) {
            SMSLog.getInstance().d(th, SMSLog.FORMAT_SIMPLE, "Init token error");
        }
    }

    public boolean c() {
        return this.c.a();
    }

    public HashMap<String, Object> b(String str, String str2, String str3) throws Throwable {
        if (!TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(str2)) {
                if (!TextUtils.isEmpty(str3)) {
                    HashMap<String, Object> map = new HashMap<>();
                    map.put("phone", str3);
                    map.put("code", str);
                    map.put("zone", str2);
                    this.c.a(11, map);
                    HashMap<String, Object> map2 = new HashMap<>();
                    map2.put(am.O, str2);
                    map2.put("phone", str3);
                    this.b.clearBuffer();
                    try {
                        this.b.setVerifyCountry(str2);
                        this.b.setVerifyPhone(str3);
                    } catch (Throwable th) {
                        SMSLog.getInstance().w(th);
                    }
                    return map2;
                }
                throw new Throwable("{\"detail\":\"phone number cant be empty\"}");
            }
            throw new Throwable("{\"detail\":\"country code cant be empty\"}");
        }
        throw new Throwable("{\"status\":\"466\"}");
    }

    public boolean a(String str, String str2, String str3, String str4) throws Throwable {
        if (!TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(str2)) {
                HashMap<String, Object> map = new HashMap<>();
                map.put("phone", str2);
                map.put("zone", str);
                if (!TextUtils.isEmpty(str3)) {
                    HashMap map2 = new HashMap();
                    map.put("attr", map2);
                    map2.put("extKey", str3);
                }
                if (!TextUtils.isEmpty(str4)) {
                    map.put("tempCode", str4);
                }
                HashMap<String, Object> mapA = this.c.a(9, map);
                String str5 = (String) mapA.get("vCode");
                String str6 = (String) mapA.get("smsId");
                Integer num = (Integer) mapA.get("smart");
                this.b.setSMSID(str6);
                this.b.setVCodeHash(str5);
                if (num == null || num.intValue() != 1) {
                    return false;
                }
                this.b.clearBuffer();
                try {
                    this.b.setVerifyCountry(str);
                    this.b.setVerifyPhone(str2);
                } catch (Throwable th) {
                    SMSLog.getInstance().w(th);
                }
                return true;
            }
            throw new Throwable("{\"detail\":\"phone number cant be empty\"}");
        }
        throw new Throwable("{\"detail\":\"country code cant be empty\"}");
    }

    public ArrayList<HashMap<String, Object>> a() throws Throwable {
        long lastZoneAt = this.b.getLastZoneAt();
        String bufferedCountrylist = this.b.getBufferedCountrylist();
        if (lastZoneAt == this.c.b() && !TextUtils.isEmpty(bufferedCountrylist) && !c()) {
            SMSLog.getInstance().d(SMSLog.FORMAT, "Protocols", "getSupportedCountries", "Use country list buffered in SP.");
            ArrayList<HashMap<String, Object>> arrayList = (ArrayList) this.a.fromJson(bufferedCountrylist).get("list");
            if (arrayList != null && !arrayList.isEmpty()) {
                return arrayList;
            }
            SMSLog.getInstance().d(SMSLog.FORMAT, "Protocols", "getSupportedCountries", "Country list buffered in SP dirty!");
        }
        SMSLog.getInstance().d(SMSLog.FORMAT, "Protocols", "getSupportedCountries", "Observe country list from server.");
        HashMap<String, Object> mapA = this.c.a(2, (HashMap<String, Object>) null);
        this.b.setBufferedCountrylist(this.a.fromHashMap(mapA));
        this.b.setLastZoneAt(this.c.b());
        this.c.c();
        return (ArrayList) mapA.get("list");
    }

    public boolean a(HashMap<String, Object> map) {
        boolean z;
        try {
            this.c.a(13, map);
            z = true;
        } catch (Throwable th) {
            SMSLog.getInstance().d(th, SMSLog.FORMAT_SIMPLE, "Upload SDK Log Failed");
            z = false;
        }
        SMSLog.getInstance().d(SMSLog.FORMAT, "Protocols", "uploadSdkLog", "Upload SDK Log: " + z);
        return z;
    }
}
