package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import com.xiaomi.push.fj;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public class t {

    /* renamed from: a, reason: collision with other field name */
    private static final Map<String, byte[]> f6480a = new HashMap();
    private static ArrayList<Pair<String, byte[]>> a = new ArrayList<>();

    public static void a(String str, byte[] bArr) {
        Map<String, byte[]> map = f6480a;
        synchronized (map) {
            com.xiaomi.channel.commonutils.logger.b.m5113a("pending registration request. " + str);
            map.put(str, bArr);
        }
    }

    public static void b(String str, byte[] bArr) {
        synchronized (a) {
            a.add(new Pair<>(str, bArr));
            if (a.size() > 50) {
                a.remove(0);
            }
        }
    }

    public static void a(XMPushService xMPushService, boolean z) {
        try {
            Map<String, byte[]> map = f6480a;
            synchronized (map) {
                for (String str : map.keySet()) {
                    com.xiaomi.channel.commonutils.logger.b.m5113a("processing pending registration request. " + str);
                    w.a(xMPushService, str, f6480a.get(str));
                    if (z && !com.xiaomi.push.t.a()) {
                        try {
                            Thread.sleep(200L);
                        } catch (Exception unused) {
                        }
                    }
                }
                f6480a.clear();
            }
        } catch (fj e2) {
            com.xiaomi.channel.commonutils.logger.b.d("fail to deal with pending register request. " + e2);
            xMPushService.a(10, e2);
        }
    }

    public static void a(Context context, int i, String str) {
        Map<String, byte[]> map = f6480a;
        synchronized (map) {
            for (String str2 : map.keySet()) {
                com.xiaomi.channel.commonutils.logger.b.m5113a("notify registration error. " + str2);
                a(context, str2, f6480a.get(str2), i, str);
            }
            f6480a.clear();
        }
    }

    public static void a(XMPushService xMPushService) throws InterruptedException {
        ArrayList<Pair<String, byte[]>> arrayList;
        try {
            synchronized (a) {
                arrayList = a;
                a = new ArrayList<>();
            }
            boolean zA = com.xiaomi.push.t.a();
            Iterator<Pair<String, byte[]>> it = arrayList.iterator();
            while (it.hasNext()) {
                Pair<String, byte[]> next = it.next();
                w.a(xMPushService, (String) next.first, (byte[]) next.second);
                if (!zA) {
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException unused) {
                    }
                }
            }
        } catch (fj e2) {
            com.xiaomi.channel.commonutils.logger.b.d("meet error when process pending message. " + e2);
            xMPushService.a(10, e2);
        }
    }

    public static void a(Context context, String str, byte[] bArr, int i, String str2) {
        Intent intent = new Intent("com.xiaomi.mipush.ERROR");
        intent.setPackage(str);
        intent.putExtra("mipush_payload", bArr);
        intent.putExtra("mipush_error_code", i);
        intent.putExtra("mipush_error_msg", str2);
        context.sendBroadcast(intent, w.a(str));
    }
}
