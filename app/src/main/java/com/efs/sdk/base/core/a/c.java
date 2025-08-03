package com.efs.sdk.base.core.a;

import android.text.TextUtils;
import com.efs.sdk.base.BuildConfig;
import com.efs.sdk.base.EfsConstant;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.PackageUtil;
import com.google.android.gms.dynamite.descriptors.com.google.mlkit.dynamite.face.ModuleDescriptor;
import com.umeng.analytics.pro.am;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/* loaded from: classes.dex */
public final class c {
    public String a;
    public String b;
    public String c;
    public String d;

    /* renamed from: e, reason: collision with root package name */
    public int f17639e;
    public String f;
    public byte g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public long m = 0;

    public static c a() {
        c cVar = new c();
        cVar.a = ControllerCenter.getGlobalEnvStruct().getAppid();
        cVar.b = ControllerCenter.getGlobalEnvStruct().getSecret();
        cVar.l = ControllerCenter.getGlobalEnvStruct().getUid();
        cVar.j = BuildConfig.VERSION_NAME;
        cVar.c = PackageUtil.getAppVersionName(ControllerCenter.getGlobalEnvStruct().mAppContext);
        cVar.i = String.valueOf(com.efs.sdk.base.core.config.a.c.a().d.a);
        cVar.k = EfsConstant.UM_SDK_VERSION;
        return cVar;
    }

    public final String b() {
        a.a();
        String strValueOf = String.valueOf(a.b() / 1000);
        String strA = com.efs.sdk.base.core.util.b.b.a(com.efs.sdk.base.core.util.b.a.a(this.l + strValueOf, this.b));
        TreeMap treeMap = new TreeMap();
        treeMap.put("app", this.a);
        treeMap.put("sd", strA);
        if (!TextUtils.isEmpty(this.d)) {
            treeMap.put("cp", this.d);
        }
        if (this.g != 0) {
            treeMap.put("de", String.valueOf(this.f17639e));
            treeMap.put("type", this.h);
            String str = this.f;
            if (TextUtils.isEmpty(str)) {
                a.a();
                long jB = a.b();
                str = String.format(Locale.SIMPLIFIED_CHINESE, "%d%04d", Long.valueOf(jB), Integer.valueOf(new Random(jB).nextInt(ModuleDescriptor.MODULE_VERSION)));
            }
            treeMap.put("seq", str);
        }
        treeMap.put("cver", this.i);
        treeMap.put(am.x, "android");
        treeMap.put("sver", this.i);
        treeMap.put("tm", strValueOf);
        treeMap.put("ver", this.c);
        treeMap.put("um_sdk_ver", this.k);
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry entry : treeMap.entrySet()) {
            String str2 = ((String) entry.getKey()) + "=" + ((String) entry.getValue());
            sb2.append(str2);
            sb.append(str2);
            sb.append("&");
        }
        String strA2 = com.efs.sdk.base.core.util.b.b.a(sb2.toString() + this.b);
        sb.append("sign=");
        sb.append(strA2);
        Log.d("efs.config", sb.toString());
        return com.efs.sdk.base.core.util.b.b.b(sb.toString());
    }
}
