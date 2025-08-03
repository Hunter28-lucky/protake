package com.blink.academy.film.support.stream.ts;

import com.blink.academy.film.support.stream.h265.H265NalUnit;
import com.blink.academy.film.support.stream.h265.H265SeqParameterSetRBSP;
import com.blink.academy.film.support.stream.h265.H265Utils;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* loaded from: classes.dex */
class H265SpsPpsParser {
    private static final String TAG = "H265SpsPpsParser";
    private static boolean VERBOSE = false;
    public H265SeqParameterSetRBSP mSeqParameterSetRBSP;

    public H265SpsPpsParser(byte[] bArr) {
        for (H265NalUnit h265NalUnit : H265Utils.getNalUnitList(bArr)) {
            byte nal_unit_type = h265NalUnit.getHeader().getNal_unit_type();
            if (nal_unit_type != 19 && nal_unit_type != 1 && nal_unit_type != 32 && nal_unit_type == 33) {
                byte[] bArrRemove03 = remove03(h265NalUnit.getContent());
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArrRemove03.length);
                byteBufferAllocate.put(bArrRemove03);
                byteBufferAllocate.position(6);
                this.mSeqParameterSetRBSP = H265SeqParameterSetRBSP.read(byteBufferAllocate);
            }
        }
    }

    private byte[] remove03(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            throw new RuntimeException("bytes not valid ! ");
        }
        int length = bArr.length - 3;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < length; i++) {
            if (bArr[i] == 0 && bArr[i + 1] == 0) {
                int i2 = i + 2;
                if (bArr[i2] == 3) {
                    arrayList.add(Integer.valueOf(i2));
                }
            }
        }
        if (arrayList.size() <= 0) {
            return bArr;
        }
        byte[] bArr2 = new byte[bArr.length - arrayList.size()];
        int size = arrayList.size();
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            int iIntValue = ((Integer) arrayList.get(i5)).intValue();
            int i6 = iIntValue - i3;
            System.arraycopy(bArr, i3, bArr2, i4, i6);
            i4 += i6;
            i3 = iIntValue + 1;
        }
        if (i3 < bArr.length) {
            System.arraycopy(bArr, i3, bArr2, i4, bArr.length - i3);
        }
        return bArr2;
    }

    public H265SeqParameterSetRBSP getSeqParameterSetRBSP() {
        return this.mSeqParameterSetRBSP;
    }
}
