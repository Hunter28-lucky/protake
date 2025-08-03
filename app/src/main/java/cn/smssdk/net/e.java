package cn.smssdk.net;

import cn.smssdk.utils.DHelper;
import cn.smssdk.utils.SMSLog;
import com.blink.academy.film.stream.FinderManager;
import com.mob.MobSDK;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.Hashon;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: ParamsBuilder.java */
/* loaded from: classes.dex */
public class e {
    private static boolean b;
    private static HashMap<String, Object> c;
    private static boolean d;

    /* renamed from: e, reason: collision with root package name */
    private static e f17621e;
    private Hashon a = new Hashon();

    private e() {
    }

    public static e a() {
        if (f17621e == null) {
            synchronized (e.class) {
                f17621e = new e();
            }
        }
        return f17621e;
    }

    public static void b() {
        boolean zCheckPermission;
        HashMap<String, Object> map = new HashMap<>();
        c = map;
        map.put("plat", Integer.valueOf(DH.SyncMtd.getPlatformCode()));
        c.put("sdkver", Integer.valueOf(cn.smssdk.utils.e.b()));
        c.put("md5", DHelper.getSignMd5());
        try {
            zCheckPermission = DH.SyncMtd.checkPermission("android.permission.READ_PHONE_STATE");
            d = zCheckPermission;
        } catch (Throwable th) {
            SMSLog.getInstance().d(th, SMSLog.FORMAT, "ParamsBuilder", "prepare", "Obtain device info error");
        }
        String serialNumber = zCheckPermission ? DHelper.getSerialNumber() : null;
        String carrier = DHelper.getCarrier();
        if (carrier != null && !carrier.equals(FinderManager.MACHINE_NOT_VALID)) {
            c.put("operator", carrier);
        }
        if (serialNumber != null && !serialNumber.equals(FinderManager.MACHINE_NOT_VALID)) {
            c.put("simserial", serialNumber);
        }
        c.put("apppkg", DH.SyncMtd.getPackageName());
        c.put("appver", DH.SyncMtd.getAppVersionName());
        b = true;
    }

    public HashMap<String, Object> a(int i, ArrayList<String> arrayList, String str, String str2, HashMap<String, Object> map) throws Throwable {
        if (b) {
            if (cn.smssdk.utils.a.c.booleanValue()) {
                SMSLog.getInstance().d(SMSLog.FORMAT, "ParamsBuilder", "buildParams", "Build params. config: " + cn.smssdk.utils.c.a(arrayList));
                String strFromHashMap = map != null ? this.a.fromHashMap(map) : null;
                SMSLog.getInstance().d(SMSLog.FORMAT, "ParamsBuilder", "buildParams", "Build params. extParams: " + strFromHashMap);
            }
            HashMap<String, Object> map2 = new HashMap<>();
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next.equals("appkey")) {
                    map2.put("appkey", MobSDK.getAppkey());
                } else if (next.equals("token")) {
                    map2.put("token", str2);
                } else if (next.equals("duid")) {
                    map2.put("duid", str);
                } else {
                    Object obj = c.get(next);
                    if (obj == null) {
                        obj = map.get(next);
                    }
                    map2.put(next, obj);
                }
            }
            return map2;
        }
        throw new Throwable("ParamsBuilder need prepare before use");
    }
}
