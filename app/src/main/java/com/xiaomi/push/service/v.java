package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.hc;
import com.xiaomi.push.hf;
import java.util.Map;

/* loaded from: classes2.dex */
public class v {
    private static a a;

    /* renamed from: a, reason: collision with other field name */
    private static b f6491a;

    public interface a {
        Map<String, String> a(Context context, hc hcVar);

        /* renamed from: a, reason: collision with other method in class */
        void m5816a(Context context, hc hcVar);

        void a(Context context, hc hcVar, hf hfVar);

        void a(String str, byte[] bArr, long j);

        boolean a(Context context, hc hcVar, boolean z);
    }

    public interface b {
        void a(hc hcVar);

        void a(String str);

        /* renamed from: a, reason: collision with other method in class */
        boolean m5817a(hc hcVar);
    }

    public static void a(Context context, hc hcVar, hf hfVar) {
        a aVar = a;
        if (aVar == null) {
            com.xiaomi.channel.commonutils.logger.b.d("The Listener of EventProcessor must be set. Please check extension plugin initialization.");
        } else {
            aVar.a(context, hcVar, hfVar);
        }
    }

    public static boolean a(Context context, hc hcVar, boolean z) {
        a aVar = a;
        if (aVar != null && hcVar != null) {
            return aVar.a(context, hcVar, z);
        }
        com.xiaomi.channel.commonutils.logger.b.m5113a("pepa judement listener or container is null");
        return false;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static void m5814a(Context context, hc hcVar) {
        a aVar = a;
        if (aVar != null && hcVar != null) {
            aVar.m5816a(context, hcVar);
        } else {
            com.xiaomi.channel.commonutils.logger.b.m5113a("handle msg wrong");
        }
    }

    public static void a(String str, byte[] bArr, long j) {
        a aVar = a;
        if (aVar != null && bArr != null) {
            aVar.a(str, bArr, j);
        } else {
            com.xiaomi.channel.commonutils.logger.b.m5113a("handle send msg wrong");
        }
    }

    public static Map<String, String> a(Context context, hc hcVar) {
        a aVar = a;
        if (aVar != null && hcVar != null) {
            return aVar.a(context, hcVar);
        }
        com.xiaomi.channel.commonutils.logger.b.m5113a("pepa listener or container is null");
        return null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m5815a(hc hcVar) {
        b bVar = f6491a;
        if (bVar != null && hcVar != null) {
            return bVar.m5817a(hcVar);
        }
        com.xiaomi.channel.commonutils.logger.b.m5113a("pepa handleReceiveMessage is null");
        return false;
    }

    public static void a(hc hcVar) {
        b bVar = f6491a;
        if (bVar != null && hcVar != null) {
            bVar.a(hcVar);
        } else {
            com.xiaomi.channel.commonutils.logger.b.m5113a("pepa clearMessage is null");
        }
    }

    public static void a(String str) {
        b bVar = f6491a;
        if (bVar != null && str != null) {
            bVar.a(str);
        } else {
            com.xiaomi.channel.commonutils.logger.b.m5113a("pepa clearMessage is null");
        }
    }
}
