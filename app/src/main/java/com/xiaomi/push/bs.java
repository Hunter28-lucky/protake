package com.xiaomi.push;

import android.content.Context;
import android.database.Cursor;
import com.xiaomi.push.bx;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class bs extends bx.b<Long> {
    private long a;

    /* renamed from: a, reason: collision with other field name */
    private String f5633a;

    public bs(String str, List<String> list, String str2, String[] strArr, String str3, String str4, String str5, int i, String str6) {
        super(str, list, str2, strArr, str3, str4, str5, i);
        this.a = 0L;
        this.f5633a = str6;
    }

    public static bs a(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("count(*)");
        return new bs(str, arrayList, null, null, null, null, null, 0, "job to get count of all message");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.xiaomi.push.bx.b
    public Long a(Context context, Cursor cursor) {
        return Long.valueOf(cursor.getLong(0));
    }

    @Override // com.xiaomi.push.bx.b
    public void a(Context context, List<Long> list) {
        if (context == null || list == null || list.size() <= 0) {
            return;
        }
        this.a = list.get(0).longValue();
    }

    @Override // com.xiaomi.push.bx.a
    /* renamed from: a */
    public Object mo5258a() {
        return Long.valueOf(this.a);
    }
}
