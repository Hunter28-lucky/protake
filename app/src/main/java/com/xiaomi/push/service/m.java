package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.umeng.umcrash.UMCrash;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.BuildConfig;
import com.xiaomi.push.fh;
import com.xiaomi.push.ge;
import com.xiaomi.push.gk;
import com.xiaomi.push.gl;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class m {

    @SuppressLint({"StaticFieldLeak"})
    private static volatile m a;

    /* renamed from: a, reason: collision with other field name */
    private long f6451a;

    /* renamed from: a, reason: collision with other field name */
    private final Context f6452a;

    /* renamed from: a, reason: collision with other field name */
    private final SharedPreferences f6453a;

    /* renamed from: b, reason: collision with other field name */
    private final boolean f6459b;

    /* renamed from: c, reason: collision with other field name */
    private final boolean f6460c;

    /* renamed from: a, reason: collision with other field name */
    private final AtomicInteger f6455a = new AtomicInteger(0);

    /* renamed from: a, reason: collision with other field name */
    private String f6454a = null;

    /* renamed from: a, reason: collision with other field name */
    private volatile boolean f6456a = false;

    /* renamed from: b, reason: collision with other field name */
    private String f6457b = null;

    /* renamed from: b, reason: collision with other field name */
    private final AtomicInteger f6458b = new AtomicInteger(0);
    private final AtomicInteger c = new AtomicInteger(0);

    /* renamed from: a, reason: collision with other field name */
    private int f6450a = -1;
    private long b = -1;
    private final boolean d = m5788g();

    public static class a {
        public static String a() {
            return "support_wifi_digest";
        }

        public static String a(String str) {
            return String.format("HB_%s", str);
        }

        public static String b() {
            return "record_support_wifi_digest_reported_time";
        }

        public static String b(String str) {
            return String.format("HB_dead_time_%s", str);
        }

        public static String c() {
            return "record_hb_count_start";
        }

        public static String d() {
            return "record_short_hb_count";
        }

        public static String e() {
            return "record_long_hb_count";
        }

        public static String f() {
            return "record_hb_change";
        }

        public static String g() {
            return "record_mobile_ptc";
        }

        public static String h() {
            return "record_wifi_ptc";
        }

        public static String i() {
            return "record_ptc_start";
        }

        public static String j() {
            return "keep_short_hb_effective_time";
        }
    }

    private m(Context context) {
        this.f6452a = context;
        this.f6460c = com.xiaomi.push.j.m5690a(context);
        this.f6459b = ah.a(context).a(gl.IntelligentHeartbeatSwitchBoolean.a(), true);
        SharedPreferences sharedPreferences = context.getSharedPreferences("hb_record", 0);
        this.f6453a = sharedPreferences;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (sharedPreferences.getLong(a.c(), -1L) == -1) {
            sharedPreferences.edit().putLong(a.c(), jCurrentTimeMillis).apply();
        }
        long j = sharedPreferences.getLong(a.i(), -1L);
        this.f6451a = j;
        if (j == -1) {
            this.f6451a = jCurrentTimeMillis;
            sharedPreferences.edit().putLong(a.i(), jCurrentTimeMillis).apply();
        }
    }

    public static m a(Context context) {
        if (a == null) {
            synchronized (m.class) {
                if (a == null) {
                    a = new m(context);
                }
            }
        }
        return a;
    }

    private void b(String str) {
        if ("WIFI-ID-UNKNOWN".equals(str)) {
            String str2 = this.f6454a;
            if (str2 == null || !str2.startsWith("W-")) {
                if (this.d) {
                    this.f6454a = "W-NETWORK_ID_WIFI_DEFAULT";
                } else {
                    this.f6454a = null;
                }
            }
        } else {
            this.f6454a = str;
        }
        int i = this.f6453a.getInt(a.a(this.f6454a), -1);
        long j = this.f6453a.getLong(a.b(this.f6454a), -1L);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (i != -1) {
            if (j == -1) {
                this.f6453a.edit().putLong(a.b(this.f6454a), jCurrentTimeMillis + d()).apply();
            } else if (jCurrentTimeMillis > j) {
                this.f6453a.edit().remove(a.a(this.f6454a)).remove(a.b(this.f6454a)).apply();
            }
        }
        this.f6455a.getAndSet(0);
        if (TextUtils.isEmpty(this.f6454a) || a() != -1) {
            this.f6456a = false;
        } else {
            this.f6456a = true;
        }
        com.xiaomi.channel.commonutils.logger.b.m5113a(String.format("[HB] network changed, netid:%s, %s", this.f6454a, Boolean.valueOf(this.f6456a)));
    }

    private void e() {
        if (this.f6453a.getBoolean(a.a(), false)) {
            return;
        }
        this.f6453a.edit().putBoolean(a.a(), true).apply();
    }

    private void f() {
        int i = this.f6450a;
        String strH = i != 0 ? i != 1 ? null : a.h() : a.g();
        if (TextUtils.isEmpty(strH)) {
            return;
        }
        if (this.f6453a.getLong(a.i(), -1L) == -1) {
            this.f6451a = System.currentTimeMillis();
            this.f6453a.edit().putLong(a.i(), this.f6451a).apply();
        }
        this.f6453a.edit().putInt(strH, this.f6453a.getInt(strH, 0) + 1).apply();
    }

    private void g() {
        int i;
        String[] strArrSplit;
        String[] strArrSplit2;
        if (m5784c()) {
            String string = this.f6453a.getString(a.f(), null);
            char c = 1;
            char c2 = 0;
            if (!TextUtils.isEmpty(string) && (strArrSplit = string.split("###")) != null) {
                int i2 = 0;
                while (i2 < strArrSplit.length) {
                    if (!TextUtils.isEmpty(strArrSplit[i2]) && (strArrSplit2 = strArrSplit[i2].split(":::")) != null && strArrSplit2.length >= 4) {
                        String str = strArrSplit2[c2];
                        String str2 = strArrSplit2[c];
                        String str3 = strArrSplit2[2];
                        String str4 = strArrSplit2[3];
                        HashMap map = new HashMap();
                        map.put(NotificationCompat.CATEGORY_EVENT, "change");
                        map.put("model", com.xiaomi.push.k.a());
                        map.put("net_type", str2);
                        map.put("net_name", str);
                        map.put(com.umeng.analytics.pro.am.aU, str3);
                        map.put(UMCrash.SP_KEY_TIMESTAMP, str4);
                        a("category_hb_change", null, map);
                        com.xiaomi.channel.commonutils.logger.b.m5113a("[HB] report hb changed events.");
                    }
                    i2++;
                    c = 1;
                    c2 = 0;
                }
                this.f6453a.edit().remove(a.f()).apply();
            }
            if (this.f6453a.getBoolean(a.a(), false)) {
                long j = this.f6453a.getLong(a.b(), 0L);
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - j > 1296000000) {
                    HashMap map2 = new HashMap();
                    map2.put(NotificationCompat.CATEGORY_EVENT, "support");
                    map2.put("model", com.xiaomi.push.k.a());
                    map2.put(UMCrash.SP_KEY_TIMESTAMP, String.valueOf(System.currentTimeMillis() / 1000));
                    a("category_hb_change", null, map2);
                    com.xiaomi.channel.commonutils.logger.b.m5113a("[HB] report support wifi digest events.");
                    this.f6453a.edit().putLong(a.b(), jCurrentTimeMillis).apply();
                }
            }
            if (m5786e()) {
                int i3 = this.f6453a.getInt(a.d(), 0);
                int i4 = this.f6453a.getInt(a.e(), 0);
                if (i3 > 0 || i4 > 0) {
                    long j2 = this.f6453a.getLong(a.c(), -1L);
                    String strValueOf = String.valueOf(235000);
                    String strValueOf2 = String.valueOf(j2);
                    String strValueOf3 = String.valueOf(System.currentTimeMillis());
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(com.umeng.analytics.pro.am.aU, strValueOf);
                        jSONObject.put("c_short", String.valueOf(i3));
                        jSONObject.put("c_long", String.valueOf(i4));
                        jSONObject.put("count", String.valueOf(i3 + i4));
                        jSONObject.put(com.umeng.analytics.pro.d.p, strValueOf2);
                        jSONObject.put(com.umeng.analytics.pro.d.q, strValueOf3);
                        String string2 = jSONObject.toString();
                        HashMap map3 = new HashMap();
                        map3.put(NotificationCompat.CATEGORY_EVENT, "long_and_short_hb_count");
                        a("category_hb_count", string2, map3);
                        com.xiaomi.channel.commonutils.logger.b.m5113a("[HB] report short/long hb count events.");
                    } catch (Throwable unused) {
                    }
                }
                this.f6453a.edit().putInt(a.d(), 0).putInt(a.e(), 0).putLong(a.c(), System.currentTimeMillis()).apply();
            }
            if (m5787f()) {
                String strValueOf4 = String.valueOf(this.f6451a);
                String strValueOf5 = String.valueOf(System.currentTimeMillis());
                int i5 = this.f6453a.getInt(a.g(), 0);
                if (i5 > 0) {
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("net_type", "M");
                        jSONObject2.put("ptc", i5);
                        jSONObject2.put(com.umeng.analytics.pro.d.p, strValueOf4);
                        jSONObject2.put(com.umeng.analytics.pro.d.q, strValueOf5);
                        String string3 = jSONObject2.toString();
                        HashMap map4 = new HashMap();
                        map4.put(NotificationCompat.CATEGORY_EVENT, "ptc_event");
                        a("category_lc_ptc", string3, map4);
                        com.xiaomi.channel.commonutils.logger.b.m5113a("[HB] report ping timeout count events of mobile network.");
                        this.f6453a.edit().putInt(a.g(), 0).apply();
                        i = 0;
                    } catch (Throwable unused2) {
                        i = 0;
                        this.f6453a.edit().putInt(a.g(), 0).apply();
                    }
                } else {
                    i = 0;
                }
                int i6 = this.f6453a.getInt(a.h(), i);
                if (i6 > 0) {
                    try {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("net_type", ExifInterface.LONGITUDE_WEST);
                        jSONObject3.put("ptc", i6);
                        jSONObject3.put(com.umeng.analytics.pro.d.p, strValueOf4);
                        jSONObject3.put(com.umeng.analytics.pro.d.q, strValueOf5);
                        String string4 = jSONObject3.toString();
                        HashMap map5 = new HashMap();
                        map5.put(NotificationCompat.CATEGORY_EVENT, "ptc_event");
                        a("category_lc_ptc", string4, map5);
                        com.xiaomi.channel.commonutils.logger.b.m5113a("[HB] report ping timeout count events of wifi network.");
                    } catch (Throwable unused3) {
                    }
                    this.f6453a.edit().putInt(a.h(), 0).apply();
                }
                this.f6451a = System.currentTimeMillis();
                this.f6453a.edit().putLong(a.i(), this.f6451a).apply();
            }
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m5790a() {
    }

    /* renamed from: c, reason: collision with other method in class */
    public void m5794c() {
        if (m5785d()) {
            this.f6457b = this.f6454a;
        }
    }

    /* renamed from: d, reason: collision with other method in class */
    public void m5795d() {
        if (m5785d()) {
            g();
            if (this.f6456a) {
                this.f6455a.getAndSet(0);
            }
        }
    }

    private long c() {
        return this.f6453a.getLong(a.j(), -1L);
    }

    /* renamed from: e, reason: collision with other method in class */
    private boolean m5786e() {
        long j = this.f6453a.getLong(a.c(), -1L);
        if (j == -1) {
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        return j > jCurrentTimeMillis || jCurrentTimeMillis - j >= 259200000;
    }

    private void c(String str) {
        if (a(str)) {
            this.f6453a.edit().putInt(a.a(str), 235000).apply();
            this.f6453a.edit().putLong(a.b(this.f6454a), System.currentTimeMillis() + d()).apply();
        }
    }

    private long d() {
        return ah.a(this.f6452a).a(gl.ShortHeartbeatEffectivePeriodMsLong.a(), 7776000000L);
    }

    public synchronized void a(com.xiaomi.push.aw awVar) {
        if (m5785d()) {
            String str = null;
            if (awVar != null) {
                if (awVar.a() == 0) {
                    String strM5221b = awVar.m5221b();
                    if (!TextUtils.isEmpty(strM5221b) && !"UNKNOWN".equalsIgnoreCase(strM5221b)) {
                        str = "M-" + strM5221b;
                    }
                    b(str);
                    this.f6450a = 0;
                } else if (awVar.a() != 1 && awVar.a() != 6) {
                    b(null);
                    this.f6450a = -1;
                } else {
                    b("WIFI-ID-UNKNOWN");
                    this.f6450a = 1;
                }
            } else {
                b(null);
                this.f6450a = -1;
            }
        }
    }

    private void d(String str) {
        String str2;
        String string;
        if (m5784c() && !TextUtils.isEmpty(str)) {
            if (str.startsWith("W-")) {
                str2 = ExifInterface.LONGITUDE_WEST;
            } else if (!str.startsWith("M-")) {
                return;
            } else {
                str2 = "M";
            }
            String strValueOf = String.valueOf(235000);
            String strValueOf2 = String.valueOf(System.currentTimeMillis() / 1000);
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(":::");
            sb.append(str2);
            sb.append(":::");
            sb.append(strValueOf);
            sb.append(":::");
            sb.append(strValueOf2);
            String string2 = this.f6453a.getString(a.f(), null);
            if (TextUtils.isEmpty(string2)) {
                string = sb.toString();
            } else {
                string = string2 + "###" + sb.toString();
            }
            this.f6453a.edit().putString(a.f(), string).apply();
        }
    }

    /* renamed from: c, reason: collision with other method in class */
    private boolean m5784c() {
        return m5785d() && ah.a(this.f6452a).a(gl.IntelligentHeartbeatDataCollectSwitchBoolean.a(), true) && com.xiaomi.push.n.China.name().equals(b.a(this.f6452a).a());
    }

    /* renamed from: f, reason: collision with other method in class */
    private boolean m5787f() {
        if (this.f6451a == -1) {
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = this.f6451a;
        return j > jCurrentTimeMillis || jCurrentTimeMillis - j >= 259200000;
    }

    /* renamed from: b, reason: collision with other method in class */
    public void m5793b() {
        if (m5785d()) {
            f();
            if (this.f6456a && !TextUtils.isEmpty(this.f6454a) && this.f6454a.equals(this.f6457b)) {
                this.f6455a.getAndIncrement();
                com.xiaomi.channel.commonutils.logger.b.m5113a("[HB] ping timeout count:" + this.f6455a);
                if (m5783a()) {
                    com.xiaomi.channel.commonutils.logger.b.m5113a("[HB] change hb interval for net:" + this.f6454a);
                    c(this.f6454a);
                    this.f6456a = false;
                    this.f6455a.getAndSet(0);
                    d(this.f6454a);
                }
            }
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized void m5791a(String str) {
        if (!TextUtils.isEmpty(str)) {
            e();
        }
        if (m5785d() && !TextUtils.isEmpty(str)) {
            b("W-" + str);
        }
    }

    /* renamed from: d, reason: collision with other method in class */
    private boolean m5785d() {
        return this.f6460c && (this.f6459b || this.d || ((c() > System.currentTimeMillis() ? 1 : (c() == System.currentTimeMillis() ? 0 : -1)) >= 0));
    }

    public void a(int i) {
        this.f6453a.edit().putLong(a.j(), System.currentTimeMillis() + (i * 1000)).apply();
    }

    /* renamed from: a, reason: collision with other method in class */
    private boolean m5783a() {
        return this.f6455a.get() >= Math.max(ah.a(this.f6452a).a(gl.IntelligentHeartbeatNATCountInt.a(), 3), 3);
    }

    /* renamed from: b, reason: collision with other method in class */
    public long m5792b() {
        return this.b;
    }

    private boolean b() {
        if (!TextUtils.isEmpty(this.f6454a)) {
            if (this.f6454a.startsWith("M-")) {
                if (!ah.a(this.f6452a).a(gl.IntelligentHeartbeatUseInMobileNetworkBoolean.a(), false)) {
                    return true;
                }
            } else if (this.f6454a.equals("W-NETWORK_ID_WIFI_DEFAULT") && !m5788g()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a, reason: collision with other method in class */
    public long m5789a() {
        int iA;
        long jB = fh.b();
        if (this.f6460c && !b() && ((ah.a(this.f6452a).a(gl.IntelligentHeartbeatSwitchBoolean.a(), true) || c() >= System.currentTimeMillis()) && (iA = a()) != -1)) {
            jB = iA;
        }
        if (!TextUtils.isEmpty(this.f6454a) && !"WIFI-ID-UNKNOWN".equals(this.f6454a) && this.f6450a == 1) {
            a(jB < Constants.ASSEMBLE_PUSH_NETWORK_INTERVAL);
        }
        this.b = jB;
        com.xiaomi.channel.commonutils.logger.b.m5113a("[HB] ping interval:" + jB);
        return jB;
    }

    private int a() {
        if (TextUtils.isEmpty(this.f6454a)) {
            return -1;
        }
        try {
            return this.f6453a.getInt(a.a(this.f6454a), -1);
        } catch (Throwable unused) {
            return -1;
        }
    }

    private boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("W-") || str.startsWith("M-");
    }

    private void a(boolean z) {
        String strE;
        if (m5784c()) {
            int iIncrementAndGet = (z ? this.f6458b : this.c).incrementAndGet();
            Object[] objArr = new Object[2];
            objArr[0] = z ? "short" : "long";
            objArr[1] = Integer.valueOf(iIncrementAndGet);
            com.xiaomi.channel.commonutils.logger.b.b(String.format("[HB] %s ping interval count: %s", objArr));
            if (iIncrementAndGet >= 5) {
                if (z) {
                    strE = a.d();
                } else {
                    strE = a.e();
                }
                int i = this.f6453a.getInt(strE, 0) + iIncrementAndGet;
                this.f6453a.edit().putInt(strE, i).apply();
                Object[] objArr2 = new Object[2];
                objArr2[0] = z ? "short" : "long";
                objArr2[1] = Integer.valueOf(i);
                com.xiaomi.channel.commonutils.logger.b.m5113a(String.format("[HB] accumulate %s hb count(%s) and write to file. ", objArr2));
                if (z) {
                    this.f6458b.set(0);
                } else {
                    this.c.set(0);
                }
            }
        }
    }

    private void a(String str, String str2, Map<String, String> map) {
        gk gkVar = new gk();
        gkVar.d(str);
        gkVar.c("hb_name");
        gkVar.a("hb_channel");
        gkVar.a(1L);
        gkVar.b(str2);
        gkVar.a(false);
        gkVar.b(System.currentTimeMillis());
        gkVar.g(this.f6452a.getPackageName());
        gkVar.e("com.xiaomi.xmsf");
        if (map == null) {
            map = new HashMap<>();
        }
        String str3 = null;
        p pVarM5807a = q.m5807a(this.f6452a);
        if (pVarM5807a != null && !TextUtils.isEmpty(pVarM5807a.f6473a)) {
            String[] strArrSplit = pVarM5807a.f6473a.split("@");
            if (strArrSplit.length > 0) {
                str3 = strArrSplit[0];
            }
        }
        map.put("uuid", str3);
        map.put("model", com.xiaomi.push.k.a());
        Context context = this.f6452a;
        map.put("avc", String.valueOf(com.xiaomi.push.g.a(context, context.getPackageName())));
        map.put("pvc", String.valueOf(BuildConfig.VERSION_CODE));
        map.put("cvc", String.valueOf(48));
        gkVar.a(map);
        ge geVarA = ge.a(this.f6452a);
        if (geVarA != null) {
            geVarA.a(gkVar, this.f6452a.getPackageName());
        }
    }

    /* renamed from: g, reason: collision with other method in class */
    private boolean m5788g() {
        return ah.a(this.f6452a).a(gl.IntelligentHeartbeatForUnsupportWifiDigestBoolean.a(), true);
    }
}
