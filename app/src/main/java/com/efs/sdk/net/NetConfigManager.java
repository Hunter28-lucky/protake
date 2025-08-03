package com.efs.sdk.net;

import android.content.Context;
import android.content.SharedPreferences;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.observer.IConfigCallback;
import com.efs.sdk.pa.config.ConfigManager;
import java.util.Map;
import java.util.Random;

/* loaded from: classes.dex */
public class NetConfigManager {
    private final String a = "NetConfigManager";
    private final int b = 0;
    private EfsReporter c;
    private int d;

    /* renamed from: e, reason: collision with root package name */
    private int f17655e;
    private boolean f;
    private Context g;

    public NetConfigManager(Context context, EfsReporter efsReporter) {
        SharedPreferences.Editor editorEdit;
        SharedPreferences.Editor editorEdit2;
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor editorEdit3;
        SharedPreferences.Editor editorEdit4;
        SharedPreferences.Editor editorEdit5;
        this.d = 0;
        this.f = false;
        Context applicationContext = context.getApplicationContext();
        this.g = applicationContext;
        this.c = efsReporter;
        SharedPreferences sharedPreferences2 = applicationContext.getSharedPreferences("net_launch", 0);
        if (sharedPreferences2 != null) {
            this.f17655e = sharedPreferences2.getInt("apm_netperf_sampling_rate_last", 0);
        }
        SharedPreferences sharedPreferences3 = this.g.getSharedPreferences("net_launch", 0);
        int i = sharedPreferences3 != null ? sharedPreferences3.getInt("apm_netperf_sampling_rate", -1) : -1;
        this.c.getAllSdkConfig(new String[]{"apm_netperf_sampling_rate"}, new IConfigCallback() { // from class: com.efs.sdk.net.NetConfigManager.1
            @Override // com.efs.sdk.base.observer.IConfigCallback
            public final void onChange(Map<String, Object> map) {
                SharedPreferences sharedPreferences4;
                final SharedPreferences.Editor editorEdit6;
                try {
                    final Object obj = map.get("apm_netperf_sampling_rate");
                    if (obj == null || (sharedPreferences4 = NetConfigManager.this.g.getSharedPreferences("net_launch", 0)) == null || (editorEdit6 = sharedPreferences4.edit()) == null) {
                        return;
                    }
                    new Thread(new Runnable() { // from class: com.efs.sdk.net.NetConfigManager.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            editorEdit6.putInt("apm_netperf_sampling_rate", Integer.parseInt(obj.toString()));
                            editorEdit6.commit();
                        }
                    }).start();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
        if (i != -1) {
            this.d = i;
        }
        SharedPreferences sharedPreferences4 = this.g.getSharedPreferences("net_launch", 0);
        long j = sharedPreferences4 != null ? sharedPreferences4.getLong(ConfigManager.FLAG_PA_FORE_CHECK_TIME, 0L) : 0L;
        boolean z = sharedPreferences4 != null ? sharedPreferences4.getBoolean(ConfigManager.FLAG_PA_CHECK_IN_STATE, false) : false;
        int i2 = this.d;
        boolean z2 = true;
        if (i2 != 0) {
            boolean z3 = i2 != this.f17655e;
            Long lValueOf = Long.valueOf(j);
            int i3 = this.d;
            Long lValueOf2 = Long.valueOf(System.currentTimeMillis());
            Long lValueOf3 = Long.valueOf(lValueOf2.longValue() - lValueOf.longValue());
            if (z && lValueOf3.longValue() < 86400000 && !z3) {
                Log.d("NetConfigManager", " check in allready");
            } else if (lValueOf3.longValue() >= 86400000 || z3) {
                if (i3 != 0 && (i3 == 100 || new Random().nextInt(100) <= i3)) {
                    Log.d("NetConfigManager", "random check in");
                } else {
                    Log.d("NetConfigManager", "random not check in!");
                    z2 = false;
                }
                SharedPreferences sharedPreferences5 = this.g.getSharedPreferences("net_launch", 0);
                if (sharedPreferences5 != null && (editorEdit2 = sharedPreferences5.edit()) != null) {
                    editorEdit2.putBoolean(ConfigManager.FLAG_PA_CHECK_IN_STATE, z2);
                    editorEdit2.commit();
                }
                if (sharedPreferences5 != null && (editorEdit = sharedPreferences5.edit()) != null) {
                    editorEdit.putLong(ConfigManager.FLAG_PA_FORE_CHECK_TIME, lValueOf2.longValue());
                    editorEdit.commit();
                }
            } else {
                Log.d("NetConfigManager", "un repeat check in 24 hour!");
            }
            this.f = z2;
            sharedPreferences = this.g.getSharedPreferences("net_launch", 0);
            if (sharedPreferences != null || (editorEdit3 = sharedPreferences.edit()) == null) {
            }
            editorEdit3.putInt("apm_netperf_sampling_rate_last", this.d);
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
        sharedPreferences = this.g.getSharedPreferences("net_launch", 0);
        if (sharedPreferences != null) {
        }
    }

    public boolean enableTracer() {
        return this.f;
    }
}
