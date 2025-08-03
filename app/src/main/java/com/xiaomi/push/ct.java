package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: classes2.dex */
public class ct {

    /* renamed from: com.xiaomi.push.ct$1, reason: invalid class name */
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
                a[gg.MultiConnectionBroadcast.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[gg.MultiConnectionResult.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[gg.Notification.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[gg.Command.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    public static int a(hr hrVar, gg ggVar) {
        int iA;
        switch (AnonymousClass1.a[ggVar.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                return dt.a(ggVar.a());
            case 11:
                iA = dt.a(ggVar.a());
                if (hrVar != null) {
                    try {
                        if (hrVar instanceof gx) {
                            String str = ((gx) hrVar).f6088d;
                            if (!TextUtils.isEmpty(str) && dt.a(dt.m5421a(str)) != -1) {
                                iA = dt.a(dt.m5421a(str));
                                break;
                            }
                        } else if (hrVar instanceof hf) {
                            String str2 = ((hf) hrVar).f6147d;
                            if (!TextUtils.isEmpty(str2)) {
                                if (dt.a(dt.m5421a(str2)) != -1) {
                                    iA = dt.a(dt.m5421a(str2));
                                }
                                if (gq.UploadTinyData.equals(dt.m5421a(str2))) {
                                    return -1;
                                }
                            }
                        }
                    } catch (Exception unused) {
                        com.xiaomi.channel.commonutils.logger.b.d("PERF_ERROR : parse Notification type error");
                        return iA;
                    }
                }
                break;
            case 12:
                iA = dt.a(ggVar.a());
                if (hrVar != null) {
                    try {
                        if (hrVar instanceof hb) {
                            String strB = ((hb) hrVar).b();
                            if (!TextUtils.isEmpty(strB) && ee.a(strB) != -1) {
                                iA = ee.a(strB);
                                break;
                            }
                        } else if (hrVar instanceof ha) {
                            String strA = ((ha) hrVar).a();
                            if (!TextUtils.isEmpty(strA) && ee.a(strA) != -1) {
                                return ee.a(strA);
                            }
                        }
                    } catch (Exception unused2) {
                        com.xiaomi.channel.commonutils.logger.b.d("PERF_ERROR : parse Command type error");
                        break;
                    }
                }
                break;
            default:
                return -1;
        }
        return iA;
    }

    public static int a(Context context, int i) {
        int iA = ga.a(context);
        if (-1 == iA) {
            return -1;
        }
        return (i * (iA == 0 ? 13 : 11)) / 10;
    }

    public static int a(gg ggVar) {
        return dt.a(ggVar.a());
    }

    public static void a(String str, Context context, byte[] bArr) {
        if (context == null || bArr == null || bArr.length <= 0) {
            return;
        }
        hc hcVar = new hc();
        try {
            hq.a(hcVar, bArr);
            a(str, context, hcVar, bArr.length);
        } catch (hv unused) {
            com.xiaomi.channel.commonutils.logger.b.m5113a("fail to convert bytes to container");
        }
    }

    public static void a(String str, Context context, hc hcVar, int i) {
        gg ggVarA;
        if (context == null || hcVar == null || (ggVarA = hcVar.a()) == null) {
            return;
        }
        int iA = a(ggVarA);
        if (i <= 0) {
            byte[] bArrA = hq.a(hcVar);
            i = bArrA != null ? bArrA.length : 0;
        }
        a(str, context, iA, i);
    }

    public static void a(String str, Context context, int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        int iA = a(context, i2);
        if (i != dt.a(gq.UploadTinyData)) {
            du.a(context.getApplicationContext()).a(str, i, 1L, iA);
        }
    }

    public static void a(String str, Context context, hr hrVar, gg ggVar, int i) {
        a(str, context, a(hrVar, ggVar), i);
    }
}
