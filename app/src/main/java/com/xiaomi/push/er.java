package com.xiaomi.push;

import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.xiaomi.push.dq;
import com.xiaomi.push.service.am;
import java.util.HashMap;

/* loaded from: classes2.dex */
class er {
    public static void a(am.b bVar, String str, fb fbVar) throws NumberFormatException {
        String strA;
        dq.c cVar = new dq.c();
        if (!TextUtils.isEmpty(bVar.c)) {
            cVar.a(bVar.c);
        }
        if (!TextUtils.isEmpty(bVar.f17900e)) {
            cVar.d(bVar.f17900e);
        }
        if (!TextUtils.isEmpty(bVar.f)) {
            cVar.e(bVar.f);
        }
        cVar.b(bVar.f6406a ? "1" : "0");
        if (TextUtils.isEmpty(bVar.d)) {
            cVar.c("XIAOMI-SASL");
        } else {
            cVar.c(bVar.d);
        }
        es esVar = new es();
        esVar.c(bVar.f6407b);
        esVar.a(Integer.parseInt(bVar.g));
        esVar.b(bVar.f6404a);
        esVar.a("BIND", (String) null);
        esVar.a(esVar.e());
        com.xiaomi.channel.commonutils.logger.b.m5113a("[Slim]: bind id=" + esVar.e());
        HashMap map = new HashMap();
        map.put("challenge", str);
        map.put("token", bVar.c);
        map.put("chid", bVar.g);
        map.put(TypedValues.TransitionType.S_FROM, bVar.f6407b);
        map.put("id", esVar.e());
        map.put(TypedValues.TransitionType.S_TO, "xiaomi.com");
        if (bVar.f6406a) {
            map.put("kick", "1");
        } else {
            map.put("kick", "0");
        }
        if (TextUtils.isEmpty(bVar.f17900e)) {
            map.put("client_attrs", "");
        } else {
            map.put("client_attrs", bVar.f17900e);
        }
        if (TextUtils.isEmpty(bVar.f)) {
            map.put("cloud_attrs", "");
        } else {
            map.put("cloud_attrs", bVar.f);
        }
        if (bVar.d.equals("XIAOMI-PASS") || bVar.d.equals("XMPUSH-PASS")) {
            strA = ba.a(bVar.d, null, map, bVar.h);
        } else {
            bVar.d.equals("XIAOMI-SASL");
            strA = null;
        }
        cVar.f(strA);
        esVar.a(cVar.m5437a(), (String) null);
        fbVar.b(esVar);
    }

    public static void a(String str, String str2, fb fbVar) throws NumberFormatException {
        es esVar = new es();
        esVar.c(str2);
        esVar.a(Integer.parseInt(str));
        esVar.a("UBND", (String) null);
        fbVar.b(esVar);
    }
}
