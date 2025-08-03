package com.blink.academy.film.greendao;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteStatement;
import com.umeng.analytics.pro.aq;
import defpackage.C3755;
import defpackage.C3862;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

/* loaded from: classes.dex */
public class ContentNameBeanDao extends AbstractDao<C3755, Long> {
    public static final String TABLENAME = "CONTENT_NAME_BEAN";

    public static class Properties {
        public static final Property ClipCount;
        public static final Property FixId;
        public static final Property Id = new Property(0, Long.TYPE, "id", true, aq.d);

        static {
            Class cls = Integer.TYPE;
            FixId = new Property(1, cls, "fixId", false, "FIX_ID");
            ClipCount = new Property(2, cls, "clipCount", false, "CLIP_COUNT");
        }
    }

    public ContentNameBeanDao(DaoConfig daoConfig, C3862 c3862) {
        super(daoConfig, c3862);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static void m531(Database database, boolean z) throws SQLException {
        database.execSQL("CREATE TABLE " + (z ? "IF NOT EXISTS " : "") + "\"CONTENT_NAME_BEAN\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ,\"FIX_ID\" INTEGER NOT NULL ,\"CLIP_COUNT\" INTEGER NOT NULL );");
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static void m532(Database database, boolean z) throws SQLException {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"CONTENT_NAME_BEAN\"");
        database.execSQL(sb.toString());
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public final boolean isEntityUpdateable() {
        return true;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public final void bindValues(SQLiteStatement sQLiteStatement, C3755 c3755) {
        sQLiteStatement.clearBindings();
        sQLiteStatement.bindLong(1, c3755.m12033());
        sQLiteStatement.bindLong(2, c3755.m12032());
        sQLiteStatement.bindLong(3, c3755.m12031());
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: Ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public final void bindValues(DatabaseStatement databaseStatement, C3755 c3755) {
        databaseStatement.clearBindings();
        databaseStatement.bindLong(1, c3755.m12033());
        databaseStatement.bindLong(2, c3755.m12032());
        databaseStatement.bindLong(3, c3755.m12031());
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: ԫ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public Long getKey(C3755 c3755) {
        if (c3755 != null) {
            return Long.valueOf(c3755.m12033());
        }
        return null;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: Ԭ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public C3755 readEntity(Cursor cursor, int i) {
        return new C3755(cursor.getLong(i + 0), cursor.getInt(i + 1), cursor.getInt(i + 2));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: ԭ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public void readEntity(Cursor cursor, C3755 c3755, int i) {
        c3755.m12036(cursor.getLong(i + 0));
        c3755.m12035(cursor.getInt(i + 1));
        c3755.m12034(cursor.getInt(i + 2));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: Ԯ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public Long readKey(Cursor cursor, int i) {
        return Long.valueOf(cursor.getLong(i + 0));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: ԯ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public final Long updateKeyAfterInsert(C3755 c3755, long j) {
        c3755.m12036(j);
        return Long.valueOf(j);
    }
}
