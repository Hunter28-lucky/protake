package com.xiaomi.push.service;

import android.util.Pair;
import com.xiaomi.push.gm;
import com.xiaomi.push.gn;
import com.xiaomi.push.gp;
import com.xiaomi.push.gr;
import com.xiaomi.push.hd;
import com.xiaomi.push.he;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class ai {

    /* renamed from: com.xiaomi.push.service.ai$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[gn.values().length];
            b = iArr;
            try {
                iArr[gn.INT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[gn.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[gn.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[gn.BOOLEAN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[gm.values().length];
            a = iArr2;
            try {
                iArr2[gm.MISC_CONFIG.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[gm.PLUGIN_CONFIG.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static void a(ah ahVar, he heVar) {
        com.xiaomi.channel.commonutils.logger.b.b("OnlineConfigHelper", "-->updateNormalConfigs(): onlineConfig=", ahVar, ", configMessage=", heVar);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (gp gpVar : heVar.a()) {
            arrayList.add(new Pair<>(gpVar.m5540a(), Integer.valueOf(gpVar.a())));
            List<Pair<Integer, Object>> listA = a(gpVar.f6001a, false);
            if (!com.xiaomi.push.aa.a(listA)) {
                arrayList2.addAll(listA);
            }
        }
        ahVar.a(arrayList, arrayList2);
        ahVar.b();
    }

    public static void a(ah ahVar, hd hdVar) {
        com.xiaomi.channel.commonutils.logger.b.b("OnlineConfigHelper", "-->updateCustomConfigs(): onlineConfig=", ahVar, ", configMessage=", hdVar);
        ahVar.a(a(hdVar.a(), true));
        ahVar.b();
    }

    public static int a(ah ahVar, gm gmVar) {
        return ahVar.a(gmVar, AnonymousClass1.a[gmVar.ordinal()] != 1 ? 0 : 1);
    }

    private static List<Pair<Integer, Object>> a(List<gr> list, boolean z) {
        Pair pair;
        if (com.xiaomi.push.aa.a(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (gr grVar : list) {
            int iA = grVar.a();
            gn gnVarA = gn.a(grVar.b());
            if (gnVarA != null) {
                if (z && grVar.f6009a) {
                    arrayList.add(new Pair(Integer.valueOf(iA), null));
                } else {
                    int i = AnonymousClass1.b[gnVarA.ordinal()];
                    if (i == 1) {
                        pair = new Pair(Integer.valueOf(iA), Integer.valueOf(grVar.c()));
                    } else if (i == 2) {
                        pair = new Pair(Integer.valueOf(iA), Long.valueOf(grVar.m5544a()));
                    } else if (i != 3) {
                        pair = i != 4 ? null : new Pair(Integer.valueOf(iA), Boolean.valueOf(grVar.g()));
                    } else {
                        pair = new Pair(Integer.valueOf(iA), grVar.m5545a());
                    }
                    arrayList.add(pair);
                }
            }
        }
        return arrayList;
    }
}
