package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import com.blink.academy.film.stream.NetInfoBean;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;

/* compiled from: SessionIdGenerateServiceImpl.java */
/* loaded from: classes2.dex */
class x implements w {
    private long a = AnalyticsConfig.kContinueSessionMillis;

    @Override // com.umeng.analytics.pro.w
    public void a(long j) {
        this.a = j;
    }

    @Override // com.umeng.analytics.pro.w
    public long a() {
        return this.a;
    }

    @Override // com.umeng.analytics.pro.w
    public String a(Context context) {
        String appkey = UMUtils.getAppkey(context);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (appkey != null) {
            return UMUtils.MD5(jCurrentTimeMillis + appkey + NetInfoBean.DEFAULT_MAC_ADDRESS);
        }
        throw new RuntimeException("Appkey is null or empty, Please check!");
    }

    @Override // com.umeng.analytics.pro.w
    public boolean a(long j, long j2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        return (j == 0 || jCurrentTimeMillis - j >= this.a) && j2 > 0 && jCurrentTimeMillis - j2 > this.a;
    }

    @Override // com.umeng.analytics.pro.w
    public void a(Context context, String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            SharedPreferences.Editor editorEdit = PreferenceWrapper.getDefault(context).edit();
            editorEdit.putString("session_id", str);
            editorEdit.putLong(u.b, 0L);
            editorEdit.putLong(u.f17786e, jCurrentTimeMillis);
            editorEdit.putLong(u.f, 0L);
            editorEdit.commit();
        } catch (Exception unused) {
        }
    }
}
