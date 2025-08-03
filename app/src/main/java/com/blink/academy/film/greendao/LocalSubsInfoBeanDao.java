package com.blink.academy.film.greendao;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteStatement;
import com.umeng.analytics.pro.aq;
import defpackage.C3287;
import defpackage.C3862;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

/* loaded from: classes.dex */
public class LocalSubsInfoBeanDao extends AbstractDao<C3287, Long> {
    public static final String TABLENAME = "LOCAL_SUBS_INFO_BEAN";

    public static class Properties {
        public static final Property Db_id = new Property(0, Long.TYPE, "db_id", true, aq.d);
        public static final Property Json_str = new Property(1, String.class, "json_str", false, "JSON_STR");
    }

    public LocalSubsInfoBeanDao(DaoConfig daoConfig, C3862 c3862) {
        super(daoConfig, c3862);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static void m576(Database database, boolean z) throws SQLException {
        database.execSQL("CREATE TABLE " + (z ? "IF NOT EXISTS " : "") + "\"LOCAL_SUBS_INFO_BEAN\" (\"_id\" INTEGER PRIMARY KEY NOT NULL ,\"JSON_STR\" TEXT);");
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static void m577(Database database, boolean z) throws SQLException {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"LOCAL_SUBS_INFO_BEAN\"");
        database.execSQL(sb.toString());
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public final boolean isEntityUpdateable() {
        return true;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public final void bindValues(SQLiteStatement sQLiteStatement, C3287 c3287) {
        sQLiteStatement.clearBindings();
        sQLiteStatement.bindLong(1, c3287.m11048());
        String strM11049 = c3287.m11049();
        if (strM11049 != null) {
            sQLiteStatement.bindString(2, strM11049);
        }
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: Ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public final void bindValues(DatabaseStatement databaseStatement, C3287 c3287) {
        databaseStatement.clearBindings();
        databaseStatement.bindLong(1, c3287.m11048());
        String strM11049 = c3287.m11049();
        if (strM11049 != null) {
            databaseStatement.bindString(2, strM11049);
        }
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: ԫ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public Long getKey(C3287 c3287) {
        if (c3287 != null) {
            return Long.valueOf(c3287.m11048());
        }
        return null;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: Ԭ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public C3287 readEntity(Cursor cursor, int i) {
        long j = cursor.getLong(i + 0);
        int i2 = i + 1;
        return new C3287(j, cursor.isNull(i2) ? null : cursor.getString(i2));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: ԭ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public void readEntity(Cursor cursor, C3287 c3287, int i) {
        c3287.m11050(cursor.getLong(i + 0));
        int i2 = i + 1;
        c3287.m11051(cursor.isNull(i2) ? null : cursor.getString(i2));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: Ԯ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public Long readKey(Cursor cursor, int i) {
        return Long.valueOf(cursor.getLong(i + 0));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: ԯ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public final Long updateKeyAfterInsert(C3287 c3287, long j) {
        c3287.m11050(j);
        return Long.valueOf(j);
    }
}
