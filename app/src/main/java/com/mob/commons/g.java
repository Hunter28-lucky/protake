package com.mob.commons;

import android.text.TextUtils;
import com.mob.MobSDK;
import com.mob.tools.MobLog;
import com.mob.tools.utils.DH;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class g {
    private static g a = new g();
    private volatile boolean b = false;
    private volatile long c = 0;

    private g() {
    }

    public static g a() {
        return a;
    }

    private synchronized boolean c() {
        try {
            long jLongValue = ((Long) b.a(i.a("004k4fi)k*fn"), 5L)).longValue() * 1000;
            if (this.c != 0 && System.currentTimeMillis() - this.c <= jLongValue) {
                return this.b;
            }
            boolean zA = a((String) b.a(i.a("002'fi@j"), i.a("006;imiminininin")));
            if (this.c == 0 || zA != this.b) {
                a(zA);
            }
            this.c = System.currentTimeMillis();
            this.b = zA;
            return zA;
        } catch (Throwable th) {
            MobLog.getInstance().e(th);
            return true;
        }
    }

    public synchronized boolean b() {
        return !c();
    }

    private boolean a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            char[] charArray = str.toCharArray();
            HashMap map = new HashMap();
            boolean zA = false;
            for (int i = 0; i < charArray.length; i++) {
                char c = charArray[i];
                if (c == '1') {
                    zA |= a(i);
                } else if (c != '0') {
                    List arrayList = (List) map.get(Character.valueOf(c));
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(Integer.valueOf(i));
                    map.put(Character.valueOf(charArray[i]), arrayList);
                }
                if (zA) {
                    return true;
                }
            }
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                Iterator it2 = ((List) ((Map.Entry) it.next()).getValue()).iterator();
                boolean zA2 = true;
                while (it2.hasNext()) {
                    zA2 &= a(((Integer) it2.next()).intValue());
                }
                zA |= zA2;
                if (zA) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            MobLog.getInstance().e(th);
            return true;
        }
    }

    private boolean a(final int i) {
        final boolean[] zArr = {true};
        DH.RequestBuilder requestBuilderRequester = DH.requester(MobSDK.getContext());
        if (i == 0) {
            requestBuilderRequester.checkUA();
        } else if (i == 1) {
            requestBuilderRequester.usbEnable();
        } else if (i == 2) {
            requestBuilderRequester.vpn();
        } else if (i == 3) {
            requestBuilderRequester.isWifiProxy();
        } else if (i == 4) {
            requestBuilderRequester.isRooted();
        } else if (i == 5) {
            requestBuilderRequester.cx();
        }
        requestBuilderRequester.request(new DH.DHResponder() { // from class: com.mob.commons.g.1
            @Override // com.mob.tools.utils.DH.DHResponder
            public void onResponse(DH.DHResponse dHResponse) {
                int i2 = i;
                if (i2 == 0) {
                    zArr[0] = dHResponse.checkUA();
                    return;
                }
                if (i2 == 1) {
                    zArr[0] = dHResponse.usbEnable();
                    return;
                }
                if (i2 == 2) {
                    zArr[0] = dHResponse.vpn();
                    return;
                }
                if (i2 == 3) {
                    zArr[0] = dHResponse.isWifiProxy();
                } else if (i2 == 4) {
                    zArr[0] = dHResponse.isRooted();
                } else {
                    if (i2 != 5) {
                        return;
                    }
                    zArr[0] = dHResponse.cx();
                }
            }
        });
        return zArr[0];
    }

    private void a(boolean z) {
        HashMap map = new HashMap();
        map.put(i.a("005Pfigf[k[fhfj"), Integer.valueOf(!z ? 1 : 0));
        map.put(i.a("002@fefi"), Integer.valueOf(a(0) ? 1 : 0));
        map.put(i.a("002GfeWj"), Integer.valueOf(a(1) ? 1 : 0));
        map.put(i.a("002lg"), Integer.valueOf(a(2) ? 1 : 0));
        map.put(i.a("002WhfAg"), Integer.valueOf(a(3) ? 1 : 0));
        map.put(i.a("002Sfj[f"), Integer.valueOf(a(4) ? 1 : 0));
        map.put(i.a("002 fn)g"), Integer.valueOf(a(5) ? 1 : 0));
        long jCurrentTimeMillis = System.currentTimeMillis();
        HashMap<String, Object> map2 = new HashMap<>();
        map2.put(i.a("004fCfkMgk"), "ECMT");
        map2.put(i.a("004j9fh3fEfh"), map);
        map2.put(i.a("008j fhVfkfSfg0nk"), Long.valueOf(jCurrentTimeMillis));
        d.a().a(jCurrentTimeMillis, map2);
    }
}
