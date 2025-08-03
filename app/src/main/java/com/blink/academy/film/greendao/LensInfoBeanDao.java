package com.blink.academy.film.greendao;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteStatement;
import com.umeng.analytics.pro.aq;
import defpackage.C2949;
import defpackage.C3862;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

/* loaded from: classes.dex */
public class LensInfoBeanDao extends AbstractDao<C2949, Long> {
    public static final String TABLENAME = "LENS_INFO_BEAN";

    public static class Properties {
        public static final Property Preview_fps;
        public static final Property Resolution_height;
        public static final Property Resolution_width;
        public static final Property Video_fps;
        public static final Property Id = new Property(0, Long.TYPE, "id", true, aq.d);
        public static final Property CameraName = new Property(1, String.class, "cameraName", false, "CAMERA_NAME");

        static {
            Class cls = Integer.TYPE;
            Preview_fps = new Property(2, cls, "preview_fps", false, "PREVIEW_FPS");
            Video_fps = new Property(3, cls, "video_fps", false, "VIDEO_FPS");
            Resolution_width = new Property(4, cls, "resolution_width", false, "RESOLUTION_WIDTH");
            Resolution_height = new Property(5, cls, "resolution_height", false, "RESOLUTION_HEIGHT");
        }
    }

    public LensInfoBeanDao(DaoConfig daoConfig, C3862 c3862) {
        super(daoConfig, c3862);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static void m540(Database database, boolean z) throws SQLException {
        database.execSQL("CREATE TABLE " + (z ? "IF NOT EXISTS " : "") + "\"LENS_INFO_BEAN\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ,\"CAMERA_NAME\" TEXT,\"PREVIEW_FPS\" INTEGER NOT NULL ,\"VIDEO_FPS\" INTEGER NOT NULL ,\"RESOLUTION_WIDTH\" INTEGER NOT NULL ,\"RESOLUTION_HEIGHT\" INTEGER NOT NULL );");
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static void m541(Database database, boolean z) throws SQLException {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"LENS_INFO_BEAN\"");
        database.execSQL(sb.toString());
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public final boolean isEntityUpdateable() {
        return true;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public final void bindValues(SQLiteStatement sQLiteStatement, C2949 c2949) {
        sQLiteStatement.clearBindings();
        sQLiteStatement.bindLong(1, c2949.m10352());
        String strM10351 = c2949.m10351();
        if (strM10351 != null) {
            sQLiteStatement.bindString(2, strM10351);
        }
        sQLiteStatement.bindLong(3, c2949.m10353());
        sQLiteStatement.bindLong(4, c2949.m10356());
        sQLiteStatement.bindLong(5, c2949.m10355());
        sQLiteStatement.bindLong(6, c2949.m10354());
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: Ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public final void bindValues(DatabaseStatement databaseStatement, C2949 c2949) {
        databaseStatement.clearBindings();
        databaseStatement.bindLong(1, c2949.m10352());
        String strM10351 = c2949.m10351();
        if (strM10351 != null) {
            databaseStatement.bindString(2, strM10351);
        }
        databaseStatement.bindLong(3, c2949.m10353());
        databaseStatement.bindLong(4, c2949.m10356());
        databaseStatement.bindLong(5, c2949.m10355());
        databaseStatement.bindLong(6, c2949.m10354());
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: ԫ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public Long getKey(C2949 c2949) {
        if (c2949 != null) {
            return Long.valueOf(c2949.m10352());
        }
        return null;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: Ԭ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public C2949 readEntity(Cursor cursor, int i) {
        int i2 = i + 1;
        return new C2949(cursor.getLong(i + 0), cursor.isNull(i2) ? null : cursor.getString(i2), cursor.getInt(i + 2), cursor.getInt(i + 3), cursor.getInt(i + 4), cursor.getInt(i + 5));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: ԭ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public void readEntity(Cursor cursor, C2949 c2949, int i) {
        c2949.m10358(cursor.getLong(i + 0));
        int i2 = i + 1;
        c2949.m10357(cursor.isNull(i2) ? null : cursor.getString(i2));
        c2949.m10359(cursor.getInt(i + 2));
        c2949.m10362(cursor.getInt(i + 3));
        c2949.m10361(cursor.getInt(i + 4));
        c2949.m10360(cursor.getInt(i + 5));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: Ԯ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public Long readKey(Cursor cursor, int i) {
        return Long.valueOf(cursor.getLong(i + 0));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: ԯ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public final Long updateKeyAfterInsert(C2949 c2949, long j) {
        c2949.m10358(j);
        return Long.valueOf(j);
    }
}
