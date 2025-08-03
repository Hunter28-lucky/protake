package com.xiaomi.push.service;

import android.os.SystemClock;
import android.text.TextUtils;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public class k {
    private static final Map<String, Long> a = new HashMap();

    public static boolean a(byte[] bArr, String str) throws NoSuchAlgorithmException {
        boolean z = false;
        if (bArr != null && bArr.length > 0 && !TextUtils.isEmpty(str)) {
            String strA = com.xiaomi.push.bc.a(bArr);
            if (!TextUtils.isEmpty(strA)) {
                Map<String, Long> map = a;
                synchronized (map) {
                    if (map.get(strA + str) != null) {
                        z = true;
                    } else {
                        map.put(strA + str, Long.valueOf(SystemClock.elapsedRealtime()));
                    }
                    a();
                }
            }
        }
        return z;
    }

    private static void a() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Map<String, Long> map = a;
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, Long> entry : map.entrySet()) {
            if (jElapsedRealtime - entry.getValue().longValue() > 60000) {
                arrayList.add(entry.getKey());
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            a.remove((String) it.next());
        }
    }
}
