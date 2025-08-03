package com.mob.pushsdk.impl;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.mob.MobSDK;
import com.mob.pushsdk.base.PLog;
import com.mob.pushsdk.plugins.huawei.compat.PushHuaWeiCompat;
import com.mob.pushsdk.plugins.oppo.PushOppo;
import com.mob.tools.utils.ReflectHelper;
import com.umeng.analytics.pro.aq;
import java.util.List;

/* loaded from: classes2.dex */
public class b {
    private static volatile b a;
    private boolean b = true;

    private b() {
    }

    public static b a() {
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    a = new b();
                }
            }
        }
        return a;
    }

    private void b(int i) {
        try {
            Context context = MobSDK.getContext();
            Bundle bundle = new Bundle();
            bundle.putString("package", context.getPackageName());
            bundle.putString("class", com.mob.pushsdk.b.a.a());
            bundle.putInt("badgenumber", i);
            context.getContentResolver().call(Uri.parse("content://com.huawei.android.launcher.settings/badge/"), "change_badge", (String) null, bundle);
        } catch (Throwable th) {
            this.b = false;
            PLog.getInstance().d("MobPush huawei phone set badge error:" + th.getMessage(), new Object[0]);
        }
    }

    private void c(int i) {
        try {
            Context context = MobSDK.getContext();
            Intent intent = new Intent("launcher.action.CHANGE_APPLICATION_NOTIFICATION_NUM");
            intent.putExtra("packageName", context.getPackageName());
            intent.putExtra("className", com.mob.pushsdk.b.a.a());
            intent.putExtra("notificationNum", i);
            ReflectHelper.invokeInstanceMethod(context, "sendBroadcast", intent);
        } catch (Throwable th) {
            PLog.getInstance().d("set vivo badge error:" + th.getMessage(), new Object[0]);
            this.b = false;
        }
    }

    private void d(int i) {
        try {
            Context context = MobSDK.getContext();
            Intent intent = new Intent("com.oppo.unsettledevent");
            intent.putExtra("packageName", context.getPackageName());
            intent.putExtra("number", i);
            intent.putExtra("upgradeNumber", i);
            List<ResolveInfo> listQueryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 0);
            if (listQueryBroadcastReceivers == null || listQueryBroadcastReceivers.size() <= 0) {
                Bundle bundle = new Bundle();
                bundle.putInt("app_badge_count", i);
                context.getContentResolver().call(Uri.parse("content://com.android.badge/badge"), "setAppBadgeCount", (String) null, bundle);
            } else {
                context.sendBroadcast(intent);
            }
        } catch (Throwable th) {
            PLog.getInstance().d("set oppo badge error:" + th.getMessage(), new Object[0]);
            this.b = false;
        }
    }

    private void e(int i) {
        Context context = MobSDK.getContext();
        Uri uri = Uri.parse("content://com.sec.badge/apps");
        Cursor cursorQuery = null;
        try {
            ContentResolver contentResolver = context.getContentResolver();
            cursorQuery = contentResolver.query(uri, new String[]{aq.d}, "package=?", new String[]{context.getPackageName()}, null);
            if (cursorQuery == null || !cursorQuery.moveToFirst()) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("package", context.getPackageName());
                contentValues.put("class", com.mob.pushsdk.b.a.a());
                contentValues.put("badgeCount", Integer.valueOf(i));
                contentResolver.insert(uri, contentValues);
            } else {
                int columnIndex = cursorQuery.getColumnIndex(aq.d);
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("badgeCount", Integer.valueOf(i));
                contentResolver.update(uri, contentValues2, aq.d + "=?", new String[]{String.valueOf(cursorQuery.getInt(columnIndex))});
            }
            if (cursorQuery == null) {
                return;
            }
        } catch (Throwable unused) {
            if (0 == 0) {
                return;
            }
        }
        cursorQuery.close();
    }

    private void f(int i) {
        try {
            Context context = MobSDK.getContext();
            Intent intent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
            intent.putExtra("badge_count", i);
            intent.putExtra("badge_count_package_name", context.getPackageName());
            intent.putExtra("badge_count_class_name", com.mob.pushsdk.b.a.a());
            ReflectHelper.invokeInstanceMethod(context, "sendBroadcast", intent);
        } catch (Throwable th) {
            PLog.getInstance().d("set htc badge error:" + th.getMessage(), new Object[0]);
            this.b = false;
        }
    }

    public void a(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.b) {
            String strC = com.mob.pushsdk.b.h.a().c();
            if (strC.equalsIgnoreCase(PushHuaWeiCompat.NAME)) {
                b(i);
                return;
            }
            if (strC.equalsIgnoreCase("VIVO")) {
                c(i);
                return;
            }
            if (!strC.equalsIgnoreCase(PushOppo.NAME) && !strC.equalsIgnoreCase("OnePlus")) {
                String str = Build.MANUFACTURER;
                if (!str.equalsIgnoreCase("SAMSUNG") && !str.equalsIgnoreCase("LG")) {
                    if (str.equalsIgnoreCase("HTC")) {
                        f(i);
                        return;
                    }
                    return;
                }
                e(i);
                return;
            }
            d(i);
        }
    }
}
