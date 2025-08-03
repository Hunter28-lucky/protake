package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.az;
import com.xiaomi.push.gg;
import com.xiaomi.push.gv;
import com.xiaomi.push.gw;
import com.xiaomi.push.gx;
import com.xiaomi.push.hb;
import com.xiaomi.push.hc;
import com.xiaomi.push.hf;
import com.xiaomi.push.hh;
import com.xiaomi.push.hi;
import com.xiaomi.push.hj;
import com.xiaomi.push.hl;
import com.xiaomi.push.hn;
import com.xiaomi.push.hp;
import com.xiaomi.push.hq;
import com.xiaomi.push.hr;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class r {

    /* renamed from: com.xiaomi.mipush.sdk.r$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[gg.values().length];
            a = iArr;
            try {
                iArr[gg.Registration.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[gg.UnRegistration.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[gg.Subscription.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[gg.UnSubscription.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[gg.SendMessage.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[gg.AckMessage.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[gg.SetConfig.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[gg.ReportFeedback.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[gg.Notification.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[gg.Command.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public static <T extends hr<T, ?>> hc a(Context context, T t, gg ggVar) {
        return a(context, t, ggVar, !ggVar.equals(gg.Registration), context.getPackageName(), b.m5140a(context).m5141a());
    }

    public static <T extends hr<T, ?>> hc b(Context context, T t, gg ggVar, boolean z, String str, String str2) {
        return a(context, t, ggVar, z, str, str2, false);
    }

    public static <T extends hr<T, ?>> hc a(Context context, T t, gg ggVar, boolean z, String str, String str2) {
        return a(context, t, ggVar, z, str, str2, true);
    }

    public static <T extends hr<T, ?>> hc a(Context context, T t, gg ggVar, boolean z, String str, String str2, boolean z2) {
        byte[] bArrA = hq.a(t);
        if (bArrA == null) {
            com.xiaomi.channel.commonutils.logger.b.m5113a("invoke convertThriftObjectToBytes method, return null.");
            return null;
        }
        hc hcVar = new hc();
        if (z) {
            String strD = b.m5140a(context).d();
            if (TextUtils.isEmpty(strD)) {
                com.xiaomi.channel.commonutils.logger.b.m5113a("regSecret is empty, return null");
                return null;
            }
            try {
                bArrA = com.xiaomi.push.h.b(az.m5226a(strD), bArrA);
            } catch (Exception unused) {
                com.xiaomi.channel.commonutils.logger.b.d("encryption error. ");
            }
        }
        gv gvVar = new gv();
        gvVar.f6051a = 5L;
        gvVar.f6052a = "fakeid";
        hcVar.a(gvVar);
        hcVar.a(ByteBuffer.wrap(bArrA));
        hcVar.a(ggVar);
        hcVar.b(z2);
        hcVar.b(str);
        hcVar.a(z);
        hcVar.a(str2);
        return hcVar;
    }

    public static hr a(Context context, hc hcVar) {
        byte[] bArrM5599a;
        if (hcVar.m5601b()) {
            byte[] bArrA = f.a(context, hcVar, d.ASSEMBLE_PUSH_FCM);
            if (bArrA == null) {
                bArrA = az.m5226a(b.m5140a(context).d());
            }
            try {
                bArrM5599a = com.xiaomi.push.h.a(bArrA, hcVar.m5599a());
            } catch (Exception e2) {
                throw new l("the aes decrypt failed.", e2);
            }
        } else {
            bArrM5599a = hcVar.m5599a();
        }
        hr hrVarA = a(hcVar.a(), hcVar.f6131b);
        if (hrVarA != null) {
            hq.a(hrVarA, bArrM5599a);
        }
        return hrVarA;
    }

    private static hr a(gg ggVar, boolean z) {
        switch (AnonymousClass1.a[ggVar.ordinal()]) {
            case 1:
                return new hh();
            case 2:
                return new hn();
            case 3:
                return new hl();
            case 4:
                return new hp();
            case 5:
                return new hj();
            case 6:
                return new gw();
            case 7:
                return new hb();
            case 8:
                return new hi();
            case 9:
                if (z) {
                    return new hf();
                }
                gx gxVar = new gx();
                gxVar.a(true);
                return gxVar;
            case 10:
                return new hb();
            default:
                return null;
        }
    }
}
