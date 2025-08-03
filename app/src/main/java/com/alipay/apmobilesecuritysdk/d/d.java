package com.alipay.apmobilesecuritysdk.d;

import android.content.Context;
import defpackage.te;
import defpackage.wc;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class d {
    public static synchronized Map<String, String> a() {
        HashMap map;
        map = new HashMap();
        try {
            new com.alipay.apmobilesecuritysdk.c.b();
            map.put("AE16", "");
        } catch (Throwable unused) {
        }
        return map;
    }

    public static synchronized Map<String, String> a(Context context) {
        HashMap map;
        te.m8309();
        wc.m8529();
        map = new HashMap();
        map.put("AE1", te.m8312());
        StringBuilder sb = new StringBuilder();
        sb.append(te.m8313() ? "1" : "0");
        map.put("AE2", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(te.m8311(context) ? "1" : "0");
        map.put("AE3", sb2.toString());
        map.put("AE4", te.m8314());
        map.put("AE5", te.m8315());
        map.put("AE6", te.m8316());
        map.put("AE7", te.m8317());
        map.put("AE8", te.m8318());
        map.put("AE9", te.m8319());
        map.put("AE10", te.m8320());
        map.put("AE11", te.m8321());
        map.put("AE12", te.m8322());
        map.put("AE13", te.m8323());
        map.put("AE14", te.m8324());
        map.put("AE15", te.m8325());
        map.put("AE21", wc.m8536());
        return map;
    }
}
