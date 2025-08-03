package com.mob.pushsdk.impl;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import com.mob.pushsdk.base.PLog;

/* loaded from: classes2.dex */
public class MobPushActivity extends Activity {
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            getWindow().addFlags(8192);
        } catch (Throwable th) {
            PLog.getInstance().d(th);
        }
        try {
            try {
                new NotifyActionReceiver().a(getApplicationContext(), getIntent());
                finish();
            } catch (Throwable th2) {
                try {
                    PLog.getInstance().w(th2);
                    finish();
                } catch (Throwable th3) {
                    try {
                        finish();
                    } catch (Throwable th4) {
                        PLog.getInstance().w(th4);
                    }
                    throw th3;
                }
            }
        } catch (Throwable th5) {
            PLog.getInstance().w(th5);
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        if (Build.VERSION.SDK_INT >= 29) {
            try {
                if (!isFinishing()) {
                    finish();
                }
            } catch (Throwable th) {
                PLog.getInstance().e(th);
            }
        }
        super.onResume();
    }
}
