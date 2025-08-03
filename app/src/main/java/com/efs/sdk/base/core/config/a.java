package com.efs.sdk.base.core.config;

import android.text.TextUtils;
import com.efs.sdk.base.protocol.file.section.AbsSection;
import com.efs.sdk.base.protocol.file.section.KVSection;
import com.umeng.umcrash.UMCrash;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class a {
    private Map<String, Object> a = new ConcurrentHashMap();

    public final void a(String str, Object obj) {
        if (obj != null) {
            this.a.put(str, obj);
        }
    }

    public final Object b(String str, Object obj) {
        Object obj2 = this.a.get(str);
        return (obj2 != null || this.a.containsKey(str)) ? obj2 : obj;
    }

    public final Map<String, Object> a() {
        HashMap map = new HashMap(this.a);
        com.efs.sdk.base.core.a.a.a();
        map.put("ctime", Long.valueOf(com.efs.sdk.base.core.a.a.b() / 1000));
        com.efs.sdk.base.core.a.a.a();
        map.put("w_tm", Long.valueOf(com.efs.sdk.base.core.a.a.b() / 1000));
        return map;
    }

    public final List<AbsSection> a(String str) {
        ArrayList arrayList = new ArrayList();
        KVSection kVSection = new KVSection("global_head");
        KVSection kVSectionPut = kVSection.put("type", str).put("appid", this.a.get("appid")).put("wid", this.a.get("wid")).put("pid", this.a.get("pid")).put("pkg", this.a.get("pkg")).put("ver", this.a.get("ver")).put("vcode", this.a.get("vcode")).put("ps", this.a.get("ps")).put("stime", this.a.get("stime"));
        com.efs.sdk.base.core.a.a.a();
        KVSection kVSectionPut2 = kVSectionPut.put("ctime", Long.valueOf(com.efs.sdk.base.core.a.a.b() / 1000));
        com.efs.sdk.base.core.a.a.a();
        kVSectionPut2.put("w_tm", Long.valueOf(com.efs.sdk.base.core.a.a.b() / 1000)).put("sdk_ver", this.a.get("sdk_ver"));
        String strValueOf = String.valueOf(b("uid", ""));
        if (!TextUtils.isEmpty(strValueOf)) {
            kVSection.put("uid", strValueOf);
        }
        arrayList.add(kVSection);
        KVSection kVSection2 = new KVSection("device_info");
        kVSection2.put("lang", this.a.get("lang")).put(Constants.PHONE_BRAND, this.a.get(Constants.PHONE_BRAND)).put("model", this.a.get("model")).put("build_model", this.a.get("build_model")).put("rom", this.a.get("rom")).put("sdk", this.a.get("sdk")).put("dsp_h", this.a.get("dsp_h")).put("dsp_w", this.a.get("dsp_w")).put("tzone", this.a.get("tzone")).put("net", this.a.get("net")).put("fr", this.a.get("fr"));
        try {
            if (this.a.containsKey(UMCrash.KEY_HEADER_ACCESS)) {
                kVSection2.put(UMCrash.KEY_HEADER_ACCESS, this.a.get(UMCrash.KEY_HEADER_ACCESS));
            }
            if (this.a.containsKey(UMCrash.KEY_HEADER_ACCESS_SUBTYPE)) {
                kVSection2.put(UMCrash.KEY_HEADER_ACCESS_SUBTYPE, this.a.get(UMCrash.KEY_HEADER_ACCESS_SUBTYPE));
            }
            if (this.a.containsKey(UMCrash.KEY_HEADER_NETWORK_TYPE)) {
                kVSection2.put(UMCrash.KEY_HEADER_NETWORK_TYPE, this.a.get(UMCrash.KEY_HEADER_NETWORK_TYPE));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        arrayList.add(kVSection2);
        return arrayList;
    }
}
