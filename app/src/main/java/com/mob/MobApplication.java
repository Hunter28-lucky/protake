package com.mob;

import android.app.Application;
import com.mob.tools.proguard.ProtectedMemberKeeper;

/* loaded from: classes2.dex */
public class MobApplication extends Application implements ProtectedMemberKeeper {
    public String getAppSecret() {
        return null;
    }

    public String getAppkey() {
        return null;
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        MobSDK.init(this, getAppkey(), getAppSecret());
    }
}
