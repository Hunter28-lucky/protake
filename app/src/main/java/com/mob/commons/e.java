package com.mob.commons;

import android.content.Context;
import android.text.TextUtils;
import com.mob.tools.MobLog;
import com.mob.tools.network.NetCommunicator;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: classes2.dex */
public final class e {
    public static volatile String a = null;
    private static volatile Boolean b = null;
    private static volatile String c = null;
    private static volatile boolean d = false;

    /* renamed from: e, reason: collision with root package name */
    private static HashSet<String> f17677e = new HashSet<>();
    private static final a f = new a();

    public static String b() {
        if (a()) {
            return null;
        }
        if (TextUtils.isEmpty(a)) {
            String strA = d().a();
            if (!TextUtils.isEmpty(strA) && TextUtils.isEmpty(a)) {
                a = strA;
            }
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static a d() {
        return f;
    }

    public static boolean a() {
        return !b.a();
    }

    public static String a(Context context) {
        return com.mob.tools.a.c.a(context).b().aY();
    }

    public static synchronized String a(MobProduct mobProduct) {
        HashMap<String, Object> mapB = b(mobProduct);
        if (mapB == null) {
            return null;
        }
        return (String) mapB.get(NetCommunicator.KEY_DUID);
    }

    public static synchronized HashMap<String, Object> b(final MobProduct mobProduct) {
        boolean z;
        HashMap<String, Object> map;
        boolean z2 = true;
        if (mobProduct != null) {
            v.a(mobProduct);
            z = !f17677e.contains(mobProduct.getProductTag());
            if (z) {
                f17677e.add(mobProduct.getProductTag());
            }
        } else {
            z = false;
        }
        if (TextUtils.isEmpty(a)) {
            a = d().b();
        } else {
            z2 = z;
        }
        MobLog.getInstance().d("aut pro: " + mobProduct + ", ndReg: " + z2 + ", hsReged: " + d, new Object[0]);
        if (z2 || !d) {
            u.c.execute(new com.mob.tools.utils.e() { // from class: com.mob.commons.e.1
                @Override // com.mob.tools.utils.e
                public void a() {
                    if (b.a(com.mob.commons.a.d.a("002i ef"))) {
                        boolean unused = e.d = true;
                        if (!b.d()) {
                            int i = 0;
                            while (i < 5) {
                                i++;
                                try {
                                    Thread.sleep(5000L);
                                    if (b.d()) {
                                        break;
                                    }
                                } catch (Throwable unused2) {
                                }
                            }
                        }
                        if (b.d()) {
                            e.d().a(mobProduct, new com.mob.tools.utils.b<Void>() { // from class: com.mob.commons.e.1.1
                                @Override // com.mob.tools.utils.b
                                public void a(Void r1) {
                                }
                            });
                        }
                    }
                }
            });
        }
        if (b == null) {
            String strB = w.a().b("key_curr_passed_duid", (String) null);
            c = strB;
            if (!TextUtils.isEmpty(strB) && !strB.equals(a)) {
                b = Boolean.TRUE;
            } else {
                b = Boolean.FALSE;
            }
        }
        w.a().a("key_curr_passed_duid", a);
        map = new HashMap<>();
        map.put(NetCommunicator.KEY_DUID, a);
        map.put(NetCommunicator.KEY_IS_MODIFIED, Boolean.valueOf(b.booleanValue()));
        map.put(NetCommunicator.KEY_DUID_PREVIOUS, c);
        return map;
    }
}
