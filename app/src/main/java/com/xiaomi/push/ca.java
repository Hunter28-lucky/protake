package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.text.SimpleDateFormat;

/* loaded from: classes2.dex */
public class ca {
    private static String a;

    /* renamed from: a, reason: collision with other field name */
    private static SimpleDateFormat f5651a;

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        f5651a = simpleDateFormat;
        a = simpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
    }

    public static gk a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        gk gkVar = new gk();
        gkVar.d("category_push_stat");
        gkVar.a("push_sdk_stat_channel");
        gkVar.a(1L);
        gkVar.b(str);
        gkVar.a(true);
        gkVar.b(System.currentTimeMillis());
        gkVar.g(bo.a(context).m5256a());
        gkVar.e("com.xiaomi.xmsf");
        gkVar.f("");
        gkVar.c("push_stat");
        return gkVar;
    }
}
