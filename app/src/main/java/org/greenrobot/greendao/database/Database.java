package org.greenrobot.greendao.database;

import android.database.Cursor;
import android.database.SQLException;

/* loaded from: classes2.dex */
public interface Database {
    void beginTransaction();

    DatabaseStatement compileStatement(String str);

    void endTransaction();

    void execSQL(String str) throws SQLException;

    Object getRawDatabase();

    boolean isDbLockedByCurrentThread();

    Cursor rawQuery(String str, String[] strArr);

    void setTransactionSuccessful();
}
