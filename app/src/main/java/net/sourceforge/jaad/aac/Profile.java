package net.sourceforge.jaad.aac;

/* loaded from: classes2.dex */
public final class Profile {
    public static final Profile AAC_LC;
    public static final Profile AAC_LD;
    public static final Profile AAC_LTP;
    public static final Profile AAC_MAIN;
    public static final Profile AAC_SBR;
    public static final Profile AAC_SCALABLE;
    public static final Profile AAC_SSR;
    private static final Profile[] ALL;
    public static final Profile ER_AAC_LC;
    public static final Profile ER_AAC_LD;
    public static final Profile ER_AAC_LTP;
    public static final Profile ER_AAC_SCALABLE;
    public static final Profile ER_AAC_SSR;
    public static final Profile ER_BSAC;
    public static final Profile ER_TWIN_VQ;
    public static final Profile TWIN_VQ;
    public static final Profile UNKNOWN = new Profile(-1, "unknown", false);
    private final String descr;
    private final int num;
    private final boolean supported;

    static {
        Profile profile = new Profile(1, "AAC Main Profile", true);
        AAC_MAIN = profile;
        Profile profile2 = new Profile(2, "AAC Low Complexity", true);
        AAC_LC = profile2;
        Profile profile3 = new Profile(3, "AAC Scalable Sample Rate", false);
        AAC_SSR = profile3;
        Profile profile4 = new Profile(4, "AAC Long Term Prediction", false);
        AAC_LTP = profile4;
        Profile profile5 = new Profile(5, "AAC SBR", true);
        AAC_SBR = profile5;
        Profile profile6 = new Profile(6, "Scalable AAC", false);
        AAC_SCALABLE = profile6;
        Profile profile7 = new Profile(7, "TwinVQ", false);
        TWIN_VQ = profile7;
        Profile profile8 = new Profile(11, "AAC Low Delay", false);
        AAC_LD = profile8;
        Profile profile9 = new Profile(17, "Error Resilient AAC Low Complexity", true);
        ER_AAC_LC = profile9;
        Profile profile10 = new Profile(18, "Error Resilient AAC SSR", false);
        ER_AAC_SSR = profile10;
        Profile profile11 = new Profile(19, "Error Resilient AAC Long Term Prediction", false);
        ER_AAC_LTP = profile11;
        Profile profile12 = new Profile(20, "Error Resilient Scalable AAC", false);
        ER_AAC_SCALABLE = profile12;
        Profile profile13 = new Profile(21, "Error Resilient TwinVQ", false);
        ER_TWIN_VQ = profile13;
        Profile profile14 = new Profile(22, "Error Resilient BSAC", false);
        ER_BSAC = profile14;
        Profile profile15 = new Profile(23, "Error Resilient AAC Low Delay", false);
        ER_AAC_LD = profile15;
        ALL = new Profile[]{profile, profile2, profile3, profile4, profile5, profile6, profile7, null, null, null, profile8, null, null, null, null, null, profile9, profile10, profile11, profile12, profile13, profile14, profile15};
    }

    private Profile(int i, String str, boolean z) {
        this.num = i;
        this.descr = str;
        this.supported = z;
    }

    public static Profile forInt(int i) {
        if (i > 0) {
            Profile[] profileArr = ALL;
            if (i <= profileArr.length) {
                return profileArr[i - 1];
            }
        }
        return UNKNOWN;
    }

    public String getDescription() {
        return this.descr;
    }

    public int getIndex() {
        return this.num;
    }

    public boolean isDecodingSupported() {
        return this.supported;
    }

    public boolean isErrorResilientProfile() {
        return this.num > 16;
    }

    public String toString() {
        return this.descr;
    }
}
