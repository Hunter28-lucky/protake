package com.mob.pushsdk.biz;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import androidx.appcompat.widget.ActivityChooserModel;
import com.mob.MobSDK;
import com.mob.pushsdk.impl.ReceivedMsg;
import com.mob.tools.MobLog;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.SharePrefrenceHelper;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
public class d {
    private static SharePrefrenceHelper a;
    private static SharePrefrenceHelper b;
    private static SharePrefrenceHelper c;

    public static synchronized String a() {
        w();
        return a.getString("key_registration_id");
    }

    public static synchronized boolean b() {
        w();
        return a.getBoolean("key_push_local_expired_gone");
    }

    public static synchronized int c() {
        w();
        return a.getInt("key_domain_abroad", 0);
    }

    public static synchronized String d() {
        w();
        return a.getString("key_last_device_token");
    }

    public static synchronized String e() {
        w();
        return a.getString("key_device_token");
    }

    public static synchronized String f() {
        w();
        return a.getString("key_channel");
    }

    public static synchronized HashSet<String> g() {
        w();
        return (HashSet) a.get("key_accepted_msg_ids");
    }

    public static synchronized boolean h() {
        w();
        return a.getBoolean("key_push_service_status");
    }

    public static synchronized int[] i() {
        x();
        return (int[]) b.get("key_silence_time");
    }

    public static synchronized String j() {
        x();
        return b.getString("key_custom_notify");
    }

    public static synchronized String k() {
        w();
        return a.getString("key_tailor_notify");
    }

    public static synchronized int l() {
        w();
        return a.getInt("key_timing_message_count");
    }

    public static synchronized boolean m() {
        w();
        return a.getBoolean("key_launch_activity_disable");
    }

    public static synchronized int n() {
        x();
        return b.getInt("key_push_icon");
    }

    public static synchronized int o() {
        w();
        return a.getInt("key_push_large_icon");
    }

    public static synchronized boolean p() {
        w();
        return a.getBoolean("key_push_notify_importance", false);
    }

    public static synchronized String q() {
        x();
        return b.getString("key_push_alias");
    }

    public static synchronized String r() {
        x();
        return b.getString("key_push_tags");
    }

    public static synchronized boolean s() {
        w();
        return a.getBoolean("key_app_foreground_hidden_notification");
    }

    public static synchronized boolean t() {
        w();
        return a.getBoolean("key_show_badge");
    }

    public static synchronized Set<ReceivedMsg> u() {
        y();
        if (c.get("key_received_msg_ids") == null) {
            return new HashSet();
        }
        return (Set) c.get("key_received_msg_ids");
    }

    private static String v() {
        String strA = a(MobSDK.getContext());
        String packageName = MobSDK.getContext().getPackageName();
        return strA == null ? "null" : strA.equals(packageName) ? "main" : strA.startsWith(packageName) ? strA.substring(packageName.length() + 1) : strA;
    }

    private static synchronized void w() {
        if (a == null) {
            SharePrefrenceHelper sharePrefrenceHelper = new SharePrefrenceHelper(MobSDK.getContext());
            a = sharePrefrenceHelper;
            sharePrefrenceHelper.open("PUSH_SDK" + v(), 1);
        }
    }

    private static synchronized void x() {
        if (b == null) {
            b = new SharePrefrenceHelper(MobSDK.getContext());
        }
        b.open("PUSH_SDK", 1);
    }

    private static synchronized void y() {
        if (c == null) {
            SharePrefrenceHelper sharePrefrenceHelper = new SharePrefrenceHelper(MobSDK.getContext());
            c = sharePrefrenceHelper;
            sharePrefrenceHelper.open("PUSH_SDK_RECEIVED_MSG", 1);
        }
    }

    public static synchronized void a(String str) {
        w();
        a.putString("key_registration_id", str);
    }

    public static synchronized void b(String str) {
        w();
        a.putString("key_last_device_token", str);
    }

    public static synchronized void c(String str) {
        w();
        a.putString("key_device_token", str);
    }

    public static synchronized void d(String str) {
        w();
        a.putString("key_channel", str);
    }

    public static synchronized void e(String str) {
        x();
        b.putString("key_custom_notify", str);
    }

    public static synchronized void f(String str) {
        w();
        a.putString("key_tailor_notify", str);
    }

    public static synchronized void g(String str) {
        x();
        b.putString("key_push_alias", str);
    }

    public static synchronized void h(String str) {
        x();
        b.putString("key_push_tags", str);
    }

    public static synchronized void a(boolean z) {
        w();
        a.putBoolean("key_push_local_expired_gone", Boolean.valueOf(z));
    }

    public static synchronized void b(boolean z) {
        w();
        a.putBoolean("key_push_service_status", Boolean.valueOf(z));
    }

    public static synchronized void c(boolean z) {
        w();
        if (z) {
            a.putBoolean("key_launch_activity_disable", Boolean.valueOf(z));
        } else {
            a.remove("key_launch_activity_disable");
        }
    }

    public static synchronized void d(int i) {
        w();
        a.putInt("key_push_large_icon", Integer.valueOf(i));
    }

    public static synchronized void e(boolean z) {
        w();
        a.putBoolean("key_app_foreground_hidden_notification", Boolean.valueOf(z));
    }

    public static synchronized void f(boolean z) {
        w();
        a.putBoolean("key_show_badge", Boolean.valueOf(z));
    }

    public static synchronized void a(int i) {
        w();
        a.putInt("key_domain_abroad", Integer.valueOf(i));
    }

    public static synchronized void b(int i) {
        w();
        a.putInt("key_timing_message_count", Integer.valueOf(i));
    }

    public static synchronized void d(boolean z) {
        w();
        a.putBoolean("key_push_notify_importance", Boolean.valueOf(z));
    }

    public static synchronized void c(int i) {
        w();
        a.putInt("key_push_icon", Integer.valueOf(i));
    }

    public static synchronized void a(HashSet<String> hashSet) {
        w();
        if (hashSet == null) {
            a.remove("key_accepted_msg_ids");
        } else {
            a.put("key_accepted_msg_ids", hashSet);
        }
    }

    public static synchronized void a(int[] iArr) {
        x();
        if (iArr != null && iArr.length == 4) {
            b.put("key_silence_time", iArr);
        } else {
            b.remove("key_silence_time");
        }
    }

    public static synchronized void a(Set<ReceivedMsg> set) {
        y();
        c.put("key_received_msg_ids", set);
    }

    public static synchronized void a(ReceivedMsg receivedMsg) {
        y();
        Set hashSet = (Set) c.get("key_received_msg_ids");
        if (hashSet == null) {
            hashSet = new HashSet();
        }
        hashSet.add(receivedMsg);
        c.put("key_received_msg_ids", hashSet);
    }

    private static String a(Context context) {
        List<ActivityManager.RunningAppProcessInfo> list;
        String str = null;
        try {
            list = (List) ReflectHelper.invokeInstanceMethod((ActivityManager) context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY), "getRunningAppProcesses", new Object[0]);
        } catch (Throwable th) {
            MobLog.getInstance().d(th.toString(), new Object[0]);
        }
        if (list == null) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : list) {
            try {
                if (runningAppProcessInfo.pid == Process.myPid()) {
                    str = runningAppProcessInfo.processName;
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        MobLog.getInstance().d(String.format("getProcessName %s in mainProcess %s", str, Boolean.valueOf(str != null && str.equalsIgnoreCase(context.getPackageName()))), new Object[0]);
        return str;
    }
}
