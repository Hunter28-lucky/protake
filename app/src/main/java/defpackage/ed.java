package defpackage;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;

/* loaded from: classes.dex */
public class ed {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static Context f6615 = null;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static boolean f6616 = false;

    /* renamed from: ԩ, reason: contains not printable characters */
    public static oe f6617;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static oe f6618;

    /* renamed from: ԫ, reason: contains not printable characters */
    public static oe f6619;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static Object f6620 = new Object();

    /* renamed from: ԭ, reason: contains not printable characters */
    public static HandlerThread f6621;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static Handler f6622;

    /* renamed from: ԯ, reason: contains not printable characters */
    public static String f6623;

    /* renamed from: ՠ, reason: contains not printable characters */
    public static String f6624;

    /* renamed from: ֈ, reason: contains not printable characters */
    public static String f6625;

    /* renamed from: ֏, reason: contains not printable characters */
    public static String f6626;

    /* renamed from: ׯ, reason: contains not printable characters */
    public static String f6627;

    /* renamed from: ؠ, reason: contains not printable characters */
    public static volatile ed f6628;

    /* renamed from: ހ, reason: contains not printable characters */
    public static volatile jc f6629;

    /* renamed from: ed$Ϳ, reason: contains not printable characters */
    public static class HandlerC1959 extends Handler {
        public HandlerC1959(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 11) {
                Log.e("VMS_IDLG_SDK_Client", "message type valid");
                return;
            }
            String unused = ed.f6623 = ed.f6629.m7111(message.getData().getInt("type"), message.getData().getString("appid"));
            synchronized (ed.f6620) {
                ed.f6620.notify();
            }
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static ed m6014(Context context) {
        if (f6628 == null) {
            synchronized (ed.class) {
                f6615 = context.getApplicationContext();
                f6628 = new ed();
            }
        }
        if (f6629 == null) {
            synchronized (ed.class) {
                f6615 = context.getApplicationContext();
                m6021();
                f6629 = new jc(f6615);
                m6020();
            }
        }
        return f6628;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static String m6015(String str, String str2) {
        try {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "unknown");
            } catch (Exception e2) {
                e2.printStackTrace();
                return str2;
            }
        } catch (Throwable unused) {
            return str2;
        }
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static void m6016(Context context, int i, String str) {
        if (i == 0) {
            f6617 = new oe(f6628, 0, null);
            context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, f6617);
            return;
        }
        if (i == 1) {
            f6618 = new oe(f6628, 1, str);
            context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + str), false, f6618);
            return;
        }
        if (i != 2) {
            return;
        }
        f6619 = new oe(f6628, 2, str);
        context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/AAID_" + str), false, f6619);
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public static void m6020() {
        f6616 = "1".equals(m6015("persist.sys.identifierid.supported", "0"));
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public static void m6021() {
        HandlerThread handlerThread = new HandlerThread("SqlWorkThread");
        f6621 = handlerThread;
        handlerThread.start();
        f6622 = new HandlerC1959(f6621.getLooper());
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public String m6022() {
        if (!m6025()) {
            return null;
        }
        String str = f6624;
        if (str != null) {
            return str;
        }
        m6023(0, null);
        if (f6617 == null) {
            m6016(f6615, 0, null);
        }
        return f6624;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public void m6023(int i, String str) {
        synchronized (f6620) {
            m6024(i, str);
            long jUptimeMillis = SystemClock.uptimeMillis();
            try {
                f6620.wait(2000L);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (SystemClock.uptimeMillis() - jUptimeMillis >= 2000) {
                Log.d("VMS_IDLG_SDK_Client", "query timeout");
            } else if (i == 0) {
                f6624 = f6623;
                f6623 = null;
            } else if (i != 1) {
                if (i == 2) {
                    String str2 = f6623;
                    if (str2 != null) {
                        f6626 = str2;
                        f6623 = null;
                    } else {
                        Log.e("VMS_IDLG_SDK_Client", "get aaid failed");
                    }
                } else if (i != 4) {
                }
                f6627 = f6623;
                f6623 = null;
            } else {
                String str3 = f6623;
                if (str3 != null) {
                    f6625 = str3;
                    f6623 = null;
                } else {
                    Log.e("VMS_IDLG_SDK_Client", "get vaid failed");
                }
            }
        }
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final void m6024(int i, String str) {
        Message messageObtainMessage = f6622.obtainMessage();
        messageObtainMessage.what = 11;
        Bundle bundle = new Bundle();
        bundle.putInt("type", i);
        if (i == 1 || i == 2) {
            bundle.putString("appid", str);
        }
        messageObtainMessage.setData(bundle);
        f6622.sendMessage(messageObtainMessage);
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public boolean m6025() {
        return f6616;
    }
}
