package com.xiaomi.mipush.sdk;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

/* loaded from: classes2.dex */
public final class NotificationClickedActivity extends Activity {
    private long a;

    /* renamed from: a, reason: collision with other field name */
    private BroadcastReceiver f5502a;

    /* renamed from: a, reason: collision with other field name */
    private Handler f5503a;
    private long b;

    private void a(Intent intent) {
        try {
            if (intent != null) {
                Intent intent2 = (Intent) intent.getParcelableExtra("mipush_serviceIntent");
                if (intent2 != null) {
                    intent2.setComponent(new ComponentName(getPackageName(), "com.xiaomi.mipush.sdk.PushMessageHandler"));
                    intent2.putExtra("is_clicked_activity_call", true);
                    intent2.putExtra("nca_create_time", this.a);
                    intent2.putExtra("nca_resume_time", this.b);
                    com.xiaomi.channel.commonutils.logger.b.m5114a("PushClickedActivity", "clicked activity start service.");
                    startService(intent2);
                } else {
                    com.xiaomi.channel.commonutils.logger.b.d("PushClickedActivity", "clicked activity start service, newIntent is null");
                }
            } else {
                com.xiaomi.channel.commonutils.logger.b.d("PushClickedActivity", "clicked activity start service, missing intent");
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        this.a = System.currentTimeMillis();
        super.onCreate(bundle);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.height = 1;
        attributes.width = 1;
        attributes.gravity = 8388659;
        window.setAttributes(attributes);
        Handler handler = new Handler();
        this.f5503a = handler;
        handler.postDelayed(new Runnable() { // from class: com.xiaomi.mipush.sdk.NotificationClickedActivity.1
            @Override // java.lang.Runnable
            public void run() {
                com.xiaomi.channel.commonutils.logger.b.e("clicked activity finish by timeout.");
                NotificationClickedActivity.this.finish();
            }
        }, 3000L);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action_clicked_activity_finish");
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.xiaomi.mipush.sdk.NotificationClickedActivity.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                com.xiaomi.channel.commonutils.logger.b.b("clicked activity finish by normal.");
                NotificationClickedActivity.this.finish();
            }
        };
        this.f5502a = broadcastReceiver;
        try {
            com.xiaomi.push.m.a(this, broadcastReceiver, intentFilter, c.a(this), null, 4);
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f5503a.removeCallbacksAndMessages(null);
        try {
            unregisterReceiver(this.f5502a);
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override // android.app.Activity
    public void onResume() {
        this.b = System.currentTimeMillis();
        super.onResume();
        a(getIntent());
    }
}
