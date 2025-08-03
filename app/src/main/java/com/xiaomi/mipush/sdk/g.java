package com.xiaomi.mipush.sdk;

import com.xiaomi.push.gl;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class g {
    private static HashMap<d, a> a = new HashMap<>();

    /* renamed from: com.xiaomi.mipush.sdk.g$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[d.values().length];
            a = iArr;
            try {
                iArr[d.ASSEMBLE_PUSH_HUAWEI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[d.ASSEMBLE_PUSH_FCM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[d.ASSEMBLE_PUSH_COS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[d.ASSEMBLE_PUSH_FTOS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static class a {
        public String a;
        public String b;

        public a(String str, String str2) {
            this.a = str;
            this.b = str2;
        }
    }

    static {
        a(d.ASSEMBLE_PUSH_HUAWEI, new a("com.xiaomi.assemble.control.HmsPushManager", "newInstance"));
        a(d.ASSEMBLE_PUSH_FCM, new a("com.xiaomi.assemble.control.FCMPushManager", "newInstance"));
        a(d.ASSEMBLE_PUSH_COS, new a("com.xiaomi.assemble.control.COSPushManager", "newInstance"));
        a(d.ASSEMBLE_PUSH_FTOS, new a("com.xiaomi.assemble.control.FTOSPushManager", "newInstance"));
    }

    private static void a(d dVar, a aVar) {
        if (aVar != null) {
            a.put(dVar, aVar);
        }
    }

    public static a a(d dVar) {
        return a.get(dVar);
    }

    /* renamed from: a, reason: collision with other method in class */
    public static gl m5167a(d dVar) {
        return gl.AggregatePushSwitch;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static v m5166a(d dVar) {
        int i = AnonymousClass1.a[dVar.ordinal()];
        if (i == 1) {
            return v.UPLOAD_HUAWEI_TOKEN;
        }
        if (i == 2) {
            return v.UPLOAD_FCM_TOKEN;
        }
        if (i == 3) {
            return v.UPLOAD_COS_TOKEN;
        }
        if (i != 4) {
            return null;
        }
        return v.UPLOAD_FTOS_TOKEN;
    }
}
