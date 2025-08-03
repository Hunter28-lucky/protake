package jp.co.cyberagent.android.gpuimage;

/* loaded from: classes2.dex */
public enum Rotation {
    NORMAL,
    ROTATION_90,
    ROTATION_180,
    ROTATION_270,
    NEGATIVE_NORMAL,
    NEGATIVE_ROTATION_90,
    NEGATIVE_ROTATION_180,
    NEGATIVE_ROTATION_270;

    public static Rotation fromInt(int i) {
        if (i == -360) {
            return NEGATIVE_NORMAL;
        }
        if (i == -270) {
            return NEGATIVE_ROTATION_270;
        }
        if (i == -180) {
            return NEGATIVE_ROTATION_180;
        }
        if (i == -90) {
            return NEGATIVE_ROTATION_90;
        }
        if (i == 90) {
            return ROTATION_90;
        }
        if (i == 180) {
            return ROTATION_180;
        }
        if (i == 270) {
            return ROTATION_270;
        }
        if (i == 360) {
            return NORMAL;
        }
        if (i == -1) {
            return NEGATIVE_NORMAL;
        }
        if (i == 0) {
            return NORMAL;
        }
        throw new IllegalStateException(i + " is an unknown rotation. Needs to be either 0, 90, 180 or 270!");
    }
}
