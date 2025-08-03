package com.mob.pushsdk.plugins.huawei;

import android.content.Intent;
import android.os.Bundle;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.mob.pushsdk.base.PLog;
import com.mob.tools.FakeActivity;

/* loaded from: classes2.dex */
public class a extends FakeActivity {
    private int a;

    @Override // com.mob.tools.FakeActivity
    public void onCreate() {
        Bundle extras;
        try {
            Intent intent = this.activity.getIntent();
            if (intent == null || (extras = intent.getExtras()) == null) {
                return;
            }
            for (String str : extras.keySet()) {
                if (str.equals("errorCode")) {
                    HuaweiApiAvailability.getInstance().resolveError(this.activity, extras.getInt(str), 1000);
                }
            }
        } catch (Throwable th) {
            PLog.getInstance().d(th);
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onResume() {
        this.a++;
        PLog.getInstance().d("onResume:" + this.a, new Object[0]);
        if (this.a == 2) {
            finish();
        }
    }
}
