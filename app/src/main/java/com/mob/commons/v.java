package com.mob.commons;

import android.text.TextUtils;
import android.util.Base64;
import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import com.mob.MobSDK;
import com.mob.tools.MobLog;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.Data;
import com.xiaomi.mipush.sdk.Constants;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public class v {
    public static final String[] a = {"SHARESDK", n.b("006Pdgfhdgdgehgi"), "MOBLINK", "MOBPUSH", n.b("009Mdgfcfffefcfddfejhh"), n.b("0083fhekeidiehdgehgi"), "MOBGUARD"};
    private static AtomicBoolean b = new AtomicBoolean(false);
    private static final HashMap<String, MobProduct> c = new HashMap<>();
    private static String d;

    public static void a() {
        f();
        u.c.execute(new com.mob.tools.utils.e() { // from class: com.mob.commons.v.1
            @Override // com.mob.tools.utils.e
            public void a() {
                MobLog.getInstance().d("init sks start", new Object[0]);
                v.b();
                MobLog.getInstance().d("init sks over", new Object[0]);
            }
        });
    }

    public static ArrayList<MobProduct> b() {
        ArrayList<MobProduct> arrayList;
        HashMap<String, MobProduct> map = c;
        synchronized (map) {
            if (b.compareAndSet(false, true)) {
                map.putAll(g());
            }
            arrayList = new ArrayList<>();
            arrayList.addAll(map.values());
        }
        return arrayList;
    }

    public static synchronized String c() {
        return a(b(), 0);
    }

    public static synchronized String d() {
        return a(b(), 2);
    }

    private static void f() {
        try {
            MOBLINK moblink = new MOBLINK();
            if (moblink instanceof MobProduct) {
                moblink.getProductTag();
            }
        } catch (Throwable unused) {
        }
    }

    private static HashMap<String, MobProduct> g() {
        Class<?> cls;
        HashMap<String, MobProduct> map = new HashMap<>();
        for (Object obj : p.a) {
            try {
                cls = obj instanceof String ? Class.forName(String.valueOf(obj).trim()) : (Class) obj;
            } catch (Throwable unused) {
            }
            if (!MobProduct.class.isAssignableFrom(cls) || MobProduct.class.equals(cls)) {
                cls.newInstance();
            } else {
                MobProduct mobProduct = (MobProduct) cls.newInstance();
                String productTag = mobProduct.getProductTag();
                String[] strArr = a;
                int length = strArr.length;
                int i = 0;
                while (true) {
                    if (i < length) {
                        String str = strArr[i];
                        if (str.equals(productTag)) {
                            map.put(str, mobProduct);
                            break;
                        }
                        i++;
                    }
                }
            }
        }
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String h() {
        if (!TextUtils.isEmpty(d)) {
            return d;
        }
        String strO = com.mob.tools.a.c.a(MobSDK.getContext()).b().o();
        if (!TextUtils.isEmpty(strO)) {
            try {
                String strEncodeToString = Base64.encodeToString(Data.AES128Encode(Data.MD5(DH.SyncMtd.getManufacturer()), strO), 2);
                d = strEncodeToString;
                return strEncodeToString;
            } catch (Throwable th) {
                MobLog.getInstance().d(th);
            }
        }
        return null;
    }

    public static void a(MobProduct mobProduct) {
        HashMap<String, MobProduct> map = c;
        synchronized (map) {
            if (mobProduct != null) {
                if (!map.containsKey(mobProduct.getProductTag())) {
                    map.put(mobProduct.getProductTag(), mobProduct);
                }
            }
        }
    }

    private static synchronized String a(final ArrayList<MobProduct> arrayList, final int i) {
        final String[] strArr;
        strArr = new String[]{""};
        DH.RequestBuilder carrier = DH.requester(MobSDK.getContext()).getMIUIVersion().getNetworkTypeForStatic().getCarrier();
        if (s.b()) {
            carrier.getDeviceKey();
        } else {
            carrier.getDeviceKeyFromCache(true);
        }
        carrier.request(new DH.DHResponder() { // from class: com.mob.commons.v.2
            @Override // com.mob.tools.utils.DH.DHResponder
            public void onResponse(DH.DHResponse dHResponse) {
                String str;
                String str2;
                int i2;
                try {
                    String str3 = "";
                    String strEncode = TextUtils.isEmpty(DH.SyncMtd.getPackageName()) ? "" : URLEncoder.encode(DH.SyncMtd.getPackageName(), "utf-8");
                    String strEncode2 = TextUtils.isEmpty(DH.SyncMtd.getAppVersionName()) ? "" : URLEncoder.encode(DH.SyncMtd.getAppVersionName(), "utf-8");
                    String strEncode3 = TextUtils.isEmpty(DH.SyncMtd.getManufacturer()) ? "" : URLEncoder.encode(DH.SyncMtd.getManufacturer(), "utf-8");
                    String strEncode4 = TextUtils.isEmpty(DH.SyncMtd.getModel()) ? "" : URLEncoder.encode(DH.SyncMtd.getModel(), "utf-8");
                    String strEncode5 = TextUtils.isEmpty(dHResponse.getMIUIVersion()) ? "" : URLEncoder.encode(dHResponse.getMIUIVersion(), "utf-8");
                    String strEncode6 = TextUtils.isEmpty(DH.SyncMtd.getOSVersionName()) ? "" : URLEncoder.encode(DH.SyncMtd.getOSVersionName(), "utf-8");
                    HashMap<String, Object> mapB = o.a().b();
                    String str4 = n.b("0044difgfg6f") + strEncode + ";" + strEncode2;
                    String str5 = n.b("012Bdghhdg[fOdicj[gMcgdbcdIgIic") + DH.SyncMtd.getOSVersionInt() + ";" + strEncode6;
                    int i3 = 0;
                    String str6 = n.b("004Ndgehdf^f") + (s.b() ? dHResponse.getDeviceKey() : dHResponse.getDeviceKeyFromCache(new int[0]));
                    String str7 = n.b("003Xejfh(f") + strEncode3 + ";" + strEncode4;
                    if (!TextUtils.isEmpty(strEncode5)) {
                        str7 = str7 + ";" + strEncode5;
                    }
                    String str8 = n.b("0039defc0f") + dHResponse.getNetworkTypeForStatic() + ";" + dHResponse.getCarrier();
                    String str9 = n.b("005(djcecjee)f") + Locale.getDefault().toString().replace(n.b("002-ghcg"), Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    String str10 = n.b("004!ffdjfe1f") + MobSDK.SDK_VERSION_CODE;
                    String strB = n.b("004Odgehgi-f");
                    if (!arrayList.isEmpty()) {
                        int size = arrayList.size();
                        while (i3 < size) {
                            String str11 = str3;
                            try {
                                MobProduct mobProduct = (MobProduct) arrayList.get(i3);
                                if (i3 != 0) {
                                    i2 = size;
                                    try {
                                        strB = strB + Constants.ACCEPT_TIME_SEPARATOR_SP;
                                    } catch (Throwable unused) {
                                    }
                                } else {
                                    i2 = size;
                                }
                                try {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(strB);
                                    String str12 = strB;
                                    try {
                                        sb.append(mobProduct.getProductTag());
                                        sb.append(";");
                                        sb.append(mobProduct.getSdkver());
                                        sb.append(";");
                                        sb.append(mapB.get(mobProduct.getProductTag()));
                                        strB = sb.toString();
                                    } catch (Throwable unused2) {
                                        strB = str12;
                                    }
                                } catch (Throwable unused3) {
                                }
                            } catch (Throwable unused4) {
                                i2 = size;
                            }
                            i3++;
                            size = i2;
                            str3 = str11;
                        }
                    }
                    String str13 = str3;
                    String str14 = "DC/6";
                    int i4 = i;
                    if (i4 == 1) {
                        str14 = "DC/[DC]";
                    } else if (i4 == 2) {
                        str14 = "DC/[DC2]";
                    }
                    String timezone = DH.SyncMtd.getTimezone();
                    if (TextUtils.isEmpty(timezone)) {
                        str = str13;
                    } else {
                        str = n.b("003$dhjccc") + timezone;
                    }
                    String strC = x.a().c();
                    String str15 = "TID/";
                    if (!TextUtils.isEmpty(strC)) {
                        str15 = "TID/" + strC;
                    }
                    String str16 = "IED/";
                    String strH = v.h();
                    if (TextUtils.isEmpty(strH)) {
                        str2 = str15;
                    } else {
                        str2 = str15;
                        str16 = "IED/" + strH;
                    }
                    int iA = com.mob.commons.cc.a.a();
                    StringBuilder sb2 = new StringBuilder();
                    String str17 = str16;
                    sb2.append("SVM/");
                    sb2.append(iA);
                    String string = sb2.toString();
                    if (com.mob.tools.a.d.b()) {
                        if (!n.b("004HdgehgiRf").equals(strB)) {
                            strB = strB + Constants.ACCEPT_TIME_SEPARATOR_SP;
                        }
                        strB = strB + "CS;" + iA;
                    }
                    String str18 = "RD/";
                    String strF = t.a().f();
                    if (!TextUtils.isEmpty(strF)) {
                        str18 = "RD/" + strF;
                    }
                    strArr[0] = str4 + MyUTIL.white_space + str5 + MyUTIL.white_space + str6 + MyUTIL.white_space + str7 + MyUTIL.white_space + str8 + MyUTIL.white_space + str9 + MyUTIL.white_space + str10 + MyUTIL.white_space + strB + MyUTIL.white_space + str14 + MyUTIL.white_space + str + MyUTIL.white_space + str2 + MyUTIL.white_space + str17 + MyUTIL.white_space + string + MyUTIL.white_space + str18;
                } catch (Throwable th) {
                    MobLog.getInstance().w(th);
                }
            }
        });
        return strArr[0];
    }
}
