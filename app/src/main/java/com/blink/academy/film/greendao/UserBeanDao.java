package com.blink.academy.film.greendao;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteStatement;
import com.blink.academy.film.netbean.UserBean;
import com.umeng.analytics.pro.aq;
import com.umeng.umcrash.UMCrash;
import defpackage.C3862;
import io.jsonwebtoken.Claims;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

/* loaded from: classes.dex */
public class UserBeanDao extends AbstractDao<UserBean, Long> {
    public static final String TABLENAME = "USER_BEAN";

    public static class Properties {
        public static final Property Access_token;
        public static final Property Aud;
        public static final Property Client_nonce;
        public static final Property Db_id;
        public static final Property Exp;
        public static final Property Iat;
        public static final Property Is_subscription_user;
        public static final Property Iss;
        public static final Property Jti;
        public static final Property Nbf;
        public static final Property Products;
        public static final Property Redceived_film_ids;
        public static final Property Sub;
        public static final Property Subscription_expire_time;
        public static final Property Timestamp;
        public static final Property Uid;
        public static final Property User_phone_number_desensitized;
        public static final Property User_phone_zone;

        static {
            Class cls = Long.TYPE;
            Db_id = new Property(0, cls, "db_id", true, aq.d);
            Uid = new Property(1, cls, "uid", false, "UID");
            Access_token = new Property(2, String.class, "access_token", false, "ACCESS_TOKEN");
            Is_subscription_user = new Property(3, Boolean.TYPE, "is_subscription_user", false, "IS_SUBSCRIPTION_USER");
            Timestamp = new Property(4, cls, UMCrash.SP_KEY_TIMESTAMP, false, "TIMESTAMP");
            Products = new Property(5, String.class, "products", false, "PRODUCTS");
            Redceived_film_ids = new Property(6, String.class, "redceived_film_ids", false, "REDCEIVED_FILM_IDS");
            Subscription_expire_time = new Property(7, cls, "subscription_expire_time", false, "SUBSCRIPTION_EXPIRE_TIME");
            User_phone_number_desensitized = new Property(8, String.class, "user_phone_number_desensitized", false, "USER_PHONE_NUMBER_DESENSITIZED");
            User_phone_zone = new Property(9, String.class, "user_phone_zone", false, "USER_PHONE_ZONE");
            Client_nonce = new Property(10, String.class, "client_nonce", false, "CLIENT_NONCE");
            Aud = new Property(11, String.class, Claims.AUDIENCE, false, "AUD");
            Exp = new Property(12, cls, Claims.EXPIRATION, false, "EXP");
            Jti = new Property(13, String.class, Claims.ID, false, "JTI");
            Iat = new Property(14, cls, Claims.ISSUED_AT, false, "IAT");
            Iss = new Property(15, String.class, Claims.ISSUER, false, "ISS");
            Nbf = new Property(16, cls, Claims.NOT_BEFORE, false, "NBF");
            Sub = new Property(17, String.class, Claims.SUBJECT, false, "SUB");
        }
    }

    public UserBeanDao(DaoConfig daoConfig, C3862 c3862) {
        super(daoConfig, c3862);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static void m603(Database database, boolean z) throws SQLException {
        database.execSQL("CREATE TABLE " + (z ? "IF NOT EXISTS " : "") + "\"USER_BEAN\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ,\"UID\" INTEGER NOT NULL ,\"ACCESS_TOKEN\" TEXT,\"IS_SUBSCRIPTION_USER\" INTEGER NOT NULL ,\"TIMESTAMP\" INTEGER NOT NULL ,\"PRODUCTS\" TEXT,\"REDCEIVED_FILM_IDS\" TEXT,\"SUBSCRIPTION_EXPIRE_TIME\" INTEGER NOT NULL ,\"USER_PHONE_NUMBER_DESENSITIZED\" TEXT,\"USER_PHONE_ZONE\" TEXT,\"CLIENT_NONCE\" TEXT,\"AUD\" TEXT,\"EXP\" INTEGER NOT NULL ,\"JTI\" TEXT,\"IAT\" INTEGER NOT NULL ,\"ISS\" TEXT,\"NBF\" INTEGER NOT NULL ,\"SUB\" TEXT);");
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static void m604(Database database, boolean z) throws SQLException {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"USER_BEAN\"");
        database.execSQL(sb.toString());
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public final boolean isEntityUpdateable() {
        return true;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public final void bindValues(SQLiteStatement sQLiteStatement, UserBean userBean) {
        sQLiteStatement.clearBindings();
        sQLiteStatement.bindLong(1, userBean.getDb_id());
        sQLiteStatement.bindLong(2, userBean.getUid());
        String access_token = userBean.getAccess_token();
        if (access_token != null) {
            sQLiteStatement.bindString(3, access_token);
        }
        sQLiteStatement.bindLong(4, userBean.getIs_subscription_user() ? 1L : 0L);
        sQLiteStatement.bindLong(5, userBean.getTimestamp());
        String products = userBean.getProducts();
        if (products != null) {
            sQLiteStatement.bindString(6, products);
        }
        String redceived_film_ids = userBean.getRedceived_film_ids();
        if (redceived_film_ids != null) {
            sQLiteStatement.bindString(7, redceived_film_ids);
        }
        sQLiteStatement.bindLong(8, userBean.getSubscription_expire_time());
        String user_phone_number_desensitized = userBean.getUser_phone_number_desensitized();
        if (user_phone_number_desensitized != null) {
            sQLiteStatement.bindString(9, user_phone_number_desensitized);
        }
        String user_phone_zone = userBean.getUser_phone_zone();
        if (user_phone_zone != null) {
            sQLiteStatement.bindString(10, user_phone_zone);
        }
        String client_nonce = userBean.getClient_nonce();
        if (client_nonce != null) {
            sQLiteStatement.bindString(11, client_nonce);
        }
        String aud = userBean.getAud();
        if (aud != null) {
            sQLiteStatement.bindString(12, aud);
        }
        sQLiteStatement.bindLong(13, userBean.getExp());
        String jti = userBean.getJti();
        if (jti != null) {
            sQLiteStatement.bindString(14, jti);
        }
        sQLiteStatement.bindLong(15, userBean.getIat());
        String iss = userBean.getIss();
        if (iss != null) {
            sQLiteStatement.bindString(16, iss);
        }
        sQLiteStatement.bindLong(17, userBean.getNbf());
        String sub = userBean.getSub();
        if (sub != null) {
            sQLiteStatement.bindString(18, sub);
        }
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: Ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public final void bindValues(DatabaseStatement databaseStatement, UserBean userBean) {
        databaseStatement.clearBindings();
        databaseStatement.bindLong(1, userBean.getDb_id());
        databaseStatement.bindLong(2, userBean.getUid());
        String access_token = userBean.getAccess_token();
        if (access_token != null) {
            databaseStatement.bindString(3, access_token);
        }
        databaseStatement.bindLong(4, userBean.getIs_subscription_user() ? 1L : 0L);
        databaseStatement.bindLong(5, userBean.getTimestamp());
        String products = userBean.getProducts();
        if (products != null) {
            databaseStatement.bindString(6, products);
        }
        String redceived_film_ids = userBean.getRedceived_film_ids();
        if (redceived_film_ids != null) {
            databaseStatement.bindString(7, redceived_film_ids);
        }
        databaseStatement.bindLong(8, userBean.getSubscription_expire_time());
        String user_phone_number_desensitized = userBean.getUser_phone_number_desensitized();
        if (user_phone_number_desensitized != null) {
            databaseStatement.bindString(9, user_phone_number_desensitized);
        }
        String user_phone_zone = userBean.getUser_phone_zone();
        if (user_phone_zone != null) {
            databaseStatement.bindString(10, user_phone_zone);
        }
        String client_nonce = userBean.getClient_nonce();
        if (client_nonce != null) {
            databaseStatement.bindString(11, client_nonce);
        }
        String aud = userBean.getAud();
        if (aud != null) {
            databaseStatement.bindString(12, aud);
        }
        databaseStatement.bindLong(13, userBean.getExp());
        String jti = userBean.getJti();
        if (jti != null) {
            databaseStatement.bindString(14, jti);
        }
        databaseStatement.bindLong(15, userBean.getIat());
        String iss = userBean.getIss();
        if (iss != null) {
            databaseStatement.bindString(16, iss);
        }
        databaseStatement.bindLong(17, userBean.getNbf());
        String sub = userBean.getSub();
        if (sub != null) {
            databaseStatement.bindString(18, sub);
        }
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: ԫ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public Long getKey(UserBean userBean) {
        if (userBean != null) {
            return Long.valueOf(userBean.getDb_id());
        }
        return null;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: Ԭ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public UserBean readEntity(Cursor cursor, int i) {
        long j = cursor.getLong(i + 0);
        long j2 = cursor.getLong(i + 1);
        int i2 = i + 2;
        String string = cursor.isNull(i2) ? null : cursor.getString(i2);
        boolean z = cursor.getShort(i + 3) != 0;
        long j3 = cursor.getLong(i + 4);
        int i3 = i + 5;
        String string2 = cursor.isNull(i3) ? null : cursor.getString(i3);
        int i4 = i + 6;
        String string3 = cursor.isNull(i4) ? null : cursor.getString(i4);
        long j4 = cursor.getLong(i + 7);
        int i5 = i + 8;
        String string4 = cursor.isNull(i5) ? null : cursor.getString(i5);
        int i6 = i + 9;
        String string5 = cursor.isNull(i6) ? null : cursor.getString(i6);
        int i7 = i + 10;
        String string6 = cursor.isNull(i7) ? null : cursor.getString(i7);
        int i8 = i + 11;
        String string7 = cursor.isNull(i8) ? null : cursor.getString(i8);
        long j5 = cursor.getLong(i + 12);
        int i9 = i + 13;
        String string8 = cursor.isNull(i9) ? null : cursor.getString(i9);
        long j6 = cursor.getLong(i + 14);
        int i10 = i + 15;
        String string9 = cursor.isNull(i10) ? null : cursor.getString(i10);
        int i11 = i + 17;
        return new UserBean(j, j2, string, z, j3, string2, string3, j4, string4, string5, string6, string7, j5, string8, j6, string9, cursor.getLong(i + 16), cursor.isNull(i11) ? null : cursor.getString(i11));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: ԭ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public void readEntity(Cursor cursor, UserBean userBean, int i) {
        userBean.setDb_id(cursor.getLong(i + 0));
        userBean.setUid(cursor.getLong(i + 1));
        int i2 = i + 2;
        userBean.setAccess_token(cursor.isNull(i2) ? null : cursor.getString(i2));
        userBean.setIs_subscription_user(cursor.getShort(i + 3) != 0);
        userBean.setTimestamp(cursor.getLong(i + 4));
        int i3 = i + 5;
        userBean.setProducts(cursor.isNull(i3) ? null : cursor.getString(i3));
        int i4 = i + 6;
        userBean.setRedceived_film_ids(cursor.isNull(i4) ? null : cursor.getString(i4));
        userBean.setSubscription_expire_time(cursor.getLong(i + 7));
        int i5 = i + 8;
        userBean.setUser_phone_number_desensitized(cursor.isNull(i5) ? null : cursor.getString(i5));
        int i6 = i + 9;
        userBean.setUser_phone_zone(cursor.isNull(i6) ? null : cursor.getString(i6));
        int i7 = i + 10;
        userBean.setClient_nonce(cursor.isNull(i7) ? null : cursor.getString(i7));
        int i8 = i + 11;
        userBean.setAud(cursor.isNull(i8) ? null : cursor.getString(i8));
        userBean.setExp(cursor.getLong(i + 12));
        int i9 = i + 13;
        userBean.setJti(cursor.isNull(i9) ? null : cursor.getString(i9));
        userBean.setIat(cursor.getLong(i + 14));
        int i10 = i + 15;
        userBean.setIss(cursor.isNull(i10) ? null : cursor.getString(i10));
        userBean.setNbf(cursor.getLong(i + 16));
        int i11 = i + 17;
        userBean.setSub(cursor.isNull(i11) ? null : cursor.getString(i11));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: Ԯ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public Long readKey(Cursor cursor, int i) {
        return Long.valueOf(cursor.getLong(i + 0));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: ԯ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public final Long updateKeyAfterInsert(UserBean userBean, long j) {
        userBean.setDb_id(j);
        return Long.valueOf(j);
    }
}
