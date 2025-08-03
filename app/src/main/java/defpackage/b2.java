package defpackage;

import jp.co.cyberagent.android.gpuimage.Rotation;

/* compiled from: TextureRotationUtil.java */
/* loaded from: classes2.dex */
public class b2 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final float[] f93 = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final float[] f94 = {1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f, -1.0f, -1.0f};

    /* renamed from: ԩ, reason: contains not printable characters */
    public static final float[] f95 = {-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f};

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static final float[] f96 = {1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f, -1.0f, -1.0f};

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final float[] f97 = {1.0f, -1.0f, 1.0f, 1.0f, -1.0f, 1.0f, -1.0f, -1.0f};

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static final float[] f98 = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};

    /* renamed from: ԭ, reason: contains not printable characters */
    public static final float[] f99 = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static final float[] f100 = {1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f};

    /* renamed from: ԯ, reason: contains not printable characters */
    public static final float[] f101 = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f};

    /* renamed from: ՠ, reason: contains not printable characters */
    public static final float[] f102 = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: ֈ, reason: contains not printable characters */
    public static final float[] f103 = {1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};

    /* renamed from: ֏, reason: contains not printable characters */
    public static final float[] f104 = {1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f};

    /* renamed from: ׯ, reason: contains not printable characters */
    public static final float[] f105 = {0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f};

    /* renamed from: ؠ, reason: contains not printable characters */
    public static final float[] f106 = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};

    /* compiled from: TextureRotationUtil.java */
    /* renamed from: b2$Ϳ, reason: contains not printable characters */
    public static /* synthetic */ class C0043 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public static final /* synthetic */ int[] f107;

        static {
            int[] iArr = new int[Rotation.values().length];
            f107 = iArr;
            try {
                iArr[Rotation.NEGATIVE_NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f107[Rotation.NEGATIVE_ROTATION_90.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f107[Rotation.NEGATIVE_ROTATION_180.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f107[Rotation.NEGATIVE_ROTATION_270.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f107[Rotation.ROTATION_90.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f107[Rotation.ROTATION_180.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f107[Rotation.ROTATION_270.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f107[Rotation.NORMAL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static float m110(float f) {
        return f == 0.0f ? 1.0f : 0.0f;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static float[] m111(Rotation rotation, boolean z, boolean z2) {
        float[] fArr;
        switch (C0043.f107[rotation.ordinal()]) {
            case 1:
                fArr = f103;
                break;
            case 2:
                fArr = f104;
                break;
            case 3:
                fArr = f105;
                break;
            case 4:
                fArr = f106;
                break;
            case 5:
                fArr = f100;
                break;
            case 6:
                fArr = f101;
                break;
            case 7:
                fArr = f102;
                break;
            default:
                fArr = f99;
                break;
        }
        if (z) {
            fArr = new float[]{m110(fArr[0]), fArr[1], m110(fArr[2]), fArr[3], m110(fArr[4]), fArr[5], m110(fArr[6]), fArr[7]};
        }
        return z2 ? new float[]{fArr[0], m110(fArr[1]), fArr[2], m110(fArr[3]), fArr[4], m110(fArr[5]), fArr[6], m110(fArr[7])} : fArr;
    }
}
