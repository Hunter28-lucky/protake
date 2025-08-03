package com.xiaomi.mipush.sdk;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.push.dt;
import com.xiaomi.push.du;
import com.xiaomi.push.gg;
import com.xiaomi.push.gq;
import com.xiaomi.push.hf;
import com.xiaomi.push.service.an;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@TargetApi(14)
/* loaded from: classes2.dex */
public class a implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a, reason: collision with other field name */
    private final ConcurrentHashMap<String, ConcurrentHashMap<String, String>> f5506a = new ConcurrentHashMap<>();
    private final Set<String> a = new HashSet();

    /* renamed from: a, reason: collision with other field name */
    private final ScheduledExecutorService f5507a = Executors.newScheduledThreadPool(0);

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostResumed(Activity activity) {
        a(activity, "32");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreCreated(Activity activity, Bundle bundle) {
        a(activity, "10");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        try {
            Intent intent = activity.getIntent();
            if (intent == null) {
                return;
            }
            String stringExtra = intent.getStringExtra("messageId");
            int intExtra = intent.getIntExtra("eventMessageType", -1);
            if (!TextUtils.isEmpty(stringExtra) && intExtra > 0 && !this.a.contains(stringExtra)) {
                this.a.add(stringExtra);
                if (intExtra == 3000) {
                    du.a(activity.getApplicationContext()).a(activity.getPackageName(), dt.m5422a(intExtra), stringExtra, 3008, null);
                } else if (intExtra == 1000) {
                    du.a(activity.getApplicationContext()).a(activity.getPackageName(), dt.m5422a(intExtra), stringExtra, 1008, null);
                }
            }
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.d("An error occurred in onActivityResumed method: " + th);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    public static void a(Context context) {
        a((Application) context.getApplicationContext());
    }

    private static void a(Application application) {
        application.registerActivityLifecycleCallbacks(new a());
    }

    private void a(Activity activity, final String str) {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        if (activity != null && !TextUtils.isEmpty(str)) {
            final Context applicationContext = activity.getApplicationContext();
            final Intent intent = activity.getIntent();
            final ComponentName componentName = activity.getComponentName();
            if (applicationContext != null && intent != null && componentName != null) {
                this.f5507a.submit(new Runnable() { // from class: com.xiaomi.mipush.sdk.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (a.this.m5139a(applicationContext)) {
                                final String stringExtra = intent.getStringExtra("messageId");
                                if (TextUtils.isEmpty(stringExtra)) {
                                    return;
                                }
                                if (intent.getBooleanExtra("mipush_notified", false)) {
                                    boolean booleanExtra = intent.getBooleanExtra("pushTargetComponent", false);
                                    ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) a.this.f5506a.get(stringExtra);
                                    if (concurrentHashMap == null) {
                                        concurrentHashMap = new ConcurrentHashMap();
                                        a.this.f5506a.put(stringExtra, concurrentHashMap);
                                    }
                                    String strA = a.this.a(componentName, str);
                                    if (TextUtils.isEmpty(strA)) {
                                        com.xiaomi.channel.commonutils.logger.b.m5113a("component Key is null when record lifecycle");
                                        return;
                                    }
                                    concurrentHashMap.put(strA, String.valueOf(jCurrentTimeMillis));
                                    boolean zEquals = TextUtils.equals("10", str);
                                    int i = 5;
                                    if (booleanExtra) {
                                        i = zEquals ? 3 : 0;
                                    }
                                    a.this.f5507a.schedule(new Runnable() { // from class: com.xiaomi.mipush.sdk.a.1.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                            a.this.a(applicationContext, stringExtra);
                                        }
                                    }, i, TimeUnit.SECONDS);
                                }
                            }
                        } catch (Throwable th) {
                            com.xiaomi.channel.commonutils.logger.b.d("an error occurred in lifecycle event: " + th);
                        }
                    }
                });
                return;
            } else {
                com.xiaomi.channel.commonutils.logger.b.m5113a("ctx|intent|componentName is null when record lifecycle");
                return;
            }
        }
        com.xiaomi.channel.commonutils.logger.b.m5113a("activity|type is null when record lifecycle");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(ComponentName componentName, String str) {
        if (componentName != null && !TextUtils.isEmpty(str)) {
            return componentName.hashCode() + "|" + str;
        }
        com.xiaomi.channel.commonutils.logger.b.m5113a("component｜type is null when create component key");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str) {
        try {
            if (context == null) {
                com.xiaomi.channel.commonutils.logger.b.m5113a("ctx is null when report activity lifecycle");
                return;
            }
            if (TextUtils.isEmpty(str)) {
                com.xiaomi.channel.commonutils.logger.b.m5113a("msgId is null when report activity lifecycle");
                return;
            }
            String packageName = context.getPackageName();
            if (TextUtils.isEmpty(packageName)) {
                com.xiaomi.channel.commonutils.logger.b.m5113a("pkg is null when report activity lifecycle");
                return;
            }
            ConcurrentHashMap<String, String> concurrentHashMapRemove = this.f5506a.remove(str);
            if (concurrentHashMapRemove != null && !concurrentHashMapRemove.isEmpty()) {
                String strM5141a = b.m5140a(context).m5141a();
                hf hfVar = new hf(str, false);
                hfVar.c(gq.SDK_START_ACTIVITY_LIFECYCLE.f6003a);
                hfVar.b(strM5141a);
                hfVar.d(packageName);
                HashMap map = new HashMap();
                hfVar.f6142a = map;
                map.putAll(concurrentHashMapRemove);
                u.a(context).a(hfVar, gg.Notification, false, false, null, true, packageName, strM5141a, true, false, an.p);
            }
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.d("an error occurred in send lifecycle event : " + th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a, reason: collision with other method in class */
    public boolean m5139a(Context context) {
        return !com.xiaomi.push.j.m5690a(context) && com.xiaomi.push.j.m5689a();
    }
}
