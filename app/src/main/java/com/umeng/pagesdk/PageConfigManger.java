package com.umeng.pagesdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.observer.IConfigCallback;
import com.efs.sdk.pa.config.ConfigManager;
import java.util.Map;
import java.util.Random;

/* loaded from: classes2.dex */
public class PageConfigManger {
    public static final String APM_FPSPERF_COLLECT_INTERVAL = "apm_pageperf_collect_interval";
    public static final String APM_FPSPERF_COLLECT_INTERVAL_TOGETHER = "apm_pageperf_collect_interval_together";
    public static final String APM_FPSPERF_COLLECT_MAX_PERIOD_SEC = "apm_pageperf_collect_max_period_sec";
    private Context b;
    private EfsReporter c;
    private int d;
    private int f;
    private boolean g;
    private final String a = "PageConfigManager";

    /* renamed from: e, reason: collision with root package name */
    private final int f17831e = 0;

    public PageConfigManger(Context context, EfsReporter efsReporter) {
        SharedPreferences.Editor editorEdit;
        SharedPreferences.Editor editorEdit2;
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor editorEdit3;
        SharedPreferences.Editor editorEdit4;
        SharedPreferences.Editor editorEdit5;
        this.d = 100;
        this.g = false;
        Context applicationContext = context.getApplicationContext();
        this.b = applicationContext;
        this.c = efsReporter;
        SharedPreferences sharedPreferences2 = applicationContext.getSharedPreferences("efs_page", 0);
        if (sharedPreferences2 != null) {
            this.f = sharedPreferences2.getInt("apm_pageperf_sampling_rate_last", 0);
        }
        SharedPreferences sharedPreferences3 = this.b.getSharedPreferences("efs_page", 0);
        int i = sharedPreferences3 != null ? sharedPreferences3.getInt("apm_pageperf_sampling_rate", -1) : -1;
        this.c.getAllSdkConfig(new String[]{"apm_pageperf_sampling_rate", APM_FPSPERF_COLLECT_INTERVAL, APM_FPSPERF_COLLECT_INTERVAL_TOGETHER, APM_FPSPERF_COLLECT_MAX_PERIOD_SEC}, new IConfigCallback() { // from class: com.umeng.pagesdk.PageConfigManger.1
            @Override // com.efs.sdk.base.observer.IConfigCallback
            public final void onChange(Map<String, Object> map) {
                SharedPreferences.Editor editorEdit6;
                try {
                    SharedPreferences sharedPreferences4 = PageConfigManger.this.b.getSharedPreferences("efs_page", 0);
                    if (sharedPreferences4 == null || (editorEdit6 = sharedPreferences4.edit()) == null || map == null) {
                        return;
                    }
                    Object obj = map.get("apm_pageperf_sampling_rate");
                    if (obj != null) {
                        editorEdit6.putInt("apm_pageperf_sampling_rate", Integer.parseInt(obj.toString()));
                    }
                    Object obj2 = map.get(PageConfigManger.APM_FPSPERF_COLLECT_INTERVAL);
                    if (obj2 != null) {
                        editorEdit6.putFloat(PageConfigManger.APM_FPSPERF_COLLECT_INTERVAL, Float.parseFloat(obj2.toString()) * 1000.0f);
                    }
                    Object obj3 = map.get(PageConfigManger.APM_FPSPERF_COLLECT_INTERVAL_TOGETHER);
                    if (obj3 != null) {
                        editorEdit6.putInt(PageConfigManger.APM_FPSPERF_COLLECT_INTERVAL_TOGETHER, Integer.parseInt(obj3.toString()));
                    }
                    Object obj4 = map.get(PageConfigManger.APM_FPSPERF_COLLECT_MAX_PERIOD_SEC);
                    if (obj4 != null) {
                        editorEdit6.putLong(PageConfigManger.APM_FPSPERF_COLLECT_MAX_PERIOD_SEC, Long.parseLong(obj4.toString()) * 1000);
                    }
                    editorEdit6.commit();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
        if (i != -1) {
            this.d = i;
        }
        SharedPreferences sharedPreferences4 = this.b.getSharedPreferences("efs_page", 0);
        long j = sharedPreferences4 != null ? sharedPreferences4.getLong(ConfigManager.FLAG_PA_FORE_CHECK_TIME, 0L) : 0L;
        boolean z = sharedPreferences4 != null ? sharedPreferences4.getBoolean(ConfigManager.FLAG_PA_CHECK_IN_STATE, false) : false;
        int i2 = this.d;
        boolean z2 = true;
        if (i2 != 0) {
            boolean z3 = i2 != this.f;
            Long lValueOf = Long.valueOf(j);
            int i3 = this.d;
            Long lValueOf2 = Long.valueOf(System.currentTimeMillis());
            Long lValueOf3 = Long.valueOf(lValueOf2.longValue() - lValueOf.longValue());
            if (!z || lValueOf3.longValue() >= 86400000 || z3) {
                if (lValueOf3.longValue() >= 86400000 || z3) {
                    if (!(i3 != 0 && (i3 == 100 || new Random().nextInt(100) <= i3))) {
                        if (PageManger.isDebug) {
                            Log.d("PageConfigManager", "check in page rate. random not check in!");
                        }
                        z2 = false;
                    } else if (PageManger.isDebug) {
                        Log.d("PageConfigManager", "check in page rate. random check in");
                    }
                    SharedPreferences sharedPreferences5 = this.b.getSharedPreferences("efs_page", 0);
                    if (sharedPreferences5 != null && (editorEdit2 = sharedPreferences5.edit()) != null) {
                        editorEdit2.putBoolean(ConfigManager.FLAG_PA_CHECK_IN_STATE, z2);
                        editorEdit2.commit();
                    }
                    if (sharedPreferences5 != null && (editorEdit = sharedPreferences5.edit()) != null) {
                        editorEdit.putLong(ConfigManager.FLAG_PA_FORE_CHECK_TIME, lValueOf2.longValue());
                        editorEdit.commit();
                    }
                } else if (PageManger.isDebug) {
                    Log.d("PageConfigManager", "check in page rate. un repeat check in 24 hour!");
                }
            } else if (PageManger.isDebug) {
                Log.d("PageConfigManager", "check in page rate. check in allready.");
            }
            this.g = z2;
            sharedPreferences = this.b.getSharedPreferences("efs_page", 0);
            if (sharedPreferences != null || (editorEdit3 = sharedPreferences.edit()) == null) {
            }
            editorEdit3.putInt("apm_pageperf_sampling_rate_last", this.d);
            editorEdit3.commit();
            return;
        }
        if (z && sharedPreferences4 != null && (editorEdit5 = sharedPreferences4.edit()) != null) {
            editorEdit5.putBoolean(ConfigManager.FLAG_PA_CHECK_IN_STATE, false);
            editorEdit5.commit();
        }
        if (j != 0 && sharedPreferences4 != null && (editorEdit4 = sharedPreferences4.edit()) != null) {
            editorEdit4.putLong(ConfigManager.FLAG_PA_FORE_CHECK_TIME, 0L);
            editorEdit4.commit();
        }
        z2 = false;
        this.g = z2;
        sharedPreferences = this.b.getSharedPreferences("efs_page", 0);
        if (sharedPreferences != null) {
        }
    }

    public boolean enableTracer() {
        return this.g;
    }
}
