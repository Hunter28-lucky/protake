package com.umeng.analytics.pro;

import com.umeng.analytics.pro.bo;
import org.jcodec.containers.mxf.model.BER;

/* compiled from: TProtocolUtil.java */
/* loaded from: classes2.dex */
public class bx {
    private static int a = Integer.MAX_VALUE;

    public static void a(int i) {
        a = i;
    }

    public static void a(bu buVar, byte b) throws bb {
        a(buVar, b, a);
    }

    public static void a(bu buVar, byte b, int i) throws bb {
        if (i > 0) {
            int i2 = 0;
            switch (b) {
                case 2:
                    buVar.t();
                    return;
                case 3:
                    buVar.u();
                    return;
                case 4:
                    buVar.y();
                    return;
                case 5:
                case 7:
                case 9:
                default:
                    return;
                case 6:
                    buVar.v();
                    return;
                case 8:
                    buVar.w();
                    return;
                case 10:
                    buVar.x();
                    return;
                case 11:
                    buVar.A();
                    return;
                case 12:
                    buVar.j();
                    while (true) {
                        byte b2 = buVar.l().b;
                        if (b2 == 0) {
                            buVar.k();
                            return;
                        } else {
                            a(buVar, b2, i - 1);
                            buVar.m();
                        }
                    }
                case 13:
                    br brVarN = buVar.n();
                    while (i2 < brVarN.c) {
                        int i3 = i - 1;
                        a(buVar, brVarN.a, i3);
                        a(buVar, brVarN.b, i3);
                        i2++;
                    }
                    buVar.o();
                    return;
                case 14:
                    by byVarR = buVar.r();
                    while (i2 < byVarR.b) {
                        a(buVar, byVarR.a, i - 1);
                        i2++;
                    }
                    buVar.s();
                    return;
                case 15:
                    bq bqVarP = buVar.p();
                    while (i2 < bqVarP.b) {
                        a(buVar, bqVarP.a, i - 1);
                        i2++;
                    }
                    buVar.q();
                    return;
            }
        } else {
            throw new bb("Maximum skip depth exceeded");
        }
    }

    public static bw a(byte[] bArr, bw bwVar) {
        if (bArr[0] > 16) {
            return new bo.a();
        }
        return (bArr.length <= 1 || (bArr[1] & BER.ASN_LONG_LEN) == 0) ? bwVar : new bo.a();
    }
}
