package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.xiaomi.push.bx;

/* loaded from: classes2.dex */
public class bu extends bx.e {
    private String a;

    public bu(String str, ContentValues contentValues, String str2) {
        super(str, contentValues);
        this.a = str2;
    }

    public static bu a(Context context, String str, gk gkVar) {
        byte[] bArrA = hq.a(gkVar);
        if (bArrA == null || bArrA.length <= 0) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotificationCompat.CATEGORY_STATUS, (Integer) 0);
        contentValues.put("messageId", "");
        contentValues.put("messageItemId", gkVar.d());
        contentValues.put("messageItem", bArrA);
        contentValues.put("appId", bo.a(context).b());
        contentValues.put("packageName", bo.a(context).m5256a());
        contentValues.put("createTimeStamp", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("uploadTimestamp", (Integer) 0);
        return new bu(str, contentValues, "a job build to insert message to db");
    }
}
