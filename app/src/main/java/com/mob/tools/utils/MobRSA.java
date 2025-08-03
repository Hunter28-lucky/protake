package com.mob.tools.utils;

import com.mob.commons.C5340r;
import com.mob.tools.proguard.PublicMemberKeeper;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.math.BigInteger;

/* loaded from: classes2.dex */
public class MobRSA implements PublicMemberKeeper {
    private int a;

    public MobRSA(int i) {
        this.a = i;
    }

    private byte[] a(byte[] bArr, int i, int i2, BigInteger bigInteger, BigInteger bigInteger2, int i3) throws Throwable {
        if (bArr.length != i2 || i != 0) {
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, i, bArr2, 0, i2);
            bArr = bArr2;
        }
        BigInteger bigInteger3 = new BigInteger(a(bArr, i3));
        if (bigInteger3.compareTo(bigInteger2) <= 0) {
            return bigInteger3.modPow(bigInteger, bigInteger2).toByteArray();
        }
        throw new Throwable("the message must be smaller than the modulue");
    }

    public byte[] encode(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2) throws Throwable {
        int i = this.a / 8;
        int i2 = i - 11;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = null;
        try {
            DataOutputStream dataOutputStream2 = new DataOutputStream(byteArrayOutputStream);
            int i3 = 0;
            while (bArr.length > i3) {
                try {
                    int iMin = Math.min(bArr.length - i3, i2);
                    byte[] bArrA = a(bArr, i3, iMin, bigInteger, bigInteger2, i);
                    dataOutputStream2.writeInt(bArrA.length);
                    dataOutputStream2.write(bArrA);
                    i3 += iMin;
                } catch (Throwable th) {
                    th = th;
                    dataOutputStream = dataOutputStream2;
                    C5340r.a(dataOutputStream);
                    throw th;
                }
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            C5340r.a(dataOutputStream2);
            return byteArray;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private byte[] a(byte[] bArr, int i) throws Throwable {
        if (bArr.length <= i - 1) {
            byte[] bArr2 = new byte[i];
            bArr2[0] = 1;
            int length = bArr.length;
            bArr2[1] = (byte) (length >> 24);
            bArr2[2] = (byte) (length >> 16);
            bArr2[3] = (byte) (length >> 8);
            bArr2[4] = (byte) length;
            System.arraycopy(bArr, 0, bArr2, i - length, length);
            return bArr2;
        }
        throw new Throwable("Message too large");
    }
}
