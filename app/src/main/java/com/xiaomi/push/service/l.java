package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Base64;
import com.xiaomi.push.hc;
import com.xiaomi.push.hh;
import com.xiaomi.push.hq;
import com.xiaomi.push.hv;

/* loaded from: classes2.dex */
public class l {
    public static void a(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra("ext_fcm_container_buffer");
        String stringExtra2 = intent.getStringExtra("mipush_app_package");
        if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(stringExtra2)) {
            return;
        }
        try {
            byte[] bArrB = b(Base64.decode(stringExtra, 2), context.getSharedPreferences("mipush_apps_scrt", 0).getString(stringExtra2, null));
            if (bArrB != null) {
                x.m5819a(context, u.a(bArrB), bArrB);
            } else {
                com.xiaomi.channel.commonutils.logger.b.m5113a("notify fcm notification error ：dencrypt failed");
            }
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a("notify fcm notification error ", th);
        }
    }

    public static byte[] b(byte[] bArr, String str) {
        if (TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.m5113a("secret is empty, return null");
            return null;
        }
        try {
            return com.xiaomi.push.h.a(com.xiaomi.push.az.m5226a(str), bArr);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a("dencryption error. ", e2);
            return null;
        }
    }

    public static byte[] a(byte[] bArr, String str) {
        if (TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.m5113a("secret is empty, return null");
            return null;
        }
        try {
            return com.xiaomi.push.h.b(com.xiaomi.push.az.m5226a(str), bArr);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a("encryption error. ", e2);
            return null;
        }
    }

    public static hh a(hc hcVar) {
        byte[] bArrM5599a = hcVar.m5599a();
        hh hhVar = new hh();
        try {
            hq.a(hhVar, bArrM5599a);
            return hhVar;
        } catch (hv unused) {
            return null;
        }
    }

    public static void a(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        context.getSharedPreferences("mipush_apps_scrt", 0).edit().putString(str, str2).apply();
    }
}
