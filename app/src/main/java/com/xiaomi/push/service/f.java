package com.xiaomi.push.service;

import android.app.NotificationChannel;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.service.ag;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class f {
    private static final SparseArray<ag.a<String, String, String>> a;

    /* renamed from: a, reason: collision with other field name */
    private static final int[] f6448a = {1, 2, 4, 8, 16};
    private static final SparseArray<Integer> b;

    static {
        int i = 5;
        a = new SparseArray<ag.a<String, String, String>>(i) { // from class: com.xiaomi.push.service.f.1
            {
                put(1, ag.b);
                put(2, ag.c);
                put(4, ag.d);
                put(8, ag.f);
                put(16, ag.f17899e);
            }
        };
        b = new SparseArray<Integer>(i) { // from class: com.xiaomi.push.service.f.2
            {
                put(1, 32);
                put(2, 16);
                put(4, 8);
                put(8, 4);
                put(16, 2);
            }
        };
    }

    public static int a(String str, String str2) {
        int i = m5782a(str, str2, 8) ? 8 : 0;
        if (m5782a(str, str2, 16)) {
            i |= 16;
        }
        if (m5782a(str, str2, 1)) {
            i |= 1;
        }
        if (m5782a(str, str2, 2)) {
            i |= 2;
        }
        return m5782a(str, str2, 4) ? i | 4 : i;
    }

    private static boolean a(int i, int i2) {
        return i >= 4 || (i2 & 2) > 0 || (i2 & 1) > 0 || (i2 & 8) > 0 || (i2 & 16) > 0;
    }

    public static void a(Context context, String str, String str2, int i, String str3, boolean z, int i2) {
        if (com.xiaomi.push.j.m5690a(context) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            int iA = com.xiaomi.push.t.a(str3, 0);
            boolean zA = a(i, iA);
            if (z) {
                a(str, str2, iA, i2);
                if (zA) {
                    synchronized (f.class) {
                        a(a(context), iA, str2);
                    }
                    return;
                }
                return;
            }
            synchronized (f.class) {
                SharedPreferences sharedPreferencesA = a(context);
                if (zA || sharedPreferencesA.contains(str2)) {
                    a(sharedPreferencesA, iA, str, str2, i2);
                    if (zA) {
                        a(sharedPreferencesA, iA, str2);
                    } else {
                        a(sharedPreferencesA, str2);
                    }
                }
            }
            return;
        }
        if (com.xiaomi.push.j.m5690a(context)) {
            com.xiaomi.channel.commonutils.logger.b.m5113a("ChannelPC: can`t setup permission with permissionCode:" + String.valueOf(str3) + " channelId:" + String.valueOf(str2) + " targetPkg:" + str);
        }
    }

    public static void a(Context context, String str) {
        List<NotificationChannel> listM5751a;
        if (!com.xiaomi.push.j.m5690a(context) || TextUtils.isEmpty(str) || (listM5751a = af.a(context, str).m5751a()) == null) {
            return;
        }
        synchronized (f.class) {
            SharedPreferences sharedPreferencesA = a(context);
            ArrayList arrayList = new ArrayList();
            Iterator<NotificationChannel> it = listM5751a.iterator();
            while (it.hasNext()) {
                String str2 = (String) com.xiaomi.push.ax.a(it.next(), "mId");
                if (!TextUtils.isEmpty(str2) && sharedPreferencesA.contains(str2)) {
                    arrayList.add(str2);
                }
            }
            if (arrayList.size() > 0) {
                a(sharedPreferencesA, arrayList);
            }
        }
    }

    public static void a(String str, String str2, int i, int i2) {
        for (int i3 : f6448a) {
            if ((b.get(i3).intValue() & i2) == 0) {
                a(str, str2, i3, (i & i3) > 0);
            } else {
                com.xiaomi.channel.commonutils.logger.b.m5113a("ChannelPermissions.grantPermission:" + str + Constants.COLON_SEPARATOR + str2 + ": <" + i3 + "> :stoped by userLock");
            }
        }
    }

    private static void a(String str, String str2, int i, boolean z) {
        com.xiaomi.channel.commonutils.logger.b.m5113a("ChannelPermissions.grantPermission:" + str + Constants.COLON_SEPARATOR + str2 + ": <" + i + "=" + z + "> :" + ag.a(com.xiaomi.push.s.m5702a(), str, str2, a.get(i), z));
    }

    public static int a(String str, String str2, int i) {
        return ag.a(com.xiaomi.push.s.m5702a(), str, str2, a.get(i));
    }

    /* renamed from: a, reason: collision with other method in class */
    public static Bundle m5781a(String str, String str2) {
        return ag.a(com.xiaomi.push.s.m5702a(), str, str2);
    }

    /* renamed from: a, reason: collision with other method in class */
    private static boolean m5782a(String str, String str2, int i) {
        boolean z = ag.a(com.xiaomi.push.s.m5702a(), str, str2, a.get(i)) == 1;
        com.xiaomi.channel.commonutils.logger.b.m5113a("ChannelPermissions.checkPermission:" + str + Constants.COLON_SEPARATOR + str2 + ": <" + i + "=" + z + ">");
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x008d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(android.content.Context r5, java.lang.String r6, android.app.NotificationChannel r7) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 0
            r2 = 26
            if (r0 < r2) goto Laa
            if (r5 == 0) goto Laa
            boolean r5 = android.text.TextUtils.isEmpty(r6)
            if (r5 != 0) goto Laa
            if (r7 == 0) goto Laa
            int r5 = r7.getImportance()
            r0 = 1
            if (r5 == 0) goto L1a
            r5 = r0
            goto L1b
        L1a:
            r5 = 2
        L1b:
            r5 = r5 | r1
            boolean r1 = com.xiaomi.push.service.ag.a()
            r2 = 16
            r3 = 4
            r4 = 8
            if (r1 == 0) goto L69
            java.lang.String r0 = r7.getId()
            android.os.Bundle r6 = m5781a(r6, r0)
            com.xiaomi.push.service.ag$a<java.lang.String, java.lang.String, java.lang.String> r0 = com.xiaomi.push.service.ag.f
            T r1 = r0.c
            java.lang.String r1 = (java.lang.String) r1
            boolean r1 = r6.containsKey(r1)
            if (r1 == 0) goto L4e
            T r0 = r0.c
            java.lang.String r0 = (java.lang.String) r0
            boolean r0 = r6.getBoolean(r0)
            if (r0 == 0) goto L4c
            int r0 = r7.getImportance()
            if (r0 < r3) goto L4c
            goto L4d
        L4c:
            r3 = r4
        L4d:
            r5 = r5 | r3
        L4e:
            com.xiaomi.push.service.ag$a<java.lang.String, java.lang.String, java.lang.String> r0 = com.xiaomi.push.service.ag.f17899e
            T r1 = r0.c
            java.lang.String r1 = (java.lang.String) r1
            boolean r1 = r6.containsKey(r1)
            if (r1 == 0) goto L91
            T r0 = r0.c
            java.lang.String r0 = (java.lang.String) r0
            boolean r6 = r6.getBoolean(r0)
            if (r6 == 0) goto L65
            goto L67
        L65:
            r2 = 32
        L67:
            r5 = r5 | r2
            goto L91
        L69:
            java.lang.String r1 = r7.getId()
            int r1 = a(r6, r1, r4)
            if (r1 != r0) goto L7c
            int r1 = r7.getImportance()
            if (r1 < r3) goto L7e
            r5 = r5 | 4
            goto L80
        L7c:
            if (r1 != 0) goto L80
        L7e:
            r5 = r5 | 8
        L80:
            java.lang.String r1 = r7.getId()
            int r6 = a(r6, r1, r2)
            if (r6 != r0) goto L8d
            r5 = r5 | 16
            goto L91
        L8d:
            if (r6 != 0) goto L91
            r5 = r5 | 32
        L91:
            android.net.Uri r6 = r7.getSound()
            if (r6 == 0) goto L9a
            r5 = r5 | 64
            goto L9c
        L9a:
            r5 = r5 | 128(0x80, float:1.8E-43)
        L9c:
            boolean r6 = r7.shouldVibrate()
            if (r6 == 0) goto La5
            r6 = 256(0x100, float:3.59E-43)
            goto La7
        La5:
            r6 = 512(0x200, float:7.17E-43)
        La7:
            r1 = r5 | r6
            goto Laf
        Laa:
            java.lang.String r5 = "context|packageName|channel must not be null "
            com.xiaomi.channel.commonutils.logger.b.m5113a(r5)
        Laf:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.f.a(android.content.Context, java.lang.String, android.app.NotificationChannel):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(android.content.Context r3, java.lang.String r4, java.lang.String r5) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 0
            r2 = 26
            if (r0 < r2) goto L67
            if (r3 == 0) goto L67
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 != 0) goto L67
            com.xiaomi.push.service.af r3 = com.xiaomi.push.service.af.a(r3, r4)
            if (r3 == 0) goto L61
            java.lang.String r5 = r3.m5750a(r5)
            android.app.NotificationChannel r3 = r3.m5747a(r5)
            if (r3 == 0) goto L5b
            int r5 = r3.getImportance()
            r0 = 1
            if (r5 == 0) goto L28
            r5 = r0
            goto L29
        L28:
            r5 = 2
        L29:
            r5 = r5 | r1
            java.lang.String r1 = r3.getId()
            r2 = 8
            int r1 = a(r4, r1, r2)
            if (r1 != r0) goto L40
            int r1 = r3.getImportance()
            r2 = 4
            if (r1 < r2) goto L42
            r5 = r5 | 4
            goto L44
        L40:
            if (r1 != 0) goto L44
        L42:
            r5 = r5 | 8
        L44:
            java.lang.String r3 = r3.getId()
            r1 = 16
            int r3 = a(r4, r3, r1)
            if (r3 != r0) goto L54
            r3 = r5 | 16
        L52:
            r1 = r3
            goto L6c
        L54:
            if (r3 != 0) goto L59
            r3 = r5 | 32
            goto L52
        L59:
            r1 = r5
            goto L6c
        L5b:
            java.lang.String r3 = "Channel must not be null"
            com.xiaomi.channel.commonutils.logger.b.m5113a(r3)
            goto L6c
        L61:
            java.lang.String r3 = "create NMHelper error"
            com.xiaomi.channel.commonutils.logger.b.m5113a(r3)
            goto L6c
        L67:
            java.lang.String r3 = "Must greater than or equal android O and context|packageName not be null"
            com.xiaomi.channel.commonutils.logger.b.m5113a(r3)
        L6c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.f.a(android.content.Context, java.lang.String, java.lang.String):int");
    }

    private static void a(SharedPreferences sharedPreferences, int i, String str, String str2, int i2) {
        if (sharedPreferences.getInt(str2, 0) != i) {
            a(str, str2, i, i2);
        }
    }

    private static void a(SharedPreferences sharedPreferences, int i, String str) {
        sharedPreferences.edit().putInt(str, i).commit();
    }

    private static void a(SharedPreferences sharedPreferences, String str) {
        a(sharedPreferences, new ArrayList<String>(str) { // from class: com.xiaomi.push.service.f.3
            public final /* synthetic */ String a;

            {
                this.a = str;
                add(str);
            }
        });
    }

    private static void a(SharedPreferences sharedPreferences, List<String> list) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            editorEdit.remove(it.next());
        }
        editorEdit.commit();
    }

    private static SharedPreferences a(Context context) {
        return context.getSharedPreferences("ch_permission_cache_file", 0);
    }
}
