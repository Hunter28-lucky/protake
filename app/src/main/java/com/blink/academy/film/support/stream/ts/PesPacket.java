package com.blink.academy.film.support.stream.ts;

import com.blink.academy.film.support.stream.h264.H264NalUnit;
import com.blink.academy.film.support.stream.h264.H264NalUnitHeader;
import com.blink.academy.film.support.stream.h264.H264Utils;
import com.blink.academy.film.support.stream.h265.H265NalUnit;
import com.blink.academy.film.support.stream.h265.H265NalUnitHeader;
import com.blink.academy.film.support.stream.h265.H265Utils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jcodec.common.tools.MD5;
import org.mp4parser.tools.Hex;

/* loaded from: classes.dex */
public class PesPacket {
    private static final String TAG = "PesPacket";
    private static boolean VERBOSE = false;
    public boolean isI;
    public byte[] mBytes;
    public long pcr;
    public byte streamType;

    public PesPacket(byte b, byte[] bArr) {
        this.streamType = b;
        this.mBytes = bArr;
    }

    private static byte[] EsToPes(byte[] bArr, long j) {
        byte[] bArr2 = new byte[bArr.length + 14];
        new PesHeader(224, bArr.length + 6, 128, 128, (byte) 5, j, j).writeToPes(bArr2);
        System.arraycopy(bArr, 0, bArr2, 14, bArr.length);
        return bArr2;
    }

    public static long convertTime(long j, long j2) {
        return ((j * 90000) / j2) % 8589934592L;
    }

    private static byte[] msgDataToPes(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length + 14];
        new PesHeader(100, bArr.length + 6, 128, 128, (byte) 5, 0L, 0L).writeToPes(bArr2);
        System.arraycopy(bArr, 0, bArr2, 14, bArr.length);
        return bArr2;
    }

    private static String pesHeaderString(byte[] bArr) {
        int i = new PesHeader(bArr, 0).headerLength;
        byte[] bArr2 = new byte[i];
        System.arraycopy(bArr, 0, bArr2, 0, i);
        return Hex.encodeHex(bArr2);
    }

    public static long revertTime(long j, long j2) {
        return (j * j2) / 90000;
    }

    public List<EsPacket> getDataEsPacket() {
        int i = new PesHeader(this.mBytes, 0).headerLength;
        byte[] bArr = this.mBytes;
        int length = bArr.length - i;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, i, bArr2, 0, length);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new EsPacket(0, 0L, bArr2));
        return arrayList;
    }

    public List<EsPacket> getEsPacket() {
        byte b = this.streamType;
        return b == 36 ? getH265EsPacket() : b == 27 ? getH264EsPacket() : getDataEsPacket();
    }

    public List<EsPacket> getH264EsPacket() {
        PesHeader pesHeader = new PesHeader(this.mBytes, 0);
        int i = pesHeader.headerLength;
        byte[] bArr = this.mBytes;
        int length = bArr.length - i;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, i, bArr2, 0, length);
        List<H264NalUnit> nalUnitList = H264Utils.getNalUnitList(bArr2);
        ArrayList arrayList = new ArrayList();
        H264NalUnit h264NalUnit = null;
        H264NalUnit h264NalUnit2 = null;
        for (H264NalUnit h264NalUnit3 : nalUnitList) {
            H264NalUnitHeader header = h264NalUnit3.getHeader();
            byte b = header.nal_unit_type;
            if (b == 1 || b == 5) {
                arrayList.add(new EsPacket(header.nal_unit_type == 1 ? 1 : 5, pesHeader.pts, h264NalUnit3.getContent()));
            } else if (b == 7) {
                h264NalUnit = h264NalUnit3;
            } else if (b == 8) {
                h264NalUnit2 = h264NalUnit3;
            }
        }
        if (h264NalUnit != null && h264NalUnit2 != null) {
            byte[] content = h264NalUnit.getContent();
            byte[] content2 = h264NalUnit2.getContent();
            int length2 = content.length;
            int length3 = content2.length;
            byte[] bArr3 = new byte[length2 + length3];
            System.arraycopy(content, 0, bArr3, 0, length2);
            System.arraycopy(content2, 0, bArr3, length2, length3);
            arrayList.add(0, new EsPacket(2, pesHeader.pts, bArr3));
        }
        return arrayList;
    }

    public List<EsPacket> getH265EsPacket() {
        int i;
        PesHeader pesHeader = new PesHeader(this.mBytes, 0);
        int i2 = pesHeader.headerLength;
        byte[] bArr = this.mBytes;
        int length = bArr.length - i2;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, i2, bArr2, 0, length);
        MD5.md5sumBytes(bArr2);
        List<H265NalUnit> nalUnitList = H265Utils.getNalUnitList(bArr2);
        ArrayList<EsPacket> arrayList = new ArrayList();
        Iterator<H265NalUnit> it = nalUnitList.iterator();
        H265NalUnit h265NalUnit = null;
        int length2 = 0;
        H265NalUnit h265NalUnit2 = null;
        H265NalUnit h265NalUnit3 = null;
        H265NalUnit h265NalUnit4 = null;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            H265NalUnit next = it.next();
            H265NalUnitHeader header = next.getHeader();
            byte nal_unit_type = header.getNal_unit_type();
            if (header.isFrame()) {
                EsPacket esPacket = new EsPacket(header.isIFrame() ? 5 : 1, pesHeader.pts, next.getContent());
                arrayList.add(esPacket);
                length2 += esPacket.data.length;
            } else if (nal_unit_type == 32) {
                h265NalUnit = next;
            } else if (nal_unit_type == 33) {
                h265NalUnit2 = next;
            } else if (nal_unit_type == 34) {
                h265NalUnit3 = next;
            } else if (nal_unit_type == 52) {
                h265NalUnit4 = next;
            }
        }
        byte[] bArr3 = new byte[length2];
        int length3 = 0;
        for (EsPacket esPacket2 : arrayList) {
            int type = esPacket2.getType();
            byte[] bArr4 = esPacket2.data;
            System.arraycopy(bArr4, 0, bArr3, length3, bArr4.length);
            length3 += esPacket2.data.length;
            i = type;
        }
        arrayList.clear();
        arrayList.add(new EsPacket(i, pesHeader.pts, bArr3));
        if (h265NalUnit != null && h265NalUnit2 != null && h265NalUnit3 != null) {
            byte[] content = h265NalUnit.getContent();
            byte[] content2 = h265NalUnit2.getContent();
            byte[] content3 = h265NalUnit3.getContent();
            int length4 = content.length;
            int length5 = content2.length;
            int length6 = content3.length;
            int i3 = length4 + length5;
            byte[] bArr5 = new byte[i3 + length6];
            System.arraycopy(content, 0, bArr5, 0, length4);
            System.arraycopy(content2, 0, bArr5, length4, length5);
            System.arraycopy(content3, 0, bArr5, i3, length6);
            arrayList.add(0, new EsPacket(2, pesHeader.pts, bArr5));
        }
        if (h265NalUnit4 != null) {
            arrayList.add(new EsPacket(11, pesHeader.pts, h265NalUnit4.getContent()));
        }
        return arrayList;
    }

    public PesPacket(byte[] bArr) {
        this.mBytes = msgDataToPes(bArr);
    }

    public PesPacket(EsPacket esPacket, byte[] bArr) {
        if (esPacket != null) {
            byte[] bArr2 = esPacket.data;
            if (esPacket.type != 5) {
                this.mBytes = EsToPes(bArr2, esPacket.presentationTimeUs);
                return;
            }
            if (bArr != null) {
                byte[] bArr3 = new byte[bArr2.length + bArr.length];
                System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
                System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
                this.isI = true;
                long j = esPacket.presentationTimeUs;
                this.pcr = j;
                this.mBytes = EsToPes(bArr3, j);
                return;
            }
            throw new RuntimeException("spsPps == null !");
        }
        throw new RuntimeException("esPacket == null !");
    }
}
