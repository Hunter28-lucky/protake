package defpackage;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

/* loaded from: classes.dex */
public class jf implements xc {
    @Override // defpackage.xc
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        Cursor cursorQuery = context.getContentResolver().query(Uri.parse("content://cn.nubia.provider.deviceid.dataid/oaid"), null, null, null, null);
        if (cursorQuery != null) {
            string = cursorQuery.moveToNext() ? cursorQuery.getString(cursorQuery.getColumnIndex("device_ids_grndid")) : null;
            cursorQuery.close();
        }
        return string;
    }
}
