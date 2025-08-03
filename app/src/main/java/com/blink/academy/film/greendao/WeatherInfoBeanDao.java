package com.blink.academy.film.greendao;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteStatement;
import com.umeng.analytics.pro.aq;
import defpackage.C3862;
import defpackage.x7;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

/* loaded from: classes.dex */
public class WeatherInfoBeanDao extends AbstractDao<x7, Long> {
    public static final String TABLENAME = "WEATHER_INFO_BEAN";

    public static class Properties {
        public static final Property Db_id = new Property(0, Long.TYPE, "db_id", true, aq.d);
        public static final Property M = new Property(1, String.class, "m", false, "M");
        public static final Property Mm = new Property(2, String.class, "mm", false, "MM");
    }

    public WeatherInfoBeanDao(DaoConfig daoConfig, C3862 c3862) {
        super(daoConfig, c3862);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static void m612(Database database, boolean z) throws SQLException {
        database.execSQL("CREATE TABLE " + (z ? "IF NOT EXISTS " : "") + "\"WEATHER_INFO_BEAN\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ,\"M\" TEXT,\"MM\" TEXT);");
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static void m613(Database database, boolean z) throws SQLException {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"WEATHER_INFO_BEAN\"");
        database.execSQL(sb.toString());
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public final boolean isEntityUpdateable() {
        return true;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public final void bindValues(SQLiteStatement sQLiteStatement, x7 x7Var) {
        sQLiteStatement.clearBindings();
        sQLiteStatement.bindLong(1, x7Var.m8589());
        String strM8590 = x7Var.m8590();
        if (strM8590 != null) {
            sQLiteStatement.bindString(2, strM8590);
        }
        String strM8591 = x7Var.m8591();
        if (strM8591 != null) {
            sQLiteStatement.bindString(3, strM8591);
        }
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: Ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public final void bindValues(DatabaseStatement databaseStatement, x7 x7Var) {
        databaseStatement.clearBindings();
        databaseStatement.bindLong(1, x7Var.m8589());
        String strM8590 = x7Var.m8590();
        if (strM8590 != null) {
            databaseStatement.bindString(2, strM8590);
        }
        String strM8591 = x7Var.m8591();
        if (strM8591 != null) {
            databaseStatement.bindString(3, strM8591);
        }
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: ԫ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public Long getKey(x7 x7Var) {
        if (x7Var != null) {
            return Long.valueOf(x7Var.m8589());
        }
        return null;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: Ԭ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public x7 readEntity(Cursor cursor, int i) {
        long j = cursor.getLong(i + 0);
        int i2 = i + 1;
        int i3 = i + 2;
        return new x7(j, cursor.isNull(i2) ? null : cursor.getString(i2), cursor.isNull(i3) ? null : cursor.getString(i3));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: ԭ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public void readEntity(Cursor cursor, x7 x7Var, int i) {
        x7Var.m8592(cursor.getLong(i + 0));
        int i2 = i + 1;
        x7Var.m8593(cursor.isNull(i2) ? null : cursor.getString(i2));
        int i3 = i + 2;
        x7Var.m8594(cursor.isNull(i3) ? null : cursor.getString(i3));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: Ԯ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public Long readKey(Cursor cursor, int i) {
        return Long.valueOf(cursor.getLong(i + 0));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: ԯ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public final Long updateKeyAfterInsert(x7 x7Var, long j) {
        x7Var.m8592(j);
        return Long.valueOf(j);
    }
}
