package cn.smssdk.net;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import cn.smssdk.SMSSDKCore;
import cn.smssdk.utils.DHelper;
import cn.smssdk.utils.SMSLog;
import cn.smssdk.utils.SPHelper;
import com.mob.MobCommunicator;
import com.mob.MobSDK;
import com.mob.commons.SMSSDK;
import com.mob.commons.authorize.DeviceAuthorizer;
import com.mob.commons.eventrecoder.EventRecorder;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.ResHelper;
import io.jsonwebtoken.JwtParser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: Config.java */
/* loaded from: classes.dex */
public class b {
    private static String v;
    private static b w;
    public static HashMap<String, Object> x;
    public static HashMap<String, Object> y;
    private Map<Integer, g> c;
    private C0064b g;
    private boolean i;
    private long j;
    private long l;
    private boolean m;
    private boolean n;
    private String o;
    private String p;
    private int q;
    private String r;
    private String s;
    private long t;
    private int k = 1;
    private String u = "";
    private final d d = new d();
    private boolean h = false;
    private SPHelper a = SPHelper.getInstance();
    private Hashon b = new Hashon();

    /* renamed from: e, reason: collision with root package name */
    private ReentrantLock f17620e = new ReentrantLock();
    private ReentrantReadWriteLock f = new ReentrantReadWriteLock();

    /* compiled from: Config.java */
    public static class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            try {
                b.w.h();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: Config.java */
    /* renamed from: cn.smssdk.net.b$b, reason: collision with other inner class name */
    public class C0064b extends Thread {
        private boolean a = true;

        public C0064b() {
        }

        private void a() throws Throwable {
            boolean zA;
            EventRecorder.addBegin("SMSSDK", "getConfig");
            String strB = b.this.b(false);
            if (TextUtils.isEmpty(strB)) {
                throw new Throwable("duid is empty!");
            }
            HashMap map = new HashMap();
            map.put("appkey", MobSDK.getAppkey());
            map.put("duid", strB);
            map.put("sdkver", Integer.valueOf(cn.smssdk.utils.e.b()));
            map.put("plat", Integer.valueOf(DH.SyncMtd.getPlatformCode()));
            map.put("apppkg", DH.SyncMtd.getPackageName());
            map.put("appver", DH.SyncMtd.getAppVersionName());
            map.put("md5", DHelper.getSignMd5());
            b bVar = b.this;
            HashMap mapA = bVar.a((cn.smssdk.net.a) bVar.d, (HashMap<String, Object>) map, false, false, 1);
            if (cn.smssdk.utils.a.c.booleanValue()) {
                SMSLog.getInstance().d(SMSLog.FORMAT, "Config", "getConfigFromService", "Config from server got. resp: " + b.this.b.fromHashMap(mapA));
            }
            if (mapA == null) {
                b.this.u = "response is empty";
                throw new Throwable("response is empty");
            }
            cn.smssdk.logger.d.d().a(6, mapA);
            b.x = new HashMap<>(mapA);
            try {
                b.this.f.writeLock().lock();
                try {
                    zA = b.this.a((HashMap<String, Object>) mapA);
                } catch (Throwable th) {
                    th = th;
                    zA = false;
                }
                try {
                    this.a = false;
                } catch (Throwable th2) {
                    th = th2;
                    SMSLog.getInstance().w(th, SMSLog.FORMAT, "Config", "getConfigFromService", "parseConfig encounters error, use default config re-configure");
                    this.a = true;
                    b.this.a.setConfig("");
                    b.this.a((HashMap<String, Object>) b.this.b.fromJson("{\"updateAt\":1545204873539,\"zoneAt\":1517389200000,\"result\":{\"urls\":[{\"name\":\"getToken\",\"host\":\"sdkapi.sms.mob.com\",\"port\":80,\"action\":\"/v3/token/get\",\"params\":[\"appkey\",\"duid\",\"sdkver\",\"plat\",\"sign\",\"apppkg\",\"appver\",\"md5\"],\"zip\":0,\"request\":1,\"frequency\":0},{\"name\":\"getFriend\",\"host\":\"addrlist.sms.mob.com\",\"port\":80,\"action\":\"/v3/relat/fm\",\"params\":[\"appkey\",\"duid\",\"sdkver\",\"plat\",\"apppkg\",\"appver\",\"token\",\"contactphones\",\"md5\"],\"zip\":0,\"request\":1,\"frequency\":0},{\"name\":\"sendTextSMS\",\"host\":\"code.sms.mob.com\",\"port\":80,\"action\":\"/v3/verify/code\",\"params\":[\"appkey\",\"duid\",\"sdkver\",\"plat\",\"apppkg\",\"appver\",\"token\",\"zone\",\"phone\",\"simserial\",\"myPhone\",\"tempCode\",\"md5\"],\"zip\":0,\"request\":1,\"frequency\":0},{\"name\":\"verifyCode\",\"host\":\"code.sms.mob.com\",\"port\":80,\"action\":\"/v3/client/verification\",\"params\":[\"appkey\",\"duid\",\"sdkver\",\"plat\",\"apppkg\",\"appver\",\"token\",\"zone\",\"phone\",\"code\",\"md5\"],\"zip\":0,\"request\":1,\"frequency\":0},{\"name\":\"getZoneList\",\"host\":\"sdkapi.sms.mob.com\",\"port\":80,\"action\":\"/v3/utils/zonelist\",\"params\":[\"appkey\",\"duid\",\"sdkver\",\"plat\",\"apppkg\",\"appver\",\"token\",\"md5\"],\"zip\":0,\"request\":1,\"frequency\":0},{\"name\":\"getFriendNew\",\"host\":\"addrlist.sms.mob.com\",\"port\":80,\"action\":\"/v3/relat/fm/new\",\"params\":[\"appkey\",\"duid\",\"sdkver\",\"plat\",\"apppkg\",\"appver\",\"token\",\"contactphones\",\"md5\"],\"zip\":0,\"request\":1,\"frequency\":0},{\"name\":\"submitUser\",\"host\":\"sdkapi.sms.mob.com\",\"port\":80,\"action\":\"/v3/app/submituserinfo\",\"params\":[\"appkey\",\"duid\",\"sdkver\",\"plat\",\"apppkg\",\"appver\",\"token\",\"zone\",\"phone\",\"uid\",\"nickname\",\"avatar\",\"md5\"],\"zip\":0,\"request\":1,\"frequency\":0},{\"name\":\"sendVoiceSMS\",\"host\":\"code.sms.mob.com\",\"port\":80,\"action\":\"/v3/voice/verify/code\",\"params\":[\"appkey\",\"duid\",\"sdkver\",\"plat\",\"apppkg\",\"appver\",\"token\",\"zone\",\"phone\",\"md5\"],\"zip\":0,\"request\":1,\"frequency\":0},{\"name\":\"sdkLog\",\"host\":\"log.sms.mob.com\",\"port\":80,\"action\":\"/log/sdk\",\"params\":[\"appkey\",\"duid\",\"sdkver\",\"plat\",\"list\"],\"zip\":0,\"request\":1,\"frequency\":0},{\"name\":\"uploadContacts\",\"host\":\"addrlist.sms.mob.com\",\"port\":80,\"action\":\"/v3/relat/apply\",\"params\":[\"appkey\",\"duid\",\"sdkver\",\"plat\",\"apppkg\",\"appver\",\"token\",\"zone\",\"myPhone\",\"simserial\",\"operator\",\"secretKey\",\"contacts\",\"imsi\",\"md5\"],\"zip\":1,\"request\":1,\"frequency\":0},{\"name\":\"uploadContactsNew\",\"host\":\"addrlist.sms.mob.com\",\"port\":80,\"action\":\"/v3/relat/apply/new\",\"params\":[\"appkey\",\"duid\",\"sdkver\",\"plat\",\"zone\",\"myPhone\",\"simserial\",\"operator\",\"secretKey\",\"contacts\",\"md5\"],\"zip\":1,\"request\":1,\"frequency\":0}]},\"request\":1,\"isSensitiveOrigin\":true,\"isPhoneSensitiveOrigin\":false}"));
                    if (!this.a) {
                        SMSLog.getInstance().d(SMSLog.FORMAT, "Config", "getConfigFromService", "config observed from server has been updated, store into SP");
                        b.this.a.setConfig(b.this.b.fromHashMap(mapA));
                    }
                    b.this.f.writeLock().unlock();
                    EventRecorder.addEnd("SMSSDK", "getConfig");
                }
                if (!this.a && zA) {
                    SMSLog.getInstance().d(SMSLog.FORMAT, "Config", "getConfigFromService", "config observed from server has been updated, store into SP");
                    b.this.a.setConfig(b.this.b.fromHashMap(mapA));
                }
                b.this.f.writeLock().unlock();
                EventRecorder.addEnd("SMSSDK", "getConfig");
            } catch (Throwable th3) {
                b.this.f.writeLock().unlock();
                throw th3;
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                a();
            } catch (Throwable th) {
                cn.smssdk.logger.d.d().a(6, th);
                if (b.this.f.writeLock().tryLock()) {
                    b.this.f.writeLock().unlock();
                }
            }
        }
    }

    private b() {
    }

    public static String f() {
        boolean z = false;
        try {
            ReflectHelper.invokeStaticMethod("DeviceHelper", "getInstance", MobSDK.getContext());
            z = true;
        } catch (Throwable unused) {
        }
        return "reflectInvoke: " + z;
    }

    public static b g() {
        if (w == null) {
            synchronized (b.class) {
                w = new b();
                new Thread(new a()).start();
            }
        }
        return w;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() throws Throwable {
        try {
            this.f.writeLock().lock();
            if (this.h) {
                return;
            }
            EventRecorder.prepare();
            String strCheckRecord = cn.smssdk.utils.a.d.booleanValue() ? EventRecorder.checkRecord("SMSSDK") : null;
            if (strCheckRecord != null) {
                EventRecorder.clear();
            }
            String config = this.a.getConfig();
            this.g = new C0064b();
            String strA = a(config);
            EventRecorder.addBegin("SMSSDK", "parseConfig");
            if (!TextUtils.isEmpty(strCheckRecord) || TextUtils.isEmpty(strA)) {
                HashMap<String, Object> mapFromJson = this.b.fromJson("{\"updateAt\":1545204873539,\"zoneAt\":1517389200000,\"result\":{\"urls\":[{\"name\":\"getToken\",\"host\":\"sdkapi.sms.mob.com\",\"port\":80,\"action\":\"/v3/token/get\",\"params\":[\"appkey\",\"duid\",\"sdkver\",\"plat\",\"sign\",\"apppkg\",\"appver\",\"md5\"],\"zip\":0,\"request\":1,\"frequency\":0},{\"name\":\"getFriend\",\"host\":\"addrlist.sms.mob.com\",\"port\":80,\"action\":\"/v3/relat/fm\",\"params\":[\"appkey\",\"duid\",\"sdkver\",\"plat\",\"apppkg\",\"appver\",\"token\",\"contactphones\",\"md5\"],\"zip\":0,\"request\":1,\"frequency\":0},{\"name\":\"sendTextSMS\",\"host\":\"code.sms.mob.com\",\"port\":80,\"action\":\"/v3/verify/code\",\"params\":[\"appkey\",\"duid\",\"sdkver\",\"plat\",\"apppkg\",\"appver\",\"token\",\"zone\",\"phone\",\"simserial\",\"myPhone\",\"tempCode\",\"md5\"],\"zip\":0,\"request\":1,\"frequency\":0},{\"name\":\"verifyCode\",\"host\":\"code.sms.mob.com\",\"port\":80,\"action\":\"/v3/client/verification\",\"params\":[\"appkey\",\"duid\",\"sdkver\",\"plat\",\"apppkg\",\"appver\",\"token\",\"zone\",\"phone\",\"code\",\"md5\"],\"zip\":0,\"request\":1,\"frequency\":0},{\"name\":\"getZoneList\",\"host\":\"sdkapi.sms.mob.com\",\"port\":80,\"action\":\"/v3/utils/zonelist\",\"params\":[\"appkey\",\"duid\",\"sdkver\",\"plat\",\"apppkg\",\"appver\",\"token\",\"md5\"],\"zip\":0,\"request\":1,\"frequency\":0},{\"name\":\"getFriendNew\",\"host\":\"addrlist.sms.mob.com\",\"port\":80,\"action\":\"/v3/relat/fm/new\",\"params\":[\"appkey\",\"duid\",\"sdkver\",\"plat\",\"apppkg\",\"appver\",\"token\",\"contactphones\",\"md5\"],\"zip\":0,\"request\":1,\"frequency\":0},{\"name\":\"submitUser\",\"host\":\"sdkapi.sms.mob.com\",\"port\":80,\"action\":\"/v3/app/submituserinfo\",\"params\":[\"appkey\",\"duid\",\"sdkver\",\"plat\",\"apppkg\",\"appver\",\"token\",\"zone\",\"phone\",\"uid\",\"nickname\",\"avatar\",\"md5\"],\"zip\":0,\"request\":1,\"frequency\":0},{\"name\":\"sendVoiceSMS\",\"host\":\"code.sms.mob.com\",\"port\":80,\"action\":\"/v3/voice/verify/code\",\"params\":[\"appkey\",\"duid\",\"sdkver\",\"plat\",\"apppkg\",\"appver\",\"token\",\"zone\",\"phone\",\"md5\"],\"zip\":0,\"request\":1,\"frequency\":0},{\"name\":\"sdkLog\",\"host\":\"log.sms.mob.com\",\"port\":80,\"action\":\"/log/sdk\",\"params\":[\"appkey\",\"duid\",\"sdkver\",\"plat\",\"list\"],\"zip\":0,\"request\":1,\"frequency\":0},{\"name\":\"uploadContacts\",\"host\":\"addrlist.sms.mob.com\",\"port\":80,\"action\":\"/v3/relat/apply\",\"params\":[\"appkey\",\"duid\",\"sdkver\",\"plat\",\"apppkg\",\"appver\",\"token\",\"zone\",\"myPhone\",\"simserial\",\"operator\",\"secretKey\",\"contacts\",\"imsi\",\"md5\"],\"zip\":1,\"request\":1,\"frequency\":0},{\"name\":\"uploadContactsNew\",\"host\":\"addrlist.sms.mob.com\",\"port\":80,\"action\":\"/v3/relat/apply/new\",\"params\":[\"appkey\",\"duid\",\"sdkver\",\"plat\",\"zone\",\"myPhone\",\"simserial\",\"operator\",\"secretKey\",\"contacts\",\"md5\"],\"zip\":1,\"request\":1,\"frequency\":0}]},\"request\":1,\"isSensitiveOrigin\":true,\"isPhoneSensitiveOrigin\":false}");
                if (mapFromJson != null) {
                    y = new HashMap<>(mapFromJson);
                }
                a(mapFromJson);
            } else {
                try {
                    a(this.b.fromJson(strA));
                } catch (Throwable unused) {
                    this.a.setConfig("");
                    a(this.b.fromJson("{\"updateAt\":1545204873539,\"zoneAt\":1517389200000,\"result\":{\"urls\":[{\"name\":\"getToken\",\"host\":\"sdkapi.sms.mob.com\",\"port\":80,\"action\":\"/v3/token/get\",\"params\":[\"appkey\",\"duid\",\"sdkver\",\"plat\",\"sign\",\"apppkg\",\"appver\",\"md5\"],\"zip\":0,\"request\":1,\"frequency\":0},{\"name\":\"getFriend\",\"host\":\"addrlist.sms.mob.com\",\"port\":80,\"action\":\"/v3/relat/fm\",\"params\":[\"appkey\",\"duid\",\"sdkver\",\"plat\",\"apppkg\",\"appver\",\"token\",\"contactphones\",\"md5\"],\"zip\":0,\"request\":1,\"frequency\":0},{\"name\":\"sendTextSMS\",\"host\":\"code.sms.mob.com\",\"port\":80,\"action\":\"/v3/verify/code\",\"params\":[\"appkey\",\"duid\",\"sdkver\",\"plat\",\"apppkg\",\"appver\",\"token\",\"zone\",\"phone\",\"simserial\",\"myPhone\",\"tempCode\",\"md5\"],\"zip\":0,\"request\":1,\"frequency\":0},{\"name\":\"verifyCode\",\"host\":\"code.sms.mob.com\",\"port\":80,\"action\":\"/v3/client/verification\",\"params\":[\"appkey\",\"duid\",\"sdkver\",\"plat\",\"apppkg\",\"appver\",\"token\",\"zone\",\"phone\",\"code\",\"md5\"],\"zip\":0,\"request\":1,\"frequency\":0},{\"name\":\"getZoneList\",\"host\":\"sdkapi.sms.mob.com\",\"port\":80,\"action\":\"/v3/utils/zonelist\",\"params\":[\"appkey\",\"duid\",\"sdkver\",\"plat\",\"apppkg\",\"appver\",\"token\",\"md5\"],\"zip\":0,\"request\":1,\"frequency\":0},{\"name\":\"getFriendNew\",\"host\":\"addrlist.sms.mob.com\",\"port\":80,\"action\":\"/v3/relat/fm/new\",\"params\":[\"appkey\",\"duid\",\"sdkver\",\"plat\",\"apppkg\",\"appver\",\"token\",\"contactphones\",\"md5\"],\"zip\":0,\"request\":1,\"frequency\":0},{\"name\":\"submitUser\",\"host\":\"sdkapi.sms.mob.com\",\"port\":80,\"action\":\"/v3/app/submituserinfo\",\"params\":[\"appkey\",\"duid\",\"sdkver\",\"plat\",\"apppkg\",\"appver\",\"token\",\"zone\",\"phone\",\"uid\",\"nickname\",\"avatar\",\"md5\"],\"zip\":0,\"request\":1,\"frequency\":0},{\"name\":\"sendVoiceSMS\",\"host\":\"code.sms.mob.com\",\"port\":80,\"action\":\"/v3/voice/verify/code\",\"params\":[\"appkey\",\"duid\",\"sdkver\",\"plat\",\"apppkg\",\"appver\",\"token\",\"zone\",\"phone\",\"md5\"],\"zip\":0,\"request\":1,\"frequency\":0},{\"name\":\"sdkLog\",\"host\":\"log.sms.mob.com\",\"port\":80,\"action\":\"/log/sdk\",\"params\":[\"appkey\",\"duid\",\"sdkver\",\"plat\",\"list\"],\"zip\":0,\"request\":1,\"frequency\":0},{\"name\":\"uploadContacts\",\"host\":\"addrlist.sms.mob.com\",\"port\":80,\"action\":\"/v3/relat/apply\",\"params\":[\"appkey\",\"duid\",\"sdkver\",\"plat\",\"apppkg\",\"appver\",\"token\",\"zone\",\"myPhone\",\"simserial\",\"operator\",\"secretKey\",\"contacts\",\"imsi\",\"md5\"],\"zip\":1,\"request\":1,\"frequency\":0},{\"name\":\"uploadContactsNew\",\"host\":\"addrlist.sms.mob.com\",\"port\":80,\"action\":\"/v3/relat/apply/new\",\"params\":[\"appkey\",\"duid\",\"sdkver\",\"plat\",\"zone\",\"myPhone\",\"simserial\",\"operator\",\"secretKey\",\"contacts\",\"md5\"],\"zip\":1,\"request\":1,\"frequency\":0}]},\"request\":1,\"isSensitiveOrigin\":true,\"isPhoneSensitiveOrigin\":false}"));
                }
            }
            this.h = true;
            try {
                SMSSDKCore.f();
                cn.smssdk.logger.d.d().b(6);
                this.g.start();
            } catch (Throwable th) {
                this.u = th.getMessage();
                SMSLog.getInstance().d(SMSLog.FORMAT, "Config", "initConfig", this.u);
            }
            EventRecorder.addEnd("SMSSDK", "parseConfig");
        } finally {
            this.f.writeLock().unlock();
        }
    }

    public static String e() {
        if (!TextUtils.isEmpty(v)) {
            return v;
        }
        try {
            String strMD5 = Data.MD5(MobSDK.getContext().getPackageManager().getPackageInfo(MobSDK.getContext().getPackageName(), 64).signatures[0].toByteArray());
            v = strMD5;
            return strMD5;
        } catch (Throwable th) {
            SMSLog.getInstance().d(th);
            return null;
        }
    }

    public long b() {
        return this.l;
    }

    public void c() {
        this.i = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(boolean z) {
        if (z || TextUtils.isEmpty(this.r)) {
            try {
                this.f17620e.lock();
                if (!TextUtils.isEmpty(this.r)) {
                    return this.r;
                }
                this.r = DeviceAuthorizer.authorize(new SMSSDK());
                cn.smssdk.logger.a.m().a(this.r);
            } finally {
                this.f17620e.unlock();
            }
        }
        return this.r;
    }

    private String c(int i) {
        try {
            int stringRes = ResHelper.getStringRes(MobSDK.getContext(), "smssdk_error_detail_" + i);
            if (stringRes > 0) {
                return MobSDK.getContext().getString(stringRes);
            }
            return null;
        } catch (Throwable th) {
            SMSLog.getInstance().w(th);
            return null;
        }
    }

    public boolean a() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(HashMap<String, Object> map) throws Throwable {
        int i;
        if (cn.smssdk.utils.a.c.booleanValue()) {
            SMSLog.getInstance().d(SMSLog.FORMAT, "Config", "parseConfig", "Parse config. config: " + this.b.fromHashMap(map));
        }
        Long l = (Long) map.get("updateAt");
        long jLongValue = l.longValue();
        long j = this.j;
        if (jLongValue < j) {
            SMSLog.getInstance().d(SMSLog.FORMAT, "Config", "parseConfig", "'updateAt' < local config, DO NOT update local config.");
            return false;
        }
        if (j == 0) {
            SMSLog.getInstance().d(SMSLog.FORMAT, "Config", "parseConfig", "Initialize local config.");
        } else {
            SMSLog.getInstance().d(SMSLog.FORMAT, "Config", "parseConfig", "'updateAt' >= local config, update local config.");
        }
        this.j = l.longValue();
        long jLongValue2 = ((Long) map.get("zoneAt")).longValue();
        long j2 = this.l;
        if (jLongValue2 > j2) {
            if (j2 != 0) {
                this.i = true;
            }
            this.l = jLongValue2;
        }
        this.k = ((Integer) map.get("request")).intValue();
        Object obj = map.get("isSensitiveOrigin");
        if (obj != null) {
            this.m = ((Boolean) obj).booleanValue();
            cn.smssdk.utils.b.c().c(this.m);
        }
        Object obj2 = map.get("phoneIsSensitiveOrigin");
        if (obj2 != null) {
            this.n = ((Boolean) obj2).booleanValue();
            cn.smssdk.utils.b.c().b(this.n);
        }
        this.o = (String) map.get("publicKey");
        this.p = (String) map.get("modulus");
        Integer num = (Integer) map.get("size");
        this.q = num != null ? num.intValue() : 0;
        if (!TextUtils.isEmpty(this.o) && !TextUtils.isEmpty(this.p) && (i = this.q) > 0) {
            c.a(this.o, this.p, i);
        }
        ArrayList arrayList = (ArrayList) ((HashMap) map.get("result")).get("urls");
        Map<Integer, g> map2 = this.c;
        if (map2 == null) {
            this.c = new HashMap();
        } else if (map2.size() > 0) {
            this.c.clear();
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            HashMap<String, Object> map3 = (HashMap) it.next();
            g gVar = new g();
            gVar.a(map3);
            gVar.a(this.f);
            this.c.put(Integer.valueOf(gVar.c()), gVar);
            if (cn.smssdk.utils.a.b.booleanValue()) {
                SMSLog.getInstance().d("api: " + cn.smssdk.utils.c.a(map3) + " urls.size: " + this.c.size(), new Object[0]);
            }
        }
        if (map.containsKey("exportKey")) {
            try {
                cn.smssdk.logger.a.m().a((ArrayList) map.get("exportKey"));
            } catch (Throwable th) {
                System.out.println(th);
            }
        }
        return true;
    }

    private String b(int i) {
        try {
            int stringRes = ResHelper.getStringRes(MobSDK.getContext(), "smssdk_error_desc_" + i);
            if (stringRes > 0) {
                return MobSDK.getContext().getString(stringRes);
            }
            return null;
        } catch (Throwable th) {
            SMSLog.getInstance().w(th);
            return null;
        }
    }

    private g a(int i) throws Throwable {
        if (MobSDK.getAppkey() != null && MobSDK.getAppkey().equalsIgnoreCase("moba6b6c6d6")) {
            String strValueOf = "zh".equals(DH.SyncMtd.getOSLanguage()) ? String.valueOf(new char[]{25152, 22635, 20889, 'A', 'P', 'P', 'K', 'E', 'Y', 20165, 20379, 27979, 35797, 20351, 29992, 65292, 19988, 19981, 23450, 26399, 22833, 25928, 65292, 35831, 21040, 'm', 'o', 'b', JwtParser.SEPARATOR_CHAR, 'c', 'o', 'm', 21518, 21488, 30003, 35831, 27491, 24335, 'A', 'P', 'P', 'K', 'E', 'Y'}) : "This appkey only for demo!Please request a new one for your own App";
            SMSLog.getInstance().e(SMSLog.FORMAT, "Config", "getApi", "SMSSDK WARNING: " + strValueOf);
        }
        h();
        if (this.k != 0) {
            return this.c.get(Integer.valueOf(i));
        }
        throw new Throwable("{\"status\":605,\"detail\":\"" + MobSDK.getContext().getResources().getString(ResHelper.getStringRes(MobSDK.getContext(), "smssdk_error_desc_605")) + "\"}");
    }

    private String a(String str) throws Throwable {
        if (TextUtils.isEmpty(str)) {
            SMSLog.getInstance().d(SMSLog.FORMAT, "Config", "checkConfigVersion", "Local config does not exist in SP, use default config.");
            return str;
        }
        if (((Integer) this.b.fromJson(str).get("expire_at")) != null) {
            this.a.setConfig("");
            this.a.setBufferedCountrylist("");
            SMSLog.getInstance().d(SMSLog.FORMAT, "Config", "checkConfigVersion", "Local config is for SMSSDK V2.1.4 or older, clear SP and use default config instead.");
            return "";
        }
        SMSLog.getInstance().d(SMSLog.FORMAT, "Config", "checkConfigVersion", "Local config is for SMSSDK V3.0.0 or later, use local config.");
        return str;
    }

    public synchronized String a(boolean z) throws Throwable {
        this.s = this.a.getToken();
        this.t = this.a.getTokenCacheAt();
        SMSLog.getInstance().d(SMSLog.FORMAT, "Config", "getToken", "force: " + z + ", tokenInSp: " + this.s + ", time: " + this.t);
        if (!z && !TextUtils.isEmpty(this.s) && this.t + 7200000 > System.currentTimeMillis()) {
            SMSLog.getInstance().d(SMSLog.FORMAT, "Config", "getToken", "Use token stored in SP. token=" + this.s);
            return this.s;
        }
        SMSLog.getInstance().d(SMSLog.FORMAT, "Config", "getToken", "Observe token from server.");
        HashMap<String, Object> map = new HashMap<>();
        map.put("sign", e());
        String str = (String) a(3, map).get("token");
        this.s = str;
        if (!TextUtils.isEmpty(str)) {
            this.a.setToken(this.s);
            this.a.setTokenCacheAt(System.currentTimeMillis());
            return this.s;
        }
        throw new Throwable("get token error!");
    }

    public HashMap<String, Object> a(int i, HashMap<String, Object> map) throws Throwable {
        g gVarA = a(i);
        HashMap<String, Object> mapA = a((cn.smssdk.net.a) gVarA, map, false, false, 1);
        if (gVarA.c() != 9 || mapA == null) {
            if (mapA != null) {
                gVarA.d();
            }
        } else if (((Integer) mapA.get("smart")) == null) {
            gVarA.d();
        }
        return mapA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, Object> a(cn.smssdk.net.a aVar, HashMap<String, Object> map, boolean z, boolean z2, int i) throws Throwable {
        if (i > 5) {
            int stringRes = ResHelper.getStringRes(MobSDK.getContext(), "smssdk_error_desc_server_busy");
            String string = stringRes > 0 ? MobSDK.getContext().getString(stringRes) : "Server is busy!";
            HashMap map2 = new HashMap();
            map2.put("description", string);
            throw new Throwable(this.b.fromHashMap(map2));
        }
        try {
            try {
                return this.b.fromJson(aVar.b(b(z), (!(aVar instanceof g) || aVar.c() == 3) ? null : a(z2), map));
            } catch (Throwable th) {
                SMSLog.getInstance().e(th);
                return null;
            }
        } catch (Throwable th2) {
            String strB = aVar != null ? aVar.b() : "";
            SMSLog.getInstance().e(th2, SMSLog.FORMAT, "Config", "post", "[" + strB + "]Request exception. msg= " + th2.getMessage());
            return a(th2, aVar, map, i);
        }
    }

    private HashMap<String, Object> a(Throwable th, cn.smssdk.net.a aVar, HashMap<String, Object> map, int i) throws Throwable {
        HashMap mapFromJson = this.b.fromJson(th.getMessage());
        ((Integer) ResHelper.forceCast(mapFromJson.get("httpStatus"), -1)).intValue();
        int iIntValue = ((Integer) ResHelper.forceCast(mapFromJson.get(NotificationCompat.CATEGORY_STATUS), -1)).intValue();
        String str = (String) ResHelper.forceCast(mapFromJson.get("res"), "");
        TextUtils.isEmpty(str);
        if (iIntValue != -1) {
            try {
                HashMap<String, Object> mapA = a(iIntValue, aVar, map, i, th);
                if (mapA != null) {
                    return mapA;
                }
            } catch (Throwable th2) {
                SMSLog.getInstance().d(th2, SMSLog.FORMAT, "Config", "handleThrowable", "ErrorStatus no need to be handled");
            }
            mapFromJson.put("description", b(iIntValue));
            mapFromJson.put("detail", c(iIntValue));
            throw new MobCommunicator.NetworkError(this.b.fromHashMap(mapFromJson));
        }
        throw th;
    }

    private HashMap<String, Object> a(int i, cn.smssdk.net.a aVar, HashMap<String, Object> map, int i2, Throwable th) throws Throwable {
        int iC;
        SMSLog.getInstance().d(SMSLog.FORMAT, "Config", "handleErrorStatus", "[" + aVar.b + "]Handle error status. status: " + i + ", count: " + i2);
        int i3 = i2 + 1;
        if (i == 453) {
            if ((aVar instanceof g) && (iC = aVar.c()) > 0) {
                aVar = a(iC);
            }
            return a(aVar, map, false, false, i3);
        }
        if (i == 419 || i == 420) {
            this.a.setToken("");
            return a(aVar, map, true, true, i3);
        }
        if (i == 401 || i == 402) {
            this.a.setToken("");
            return a(aVar, map, false, true, i3);
        }
        if (i == 482) {
            return a(aVar, map, false, false, i3);
        }
        throw th;
    }
}
