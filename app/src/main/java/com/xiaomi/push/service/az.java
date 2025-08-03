package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.blink.academy.film.stream.FinderManager;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.gj;
import com.xiaomi.push.gk;
import com.xiaomi.push.gq;
import com.xiaomi.push.hf;
import com.xiaomi.push.hq;
import java.text.SimpleDateFormat;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes2.dex */
public class az {
    private static String a;

    /* renamed from: a, reason: collision with other field name */
    private static SimpleDateFormat f6432a;

    /* renamed from: a, reason: collision with other field name */
    private static AtomicLong f6433a = new AtomicLong(0);

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        f6432a = simpleDateFormat;
        a = simpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
    }

    public static synchronized String a() {
        String str;
        str = f6432a.format(Long.valueOf(System.currentTimeMillis()));
        if (!TextUtils.equals(a, str)) {
            f6433a.set(0L);
            a = str;
        }
        return str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + f6433a.incrementAndGet();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.ArrayList<com.xiaomi.push.hf> a(java.util.List<com.xiaomi.push.gk> r11, java.lang.String r12, java.lang.String r13, int r14) throws java.lang.NumberFormatException {
        /*
            r0 = 0
            if (r11 != 0) goto L9
            java.lang.String r11 = "requests can not be null in TinyDataHelper.transToThriftObj()."
            com.xiaomi.channel.commonutils.logger.b.d(r11)
            return r0
        L9:
            int r1 = r11.size()
            if (r1 != 0) goto L15
            java.lang.String r11 = "requests.length is 0 in TinyDataHelper.transToThriftObj()."
            com.xiaomi.channel.commonutils.logger.b.d(r11)
            return r0
        L15:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            com.xiaomi.push.gj r2 = new com.xiaomi.push.gj
            r2.<init>()
            r3 = 0
            r4 = r3
            r5 = r4
        L22:
            int r6 = r11.size()
            if (r4 >= r6) goto Lad
            java.lang.Object r6 = r11.get(r4)
            com.xiaomi.push.gk r6 = (com.xiaomi.push.gk) r6
            if (r6 != 0) goto L32
            goto La9
        L32:
            java.util.Map r7 = r6.m5528a()
            if (r7 == 0) goto L71
            java.util.Map r7 = r6.m5528a()
            java.lang.String r8 = "item_size"
            boolean r7 = r7.containsKey(r8)
            if (r7 == 0) goto L71
            java.util.Map r7 = r6.m5528a()
            java.lang.Object r7 = r7.get(r8)
            java.lang.String r7 = (java.lang.String) r7
            boolean r9 = android.text.TextUtils.isEmpty(r7)
            if (r9 != 0) goto L59
            int r7 = java.lang.Integer.parseInt(r7)     // Catch: java.lang.Exception -> L59
            goto L5a
        L59:
            r7 = r3
        L5a:
            java.util.Map r9 = r6.m5528a()
            int r9 = r9.size()
            r10 = 1
            if (r9 != r10) goto L69
            r6.a(r0)
            goto L72
        L69:
            java.util.Map r9 = r6.m5528a()
            r9.remove(r8)
            goto L72
        L71:
            r7 = r3
        L72:
            if (r7 > 0) goto L79
            byte[] r7 = com.xiaomi.push.hq.a(r6)
            int r7 = r7.length
        L79:
            if (r7 <= r14) goto L94
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "TinyData is too big, ignore upload request item:"
            r7.append(r8)
            java.lang.String r6 = r6.d()
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            com.xiaomi.channel.commonutils.logger.b.d(r6)
            goto La9
        L94:
            int r8 = r5 + r7
            if (r8 <= r14) goto La5
            com.xiaomi.push.hf r2 = a(r12, r13, r2)
            r1.add(r2)
            com.xiaomi.push.gj r2 = new com.xiaomi.push.gj
            r2.<init>()
            r5 = r3
        La5:
            r2.a(r6)
            int r5 = r5 + r7
        La9:
            int r4 = r4 + 1
            goto L22
        Lad:
            int r11 = r2.a()
            if (r11 == 0) goto Lba
            com.xiaomi.push.hf r11 = a(r12, r13, r2)
            r1.add(r11)
        Lba:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.az.a(java.util.List, java.lang.String, java.lang.String, int):java.util.ArrayList");
    }

    private static hf a(String str, String str2, gj gjVar) {
        return new hf(FinderManager.MACHINE_NOT_VALID, false).d(str).b(str2).a(com.xiaomi.push.x.a(hq.a(gjVar))).c(gq.UploadTinyData.f6003a);
    }

    public static boolean a(gk gkVar, boolean z) {
        if (gkVar == null) {
            com.xiaomi.channel.commonutils.logger.b.m5113a("item is null, verfiy ClientUploadDataItem failed.");
            return true;
        }
        if (!z && TextUtils.isEmpty(gkVar.f5975a)) {
            com.xiaomi.channel.commonutils.logger.b.m5113a("item.channel is null or empty, verfiy ClientUploadDataItem failed.");
            return true;
        }
        if (TextUtils.isEmpty(gkVar.f5982d)) {
            com.xiaomi.channel.commonutils.logger.b.m5113a("item.category is null or empty, verfiy ClientUploadDataItem failed.");
            return true;
        }
        if (TextUtils.isEmpty(gkVar.f5981c)) {
            com.xiaomi.channel.commonutils.logger.b.m5113a("item.name is null or empty, verfiy ClientUploadDataItem failed.");
            return true;
        }
        if (!com.xiaomi.push.bc.m5242a(gkVar.f5982d)) {
            com.xiaomi.channel.commonutils.logger.b.m5113a("item.category can only contain ascii char, verfiy ClientUploadDataItem failed.");
            return true;
        }
        if (!com.xiaomi.push.bc.m5242a(gkVar.f5981c)) {
            com.xiaomi.channel.commonutils.logger.b.m5113a("item.name can only contain ascii char, verfiy ClientUploadDataItem failed.");
            return true;
        }
        String str = gkVar.f5980b;
        if (str == null || str.length() <= 30720) {
            return false;
        }
        com.xiaomi.channel.commonutils.logger.b.m5113a("item.data is too large(" + gkVar.f5980b.length() + "), max size for data is 30720 , verfiy ClientUploadDataItem failed.");
        return true;
    }

    public static void a(Context context, String str, String str2, long j, String str3) {
        gk gkVar = new gk();
        gkVar.d(str);
        gkVar.c(str2);
        gkVar.a(j);
        gkVar.b(str3);
        gkVar.a("push_sdk_channel");
        gkVar.g(context.getPackageName());
        gkVar.e(context.getPackageName());
        gkVar.a(true);
        gkVar.b(System.currentTimeMillis());
        gkVar.f(a());
        ba.a(context, gkVar);
    }

    public static boolean a(String str) {
        return !com.xiaomi.push.s.m5706b() || Constants.HYBRID_PACKAGE_NAME.equals(str);
    }
}
