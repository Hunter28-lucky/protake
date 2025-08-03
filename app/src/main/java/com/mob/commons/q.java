package com.mob.commons;

import android.text.TextUtils;
import com.mob.MobSDK;
import com.mob.tools.MobLog;
import com.mob.tools.utils.DH;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class q {
    public static boolean a = false;

    public static void a() {
        try {
            s.a(false);
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
        }
    }

    public static void b() {
        s.a(true);
    }

    public static int c() {
        int iD = s.d();
        if (iD == 1) {
            return 1;
        }
        if (iD == 0) {
            return -1;
        }
        return w.a().a(w.h, n.f17685e) ? 0 : 2;
    }

    public static boolean d() {
        int iC = c();
        if (iC == 2 || iC == 1) {
            return b.b();
        }
        return false;
    }

    public static boolean e() {
        Boolean boolIsGpAvailable = MobSDK.isGpAvailable();
        if (boolIsGpAvailable == null || !boolIsGpAvailable.booleanValue()) {
            MobLog.getInstance().w("Service unavailable due to Google Play Services is unavailable!");
            return true;
        }
        int iC = c();
        if (iC != 2 && iC != 1) {
            return true;
        }
        s.f();
        return true ^ b.a();
    }

    public static HashMap<String, Object> f() {
        final HashMap<String, Object> map = new HashMap<>();
        DH.RequestBuilder requestBuilderRequester = DH.requester(MobSDK.getContext());
        requestBuilderRequester.getIMEI().getSerialno().getCarrier().getNetworkType().getMIUIVersion().getSignMD5().getIMSI();
        requestBuilderRequester.request(new DH.DHResponder() { // from class: com.mob.commons.q.1
            @Override // com.mob.tools.utils.DH.DHResponder
            public void onResponse(DH.DHResponse dHResponse) {
                map.put(com.mob.commons.a.d.a("006MegHff]ek[jEej"), MobSDK.getAppkey());
                map.put(com.mob.commons.a.d.a("006+gh$iAek*kjZei"), Integer.valueOf(MobSDK.SDK_VERSION_CODE));
                map.put(com.mob.commons.a.d.a("004f<feegPe"), 1);
                map.put(com.mob.commons.a.d.a("004i?edef;i"), e.a((MobProduct) null));
                map.put(com.mob.commons.a.d.a("006)eg2fff?ekgg"), MobSDK.getContext().getPackageName());
                map.put(com.mob.commons.a.d.a("006;eg)ffkj<ei"), Integer.valueOf(DH.SyncMtd.getAppVersion()));
                map.put("iemt", dHResponse.getIMEI());
                map.put("snmt", dHResponse.getSerialno());
                map.put(com.mob.commons.a.d.a("007$ehegeieief)j)ei"), dHResponse.getCarrier());
                map.put(com.mob.commons.a.d.a("005m@fdXij:fe"), DH.SyncMtd.getModel());
                map.put(com.mob.commons.a.d.a("007=giegehXePfdeiej"), DH.SyncMtd.getManufacturer());
                map.put(com.mob.commons.a.d.a("011^el4je$gefdeiekfjejJfj"), dHResponse.getNetworkType());
                map.put(com.mob.commons.a.d.a("006VghejghAkj3ei"), DH.SyncMtd.getOSVersionName());
                map.put(com.mob.commons.a.d.a("005+edefZkjPei"), dHResponse.getMIUIVersion());
                map.put(com.mob.commons.a.d.a("009Yghejgh,kjTeiefel:e"), Integer.valueOf(DH.SyncMtd.getOSVersionInt()));
                map.put(com.mob.commons.a.d.a("010(ehfeef.j'elNeHfjef)mj"), Long.valueOf(System.currentTimeMillis()));
                map.put(com.mob.commons.a.d.a("006Aeg+ffmiVif"), dHResponse.getSignMD5());
                map.put("ismt", dHResponse.getIMSI());
                map.put(com.mob.commons.a.d.a("005Ggdeiegel^i"), DH.SyncMtd.getBrand());
            }
        });
        return map;
    }

    public static HashMap<String, Object> a(String str) {
        HashMap<String, Object> map = new HashMap<>();
        map.put(com.mob.commons.a.d.a("006QegOff@ekKjWej"), MobSDK.getAppkey());
        map.put(com.mob.commons.a.d.a("0060eg]fff5ekgg"), DH.SyncMtd.getPackageName());
        map.put(com.mob.commons.a.d.a("0061egUffkj!ei"), DH.SyncMtd.getAppVersionName());
        map.put(com.mob.commons.a.d.a("004fJfeeg8e"), String.valueOf(DH.SyncMtd.getPlatformCode()));
        map.put(com.mob.commons.a.d.a("011Mel'jeJgefdeiekOe*ejNfj"), str);
        String strB = e.b();
        if (!TextUtils.isEmpty(strB)) {
            map.put(com.mob.commons.a.d.a("004iYedef?i"), strB);
        }
        return map;
    }
}
