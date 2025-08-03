package com.mob.pushsdk.vivo.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.mob.MobSDK;
import com.mob.pushsdk.vivo.c.a;
import com.mob.pushsdk.vivo.c.c;
import com.mob.pushsdk.vivo.c.d;
import com.mob.pushsdk.vivo.c.e;
import com.mob.tools.utils.DH;
import java.util.Map;

/* loaded from: classes2.dex */
public class ClientPushMessageReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            if (a.b(intent)) {
                d.a().a("ClientPushMessageReceiver:" + intent);
                if ("com.vivo.pushclient.action.RECEIVE".equals(intent.getAction())) {
                    final Bundle extras = intent.getExtras();
                    if (a.b(extras)) {
                        int i = extras.getInt("method");
                        if (10 == i) {
                            String string = extras.getString("client_token");
                            if (!TextUtils.isEmpty(string)) {
                                d.a().a("vivo bd tk:" + string);
                                onReceiveRegId(context, string);
                            }
                        } else if (11 == i) {
                            d.a().a("unbind");
                            String string2 = extras.getString("client_token");
                            if (!TextUtils.isEmpty(string2)) {
                                d.a().a("vivo ubd tk:" + string2);
                            }
                        } else if (5 == i) {
                            d.a().a("click");
                            e.a(new Runnable() { // from class: com.mob.pushsdk.vivo.service.ClientPushMessageReceiver.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    try {
                                        ClientPushMessageReceiver.this.a(extras);
                                    } catch (Throwable th) {
                                        d.a().a(th);
                                    }
                                }
                            });
                        } else {
                            d.a().a("method:" + i);
                        }
                    } else {
                        d.a().a("extras null");
                    }
                } else {
                    d.a().b("ClientPushMessageReceiver  receive invalid action " + intent.getAction(), new Object[0]);
                }
            } else {
                d.a().a("intent null");
            }
        } catch (Throwable th) {
            d.a().b(th);
        }
    }

    public void onReceiveRegId(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bundle bundle) {
        String string;
        com.mob.pushsdk.vivo.b.a aVarM;
        try {
            string = bundle.getString("package_name", "");
            aVarM = com.mob.pushsdk.vivo.b.a.m(bundle.getString("notification_v1", ""));
        } catch (Throwable th) {
            d.a().a(th);
        }
        if (a.a(aVarM)) {
            d.a().a("notificationItem null", new Object[0]);
            return;
        }
        if (!DH.SyncMtd.getPackageName().equals(string)) {
            d.a().a("pkg not equals localpkg:" + DH.SyncMtd.getPackageName() + ",intpkg:" + string, new Object[0]);
            return;
        }
        c.a();
        d.a().a("notification is clicked by skip type[" + aVarM.b() + "]", new Object[0]);
        int iB = aVarM.b();
        if (iB == 1) {
            Intent launchIntentForPackage = MobSDK.getContext().getPackageManager().getLaunchIntentForPackage(DH.SyncMtd.getPackageName());
            if (launchIntentForPackage == null) {
                d.a().a("LaunchIntent is null", new Object[0]);
                return;
            }
            launchIntentForPackage.setFlags(268435456);
            a(launchIntentForPackage, aVarM.c());
            MobSDK.getContext().startActivity(launchIntentForPackage);
            return;
        }
        if (iB == 2) {
            String strA = aVarM.a();
            if (!strA.startsWith("http://") && !strA.startsWith("https://")) {
                d.a().a("url not legal", new Object[0]);
                return;
            }
            Uri uri = Uri.parse(strA);
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            intent.setFlags(268435456);
            a(intent, aVarM.c());
            try {
                MobSDK.getContext().startActivity(intent);
                return;
            } catch (Throwable unused) {
                d.a().a("startActivity error : ".concat(String.valueOf(uri)), new Object[0]);
                return;
            }
        }
        if (iB != 3) {
            if (iB != 4) {
                d.a().a("illegitmacy skip type error : " + aVarM.b(), new Object[0]);
                return;
            }
            String strA2 = aVarM.a();
            if (TextUtils.isEmpty(strA2)) {
                d.a().a("skipContent null", new Object[0]);
            }
            Intent uri2 = Intent.parseUri(strA2, 1);
            try {
                String str = uri2.getPackage();
                if (TextUtils.isEmpty(str) || DH.SyncMtd.getPackageName().equals(str)) {
                    String packageName = uri2.getComponent() == null ? null : uri2.getComponent().getPackageName();
                    if (!TextUtils.isEmpty(packageName) && !DH.SyncMtd.getPackageName().equals(packageName)) {
                        d.a().a("open activity component error : local pkgName is " + DH.SyncMtd.getPackageName() + "; but remote pkgName is " + uri2.getPackage(), new Object[0]);
                        return;
                    }
                    uri2.setSelector(null);
                    uri2.setPackage(DH.SyncMtd.getPackageName());
                    uri2.addFlags(335544320);
                    a(uri2, aVarM.c());
                    ActivityInfo activityInfoResolveActivityInfo = uri2.resolveActivityInfo(MobSDK.getContext().getPackageManager(), 65536);
                    if (activityInfoResolveActivityInfo != null && !activityInfoResolveActivityInfo.exported) {
                        d.a().a("activity is not exported : " + activityInfoResolveActivityInfo.toString(), new Object[0]);
                        return;
                    }
                    MobSDK.getContext().startActivity(uri2);
                    return;
                }
            } catch (Throwable th2) {
                d.a().b("open activity error : ".concat(String.valueOf(strA2)), th2);
            }
            d.a().a("open activity error : local pkgName is " + DH.SyncMtd.getPackageName() + "; but remote pkgName is " + uri2.getPackage(), new Object[0]);
            return;
        }
        return;
        d.a().a(th);
    }

    public static Intent a(Intent intent, Map<String, String> map) {
        if (map != null && map.entrySet() != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry != null && entry.getKey() != null) {
                    intent.putExtra(entry.getKey(), entry.getValue());
                }
            }
        }
        return intent;
    }
}
