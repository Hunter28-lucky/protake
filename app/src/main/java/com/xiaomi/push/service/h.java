package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.push.es;
import com.xiaomi.push.fn;
import com.xiaomi.push.fo;
import com.xiaomi.push.fp;
import com.xiaomi.push.fr;
import com.xiaomi.push.service.am;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class h {
    private u a = new u();

    @SuppressLint({"WrongConstant"})
    public void a(Context context) {
        if ("com.xiaomi.xmsf".equals(context.getPackageName())) {
            Intent intent = new Intent();
            intent.setAction("com.xiaomi.push.service_started");
            if (com.xiaomi.push.j.m5695c()) {
                intent.addFlags(16777216);
            }
            com.xiaomi.channel.commonutils.logger.b.m5113a("[Bcst] send ***.push.service_started broadcast to inform push service has started.");
            intent.setPackage("com.android.mms");
            context.sendBroadcast(intent);
        }
    }

    @SuppressLint({"DefaultLocale"})
    public void a(Context context, am.b bVar, boolean z, int i, String str) {
        if ("5".equalsIgnoreCase(bVar.g)) {
            this.a.a(context, bVar, z, i, str);
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.channel_opened");
        intent.setPackage(bVar.f6404a);
        intent.putExtra("ext_succeeded", z);
        if (!z) {
            intent.putExtra("ext_reason", i);
        }
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("ext_reason_msg", str);
        }
        intent.putExtra("ext_chid", bVar.g);
        intent.putExtra(an.t, bVar.f6407b);
        intent.putExtra(an.K, bVar.i);
        com.xiaomi.channel.commonutils.logger.b.m5113a(String.format("[Bcst] notify channel open result. %s,%s,%b,%d", bVar.g, bVar.f6404a, Boolean.valueOf(z), Integer.valueOf(i)));
        a(context, intent, bVar);
    }

    @SuppressLint({"DefaultLocale"})
    public void a(Context context, am.b bVar, int i) {
        if ("5".equalsIgnoreCase(bVar.g)) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.channel_closed");
        intent.setPackage(bVar.f6404a);
        intent.putExtra(an.w, bVar.g);
        intent.putExtra("ext_reason", i);
        intent.putExtra(an.t, bVar.f6407b);
        intent.putExtra(an.K, bVar.i);
        if (bVar.f6398a != null && "9".equals(bVar.g)) {
            try {
                bVar.f6398a.send(Message.obtain(null, 17, intent));
                return;
            } catch (RemoteException unused) {
                bVar.f6398a = null;
                StringBuilder sb = new StringBuilder();
                sb.append("peer may died: ");
                String str = bVar.f6407b;
                sb.append(str.substring(str.lastIndexOf(64)));
                com.xiaomi.channel.commonutils.logger.b.m5113a(sb.toString());
                return;
            }
        }
        com.xiaomi.channel.commonutils.logger.b.m5113a(String.format("[Bcst] notify channel closed. %s,%s,%d", bVar.g, bVar.f6404a, Integer.valueOf(i)));
        a(context, intent, bVar);
    }

    public void a(XMPushService xMPushService, String str, fp fpVar) {
        String str2;
        am.b bVarA = a(fpVar);
        if (bVarA == null) {
            com.xiaomi.channel.commonutils.logger.b.d("error while notify channel closed! channel " + str + " not registered");
            return;
        }
        if ("5".equalsIgnoreCase(str)) {
            this.a.a(xMPushService, fpVar, bVarA);
            return;
        }
        String str3 = bVarA.f6404a;
        if (fpVar instanceof fo) {
            str2 = "com.xiaomi.push.new_msg";
        } else if (fpVar instanceof fn) {
            str2 = "com.xiaomi.push.new_iq";
        } else {
            if (!(fpVar instanceof fr)) {
                com.xiaomi.channel.commonutils.logger.b.d("unknown packet type, drop it");
                return;
            }
            str2 = "com.xiaomi.push.new_pres";
        }
        Intent intent = new Intent();
        intent.setAction(str2);
        intent.setPackage(str3);
        intent.putExtra("ext_chid", str);
        intent.putExtra("ext_packet", fpVar.a());
        intent.putExtra(an.K, bVarA.i);
        intent.putExtra(an.C, bVarA.h);
        com.xiaomi.channel.commonutils.logger.b.m5113a(String.format("[Bcst] notify packet arrival. %s,%s,%s", bVarA.g, bVarA.f6404a, fpVar.j()));
        if ("3".equalsIgnoreCase(str)) {
            intent.putExtra(an.x, fpVar.f5935a);
            intent.putExtra(an.y, System.currentTimeMillis());
        }
        a(xMPushService, intent, bVarA);
    }

    public void a(XMPushService xMPushService, String str, es esVar) throws RemoteException {
        am.b bVarA = a(esVar);
        if (bVarA == null) {
            com.xiaomi.channel.commonutils.logger.b.d("error while notify channel closed! channel " + str + " not registered");
            return;
        }
        if ("5".equalsIgnoreCase(str)) {
            this.a.a(xMPushService, esVar, bVarA);
            return;
        }
        String str2 = bVarA.f6404a;
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.new_msg");
        intent.setPackage(str2);
        intent.putExtra("ext_rcv_timestamp", SystemClock.elapsedRealtime());
        intent.putExtra("ext_chid", str);
        intent.putExtra("ext_raw_packet", esVar.m5460a(bVarA.h));
        intent.putExtra(an.K, bVarA.i);
        intent.putExtra(an.C, bVarA.h);
        if (e.a(esVar)) {
            intent.putExtra("ext_downward_pkt_id", esVar.e());
        }
        if (bVarA.f6398a != null) {
            try {
                bVarA.f6398a.send(Message.obtain(null, 17, intent));
                com.xiaomi.channel.commonutils.logger.b.m5113a("message was sent by messenger for chid=" + str);
                return;
            } catch (RemoteException unused) {
                bVarA.f6398a = null;
                StringBuilder sb = new StringBuilder();
                sb.append("peer may died: ");
                String str3 = bVarA.f6407b;
                sb.append(str3.substring(str3.lastIndexOf(64)));
                com.xiaomi.channel.commonutils.logger.b.m5113a(sb.toString());
            }
        }
        if ("com.xiaomi.xmsf".equals(str2)) {
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m5113a(String.format("[Bcst] notify packet(blob) arrival. %s,%s,%s", bVarA.g, bVarA.f6404a, esVar.e()));
        if (e.a(esVar)) {
            at.a().a(esVar.e(), SystemClock.elapsedRealtime());
        }
        a(xMPushService, intent, bVarA);
    }

    public am.b a(fp fpVar) {
        Collection<am.b> collectionM5759a = am.a().m5759a(fpVar.k());
        if (collectionM5759a.isEmpty()) {
            return null;
        }
        Iterator<am.b> it = collectionM5759a.iterator();
        if (collectionM5759a.size() == 1) {
            return it.next();
        }
        String strM = fpVar.m();
        String strL = fpVar.l();
        while (it.hasNext()) {
            am.b next = it.next();
            if (TextUtils.equals(strM, next.f6407b) || TextUtils.equals(strL, next.f6407b)) {
                return next;
            }
        }
        return null;
    }

    public am.b a(es esVar) {
        Collection<am.b> collectionM5759a = am.a().m5759a(Integer.toString(esVar.a()));
        if (collectionM5759a.isEmpty()) {
            return null;
        }
        Iterator<am.b> it = collectionM5759a.iterator();
        if (collectionM5759a.size() == 1) {
            return it.next();
        }
        String strG = esVar.g();
        while (it.hasNext()) {
            am.b next = it.next();
            if (TextUtils.equals(strG, next.f6407b)) {
                return next;
            }
        }
        return null;
    }

    public void a(Context context, am.b bVar, String str, String str2) {
        if (bVar == null) {
            com.xiaomi.channel.commonutils.logger.b.d("error while notify kick by server!");
            return;
        }
        if ("5".equalsIgnoreCase(bVar.g)) {
            com.xiaomi.channel.commonutils.logger.b.d("mipush kicked by server");
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.kicked");
        intent.setPackage(bVar.f6404a);
        intent.putExtra("ext_kick_type", str);
        intent.putExtra("ext_kick_reason", str2);
        intent.putExtra("ext_chid", bVar.g);
        intent.putExtra(an.t, bVar.f6407b);
        intent.putExtra(an.K, bVar.i);
        com.xiaomi.channel.commonutils.logger.b.m5113a(String.format("[Bcst] notify packet(blob) arrival. %s,%s,%s", bVar.g, bVar.f6404a, str2));
        a(context, intent, bVar);
    }

    private static void a(Context context, Intent intent, am.b bVar) {
        if ("com.xiaomi.xmsf".equals(context.getPackageName())) {
            context.sendBroadcast(intent);
        } else {
            context.sendBroadcast(intent, a(bVar));
        }
    }

    public static String a(am.b bVar) {
        if (!"9".equals(bVar.g)) {
            return bVar.f6404a + ".permission.MIPUSH_RECEIVE";
        }
        return bVar.f6404a + ".permission.MIMC_RECEIVE";
    }
}
