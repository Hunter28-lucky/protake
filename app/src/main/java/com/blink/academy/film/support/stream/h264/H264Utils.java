package com.blink.academy.film.support.stream.h264;

import defpackage.C4638;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class H264Utils {
    public static byte[] SPSAndPPS = new byte[0];
    public static boolean VERBOSE = false;
    public static int saveCount = 1;

    public static List<H264NalUnit> getNalUnitList(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            throw new RuntimeException("bytes not valid ! ");
        }
        int length = bArr.length - 4;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < length; i++) {
            if (bArr[i] == 0 && bArr[i + 1] == 0 && bArr[i + 2] == 0 && bArr[i + 3] == 1) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        if (VERBOSE) {
            C4638.m14099("H264Utils", String.format("bytes.length : %s , posList.length : %s , posList : %s ", Integer.valueOf(bArr.length), Integer.valueOf(arrayList.size()), arrayList));
        }
        ArrayList arrayList2 = new ArrayList();
        if (arrayList.size() > 1) {
            for (int i2 = 1; i2 < arrayList.size(); i2++) {
                int iIntValue = ((Integer) arrayList.get(i2 - 1)).intValue();
                int iIntValue2 = ((Integer) arrayList.get(i2)).intValue();
                int i3 = iIntValue2 - iIntValue;
                byte[] bArr2 = new byte[i3];
                if (VERBOSE) {
                    C4638.m14099("H264Utils", String.format("before : %s , cur : %s , length : %s ", Integer.valueOf(iIntValue), Integer.valueOf(iIntValue2), Integer.valueOf(i3)));
                }
                System.arraycopy(bArr, iIntValue, bArr2, 0, i3);
                arrayList2.add(new H264NalUnit(bArr2));
            }
            int iIntValue3 = ((Integer) arrayList.get(arrayList.size() - 1)).intValue();
            int length2 = bArr.length;
            int i4 = length2 - iIntValue3;
            byte[] bArr3 = new byte[i4];
            if (VERBOSE) {
                C4638.m14099("H264Utils", String.format("before : %s , cur : %s , length : %s ", Integer.valueOf(iIntValue3), Integer.valueOf(length2), Integer.valueOf(i4)));
            }
            System.arraycopy(bArr, iIntValue3, bArr3, 0, i4);
            arrayList2.add(new H264NalUnit(bArr3));
        } else if (arrayList.size() == 1) {
            int iIntValue4 = ((Integer) arrayList.get(0)).intValue();
            int length3 = bArr.length;
            int i5 = length3 - iIntValue4;
            byte[] bArr4 = new byte[i5];
            if (VERBOSE) {
                C4638.m14099("H264Utils", String.format("before : %s , cur : %s , length : %s ", Integer.valueOf(iIntValue4), Integer.valueOf(length3), Integer.valueOf(i5)));
            }
            System.arraycopy(bArr, iIntValue4, bArr4, 0, i5);
            arrayList2.add(new H264NalUnit(bArr4));
        }
        return arrayList2;
    }
}
