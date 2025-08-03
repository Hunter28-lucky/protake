package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class ge {
    private static volatile ge a;

    /* renamed from: a, reason: collision with other field name */
    private final Context f5963a;

    /* renamed from: a, reason: collision with other field name */
    private Map<String, gf> f5964a = new HashMap();

    private ge(Context context) {
        this.f5963a = context;
    }

    public static ge a(Context context) {
        if (context == null) {
            com.xiaomi.channel.commonutils.logger.b.d("[TinyDataManager]:mContext is null, TinyDataManager.getInstance(Context) failed.");
            return null;
        }
        if (a == null) {
            synchronized (ge.class) {
                if (a == null) {
                    a = new ge(context);
                }
            }
        }
        return a;
    }

    public void a(gf gfVar, String str) {
        if (gfVar == null) {
            com.xiaomi.channel.commonutils.logger.b.d("[TinyDataManager]: please do not add null mUploader to TinyDataManager.");
        } else if (TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.d("[TinyDataManager]: can not add a provider from unkown resource.");
        } else {
            m5523a().put(str, gfVar);
        }
    }

    public gf a() {
        gf gfVar = this.f5964a.get("UPLOADER_PUSH_CHANNEL");
        if (gfVar != null) {
            return gfVar;
        }
        gf gfVar2 = this.f5964a.get("UPLOADER_HTTP");
        if (gfVar2 != null) {
            return gfVar2;
        }
        return null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public Map<String, gf> m5523a() {
        return this.f5964a;
    }

    public boolean a(gk gkVar, String str) {
        if (TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.m5113a("pkgName is null or empty, upload ClientUploadDataItem failed.");
            return false;
        }
        if (com.xiaomi.push.service.az.a(gkVar, false)) {
            return false;
        }
        if (TextUtils.isEmpty(gkVar.d())) {
            gkVar.f(com.xiaomi.push.service.az.a());
        }
        gkVar.g(str);
        com.xiaomi.push.service.ba.a(this.f5963a, gkVar);
        return true;
    }
}
