package com.mob.pushsdk;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.os.Process;
import com.mob.MobSDK;
import com.mob.pushsdk.b.b;
import com.mob.pushsdk.b.f;
import com.mob.pushsdk.b.h;
import com.mob.pushsdk.base.PLog;
import com.mob.pushsdk.biz.a;
import com.mob.pushsdk.biz.d;
import com.mob.pushsdk.impl.e;
import com.mob.pushsdk.impl.k;
import com.mob.pushsdk.impl.m;
import com.mob.tools.proguard.ClassKeeper;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes2.dex */
public class MobPush implements ClassKeeper {
    public static final int DOMAIN_ABROAD = 1;
    public static final int DOMAIN_INLAND = 0;
    public static final int SDK_VERSION_CODE;
    public static final String SDK_VERSION_NAME = "3.3.9";
    private static m impl = null;
    public static boolean isForb = false;
    public static String sdkTag = "MOBPUSH";

    public static class Channels implements ClassKeeper {
        public static final String FCM = "fcm";
        public static final String HUAWEI = "huawei";
        public static final String MEIZU = "meizu";
        public static final String MOB = "mobpush";
        public static final String OPPO = "oppo";
        public static final String VIVO = "vivo";
        public static final String XIAOMI = "xiaomi";
    }

    static {
        String[] strArrSplit = "3.3.9".split("\\.");
        int length = strArrSplit.length;
        if (length > 3) {
            length = 3;
        }
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            i = (i * 100) + Integer.parseInt(strArrSplit[i2]);
        }
        SDK_VERSION_CODE = i;
        PLog.prepare();
        if (h.a().d()) {
            ensureInit();
        }
    }

    public static void addGuardMessage(String str) {
        if (d.h()) {
            PLog.getInstance().d("MobPush addGuardMessage isPushServiceStopped", new Object[0]);
            return;
        }
        PLog.getInstance().d("MobPush addGuardMessage pkg:" + MobSDK.getContext().getPackageName(), new Object[0]);
        if (str == null) {
            return;
        }
        PLog.getInstance().d("MobPush addGuardMessage content:" + str, new Object[0]);
        Message messageObtain = Message.obtain();
        Bundle bundle = new Bundle();
        bundle.putByteArray("content", str.getBytes());
        messageObtain.setData(bundle);
        k.a().a(messageObtain);
    }

    public static boolean addLocalNotification(MobPushLocalNotification mobPushLocalNotification) {
        try {
            if (isForb()) {
                return false;
            }
            com.mob.pushsdk.b.d.a().a("addLocalNotification:" + mobPushLocalNotification);
            return impl.a(mobPushLocalNotification);
        } catch (Throwable th) {
            PLog.getInstance().e(th);
            return false;
        }
    }

    public static void addPushReceiver(MobPushReceiver mobPushReceiver) {
        try {
            e.a.add(mobPushReceiver);
            if (isForb()) {
                return;
            }
            com.mob.pushsdk.b.d.a().a("addPushReceiver:" + mobPushReceiver);
            impl.a(mobPushReceiver);
        } catch (Throwable th) {
            PLog.getInstance().e(th);
        }
    }

    public static void addPushReceiverInMain(Context context, MobPushReceiver mobPushReceiver) {
        if (context == null) {
            return;
        }
        try {
            if (h.a().d()) {
                com.mob.pushsdk.b.d.a().a("addPushReceiverInMain pid:" + Process.myPid());
                e.a.add(mobPushReceiver);
                if (isForb()) {
                    return;
                }
                com.mob.pushsdk.b.d.a().a("addPushReceiver:" + mobPushReceiver);
                impl.a(mobPushReceiver);
            }
        } catch (Throwable th) {
            com.mob.pushsdk.b.d.a().d(th.toString());
        }
    }

    public static void addTags(String[] strArr) {
        try {
            if (isForb()) {
                return;
            }
            com.mob.pushsdk.b.d.a().a("addTags:" + Arrays.toString(strArr));
            impl.b(strArr);
        } catch (Throwable th) {
            PLog.getInstance().e(th);
        }
    }

    public static void bindPhoneNum(String str, MobPushCallback<Boolean> mobPushCallback) {
        try {
            if (isForb()) {
                return;
            }
            com.mob.pushsdk.b.d.a().a("bindPhoneNum");
            impl.a(str, mobPushCallback);
        } catch (Throwable th) {
            PLog.getInstance().e(th);
        }
    }

    public static void checkTcpStatus(MobPushCallback mobPushCallback) {
        try {
            if (isForb() || impl == null) {
                return;
            }
            com.mob.pushsdk.b.d.a().a("checkPushStatus:");
            impl.d(mobPushCallback);
        } catch (Throwable th) {
            PLog.getInstance().e(th);
        }
    }

    public static void cleanTags() {
        try {
            if (isForb()) {
                return;
            }
            com.mob.pushsdk.b.d.a().a("cleanTags");
            impl.j();
        } catch (Throwable th) {
            PLog.getInstance().e(th);
        }
    }

    public static void clearAllNotification() {
        try {
            if (isForb()) {
                return;
            }
            com.mob.pushsdk.b.d.a().a("clearAllNotification");
            impl.c();
        } catch (Throwable th) {
            PLog.getInstance().e(th);
        }
    }

    public static boolean clearLocalNotifications() {
        try {
            if (isForb()) {
                return false;
            }
            com.mob.pushsdk.b.d.a().a("clearLocalNotifications");
            return impl.l();
        } catch (Throwable th) {
            PLog.getInstance().e(th);
            return false;
        }
    }

    public static void deleteAlias() {
        try {
            if (isForb()) {
                return;
            }
            com.mob.pushsdk.b.d.a().a("deleteAlias");
            impl.h();
        } catch (Throwable th) {
            PLog.getInstance().e(th);
        }
    }

    public static void deleteTags(String[] strArr) {
        try {
            if (isForb()) {
                return;
            }
            com.mob.pushsdk.b.d.a().a("deleteTags:" + Arrays.toString(strArr));
            impl.c(strArr);
        } catch (Throwable th) {
            PLog.getInstance().e(th);
        }
    }

    private static synchronized void ensureInit() {
        if (impl == null) {
            impl = m.a();
        }
    }

    public static void getAlias() {
        try {
            if (isForb()) {
                return;
            }
            com.mob.pushsdk.b.d.a().a("getAlias");
            impl.g();
        } catch (Throwable th) {
            PLog.getInstance().e(th);
        }
    }

    public static void getDeviceToken(MobPushCallback<String> mobPushCallback) {
        try {
            if (isForb()) {
                return;
            }
            impl.a(mobPushCallback);
        } catch (Throwable th) {
            PLog.getInstance().e(th);
        }
    }

    public static void getPhoneNum(MobPushCallback<String> mobPushCallback) {
        try {
            if (isForb()) {
                return;
            }
            com.mob.pushsdk.b.d.a().a("getPhoneNum");
            impl.b(mobPushCallback);
        } catch (Throwable th) {
            PLog.getInstance().e(th);
        }
    }

    public static void getRegistrationId(MobPushCallback<String> mobPushCallback) {
        try {
            if (!isForb() || mobPushCallback == null) {
                com.mob.pushsdk.b.d.a().a("getRegistrationId");
                impl.c(mobPushCallback);
            } else {
                mobPushCallback.onCallback(null);
            }
        } catch (Throwable th) {
            PLog.getInstance().e(th);
        }
    }

    public static boolean getShowBadge() {
        try {
            if (isForb()) {
                return false;
            }
            com.mob.pushsdk.b.d.a().a("getShowBadge");
            return impl.m();
        } catch (Throwable th) {
            PLog.getInstance().e(th);
            return false;
        }
    }

    public static void getTags() {
        try {
            if (isForb()) {
                return;
            }
            com.mob.pushsdk.b.d.a().a("getTags");
            impl.i();
        } catch (Throwable th) {
            PLog.getInstance().e(th);
        }
    }

    public static void initMobPush() {
        isForb();
    }

    private static boolean isForb() {
        if (MobSDK.isForb()) {
            return true;
        }
        ensureInit();
        try {
            List<MobPushReceiver> list = e.a;
            if (b.a(list)) {
                return false;
            }
            for (MobPushReceiver mobPushReceiver : list) {
                if (f.b(mobPushReceiver)) {
                    impl.a(mobPushReceiver);
                }
            }
            return false;
        } catch (Throwable th) {
            PLog.getInstance().d(th);
            return false;
        }
    }

    public static boolean isPushStopped() {
        try {
            if (isForb()) {
                return true;
            }
            com.mob.pushsdk.b.d.a().a("isPushStopped");
            return impl.f();
        } catch (Throwable th) {
            PLog.getInstance().e(th);
            return true;
        }
    }

    public static void notificationClickAck(Intent intent) {
        try {
            if (isForb()) {
                return;
            }
            impl.a(intent);
        } catch (Throwable th) {
            PLog.getInstance().e(th);
        }
    }

    public static boolean removeLocalNotification(int i) {
        try {
            if (isForb()) {
                return false;
            }
            com.mob.pushsdk.b.d.a().a("removeLocalNotification:" + i);
            return impl.b(i);
        } catch (Throwable th) {
            PLog.getInstance().e(th);
            return false;
        }
    }

    public static void removePushReceiver(MobPushReceiver mobPushReceiver) {
        try {
            e.a.remove(mobPushReceiver);
            if (isForb()) {
                return;
            }
            com.mob.pushsdk.b.d.a().a("removePushReceiver:" + mobPushReceiver);
            impl.b(mobPushReceiver);
        } catch (Throwable th) {
            PLog.getInstance().e(th);
        }
    }

    @Deprecated
    public static void removeTailorNotification() {
        try {
            if (isForb()) {
                return;
            }
            com.mob.pushsdk.b.d.a().a("removeTailorNotification");
            impl.k();
        } catch (Throwable th) {
            PLog.getInstance().e(th);
        }
    }

    public static void replaceTags(String[] strArr) {
        try {
            if (isForb()) {
                return;
            }
            com.mob.pushsdk.b.d.a().a("replaceTags");
            impl.a(strArr);
        } catch (Throwable th) {
            PLog.getInstance().e(th);
        }
    }

    public static void requestTokenAsync() {
        try {
            a.f();
        } catch (Throwable th) {
            PLog.getInstance().e(th);
        }
    }

    public static HashMap<String, Object> requestTokenSync() {
        try {
            return a.g();
        } catch (Throwable th) {
            PLog.getInstance().e(th);
            return null;
        }
    }

    public static void restartPush() {
        try {
            if (isForb()) {
                return;
            }
            com.mob.pushsdk.b.d.a().a("restartPush");
            impl.e();
        } catch (Throwable th) {
            PLog.getInstance().e(th);
        }
    }

    public static void sendLocalNotification(MobPushLocalNotification mobPushLocalNotification, MobPushCallback<MobPushResult> mobPushCallback) {
        try {
            if (isForb()) {
                return;
            }
            com.mob.pushsdk.b.d.a().a("sendLocalNotification:" + mobPushLocalNotification);
            impl.a(mobPushLocalNotification, mobPushCallback);
        } catch (Throwable th) {
            PLog.getInstance().e(th);
        }
    }

    public static void setAlias(String str) {
        try {
            if (isForb()) {
                return;
            }
            com.mob.pushsdk.b.d.a().a("setAlias:" + str);
            impl.c(str);
        } catch (Throwable th) {
            PLog.getInstance().e(th);
        }
    }

    public static void setAppForegroundHiddenNotification(boolean z) {
        try {
            if (isForb()) {
                return;
            }
            com.mob.pushsdk.b.d.a().a("setAppForegroundHiddenNotification:" + z);
            impl.d(z);
        } catch (Throwable th) {
            PLog.getInstance().e(th);
        }
    }

    public static void setBadgeCounts(int i) {
        try {
            if (isForb()) {
                return;
            }
            com.mob.pushsdk.b.d.a().a("setBadgeCounts:" + i);
            impl.a(i);
        } catch (Throwable th) {
            PLog.getInstance().e(th);
        }
    }

    public static void setClickNotificationToLaunchMainActivity(boolean z) {
        try {
            if (isForb()) {
                return;
            }
            com.mob.pushsdk.b.d.a().a("setClickNotificationToLaunchMainActivity:" + z);
            impl.b(z);
        } catch (Throwable th) {
            PLog.getInstance().e(th);
        }
    }

    @Deprecated
    public static void setCustomNotification(MobPushCustomNotification mobPushCustomNotification) {
        try {
            if (isForb()) {
                return;
            }
            com.mob.pushsdk.b.d.a().a("setCustomNotification:" + mobPushCustomNotification);
            impl.a(mobPushCustomNotification);
        } catch (Throwable th) {
            PLog.getInstance().e(th);
        }
    }

    public static void setDeviceTokenByUser(String str) {
        try {
            if (isForb()) {
                return;
            }
            impl.b(str);
        } catch (Throwable th) {
            PLog.getInstance().e(th);
        }
    }

    public static void setDomainAbroad(int i) {
        try {
            if (isForb()) {
                return;
            }
            com.mob.pushsdk.b.d.a().a("setDomainAbroad:" + i);
            impl.e(i);
        } catch (Throwable th) {
            PLog.getInstance().e(th);
        }
    }

    public static void setLocalNotifyExpiredGone(boolean z) {
        try {
            if (isForb()) {
                return;
            }
            com.mob.pushsdk.b.d.a().a("setLocalNotifyExpiredGone:" + z);
            impl.a(z);
        } catch (Throwable th) {
            PLog.getInstance().e(th);
        }
    }

    public static void setNotifyIcon(int i) {
        try {
            if (isForb()) {
                return;
            }
            com.mob.pushsdk.b.d.a().a("setNotifyIcon:" + i);
            impl.c(i);
        } catch (Throwable th) {
            PLog.getInstance().e(th);
        }
    }

    public static void setNotifyImportance(boolean z) {
        try {
            if (isForb()) {
                return;
            }
            com.mob.pushsdk.b.d.a().a("setNotifyImportance:" + z);
            impl.c(z);
        } catch (Throwable th) {
            PLog.getInstance().e(th);
        }
    }

    public static void setNotifyLargeIcon(int i) {
        try {
            if (isForb()) {
                return;
            }
            com.mob.pushsdk.b.d.a().a("setNotifyLargeIcon:" + i);
            impl.d(i);
        } catch (Throwable th) {
            PLog.getInstance().e(th);
        }
    }

    public static void setShowBadge(boolean z) {
        try {
            if (isForb()) {
                return;
            }
            com.mob.pushsdk.b.d.a().a("setShowBadge:" + z);
            impl.e(z);
        } catch (Throwable th) {
            PLog.getInstance().e(th);
        }
    }

    public static void setSilenceTime(int i, int i2, int i3, int i4) {
        try {
            if (isForb()) {
                return;
            }
            com.mob.pushsdk.b.d.a().a("setSilenceTime:" + i + Constants.ACCEPT_TIME_SEPARATOR_SP + i2 + Constants.ACCEPT_TIME_SEPARATOR_SP + i3 + Constants.ACCEPT_TIME_SEPARATOR_SP + i4);
            impl.a(i, i2, i3, i4);
        } catch (Throwable th) {
            PLog.getInstance().e(th);
        }
    }

    public static <T extends MobPushTailorNotification> void setTailorNotification(Class<T> cls) {
        try {
            if (isForb()) {
                return;
            }
            com.mob.pushsdk.b.d.a().a("setTailorNotification:" + cls);
            impl.a(cls);
        } catch (Throwable th) {
            PLog.getInstance().e(th);
        }
    }

    public static void stopPush() {
        try {
            if (isForb()) {
                return;
            }
            com.mob.pushsdk.b.d.a().a("stopPush");
            impl.d();
        } catch (Throwable th) {
            PLog.getInstance().e(th);
        }
    }

    public static void setDeviceTokenByUser(String str, String str2) {
        try {
            if (isForb()) {
                return;
            }
            impl.a(str, str2);
        } catch (Throwable th) {
            PLog.getInstance().e(th);
        }
    }
}
