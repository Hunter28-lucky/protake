package com.xiaomi.push;

import android.content.Context;
import java.io.File;

/* loaded from: classes2.dex */
public class da {
    private static cz a;

    public static File a(Context context) {
        if (context == null) {
            com.xiaomi.channel.commonutils.logger.b.d("ERROR: Context cannot be null.");
            return null;
        }
        cz czVar = a;
        if (czVar != null) {
            return czVar.a(context);
        }
        com.xiaomi.channel.commonutils.logger.b.d("ERROR: XMSF not configure the instance of LogAgent.");
        return null;
    }
}
