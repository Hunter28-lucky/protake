package com.blink.academy.film.greendao;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteStatement;
import com.blink.academy.film.stream.ban.ACBanBean;
import com.umeng.analytics.pro.aq;
import defpackage.C3862;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

/* loaded from: classes.dex */
public class ACBanBeanDao extends AbstractDao<ACBanBean, Long> {
    public static final String TABLENAME = "ACBAN_BEAN";

    public static class Properties {
        public static final Property Db_id = new Property(0, Long.TYPE, "db_id", true, aq.d);
        public static final Property Uuid = new Property(1, String.class, "uuid", false, "UUID");
        public static final Property Name = new Property(2, String.class, "name", false, "NAME");
        public static final Property Suffix = new Property(3, String.class, "suffix", false, "SUFFIX");
    }

    public ACBanBeanDao(DaoConfig daoConfig, C3862 c3862) {
        super(daoConfig, c3862);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static void m513(Database database, boolean z) throws SQLException {
        database.execSQL("CREATE TABLE " + (z ? "IF NOT EXISTS " : "") + "\"ACBAN_BEAN\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ,\"UUID\" TEXT,\"NAME\" TEXT,\"SUFFIX\" TEXT);");
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static void m514(Database database, boolean z) throws SQLException {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"ACBAN_BEAN\"");
        database.execSQL(sb.toString());
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public final boolean isEntityUpdateable() {
        return true;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public final void bindValues(SQLiteStatement sQLiteStatement, ACBanBean aCBanBean) {
        sQLiteStatement.clearBindings();
        sQLiteStatement.bindLong(1, aCBanBean.getDb_id());
        String uuid = aCBanBean.getUuid();
        if (uuid != null) {
            sQLiteStatement.bindString(2, uuid);
        }
        String name = aCBanBean.getName();
        if (name != null) {
            sQLiteStatement.bindString(3, name);
        }
        String suffix = aCBanBean.getSuffix();
        if (suffix != null) {
            sQLiteStatement.bindString(4, suffix);
        }
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: Ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public final void bindValues(DatabaseStatement databaseStatement, ACBanBean aCBanBean) {
        databaseStatement.clearBindings();
        databaseStatement.bindLong(1, aCBanBean.getDb_id());
        String uuid = aCBanBean.getUuid();
        if (uuid != null) {
            databaseStatement.bindString(2, uuid);
        }
        String name = aCBanBean.getName();
        if (name != null) {
            databaseStatement.bindString(3, name);
        }
        String suffix = aCBanBean.getSuffix();
        if (suffix != null) {
            databaseStatement.bindString(4, suffix);
        }
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: ԫ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public Long getKey(ACBanBean aCBanBean) {
        if (aCBanBean != null) {
            return Long.valueOf(aCBanBean.getDb_id());
        }
        return null;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: Ԭ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public ACBanBean readEntity(Cursor cursor, int i) {
        long j = cursor.getLong(i + 0);
        int i2 = i + 1;
        String string = cursor.isNull(i2) ? null : cursor.getString(i2);
        int i3 = i + 2;
        int i4 = i + 3;
        return new ACBanBean(j, string, cursor.isNull(i3) ? null : cursor.getString(i3), cursor.isNull(i4) ? null : cursor.getString(i4));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: ԭ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public void readEntity(Cursor cursor, ACBanBean aCBanBean, int i) {
        aCBanBean.setDb_id(cursor.getLong(i + 0));
        int i2 = i + 1;
        aCBanBean.setUuid(cursor.isNull(i2) ? null : cursor.getString(i2));
        int i3 = i + 2;
        aCBanBean.setName(cursor.isNull(i3) ? null : cursor.getString(i3));
        int i4 = i + 3;
        aCBanBean.setSuffix(cursor.isNull(i4) ? null : cursor.getString(i4));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: Ԯ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public Long readKey(Cursor cursor, int i) {
        return Long.valueOf(cursor.getLong(i + 0));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: ԯ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public final Long updateKeyAfterInsert(ACBanBean aCBanBean, long j) {
        aCBanBean.setDb_id(j);
        return Long.valueOf(j);
    }
}
