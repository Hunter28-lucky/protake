package com.xiaomi.push;

/* loaded from: classes2.dex */
public class ie {
    private static int a = Integer.MAX_VALUE;

    public static void a(ib ibVar, byte b) {
        a(ibVar, b, a);
    }

    public static void a(ib ibVar, byte b, int i) throws hv {
        if (i <= 0) {
            throw new hv("Maximum skip depth exceeded");
        }
        int i2 = 0;
        switch (b) {
            case 2:
                ibVar.mo5677a();
                return;
            case 3:
                ibVar.a();
                return;
            case 4:
                ibVar.mo5664a();
                return;
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 6:
                ibVar.mo5674a();
                return;
            case 8:
                ibVar.mo5665a();
                return;
            case 10:
                ibVar.mo5666a();
                return;
            case 11:
                ibVar.mo5673a();
                return;
            case 12:
                ibVar.mo5671a();
                while (true) {
                    byte b2 = ibVar.mo5667a().a;
                    if (b2 == 0) {
                        ibVar.f();
                        return;
                    } else {
                        a(ibVar, b2, i - 1);
                        ibVar.g();
                    }
                }
            case 13:
                ia iaVarMo5669a = ibVar.mo5669a();
                while (i2 < iaVarMo5669a.f6308a) {
                    int i3 = i - 1;
                    a(ibVar, iaVarMo5669a.a, i3);
                    a(ibVar, iaVarMo5669a.b, i3);
                    i2++;
                }
                ibVar.h();
                return;
            case 14:
                Cif cifMo5670a = ibVar.mo5670a();
                while (i2 < cifMo5670a.f6309a) {
                    a(ibVar, cifMo5670a.a, i - 1);
                    i2++;
                }
                ibVar.j();
                return;
            case 15:
                hz hzVarMo5668a = ibVar.mo5668a();
                while (i2 < hzVarMo5668a.f6305a) {
                    a(ibVar, hzVarMo5668a.a, i - 1);
                    i2++;
                }
                ibVar.i();
                return;
        }
    }
}
