package com.efs.sdk.base.core.config.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.efs.sdk.base.core.controller.ControllerCenter;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class b {
    public int a = -1;
    public String b = "https://";
    public String c = "errnewlog.umeng.com";
    public long d = 480;
    private Boolean g = null;

    /* renamed from: e, reason: collision with root package name */
    public Map<String, Double> f17643e = new HashMap();
    public Map<String, String> f = new HashMap();

    private b() {
    }

    public static b a() {
        b bVar = new b();
        if (ControllerCenter.getGlobalEnvStruct().isIntl()) {
            bVar.c = "errnewlogos.umeng.com";
        } else {
            bVar.c = "errnewlog.umeng.com";
        }
        return bVar;
    }

    public final void a(@NonNull Map<String, String> map) {
        if (map.containsKey("gate_way")) {
            String str = map.get("gate_way");
            if (!TextUtils.isEmpty(str)) {
                this.c = str;
            }
        }
        if (map.containsKey("gate_way_https")) {
            String str2 = map.get("gate_way_https");
            if (!TextUtils.isEmpty(str2)) {
                this.b = Boolean.parseBoolean(str2) ? "https://" : "http://";
            }
        }
        try {
            if (map.containsKey("updateInteval")) {
                String str3 = map.get("updateInteval");
                if (!TextUtils.isEmpty(str3)) {
                    this.d = Long.parseLong(str3);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        HashMap map2 = new HashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            if (key.startsWith("data_sampling_rate_") || key.startsWith("file_sampling_rate_")) {
                String strReplace = key.replace("data_sampling_rate_", "").replace("file_sampling_rate_", "");
                double d = 100.0d;
                try {
                    d = Double.parseDouble(entry.getValue());
                } catch (Throwable unused) {
                }
                map2.put(strReplace, Double.valueOf(d));
            }
        }
        this.f17643e = map2;
        this.f = map;
    }
}
