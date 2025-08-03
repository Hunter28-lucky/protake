package com.blink.academy.film.greendao;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteStatement;
import com.umeng.analytics.pro.aq;
import defpackage.C3862;
import defpackage.C5244;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

/* loaded from: classes.dex */
public class LocalFilterGroupBeanDao extends AbstractDao<C5244, Long> {
    public static final String TABLENAME = "LOCAL_FILTER_GROUP_BEAN";

    public static class Properties {
        public static final Property Db_id = new Property(0, Long.TYPE, "db_id", true, aq.d);
        public static final Property Group_str = new Property(1, String.class, "group_str", false, "GROUP_STR");
        public static final Property Filters_str = new Property(2, String.class, "filters_str", false, "FILTERS_STR");
        public static final Property Group_collection_str = new Property(3, String.class, "group_collection_str", false, "GROUP_COLLECTION_STR");
        public static final Property Free_ids_str = new Property(4, String.class, "free_ids_str", false, "FREE_IDS_STR");
    }

    public LocalFilterGroupBeanDao(DaoConfig daoConfig, C3862 c3862) {
        super(daoConfig, c3862);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static void m558(Database database, boolean z) throws SQLException {
        database.execSQL("CREATE TABLE " + (z ? "IF NOT EXISTS " : "") + "\"LOCAL_FILTER_GROUP_BEAN\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ,\"GROUP_STR\" TEXT,\"FILTERS_STR\" TEXT,\"GROUP_COLLECTION_STR\" TEXT,\"FREE_IDS_STR\" TEXT);");
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static void m559(Database database, boolean z) throws SQLException {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"LOCAL_FILTER_GROUP_BEAN\"");
        database.execSQL(sb.toString());
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public final boolean isEntityUpdateable() {
        return true;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public final void bindValues(SQLiteStatement sQLiteStatement, C5244 c5244) {
        sQLiteStatement.clearBindings();
        sQLiteStatement.bindLong(1, c5244.m15266());
        String strM15270 = c5244.m15270();
        if (strM15270 != null) {
            sQLiteStatement.bindString(2, strM15270);
        }
        String strM15267 = c5244.m15267();
        if (strM15267 != null) {
            sQLiteStatement.bindString(3, strM15267);
        }
        String strM15269 = c5244.m15269();
        if (strM15269 != null) {
            sQLiteStatement.bindString(4, strM15269);
        }
        String strM15268 = c5244.m15268();
        if (strM15268 != null) {
            sQLiteStatement.bindString(5, strM15268);
        }
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: Ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public final void bindValues(DatabaseStatement databaseStatement, C5244 c5244) {
        databaseStatement.clearBindings();
        databaseStatement.bindLong(1, c5244.m15266());
        String strM15270 = c5244.m15270();
        if (strM15270 != null) {
            databaseStatement.bindString(2, strM15270);
        }
        String strM15267 = c5244.m15267();
        if (strM15267 != null) {
            databaseStatement.bindString(3, strM15267);
        }
        String strM15269 = c5244.m15269();
        if (strM15269 != null) {
            databaseStatement.bindString(4, strM15269);
        }
        String strM15268 = c5244.m15268();
        if (strM15268 != null) {
            databaseStatement.bindString(5, strM15268);
        }
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: ԫ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public Long getKey(C5244 c5244) {
        if (c5244 != null) {
            return Long.valueOf(c5244.m15266());
        }
        return null;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: Ԭ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public C5244 readEntity(Cursor cursor, int i) {
        long j = cursor.getLong(i + 0);
        int i2 = i + 1;
        String string = cursor.isNull(i2) ? null : cursor.getString(i2);
        int i3 = i + 2;
        String string2 = cursor.isNull(i3) ? null : cursor.getString(i3);
        int i4 = i + 3;
        int i5 = i + 4;
        return new C5244(j, string, string2, cursor.isNull(i4) ? null : cursor.getString(i4), cursor.isNull(i5) ? null : cursor.getString(i5));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: ԭ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public void readEntity(Cursor cursor, C5244 c5244, int i) {
        c5244.m15271(cursor.getLong(i + 0));
        int i2 = i + 1;
        c5244.m15275(cursor.isNull(i2) ? null : cursor.getString(i2));
        int i3 = i + 2;
        c5244.m15272(cursor.isNull(i3) ? null : cursor.getString(i3));
        int i4 = i + 3;
        c5244.m15274(cursor.isNull(i4) ? null : cursor.getString(i4));
        int i5 = i + 4;
        c5244.m15273(cursor.isNull(i5) ? null : cursor.getString(i5));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: Ԯ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public Long readKey(Cursor cursor, int i) {
        return Long.valueOf(cursor.getLong(i + 0));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: ԯ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public final Long updateKeyAfterInsert(C5244 c5244, long j) {
        c5244.m15271(j);
        return Long.valueOf(j);
    }
}
