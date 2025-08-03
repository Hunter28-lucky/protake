package com.blink.academy.film.greendao;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteStatement;
import com.umeng.analytics.pro.am;
import com.umeng.analytics.pro.aq;
import defpackage.C3862;
import defpackage.C3891;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

/* loaded from: classes.dex */
public class PresetBeanDao extends AbstractDao<C3891, Long> {
    public static final String TABLENAME = "PRESET_BEAN";

    public static class Properties {
        public static final Property AlwaysOnAssistantsState;
        public static final Property AngelMode;
        public static final Property AudioLevel;
        public static final Property Audio_sample_rate;
        public static final Property AutoAssistantsState;
        public static final Property AutoCameraName;
        public static final Property AutoExposure;
        public static final Property BeautyBigEyesStrength;
        public static final Property BeautyBrightEyesStrength;
        public static final Property BeautyBrightStrength;
        public static final Property BeautyChinStrength;
        public static final Property BeautyEyeCircleStrength;
        public static final Property BeautyOn;
        public static final Property BeautySmoothStrength;
        public static final Property BeautyWhiteTeethStrength;
        public static final Property BlackPoint;
        public static final Property Brightness;
        public static final Property CameraName;
        public static final Property ConfigName;
        public static final Property ConfigVersion;
        public static final Property Contrast;
        public static final Property Crop_ratio_h;
        public static final Property Crop_ratio_w;
        public static final Property Crosshairs_state;
        public static final Property CurrentAutoFrontZoomPercent;
        public static final Property CurrentAutoZoomPercent;
        public static final Property CurrentContentNameFixId;
        public static final Property CurrentETValue;
        public static final Property CurrentEVPro;
        public static final Property CurrentExposure;
        public static final Property CurrentFocusPercent;
        public static final Property CurrentHz;
        public static final Property CurrentISO;
        public static final Property CurrentMicroPhoneType;
        public static final Property CurrentOpener;
        public static final Property CurrentZoomPercent;
        public static final Property DeviceAndroidVersion;
        public static final Property DeviceManufacturer;
        public static final Property DeviceModel;
        public static final Property DofAdapterState;
        public static final Property EdgeEnhancementType;
        public static final Property EnergyMode;
        public static final Property FrameDropNotice;
        public static final Property FrameRatioOffState;
        public static final Property HdmiCleanState;
        public static final Property Horizon_line_state;
        public static final Property Id;
        public static final Property InputModeState;
        public static final Property IsAudioAutoGain;
        public static final Property IsCurrent;
        public static final Property IsOnlyVideo;
        public static final Property IsoMode;
        public static final Property LeicaMode;
        public static final Property LocationSwitch;
        public static final Property LutStrength;
        public static final Property LutType;
        public static final Property MirrorSelfieState;
        public static final Property NeedCropOrigin;
        public static final Property NeedSafeCover;
        public static final Property NoiseReductionType;
        public static final Property Os;
        public static final Property OsVersion;
        public static final Property PerformanceState;
        public static final Property PortraitAFMode;
        public static final Property PortraitAFValue;
        public static final Property PortraitAperture;
        public static final Property PortraitFPS;
        public static final Property PortraitIsLidar;
        public static final Property PortraitRes;
        public static final Property Preview_fps;
        public static final Property ProMode;
        public static final Property RecBeeperState;
        public static final Property RecFlashState;
        public static final Property RecordMode;
        public static final Property RepeatMode;
        public static final Property Resolution_height;
        public static final Property Resolution_width;
        public static final Property Safe_area_value;
        public static final Property SelectState;
        public static final Property Stabilization;
        public static final Property TempA;
        public static final Property TempB;
        public static final Property Temperature;
        public static final Property Third_line_state;
        public static final Property Time_lapse;
        public static final Property TimecodeState;
        public static final Property Tint;
        public static final Property TintA;
        public static final Property TintB;
        public static final Property UpdateTime;
        public static final Property UserSpecifiedAudioSource;
        public static final Property VideoFormatMode;
        public static final Property Video_bit_rate_1080;
        public static final Property Video_bit_rate_4K;
        public static final Property Video_bit_rate_540;
        public static final Property Video_bit_rate_720;
        public static final Property Video_codec_mime;
        public static final Property Video_fps;
        public static final Property ViewsRecordMode;
        public static final Property VolumeKeyRecordState;
        public static final Property WaveMode;
        public static final Property WhiteBalanceMode;
        public static final Property WhitePoint;
        public static final Property ZoomMode;

        static {
            Class cls = Long.TYPE;
            Id = new Property(0, cls, "id", true, aq.d);
            Class cls2 = Boolean.TYPE;
            IsCurrent = new Property(1, cls2, "isCurrent", false, "IS_CURRENT");
            CameraName = new Property(2, String.class, "cameraName", false, "CAMERA_NAME");
            Class cls3 = Integer.TYPE;
            Resolution_width = new Property(3, cls3, "resolution_width", false, "RESOLUTION_WIDTH");
            Resolution_height = new Property(4, cls3, "resolution_height", false, "RESOLUTION_HEIGHT");
            Class cls4 = Float.TYPE;
            Crop_ratio_w = new Property(5, cls4, "crop_ratio_w", false, "CROP_RATIO_W");
            Crop_ratio_h = new Property(6, cls4, "crop_ratio_h", false, "CROP_RATIO_H");
            Horizon_line_state = new Property(7, cls3, "horizon_line_state", false, "HORIZON_LINE_STATE");
            Crosshairs_state = new Property(8, cls3, "crosshairs_state", false, "CROSSHAIRS_STATE");
            Third_line_state = new Property(9, cls3, "third_line_state", false, "THIRD_LINE_STATE");
            AlwaysOnAssistantsState = new Property(10, cls3, "alwaysOnAssistantsState", false, "ALWAYS_ON_ASSISTANTS_STATE");
            Video_bit_rate_540 = new Property(11, cls3, "video_bit_rate_540", false, "VIDEO_BIT_RATE_540");
            Video_bit_rate_720 = new Property(12, cls3, "video_bit_rate_720", false, "VIDEO_BIT_RATE_720");
            Video_bit_rate_1080 = new Property(13, cls3, "video_bit_rate_1080", false, "VIDEO_BIT_RATE_1080");
            Video_bit_rate_4K = new Property(14, cls3, "video_bit_rate_4K", false, "VIDEO_BIT_RATE_4_K");
            Safe_area_value = new Property(15, cls3, "safe_area_value", false, "SAFE_AREA_VALUE");
            Video_codec_mime = new Property(16, String.class, "video_codec_mime", false, "VIDEO_CODEC_MIME");
            Preview_fps = new Property(17, cls3, "preview_fps", false, "PREVIEW_FPS");
            Video_fps = new Property(18, cls3, "video_fps", false, "VIDEO_FPS");
            Time_lapse = new Property(19, cls3, "time_lapse", false, "TIME_LAPSE");
            Audio_sample_rate = new Property(20, cls3, "audio_sample_rate", false, "AUDIO_SAMPLE_RATE");
            ConfigName = new Property(21, String.class, "configName", false, "CONFIG_NAME");
            SelectState = new Property(22, cls3, "selectState", false, "SELECT_STATE");
            WhiteBalanceMode = new Property(23, cls3, "whiteBalanceMode", false, "WHITE_BALANCE_MODE");
            NoiseReductionType = new Property(24, cls3, "noiseReductionType", false, "NOISE_REDUCTION_TYPE");
            EdgeEnhancementType = new Property(25, cls3, "edgeEnhancementType", false, "EDGE_ENHANCEMENT_TYPE");
            Stabilization = new Property(26, cls3, "stabilization", false, "STABILIZATION");
            Tint = new Property(27, cls4, "tint", false, "TINT");
            Temperature = new Property(28, cls4, "temperature", false, "TEMPERATURE");
            TempA = new Property(29, cls4, "tempA", false, "TEMP_A");
            TempB = new Property(30, cls4, "tempB", false, "TEMP_B");
            TintA = new Property(31, cls4, "tintA", false, "TINT_A");
            TintB = new Property(32, cls4, "tintB", false, "TINT_B");
            WhitePoint = new Property(33, cls4, "whitePoint", false, "WHITE_POINT");
            BlackPoint = new Property(34, cls4, "blackPoint", false, "BLACK_POINT");
            Brightness = new Property(35, cls4, "brightness", false, "BRIGHTNESS");
            Contrast = new Property(36, cls4, "contrast", false, "CONTRAST");
            LutStrength = new Property(37, cls4, "lutStrength", false, "LUT_STRENGTH");
            LutType = new Property(38, cls3, "lutType", false, "LUT_TYPE");
            NeedCropOrigin = new Property(39, cls2, "needCropOrigin", false, "NEED_CROP_ORIGIN");
            IsOnlyVideo = new Property(40, cls2, "isOnlyVideo", false, "IS_ONLY_VIDEO");
            IsAudioAutoGain = new Property(41, cls2, "isAudioAutoGain", false, "IS_AUDIO_AUTO_GAIN");
            AudioLevel = new Property(42, cls4, "audioLevel", false, "AUDIO_LEVEL");
            CurrentMicroPhoneType = new Property(43, cls3, "currentMicroPhoneType", false, "CURRENT_MICRO_PHONE_TYPE");
            AutoExposure = new Property(44, cls2, "autoExposure", false, "AUTO_EXPOSURE");
            CurrentISO = new Property(45, cls4, "currentISO", false, "CURRENT_ISO");
            CurrentExposure = new Property(46, cls4, "currentExposure", false, "CURRENT_EXPOSURE");
            CurrentOpener = new Property(47, cls4, "currentOpener", false, "CURRENT_OPENER");
            CurrentFocusPercent = new Property(48, cls4, "currentFocusPercent", false, "CURRENT_FOCUS_PERCENT");
            CurrentZoomPercent = new Property(49, cls4, "currentZoomPercent", false, "CURRENT_ZOOM_PERCENT");
            CurrentETValue = new Property(50, cls3, "currentETValue", false, "CURRENT_ETVALUE");
            AngelMode = new Property(51, cls2, "angelMode", false, "ANGEL_MODE");
            ZoomMode = new Property(52, cls2, "zoomMode", false, "ZOOM_MODE");
            CurrentEVPro = new Property(53, cls4, "currentEVPro", false, "CURRENT_EVPRO");
            ProMode = new Property(54, cls2, "proMode", false, "PRO_MODE");
            CurrentContentNameFixId = new Property(55, cls3, "currentContentNameFixId", false, "CURRENT_CONTENT_NAME_FIX_ID");
            FrameDropNotice = new Property(56, cls3, "frameDropNotice", false, "FRAME_DROP_NOTICE");
            RecBeeperState = new Property(57, cls3, "recBeeperState", false, "REC_BEEPER_STATE");
            RecFlashState = new Property(58, cls3, "recFlashState", false, "REC_FLASH_STATE");
            RecordMode = new Property(59, cls3, "recordMode", false, "RECORD_MODE");
            CurrentHz = new Property(60, cls4, "currentHz", false, "CURRENT_HZ");
            Os = new Property(61, String.class, am.x, false, "OS");
            OsVersion = new Property(62, String.class, "osVersion", false, "OS_VERSION");
            DeviceModel = new Property(63, String.class, "deviceModel", false, "DEVICE_MODEL");
            DeviceManufacturer = new Property(64, String.class, "deviceManufacturer", false, "DEVICE_MANUFACTURER");
            DeviceAndroidVersion = new Property(65, String.class, "DeviceAndroidVersion", false, "DEVICE_ANDROID_VERSION");
            ConfigVersion = new Property(66, String.class, "configVersion", false, "CONFIG_VERSION");
            UpdateTime = new Property(67, cls, "updateTime", false, "UPDATE_TIME");
            WaveMode = new Property(68, cls3, "waveMode", false, "WAVE_MODE");
            RepeatMode = new Property(69, cls3, "repeatMode", false, "REPEAT_MODE");
            LeicaMode = new Property(70, cls3, "leicaMode", false, "LEICA_MODE");
            VideoFormatMode = new Property(71, cls3, "videoFormatMode", false, "VIDEO_FORMAT_MODE");
            InputModeState = new Property(72, cls3, "inputModeState", false, "INPUT_MODE_STATE");
            FrameRatioOffState = new Property(73, cls3, "frameRatioOffState", false, "FRAME_RATIO_OFF_STATE");
            LocationSwitch = new Property(74, cls3, "locationSwitch", false, "LOCATION_SWITCH");
            CurrentAutoZoomPercent = new Property(75, cls4, "currentAutoZoomPercent", false, "CURRENT_AUTO_ZOOM_PERCENT");
            CurrentAutoFrontZoomPercent = new Property(76, cls4, "currentAutoFrontZoomPercent", false, "CURRENT_AUTO_FRONT_ZOOM_PERCENT");
            IsoMode = new Property(77, cls2, "isoMode", false, "ISO_MODE");
            AutoCameraName = new Property(78, String.class, "autoCameraName", false, "AUTO_CAMERA_NAME");
            ViewsRecordMode = new Property(79, cls3, "viewsRecordMode", false, "VIEWS_RECORD_MODE");
            AutoAssistantsState = new Property(80, cls3, "autoAssistantsState", false, "AUTO_ASSISTANTS_STATE");
            VolumeKeyRecordState = new Property(81, cls3, "volumeKeyRecordState", false, "VOLUME_KEY_RECORD_STATE");
            DofAdapterState = new Property(82, cls3, "dofAdapterState", false, "DOF_ADAPTER_STATE");
            UserSpecifiedAudioSource = new Property(83, cls3, "userSpecifiedAudioSource", false, "USER_SPECIFIED_AUDIO_SOURCE");
            BeautyOn = new Property(84, cls2, "beautyOn", false, "BEAUTY_ON");
            BeautyBrightStrength = new Property(85, cls4, "beautyBrightStrength", false, "BEAUTY_BRIGHT_STRENGTH");
            BeautySmoothStrength = new Property(86, cls4, "beautySmoothStrength", false, "BEAUTY_SMOOTH_STRENGTH");
            BeautyChinStrength = new Property(87, cls4, "beautyChinStrength", false, "BEAUTY_CHIN_STRENGTH");
            BeautyBigEyesStrength = new Property(88, cls4, "beautyBigEyesStrength", false, "BEAUTY_BIG_EYES_STRENGTH");
            BeautyEyeCircleStrength = new Property(89, cls4, "beautyEyeCircleStrength", false, "BEAUTY_EYE_CIRCLE_STRENGTH");
            BeautyWhiteTeethStrength = new Property(90, cls4, "beautyWhiteTeethStrength", false, "BEAUTY_WHITE_TEETH_STRENGTH");
            BeautyBrightEyesStrength = new Property(91, cls4, "beautyBrightEyesStrength", false, "BEAUTY_BRIGHT_EYES_STRENGTH");
            MirrorSelfieState = new Property(92, cls3, "mirrorSelfieState", false, "MIRROR_SELFIE_STATE");
            PortraitRes = new Property(93, cls3, "portraitRes", false, "PORTRAIT_RES");
            PortraitFPS = new Property(94, cls3, "portraitFPS", false, "PORTRAIT_FPS");
            PortraitAperture = new Property(95, cls4, "portraitAperture", false, "PORTRAIT_APERTURE");
            PortraitAFMode = new Property(96, cls3, "portraitAFMode", false, "PORTRAIT_AFMODE");
            PortraitAFValue = new Property(97, cls4, "portraitAFValue", false, "PORTRAIT_AFVALUE");
            PortraitIsLidar = new Property(98, cls3, "portraitIsLidar", false, "PORTRAIT_IS_LIDAR");
            NeedSafeCover = new Property(99, cls2, "needSafeCover", false, "NEED_SAFE_COVER");
            HdmiCleanState = new Property(100, cls3, "hdmiCleanState", false, "HDMI_CLEAN_STATE");
            PerformanceState = new Property(101, cls3, "performanceState", false, "PERFORMANCE_STATE");
            TimecodeState = new Property(102, cls3, "timecodeState", false, "TIMECODE_STATE");
            EnergyMode = new Property(103, cls3, "energyMode", false, "ENERGY_MODE");
        }
    }

    public PresetBeanDao(DaoConfig daoConfig, C3862 c3862) {
        super(daoConfig, c3862);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static void m585(Database database, boolean z) throws SQLException {
        database.execSQL("CREATE TABLE " + (z ? "IF NOT EXISTS " : "") + "\"PRESET_BEAN\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ,\"IS_CURRENT\" INTEGER NOT NULL ,\"CAMERA_NAME\" TEXT,\"RESOLUTION_WIDTH\" INTEGER NOT NULL ,\"RESOLUTION_HEIGHT\" INTEGER NOT NULL ,\"CROP_RATIO_W\" REAL NOT NULL ,\"CROP_RATIO_H\" REAL NOT NULL ,\"HORIZON_LINE_STATE\" INTEGER NOT NULL ,\"CROSSHAIRS_STATE\" INTEGER NOT NULL ,\"THIRD_LINE_STATE\" INTEGER NOT NULL ,\"ALWAYS_ON_ASSISTANTS_STATE\" INTEGER NOT NULL ,\"VIDEO_BIT_RATE_540\" INTEGER NOT NULL ,\"VIDEO_BIT_RATE_720\" INTEGER NOT NULL ,\"VIDEO_BIT_RATE_1080\" INTEGER NOT NULL ,\"VIDEO_BIT_RATE_4_K\" INTEGER NOT NULL ,\"SAFE_AREA_VALUE\" INTEGER NOT NULL ,\"VIDEO_CODEC_MIME\" TEXT,\"PREVIEW_FPS\" INTEGER NOT NULL ,\"VIDEO_FPS\" INTEGER NOT NULL ,\"TIME_LAPSE\" INTEGER NOT NULL ,\"AUDIO_SAMPLE_RATE\" INTEGER NOT NULL ,\"CONFIG_NAME\" TEXT,\"SELECT_STATE\" INTEGER NOT NULL ,\"WHITE_BALANCE_MODE\" INTEGER NOT NULL ,\"NOISE_REDUCTION_TYPE\" INTEGER NOT NULL ,\"EDGE_ENHANCEMENT_TYPE\" INTEGER NOT NULL ,\"STABILIZATION\" INTEGER NOT NULL ,\"TINT\" REAL NOT NULL ,\"TEMPERATURE\" REAL NOT NULL ,\"TEMP_A\" REAL NOT NULL ,\"TEMP_B\" REAL NOT NULL ,\"TINT_A\" REAL NOT NULL ,\"TINT_B\" REAL NOT NULL ,\"WHITE_POINT\" REAL NOT NULL ,\"BLACK_POINT\" REAL NOT NULL ,\"BRIGHTNESS\" REAL NOT NULL ,\"CONTRAST\" REAL NOT NULL ,\"LUT_STRENGTH\" REAL NOT NULL ,\"LUT_TYPE\" INTEGER NOT NULL ,\"NEED_CROP_ORIGIN\" INTEGER NOT NULL ,\"IS_ONLY_VIDEO\" INTEGER NOT NULL ,\"IS_AUDIO_AUTO_GAIN\" INTEGER NOT NULL ,\"AUDIO_LEVEL\" REAL NOT NULL ,\"CURRENT_MICRO_PHONE_TYPE\" INTEGER NOT NULL ,\"AUTO_EXPOSURE\" INTEGER NOT NULL ,\"CURRENT_ISO\" REAL NOT NULL ,\"CURRENT_EXPOSURE\" REAL NOT NULL ,\"CURRENT_OPENER\" REAL NOT NULL ,\"CURRENT_FOCUS_PERCENT\" REAL NOT NULL ,\"CURRENT_ZOOM_PERCENT\" REAL NOT NULL ,\"CURRENT_ETVALUE\" INTEGER NOT NULL ,\"ANGEL_MODE\" INTEGER NOT NULL ,\"ZOOM_MODE\" INTEGER NOT NULL ,\"CURRENT_EVPRO\" REAL NOT NULL ,\"PRO_MODE\" INTEGER NOT NULL ,\"CURRENT_CONTENT_NAME_FIX_ID\" INTEGER NOT NULL ,\"FRAME_DROP_NOTICE\" INTEGER NOT NULL ,\"REC_BEEPER_STATE\" INTEGER NOT NULL ,\"REC_FLASH_STATE\" INTEGER NOT NULL ,\"RECORD_MODE\" INTEGER NOT NULL ,\"CURRENT_HZ\" REAL NOT NULL ,\"OS\" TEXT,\"OS_VERSION\" TEXT,\"DEVICE_MODEL\" TEXT,\"DEVICE_MANUFACTURER\" TEXT,\"DEVICE_ANDROID_VERSION\" TEXT,\"CONFIG_VERSION\" TEXT,\"UPDATE_TIME\" INTEGER NOT NULL ,\"WAVE_MODE\" INTEGER NOT NULL ,\"REPEAT_MODE\" INTEGER NOT NULL ,\"LEICA_MODE\" INTEGER NOT NULL ,\"VIDEO_FORMAT_MODE\" INTEGER NOT NULL ,\"INPUT_MODE_STATE\" INTEGER NOT NULL ,\"FRAME_RATIO_OFF_STATE\" INTEGER NOT NULL ,\"LOCATION_SWITCH\" INTEGER NOT NULL ,\"CURRENT_AUTO_ZOOM_PERCENT\" REAL NOT NULL ,\"CURRENT_AUTO_FRONT_ZOOM_PERCENT\" REAL NOT NULL ,\"ISO_MODE\" INTEGER NOT NULL ,\"AUTO_CAMERA_NAME\" TEXT,\"VIEWS_RECORD_MODE\" INTEGER NOT NULL ,\"AUTO_ASSISTANTS_STATE\" INTEGER NOT NULL ,\"VOLUME_KEY_RECORD_STATE\" INTEGER NOT NULL ,\"DOF_ADAPTER_STATE\" INTEGER NOT NULL ,\"USER_SPECIFIED_AUDIO_SOURCE\" INTEGER NOT NULL ,\"BEAUTY_ON\" INTEGER NOT NULL ,\"BEAUTY_BRIGHT_STRENGTH\" REAL NOT NULL ,\"BEAUTY_SMOOTH_STRENGTH\" REAL NOT NULL ,\"BEAUTY_CHIN_STRENGTH\" REAL NOT NULL ,\"BEAUTY_BIG_EYES_STRENGTH\" REAL NOT NULL ,\"BEAUTY_EYE_CIRCLE_STRENGTH\" REAL NOT NULL ,\"BEAUTY_WHITE_TEETH_STRENGTH\" REAL NOT NULL ,\"BEAUTY_BRIGHT_EYES_STRENGTH\" REAL NOT NULL ,\"MIRROR_SELFIE_STATE\" INTEGER NOT NULL ,\"PORTRAIT_RES\" INTEGER NOT NULL ,\"PORTRAIT_FPS\" INTEGER NOT NULL ,\"PORTRAIT_APERTURE\" REAL NOT NULL ,\"PORTRAIT_AFMODE\" INTEGER NOT NULL ,\"PORTRAIT_AFVALUE\" REAL NOT NULL ,\"PORTRAIT_IS_LIDAR\" INTEGER NOT NULL ,\"NEED_SAFE_COVER\" INTEGER NOT NULL ,\"HDMI_CLEAN_STATE\" INTEGER NOT NULL ,\"PERFORMANCE_STATE\" INTEGER NOT NULL ,\"TIMECODE_STATE\" INTEGER NOT NULL ,\"ENERGY_MODE\" INTEGER NOT NULL );");
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static void m586(Database database, boolean z) throws SQLException {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"PRESET_BEAN\"");
        database.execSQL(sb.toString());
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public final boolean isEntityUpdateable() {
        return true;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public final void bindValues(SQLiteStatement sQLiteStatement, C3891 c3891) {
        sQLiteStatement.clearBindings();
        sQLiteStatement.bindLong(1, c3891.m12428());
        sQLiteStatement.bindLong(2, c3891.m12431() ? 1L : 0L);
        String strM12399 = c3891.m12399();
        if (strM12399 != null) {
            sQLiteStatement.bindString(3, strM12399);
        }
        sQLiteStatement.bindLong(4, c3891.m12463());
        sQLiteStatement.bindLong(5, c3891.m12462());
        sQLiteStatement.bindDouble(6, c3891.m12404());
        sQLiteStatement.bindDouble(7, c3891.m12403());
        sQLiteStatement.bindLong(8, c3891.m12427());
        sQLiteStatement.bindLong(9, c3891.m12405());
        sQLiteStatement.bindLong(10, c3891.m12470());
        sQLiteStatement.bindLong(11, c3891.m12375());
        sQLiteStatement.bindLong(12, c3891.m12481());
        sQLiteStatement.bindLong(13, c3891.m12482());
        sQLiteStatement.bindLong(14, c3891.m12479());
        sQLiteStatement.bindLong(15, c3891.m12480());
        sQLiteStatement.bindLong(16, c3891.m12464());
        String strM12483 = c3891.m12483();
        if (strM12483 != null) {
            sQLiteStatement.bindString(17, strM12483);
        }
        sQLiteStatement.bindLong(18, c3891.m12456());
        sQLiteStatement.bindLong(19, c3891.m12484());
        sQLiteStatement.bindLong(20, c3891.m12471());
        sQLiteStatement.bindLong(21, c3891.m12378());
        String strM12400 = c3891.m12400();
        if (strM12400 != null) {
            sQLiteStatement.bindString(22, strM12400);
        }
        sQLiteStatement.bindLong(23, c3891.m12465());
        sQLiteStatement.bindLong(24, c3891.m12488());
        sQLiteStatement.bindLong(25, c3891.m12446());
        sQLiteStatement.bindLong(26, c3891.m12422());
        sQLiteStatement.bindLong(27, c3891.m12466());
        sQLiteStatement.bindDouble(28, c3891.m12473());
        sQLiteStatement.bindDouble(29, c3891.m12469());
        sQLiteStatement.bindDouble(30, c3891.m12467());
        sQLiteStatement.bindDouble(31, c3891.m12468());
        sQLiteStatement.bindDouble(32, c3891.m12474());
        sQLiteStatement.bindDouble(33, c3891.m12475());
        sQLiteStatement.bindDouble(34, c3891.m12489());
        sQLiteStatement.bindDouble(35, c3891.m12397());
        sQLiteStatement.bindDouble(36, c3891.m12398());
        sQLiteStatement.bindDouble(37, c3891.m12402());
        sQLiteStatement.bindDouble(38, c3891.m12438());
        sQLiteStatement.bindLong(39, c3891.m12442());
        sQLiteStatement.bindLong(40, c3891.m12444() ? 1L : 0L);
        sQLiteStatement.bindLong(41, c3891.m12432() ? 1L : 0L);
        sQLiteStatement.bindLong(42, c3891.m12430() ? 1L : 0L);
        sQLiteStatement.bindDouble(43, c3891.m12377());
        sQLiteStatement.bindLong(44, c3891.m12415());
        sQLiteStatement.bindLong(45, c3891.m12381() ? 1L : 0L);
        sQLiteStatement.bindDouble(46, c3891.m12414());
        sQLiteStatement.bindDouble(47, c3891.m12411());
        sQLiteStatement.bindDouble(48, c3891.m12416());
        sQLiteStatement.bindDouble(49, c3891.m12412());
        sQLiteStatement.bindDouble(50, c3891.m12417());
        sQLiteStatement.bindLong(51, c3891.m12409());
        sQLiteStatement.bindLong(52, c3891.m12376() ? 1L : 0L);
        sQLiteStatement.bindLong(53, c3891.m12490() ? 1L : 0L);
        sQLiteStatement.bindDouble(54, c3891.m12410());
        sQLiteStatement.bindLong(55, c3891.m12457() ? 1L : 0L);
        sQLiteStatement.bindLong(56, c3891.m12408());
        sQLiteStatement.bindLong(57, c3891.m12424());
        sQLiteStatement.bindLong(58, c3891.m12458());
        sQLiteStatement.bindLong(59, c3891.m12459());
        sQLiteStatement.bindLong(60, c3891.m12460());
        sQLiteStatement.bindDouble(61, c3891.m12413());
        String strM12447 = c3891.m12447();
        if (strM12447 != null) {
            sQLiteStatement.bindString(62, strM12447);
        }
        String strM12448 = c3891.m12448();
        if (strM12448 != null) {
            sQLiteStatement.bindString(63, strM12448);
        }
        String strM12420 = c3891.m12420();
        if (strM12420 != null) {
            sQLiteStatement.bindString(64, strM12420);
        }
        String strM12419 = c3891.m12419();
        if (strM12419 != null) {
            sQLiteStatement.bindString(65, strM12419);
        }
        String strM12418 = c3891.m12418();
        if (strM12418 != null) {
            sQLiteStatement.bindString(66, strM12418);
        }
        String strM12401 = c3891.m12401();
        if (strM12401 != null) {
            sQLiteStatement.bindString(67, strM12401);
        }
        sQLiteStatement.bindLong(68, c3891.m12476());
        sQLiteStatement.bindLong(69, c3891.m12487());
        sQLiteStatement.bindLong(70, c3891.m12461());
        sQLiteStatement.bindLong(71, c3891.m12434());
        sQLiteStatement.bindLong(72, c3891.m12478());
        sQLiteStatement.bindLong(73, c3891.m12429());
        sQLiteStatement.bindLong(74, c3891.m12425());
        sQLiteStatement.bindLong(75, c3891.m12437());
        sQLiteStatement.bindDouble(76, c3891.m12407());
        sQLiteStatement.bindDouble(77, c3891.m12406());
        sQLiteStatement.bindLong(78, c3891.m12433() ? 1L : 0L);
        String strM12380 = c3891.m12380();
        if (strM12380 != null) {
            sQLiteStatement.bindString(79, strM12380);
        }
        sQLiteStatement.bindLong(80, c3891.m12485());
        sQLiteStatement.bindLong(81, c3891.m12379());
        sQLiteStatement.bindLong(82, c3891.m12486());
        sQLiteStatement.bindLong(83, c3891.m12421());
        sQLiteStatement.bindLong(84, c3891.m12477());
        sQLiteStatement.bindLong(85, c3891.m12389() ? 1L : 0L);
        sQLiteStatement.bindDouble(86, c3891.m12385());
        sQLiteStatement.bindDouble(87, c3891.m12390());
        sQLiteStatement.bindDouble(88, c3891.m12386());
        sQLiteStatement.bindDouble(89, c3891.m12382());
        sQLiteStatement.bindDouble(90, c3891.m12387());
        sQLiteStatement.bindDouble(91, c3891.m12396());
        sQLiteStatement.bindDouble(92, c3891.m12383());
        sQLiteStatement.bindLong(93, c3891.m12443());
        sQLiteStatement.bindLong(94, c3891.m12455());
        sQLiteStatement.bindLong(95, c3891.m12453());
        sQLiteStatement.bindDouble(96, c3891.m12452());
        sQLiteStatement.bindLong(97, c3891.m12450());
        sQLiteStatement.bindDouble(98, c3891.m12451());
        sQLiteStatement.bindLong(99, c3891.m12454());
        sQLiteStatement.bindLong(100, c3891.m12445() ? 1L : 0L);
        sQLiteStatement.bindLong(101, c3891.m12426());
        sQLiteStatement.bindLong(102, c3891.m12449());
        sQLiteStatement.bindLong(103, c3891.m12472());
        sQLiteStatement.bindLong(104, c3891.m12423());
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: Ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public final void bindValues(DatabaseStatement databaseStatement, C3891 c3891) {
        databaseStatement.clearBindings();
        databaseStatement.bindLong(1, c3891.m12428());
        databaseStatement.bindLong(2, c3891.m12431() ? 1L : 0L);
        String strM12399 = c3891.m12399();
        if (strM12399 != null) {
            databaseStatement.bindString(3, strM12399);
        }
        databaseStatement.bindLong(4, c3891.m12463());
        databaseStatement.bindLong(5, c3891.m12462());
        databaseStatement.bindDouble(6, c3891.m12404());
        databaseStatement.bindDouble(7, c3891.m12403());
        databaseStatement.bindLong(8, c3891.m12427());
        databaseStatement.bindLong(9, c3891.m12405());
        databaseStatement.bindLong(10, c3891.m12470());
        databaseStatement.bindLong(11, c3891.m12375());
        databaseStatement.bindLong(12, c3891.m12481());
        databaseStatement.bindLong(13, c3891.m12482());
        databaseStatement.bindLong(14, c3891.m12479());
        databaseStatement.bindLong(15, c3891.m12480());
        databaseStatement.bindLong(16, c3891.m12464());
        String strM12483 = c3891.m12483();
        if (strM12483 != null) {
            databaseStatement.bindString(17, strM12483);
        }
        databaseStatement.bindLong(18, c3891.m12456());
        databaseStatement.bindLong(19, c3891.m12484());
        databaseStatement.bindLong(20, c3891.m12471());
        databaseStatement.bindLong(21, c3891.m12378());
        String strM12400 = c3891.m12400();
        if (strM12400 != null) {
            databaseStatement.bindString(22, strM12400);
        }
        databaseStatement.bindLong(23, c3891.m12465());
        databaseStatement.bindLong(24, c3891.m12488());
        databaseStatement.bindLong(25, c3891.m12446());
        databaseStatement.bindLong(26, c3891.m12422());
        databaseStatement.bindLong(27, c3891.m12466());
        databaseStatement.bindDouble(28, c3891.m12473());
        databaseStatement.bindDouble(29, c3891.m12469());
        databaseStatement.bindDouble(30, c3891.m12467());
        databaseStatement.bindDouble(31, c3891.m12468());
        databaseStatement.bindDouble(32, c3891.m12474());
        databaseStatement.bindDouble(33, c3891.m12475());
        databaseStatement.bindDouble(34, c3891.m12489());
        databaseStatement.bindDouble(35, c3891.m12397());
        databaseStatement.bindDouble(36, c3891.m12398());
        databaseStatement.bindDouble(37, c3891.m12402());
        databaseStatement.bindDouble(38, c3891.m12438());
        databaseStatement.bindLong(39, c3891.m12442());
        databaseStatement.bindLong(40, c3891.m12444() ? 1L : 0L);
        databaseStatement.bindLong(41, c3891.m12432() ? 1L : 0L);
        databaseStatement.bindLong(42, c3891.m12430() ? 1L : 0L);
        databaseStatement.bindDouble(43, c3891.m12377());
        databaseStatement.bindLong(44, c3891.m12415());
        databaseStatement.bindLong(45, c3891.m12381() ? 1L : 0L);
        databaseStatement.bindDouble(46, c3891.m12414());
        databaseStatement.bindDouble(47, c3891.m12411());
        databaseStatement.bindDouble(48, c3891.m12416());
        databaseStatement.bindDouble(49, c3891.m12412());
        databaseStatement.bindDouble(50, c3891.m12417());
        databaseStatement.bindLong(51, c3891.m12409());
        databaseStatement.bindLong(52, c3891.m12376() ? 1L : 0L);
        databaseStatement.bindLong(53, c3891.m12490() ? 1L : 0L);
        databaseStatement.bindDouble(54, c3891.m12410());
        databaseStatement.bindLong(55, c3891.m12457() ? 1L : 0L);
        databaseStatement.bindLong(56, c3891.m12408());
        databaseStatement.bindLong(57, c3891.m12424());
        databaseStatement.bindLong(58, c3891.m12458());
        databaseStatement.bindLong(59, c3891.m12459());
        databaseStatement.bindLong(60, c3891.m12460());
        databaseStatement.bindDouble(61, c3891.m12413());
        String strM12447 = c3891.m12447();
        if (strM12447 != null) {
            databaseStatement.bindString(62, strM12447);
        }
        String strM12448 = c3891.m12448();
        if (strM12448 != null) {
            databaseStatement.bindString(63, strM12448);
        }
        String strM12420 = c3891.m12420();
        if (strM12420 != null) {
            databaseStatement.bindString(64, strM12420);
        }
        String strM12419 = c3891.m12419();
        if (strM12419 != null) {
            databaseStatement.bindString(65, strM12419);
        }
        String strM12418 = c3891.m12418();
        if (strM12418 != null) {
            databaseStatement.bindString(66, strM12418);
        }
        String strM12401 = c3891.m12401();
        if (strM12401 != null) {
            databaseStatement.bindString(67, strM12401);
        }
        databaseStatement.bindLong(68, c3891.m12476());
        databaseStatement.bindLong(69, c3891.m12487());
        databaseStatement.bindLong(70, c3891.m12461());
        databaseStatement.bindLong(71, c3891.m12434());
        databaseStatement.bindLong(72, c3891.m12478());
        databaseStatement.bindLong(73, c3891.m12429());
        databaseStatement.bindLong(74, c3891.m12425());
        databaseStatement.bindLong(75, c3891.m12437());
        databaseStatement.bindDouble(76, c3891.m12407());
        databaseStatement.bindDouble(77, c3891.m12406());
        databaseStatement.bindLong(78, c3891.m12433() ? 1L : 0L);
        String strM12380 = c3891.m12380();
        if (strM12380 != null) {
            databaseStatement.bindString(79, strM12380);
        }
        databaseStatement.bindLong(80, c3891.m12485());
        databaseStatement.bindLong(81, c3891.m12379());
        databaseStatement.bindLong(82, c3891.m12486());
        databaseStatement.bindLong(83, c3891.m12421());
        databaseStatement.bindLong(84, c3891.m12477());
        databaseStatement.bindLong(85, c3891.m12389() ? 1L : 0L);
        databaseStatement.bindDouble(86, c3891.m12385());
        databaseStatement.bindDouble(87, c3891.m12390());
        databaseStatement.bindDouble(88, c3891.m12386());
        databaseStatement.bindDouble(89, c3891.m12382());
        databaseStatement.bindDouble(90, c3891.m12387());
        databaseStatement.bindDouble(91, c3891.m12396());
        databaseStatement.bindDouble(92, c3891.m12383());
        databaseStatement.bindLong(93, c3891.m12443());
        databaseStatement.bindLong(94, c3891.m12455());
        databaseStatement.bindLong(95, c3891.m12453());
        databaseStatement.bindDouble(96, c3891.m12452());
        databaseStatement.bindLong(97, c3891.m12450());
        databaseStatement.bindDouble(98, c3891.m12451());
        databaseStatement.bindLong(99, c3891.m12454());
        databaseStatement.bindLong(100, c3891.m12445() ? 1L : 0L);
        databaseStatement.bindLong(101, c3891.m12426());
        databaseStatement.bindLong(102, c3891.m12449());
        databaseStatement.bindLong(103, c3891.m12472());
        databaseStatement.bindLong(104, c3891.m12423());
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: ԫ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public Long getKey(C3891 c3891) {
        if (c3891 != null) {
            return Long.valueOf(c3891.m12428());
        }
        return null;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: Ԭ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public C3891 readEntity(Cursor cursor, int i) {
        long j = cursor.getLong(i + 0);
        boolean z = cursor.getShort(i + 1) != 0;
        int i2 = i + 2;
        String string = cursor.isNull(i2) ? null : cursor.getString(i2);
        int i3 = cursor.getInt(i + 3);
        int i4 = cursor.getInt(i + 4);
        float f = cursor.getFloat(i + 5);
        float f2 = cursor.getFloat(i + 6);
        int i5 = cursor.getInt(i + 7);
        int i6 = cursor.getInt(i + 8);
        int i7 = cursor.getInt(i + 9);
        int i8 = cursor.getInt(i + 10);
        int i9 = cursor.getInt(i + 11);
        int i10 = cursor.getInt(i + 12);
        int i11 = cursor.getInt(i + 13);
        int i12 = cursor.getInt(i + 14);
        int i13 = cursor.getInt(i + 15);
        int i14 = i + 16;
        String string2 = cursor.isNull(i14) ? null : cursor.getString(i14);
        int i15 = cursor.getInt(i + 17);
        int i16 = cursor.getInt(i + 18);
        int i17 = cursor.getInt(i + 19);
        int i18 = cursor.getInt(i + 20);
        int i19 = i + 21;
        String string3 = cursor.isNull(i19) ? null : cursor.getString(i19);
        int i20 = cursor.getInt(i + 22);
        int i21 = cursor.getInt(i + 23);
        int i22 = cursor.getInt(i + 24);
        int i23 = cursor.getInt(i + 25);
        int i24 = cursor.getInt(i + 26);
        float f3 = cursor.getFloat(i + 27);
        float f4 = cursor.getFloat(i + 28);
        float f5 = cursor.getFloat(i + 29);
        float f6 = cursor.getFloat(i + 30);
        float f7 = cursor.getFloat(i + 31);
        float f8 = cursor.getFloat(i + 32);
        float f9 = cursor.getFloat(i + 33);
        float f10 = cursor.getFloat(i + 34);
        float f11 = cursor.getFloat(i + 35);
        float f12 = cursor.getFloat(i + 36);
        float f13 = cursor.getFloat(i + 37);
        int i25 = cursor.getInt(i + 38);
        boolean z2 = cursor.getShort(i + 39) != 0;
        boolean z3 = cursor.getShort(i + 40) != 0;
        boolean z4 = cursor.getShort(i + 41) != 0;
        float f14 = cursor.getFloat(i + 42);
        int i26 = cursor.getInt(i + 43);
        boolean z5 = cursor.getShort(i + 44) != 0;
        float f15 = cursor.getFloat(i + 45);
        float f16 = cursor.getFloat(i + 46);
        float f17 = cursor.getFloat(i + 47);
        float f18 = cursor.getFloat(i + 48);
        float f19 = cursor.getFloat(i + 49);
        int i27 = cursor.getInt(i + 50);
        boolean z6 = cursor.getShort(i + 51) != 0;
        boolean z7 = cursor.getShort(i + 52) != 0;
        float f20 = cursor.getFloat(i + 53);
        boolean z8 = cursor.getShort(i + 54) != 0;
        int i28 = cursor.getInt(i + 55);
        int i29 = cursor.getInt(i + 56);
        int i30 = cursor.getInt(i + 57);
        int i31 = cursor.getInt(i + 58);
        int i32 = cursor.getInt(i + 59);
        float f21 = cursor.getFloat(i + 60);
        int i33 = i + 61;
        String string4 = cursor.isNull(i33) ? null : cursor.getString(i33);
        int i34 = i + 62;
        String string5 = cursor.isNull(i34) ? null : cursor.getString(i34);
        int i35 = i + 63;
        String string6 = cursor.isNull(i35) ? null : cursor.getString(i35);
        int i36 = i + 64;
        String string7 = cursor.isNull(i36) ? null : cursor.getString(i36);
        int i37 = i + 65;
        String string8 = cursor.isNull(i37) ? null : cursor.getString(i37);
        int i38 = i + 66;
        String string9 = cursor.isNull(i38) ? null : cursor.getString(i38);
        int i39 = i + 78;
        return new C3891(j, z, string, i3, i4, f, f2, i5, i6, i7, i8, i9, i10, i11, i12, i13, string2, i15, i16, i17, i18, string3, i20, i21, i22, i23, i24, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, i25, z2, z3, z4, f14, i26, z5, f15, f16, f17, f18, f19, i27, z6, z7, f20, z8, i28, i29, i30, i31, i32, f21, string4, string5, string6, string7, string8, string9, cursor.getLong(i + 67), cursor.getInt(i + 68), cursor.getInt(i + 69), cursor.getInt(i + 70), cursor.getInt(i + 71), cursor.getInt(i + 72), cursor.getInt(i + 73), cursor.getInt(i + 74), cursor.getFloat(i + 75), cursor.getFloat(i + 76), cursor.getShort(i + 77) != 0, cursor.isNull(i39) ? null : cursor.getString(i39), cursor.getInt(i + 79), cursor.getInt(i + 80), cursor.getInt(i + 81), cursor.getInt(i + 82), cursor.getInt(i + 83), cursor.getShort(i + 84) != 0, cursor.getFloat(i + 85), cursor.getFloat(i + 86), cursor.getFloat(i + 87), cursor.getFloat(i + 88), cursor.getFloat(i + 89), cursor.getFloat(i + 90), cursor.getFloat(i + 91), cursor.getInt(i + 92), cursor.getInt(i + 93), cursor.getInt(i + 94), cursor.getFloat(i + 95), cursor.getInt(i + 96), cursor.getFloat(i + 97), cursor.getInt(i + 98), cursor.getShort(i + 99) != 0, cursor.getInt(i + 100), cursor.getInt(i + 101), cursor.getInt(i + 102), cursor.getInt(i + 103));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: ԭ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public void readEntity(Cursor cursor, C3891 c3891, int i) {
        c3891.m12544(cursor.getLong(i + 0));
        c3891.m12547(cursor.getShort(i + 1) != 0);
        int i2 = i + 2;
        c3891.m12515(cursor.isNull(i2) ? null : cursor.getString(i2));
        c3891.m12358(cursor.getInt(i + 3));
        c3891.m12357(cursor.getInt(i + 4));
        c3891.m12520(cursor.getFloat(i + 5));
        c3891.m12519(cursor.getFloat(i + 6));
        c3891.m12543(cursor.getInt(i + 7));
        c3891.m12521(cursor.getInt(i + 8));
        c3891.m12435(cursor.getInt(i + 9));
        c3891.m12497(cursor.getInt(i + 10));
        c3891.m12344(cursor.getInt(i + 11));
        c3891.m12348(cursor.getInt(i + 12));
        c3891.m12349(cursor.getInt(i + 13));
        c3891.m12351(cursor.getInt(i + 14));
        c3891.m12352(cursor.getInt(i + 15));
        int i3 = i + 16;
        c3891.m12553(cursor.isNull(i3) ? null : cursor.getString(i3));
        c3891.m12354(cursor.getInt(i + 17));
        c3891.m12395(cursor.getInt(i + 18));
        c3891.m12436(cursor.getInt(i + 19));
        c3891.m12501(cursor.getInt(i + 20));
        int i4 = i + 21;
        c3891.m12516(cursor.isNull(i4) ? null : cursor.getString(i4));
        c3891.m12374(cursor.getInt(i + 22));
        c3891.m12392(cursor.getInt(i + 23));
        c3891.m12365(cursor.getInt(i + 24));
        c3891.m12538(cursor.getInt(i + 25));
        c3891.m12355(cursor.getInt(i + 26));
        c3891.m12373(cursor.getFloat(i + 27));
        c3891.m12347(cursor.getFloat(i + 28));
        c3891.m12372(cursor.getFloat(i + 29));
        c3891.m12369(cursor.getFloat(i + 30));
        c3891.m12370(cursor.getFloat(i + 31));
        c3891.m12371(cursor.getFloat(i + 32));
        c3891.m12391(cursor.getFloat(i + 33));
        c3891.m12513(cursor.getFloat(i + 34));
        c3891.m12514(cursor.getFloat(i + 35));
        c3891.m12518(cursor.getFloat(i + 36));
        c3891.m12552(cursor.getFloat(i + 37));
        c3891.m12554(cursor.getInt(i + 38));
        c3891.m12556(cursor.getShort(i + 39) != 0);
        c3891.m12548(cursor.getShort(i + 40) != 0);
        c3891.m12546(cursor.getShort(i + 41) != 0);
        c3891.m12500(cursor.getFloat(i + 42));
        c3891.m12531(cursor.getInt(i + 43));
        c3891.m12504(cursor.getShort(i + 44) != 0);
        c3891.m12530(cursor.getFloat(i + 45));
        c3891.m12527(cursor.getFloat(i + 46));
        c3891.m12532(cursor.getFloat(i + 47));
        c3891.m12528(cursor.getFloat(i + 48));
        c3891.m12533(cursor.getFloat(i + 49));
        c3891.m12525(cursor.getInt(i + 50));
        c3891.m12498(cursor.getShort(i + 51) != 0);
        c3891.m12393(cursor.getShort(i + 52) != 0);
        c3891.m12526(cursor.getFloat(i + 53));
        c3891.m12363(cursor.getShort(i + 54) != 0);
        c3891.m12524(cursor.getInt(i + 55));
        c3891.m12540(cursor.getInt(i + 56));
        c3891.m12384(cursor.getInt(i + 57));
        c3891.m12360(cursor.getInt(i + 58));
        c3891.m12359(cursor.getInt(i + 59));
        c3891.m12529(cursor.getFloat(i + 60));
        int i5 = i + 61;
        c3891.m12366(cursor.isNull(i5) ? null : cursor.getString(i5));
        int i6 = i + 62;
        c3891.m12394(cursor.isNull(i6) ? null : cursor.getString(i6));
        int i7 = i + 63;
        c3891.m12536(cursor.isNull(i7) ? null : cursor.getString(i7));
        int i8 = i + 64;
        c3891.m12535(cursor.isNull(i8) ? null : cursor.getString(i8));
        int i9 = i + 65;
        c3891.m12534(cursor.isNull(i9) ? null : cursor.getString(i9));
        int i10 = i + 66;
        c3891.m12517(cursor.isNull(i10) ? null : cursor.getString(i10));
        c3891.m12345(cursor.getLong(i + 67));
        c3891.m12367(cursor.getInt(i + 68));
        c3891.m12346(cursor.getInt(i + 69));
        c3891.m12550(cursor.getInt(i + 70));
        c3891.m12343(cursor.getInt(i + 71));
        c3891.m12545(cursor.getInt(i + 72));
        c3891.m12541(cursor.getInt(i + 73));
        c3891.m12551(cursor.getInt(i + 74));
        c3891.m12523(cursor.getFloat(i + 75));
        c3891.m12522(cursor.getFloat(i + 76));
        c3891.m12549(cursor.getShort(i + 77) != 0);
        int i11 = i + 78;
        c3891.m12503(cursor.isNull(i11) ? null : cursor.getString(i11));
        c3891.m12388(cursor.getInt(i + 79));
        c3891.m12502(cursor.getInt(i + 80));
        c3891.m12350(cursor.getInt(i + 81));
        c3891.m12537(cursor.getInt(i + 82));
        c3891.m12353(cursor.getInt(i + 83));
        c3891.m12510(cursor.getShort(i + 84) != 0);
        c3891.m12507(cursor.getFloat(i + 85));
        c3891.m12511(cursor.getFloat(i + 86));
        c3891.m12508(cursor.getFloat(i + 87));
        c3891.m12505(cursor.getFloat(i + 88));
        c3891.m12509(cursor.getFloat(i + 89));
        c3891.m12512(cursor.getFloat(i + 90));
        c3891.m12506(cursor.getFloat(i + 91));
        c3891.m12555(cursor.getInt(i + 92));
        c3891.m12439(cursor.getInt(i + 93));
        c3891.m12440(cursor.getInt(i + 94));
        c3891.m12441(cursor.getFloat(i + 95));
        c3891.m12362(cursor.getInt(i + 96));
        c3891.m12364(cursor.getFloat(i + 97));
        c3891.m12356(cursor.getInt(i + 98));
        c3891.m12492(cursor.getShort(i + 99) != 0);
        c3891.m12542(cursor.getInt(i + 100));
        c3891.m12361(cursor.getInt(i + 101));
        c3891.m12368(cursor.getInt(i + 102));
        c3891.m12539(cursor.getInt(i + 103));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: Ԯ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public Long readKey(Cursor cursor, int i) {
        return Long.valueOf(cursor.getLong(i + 0));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: ԯ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public final Long updateKeyAfterInsert(C3891 c3891, long j) {
        c3891.m12544(j);
        return Long.valueOf(j);
    }
}
