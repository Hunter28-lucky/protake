package defpackage;

import defpackage.C3444;

/* compiled from: LensZoomHelper.java */
/* renamed from: ש, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3410 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static boolean f11756 = false;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final String f11757 = "ש";

    /* compiled from: LensZoomHelper.java */
    /* renamed from: ש$Ϳ, reason: contains not printable characters */
    public static class C3411 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public boolean f11758;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public C3485 f11759;

        /* renamed from: ԩ, reason: contains not printable characters */
        public float f11760;

        /* renamed from: Ԫ, reason: contains not printable characters */
        public float f11761 = 1.0f;

        /* renamed from: ԫ, reason: contains not printable characters */
        public float f11762 = 1.0f;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public float f11763 = 2.0f;

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("ZoomChooseBean{validate=");
            sb.append(this.f11758);
            sb.append(", mCameraIdInfo=");
            C3485 c3485 = this.f11759;
            sb.append(c3485 == null ? "" : c3485.m11360());
            sb.append(", focalLength=");
            sb.append(this.f11760);
            sb.append(", zoomRatio=");
            sb.append(this.f11761);
            sb.append('}');
            return sb.toString();
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public C3485 m11183() {
            return this.f11759;
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public float m11184() {
            return this.f11760;
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public float m11185() {
            return this.f11763;
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public float m11186() {
            return this.f11762;
        }

        /* renamed from: ԫ, reason: contains not printable characters */
        public float m11187() {
            return this.f11761;
        }

        /* renamed from: Ԭ, reason: contains not printable characters */
        public boolean m11188() {
            return this.f11758;
        }

        /* renamed from: ԭ, reason: contains not printable characters */
        public C3411 m11189(C3485 c3485) {
            this.f11759 = c3485;
            return this;
        }

        /* renamed from: Ԯ, reason: contains not printable characters */
        public C3411 m11190(float f) {
            this.f11760 = f;
            return this;
        }

        /* renamed from: ԯ, reason: contains not printable characters */
        public C3411 m11191(float f) {
            this.f11763 = f;
            return this;
        }

        /* renamed from: ՠ, reason: contains not printable characters */
        public C3411 m11192(float f) {
            this.f11762 = f;
            return this;
        }

        /* renamed from: ֈ, reason: contains not printable characters */
        public C3411 m11193(boolean z) {
            this.f11758 = z;
            return this;
        }

        /* renamed from: ֏, reason: contains not printable characters */
        public C3411 m11194(float f) {
            this.f11761 = f;
            return this;
        }
    }

    /* compiled from: LensZoomHelper.java */
    /* renamed from: ש$Ԩ, reason: contains not printable characters */
    public interface InterfaceC3412 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public static final C3411 f11764 = new C3411();

        /* renamed from: Ԩ, reason: contains not printable characters */
        public static final C3411 f11765 = new C3411();

        /* renamed from: ԩ, reason: contains not printable characters */
        public static final C3411 f11766 = new C3411();

        /* renamed from: Ԫ, reason: contains not printable characters */
        public static final C3411 f11767 = new C3411();

        /* renamed from: ԫ, reason: contains not printable characters */
        public static final C3411 f11768 = new C3411();

        /* renamed from: Ԭ, reason: contains not printable characters */
        public static final C3411 f11769 = new C3411();

        /* renamed from: ԭ, reason: contains not printable characters */
        public static final C3411 f11770 = new C3411();
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static float m11179(float[] fArr) {
        if (fArr == null || fArr.length <= 0) {
            return -1.0f;
        }
        return fArr[0];
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static boolean m11180() {
        C3828 c3828 = C3444.InterfaceC3449.f11898;
        return c3828.m12143() && !c3828.m12141();
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static void m11181() {
        float fRound;
        float[] fArrM11361;
        float[] fArrM113612;
        if (m11180()) {
            C3485 c3485M11721 = C3641.m11713(null).m11721(C3444.InterfaceC3449.f11898.m12137());
            C3411 c3411 = InterfaceC3412.f11764;
            c3411.m11193(true);
            c3411.m11189(c3485M11721);
            float fM11375 = c3485M11721.m11375();
            String str = f11757;
            C4638.m14099(str, String.format("half : %s ", Float.valueOf(fM11375)));
            float fRound2 = fM11375 > 0.0f ? fM11375 < 1.0f ? (Math.round(fM11375 * 10.0f) * 1.0f) / 10.0f : Math.round(fM11375) : 0.5f;
            if (C2813.f10260) {
                fRound2 = 0.5f;
            }
            C4638.m14099(str, String.format("half : %s ", Float.valueOf(fRound2)));
            c3411.m11194(fRound2);
            c3411.m11192(1.0f);
            c3411.m11191(2.0f);
            C3828 c3828 = C3444.InterfaceC3449.f11902;
            if (c3828.m12143()) {
                C3485 c3485M117212 = C3641.m11713(null).m11721(c3828.m12137());
                if (c3485M117212.m11386() && (fArrM113612 = c3485M117212.m11361()) != null && fArrM113612.length > 1) {
                    float fM11179 = m11179(c3485M11721.m11361());
                    if (fM11179 != -1.0f && m11182(fArrM113612, fM11179)) {
                        c3411.m11189(c3485M117212);
                        c3411.m11190(fM11179);
                        if (C2813.f10260) {
                            c3411.m11192(1.0f);
                            c3411.m11191(1.25f);
                        }
                    }
                }
            }
        } else {
            InterfaceC3412.f11764.m11193(false);
        }
        C3828 c38282 = C3444.InterfaceC3449.f11899;
        if (c38282.m12143()) {
            C3485 c3485M117213 = C3641.m11713(null).m11721(c38282.m12137());
            C3411 c34112 = InterfaceC3412.f11765;
            c34112.m11193(true);
            c34112.m11189(c3485M117213);
            float fM113752 = c3485M117213.m11375();
            String str2 = f11757;
            C4638.m14099(str2, String.format("wide : %s ", Float.valueOf(fM113752)));
            float fRound3 = fM113752 > 0.0f ? fM113752 < 1.0f ? (Math.round(fM113752 * 10.0f) * 1.0f) / 10.0f : Math.round(fM113752) : 1.0f;
            C4638.m14099(str2, String.format("wide : %s ", Float.valueOf(fRound3)));
            c34112.m11194(fRound3);
            C3828 c38283 = C3444.InterfaceC3449.f11902;
            if (c38283.m12143()) {
                C3485 c3485M117214 = C3641.m11713(null).m11721(c38283.m12137());
                if (c3485M117214.m11386() && (fArrM11361 = c3485M117214.m11361()) != null && fArrM11361.length > 1) {
                    float fM111792 = m11179(c3485M117213.m11361());
                    if (fM111792 != -1.0f && m11182(fArrM11361, fM111792)) {
                        c34112.m11189(c3485M117214);
                        c34112.m11190(fM111792);
                    }
                }
            }
        } else {
            InterfaceC3412.f11765.m11193(false);
        }
        C3828 c38284 = C3444.InterfaceC3449.f11900;
        if (!c38284.m12143() || c38284.m12141()) {
            InterfaceC3412.f11766.m11193(false);
        } else {
            C3485 c3485M117215 = C3641.m11713(null).m11721(c38284.m12137());
            C3641.m11713(null).m11721(c38282.m12137());
            C3411 c34113 = InterfaceC3412.f11766;
            c34113.m11193(true);
            c34113.m11189(c3485M117215);
            float fM113753 = c3485M117215.m11375();
            if (C2813.f10260) {
                fRound = 3.0f;
            } else {
                fRound = fM113753 > 0.0f ? fM113753 < 1.0f ? (Math.round(fM113753 * 10.0f) * 1.0f) / 10.0f : Math.round(fM113753) : 2.0f;
                C4638.m14099(f11757, String.format("tele : %s ", Float.valueOf(fRound)));
            }
            C4638.m14099(f11757, String.format("tele : %s ", Float.valueOf(fRound)));
            c34113.m11194(fRound);
        }
        C3828 c38285 = C3444.InterfaceC3449.f11901;
        if (!c38285.m12143() || c38285.m12141()) {
            InterfaceC3412.f11767.m11193(false);
        } else {
            C3485 c3485M117216 = C3641.m11713(null).m11721(c38285.m12137());
            C3411 c34114 = InterfaceC3412.f11767;
            c34114.m11193(true);
            c34114.m11189(c3485M117216);
            float fM113754 = c3485M117216.m11375();
            String str3 = f11757;
            C4638.m14099(str3, String.format("largeTele : %s ", Float.valueOf(fM113754)));
            float fRound4 = fM113754 > 0.0f ? fM113754 < 1.0f ? (Math.round(fM113754 * 10.0f) * 1.0f) / 10.0f : Math.round(fM113754) : 4.0f;
            C4638.m14099(str3, String.format("largeTele : %s ", Float.valueOf(fRound4)));
            c34114.m11194(fRound4);
            InterfaceC3412.f11766.m11194(2.0f);
        }
        C3828 c38286 = C3444.InterfaceC3449.f11897;
        if (c38286.m12143()) {
            C3485 c3485M117217 = C3641.m11713(null).m11721(c38286.m12137());
            C3411 c34115 = InterfaceC3412.f11769;
            c34115.m11193(true);
            c34115.m11189(c3485M117217);
            float fM113755 = c3485M117217.m11375();
            String str4 = f11757;
            C4638.m14099(str4, String.format("selfie : %s ", Float.valueOf(fM113755)));
            float fRound5 = fM113755 > 0.0f ? fM113755 < 1.0f ? (Math.round(fM113755 * 10.0f) * 1.0f) / 10.0f : Math.round(fM113755) : 1.0f;
            C4638.m14099(str4, String.format("selfie : %s ", Float.valueOf(fRound5)));
            c34115.m11194(fRound5);
        } else {
            InterfaceC3412.f11769.m11193(false);
        }
        C3828 c38287 = C3444.InterfaceC3449.f11895;
        if (!c38287.m12143() || c38287.m12141()) {
            InterfaceC3412.f11768.m11193(false);
        } else {
            C3485 c3485M117218 = C3641.m11713(null).m11721(c38287.m12137());
            C3411 c34116 = InterfaceC3412.f11768;
            c34116.m11193(true);
            c34116.m11189(c3485M117218);
            float fM113756 = c3485M117218.m11375();
            String str5 = f11757;
            C4638.m14099(str5, String.format("selfieHalf : %s ", Float.valueOf(fM113756)));
            float fRound6 = fM113756 > 0.0f ? fM113756 < 1.0f ? (Math.round(fM113756 * 10.0f) * 1.0f) / 10.0f : Math.round(fM113756) : 0.5f;
            C4638.m14099(str5, String.format("selfieHalf : %s ", Float.valueOf(fRound6)));
            c34116.m11194(fRound6);
        }
        if (f11756) {
            String str6 = f11757;
            C4638.m14099(str6, String.format("half : %s ", InterfaceC3412.f11764));
            C4638.m14099(str6, String.format("normal : %s ", InterfaceC3412.f11765));
            C4638.m14099(str6, String.format("high : %s ", InterfaceC3412.f11766));
            C4638.m14099(str6, String.format("largeHigh : %s ", InterfaceC3412.f11767));
            C4638.m14099(str6, String.format("selfieHalf : %s ", InterfaceC3412.f11768));
            C4638.m14099(str6, String.format("selfieNormal : %s ", InterfaceC3412.f11769));
            C4638.m14099(str6, String.format("selfieHigh : %s ", InterfaceC3412.f11770));
        }
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static boolean m11182(float[] fArr, float f) {
        if (fArr == null) {
            return false;
        }
        for (float f2 : fArr) {
            if (f == f2) {
                return true;
            }
        }
        return false;
    }
}
