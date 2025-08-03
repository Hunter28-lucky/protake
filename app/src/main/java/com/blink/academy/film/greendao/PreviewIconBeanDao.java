package com.blink.academy.film.greendao;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteStatement;
import com.umeng.analytics.pro.aq;
import defpackage.C3756;
import defpackage.C3862;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

/* loaded from: classes.dex */
public class PreviewIconBeanDao extends AbstractDao<C3756, Long> {
    public static final String TABLENAME = "PREVIEW_ICON_BEAN";

    public static class Properties {
        public static final Property Db_id = new Property(0, Long.TYPE, "db_id", true, aq.d);
        public static final Property Path = new Property(1, String.class, "path", false, "PATH");
    }

    public PreviewIconBeanDao(DaoConfig daoConfig, C3862 c3862) {
        super(daoConfig, c3862);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static void m594(Database database, boolean z) throws SQLException {
        database.execSQL("CREATE TABLE " + (z ? "IF NOT EXISTS " : "") + "\"PREVIEW_ICON_BEAN\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ,\"PATH\" TEXT);");
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static void m595(Database database, boolean z) throws SQLException {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"PREVIEW_ICON_BEAN\"");
        database.execSQL(sb.toString());
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public final boolean isEntityUpdateable() {
        return true;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public final void bindValues(SQLiteStatement sQLiteStatement, C3756 c3756) {
        sQLiteStatement.clearBindings();
        sQLiteStatement.bindLong(1, c3756.m12037());
        String strM12038 = c3756.m12038();
        if (strM12038 != null) {
            sQLiteStatement.bindString(2, strM12038);
        }
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: Ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public final void bindValues(DatabaseStatement databaseStatement, C3756 c3756) {
        databaseStatement.clearBindings();
        databaseStatement.bindLong(1, c3756.m12037());
        String strM12038 = c3756.m12038();
        if (strM12038 != null) {
            databaseStatement.bindString(2, strM12038);
        }
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: ԫ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public Long getKey(C3756 c3756) {
        if (c3756 != null) {
            return Long.valueOf(c3756.m12037());
        }
        return null;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: Ԭ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public C3756 readEntity(Cursor cursor, int i) {
        long j = cursor.getLong(i + 0);
        int i2 = i + 1;
        return new C3756(j, cursor.isNull(i2) ? null : cursor.getString(i2));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: ԭ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public void readEntity(Cursor cursor, C3756 c3756, int i) {
        c3756.m12039(cursor.getLong(i + 0));
        int i2 = i + 1;
        c3756.m12040(cursor.isNull(i2) ? null : cursor.getString(i2));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: Ԯ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public Long readKey(Cursor cursor, int i) {
        return Long.valueOf(cursor.getLong(i + 0));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: ԯ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public final Long updateKeyAfterInsert(C3756 c3756, long j) {
        c3756.m12039(j);
        return Long.valueOf(j);
    }
}
