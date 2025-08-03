package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.blink.academy.film.support.socket.TransmitHelper;
import com.xiaomi.push.bx;

/* loaded from: classes2.dex */
public class br extends bt {
    public br(String str, String str2, String[] strArr, String str3) {
        super(str, str2, strArr, str3);
    }

    public static br a(Context context, String str, int i) {
        com.xiaomi.channel.commonutils.logger.b.b("delete  messages when db size is too bigger");
        String strM5257a = bx.a(context).m5257a(str);
        if (TextUtils.isEmpty(strM5257a)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("rowDataId in (select ");
        sb.append("rowDataId from " + strM5257a);
        sb.append(" order by createTimeStamp asc");
        sb.append(" limit ?)");
        return new br(str, sb.toString(), new String[]{String.valueOf(i)}, "a job build to delete history message");
    }

    private void a(long j) {
        String[] strArr = ((bx.d) this).f5648a;
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        strArr[0] = String.valueOf(j);
    }

    @Override // com.xiaomi.push.bx.a
    public void a(Context context, Object obj) {
        if (obj instanceof Long) {
            long jLongValue = ((Long) obj).longValue();
            long jA = cb.a(m5259a());
            long j = bp.f5630a;
            if (jA > j) {
                long j2 = (long) ((((jA - j) * 1.2d) / j) * jLongValue);
                a(j2);
                bo.a(context).a("begin delete " + j2 + "noUpload messages , because db size is " + jA + TransmitHelper.CAMERA_UNIT_B_CONTENT);
                super.a(context, obj);
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.b("db size is suitable");
        }
    }
}
