package com.efs.sdk.launch;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.observer.IConfigCallback;
import com.efs.sdk.pa.config.ConfigManager;
import java.util.Map;
import java.util.Random;

/* loaded from: classes.dex */
public class LaunchConfigManager {
    private final String a = "LaunchConfigManager";
    private final int b = 0;
    private EfsReporter c;
    private int d;

    /* renamed from: e, reason: collision with root package name */
    private int f17651e;
    private boolean f;
    private Context g;

    public LaunchConfigManager(Context context, EfsReporter efsReporter) {
        SharedPreferences.Editor editorEdit;
        SharedPreferences.Editor editorEdit2;
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor editorEdit3;
        SharedPreferences.Editor editorEdit4;
        SharedPreferences.Editor editorEdit5;
        this.d = 100;
        this.f = false;
        Context applicationContext = context.getApplicationContext();
        this.g = applicationContext;
        this.c = efsReporter;
        SharedPreferences sharedPreferences2 = applicationContext.getSharedPreferences("efs_launch", 0);
        if (sharedPreferences2 != null) {
            this.f17651e = sharedPreferences2.getInt("apm_startperf_sampling_rate_last", 0);
        }
        SharedPreferences sharedPreferences3 = this.g.getSharedPreferences("efs_launch", 0);
        int i = sharedPreferences3 != null ? sharedPreferences3.getInt("apm_startperf_sampling_rate", -1) : -1;
        this.c.getAllSdkConfig(new String[]{"apm_startperf_sampling_rate"}, new IConfigCallback() { // from class: com.efs.sdk.launch.LaunchConfigManager.1
            @Override // com.efs.sdk.base.observer.IConfigCallback
            public final void onChange(Map<String, Object> map) {
                SharedPreferences sharedPreferences4;
                SharedPreferences.Editor editorEdit6;
                try {
                    Object obj = map.get("apm_startperf_sampling_rate");
                    if (obj == null || (sharedPreferences4 = LaunchConfigManager.this.g.getSharedPreferences("efs_launch", 0)) == null || (editorEdit6 = sharedPreferences4.edit()) == null) {
                        return;
                    }
                    editorEdit6.putInt("apm_startperf_sampling_rate", Integer.parseInt(obj.toString()));
                    editorEdit6.commit();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
        if (i != -1) {
            this.d = i;
        }
        SharedPreferences sharedPreferences4 = this.g.getSharedPreferences("efs_launch", 0);
        long j = sharedPreferences4 != null ? sharedPreferences4.getLong(ConfigManager.FLAG_PA_FORE_CHECK_TIME, 0L) : 0L;
        boolean z = sharedPreferences4 != null ? sharedPreferences4.getBoolean(ConfigManager.FLAG_PA_CHECK_IN_STATE, false) : false;
        int i2 = this.d;
        boolean z2 = true;
        if (i2 != 0) {
            boolean z3 = i2 != this.f17651e;
            Long lValueOf = Long.valueOf(j);
            int i3 = this.d;
            Long lValueOf2 = Long.valueOf(System.currentTimeMillis());
            Long lValueOf3 = Long.valueOf(lValueOf2.longValue() - lValueOf.longValue());
            if (!z || lValueOf3.longValue() >= 86400000 || z3) {
                if (lValueOf3.longValue() >= 86400000 || z3) {
                    if (!(i3 != 0 && (i3 == 100 || new Random().nextInt(100) <= i3))) {
                        if (LaunchManager.isDebug) {
                            Log.d("LaunchConfigManager", "random not check in!");
                        }
                        z2 = false;
                    } else if (LaunchManager.isDebug) {
                        Log.d("LaunchConfigManager", "random check in");
                    }
                    SharedPreferences sharedPreferences5 = this.g.getSharedPreferences("efs_launch", 0);
                    if (sharedPreferences5 != null && (editorEdit2 = sharedPreferences5.edit()) != null) {
                        editorEdit2.putBoolean(ConfigManager.FLAG_PA_CHECK_IN_STATE, z2);
                        editorEdit2.commit();
                    }
                    if (sharedPreferences5 != null && (editorEdit = sharedPreferences5.edit()) != null) {
                        editorEdit.putLong(ConfigManager.FLAG_PA_FORE_CHECK_TIME, lValueOf2.longValue());
                        editorEdit.commit();
                    }
                } else if (LaunchManager.isDebug) {
                    Log.d("LaunchConfigManager", "un repeat check in 24 hour!");
                }
            } else if (LaunchManager.isDebug) {
                Log.d("LaunchConfigManager", " check in allready");
            }
            this.f = z2;
            sharedPreferences = this.g.getSharedPreferences("efs_launch", 0);
            if (sharedPreferences != null || (editorEdit3 = sharedPreferences.edit()) == null) {
            }
            editorEdit3.putInt("apm_startperf_sampling_rate_last", this.d);
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
        this.f = z2;
        sharedPreferences = this.g.getSharedPreferences("efs_launch", 0);
        if (sharedPreferences != null) {
        }
    }

    public boolean enableTracer() {
        return this.f;
    }
}
