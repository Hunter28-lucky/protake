package defpackage;

import defpackage.C3410;
import defpackage.C3444;

/* compiled from: CameraLensUIHelper.java */
/* renamed from: ȓ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2520 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static C2520 f9340;

    /* renamed from: ԩ, reason: contains not printable characters */
    public static C2520 m9312() {
        if (f9340 == null) {
            synchronized (C2520.class) {
                if (f9340 == null) {
                    f9340 = new C2520();
                }
            }
        }
        return f9340;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public String m9313(String str, float f) {
        C3410.C3411 c3411 = C3410.InterfaceC3412.f11767;
        if (c3411.m11188() && f >= c3411.m11187()) {
            return c3411.m11183().m11360();
        }
        C3410.C3411 c34112 = C3410.InterfaceC3412.f11766;
        if (c34112.m11188() && f >= c34112.m11187()) {
            return c34112.m11183().m11360();
        }
        C3410.C3411 c34113 = C3410.InterfaceC3412.f11764;
        if (!c34113.m11188()) {
            return str;
        }
        C3410.C3411 c34114 = C3410.InterfaceC3412.f11765;
        return (f >= c34114.m11187() || c34113.m11183() == c34114.m11183()) ? str : c34113.m11183().m11360();
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public C3828 m9314() {
        C3891 c3891M13890 = C4535.m13880().m13890();
        if (c3891M13890.m12495()) {
            return C3444.m11224(c3891M13890.m12399());
        }
        C3828 c3828M11224 = C3444.m11224(c3891M13890.m12380());
        C3828 c3828 = C3444.InterfaceC3449.f11902;
        if (!c3828.m12137().equals(c3828M11224.m12137())) {
            C3410.C3411 c3411 = C3410.InterfaceC3412.f11766;
            if (!c3411.m11188() || !c3411.m11183().m11360().equals(c3828M11224.m12137())) {
                C3410.C3411 c34112 = C3410.InterfaceC3412.f11767;
                if (!c34112.m11188() || !c34112.m11183().m11360().equals(c3828M11224.m12137())) {
                    C3410.C3411 c34113 = C3410.InterfaceC3412.f11764;
                    if (!c34113.m11188() || !c34113.m11183().m11360().equals(c3828M11224.m12137())) {
                        C3410.C3411 c34114 = C3410.InterfaceC3412.f11765;
                        if (!c34114.m11188() || !c34114.m11183().m11360().equals(c3828M11224.m12137())) {
                            return c3828M11224;
                        }
                    }
                }
            }
        }
        return c3828;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public C3828 m9315() {
        return C3444.InterfaceC3449.f11902;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public C3828 m9316() {
        return C3444.InterfaceC3449.f11897;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public C3828 m9317() {
        return C3444.InterfaceC3449.f11899;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public C3410.C3411 m9318(int i) {
        if (i == 0) {
            return C3410.InterfaceC3412.f11769;
        }
        if (i == 1) {
            return C3410.InterfaceC3412.f11768;
        }
        if (i == 2) {
            return C3410.InterfaceC3412.f11765;
        }
        if (i == 3) {
            return C3410.InterfaceC3412.f11764;
        }
        if (i == 4) {
            return C3410.InterfaceC3412.f11766;
        }
        if (i != 5) {
            return null;
        }
        return C3410.InterfaceC3412.f11767;
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public boolean m9319(String str) {
        C3828 c3828 = C3444.InterfaceC3449.f11897;
        if (c3828.m12143()) {
            return c3828.m12137().equals(str);
        }
        return false;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public boolean m9320() {
        return C3444.InterfaceC3449.f11897.m12143();
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public boolean m9321(String str) {
        return C3444.InterfaceC3449.f11902.m12137().equals(str);
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public boolean m9322() {
        return C3444.InterfaceC3449.f11902.m12143();
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public boolean m9323(String str) {
        C3828 c3828 = C3444.InterfaceC3449.f11899;
        if (c3828.m12143()) {
            return c3828.m12137().equals(str);
        }
        return false;
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public boolean m9324(String str) {
        C3410.C3411 c3411 = C3410.InterfaceC3412.f11764;
        return c3411.m11188() && c3411.m11183().m11360().equals(str);
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public boolean m9325(String str) {
        C3410.C3411 c3411 = C3410.InterfaceC3412.f11766;
        return c3411.m11188() && c3411.m11183().m11360().equals(str);
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public boolean m9326(String str) {
        C3410.C3411 c3411 = C3410.InterfaceC3412.f11767;
        return c3411.m11188() && c3411.m11183().m11360().equals(str);
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public boolean m9327(String str) {
        return C3410.InterfaceC3412.f11765.m11183().m11360().equals(str);
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public boolean m9328(String str) {
        C3410.C3411 c3411 = C3410.InterfaceC3412.f11768;
        return c3411.m11188() && c3411.m11183().m11360().equals(str);
    }
}
