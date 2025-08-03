package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.PushMessageHandler;
import com.xiaomi.push.af;
import com.xiaomi.push.du;
import com.xiaomi.push.ee;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class MessageHandleService extends BaseService {
    private static ConcurrentLinkedQueue<a> a = new ConcurrentLinkedQueue<>();

    /* renamed from: a, reason: collision with other field name */
    private static ExecutorService f5489a = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    public static class a {
        private Intent a;

        /* renamed from: a, reason: collision with other field name */
        private PushMessageReceiver f5491a;

        public a(Intent intent, PushMessageReceiver pushMessageReceiver) {
            this.f5491a = pushMessageReceiver;
            this.a = intent;
        }

        /* renamed from: a, reason: collision with other method in class */
        public PushMessageReceiver m5131a() {
            return this.f5491a;
        }

        public Intent a() {
            return this.a;
        }
    }

    public static void addJob(Context context, a aVar) {
        if (aVar != null) {
            a.add(aVar);
            b(context);
            startService(context);
        }
    }

    private static void b(final Context context) {
        if (f5489a.isShutdown()) {
            return;
        }
        f5489a.execute(new Runnable() { // from class: com.xiaomi.mipush.sdk.MessageHandleService.2
            @Override // java.lang.Runnable
            public void run() {
                MessageHandleService.c(context);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context) {
        try {
            a(context, a.poll());
        } catch (RuntimeException e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
        }
    }

    public static void startService(final Context context) {
        final Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, (Class<?>) MessageHandleService.class));
        af.a(context).a(new Runnable() { // from class: com.xiaomi.mipush.sdk.MessageHandleService.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    context.startService(intent);
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.m5113a(e2.getMessage());
                }
            }
        });
    }

    @Override // com.xiaomi.mipush.sdk.BaseService, android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // com.xiaomi.mipush.sdk.BaseService, android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
    }

    public static void a(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        b(context);
    }

    public static void a(Context context, a aVar) {
        String[] stringArrayExtra;
        if (aVar == null) {
            return;
        }
        try {
            PushMessageReceiver pushMessageReceiverM5131a = aVar.m5131a();
            Intent intentA = aVar.a();
            int intExtra = intentA.getIntExtra(PushMessageHelper.MESSAGE_TYPE, 1);
            if (intExtra != 1) {
                if (intExtra != 3) {
                    if (intExtra == 5 && PushMessageHelper.ERROR_TYPE_NEED_PERMISSION.equals(intentA.getStringExtra(PushMessageHelper.ERROR_TYPE)) && (stringArrayExtra = intentA.getStringArrayExtra(PushMessageHelper.ERROR_MESSAGE)) != null) {
                        com.xiaomi.channel.commonutils.logger.b.e("begin execute onRequirePermissions, lack of necessary permissions");
                        pushMessageReceiverM5131a.onRequirePermissions(context, stringArrayExtra);
                        return;
                    }
                    return;
                }
                MiPushCommandMessage miPushCommandMessage = (MiPushCommandMessage) intentA.getSerializableExtra(PushMessageHelper.KEY_COMMAND);
                com.xiaomi.channel.commonutils.logger.b.e("(Local) begin execute onCommandResult, command=" + miPushCommandMessage.getCommand() + ", resultCode=" + miPushCommandMessage.getResultCode() + ", reason=" + miPushCommandMessage.getReason());
                pushMessageReceiverM5131a.onCommandResult(context, miPushCommandMessage);
                if (TextUtils.equals(miPushCommandMessage.getCommand(), ee.COMMAND_REGISTER.f5830a)) {
                    pushMessageReceiverM5131a.onReceiveRegisterResult(context, miPushCommandMessage);
                    PushMessageHandler.a(context, miPushCommandMessage);
                    if (miPushCommandMessage.getResultCode() == 0) {
                        f.b(context);
                        return;
                    }
                    return;
                }
                return;
            }
            PushMessageHandler.a aVarA = t.a(context).a(intentA);
            int intExtra2 = intentA.getIntExtra("eventMessageType", -1);
            if (aVarA != null) {
                if (aVarA instanceof MiPushMessage) {
                    MiPushMessage miPushMessage = (MiPushMessage) aVarA;
                    if (!miPushMessage.isArrivedMessage()) {
                        pushMessageReceiverM5131a.onReceiveMessage(context, miPushMessage);
                    }
                    if (miPushMessage.getPassThrough() == 1) {
                        du.a(context.getApplicationContext()).a(context.getPackageName(), intentA, 2004, (String) null);
                        com.xiaomi.channel.commonutils.logger.b.d("MessageHandleService", "begin execute onReceivePassThroughMessage from " + miPushMessage.getMessageId());
                        pushMessageReceiverM5131a.onReceivePassThroughMessage(context, miPushMessage);
                        return;
                    }
                    if (miPushMessage.isNotified()) {
                        if (intExtra2 == 1000) {
                            du.a(context.getApplicationContext()).a(context.getPackageName(), intentA, 1007, (String) null);
                        } else {
                            du.a(context.getApplicationContext()).a(context.getPackageName(), intentA, 3007, (String) null);
                        }
                        com.xiaomi.channel.commonutils.logger.b.d("MessageHandleService", "begin execute onNotificationMessageClicked from\u3000" + miPushMessage.getMessageId());
                        pushMessageReceiverM5131a.onNotificationMessageClicked(context, miPushMessage);
                        return;
                    }
                    com.xiaomi.channel.commonutils.logger.b.d("MessageHandleService", "begin execute onNotificationMessageArrived from " + miPushMessage.getMessageId());
                    pushMessageReceiverM5131a.onNotificationMessageArrived(context, miPushMessage);
                    return;
                }
                if (aVarA instanceof MiPushCommandMessage) {
                    MiPushCommandMessage miPushCommandMessage2 = (MiPushCommandMessage) aVarA;
                    com.xiaomi.channel.commonutils.logger.b.d("MessageHandleService", "begin execute onCommandResult, command=" + miPushCommandMessage2.getCommand() + ", resultCode=" + miPushCommandMessage2.getResultCode() + ", reason=" + miPushCommandMessage2.getReason());
                    pushMessageReceiverM5131a.onCommandResult(context, miPushCommandMessage2);
                    if (TextUtils.equals(miPushCommandMessage2.getCommand(), ee.COMMAND_REGISTER.f5830a)) {
                        pushMessageReceiverM5131a.onReceiveRegisterResult(context, miPushCommandMessage2);
                        PushMessageHandler.a(context, miPushCommandMessage2);
                        if (miPushCommandMessage2.getResultCode() == 0) {
                            f.b(context);
                            return;
                        }
                        return;
                    }
                    return;
                }
                com.xiaomi.channel.commonutils.logger.b.d("MessageHandleService", "unknown raw message: " + aVarA);
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.d("MessageHandleService", "no message from raw for receiver");
        } catch (RuntimeException e2) {
            com.xiaomi.channel.commonutils.logger.b.a("MessageHandleService", e2);
        }
    }

    @Override // com.xiaomi.mipush.sdk.BaseService
    /* renamed from: a */
    public boolean mo5137a() {
        ConcurrentLinkedQueue<a> concurrentLinkedQueue = a;
        return concurrentLinkedQueue != null && concurrentLinkedQueue.size() > 0;
    }
}
