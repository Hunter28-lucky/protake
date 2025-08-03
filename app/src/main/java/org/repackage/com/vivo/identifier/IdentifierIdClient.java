package org.repackage.com.vivo.identifier;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;

/* loaded from: classes2.dex */
public class IdentifierIdClient {
    private static String A = null;
    private static volatile IdentifierIdClient B = null;
    private static volatile DataBaseOperation C = null;
    private static Context o = null;
    private static boolean p = false;
    private static IdentifierIdObserver q;
    private static IdentifierIdObserver r;
    private static IdentifierIdObserver s;
    private static Object t = new Object();
    private static HandlerThread u;
    private static Handler v;
    private static String w;
    private static String x;
    private static String y;
    private static String z;

    private IdentifierIdClient() {
    }

    public static IdentifierIdClient a(Context context) {
        if (B == null) {
            synchronized (IdentifierIdClient.class) {
                o = context.getApplicationContext();
                B = new IdentifierIdClient();
            }
        }
        if (C == null) {
            synchronized (IdentifierIdClient.class) {
                o = context.getApplicationContext();
                g();
                C = new DataBaseOperation(o);
                d();
            }
        }
        return B;
    }

    public static void d() {
        p = "1".equals(a("persist.sys.identifierid.supported", "0"));
    }

    private static void g() {
        HandlerThread handlerThread = new HandlerThread("SqlWorkThread");
        u = handlerThread;
        handlerThread.start();
        v = new Handler(u.getLooper()) { // from class: org.repackage.com.vivo.identifier.IdentifierIdClient.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 11) {
                    Log.e("VMS_IDLG_SDK_Client", "message type valid");
                    return;
                }
                String unused = IdentifierIdClient.w = IdentifierIdClient.C.a(message.getData().getInt("type"), message.getData().getString("appid"));
                synchronized (IdentifierIdClient.t) {
                    IdentifierIdClient.t.notify();
                }
            }
        };
    }

    public String b() {
        if (!a()) {
            return null;
        }
        String str = x;
        if (str != null) {
            return str;
        }
        a(0, (String) null);
        if (q == null) {
            a(o, 0, null);
        }
        return x;
    }

    private void b(int i, String str) {
        Message messageObtainMessage = v.obtainMessage();
        messageObtainMessage.what = 11;
        Bundle bundle = new Bundle();
        bundle.putInt("type", i);
        if (i == 1 || i == 2) {
            bundle.putString("appid", str);
        }
        messageObtainMessage.setData(bundle);
        v.sendMessage(messageObtainMessage);
    }

    public boolean a() {
        return p;
    }

    public void a(int i, String str) {
        synchronized (t) {
            b(i, str);
            long jUptimeMillis = SystemClock.uptimeMillis();
            try {
                t.wait(2000L);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (SystemClock.uptimeMillis() - jUptimeMillis >= 2000) {
                Log.d("VMS_IDLG_SDK_Client", "query timeout");
            } else if (i == 0) {
                x = w;
                w = null;
            } else if (i != 1) {
                if (i == 2) {
                    String str2 = w;
                    if (str2 != null) {
                        z = str2;
                        w = null;
                    } else {
                        Log.e("VMS_IDLG_SDK_Client", "get aaid failed");
                    }
                } else if (i != 4) {
                }
                A = w;
                w = null;
            } else {
                String str3 = w;
                if (str3 != null) {
                    y = str3;
                    w = null;
                } else {
                    Log.e("VMS_IDLG_SDK_Client", "get vaid failed");
                }
            }
        }
    }

    public static String a(String str, String str2) {
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

    private static void a(Context context, int i, String str) {
        if (i == 0) {
            q = new IdentifierIdObserver(B, 0, null);
            context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, q);
            return;
        }
        if (i == 1) {
            r = new IdentifierIdObserver(B, 1, str);
            context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + str), false, r);
            return;
        }
        if (i != 2) {
            return;
        }
        s = new IdentifierIdObserver(B, 2, str);
        context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/AAID_" + str), false, s);
    }
}
