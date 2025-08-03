package com.umeng.analytics.pro;

/* compiled from: TApplicationException.java */
/* loaded from: classes2.dex */
public class au extends bb {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;

    /* renamed from: e, reason: collision with root package name */
    public static final int f17759e = 4;
    public static final int f = 5;
    public static final int g = 6;
    public static final int h = 7;
    private static final bz j = new bz("TApplicationException");
    private static final bp k = new bp("message", (byte) 11, 1);
    private static final bp l = new bp("type", (byte) 8, 2);
    private static final long m = 1;
    public int i;

    public au() {
        this.i = 0;
    }

    public int a() {
        return this.i;
    }

    public void b(bu buVar) throws bb {
        buVar.a(j);
        if (getMessage() != null) {
            buVar.a(k);
            buVar.a(getMessage());
            buVar.c();
        }
        buVar.a(l);
        buVar.a(this.i);
        buVar.c();
        buVar.d();
        buVar.b();
    }

    public static au a(bu buVar) throws bb {
        buVar.j();
        String strZ = null;
        int iW = 0;
        while (true) {
            bp bpVarL = buVar.l();
            byte b2 = bpVarL.b;
            if (b2 == 0) {
                buVar.k();
                return new au(iW, strZ);
            }
            short s = bpVarL.c;
            if (s != 1) {
                if (s != 2) {
                    bx.a(buVar, b2);
                } else if (b2 == 8) {
                    iW = buVar.w();
                } else {
                    bx.a(buVar, b2);
                }
            } else if (b2 == 11) {
                strZ = buVar.z();
            } else {
                bx.a(buVar, b2);
            }
            buVar.m();
        }
    }

    public au(int i) {
        this.i = i;
    }

    public au(int i, String str) {
        super(str);
        this.i = i;
    }

    public au(String str) {
        super(str);
        this.i = 0;
    }
}
