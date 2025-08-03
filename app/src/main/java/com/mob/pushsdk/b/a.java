package com.mob.pushsdk.b;

import android.app.ActivityManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.ActivityChooserModel;
import com.mob.MobSDK;
import com.mob.pushsdk.base.PLog;
import com.mob.tools.utils.ReflectHelper;
import java.util.List;

/* loaded from: classes2.dex */
public class a {
    public static boolean a(Context context) {
        boolean z;
        try {
            z = false;
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : (List) ReflectHelper.invokeInstanceMethod((ActivityManager) context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY), "getRunningAppProcesses", new Object[0])) {
                try {
                    if (runningAppProcessInfo.importance == 100) {
                        for (String str : runningAppProcessInfo.pkgList) {
                            if (str.equals(context.getPackageName())) {
                                z = true;
                            }
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    PLog.getInstance().e(th.toString(), new Object[0]);
                    return z;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            z = false;
        }
        return z;
    }

    public static Intent b() {
        Context context = MobSDK.getContext();
        String packageName = context.getPackageName();
        Intent intent = new Intent(packageName + ".default.MAIN");
        if (!a(context, packageName, intent).booleanValue()) {
            intent = null;
        }
        if (intent == null) {
            intent = context.getPackageManager().getLaunchIntentForPackage(packageName);
        }
        if (intent != null) {
            intent.addFlags(335544320);
        }
        return intent;
    }

    public static boolean c() {
        return h.a().d();
    }

    public static Boolean a(Context context, String str, Intent intent) {
        try {
            List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
            if (listQueryIntentActivities != null && listQueryIntentActivities.size() > 0) {
                int size = listQueryIntentActivities.size();
                for (int i = 0; i < size; i++) {
                    if (listQueryIntentActivities.get(i).activityInfo != null && str.equals(listQueryIntentActivities.get(i).activityInfo.applicationInfo.packageName)) {
                        return Boolean.TRUE;
                    }
                }
            }
        } catch (Exception e2) {
            PLog.getInstance().d("MobPush findActivityByIntent " + e2.toString(), new Object[0]);
        }
        return Boolean.FALSE;
    }

    public static void a(Intent intent) throws PendingIntent.CanceledException {
        try {
            PLog.getInstance().d("MobPush start specific Activity intent uri: " + intent.toUri(1), new Object[0]);
            g.c(MobSDK.getContext(), i.a().b(), intent, 134217728).send();
        } catch (PendingIntent.CanceledException e2) {
            PLog.getInstance().d("MobPush start specific Activity error: " + e2, new Object[0]);
        }
    }

    public static String a() {
        Context context = MobSDK.getContext();
        ComponentName component = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName()).getComponent();
        return component != null ? component.getClassName() : "";
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(com.mob.pushsdk.MobPushNotifyMessage r6) {
        /*
            java.lang.String r0 = "mobpush_link_v"
            java.lang.String r1 = "mobpush_link_k"
            r2 = 0
            if (r6 == 0) goto L55
            java.util.HashMap r3 = r6.getExtrasMap()     // Catch: java.lang.Throwable -> Lb3
            if (r3 == 0) goto L55
            java.util.HashMap r3 = r6.getExtrasMap()     // Catch: java.lang.Throwable -> Lb3
            boolean r3 = r3.containsKey(r1)     // Catch: java.lang.Throwable -> Lb3
            if (r3 == 0) goto L55
            java.util.HashMap r3 = r6.getExtrasMap()     // Catch: java.lang.Throwable -> Lb3
            java.lang.String r4 = "mobpush_link_pkg"
            java.lang.Object r4 = r3.get(r4)     // Catch: java.lang.Throwable -> Lb3
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Throwable -> Lb3
            java.lang.Object r1 = r3.get(r1)     // Catch: java.lang.Throwable -> Lb3
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> Lb3
            boolean r5 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> Lb3
            if (r5 != 0) goto L56
            android.content.Intent r2 = new android.content.Intent     // Catch: java.lang.Throwable -> Lb3
            r2.<init>()     // Catch: java.lang.Throwable -> Lb3
            android.net.Uri r1 = android.net.Uri.parse(r1)     // Catch: java.lang.Throwable -> Lb3
            r2.setData(r1)     // Catch: java.lang.Throwable -> Lb3
            boolean r1 = r3.containsKey(r0)     // Catch: java.lang.Throwable -> Lb3
            if (r1 == 0) goto L56
            java.lang.Object r0 = r3.get(r0)     // Catch: java.lang.Throwable -> Lb3
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> Lb3
            android.os.Bundle r1 = new android.os.Bundle     // Catch: java.lang.Throwable -> Lb3
            r1.<init>()     // Catch: java.lang.Throwable -> Lb3
            java.lang.String r3 = "data"
            r1.putString(r3, r0)     // Catch: java.lang.Throwable -> Lb3
            r2.putExtras(r1)     // Catch: java.lang.Throwable -> Lb3
            goto L56
        L55:
            r4 = r2
        L56:
            boolean r0 = com.mob.pushsdk.biz.d.m()     // Catch: java.lang.Throwable -> Lb3
            if (r0 != 0) goto L6f
            if (r2 != 0) goto L6f
            android.content.Intent r2 = b()     // Catch: java.lang.Throwable -> Lb3
            android.os.Bundle r0 = new android.os.Bundle     // Catch: java.lang.Throwable -> Lb3
            r0.<init>()     // Catch: java.lang.Throwable -> Lb3
            java.lang.String r1 = "msg"
            r0.putSerializable(r1, r6)     // Catch: java.lang.Throwable -> Lb3
            r2.putExtras(r0)     // Catch: java.lang.Throwable -> Lb3
        L6f:
            if (r2 == 0) goto Lcf
            r6 = 268435456(0x10000000, float:2.524355E-29)
            r2.addFlags(r6)     // Catch: java.lang.Throwable -> Lb3
            if (r4 == 0) goto La4
            java.lang.String r6 = r4.trim()     // Catch: java.lang.Throwable -> Lb3
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch: java.lang.Throwable -> Lb3
            if (r6 == 0) goto L83
            goto La4
        L83:
            java.lang.String r6 = r4.trim()     // Catch: java.lang.Throwable -> Lb3
            java.lang.String r0 = "2"
            boolean r6 = r6.equals(r0)     // Catch: java.lang.Throwable -> Lb3
            if (r6 == 0) goto L90
            return
        L90:
            java.lang.String r6 = r4.trim()     // Catch: java.lang.Throwable -> Lb3
            java.lang.String r0 = "1"
            boolean r6 = r6.equals(r0)     // Catch: java.lang.Throwable -> Lb3
            if (r6 != 0) goto Laf
            java.lang.String r6 = r4.trim()     // Catch: java.lang.Throwable -> Lb3
            r2.setPackage(r6)     // Catch: java.lang.Throwable -> Lb3
            goto Laf
        La4:
            android.content.Context r6 = com.mob.MobSDK.getContext()     // Catch: java.lang.Throwable -> Lb3
            java.lang.String r6 = r6.getPackageName()     // Catch: java.lang.Throwable -> Lb3
            r2.setPackage(r6)     // Catch: java.lang.Throwable -> Lb3
        Laf:
            a(r2)     // Catch: java.lang.Throwable -> Lb3
            goto Lcf
        Lb3:
            r6 = move-exception
            com.mob.tools.log.NLog r0 = com.mob.pushsdk.base.PLog.getInstance()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "MobPush launchActivity error: "
            r1.append(r2)
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r0.e(r6, r1)
        Lcf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.pushsdk.b.a.a(com.mob.pushsdk.MobPushNotifyMessage):void");
    }

    public static Bitmap a(Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        drawable.draw(new Canvas(bitmapCreateBitmap));
        return bitmapCreateBitmap;
    }
}
