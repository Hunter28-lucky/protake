package defpackage;

import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: if, reason: invalid class name */
/* loaded from: classes2.dex */
public class Cif {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static void m6291(Context context, C2328 c2328) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(c2328);
        m6292(context, linkedList);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static void m6292(Context context, List<C2328> list) {
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(list);
        qd.m8124("isSupportStatisticByMcs:" + m6293(context) + ",list size:" + linkedList.size());
        if (linkedList.size() <= 0 || !m6293(context)) {
            return;
        }
        m6294(context, linkedList);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static boolean m6293(Context context) {
        String strM8186 = re.m8171().m8186();
        return gg.m6102(context, strM8186) && gg.m6104(context, strM8186) >= 1017;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static void m6294(Context context, List<C2328> list) {
        try {
            Intent intent = new Intent();
            intent.setAction(re.m8171().m8187());
            intent.setPackage(re.m8171().m8186());
            intent.putExtra("appPackage", context.getPackageName());
            intent.putExtra("type", 12291);
            intent.putExtra("count", list.size());
            ArrayList<String> arrayList = new ArrayList<>();
            Iterator<C2328> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().m8736());
            }
            intent.putStringArrayListExtra("list", arrayList);
            context.startService(intent);
        } catch (Exception e2) {
            qd.m8125("statisticMessage--Exception" + e2.getMessage());
        }
    }
}
