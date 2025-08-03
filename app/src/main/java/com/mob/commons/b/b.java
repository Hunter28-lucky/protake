package com.mob.commons.b;

import android.content.Context;
import android.text.TextUtils;
import com.mob.commons.i;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class b {
    public static synchronized HashMap<String, Object> a(Context context) {
        HashMap<String, Object> map = new HashMap<>();
        a aVarA = a.a(context);
        HashMap<String, Object> mapA = aVarA.a();
        boolean z = mapA != null && mapA.size() > 0;
        if (z) {
            HashMap map2 = new HashMap();
            if (mapA.containsKey(i.a("004Kfe6j@fg>j"))) {
                mapA.put(i.a("005LfhfeIj,fgGj"), mapA.remove(i.a("004VfeFj]fg8j")));
            }
            if (mapA.containsKey(i.a("009Zhife]gg.gefjUfkj"))) {
                mapA.put(i.a("011Lfg-j*gjfe^ggSgefj@fkj"), mapA.remove(i.a("0095hifeRgg+gefjKfkj")));
            }
            map2.putAll(mapA);
            map.put(i.a("009@hjfg4j=hiiifhfi*ek"), map2);
        }
        String strC = c(context);
        String strE = e(context);
        String strG = g(context);
        String strF = f(context);
        if (!z && TextUtils.isEmpty(strC) && TextUtils.isEmpty(strF)) {
            return null;
        }
        boolean zB = b(context);
        map.put(i.a("004+fhfhfg%j"), strE);
        map.put(i.a("004PgefhfgHj"), strC);
        map.put(i.a("004l$fhfg6j"), strG);
        map.put(i.a("005=fhfeLj6fg.j"), strF);
        map.put(i.a("011_fg'j>gjfe3gg7gefjMfkj"), Boolean.valueOf(zB));
        aVarA.a(strC, strE, strG, strF, zB);
        return map;
    }

    public static boolean b(Context context) {
        return false;
    }

    public static String c(Context context) {
        return null;
    }

    public static String d(Context context) {
        return null;
    }

    public static String e(Context context) {
        return null;
    }

    public static String f(Context context) {
        return null;
    }

    public static String g(Context context) {
        return null;
    }
}
