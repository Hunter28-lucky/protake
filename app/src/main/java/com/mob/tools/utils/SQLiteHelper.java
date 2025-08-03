package com.mob.tools.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.mob.tools.proguard.PublicMemberKeeper;
import java.util.HashMap;
import java.util.LinkedHashMap;

/* loaded from: classes2.dex */
public class SQLiteHelper implements PublicMemberKeeper {

    public static class SingleTableDB implements PublicMemberKeeper {
        private String a;
        private String b;
        private SQLiteDatabase c;
        private LinkedHashMap<String, String> d;

        /* renamed from: e, reason: collision with root package name */
        private HashMap<String, Boolean> f17726e;
        private String f;
        private boolean g;

        public void addField(String str, String str2, boolean z) {
            if (this.c == null) {
                this.d.put(str, str2);
                this.f17726e.put(str, Boolean.valueOf(z));
            }
        }

        private SingleTableDB(String str, String str2) {
            this.a = str;
            this.b = str2;
            this.d = new LinkedHashMap<>();
            this.f17726e = new HashMap<>();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0093  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a() throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 313
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.utils.SQLiteHelper.SingleTableDB.a():void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            SQLiteDatabase sQLiteDatabase = this.c;
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
                this.c = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String c() {
            return this.b;
        }
    }

    public static void close(SingleTableDB singleTableDB) {
        singleTableDB.b();
    }

    public static int delete(SingleTableDB singleTableDB, String str, String[] strArr) throws Throwable {
        singleTableDB.a();
        return singleTableDB.c.delete(singleTableDB.c(), str, strArr);
    }

    public static SingleTableDB getDatabase(Context context, String str) {
        return getDatabase(context != null ? context.getDatabasePath(str).getPath() : null, str);
    }

    public static long insert(SingleTableDB singleTableDB, ContentValues contentValues) throws Throwable {
        singleTableDB.a();
        return singleTableDB.c.replace(singleTableDB.c(), null, contentValues);
    }

    public static Cursor query(SingleTableDB singleTableDB, String[] strArr, String str, String[] strArr2, String str2) throws Throwable {
        singleTableDB.a();
        return singleTableDB.c.query(singleTableDB.c(), strArr, str, strArr2, null, null, str2);
    }

    public static int update(SingleTableDB singleTableDB, ContentValues contentValues, String str, String[] strArr) throws Throwable {
        singleTableDB.a();
        return singleTableDB.c.update(singleTableDB.c(), contentValues, str, strArr);
    }

    public static SingleTableDB getDatabase(String str, String str2) {
        return new SingleTableDB(str, str2);
    }
}
