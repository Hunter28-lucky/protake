package cn.smssdk.net;

import android.text.TextUtils;
import cn.smssdk.utils.SMSLog;
import com.mob.MobCommunicator;
import com.mob.MobSDK;
import com.mob.commons.ForbThrowable;
import com.mob.tools.utils.Hashon;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: BaseApi.java */
/* loaded from: classes.dex */
public abstract class a {
    private static MobCommunicator i;
    private static Hashon j;
    public int a;
    public String b;
    public String c;
    public boolean d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f17619e;
    public boolean f = false;
    public ReentrantReadWriteLock g;
    public ArrayList<String> h;

    public a() {
        if (j == null) {
            j = new Hashon();
        }
    }

    public abstract HashMap<String, Object> a(String str, String str2, HashMap<String, Object> map) throws Throwable;

    public void a(ReentrantReadWriteLock reentrantReadWriteLock) {
        this.g = reentrantReadWriteLock;
    }

    public abstract boolean a() throws Throwable;

    public String b() {
        return this.b;
    }

    public int c() {
        return this.a;
    }

    public String b(String str, String str2, HashMap<String, Object> map) throws Throwable {
        if (MobSDK.isForb()) {
            throw new ForbThrowable();
        }
        if (a()) {
            SMSLog.getInstance().w(SMSLog.FORMAT, "BaseApi", "request", "[" + this.b + "]Request limited.");
            return "";
        }
        try {
            ReentrantReadWriteLock reentrantReadWriteLock = this.g;
            if (reentrantReadWriteLock != null) {
                reentrantReadWriteLock.readLock().lock();
            }
            HashMap<String, Object> mapA = a(str, str2, map);
            if (mapA == null) {
                mapA = new HashMap<>();
            }
            if (!mapA.containsKey("duid")) {
                mapA.put("duid", str);
                String str3 = this.b;
                if (str3 == null || !str3.equals("getToken")) {
                    mapA.put("duid", "Api: " + this.b + " duid: " + str + " is added by workaround.");
                } else {
                    mapA.put("duidinfo_x17zcD", "Api: " + this.b + " duid: " + str + " added by workaround. " + b.f() + " params is : " + cn.smssdk.utils.c.a(this.h) + " cfgsrv: " + cn.smssdk.utils.c.a(b.x) + "cfgsp: " + cn.smssdk.utils.c.a(b.y));
                }
            } else if (TextUtils.isEmpty((String) mapA.get("duid"))) {
                if (TextUtils.isEmpty(str)) {
                    mapA.put("duidinfo_x17zcD", "Api: " + this.b + " duid got from CommonsLib is invalid.");
                } else {
                    mapA.put("duid", str);
                    mapA.put("duidinfo_x17zcD", "Api: " + this.b + " duid build to params is invalid and added by workaround.");
                }
            }
            if (i == null) {
                Object[] objArrA = c.a();
                i = new MobCommunicator(((Integer) objArrA[2]).intValue(), (String) objArrA[0], (String) objArrA[1]);
            }
            return j.fromObject(i.requestSynchronized(mapA, MobSDK.checkRequestUrl(this.c), this.d));
        } finally {
            ReentrantReadWriteLock reentrantReadWriteLock2 = this.g;
            if (reentrantReadWriteLock2 != null) {
                reentrantReadWriteLock2.readLock().unlock();
            }
        }
    }
}
