package com.mob.pushsdk.plugins.huawei.compat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.mob.pushsdk.base.PLog;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import org.jcodec.platform.Platform;

/* loaded from: classes2.dex */
public abstract class PushReceiver extends BroadcastReceiver {
    public ExecutorService a = Executors.newFixedThreadPool(3);

    /* renamed from: com.mob.pushsdk.plugins.huawei.compat.PushReceiver$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ReceiveType.values().length];
            a = iArr;
            try {
                iArr[ReceiveType.ReceiveType_Token.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ReceiveType.ReceiveType_Msg.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ReceiveType.ReceiveType_PushState.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ReceiveType.ReceiveType_NotifyClick.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[ReceiveType.ReceiveType_ClickBtn.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public enum Event {
        NOTIFICATION_OPENED,
        NOTIFICATION_CLICK_BTN
    }

    public enum ReceiveType {
        ReceiveType_Init,
        ReceiveType_Token,
        ReceiveType_Msg,
        ReceiveType_PushState,
        ReceiveType_NotifyClick,
        ReceiveType_ClickBtn
    }

    public class a implements Runnable {
        private Context b;
        private Bundle c;

        public a(Context context, Bundle bundle) {
            this.b = context;
            this.c = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bundle bundle = this.c;
            if (bundle == null) {
                return;
            }
            int i = bundle.getInt("receiveType");
            if (i < 0 || i >= ReceiveType.values().length) {
                PLog.getInstance().d("MobPush-HUAWEI: invalid receiverType:" + i, new Object[0]);
                return;
            }
            try {
                int i2 = AnonymousClass1.a[ReceiveType.values()[i].ordinal()];
                if (i2 == 1) {
                    PushReceiver.this.a(this.b, this.c.getString("deviceToken"), this.c);
                } else if (i2 == 2) {
                    byte[] byteArray = this.c.getByteArray("pushMsg");
                    if (byteArray != null) {
                        PushReceiver.this.a(this.b, byteArray, this.c);
                    }
                } else if (i2 == 3) {
                    PushReceiver.this.a(this.b, this.c.getBoolean("pushState"));
                } else if (i2 == 4) {
                    PushReceiver.this.a(this.b, Event.NOTIFICATION_OPENED, this.c);
                } else if (i2 == 5) {
                    PushReceiver.this.a(this.b, Event.NOTIFICATION_CLICK_BTN, this.c);
                }
            } catch (Exception unused) {
                PLog.getInstance().d("MobPush-HUAWEI: call EventThread(ReceiveType) error", new Object[0]);
            }
        }
    }

    public class b implements Runnable {
        private Context b;
        private Intent c;

        public b(Context context, Intent intent) {
            this.b = context;
            this.c = intent;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                byte[] byteArrayExtra = this.c.getByteArrayExtra("device_token");
                this.c.getStringExtra("extra_notify_key");
                if (byteArrayExtra == null) {
                    PLog.getInstance().d("MobPush-HUAWEI: get setLoggerInterface deviceToken, but it is null", new Object[0]);
                    return;
                }
                PLog.getInstance().d("MobPush-HUAWEI: receive setLoggerInterface push token: " + this.b.getPackageName(), new Object[0]);
                String str = new String(byteArrayExtra, Platform.UTF_8);
                Bundle bundle = new Bundle();
                bundle.putString("deviceToken", str);
                bundle.putByteArray("pushMsg", null);
                bundle.putInt("receiveType", ReceiveType.ReceiveType_Token.ordinal());
                if (this.c.getExtras() != null) {
                    bundle.putAll(this.c.getExtras());
                }
                PushReceiver pushReceiver = PushReceiver.this;
                pushReceiver.a.execute(pushReceiver.new a(this.b, bundle));
            } catch (UnsupportedEncodingException unused) {
                PLog.getInstance().d("MobPush-HUAWEI: encode token error", new Object[0]);
            } catch (RejectedExecutionException unused2) {
                PLog.getInstance().d("MobPush-HUAWEI: execute task error", new Object[0]);
            } catch (Throwable unused3) {
                PLog.getInstance().d("MobPush-HUAWEI: handle push token error", new Object[0]);
            }
        }
    }

    private void b(Context context, Intent intent) {
        try {
            String stringExtra = intent.getStringExtra("click");
            Bundle bundle = new Bundle();
            bundle.putString("pushMsg", stringExtra);
            bundle.putInt("receiveType", ReceiveType.ReceiveType_NotifyClick.ordinal());
            this.a.execute(new a(context, bundle));
        } catch (RejectedExecutionException unused) {
            PLog.getInstance().d("MobPush-HUAWEI: execute task error", new Object[0]);
        } catch (Throwable unused2) {
            PLog.getInstance().d("MobPush-HUAWEI: handle click event error", new Object[0]);
        }
    }

    private void c(Context context, Intent intent) {
        try {
            String stringExtra = intent.getStringExtra("clickBtn");
            int intExtra = intent.getIntExtra("notifyId", 0);
            Bundle bundle = new Bundle();
            bundle.putString("pushMsg", stringExtra);
            bundle.putInt("pushNotifyId", intExtra);
            bundle.putInt("receiveType", ReceiveType.ReceiveType_ClickBtn.ordinal());
            this.a.execute(new a(context, bundle));
        } catch (RejectedExecutionException unused) {
            PLog.getInstance().d("MobPush-HUAWEI: execute task error", new Object[0]);
        } catch (Throwable unused2) {
            PLog.getInstance().d("MobPush-HUAWEI: handleNotificationBtnOnclickEvent error", new Object[0]);
        }
    }

    public void a(Context context, Event event, Bundle bundle) {
    }

    public void a(Context context, String str) {
    }

    public void a(Context context, String str, Bundle bundle) {
        a(context, str);
    }

    public void a(Context context, boolean z) {
    }

    public void a(Context context, byte[] bArr, String str) {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent == null || context == null) {
            return;
        }
        PLog.getInstance().d("MobPush-HUAWEI: push receive broadcast message, Intent:" + intent.getAction() + " pkgName:" + context.getPackageName(), new Object[0]);
        try {
            intent.getStringExtra("TestIntent");
            String action = intent.getAction();
            if ("com.huawei.android.push.intent.REGISTRATION".equals(action) && intent.hasExtra("device_token")) {
                a(context, intent);
                return;
            }
            if ("com.huawei.android.push.intent.CLICK".equals(action) && intent.hasExtra("click")) {
                b(context, intent);
                return;
            }
            if ("com.huawei.android.push.intent.CLICK".equals(action) && intent.hasExtra("clickBtn")) {
                c(context, intent);
                return;
            }
            PLog.getInstance().d("MobPush-HUAWEI: message can't be recognised:" + intent.toUri(0), new Object[0]);
        } catch (Throwable unused) {
            PLog.getInstance().d("MobPush-HUAWEI: intent has some error", new Object[0]);
        }
    }

    public boolean a(Context context, byte[] bArr, Bundle bundle) {
        a(context, bArr, bundle != null ? bundle.getString("deviceToken") : "");
        return true;
    }

    private void a(Context context, Intent intent) {
        try {
            this.a.execute(new b(context, intent));
        } catch (Throwable unused) {
            PLog.getInstance().d("MobPush-HUAWEI: handlePushTokenEvent execute task error", new Object[0]);
        }
    }
}
