package com.blink.academy.film.greendao;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteStatement;
import com.umeng.analytics.pro.aq;
import defpackage.C2531;
import defpackage.C3862;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

/* loaded from: classes.dex */
public class LocalFilterBeanDao extends AbstractDao<C2531, Long> {
    public static final String TABLENAME = "LOCAL_FILTER_BEAN";

    public static class Properties {
        public static final Property Db_id = new Property(0, Long.TYPE, "db_id", true, aq.d);
        public static final Property Id;
        public static final Property Path;
        public static final Property PreviewPath;
        public static final Property Real_path;
        public static final Property Version_id;

        static {
            Class cls = Integer.TYPE;
            Id = new Property(1, cls, "id", false, "ID");
            Version_id = new Property(2, cls, "version_id", false, "VERSION_ID");
            Path = new Property(3, String.class, "path", false, "PATH");
            Real_path = new Property(4, String.class, "real_path", false, "REAL_PATH");
            PreviewPath = new Property(5, String.class, "previewPath", false, "PREVIEW_PATH");
        }
    }

    public LocalFilterBeanDao(DaoConfig daoConfig, C3862 c3862) {
        super(daoConfig, c3862);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static void m549(Database database, boolean z) throws SQLException {
        database.execSQL("CREATE TABLE " + (z ? "IF NOT EXISTS " : "") + "\"LOCAL_FILTER_BEAN\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ,\"ID\" INTEGER NOT NULL ,\"VERSION_ID\" INTEGER NOT NULL ,\"PATH\" TEXT,\"REAL_PATH\" TEXT,\"PREVIEW_PATH\" TEXT);");
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static void m550(Database database, boolean z) throws SQLException {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"LOCAL_FILTER_BEAN\"");
        database.execSQL(sb.toString());
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public final boolean isEntityUpdateable() {
        return true;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public final void bindValues(SQLiteStatement sQLiteStatement, C2531 c2531) {
        sQLiteStatement.clearBindings();
        sQLiteStatement.bindLong(1, c2531.m9345());
        sQLiteStatement.bindLong(2, c2531.m9346());
        sQLiteStatement.bindLong(3, c2531.m9350());
        String strM9347 = c2531.m9347();
        if (strM9347 != null) {
            sQLiteStatement.bindString(4, strM9347);
        }
        String strM9349 = c2531.m9349();
        if (strM9349 != null) {
            sQLiteStatement.bindString(5, strM9349);
        }
        String strM9348 = c2531.m9348();
        if (strM9348 != null) {
            sQLiteStatement.bindString(6, strM9348);
        }
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: Ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public final void bindValues(DatabaseStatement databaseStatement, C2531 c2531) {
        databaseStatement.clearBindings();
        databaseStatement.bindLong(1, c2531.m9345());
        databaseStatement.bindLong(2, c2531.m9346());
        databaseStatement.bindLong(3, c2531.m9350());
        String strM9347 = c2531.m9347();
        if (strM9347 != null) {
            databaseStatement.bindString(4, strM9347);
        }
        String strM9349 = c2531.m9349();
        if (strM9349 != null) {
            databaseStatement.bindString(5, strM9349);
        }
        String strM9348 = c2531.m9348();
        if (strM9348 != null) {
            databaseStatement.bindString(6, strM9348);
        }
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: ԫ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public Long getKey(C2531 c2531) {
        if (c2531 != null) {
            return Long.valueOf(c2531.m9345());
        }
        return null;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: Ԭ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public C2531 readEntity(Cursor cursor, int i) {
        long j = cursor.getLong(i + 0);
        int i2 = cursor.getInt(i + 1);
        int i3 = cursor.getInt(i + 2);
        int i4 = i + 3;
        String string = cursor.isNull(i4) ? null : cursor.getString(i4);
        int i5 = i + 4;
        int i6 = i + 5;
        return new C2531(j, i2, i3, string, cursor.isNull(i5) ? null : cursor.getString(i5), cursor.isNull(i6) ? null : cursor.getString(i6));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: ԭ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public void readEntity(Cursor cursor, C2531 c2531, int i) {
        c2531.m9351(cursor.getLong(i + 0));
        c2531.m9352(cursor.getInt(i + 1));
        c2531.m9356(cursor.getInt(i + 2));
        int i2 = i + 3;
        c2531.m9353(cursor.isNull(i2) ? null : cursor.getString(i2));
        int i3 = i + 4;
        c2531.m9355(cursor.isNull(i3) ? null : cursor.getString(i3));
        int i4 = i + 5;
        c2531.m9354(cursor.isNull(i4) ? null : cursor.getString(i4));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: Ԯ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public Long readKey(Cursor cursor, int i) {
        return Long.valueOf(cursor.getLong(i + 0));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: ԯ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public final Long updateKeyAfterInsert(C2531 c2531, long j) {
        c2531.m9351(j);
        return Long.valueOf(j);
    }
}
