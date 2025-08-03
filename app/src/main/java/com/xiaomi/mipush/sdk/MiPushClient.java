package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.clientreport.manager.ClientReportClient;
import com.xiaomi.mipush.sdk.MiTinyDataClient;
import com.xiaomi.push.BuildConfig;
import com.xiaomi.push.af;
import com.xiaomi.push.ao;
import com.xiaomi.push.av;
import com.xiaomi.push.bc;
import com.xiaomi.push.cy;
import com.xiaomi.push.dh;
import com.xiaomi.push.di;
import com.xiaomi.push.dr;
import com.xiaomi.push.ds;
import com.xiaomi.push.dt;
import com.xiaomi.push.ee;
import com.xiaomi.push.gg;
import com.xiaomi.push.gk;
import com.xiaomi.push.gl;
import com.xiaomi.push.gq;
import com.xiaomi.push.gt;
import com.xiaomi.push.gu;
import com.xiaomi.push.ha;
import com.xiaomi.push.hf;
import com.xiaomi.push.hg;
import com.xiaomi.push.hk;
import com.xiaomi.push.hm;
import com.xiaomi.push.ho;
import com.xiaomi.push.service.ah;
import com.xiaomi.push.service.aj;
import com.xiaomi.push.service.receivers.NetworkStatusReceiver;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public abstract class MiPushClient {
    public static final String COMMAND_REGISTER = "register";
    public static final String COMMAND_SET_ACCEPT_TIME = "accept-time";
    public static final String COMMAND_SET_ACCOUNT = "set-account";
    public static final String COMMAND_SET_ALIAS = "set-alias";
    public static final String COMMAND_SUBSCRIBE_TOPIC = "subscribe-topic";
    public static final String COMMAND_UNREGISTER = "unregister";
    public static final String COMMAND_UNSET_ACCOUNT = "unset-account";
    public static final String COMMAND_UNSET_ALIAS = "unset-alias";
    public static final String COMMAND_UNSUBSCRIBE_TOPIC = "unsubscibe-topic";
    public static final String PREF_EXTRA = "mipush_extra";
    private static Context sContext;
    private static long sCurMsgId = System.currentTimeMillis();

    public static class CodeResult {
        private long resultCode = -1;

        public long getResultCode() {
            return this.resultCode;
        }

        public void setResultCode(long j) {
            this.resultCode = j;
        }
    }

    public interface ICallbackResult<R> {
        void onResult(R r);
    }

    @Deprecated
    public static abstract class MiPushClientCallback {
        private String category;

        public String getCategory() {
            return this.category;
        }

        public void onCommandResult(String str, long j, String str2, List<String> list) {
        }

        public void onInitializeResult(long j, String str, String str2) {
        }

        public void onReceiveMessage(MiPushMessage miPushMessage) {
        }

        public void onReceiveMessage(String str, String str2, String str3, boolean z) {
        }

        public void onSubscribeResult(long j, String str, String str2) {
        }

        public void onUnsubscribeResult(long j, String str, String str2) {
        }

        public void setCategory(String str) {
            this.category = str;
        }
    }

    public static class TokenResult {
        private String token = null;
        private long resultCode = -1;

        public long getResultCode() {
            return this.resultCode;
        }

        public String getToken() {
            return this.token;
        }

        public void setResultCode(long j) {
            this.resultCode = j;
        }

        public void setToken(String str) {
            this.token = str;
        }
    }

    public interface UPSRegisterCallBack extends ICallbackResult<TokenResult> {
    }

    public interface UPSTurnCallBack extends ICallbackResult<CodeResult> {
    }

    public interface UPSUnRegisterCallBack extends ICallbackResult<TokenResult> {
    }

    private static boolean acceptTimeSet(Context context, String str, String str2) {
        return TextUtils.equals(getAcceptTime(context), str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2);
    }

    public static long accountSetTime(Context context, String str) {
        return context.getSharedPreferences("mipush_extra", 0).getLong("account_" + str, -1L);
    }

    public static synchronized void addAcceptTime(Context context, String str, String str2) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("mipush_extra", 0).edit();
        editorEdit.putString(Constants.EXTRA_KEY_ACCEPT_TIME, str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2);
        com.xiaomi.push.p.a(editorEdit);
    }

    public static synchronized void addAccount(Context context, String str) {
        context.getSharedPreferences("mipush_extra", 0).edit().putLong("account_" + str, System.currentTimeMillis()).commit();
    }

    public static synchronized void addAlias(Context context, String str) {
        context.getSharedPreferences("mipush_extra", 0).edit().putLong("alias_" + str, System.currentTimeMillis()).commit();
    }

    private static void addPullNotificationTime(Context context) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("mipush_extra", 0).edit();
        editorEdit.putLong("last_pull_notification", System.currentTimeMillis());
        com.xiaomi.push.p.a(editorEdit);
    }

    private static void addRegRequestTime(Context context) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("mipush_extra", 0).edit();
        editorEdit.putLong("last_reg_request", System.currentTimeMillis());
        com.xiaomi.push.p.a(editorEdit);
    }

    public static synchronized void addTopic(Context context, String str) {
        context.getSharedPreferences("mipush_extra", 0).edit().putLong("topic_" + str, System.currentTimeMillis()).commit();
    }

    public static long aliasSetTime(Context context, String str) {
        return context.getSharedPreferences("mipush_extra", 0).getLong("alias_" + str, -1L);
    }

    public static void awakeApps(final Context context, final String[] strArr) {
        af.a(context).a(new Runnable() { // from class: com.xiaomi.mipush.sdk.MiPushClient.4
            @Override // java.lang.Runnable
            public void run() {
                PackageInfo packageInfo;
                try {
                    for (String str : strArr) {
                        if (!TextUtils.isEmpty(str) && (packageInfo = context.getPackageManager().getPackageInfo(str, 4)) != null) {
                            MiPushClient.awakePushServiceByPackageInfo(context, packageInfo);
                        }
                    }
                } catch (Throwable th) {
                    com.xiaomi.channel.commonutils.logger.b.a(th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void awakePushServiceByPackageInfo(Context context, PackageInfo packageInfo) {
        ServiceInfo[] serviceInfoArr = packageInfo.services;
        if (serviceInfoArr != null) {
            for (ServiceInfo serviceInfo : serviceInfoArr) {
                if (serviceInfo.exported && serviceInfo.enabled && "com.xiaomi.mipush.sdk.PushMessageHandler".equals(serviceInfo.name) && !context.getPackageName().equals(serviceInfo.packageName)) {
                    try {
                        Thread.sleep(((long) ((Math.random() * 2.0d) + 1.0d)) * 1000);
                        Intent intent = new Intent();
                        intent.setClassName(serviceInfo.packageName, serviceInfo.name);
                        intent.setAction("com.xiaomi.mipush.sdk.WAKEUP");
                        intent.putExtra("waker_pkgname", context.getPackageName());
                        PushMessageHandler.a(context, intent);
                        return;
                    } catch (Throwable unused) {
                        return;
                    }
                }
            }
        }
    }

    private static void checkNotNull(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw new IllegalArgumentException("param " + str + " is not nullable");
    }

    public static void clearExtras(Context context) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("mipush_extra", 0).edit();
        editorEdit.clear();
        editorEdit.commit();
    }

    private static void clearExtrasForInitialize(Context context) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("mipush_extra", 0).edit();
        Iterator<String> it = getAllAlias(context).iterator();
        while (it.hasNext()) {
            editorEdit.remove("alias_" + it.next());
        }
        Iterator<String> it2 = getAllUserAccount(context).iterator();
        while (it2.hasNext()) {
            editorEdit.remove("account_" + it2.next());
        }
        Iterator<String> it3 = getAllTopic(context).iterator();
        while (it3.hasNext()) {
            editorEdit.remove("topic_" + it3.next());
        }
        editorEdit.remove(Constants.EXTRA_KEY_ACCEPT_TIME);
        editorEdit.commit();
    }

    public static void clearLocalNotificationType(Context context) {
        u.a(context).f();
    }

    public static void clearNotification(Context context, int i) {
        u.a(context).a(i);
    }

    public static void disablePush(Context context) {
        u.a(context).a(true);
    }

    public static void enablePush(Context context) {
        u.a(context).a(false);
    }

    public static String getAcceptTime(Context context) {
        return context.getSharedPreferences("mipush_extra", 0).getString(Constants.EXTRA_KEY_ACCEPT_TIME, "00:00-23:59");
    }

    public static List<String> getAllAlias(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String str : context.getSharedPreferences("mipush_extra", 0).getAll().keySet()) {
            if (str.startsWith("alias_")) {
                arrayList.add(str.substring(6));
            }
        }
        return arrayList;
    }

    public static List<String> getAllTopic(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String str : context.getSharedPreferences("mipush_extra", 0).getAll().keySet()) {
            if (str.startsWith("topic_") && !str.contains("**ALL**")) {
                arrayList.add(str.substring(6));
            }
        }
        return arrayList;
    }

    public static List<String> getAllUserAccount(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String str : context.getSharedPreferences("mipush_extra", 0).getAll().keySet()) {
            if (str.startsWith("account_")) {
                arrayList.add(str.substring(8));
            }
        }
        return arrayList;
    }

    public static String getAppRegion(Context context) {
        if (b.m5140a(context).m5149c()) {
            return b.m5140a(context).f();
        }
        return null;
    }

    private static boolean getDefaultSwitch() {
        return com.xiaomi.push.j.m5694b();
    }

    public static boolean getOpenFCMPush(Context context) {
        checkNotNull(context, com.umeng.analytics.pro.d.R);
        return e.a(context).b(d.ASSEMBLE_PUSH_FCM);
    }

    public static boolean getOpenHmsPush(Context context) {
        checkNotNull(context, com.umeng.analytics.pro.d.R);
        return e.a(context).b(d.ASSEMBLE_PUSH_HUAWEI);
    }

    public static boolean getOpenOPPOPush(Context context) {
        checkNotNull(context, com.umeng.analytics.pro.d.R);
        return e.a(context).b(d.ASSEMBLE_PUSH_COS);
    }

    public static boolean getOpenVIVOPush(Context context) {
        return e.a(context).b(d.ASSEMBLE_PUSH_FTOS);
    }

    public static String getRegId(Context context) {
        if (b.m5140a(context).m5149c()) {
            return b.m5140a(context).m5148c();
        }
        return null;
    }

    private static void initEventPerfLogic(final Context context) {
        dt.a(new dt.a() { // from class: com.xiaomi.mipush.sdk.MiPushClient.5
            @Override // com.xiaomi.push.dt.a
            public void uploader(Context context2, gk gkVar) {
                MiTinyDataClient.upload(context2, gkVar);
            }
        });
        Config configA = dt.a(context);
        com.xiaomi.clientreport.manager.a.a(context).a(BuildConfig.VERSION_NAME);
        ClientReportClient.init(context, configA, new dr(context), new ds(context));
        a.a(context);
        k.a(context, configA);
        ah.a(context).a(new ah.a(100, "perf event job update") { // from class: com.xiaomi.mipush.sdk.MiPushClient.6
            @Override // com.xiaomi.push.service.ah.a
            public void onCallback() {
                dt.m5423a(context);
            }
        });
    }

    @Deprecated
    public static void initialize(Context context, String str, String str2, MiPushClientCallback miPushClientCallback) {
        initialize(context, str, str2, miPushClientCallback, null, null);
    }

    private static void operateSyncAction(Context context) {
        if ("syncing".equals(p.a(sContext).a(v.DISABLE_PUSH))) {
            disablePush(sContext);
        }
        if ("syncing".equals(p.a(sContext).a(v.ENABLE_PUSH))) {
            enablePush(sContext);
        }
        p pVarA = p.a(sContext);
        v vVar = v.UPLOAD_HUAWEI_TOKEN;
        if ("syncing".equals(pVarA.a(vVar))) {
            u.a(sContext).a((String) null, vVar, d.ASSEMBLE_PUSH_HUAWEI, "init");
        }
        if ("syncing".equals(p.a(sContext).a(v.UPLOAD_FCM_TOKEN))) {
            syncAssembleFCMPushToken(sContext);
        }
        p pVarA2 = p.a(sContext);
        v vVar2 = v.UPLOAD_COS_TOKEN;
        if ("syncing".equals(pVarA2.a(vVar2))) {
            u.a(sContext).a((String) null, vVar2, d.ASSEMBLE_PUSH_COS, "init");
        }
        p pVarA3 = p.a(sContext);
        v vVar3 = v.UPLOAD_FTOS_TOKEN;
        if ("syncing".equals(pVarA3.a(vVar3))) {
            u.a(context).a((String) null, vVar3, d.ASSEMBLE_PUSH_FTOS, "init");
        }
    }

    public static void pausePush(Context context, String str) {
        setAcceptTime(context, 0, 0, 0, 0, str);
    }

    public static void reInitialize(Context context, gu guVar) {
        com.xiaomi.channel.commonutils.logger.b.e("re-register reason: " + guVar);
        String strA = bc.a(6);
        String strM5141a = b.m5140a(context).m5141a();
        String strB = b.m5140a(context).b();
        b.m5140a(context).m5142a();
        clearExtrasForInitialize(context);
        clearNotification(context);
        b.m5140a(context).a(Constants.a());
        b.m5140a(context).a(strM5141a, strB, strA);
        hg hgVar = new hg();
        hgVar.a(aj.b());
        hgVar.b(strM5141a);
        hgVar.e(strB);
        hgVar.f(strA);
        hgVar.d(context.getPackageName());
        hgVar.c(com.xiaomi.push.g.m5511a(context, context.getPackageName()));
        hgVar.b(com.xiaomi.push.g.a(context, context.getPackageName()));
        hgVar.h(BuildConfig.VERSION_NAME);
        hgVar.a(BuildConfig.VERSION_CODE);
        hgVar.a(guVar);
        int iA = com.xiaomi.push.i.a();
        if (iA >= 0) {
            hgVar.c(iA);
        }
        u.a(context).a(hgVar, false);
    }

    @Deprecated
    public static void registerCrashHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
    }

    private static void registerNetworkReceiver(Context context) {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            intentFilter.addCategory("android.intent.category.DEFAULT");
            com.xiaomi.push.m.a(context.getApplicationContext(), new NetworkStatusReceiver(null), intentFilter, 2);
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.m5113a("dynamic register network status receiver failed:" + th);
        }
        av.m5211a(sContext);
    }

    public static void registerPush(Context context, String str, String str2) {
        registerPush(context, str, str2, new PushConfiguration());
    }

    public static void registerToken(Context context, String str, String str2, String str3, UPSRegisterCallBack uPSRegisterCallBack) {
        registerPush(context, str, str2, new PushConfiguration(), null, uPSRegisterCallBack);
    }

    public static synchronized void removeAcceptTime(Context context) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("mipush_extra", 0).edit();
        editorEdit.remove(Constants.EXTRA_KEY_ACCEPT_TIME);
        com.xiaomi.push.p.a(editorEdit);
    }

    public static synchronized void removeAccount(Context context, String str) {
        context.getSharedPreferences("mipush_extra", 0).edit().remove("account_" + str).commit();
    }

    public static synchronized void removeAlias(Context context, String str) {
        context.getSharedPreferences("mipush_extra", 0).edit().remove("alias_" + str).commit();
    }

    public static synchronized void removeAllAccounts(Context context) {
        Iterator<String> it = getAllUserAccount(context).iterator();
        while (it.hasNext()) {
            removeAccount(context, it.next());
        }
    }

    public static synchronized void removeAllAliases(Context context) {
        Iterator<String> it = getAllAlias(context).iterator();
        while (it.hasNext()) {
            removeAlias(context, it.next());
        }
    }

    public static synchronized void removeAllTopics(Context context) {
        Iterator<String> it = getAllTopic(context).iterator();
        while (it.hasNext()) {
            removeTopic(context, it.next());
        }
    }

    public static synchronized void removeTopic(Context context, String str) {
        context.getSharedPreferences("mipush_extra", 0).edit().remove("topic_" + str).commit();
    }

    public static void removeWindow(Context context) {
        u.a(context).m5191e();
    }

    public static void reportAppRunInBackground(Context context, boolean z) {
        if (b.m5140a(context).m5147b()) {
            gq gqVar = z ? gq.APP_SLEEP : gq.APP_WAKEUP;
            hf hfVar = new hf();
            hfVar.b(b.m5140a(context).m5141a());
            hfVar.c(gqVar.f6003a);
            hfVar.d(context.getPackageName());
            hfVar.a(aj.a());
            hfVar.a(false);
            u.a(context).a((u) hfVar, gg.Notification, false, (gt) null, false);
        }
    }

    public static void reportIgnoreRegMessageClicked(Context context, String str, gt gtVar, String str2, String str3) {
        hf hfVar = new hf();
        if (TextUtils.isEmpty(str3)) {
            com.xiaomi.channel.commonutils.logger.b.d("do not report clicked message");
            return;
        }
        hfVar.b(str3);
        hfVar.c("bar:click");
        hfVar.a(str);
        hfVar.a(false);
        u.a(context).a(hfVar, gg.Notification, false, true, gtVar, true, str2, str3);
    }

    @Deprecated
    public static void reportMessageClicked(Context context, String str) {
        reportMessageClicked(context, str, null, null);
    }

    public static void resumePush(Context context, String str) {
        setAcceptTime(context, 0, 0, 23, 59, str);
    }

    private static void scheduleDataCollectionJobs(Context context) {
        if (ah.a(sContext).a(gl.DataCollectionSwitch.a(), getDefaultSwitch())) {
            dh.a().a(new i(context));
            af.a(sContext).a(new Runnable() { // from class: com.xiaomi.mipush.sdk.MiPushClient.2
                @Override // java.lang.Runnable
                public void run() {
                    di.a(MiPushClient.sContext);
                }
            }, 10);
        }
    }

    private static void scheduleOcVersionCheckJob() {
        af.a(sContext).a(new o(sContext), ah.a(sContext).a(gl.OcVersionCheckFrequency.a(), 86400), 5);
    }

    public static void setAcceptTime(Context context, int i, int i2, int i3, int i4, String str) {
        if (i < 0 || i >= 24 || i3 < 0 || i3 >= 24 || i2 < 0 || i2 >= 60 || i4 < 0 || i4 >= 60) {
            throw new IllegalArgumentException("the input parameter is not valid.");
        }
        long rawOffset = ((TimeZone.getTimeZone("GMT+08").getRawOffset() - TimeZone.getDefault().getRawOffset()) / 1000) / 60;
        long j = ((((i * 60) + i2) + rawOffset) + 1440) % 1440;
        long j2 = ((((i3 * 60) + i4) + rawOffset) + 1440) % 1440;
        ArrayList arrayList = new ArrayList();
        arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(j / 60), Long.valueOf(j % 60)));
        arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(j2 / 60), Long.valueOf(j2 % 60)));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(String.format("%1$02d:%2$02d", Integer.valueOf(i), Integer.valueOf(i2)));
        arrayList2.add(String.format("%1$02d:%2$02d", Integer.valueOf(i3), Integer.valueOf(i4)));
        if (!acceptTimeSet(context, (String) arrayList.get(0), (String) arrayList.get(1))) {
            setCommand(context, ee.COMMAND_SET_ACCEPT_TIME.f5830a, (ArrayList<String>) arrayList, str);
        } else if (1 == PushMessageHelper.getPushMode(context)) {
            PushMessageHandler.a(context, str, ee.COMMAND_SET_ACCEPT_TIME.f5830a, 0L, null, arrayList2);
        } else {
            PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(ee.COMMAND_SET_ACCEPT_TIME.f5830a, arrayList2, 0L, null, null, null));
        }
    }

    public static void setAlias(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        setCommand(context, ee.COMMAND_SET_ALIAS.f5830a, str, str2);
    }

    public static void setCommand(Context context, String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
        }
        ee eeVar = ee.COMMAND_SET_ALIAS;
        if (eeVar.f5830a.equalsIgnoreCase(str) && Math.abs(System.currentTimeMillis() - aliasSetTime(context, str2)) < 86400000) {
            if (1 == PushMessageHelper.getPushMode(context)) {
                PushMessageHandler.a(context, str3, str, 0L, null, arrayList);
                return;
            } else {
                PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(eeVar.f5830a, arrayList, 0L, null, str3, null));
                return;
            }
        }
        if (ee.COMMAND_UNSET_ALIAS.f5830a.equalsIgnoreCase(str) && aliasSetTime(context, str2) < 0) {
            com.xiaomi.channel.commonutils.logger.b.m5113a("Don't cancel alias for " + bc.a(arrayList.toString(), 3) + " is unseted");
            return;
        }
        ee eeVar2 = ee.COMMAND_SET_ACCOUNT;
        if (eeVar2.f5830a.equalsIgnoreCase(str) && Math.abs(System.currentTimeMillis() - accountSetTime(context, str2)) < 3600000) {
            if (1 == PushMessageHelper.getPushMode(context)) {
                PushMessageHandler.a(context, str3, str, 0L, null, arrayList);
                return;
            } else {
                PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(eeVar2.f5830a, arrayList, 0L, null, str3, null));
                return;
            }
        }
        if (!ee.COMMAND_UNSET_ACCOUNT.f5830a.equalsIgnoreCase(str) || accountSetTime(context, str2) >= 0) {
            setCommand(context, str, (ArrayList<String>) arrayList, str3);
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m5113a("Don't cancel account for " + bc.a(arrayList.toString(), 3) + " is unseted");
    }

    public static void setLocalNotificationType(Context context, int i) {
        u.a(context).b(i & (-1));
    }

    public static void setUserAccount(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        setCommand(context, ee.COMMAND_SET_ACCOUNT.f5830a, str, str2);
    }

    private static boolean shouldPullNotification(Context context) {
        return Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_pull_notification", -1L)) > Constants.ASSEMBLE_PUSH_NETWORK_INTERVAL;
    }

    private static boolean shouldSendRegRequest(Context context) {
        return Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_reg_request", -1L)) > 5000;
    }

    public static boolean shouldUseMIUIPush(Context context) {
        return u.a(context).m5185a();
    }

    public static void subscribe(Context context, String str, String str2) {
        if (TextUtils.isEmpty(b.m5140a(context).m5141a()) || TextUtils.isEmpty(str)) {
            return;
        }
        if (Math.abs(System.currentTimeMillis() - topicSubscribedTime(context, str)) <= 86400000) {
            if (1 == PushMessageHelper.getPushMode(context)) {
                PushMessageHandler.a(context, str2, 0L, null, str);
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(ee.COMMAND_SUBSCRIBE_TOPIC.f5830a, arrayList, 0L, null, null, null));
            return;
        }
        hk hkVar = new hk();
        String strA = aj.a();
        hkVar.a(strA);
        hkVar.b(b.m5140a(context).m5141a());
        hkVar.c(str);
        hkVar.d(context.getPackageName());
        hkVar.e(str2);
        com.xiaomi.channel.commonutils.logger.b.e("cmd:" + ee.COMMAND_SUBSCRIBE_TOPIC + ", " + strA);
        u.a(context).a((u) hkVar, gg.Subscription, (gt) null);
    }

    @Deprecated
    public static void syncAssembleCOSPushToken(Context context) {
    }

    public static void syncAssembleFCMPushToken(Context context) {
        u.a(context).a((String) null, v.UPLOAD_FCM_TOKEN, d.ASSEMBLE_PUSH_FCM, "");
    }

    @Deprecated
    public static void syncAssembleFTOSPushToken(Context context) {
    }

    @Deprecated
    public static void syncAssemblePushToken(Context context) {
    }

    public static long topicSubscribedTime(Context context, String str) {
        return context.getSharedPreferences("mipush_extra", 0).getLong("topic_" + str, -1L);
    }

    public static void turnOffPush(Context context, UPSTurnCallBack uPSTurnCallBack) {
        disablePush(context);
        if (uPSTurnCallBack != null) {
            CodeResult codeResult = new CodeResult();
            codeResult.setResultCode(0L);
            codeResult.getResultCode();
            uPSTurnCallBack.onResult(codeResult);
        }
    }

    public static void turnOnPush(Context context, UPSTurnCallBack uPSTurnCallBack) {
        enablePush(context);
        if (uPSTurnCallBack != null) {
            CodeResult codeResult = new CodeResult();
            codeResult.setResultCode(0L);
            codeResult.getResultCode();
            uPSTurnCallBack.onResult(codeResult);
        }
    }

    public static void unRegisterToken(Context context, UPSUnRegisterCallBack uPSUnRegisterCallBack) {
        unregisterPush(context);
        if (uPSUnRegisterCallBack != null) {
            TokenResult tokenResult = new TokenResult();
            tokenResult.setToken(null);
            tokenResult.getToken();
            tokenResult.setResultCode(0L);
            tokenResult.getResultCode();
            uPSUnRegisterCallBack.onResult(tokenResult);
        }
    }

    public static void unregisterPush(Context context) {
        f.c(context);
        ah.a(context).a();
        if (b.m5140a(context).m5147b()) {
            hm hmVar = new hm();
            hmVar.a(aj.a());
            hmVar.b(b.m5140a(context).m5141a());
            hmVar.c(b.m5140a(context).m5148c());
            hmVar.e(b.m5140a(context).b());
            hmVar.d(context.getPackageName());
            u.a(context).a(hmVar);
            PushMessageHandler.a();
            PushMessageHandler.b();
            b.m5140a(context).m5146b();
            clearLocalNotificationType(context);
            clearNotification(context);
            clearExtras(context);
        }
    }

    public static void unsetAlias(Context context, String str, String str2) {
        setCommand(context, ee.COMMAND_UNSET_ALIAS.f5830a, str, str2);
    }

    public static void unsetUserAccount(Context context, String str, String str2) {
        setCommand(context, ee.COMMAND_UNSET_ACCOUNT.f5830a, str, str2);
    }

    public static void unsubscribe(Context context, String str, String str2) {
        if (b.m5140a(context).m5147b()) {
            if (topicSubscribedTime(context, str) < 0) {
                com.xiaomi.channel.commonutils.logger.b.m5113a("Don't cancel subscribe for " + bc.a(str, 3) + " is unsubscribed");
                return;
            }
            ho hoVar = new ho();
            String strA = aj.a();
            hoVar.a(strA);
            hoVar.b(b.m5140a(context).m5141a());
            hoVar.c(str);
            hoVar.d(context.getPackageName());
            hoVar.e(str2);
            com.xiaomi.channel.commonutils.logger.b.e("cmd:" + ee.COMMAND_UNSUBSCRIBE_TOPIC + ", " + strA);
            u.a(context).a((u) hoVar, gg.UnSubscription, (gt) null);
        }
    }

    private static void updateImeiOrOaid() {
        new Thread(new Runnable() { // from class: com.xiaomi.mipush.sdk.MiPushClient.3
            @Override // java.lang.Runnable
            public void run() {
                if (com.xiaomi.push.j.m5696d()) {
                    return;
                }
                if (com.xiaomi.push.i.b(MiPushClient.sContext) != null || ao.a(MiPushClient.sContext).mo5202a()) {
                    hf hfVar = new hf();
                    hfVar.b(b.m5140a(MiPushClient.sContext).m5141a());
                    hfVar.c(gq.ClientInfoUpdate.f6003a);
                    hfVar.a(aj.a());
                    hfVar.a(new HashMap());
                    String str = "";
                    String strB = com.xiaomi.push.i.b(MiPushClient.sContext);
                    if (!TextUtils.isEmpty(strB)) {
                        str = "" + bc.a(strB);
                    }
                    String strD = com.xiaomi.push.i.d(MiPushClient.sContext);
                    if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(strD)) {
                        str = str + Constants.ACCEPT_TIME_SEPARATOR_SP + strD;
                    }
                    if (!TextUtils.isEmpty(str)) {
                        hfVar.m5609a().put(Constants.EXTRA_KEY_IMEI_MD5, str);
                    }
                    ao.a(MiPushClient.sContext).a(hfVar.m5609a());
                    int iA = com.xiaomi.push.i.a();
                    if (iA >= 0) {
                        hfVar.m5609a().put("space_id", Integer.toString(iA));
                    }
                    u.a(MiPushClient.sContext).a((u) hfVar, gg.Notification, false, (gt) null);
                }
            }
        }).start();
    }

    public static void clearNotification(Context context, String str, String str2) {
        u.a(context).a(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void initialize(Context context, String str, String str2, MiPushClientCallback miPushClientCallback, String str3, ICallbackResult iCallbackResult) {
        try {
            com.xiaomi.channel.commonutils.logger.b.a(context.getApplicationContext());
            com.xiaomi.channel.commonutils.logger.b.e("sdk_version = 6_0_1-C");
            ao.a(context).a();
            cy.a(context);
            if (miPushClientCallback != null) {
                PushMessageHandler.a(miPushClientCallback);
            }
            if (iCallbackResult != null) {
                PushMessageHandler.a(iCallbackResult);
            }
            if (com.xiaomi.push.s.m5705a(sContext)) {
                m.a(sContext);
            }
            boolean z = b.m5140a(sContext).a() != Constants.a();
            if (!z && !shouldSendRegRequest(sContext)) {
                u.a(sContext).m5182a();
                com.xiaomi.channel.commonutils.logger.b.m5113a("Could not send  register message within 5s repeatly .");
                return;
            }
            if (z || !b.m5140a(sContext).a(str, str2) || b.m5140a(sContext).m5152f()) {
                String strA = bc.a(6);
                b.m5140a(sContext).m5142a();
                b.m5140a(sContext).a(Constants.a());
                b.m5140a(sContext).a(str, str2, strA);
                MiTinyDataClient.a.a().b(MiTinyDataClient.PENDING_REASON_APPID);
                clearExtras(sContext);
                clearNotification(context);
                hg hgVar = new hg();
                hgVar.a(aj.b());
                hgVar.b(str);
                hgVar.e(str2);
                hgVar.d(sContext.getPackageName());
                hgVar.f(strA);
                Context context2 = sContext;
                hgVar.c(com.xiaomi.push.g.m5511a(context2, context2.getPackageName()));
                Context context3 = sContext;
                hgVar.b(com.xiaomi.push.g.a(context3, context3.getPackageName()));
                hgVar.h(BuildConfig.VERSION_NAME);
                hgVar.a(BuildConfig.VERSION_CODE);
                hgVar.a(gu.Init);
                if (!TextUtils.isEmpty(str3)) {
                    hgVar.g(str3);
                }
                if (!com.xiaomi.push.j.m5696d()) {
                    String strC = com.xiaomi.push.i.c(sContext);
                    if (!TextUtils.isEmpty(strC)) {
                        hgVar.i(bc.a(strC) + Constants.ACCEPT_TIME_SEPARATOR_SP + com.xiaomi.push.i.e(sContext));
                    }
                }
                int iA = com.xiaomi.push.i.a();
                if (iA >= 0) {
                    hgVar.c(iA);
                }
                u.a(sContext).a(hgVar, z);
                sContext.getSharedPreferences("mipush_extra", 4).getBoolean("mipush_registed", true);
            } else {
                if (1 == PushMessageHelper.getPushMode(sContext)) {
                    checkNotNull(miPushClientCallback, "callback");
                    miPushClientCallback.onInitializeResult(0L, null, b.m5140a(sContext).m5148c());
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(b.m5140a(sContext).m5148c());
                    PushMessageHelper.sendCommandMessageBroadcast(sContext, PushMessageHelper.generateCommandMessage(ee.COMMAND_REGISTER.f5830a, arrayList, 0L, null, null, null));
                }
                u.a(sContext).m5182a();
                if (b.m5140a(sContext).m5144a()) {
                    hf hfVar = new hf();
                    hfVar.b(b.m5140a(sContext).m5141a());
                    hfVar.c(gq.ClientInfoUpdate.f6003a);
                    hfVar.a(aj.a());
                    HashMap map = new HashMap();
                    hfVar.f6142a = map;
                    Context context4 = sContext;
                    map.put("app_version", com.xiaomi.push.g.m5511a(context4, context4.getPackageName()));
                    Map<String, String> map2 = hfVar.f6142a;
                    Context context5 = sContext;
                    map2.put(Constants.EXTRA_KEY_APP_VERSION_CODE, Integer.toString(com.xiaomi.push.g.a(context5, context5.getPackageName())));
                    hfVar.f6142a.put("push_sdk_vn", BuildConfig.VERSION_NAME);
                    hfVar.f6142a.put("push_sdk_vc", Integer.toString(BuildConfig.VERSION_CODE));
                    String strE = b.m5140a(sContext).e();
                    if (!TextUtils.isEmpty(strE)) {
                        hfVar.f6142a.put("deviceid", strE);
                    }
                    u.a(sContext).a((u) hfVar, gg.Notification, false, (gt) null);
                    u.a(sContext).m5183a(sContext);
                }
                if (!com.xiaomi.push.l.m5699a(sContext, "update_devId", false)) {
                    updateImeiOrOaid();
                    com.xiaomi.push.l.a(sContext, "update_devId", true);
                }
                if (shouldUseMIUIPush(sContext) && shouldPullNotification(sContext)) {
                    hf hfVar2 = new hf();
                    hfVar2.b(b.m5140a(sContext).m5141a());
                    hfVar2.c(gq.PullOfflineMessage.f6003a);
                    hfVar2.a(aj.a());
                    hfVar2.a(false);
                    u.a(sContext).a((u) hfVar2, gg.Notification, false, (gt) null, false);
                    addPullNotificationTime(sContext);
                }
            }
            addRegRequestTime(sContext);
            scheduleOcVersionCheckJob();
            scheduleDataCollectionJobs(sContext);
            initEventPerfLogic(sContext);
            w.a(sContext);
            if (!sContext.getPackageName().equals("com.xiaomi.xmsf")) {
                if (Logger.getUserLogger() != null) {
                    Logger.setLogger(sContext, Logger.getUserLogger());
                }
                com.xiaomi.channel.commonutils.logger.b.a(2);
            }
            operateSyncAction(context);
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a(th);
        }
    }

    public static void registerPush(Context context, String str, String str2, String str3) {
        registerPush(context, str, str2, new PushConfiguration(), str3, null);
    }

    public static void reportMessageClicked(Context context, MiPushMessage miPushMessage) {
        gt gtVar = new gt();
        gtVar.a(miPushMessage.getMessageId());
        gtVar.b(miPushMessage.getTopic());
        gtVar.d(miPushMessage.getDescription());
        gtVar.c(miPushMessage.getTitle());
        gtVar.c(miPushMessage.getNotifyId());
        gtVar.a(miPushMessage.getNotifyType());
        gtVar.b(miPushMessage.getPassThrough());
        gtVar.a(miPushMessage.getExtra());
        reportMessageClicked(context, miPushMessage.getMessageId(), gtVar, null);
    }

    public static void clearNotification(Context context) {
        u.a(context).a(-1);
    }

    public static void registerPush(Context context, String str, String str2, PushConfiguration pushConfiguration) {
        registerPush(context, str, str2, pushConfiguration, null, null);
    }

    private static void registerPush(Context context, final String str, final String str2, PushConfiguration pushConfiguration, final String str3, final ICallbackResult iCallbackResult) {
        checkNotNull(context, com.umeng.analytics.pro.d.R);
        checkNotNull(str, "appID");
        checkNotNull(str2, "appToken");
        Context applicationContext = context.getApplicationContext();
        sContext = applicationContext;
        if (applicationContext == null) {
            sContext = context;
        }
        Context context2 = sContext;
        com.xiaomi.push.s.a(context2);
        if (!NetworkStatusReceiver.a()) {
            registerNetworkReceiver(sContext);
        }
        e.a(sContext).a(pushConfiguration);
        af.a(context2).a(new Runnable() { // from class: com.xiaomi.mipush.sdk.MiPushClient.1
            @Override // java.lang.Runnable
            public void run() {
                MiPushClient.initialize(MiPushClient.sContext, str, str2, null, str3, iCallbackResult);
            }
        });
    }

    public static void reportMessageClicked(Context context, String str, gt gtVar, String str2) {
        hf hfVar = new hf();
        if (TextUtils.isEmpty(str2)) {
            if (b.m5140a(context).m5147b()) {
                hfVar.b(b.m5140a(context).m5141a());
            } else {
                com.xiaomi.channel.commonutils.logger.b.d("do not report clicked message");
                return;
            }
        } else {
            hfVar.b(str2);
        }
        hfVar.c("bar:click");
        hfVar.a(str);
        hfVar.a(false);
        u.a(context).a((u) hfVar, gg.Notification, false, gtVar);
    }

    public static void setCommand(Context context, String str, ArrayList<String> arrayList, String str2) {
        if (TextUtils.isEmpty(b.m5140a(context).m5141a())) {
            return;
        }
        ha haVar = new ha();
        String strA = aj.a();
        haVar.a(strA);
        haVar.b(b.m5140a(context).m5141a());
        haVar.c(str);
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            haVar.m5584a(it.next());
        }
        haVar.e(str2);
        haVar.d(context.getPackageName());
        com.xiaomi.channel.commonutils.logger.b.e("cmd:" + str + ", " + strA);
        u.a(context).a((u) haVar, gg.Command, (gt) null);
    }
}
