package com.zhiyun.protocol.constants;

import com.uc.crashsdk.export.LogType;
import java.util.Objects;

/* loaded from: classes2.dex */
public enum Model {
    SHINING("SHINING", 4096),
    PROUND("PROUND", 512),
    RIDER_M("RIDER-M", "RiderM.json", 1024),
    SMOOTH("SMOOTH", 528),
    SMOOTH2("SMOOTH 2", "Smooth2.json", 544),
    SMOOTH3("SMOOTH 3", "Smooth3.json", 560),
    SMOOTH4("SMOOTH 4", "Smooth4.json", 576),
    SMOOTH5("SMOOTH 5", "smooth 5", "Smooth5.json", 577),
    SMOOTHQ("SMOOTH-Q", "SmoothQ.json", 545),
    SMOOTHQ2("SMOOTH-Q2", "smooth q2", "SmoothQ2.json", 547),
    SMOOTHX("SMOOTH-X", "smooth-x", "SM108.json", 550),
    SMOOTHXS("SMOOTH-XS", "smooth-xs", "SM110.json", 551),
    SMOOTHQ3("SMOOTH-Q3", "smooth-q3", "SmoothQ3.json", 592),
    EVOLUTION("EVO", 768),
    EVOLUTION2("EVO 2", "EV103.json", 784),
    CRANE("CRANE", "Crane.json", LogType.UNEXP_ANR, 1281),
    CRANE2("CRANE 2", "Crane2.json", 1312),
    CRANE2_S("CRANE 2S", "Crane2S.json", 1313),
    CRANE3("CRANE 3", 1330),
    CRANE3_LAB("CRANE 3 LAB", "Crane3Lab.json", 1328),
    CRANE3_S("CRANE 3S", "Crane3S.json", 1338),
    CRANE_PLUS("CRANE PLUS", "CranePlus.json", 1282, 1283),
    CRANE_M("CRANE-M", "CraneM.json", 1296, 1297),
    CRANE_M2("CRANE-M2", "CraneM2.json", 1298),
    CRANE_M3("CRANE-M3", "CraneM3.json", 1299),
    WEEBILL_LAB("WEEBILL LAB", "WeebillLab.json", 1329),
    WEEBILL_S("WEEBILL-S", "WeebillS.json", 1331),
    P1("P1", "P1.json", 546),
    C11("C11", "C11.json", 548),
    UNKNOWN("Unknown", 0);

    public final int code;
    private final int[] codes;
    public final String hidName;
    public final String name;
    public int oemSerial;
    private final Profile profile;

    /* renamed from: com.zhiyun.protocol.constants.Model$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$zhiyun$protocol$constants$Model;

        static {
            int[] iArr = new int[Model.values().length];
            $SwitchMap$com$zhiyun$protocol$constants$Model = iArr;
            try {
                iArr[Model.SHINING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$zhiyun$protocol$constants$Model[Model.PROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$zhiyun$protocol$constants$Model[Model.SMOOTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$zhiyun$protocol$constants$Model[Model.SMOOTH2.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$zhiyun$protocol$constants$Model[Model.SMOOTHQ.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$zhiyun$protocol$constants$Model[Model.SMOOTH3.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$zhiyun$protocol$constants$Model[Model.EVOLUTION.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$zhiyun$protocol$constants$Model[Model.RIDER_M.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$zhiyun$protocol$constants$Model[Model.CRANE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$zhiyun$protocol$constants$Model[Model.CRANE_PLUS.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$zhiyun$protocol$constants$Model[Model.CRANE_M.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$zhiyun$protocol$constants$Model[Model.C11.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    Model(String str, int... iArr) {
        this(str, null, iArr);
    }

    public static Model from(int i) {
        for (Model model : values()) {
            for (int i2 : model.codes) {
                if (i == i2) {
                    return model;
                }
            }
        }
        return UNKNOWN;
    }

    public static int to(Model model) {
        return model.codes[0];
    }

    public int getCode() {
        return this.codes[0];
    }

    public String getHidName() {
        return this.hidName;
    }

    public float[][] getMoveLimit() {
        return this.profile.moveLimit;
    }

    public String getName() {
        return this.name;
    }

    public int hid() {
        return this.profile.hid;
    }

    public boolean isBl() {
        switch (AnonymousClass1.$SwitchMap$com$zhiyun$protocol$constants$Model[ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                return false;
            default:
                return true;
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.name;
    }

    Model(String str, String str2, int... iArr) {
        this(str, (String) null, str2, iArr);
    }

    Model(String str, String str2, String str3, int... iArr) {
        this(str, str2, Profile.create(str3), iArr);
    }

    Model(String str, String str2, Profile profile, int... iArr) {
        this.name = str;
        this.hidName = str2;
        this.profile = profile == null ? new Profile() : profile;
        Objects.requireNonNull(iArr);
        this.codes = iArr;
        this.code = iArr[0];
    }
}
