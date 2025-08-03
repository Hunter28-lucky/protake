package com.mob.commons.cc;

import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.PackageManager;
import com.mob.commons.cc.l;
import com.mob.commons.cc.v;
import com.mob.tools.MobHandlerThread;
import com.mob.tools.network.NetCommunicator;
import com.mob.tools.network.NetworkHelper;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/* loaded from: classes2.dex */
public class a {
    private static final p a = new p();
    private static final i b = new i();
    private static volatile l c;
    private static volatile l d;

    static {
        try {
            c = new l(new l.a() { // from class: com.mob.commons.cc.a.1
                @Override // com.mob.commons.cc.l.a
                public Object a(String str, ArrayList<Object> arrayList) {
                    try {
                        if (a.d != null) {
                            return a.d.a(str, arrayList);
                        }
                        return null;
                    } catch (Throwable unused) {
                        return null;
                    }
                }
            });
            d = new l(new l.a() { // from class: com.mob.commons.cc.a.2
                @Override // com.mob.commons.cc.l.a
                public Object a(String str, ArrayList<Object> arrayList) {
                    return str + "" + arrayList;
                }
            });
            c.a("tt", null);
        } catch (Throwable unused) {
        }
    }

    public static int a() {
        return v.a();
    }

    public static void a(Context context, byte[] bArr, String str, Method method) throws Throwable {
        a(v.a(bArr), context, str, method);
    }

    public static void a(Context context, String str, String str2, Method method) throws Throwable {
        a(v.a(str), context, str2, method);
    }

    public static void a(Context context, String str, String str2, HashMap<String, Object> map, HashMap<String, Object> map2) throws Throwable {
        v.c cVarA = v.a(str);
        cVarA.a("ss_dhMap", map).a("ss_dataMaps", map2);
        a(cVarA, context, str2, (Method) null);
    }

    public static LinkedList<Object> a(Object obj, Object... objArr) throws Throwable {
        return ((x) obj).b(objArr);
    }

    private static void a(v.c cVar, Context context, String str, Method method) throws Throwable {
        cVar.a(com.mob.commons.o.a("012%flSei)dhdfWdLdeecdkeh?id"), i.class).a("MNT", c.class).a("MSPH", f.class).a("SBHandlerThread", MobHandlerThread.class).a("SBBroadcastReceiver", h.class).a("SBContentResolver", k.class).a("SBServiceConnection", n.class).a("SBContentObserver", j.class).a("SBNetworkCallback", m.class).a(com.mob.commons.o.a("009Kehfjhddfdk=hVed i!dh"), l.class).a("MNC", NetCommunicator.class).a(com.mob.commons.o.a("004Pgiefeifl"), NetworkHelper.NetworkTimeOut.class).a(h.class, h.class).a(j.class, j.class).a(n.class, o.class).a(m.class, m.class).a(p.class, p.class).a(i.class, i.class).a(c.class, c.class).a(f.class, g.class).a(Context.class, b.class).a(PackageManager.class, e.class).a(NotificationManager.class, d.class).a("ss_opSet", b).a("ss_suls", a).a(com.mob.commons.o.a("015LfgfgdddgecdkDdiUdlYd0ghdfdhdf]l"), context).a(com.mob.commons.o.a("014Pfgfgddfg?dFdfdhFdAghdfdhdf1lOfg"), str).a(com.mob.commons.o.a("012Yfgfgddfg4dFdfdh6d:eideXli"), Long.valueOf(System.currentTimeMillis())).a(com.mob.commons.o.a("006Wfgfgdd%lhe"), method).a(com.mob.commons.o.a("016ZdgecQllVecdkdf e7elfg6hYdjeldgFh?dg"));
        cVar.a();
    }
}
