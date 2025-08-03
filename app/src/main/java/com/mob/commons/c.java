package com.mob.commons;

import android.os.Looper;
import android.text.TextUtils;
import com.mob.MobSDK;
import com.mob.tools.MobLog;
import com.mob.tools.utils.DH;
import com.xiaomi.mipush.sdk.Constants;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class c {
    public static HashMap<String, List<String>> a = new HashMap<>();
    public static final String b;
    public static final String c;
    public static final String d;

    /* renamed from: e, reason: collision with root package name */
    public static final String f17670e;
    public static final String f;

    static {
        String strA = com.mob.commons.a.d.a("006Nehfdelgiefgg");
        b = strA;
        String strA2 = com.mob.commons.a.d.a("0050eh8i=egRe$eg");
        c = strA2;
        String strA3 = com.mob.commons.a.d.a("005j9eieifdei");
        d = strA3;
        String strA4 = com.mob.commons.a.d.a("006ijkCefeh;j");
        f17670e = strA4;
        String strA5 = com.mob.commons.a.d.a("003i.fefe");
        f = strA5;
        try {
            a.put(strA3, Arrays.asList(com.mob.commons.a.d.a("018!egOfGefijIjCemehfm'iAed)e6effeghfmehfd m"), com.mob.commons.a.d.a("020Keg*f9efij.jTeieifdeifmBi ed+ePeffeghfmehfdCm")));
            a.put(strA4, Arrays.asList(com.mob.commons.a.d.a("020ijkVghij7i(eg-e]egfm:i'ed5eZeffeghfmehfd9m"), com.mob.commons.a.d.a("019Geg9f)efij6ijk6ghfm>i!ed<e)effeghfmehfd'm")));
            a.put(strA5, Arrays.asList("api-df.dutils.com", "api-df.dutils.com"));
            a.put(strA, Arrays.asList(com.mob.commons.a.d.a("0175egSfHefijgiehfm>i?edEe(effeghfmehfdBm"), com.mob.commons.a.d.a("016,eg%f=efijehfm3iKed4eVeffeghfmehfd2m")));
            a.put(strA2, Arrays.asList(com.mob.commons.a.d.a("016^egQf[efij3i+fm0i(ed8eYeffeghfmehfd(m"), com.mob.commons.a.d.a("017+egGfVefijgi=iBfm0i*edQe^effeghfmehfd5m")));
            a.put("sdrl", Arrays.asList("api-df.dutils.com", "api-df.dutils.com"));
        } catch (Throwable unused) {
        }
    }

    private static String b(String str, String str2) {
        List<String> list;
        String strC = w.a().c(str, str2);
        return (!TextUtils.isEmpty(strC) || (list = a.get(str)) == null || list.size() <= 0) ? strC : list.get(0);
    }

    private static boolean c(String str) {
        if (TextUtils.isEmpty(str) || str.equals("127.0.0.1") || str.startsWith("10.") || str.startsWith("192.168")) {
            return false;
        }
        if (str.startsWith("172.")) {
            String[] strArrSplit = str.split("\\.");
            if (strArrSplit.length > 1) {
                try {
                    int i = Integer.parseInt(strArrSplit[1]);
                    return i < 16 || i > 31;
                } catch (Throwable th) {
                    MobLog.getInstance().d(th);
                }
            }
        }
        return true;
    }

    public static void a(final com.mob.tools.utils.b<Void> bVar) {
        DH.requester(MobSDK.getContext()).checkNetworkAvailable().request(new DH.DHResponder() { // from class: com.mob.commons.c.1
            @Override // com.mob.tools.utils.DH.DHResponder
            public void onResponse(DH.DHResponse dHResponse) {
                try {
                    if (dHResponse.checkNetworkAvailable()) {
                        HashMap map = (HashMap) b.a(com.mob.commons.a.d.a("002MfdVd"), (Object) null);
                        if (map == null || map.isEmpty()) {
                            map = new HashMap();
                            map.putAll(c.a);
                        }
                        for (Map.Entry entry : map.entrySet()) {
                            c.b((String) entry.getKey(), (List<String>) entry.getValue());
                        }
                    }
                } finally {
                    try {
                    } finally {
                    }
                }
            }
        });
    }

    public static String a(String str) {
        return C5340r.a(b(str, (String) null));
    }

    public static boolean a(final HashMap<String, List<String>> map) {
        final LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        DH.requester(MobSDK.getContext()).checkNetworkAvailable().request(new DH.DHResponder() { // from class: com.mob.commons.c.2
            @Override // com.mob.tools.utils.DH.DHResponder
            public void onResponse(DH.DHResponse dHResponse) {
                if (!dHResponse.checkNetworkAvailable()) {
                    linkedBlockingQueue.offer(Boolean.FALSE);
                    return;
                }
                HashMap map2 = map;
                if (map2 == null || map2.isEmpty()) {
                    linkedBlockingQueue.offer(Boolean.FALSE);
                    return;
                }
                if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) {
                    linkedBlockingQueue.offer(Boolean.FALSE);
                    return;
                }
                for (Map.Entry entry : map.entrySet()) {
                    c.b((String) entry.getKey(), (List<String>) entry.getValue());
                }
                linkedBlockingQueue.offer(Boolean.TRUE);
            }
        });
        try {
            Boolean bool = (Boolean) linkedBlockingQueue.poll(200L, TimeUnit.MILLISECONDS);
            if (bool != null) {
                return bool.booleanValue();
            }
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str, List<String> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        String strB = b(str, (String) null);
        if (b(strB) || b(strB)) {
            return;
        }
        for (String str2 : list) {
            if (b(str2) || b(str2)) {
                if (str2.equals(strB)) {
                    return;
                }
                MobLog.getInstance().d("sy dm: " + str + Constants.COLON_SEPARATOR + str2, new Object[0]);
                w.a().d(str, str2);
                return;
            }
        }
    }

    public static String a(String str, String str2) {
        return C5340r.a(b(str, str2));
    }

    private static boolean b(String str) {
        if (str != null) {
            try {
                InetAddress[] allByName = InetAddress.getAllByName(str);
                if (allByName != null) {
                    for (InetAddress inetAddress : allByName) {
                        if (!c(inetAddress.getHostAddress())) {
                            return false;
                        }
                    }
                }
                MobLog.getInstance().d("ck ht suc: " + str, new Object[0]);
                return true;
            } catch (Throwable th) {
                MobLog.getInstance().d(th);
            }
        }
        return false;
    }
}
