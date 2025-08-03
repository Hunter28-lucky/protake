package org.greenrobot.greendao.database;

/* loaded from: classes2.dex */
public interface DatabaseStatement {
    void bindDouble(int i, double d);

    void bindLong(int i, long j);

    void bindString(int i, String str);

    void clearBindings();

    void close();

    void execute();

    long executeInsert();

    Object getRawStatement();

    long simpleQueryForLong();
}
