package com.efs.sdk.base.core.config.a;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import com.efs.sdk.base.core.c.f;
import com.efs.sdk.base.core.config.GlobalEnvStruct;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.newsharedpreferences.SharedPreferencesUtils;
import java.io.File;
import java.util.Map;

/* loaded from: classes.dex */
public final class e implements SharedPreferences.OnSharedPreferenceChangeListener {
    public volatile SharedPreferences a;

    public static void b() {
        File fileA = com.efs.sdk.base.core.util.a.a(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid());
        if (fileA.exists()) {
            fileA.delete();
        }
    }

    private void d() {
        if (this.a == null) {
            synchronized (com.efs.sdk.base.core.c.b.class) {
                if (this.a == null) {
                    this.a = SharedPreferencesUtils.getSharedPreferences(ControllerCenter.getGlobalEnvStruct().mAppContext, com.efs.sdk.base.core.util.b.b.a(("config_" + ControllerCenter.getGlobalEnvStruct().getAppid().toLowerCase()).getBytes()));
                    this.a.registerOnSharedPreferenceChangeListener(this);
                }
            }
        }
    }

    public final boolean a(@NonNull b bVar) {
        c();
        if (this.a == null) {
            return false;
        }
        SharedPreferences.Editor editorEdit = this.a.edit();
        editorEdit.clear();
        editorEdit.putInt("cver", bVar.a);
        editorEdit.putLong("last_refresh_time", System.currentTimeMillis());
        for (Map.Entry<String, String> entry : bVar.f.entrySet()) {
            editorEdit.putString(entry.getKey(), entry.getValue());
        }
        editorEdit.apply();
        return true;
    }

    public final void c() {
        try {
            d();
        } catch (Throwable th) {
            Log.e("efs.config", "init sharedpreferences error", th);
        }
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (f.a.a.a()) {
            return;
        }
        c.a().b();
    }

    public static boolean a() {
        GlobalEnvStruct globalEnvStruct = ControllerCenter.getGlobalEnvStruct();
        File fileB = com.efs.sdk.base.core.util.a.b(globalEnvStruct.mAppContext, globalEnvStruct.getAppid());
        if (!fileB.exists()) {
            return false;
        }
        com.efs.sdk.base.core.util.b.b(fileB);
        return true;
    }
}
