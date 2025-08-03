package defpackage;

import java.math.BigDecimal;

/* compiled from: UnitUtil.java */
/* loaded from: classes.dex */
public class o4 {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static float m7677(float f) {
        return m7679(f) / 1024.0f;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static float m7678(float f) {
        return f / 1024.0f;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static float m7679(float f) {
        return m7678(f) / 1024.0f;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static String m7680(float f) {
        if (Float.isInfinite(f)) {
            return "0";
        }
        return new BigDecimal(f).setScale(1, 4).floatValue() + "";
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static String m7681(float f) {
        if (Float.isInfinite(f)) {
            return "0";
        }
        BigDecimal scale = new BigDecimal(f).setScale(1, 4);
        if (scale.floatValue() < 1.0f) {
            return scale.floatValue() + "";
        }
        return scale.intValue() + "";
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static String m7682(long j) {
        return String.format("%s %s", m7684(j, 103), m7690(103));
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static String m7683(float f, int i) {
        if (f == 0.0f) {
            return f + "";
        }
        if (i == 0) {
            return f + "";
        }
        switch (i) {
            case 101:
                break;
            case 102:
                f = m7678(f);
                break;
            case 103:
                f = m7679(f);
                break;
            case 104:
                f = m7677(f);
                break;
            default:
                return f + "";
        }
        return m7681(f);
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static String m7684(float f, int i) {
        if (f == 0.0f) {
            return f + "";
        }
        if (i == 0) {
            return f + "";
        }
        switch (i) {
            case 101:
                break;
            case 102:
                f = m7678(f);
                break;
            case 103:
                f = m7679(f);
                break;
            case 104:
                f = m7677(f);
                break;
            default:
                return f + "";
        }
        return m7680(f);
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public static String m7685(int i) {
        if (i >= 10) {
            return String.valueOf(i);
        }
        return "0" + i;
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public static String m7686(long j) {
        return m7685((int) ((j / 1000.0f) / 3600.0f));
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public static String m7687(long j) {
        return m7685((int) (((j / 1000.0f) % 3600.0f) / 60.0f));
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public static float m7688(long j) {
        return j >= 1000 ? (j / 10.0f) % 100.0f : j / 10.0f;
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public static String m7689(long j) {
        return m7685((int) ((j / 1000.0f) % 60.0f));
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public static String m7690(int i) {
        switch (i) {
            case 101:
                return "Bytes";
            case 102:
                return "KB";
            case 103:
                return "MB";
            case 104:
                return "GB";
            default:
                return "";
        }
    }
}
