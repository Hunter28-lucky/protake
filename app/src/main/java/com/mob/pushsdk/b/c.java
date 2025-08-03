package com.mob.pushsdk.b;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import com.mob.MobSDK;
import com.mob.pushsdk.impl.m;
import com.mob.tools.utils.ActivityTracker;

/* loaded from: classes2.dex */
public class c {
    private static c a;
    private String b = null;
    private long c = 0;

    public void b() {
        ActivityTracker.getInstance(MobSDK.getContext()).addTracker(new ActivityTracker.Tracker() { // from class: com.mob.pushsdk.b.c.1
            @Override // com.mob.tools.utils.ActivityTracker.Tracker
            public void onCreated(Activity activity, Bundle bundle) {
            }

            @Override // com.mob.tools.utils.ActivityTracker.Tracker
            public void onDestroyed(Activity activity) {
                if (c.this.c > 0) {
                    onStopped(activity);
                }
            }

            @Override // com.mob.tools.utils.ActivityTracker.Tracker
            public void onPaused(Activity activity) {
            }

            @Override // com.mob.tools.utils.ActivityTracker.Tracker
            public void onResumed(Activity activity) {
                if (c.this.c == 0) {
                    c.this.c = SystemClock.elapsedRealtime();
                    m.a().b();
                }
                c.this.b = activity.toString();
            }

            @Override // com.mob.tools.utils.ActivityTracker.Tracker
            public void onSaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // com.mob.tools.utils.ActivityTracker.Tracker
            public void onStarted(Activity activity) {
            }

            @Override // com.mob.tools.utils.ActivityTracker.Tracker
            public void onStopped(Activity activity) {
                if (c.this.b == null || activity.toString().equals(c.this.b.toString())) {
                    c.this.c = 0L;
                    c.this.b = null;
                }
            }
        });
    }

    public static synchronized c a() {
        if (a == null) {
            a = new c();
        }
        return a;
    }
}
