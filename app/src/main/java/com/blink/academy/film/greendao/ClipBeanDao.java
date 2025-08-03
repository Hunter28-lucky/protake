package com.blink.academy.film.greendao;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteStatement;
import com.umeng.analytics.pro.aq;
import defpackage.C2628;
import defpackage.C3862;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

/* loaded from: classes.dex */
public class ClipBeanDao extends AbstractDao<C2628, Long> {
    public static final String TABLENAME = "CLIP_BEAN";

    public static class Properties {
        public static final Property Clapperboard;
        public static final Property ConfigName;
        public static final Property Duration;
        public static final Property FilePath;
        public static final Property FileUri;
        public static final Property GoodState;
        public static final Property Id;
        public static final Property KeepState;
        public static final Property MetaDataAccessories;
        public static final Property MetaDataAudioAutoGain;
        public static final Property MetaDataAudioLevel;
        public static final Property MetaDataAutoExposure;
        public static final Property MetaDataBattery;
        public static final Property MetaDataBlack;
        public static final Property MetaDataBrightness;
        public static final Property MetaDataCameraName;
        public static final Property MetaDataClipCount;
        public static final Property MetaDataClipID;
        public static final Property MetaDataContrast;
        public static final Property MetaDataExposureBias;
        public static final Property MetaDataFlicker;
        public static final Property MetaDataFrameDrop;
        public static final Property MetaDataFramework;
        public static final Property MetaDataISO;
        public static final Property MetaDataJson;
        public static final Property MetaDataLen;
        public static final Property MetaDataLutStrength;
        public static final Property MetaDataLutType;
        public static final Property MetaDataMic;
        public static final Property MetaDataMode;
        public static final Property MetaDataNoiseReduction;
        public static final Property MetaDataProjectFps;
        public static final Property MetaDataReel;
        public static final Property MetaDataSharpness;
        public static final Property MetaDataShutterSpeed;
        public static final Property MetaDataStabilization;
        public static final Property MetaDataSuffix;
        public static final Property MetaDataVfr;
        public static final Property MetaDataWhite;
        public static final Property MetaDataWhiteBalanceMode;
        public static final Property Name;
        public static final Property NgState;
        public static final Property PortraitClip;
        public static final Property ResHeight;
        public static final Property ResWidth;
        public static final Property ThumbPath;
        public static final Property ThumbSmallPath;
        public static final Property VideoFps;

        static {
            Class cls = Long.TYPE;
            Id = new Property(0, cls, "id", true, aq.d);
            FilePath = new Property(1, String.class, "filePath", false, "FILE_PATH");
            FileUri = new Property(2, String.class, "fileUri", false, "FILE_URI");
            ThumbPath = new Property(3, String.class, "thumbPath", false, "THUMB_PATH");
            ThumbSmallPath = new Property(4, String.class, "thumbSmallPath", false, "THUMB_SMALL_PATH");
            Class cls2 = Integer.TYPE;
            GoodState = new Property(5, cls2, "goodState", false, "GOOD_STATE");
            KeepState = new Property(6, cls2, "keepState", false, "KEEP_STATE");
            NgState = new Property(7, cls2, "ngState", false, "NG_STATE");
            Name = new Property(8, String.class, "name", false, "NAME");
            ConfigName = new Property(9, String.class, "configName", false, "CONFIG_NAME");
            Duration = new Property(10, cls, "duration", false, "DURATION");
            Clapperboard = new Property(11, String.class, "clapperboard", false, "CLAPPERBOARD");
            ResHeight = new Property(12, cls2, "resHeight", false, "RES_HEIGHT");
            ResWidth = new Property(13, cls2, "resWidth", false, "RES_WIDTH");
            PortraitClip = new Property(14, Boolean.TYPE, "portraitClip", false, "PORTRAIT_CLIP");
            VideoFps = new Property(15, cls2, "videoFps", false, "VIDEO_FPS");
            MetaDataJson = new Property(16, String.class, "metaDataJson", false, "META_DATA_JSON");
            MetaDataFrameDrop = new Property(17, String.class, "metaDataFrameDrop", false, "META_DATA_FRAME_DROP");
            MetaDataLen = new Property(18, String.class, "metaDataLen", false, "META_DATA_LEN");
            MetaDataLutType = new Property(19, String.class, "metaDataLutType", false, "META_DATA_LUT_TYPE");
            MetaDataLutStrength = new Property(20, String.class, "metaDataLutStrength", false, "META_DATA_LUT_STRENGTH");
            MetaDataContrast = new Property(21, String.class, "metaDataContrast", false, "META_DATA_CONTRAST");
            MetaDataBrightness = new Property(22, String.class, "metaDataBrightness", false, "META_DATA_BRIGHTNESS");
            MetaDataBlack = new Property(23, String.class, "metaDataBlack", false, "META_DATA_BLACK");
            MetaDataWhite = new Property(24, String.class, "metaDataWhite", false, "META_DATA_WHITE");
            MetaDataAutoExposure = new Property(25, String.class, "metaDataAutoExposure", false, "META_DATA_AUTO_EXPOSURE");
            MetaDataISO = new Property(26, String.class, "metaDataISO", false, "META_DATA_ISO");
            MetaDataShutterSpeed = new Property(27, String.class, "metaDataShutterSpeed", false, "META_DATA_SHUTTER_SPEED");
            MetaDataExposureBias = new Property(28, String.class, "metaDataExposureBias", false, "META_DATA_EXPOSURE_BIAS");
            MetaDataWhiteBalanceMode = new Property(29, String.class, "metaDataWhiteBalanceMode", false, "META_DATA_WHITE_BALANCE_MODE");
            MetaDataSharpness = new Property(30, String.class, "metaDataSharpness", false, "META_DATA_SHARPNESS");
            MetaDataNoiseReduction = new Property(31, String.class, "metaDataNoiseReduction", false, "META_DATA_NOISE_REDUCTION");
            MetaDataStabilization = new Property(32, String.class, "metaDataStabilization", false, "META_DATA_STABILIZATION");
            MetaDataProjectFps = new Property(33, String.class, "metaDataProjectFps", false, "META_DATA_PROJECT_FPS");
            MetaDataCameraName = new Property(34, String.class, "metaDataCameraName", false, "META_DATA_CAMERA_NAME");
            MetaDataReel = new Property(35, String.class, "metaDataReel", false, "META_DATA_REEL");
            MetaDataClipCount = new Property(36, String.class, "metaDataClipCount", false, "META_DATA_CLIP_COUNT");
            MetaDataSuffix = new Property(37, String.class, "metaDataSuffix", false, "META_DATA_SUFFIX");
            MetaDataClipID = new Property(38, String.class, "metaDataClipID", false, "META_DATA_CLIP_ID");
            MetaDataAudioLevel = new Property(39, String.class, "metaDataAudioLevel", false, "META_DATA_AUDIO_LEVEL");
            MetaDataMic = new Property(40, String.class, "metaDataMic", false, "META_DATA_MIC");
            MetaDataAudioAutoGain = new Property(41, String.class, "metaDataAudioAutoGain", false, "META_DATA_AUDIO_AUTO_GAIN");
            MetaDataMode = new Property(42, String.class, "metaDataMode", false, "META_DATA_MODE");
            MetaDataFlicker = new Property(43, String.class, "metaDataFlicker", false, "META_DATA_FLICKER");
            MetaDataFramework = new Property(44, String.class, "metaDataFramework", false, "META_DATA_FRAMEWORK");
            MetaDataBattery = new Property(45, String.class, "metaDataBattery", false, "META_DATA_BATTERY");
            MetaDataAccessories = new Property(46, String.class, "metaDataAccessories", false, "META_DATA_ACCESSORIES");
            MetaDataVfr = new Property(47, String.class, "metaDataVfr", false, "META_DATA_VFR");
        }
    }

    public ClipBeanDao(DaoConfig daoConfig, C3862 c3862) {
        super(daoConfig, c3862);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static void m522(Database database, boolean z) throws SQLException {
        database.execSQL("CREATE TABLE " + (z ? "IF NOT EXISTS " : "") + "\"CLIP_BEAN\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ,\"FILE_PATH\" TEXT,\"FILE_URI\" TEXT,\"THUMB_PATH\" TEXT,\"THUMB_SMALL_PATH\" TEXT,\"GOOD_STATE\" INTEGER NOT NULL ,\"KEEP_STATE\" INTEGER NOT NULL ,\"NG_STATE\" INTEGER NOT NULL ,\"NAME\" TEXT,\"CONFIG_NAME\" TEXT,\"DURATION\" INTEGER NOT NULL ,\"CLAPPERBOARD\" TEXT,\"RES_HEIGHT\" INTEGER NOT NULL ,\"RES_WIDTH\" INTEGER NOT NULL ,\"PORTRAIT_CLIP\" INTEGER NOT NULL ,\"VIDEO_FPS\" INTEGER NOT NULL ,\"META_DATA_JSON\" TEXT,\"META_DATA_FRAME_DROP\" TEXT,\"META_DATA_LEN\" TEXT,\"META_DATA_LUT_TYPE\" TEXT,\"META_DATA_LUT_STRENGTH\" TEXT,\"META_DATA_CONTRAST\" TEXT,\"META_DATA_BRIGHTNESS\" TEXT,\"META_DATA_BLACK\" TEXT,\"META_DATA_WHITE\" TEXT,\"META_DATA_AUTO_EXPOSURE\" TEXT,\"META_DATA_ISO\" TEXT,\"META_DATA_SHUTTER_SPEED\" TEXT,\"META_DATA_EXPOSURE_BIAS\" TEXT,\"META_DATA_WHITE_BALANCE_MODE\" TEXT,\"META_DATA_SHARPNESS\" TEXT,\"META_DATA_NOISE_REDUCTION\" TEXT,\"META_DATA_STABILIZATION\" TEXT,\"META_DATA_PROJECT_FPS\" TEXT,\"META_DATA_CAMERA_NAME\" TEXT,\"META_DATA_REEL\" TEXT,\"META_DATA_CLIP_COUNT\" TEXT,\"META_DATA_SUFFIX\" TEXT,\"META_DATA_CLIP_ID\" TEXT,\"META_DATA_AUDIO_LEVEL\" TEXT,\"META_DATA_MIC\" TEXT,\"META_DATA_AUDIO_AUTO_GAIN\" TEXT,\"META_DATA_MODE\" TEXT,\"META_DATA_FLICKER\" TEXT,\"META_DATA_FRAMEWORK\" TEXT,\"META_DATA_BATTERY\" TEXT,\"META_DATA_ACCESSORIES\" TEXT,\"META_DATA_VFR\" TEXT);");
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static void m523(Database database, boolean z) throws SQLException {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"CLIP_BEAN\"");
        database.execSQL(sb.toString());
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public final boolean isEntityUpdateable() {
        return true;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public final void bindValues(SQLiteStatement sQLiteStatement, C2628 c2628) {
        sQLiteStatement.clearBindings();
        sQLiteStatement.bindLong(1, c2628.m9595());
        String strM9592 = c2628.m9592();
        if (strM9592 != null) {
            sQLiteStatement.bindString(2, strM9592);
        }
        String strM9593 = c2628.m9593();
        if (strM9593 != null) {
            sQLiteStatement.bindString(3, strM9593);
        }
        String strM9634 = c2628.m9634();
        if (strM9634 != null) {
            sQLiteStatement.bindString(4, strM9634);
        }
        String strM9635 = c2628.m9635();
        if (strM9635 != null) {
            sQLiteStatement.bindString(5, strM9635);
        }
        sQLiteStatement.bindLong(6, c2628.m9594());
        sQLiteStatement.bindLong(7, c2628.m9596());
        sQLiteStatement.bindLong(8, c2628.m9630());
        String strM9629 = c2628.m9629();
        if (strM9629 != null) {
            sQLiteStatement.bindString(9, strM9629);
        }
        String strM9590 = c2628.m9590();
        if (strM9590 != null) {
            sQLiteStatement.bindString(10, strM9590);
        }
        sQLiteStatement.bindLong(11, c2628.m9591());
        String strM9589 = c2628.m9589();
        if (strM9589 != null) {
            sQLiteStatement.bindString(12, strM9589);
        }
        sQLiteStatement.bindLong(13, c2628.m9632());
        sQLiteStatement.bindLong(14, c2628.m9633());
        sQLiteStatement.bindLong(15, c2628.m9631() ? 1L : 0L);
        sQLiteStatement.bindLong(16, c2628.m9636());
        String strM9613 = c2628.m9613();
        if (strM9613 != null) {
            sQLiteStatement.bindString(17, strM9613);
        }
        String strM9610 = c2628.m9610();
        if (strM9610 != null) {
            sQLiteStatement.bindString(18, strM9610);
        }
        String strM9614 = c2628.m9614();
        if (strM9614 != null) {
            sQLiteStatement.bindString(19, strM9614);
        }
        String strM9616 = c2628.m9616();
        if (strM9616 != null) {
            sQLiteStatement.bindString(20, strM9616);
        }
        String strM9615 = c2628.m9615();
        if (strM9615 != null) {
            sQLiteStatement.bindString(21, strM9615);
        }
        String strM9607 = c2628.m9607();
        if (strM9607 != null) {
            sQLiteStatement.bindString(22, strM9607);
        }
        String strM9603 = c2628.m9603();
        if (strM9603 != null) {
            sQLiteStatement.bindString(23, strM9603);
        }
        String strM9602 = c2628.m9602();
        if (strM9602 != null) {
            sQLiteStatement.bindString(24, strM9602);
        }
        String strM9627 = c2628.m9627();
        if (strM9627 != null) {
            sQLiteStatement.bindString(25, strM9627);
        }
        String strM9600 = c2628.m9600();
        if (strM9600 != null) {
            sQLiteStatement.bindString(26, strM9600);
        }
        String strM9612 = c2628.m9612();
        if (strM9612 != null) {
            sQLiteStatement.bindString(27, strM9612);
        }
        String strM9623 = c2628.m9623();
        if (strM9623 != null) {
            sQLiteStatement.bindString(28, strM9623);
        }
        String strM9608 = c2628.m9608();
        if (strM9608 != null) {
            sQLiteStatement.bindString(29, strM9608);
        }
        String strM9628 = c2628.m9628();
        if (strM9628 != null) {
            sQLiteStatement.bindString(30, strM9628);
        }
        String strM9622 = c2628.m9622();
        if (strM9622 != null) {
            sQLiteStatement.bindString(31, strM9622);
        }
        String strM9619 = c2628.m9619();
        if (strM9619 != null) {
            sQLiteStatement.bindString(32, strM9619);
        }
        String strM9624 = c2628.m9624();
        if (strM9624 != null) {
            sQLiteStatement.bindString(33, strM9624);
        }
        String strM9620 = c2628.m9620();
        if (strM9620 != null) {
            sQLiteStatement.bindString(34, strM9620);
        }
        String strM9604 = c2628.m9604();
        if (strM9604 != null) {
            sQLiteStatement.bindString(35, strM9604);
        }
        String strM9621 = c2628.m9621();
        if (strM9621 != null) {
            sQLiteStatement.bindString(36, strM9621);
        }
        String strM9605 = c2628.m9605();
        if (strM9605 != null) {
            sQLiteStatement.bindString(37, strM9605);
        }
        String strM9625 = c2628.m9625();
        if (strM9625 != null) {
            sQLiteStatement.bindString(38, strM9625);
        }
        String strM9606 = c2628.m9606();
        if (strM9606 != null) {
            sQLiteStatement.bindString(39, strM9606);
        }
        String strM9599 = c2628.m9599();
        if (strM9599 != null) {
            sQLiteStatement.bindString(40, strM9599);
        }
        String strM9617 = c2628.m9617();
        if (strM9617 != null) {
            sQLiteStatement.bindString(41, strM9617);
        }
        String strM9598 = c2628.m9598();
        if (strM9598 != null) {
            sQLiteStatement.bindString(42, strM9598);
        }
        String strM9618 = c2628.m9618();
        if (strM9618 != null) {
            sQLiteStatement.bindString(43, strM9618);
        }
        String strM9609 = c2628.m9609();
        if (strM9609 != null) {
            sQLiteStatement.bindString(44, strM9609);
        }
        String strM9611 = c2628.m9611();
        if (strM9611 != null) {
            sQLiteStatement.bindString(45, strM9611);
        }
        String strM9601 = c2628.m9601();
        if (strM9601 != null) {
            sQLiteStatement.bindString(46, strM9601);
        }
        String strM9597 = c2628.m9597();
        if (strM9597 != null) {
            sQLiteStatement.bindString(47, strM9597);
        }
        String strM9626 = c2628.m9626();
        if (strM9626 != null) {
            sQLiteStatement.bindString(48, strM9626);
        }
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: Ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public final void bindValues(DatabaseStatement databaseStatement, C2628 c2628) {
        databaseStatement.clearBindings();
        databaseStatement.bindLong(1, c2628.m9595());
        String strM9592 = c2628.m9592();
        if (strM9592 != null) {
            databaseStatement.bindString(2, strM9592);
        }
        String strM9593 = c2628.m9593();
        if (strM9593 != null) {
            databaseStatement.bindString(3, strM9593);
        }
        String strM9634 = c2628.m9634();
        if (strM9634 != null) {
            databaseStatement.bindString(4, strM9634);
        }
        String strM9635 = c2628.m9635();
        if (strM9635 != null) {
            databaseStatement.bindString(5, strM9635);
        }
        databaseStatement.bindLong(6, c2628.m9594());
        databaseStatement.bindLong(7, c2628.m9596());
        databaseStatement.bindLong(8, c2628.m9630());
        String strM9629 = c2628.m9629();
        if (strM9629 != null) {
            databaseStatement.bindString(9, strM9629);
        }
        String strM9590 = c2628.m9590();
        if (strM9590 != null) {
            databaseStatement.bindString(10, strM9590);
        }
        databaseStatement.bindLong(11, c2628.m9591());
        String strM9589 = c2628.m9589();
        if (strM9589 != null) {
            databaseStatement.bindString(12, strM9589);
        }
        databaseStatement.bindLong(13, c2628.m9632());
        databaseStatement.bindLong(14, c2628.m9633());
        databaseStatement.bindLong(15, c2628.m9631() ? 1L : 0L);
        databaseStatement.bindLong(16, c2628.m9636());
        String strM9613 = c2628.m9613();
        if (strM9613 != null) {
            databaseStatement.bindString(17, strM9613);
        }
        String strM9610 = c2628.m9610();
        if (strM9610 != null) {
            databaseStatement.bindString(18, strM9610);
        }
        String strM9614 = c2628.m9614();
        if (strM9614 != null) {
            databaseStatement.bindString(19, strM9614);
        }
        String strM9616 = c2628.m9616();
        if (strM9616 != null) {
            databaseStatement.bindString(20, strM9616);
        }
        String strM9615 = c2628.m9615();
        if (strM9615 != null) {
            databaseStatement.bindString(21, strM9615);
        }
        String strM9607 = c2628.m9607();
        if (strM9607 != null) {
            databaseStatement.bindString(22, strM9607);
        }
        String strM9603 = c2628.m9603();
        if (strM9603 != null) {
            databaseStatement.bindString(23, strM9603);
        }
        String strM9602 = c2628.m9602();
        if (strM9602 != null) {
            databaseStatement.bindString(24, strM9602);
        }
        String strM9627 = c2628.m9627();
        if (strM9627 != null) {
            databaseStatement.bindString(25, strM9627);
        }
        String strM9600 = c2628.m9600();
        if (strM9600 != null) {
            databaseStatement.bindString(26, strM9600);
        }
        String strM9612 = c2628.m9612();
        if (strM9612 != null) {
            databaseStatement.bindString(27, strM9612);
        }
        String strM9623 = c2628.m9623();
        if (strM9623 != null) {
            databaseStatement.bindString(28, strM9623);
        }
        String strM9608 = c2628.m9608();
        if (strM9608 != null) {
            databaseStatement.bindString(29, strM9608);
        }
        String strM9628 = c2628.m9628();
        if (strM9628 != null) {
            databaseStatement.bindString(30, strM9628);
        }
        String strM9622 = c2628.m9622();
        if (strM9622 != null) {
            databaseStatement.bindString(31, strM9622);
        }
        String strM9619 = c2628.m9619();
        if (strM9619 != null) {
            databaseStatement.bindString(32, strM9619);
        }
        String strM9624 = c2628.m9624();
        if (strM9624 != null) {
            databaseStatement.bindString(33, strM9624);
        }
        String strM9620 = c2628.m9620();
        if (strM9620 != null) {
            databaseStatement.bindString(34, strM9620);
        }
        String strM9604 = c2628.m9604();
        if (strM9604 != null) {
            databaseStatement.bindString(35, strM9604);
        }
        String strM9621 = c2628.m9621();
        if (strM9621 != null) {
            databaseStatement.bindString(36, strM9621);
        }
        String strM9605 = c2628.m9605();
        if (strM9605 != null) {
            databaseStatement.bindString(37, strM9605);
        }
        String strM9625 = c2628.m9625();
        if (strM9625 != null) {
            databaseStatement.bindString(38, strM9625);
        }
        String strM9606 = c2628.m9606();
        if (strM9606 != null) {
            databaseStatement.bindString(39, strM9606);
        }
        String strM9599 = c2628.m9599();
        if (strM9599 != null) {
            databaseStatement.bindString(40, strM9599);
        }
        String strM9617 = c2628.m9617();
        if (strM9617 != null) {
            databaseStatement.bindString(41, strM9617);
        }
        String strM9598 = c2628.m9598();
        if (strM9598 != null) {
            databaseStatement.bindString(42, strM9598);
        }
        String strM9618 = c2628.m9618();
        if (strM9618 != null) {
            databaseStatement.bindString(43, strM9618);
        }
        String strM9609 = c2628.m9609();
        if (strM9609 != null) {
            databaseStatement.bindString(44, strM9609);
        }
        String strM9611 = c2628.m9611();
        if (strM9611 != null) {
            databaseStatement.bindString(45, strM9611);
        }
        String strM9601 = c2628.m9601();
        if (strM9601 != null) {
            databaseStatement.bindString(46, strM9601);
        }
        String strM9597 = c2628.m9597();
        if (strM9597 != null) {
            databaseStatement.bindString(47, strM9597);
        }
        String strM9626 = c2628.m9626();
        if (strM9626 != null) {
            databaseStatement.bindString(48, strM9626);
        }
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: ԫ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public Long getKey(C2628 c2628) {
        if (c2628 != null) {
            return Long.valueOf(c2628.m9595());
        }
        return null;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: Ԭ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public C2628 readEntity(Cursor cursor, int i) {
        long j = cursor.getLong(i + 0);
        int i2 = i + 1;
        String string = cursor.isNull(i2) ? null : cursor.getString(i2);
        int i3 = i + 2;
        String string2 = cursor.isNull(i3) ? null : cursor.getString(i3);
        int i4 = i + 3;
        String string3 = cursor.isNull(i4) ? null : cursor.getString(i4);
        int i5 = i + 4;
        String string4 = cursor.isNull(i5) ? null : cursor.getString(i5);
        int i6 = cursor.getInt(i + 5);
        int i7 = cursor.getInt(i + 6);
        int i8 = cursor.getInt(i + 7);
        int i9 = i + 8;
        String string5 = cursor.isNull(i9) ? null : cursor.getString(i9);
        int i10 = i + 9;
        String string6 = cursor.isNull(i10) ? null : cursor.getString(i10);
        long j2 = cursor.getLong(i + 10);
        int i11 = i + 11;
        String string7 = cursor.isNull(i11) ? null : cursor.getString(i11);
        int i12 = cursor.getInt(i + 12);
        int i13 = cursor.getInt(i + 13);
        boolean z = cursor.getShort(i + 14) != 0;
        int i14 = cursor.getInt(i + 15);
        int i15 = i + 16;
        String string8 = cursor.isNull(i15) ? null : cursor.getString(i15);
        int i16 = i + 17;
        String string9 = cursor.isNull(i16) ? null : cursor.getString(i16);
        int i17 = i + 18;
        String string10 = cursor.isNull(i17) ? null : cursor.getString(i17);
        int i18 = i + 19;
        String string11 = cursor.isNull(i18) ? null : cursor.getString(i18);
        int i19 = i + 20;
        String string12 = cursor.isNull(i19) ? null : cursor.getString(i19);
        int i20 = i + 21;
        String string13 = cursor.isNull(i20) ? null : cursor.getString(i20);
        int i21 = i + 22;
        String string14 = cursor.isNull(i21) ? null : cursor.getString(i21);
        int i22 = i + 23;
        String string15 = cursor.isNull(i22) ? null : cursor.getString(i22);
        int i23 = i + 24;
        String string16 = cursor.isNull(i23) ? null : cursor.getString(i23);
        int i24 = i + 25;
        String string17 = cursor.isNull(i24) ? null : cursor.getString(i24);
        int i25 = i + 26;
        String string18 = cursor.isNull(i25) ? null : cursor.getString(i25);
        int i26 = i + 27;
        String string19 = cursor.isNull(i26) ? null : cursor.getString(i26);
        int i27 = i + 28;
        String string20 = cursor.isNull(i27) ? null : cursor.getString(i27);
        int i28 = i + 29;
        String string21 = cursor.isNull(i28) ? null : cursor.getString(i28);
        int i29 = i + 30;
        String string22 = cursor.isNull(i29) ? null : cursor.getString(i29);
        int i30 = i + 31;
        String string23 = cursor.isNull(i30) ? null : cursor.getString(i30);
        int i31 = i + 32;
        String string24 = cursor.isNull(i31) ? null : cursor.getString(i31);
        int i32 = i + 33;
        String string25 = cursor.isNull(i32) ? null : cursor.getString(i32);
        int i33 = i + 34;
        String string26 = cursor.isNull(i33) ? null : cursor.getString(i33);
        int i34 = i + 35;
        String string27 = cursor.isNull(i34) ? null : cursor.getString(i34);
        int i35 = i + 36;
        String string28 = cursor.isNull(i35) ? null : cursor.getString(i35);
        int i36 = i + 37;
        String string29 = cursor.isNull(i36) ? null : cursor.getString(i36);
        int i37 = i + 38;
        String string30 = cursor.isNull(i37) ? null : cursor.getString(i37);
        int i38 = i + 39;
        String string31 = cursor.isNull(i38) ? null : cursor.getString(i38);
        int i39 = i + 40;
        String string32 = cursor.isNull(i39) ? null : cursor.getString(i39);
        int i40 = i + 41;
        String string33 = cursor.isNull(i40) ? null : cursor.getString(i40);
        int i41 = i + 42;
        String string34 = cursor.isNull(i41) ? null : cursor.getString(i41);
        int i42 = i + 43;
        String string35 = cursor.isNull(i42) ? null : cursor.getString(i42);
        int i43 = i + 44;
        String string36 = cursor.isNull(i43) ? null : cursor.getString(i43);
        int i44 = i + 45;
        String string37 = cursor.isNull(i44) ? null : cursor.getString(i44);
        int i45 = i + 46;
        String string38 = cursor.isNull(i45) ? null : cursor.getString(i45);
        int i46 = i + 47;
        return new C2628(j, string, string2, string3, string4, i6, i7, i8, string5, string6, j2, string7, i12, i13, z, i14, string8, string9, string10, string11, string12, string13, string14, string15, string16, string17, string18, string19, string20, string21, string22, string23, string24, string25, string26, string27, string28, string29, string30, string31, string32, string33, string34, string35, string36, string37, string38, cursor.isNull(i46) ? null : cursor.getString(i46));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: ԭ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public void readEntity(Cursor cursor, C2628 c2628, int i) {
        c2628.m9643(cursor.getLong(i + 0));
        int i2 = i + 1;
        c2628.m9640(cursor.isNull(i2) ? null : cursor.getString(i2));
        int i3 = i + 2;
        c2628.m9641(cursor.isNull(i3) ? null : cursor.getString(i3));
        int i4 = i + 3;
        c2628.m9682(cursor.isNull(i4) ? null : cursor.getString(i4));
        int i5 = i + 4;
        c2628.m9683(cursor.isNull(i5) ? null : cursor.getString(i5));
        c2628.m9642(cursor.getInt(i + 5));
        c2628.m9644(cursor.getInt(i + 6));
        c2628.m9678(cursor.getInt(i + 7));
        int i6 = i + 8;
        c2628.m9677(cursor.isNull(i6) ? null : cursor.getString(i6));
        int i7 = i + 9;
        c2628.m9638(cursor.isNull(i7) ? null : cursor.getString(i7));
        c2628.m9639(cursor.getLong(i + 10));
        int i8 = i + 11;
        c2628.m9637(cursor.isNull(i8) ? null : cursor.getString(i8));
        c2628.m9680(cursor.getInt(i + 12));
        c2628.m9681(cursor.getInt(i + 13));
        c2628.m9679(cursor.getShort(i + 14) != 0);
        c2628.m9684(cursor.getInt(i + 15));
        int i9 = i + 16;
        c2628.m9661(cursor.isNull(i9) ? null : cursor.getString(i9));
        int i10 = i + 17;
        c2628.m9658(cursor.isNull(i10) ? null : cursor.getString(i10));
        int i11 = i + 18;
        c2628.m9662(cursor.isNull(i11) ? null : cursor.getString(i11));
        int i12 = i + 19;
        c2628.m9664(cursor.isNull(i12) ? null : cursor.getString(i12));
        int i13 = i + 20;
        c2628.m9663(cursor.isNull(i13) ? null : cursor.getString(i13));
        int i14 = i + 21;
        c2628.m9655(cursor.isNull(i14) ? null : cursor.getString(i14));
        int i15 = i + 22;
        c2628.m9651(cursor.isNull(i15) ? null : cursor.getString(i15));
        int i16 = i + 23;
        c2628.m9650(cursor.isNull(i16) ? null : cursor.getString(i16));
        int i17 = i + 24;
        c2628.m9675(cursor.isNull(i17) ? null : cursor.getString(i17));
        int i18 = i + 25;
        c2628.m9648(cursor.isNull(i18) ? null : cursor.getString(i18));
        int i19 = i + 26;
        c2628.m9660(cursor.isNull(i19) ? null : cursor.getString(i19));
        int i20 = i + 27;
        c2628.m9671(cursor.isNull(i20) ? null : cursor.getString(i20));
        int i21 = i + 28;
        c2628.m9656(cursor.isNull(i21) ? null : cursor.getString(i21));
        int i22 = i + 29;
        c2628.m9676(cursor.isNull(i22) ? null : cursor.getString(i22));
        int i23 = i + 30;
        c2628.m9670(cursor.isNull(i23) ? null : cursor.getString(i23));
        int i24 = i + 31;
        c2628.m9667(cursor.isNull(i24) ? null : cursor.getString(i24));
        int i25 = i + 32;
        c2628.m9672(cursor.isNull(i25) ? null : cursor.getString(i25));
        int i26 = i + 33;
        c2628.m9668(cursor.isNull(i26) ? null : cursor.getString(i26));
        int i27 = i + 34;
        c2628.m9652(cursor.isNull(i27) ? null : cursor.getString(i27));
        int i28 = i + 35;
        c2628.m9669(cursor.isNull(i28) ? null : cursor.getString(i28));
        int i29 = i + 36;
        c2628.m9653(cursor.isNull(i29) ? null : cursor.getString(i29));
        int i30 = i + 37;
        c2628.m9673(cursor.isNull(i30) ? null : cursor.getString(i30));
        int i31 = i + 38;
        c2628.m9654(cursor.isNull(i31) ? null : cursor.getString(i31));
        int i32 = i + 39;
        c2628.m9647(cursor.isNull(i32) ? null : cursor.getString(i32));
        int i33 = i + 40;
        c2628.m9665(cursor.isNull(i33) ? null : cursor.getString(i33));
        int i34 = i + 41;
        c2628.m9646(cursor.isNull(i34) ? null : cursor.getString(i34));
        int i35 = i + 42;
        c2628.m9666(cursor.isNull(i35) ? null : cursor.getString(i35));
        int i36 = i + 43;
        c2628.m9657(cursor.isNull(i36) ? null : cursor.getString(i36));
        int i37 = i + 44;
        c2628.m9659(cursor.isNull(i37) ? null : cursor.getString(i37));
        int i38 = i + 45;
        c2628.m9649(cursor.isNull(i38) ? null : cursor.getString(i38));
        int i39 = i + 46;
        c2628.m9645(cursor.isNull(i39) ? null : cursor.getString(i39));
        int i40 = i + 47;
        c2628.m9674(cursor.isNull(i40) ? null : cursor.getString(i40));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: Ԯ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public Long readKey(Cursor cursor, int i) {
        return Long.valueOf(cursor.getLong(i + 0));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: ԯ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public final Long updateKeyAfterInsert(C2628 c2628, long j) {
        c2628.m9643(j);
        return Long.valueOf(j);
    }
}
