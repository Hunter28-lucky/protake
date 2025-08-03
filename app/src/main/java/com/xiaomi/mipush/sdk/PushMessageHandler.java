package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.os.IBinder;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.MessageHandleService;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.push.du;
import com.xiaomi.push.ee;
import com.xiaomi.push.gk;
import com.xiaomi.push.hq;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class PushMessageHandler extends BaseService {
    private static List<MiPushClient.ICallbackResult> a = new ArrayList();
    private static List<MiPushClient.MiPushClientCallback> b = new ArrayList();

    /* renamed from: a, reason: collision with other field name */
    private static ThreadPoolExecutor f5504a = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    public interface a extends Serializable {
    }

    public static void a(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, (Class<?>) PushMessageHandler.class));
        try {
            context.startService(intent);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m5114a("PushMessageHandler", e2.getMessage());
        }
    }

    public static void b() {
        synchronized (a) {
            a.clear();
        }
    }

    private static void c(final Context context, final Intent intent) {
        if (intent != null && !f5504a.isShutdown()) {
            f5504a.execute(new Runnable() { // from class: com.xiaomi.mipush.sdk.PushMessageHandler.1
                @Override // java.lang.Runnable
                public void run() {
                    PushMessageHandler.b(context, intent);
                }
            });
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("-->scheduleJob() fail, case");
        sb.append(intent == null ? "0" : "1");
        com.xiaomi.channel.commonutils.logger.b.d("PushMessageHandler", sb.toString());
    }

    @Override // com.xiaomi.mipush.sdk.BaseService, android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // com.xiaomi.mipush.sdk.BaseService, android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        c(getApplicationContext(), intent);
    }

    public static void b(Context context, Intent intent) {
        boolean booleanExtra;
        try {
            intent.putExtra("pmh_handle_time", System.currentTimeMillis());
            booleanExtra = intent.getBooleanExtra("is_clicked_activity_call", false);
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.m5114a("PushMessageHandler", "intent unparcel error:" + th);
            booleanExtra = false;
        }
        try {
            com.xiaomi.channel.commonutils.logger.b.m5115a("PushMessageHandler", "-->onHandleIntent(): action=", intent.getAction());
            if ("com.xiaomi.mipush.SEND_TINYDATA".equals(intent.getAction())) {
                gk gkVar = new gk();
                hq.a(gkVar, intent.getByteArrayExtra("mipush_payload"));
                com.xiaomi.channel.commonutils.logger.b.m5118b("PushMessageHandler", "PushMessageHandler.onHandleIntent " + gkVar.d());
                MiTinyDataClient.upload(context, gkVar);
            } else if (1 == PushMessageHelper.getPushMode(context)) {
                if (m5136b()) {
                    com.xiaomi.channel.commonutils.logger.b.c("PushMessageHandler", "receive a message before application calling initialize");
                    if (booleanExtra) {
                        b(context);
                        return;
                    }
                    return;
                }
                a aVarA = t.a(context).a(intent);
                if (aVarA != null) {
                    a(context, aVarA);
                }
            } else if (!"com.xiaomi.mipush.sdk.SYNC_LOG".equals(intent.getAction())) {
                Intent intent2 = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
                intent2.setPackage(context.getPackageName());
                intent2.putExtras(intent);
                try {
                    List<ResolveInfo> listQueryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent2, 32);
                    ResolveInfo resolveInfo = null;
                    if (listQueryBroadcastReceivers != null) {
                        Iterator<ResolveInfo> it = listQueryBroadcastReceivers.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            ResolveInfo next = it.next();
                            ActivityInfo activityInfo = next.activityInfo;
                            if (activityInfo != null && activityInfo.packageName.equals(context.getPackageName()) && PushMessageReceiver.class.isAssignableFrom(com.xiaomi.push.s.a(context, next.activityInfo.name))) {
                                resolveInfo = next;
                                break;
                            }
                        }
                    }
                    if (resolveInfo != null) {
                        a(context, intent2, resolveInfo, booleanExtra);
                    } else {
                        com.xiaomi.channel.commonutils.logger.b.c("PushMessageHandler", "cannot find the receiver to handler this message, check your manifest");
                        du.a(context).a(context.getPackageName(), intent, "11");
                    }
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.a("PushMessageHandler", e2);
                    du.a(context).a(context.getPackageName(), intent, "9");
                }
            }
            if (!booleanExtra) {
            }
        } catch (Throwable th2) {
            try {
                com.xiaomi.channel.commonutils.logger.b.a("PushMessageHandler", th2);
                du.a(context).a(context.getPackageName(), intent, "10");
            } finally {
                if (booleanExtra) {
                    b(context);
                }
            }
        }
    }

    public static void a(Context context, Intent intent) {
        com.xiaomi.channel.commonutils.logger.b.m5118b("PushMessageHandler", "addjob PushMessageHandler " + intent);
        if (intent != null) {
            c(context, intent);
            a(context);
        }
    }

    public static void a(MiPushClient.MiPushClientCallback miPushClientCallback) {
        synchronized (b) {
            if (!b.contains(miPushClientCallback)) {
                b.add(miPushClientCallback);
            }
        }
    }

    public static void a(MiPushClient.ICallbackResult iCallbackResult) {
        synchronized (a) {
            if (!a.contains(iCallbackResult)) {
                a.add(iCallbackResult);
            }
        }
    }

    public static void a() {
        synchronized (b) {
            b.clear();
        }
    }

    private static void a(Context context, Intent intent, ResolveInfo resolveInfo, boolean z) {
        try {
            MessageHandleService.a aVar = new MessageHandleService.a(intent, (PushMessageReceiver) com.xiaomi.push.s.a(context, resolveInfo.activityInfo.name).newInstance());
            if (z) {
                MessageHandleService.a(context.getApplicationContext(), aVar);
            } else {
                MessageHandleService.addJob(context.getApplicationContext(), aVar);
            }
            MessageHandleService.a(context, new Intent(context.getApplicationContext(), (Class<?>) MessageHandleService.class));
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a(th);
        }
    }

    @Override // com.xiaomi.mipush.sdk.BaseService
    /* renamed from: a, reason: collision with other method in class */
    public boolean mo5137a() {
        ThreadPoolExecutor threadPoolExecutor = f5504a;
        return (threadPoolExecutor == null || threadPoolExecutor.getQueue() == null || f5504a.getQueue().size() <= 0) ? false : true;
    }

    public static void a(Context context, a aVar) {
        if (aVar instanceof MiPushMessage) {
            a(context, (MiPushMessage) aVar);
            return;
        }
        if (aVar instanceof MiPushCommandMessage) {
            MiPushCommandMessage miPushCommandMessage = (MiPushCommandMessage) aVar;
            String command = miPushCommandMessage.getCommand();
            String str = null;
            if (ee.COMMAND_REGISTER.f5830a.equals(command)) {
                List<String> commandArguments = miPushCommandMessage.getCommandArguments();
                if (commandArguments != null && !commandArguments.isEmpty()) {
                    str = commandArguments.get(0);
                }
                a(miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), str);
                return;
            }
            if (!ee.COMMAND_SET_ALIAS.f5830a.equals(command) && !ee.COMMAND_UNSET_ALIAS.f5830a.equals(command) && !ee.COMMAND_SET_ACCEPT_TIME.f5830a.equals(command)) {
                if (ee.COMMAND_SUBSCRIBE_TOPIC.f5830a.equals(command)) {
                    List<String> commandArguments2 = miPushCommandMessage.getCommandArguments();
                    if (commandArguments2 != null && !commandArguments2.isEmpty()) {
                        str = commandArguments2.get(0);
                    }
                    a(context, miPushCommandMessage.getCategory(), miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), str);
                    return;
                }
                if (ee.COMMAND_UNSUBSCRIBE_TOPIC.f5830a.equals(command)) {
                    List<String> commandArguments3 = miPushCommandMessage.getCommandArguments();
                    if (commandArguments3 != null && !commandArguments3.isEmpty()) {
                        str = commandArguments3.get(0);
                    }
                    b(context, miPushCommandMessage.getCategory(), miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), str);
                    return;
                }
                return;
            }
            a(context, miPushCommandMessage.getCategory(), command, miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), miPushCommandMessage.getCommandArguments());
        }
    }

    private static void b(Context context) {
        try {
            Intent intent = new Intent();
            intent.setPackage(context.getPackageName());
            intent.setAction("action_clicked_activity_finish");
            context.sendBroadcast(intent, c.a(context));
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m5114a("PushMessageHandler", "callback sync error" + e2);
        }
    }

    /* renamed from: b, reason: collision with other method in class */
    public static boolean m5136b() {
        return b.isEmpty();
    }

    public static void b(Context context, String str, long j, String str2, String str3) {
        synchronized (b) {
            for (MiPushClient.MiPushClientCallback miPushClientCallback : b) {
                if (a(str, miPushClientCallback.getCategory())) {
                    miPushClientCallback.onUnsubscribeResult(j, str2, str3);
                }
            }
        }
    }

    public static void a(Context context, MiPushMessage miPushMessage) {
        synchronized (b) {
            for (MiPushClient.MiPushClientCallback miPushClientCallback : b) {
                if (a(miPushMessage.getCategory(), miPushClientCallback.getCategory())) {
                    miPushClientCallback.onReceiveMessage(miPushMessage.getContent(), miPushMessage.getAlias(), miPushMessage.getTopic(), miPushMessage.isNotified());
                    miPushClientCallback.onReceiveMessage(miPushMessage);
                }
            }
        }
    }

    public static void a(long j, String str, String str2) {
        synchronized (b) {
            Iterator<MiPushClient.MiPushClientCallback> it = b.iterator();
            while (it.hasNext()) {
                it.next().onInitializeResult(j, str, str2);
            }
        }
    }

    public static void a(Context context, String str, long j, String str2, String str3) {
        synchronized (b) {
            for (MiPushClient.MiPushClientCallback miPushClientCallback : b) {
                if (a(str, miPushClientCallback.getCategory())) {
                    miPushClientCallback.onSubscribeResult(j, str2, str3);
                }
            }
        }
    }

    public static void a(Context context, String str, String str2, long j, String str3, List<String> list) {
        synchronized (b) {
            for (MiPushClient.MiPushClientCallback miPushClientCallback : b) {
                if (a(str, miPushClientCallback.getCategory())) {
                    miPushClientCallback.onCommandResult(str2, j, str3, list);
                }
            }
        }
    }

    public static boolean a(String str, String str2) {
        return (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || TextUtils.equals(str, str2);
    }

    public static void a(Context context, MiPushCommandMessage miPushCommandMessage) {
        synchronized (a) {
            for (MiPushClient.ICallbackResult iCallbackResult : a) {
                if (iCallbackResult instanceof MiPushClient.UPSRegisterCallBack) {
                    MiPushClient.TokenResult tokenResult = new MiPushClient.TokenResult();
                    if (miPushCommandMessage != null && miPushCommandMessage.getCommandArguments() != null && miPushCommandMessage.getCommandArguments().size() > 0) {
                        tokenResult.setResultCode(miPushCommandMessage.getResultCode());
                        tokenResult.setToken(miPushCommandMessage.getCommandArguments().get(0));
                    }
                    iCallbackResult.onResult(tokenResult);
                }
            }
        }
    }
}
