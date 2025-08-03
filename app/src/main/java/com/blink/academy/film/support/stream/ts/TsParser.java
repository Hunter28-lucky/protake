package com.blink.academy.film.support.stream.ts;

import androidx.exifinterface.media.ExifInterface;
import com.blink.academy.film.support.stream.h265.H265SeqParameterSetRBSP;
import defpackage.C4638;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jcodec.codecs.h264.io.model.SeqParameterSet;
import org.jcodec.codecs.mpeg12.MPEGConst;

/* loaded from: classes.dex */
public class TsParser {
    public static boolean VERBOSE = false;

    public interface TsCallback {
        void onFinish();

        void onTsPacketReady(TsPacket tsPacket);
    }

    public static class VideoConfig {
        public int height;
        public int width;

        public VideoConfig(String str, byte[] bArr) {
            H265SeqParameterSetRBSP seqParameterSetRBSP;
            if ("video/avc".equalsIgnoreCase(str)) {
                SpsPpsParser spsPpsParser = new SpsPpsParser(bArr);
                spsPpsParser.getPps();
                SeqParameterSet sps = spsPpsParser.getSps();
                if (sps != null) {
                    int i = (sps.picWidthInMbsMinus1 + 1) * 16;
                    this.width = i;
                    int i2 = (sps.picHeightInMapUnitsMinus1 + 1) * 16;
                    this.height = i2;
                    if (sps.frameCroppingFlag) {
                        this.width = (i - sps.frameCropLeftOffset) - sps.frameCropRightOffset;
                        this.height = (i2 - sps.frameCropBottomOffset) - sps.frameCropTopOffset;
                        return;
                    }
                    return;
                }
                return;
            }
            if (!"video/hevc".equalsIgnoreCase(str) || (seqParameterSetRBSP = new H265SpsPpsParser(bArr).getSeqParameterSetRBSP()) == null) {
                return;
            }
            int conf_win_bottom_offset = seqParameterSetRBSP.getConf_win_bottom_offset();
            int conf_win_top_offset = seqParameterSetRBSP.getConf_win_top_offset();
            int conf_win_left_offset = seqParameterSetRBSP.getConf_win_left_offset();
            int conf_win_right_offset = seqParameterSetRBSP.getConf_win_right_offset();
            int subWidthC = seqParameterSetRBSP.getSubWidthC();
            int subHeightC = seqParameterSetRBSP.getSubHeightC();
            this.width = seqParameterSetRBSP.getPic_width_in_luma_samples();
            int pic_height_in_luma_samples = seqParameterSetRBSP.getPic_height_in_luma_samples();
            this.width -= (conf_win_right_offset * subWidthC) + (subWidthC * conf_win_left_offset);
            this.height = pic_height_in_luma_samples - ((conf_win_bottom_offset * subHeightC) + (subHeightC * conf_win_top_offset));
        }

        public int getHeight() {
            return this.height;
        }

        public int getWidth() {
            return this.width;
        }
    }

    public static void MsgToTs(PesPacket pesPacket, ContinuityCounter continuityCounter, TsCallback tsCallback) {
        MsgToTs(pesPacket.mBytes, continuityCounter, pesPacket.isI, pesPacket.pcr, tsCallback);
    }

    public static void PesToTs(PesPacket pesPacket, ContinuityCounter continuityCounter, TsCallback tsCallback) {
        long jNanoTime = System.nanoTime();
        PesToTs2(pesPacket.mBytes, continuityCounter, pesPacket.isI, pesPacket.pcr, tsCallback);
        long jNanoTime2 = System.nanoTime();
        if (VERBOSE) {
            long j = jNanoTime2 - jNanoTime;
            C4638.m14099("TimeMeasure", String.format("PesToTs cost : %s ns , %s ms  ", Long.valueOf(j), Long.valueOf(j / 1000000)));
        }
    }

    private static void PesToTs2(byte[] bArr, ContinuityCounter continuityCounter, boolean z, long j, TsCallback tsCallback) {
        TsHeader tsHeader;
        TsAdaptationField tsAdaptationField;
        int length = bArr.length;
        int length2 = bArr.length;
        long j2 = j;
        while (length2 > 0) {
            byte[] bArr2 = new byte[TsConstants.TS_PACKET_SIZE];
            if (length2 == length) {
                if (z) {
                    tsHeader = new TsHeader(71, 0, 1, 0, 33, 0, 3, continuityCounter.incrementAndGetVideo());
                    long j3 = j2 - 1500;
                    long j4 = j3 >= 0 ? j3 : 0L;
                    tsAdaptationField = new TsAdaptationField(7, 80, PesPacket.convertTime(j4, 1000000L) * 300);
                    j2 = j4;
                } else {
                    TsHeader tsHeader2 = new TsHeader(71, 0, 1, 0, 33, 0, 1, continuityCounter.incrementAndGetVideo());
                    tsAdaptationField = length2 <= 183 ? new TsAdaptationField((184 - length2) - 1, 64, 0L) : null;
                    tsHeader = tsHeader2;
                }
            } else if (length2 > 183) {
                tsAdaptationField = null;
                tsHeader = new TsHeader(71, 0, 0, 0, 33, 0, 1, continuityCounter.incrementAndGetVideo());
            } else {
                tsHeader = new TsHeader(71, 0, 0, 0, 33, 0, 3, continuityCounter.incrementAndGetVideo());
                tsAdaptationField = new TsAdaptationField((184 - length2) - 1, 64, 0L);
            }
            tsHeader.writeToTs(bArr2);
            int i = MPEGConst.GROUP_START_CODE;
            if (tsAdaptationField != null) {
                tsAdaptationField.writeTo(bArr2, 4);
                i = MPEGConst.GROUP_START_CODE - (tsAdaptationField.adaptation_field_length + 1);
                if (VERBOSE) {
                    C4638.m14099("PesToTs2", String.format("needPcr : %s , pcr : %s , adaptation.length : %s ", Boolean.valueOf(z), Long.valueOf(j2), Integer.valueOf(tsAdaptationField.adaptation_field_length + 1)));
                }
            }
            if (VERBOSE) {
                C4638.m14099("PesToTs2", String.format("sumLength : %s , remain_length : %s , srcPos : %s , dstPos : %s , ts_left_length : %s ", Integer.valueOf(length), Integer.valueOf(length2), Integer.valueOf(length - length2), Integer.valueOf(188 - i), Integer.valueOf(i)));
            }
            System.arraycopy(bArr, length - length2, bArr2, 188 - i, i);
            length2 -= i;
            tsCallback.onTsPacketReady(new TsPacket(bArr2));
        }
        if (tsCallback != null) {
            tsCallback.onFinish();
        }
    }

    public static List<EsPacket> mergeToPes(byte b, ArrayList<TsPacket> arrayList) {
        char c;
        int i;
        int i2;
        int i3;
        long jNanoTime = System.nanoTime();
        Iterator<TsPacket> it = arrayList.iterator();
        int i4 = 0;
        while (true) {
            c = 5;
            i = 1;
            if (!it.hasNext()) {
                break;
            }
            TsPacket next = it.next();
            next.refreshHeader();
            if (VERBOSE) {
                C4638.m14099("TsTransferStation", String.format("Header : %s ", next.mTsHeader.toString()));
            }
            byte[] bArr = next.mBytes;
            if ((next.mTsHeader.adaptation_field_control & 2) != 0) {
                int i5 = bArr[4] & ExifInterface.MARKER;
                if (i5 != 0) {
                    byte b2 = bArr[5];
                }
                i3 = i5 + 1;
                if (VERBOSE) {
                    C4638.m14099("TsTransferStation", String.format("adaptation_field_length : %s ", Integer.valueOf(i3)));
                }
            } else {
                i3 = 0;
            }
            int i6 = 4 + i3;
            int i7 = 188 - i6;
            if (VERBOSE) {
                C4638.m14099("TsTransferStation", String.format("startPos : %s , length : %s ", Integer.valueOf(i6), Integer.valueOf(i7)));
            }
            i4 += i7;
        }
        if (VERBOSE) {
            C4638.m14099("TsTransferStation", String.format("after send sumLength : %s , list.size : %s ", Integer.valueOf(i4), Integer.valueOf(arrayList.size())));
        }
        byte[] bArr2 = new byte[i4];
        Iterator<TsPacket> it2 = arrayList.iterator();
        int i8 = 0;
        while (it2.hasNext()) {
            TsPacket next2 = it2.next();
            next2.refreshHeader();
            if (VERBOSE) {
                Object[] objArr = new Object[i];
                objArr[0] = next2.mTsHeader.toString();
                C4638.m14099("TsTransferStation", String.format("Header : %s ", objArr));
            }
            byte[] bArr3 = next2.mBytes;
            if ((next2.mTsHeader.adaptation_field_control & 2) != 0) {
                new TsAdaptationField(bArr3, 4);
                int i9 = bArr3[4] & ExifInterface.MARKER;
                if (i9 != 0) {
                    byte b3 = bArr3[c];
                }
                i2 = i9 + 1;
                if (VERBOSE) {
                    C4638.m14099("TsTransferStation", String.format("adaptation_field_length : %s ", Integer.valueOf(i2)));
                }
            } else {
                i2 = 0;
            }
            int i10 = i2 + 4;
            int i11 = 188 - i10;
            if (VERBOSE) {
                C4638.m14099("TsTransferStation", String.format("startPos : %s , length : %s ", Integer.valueOf(i10), Integer.valueOf(i11)));
            }
            System.arraycopy(bArr3, i10, bArr2, i8, i11);
            i8 += i11;
            c = 5;
            i = 1;
        }
        List<EsPacket> esPacket = new PesPacket(b, bArr2).getEsPacket();
        long jNanoTime2 = System.nanoTime();
        if (VERBOSE) {
            long j = jNanoTime2 - jNanoTime;
            C4638.m14099("TimeMeasure", String.format("mergePes cost : %s ns , %s ms  ", Long.valueOf(j), Long.valueOf(j / 1000000)));
        }
        return esPacket;
    }

    private static void MsgToTs(byte[] bArr, ContinuityCounter continuityCounter, boolean z, long j, TsCallback tsCallback) {
        TsHeader tsHeader;
        TsAdaptationField tsAdaptationField;
        TsHeader tsHeader2;
        int length = bArr.length;
        int length2 = bArr.length;
        long j2 = j;
        while (length2 > 0) {
            byte[] bArr2 = new byte[TsConstants.TS_PACKET_SIZE];
            if (length2 == length) {
                if (z) {
                    tsHeader = new TsHeader(71, 0, 1, 0, TsConstants.kTS_PID_Data, 0, 3, continuityCounter.incrementAndGetVideo());
                    long j3 = j2 - 1500;
                    long j4 = j3 >= 0 ? j3 : 0L;
                    tsAdaptationField = new TsAdaptationField(7, 80, PesPacket.convertTime(j4, 1000000L) * 300);
                    j2 = j4;
                } else if (length2 > 183) {
                    tsHeader2 = new TsHeader(71, 0, 1, 0, TsConstants.kTS_PID_Data, 0, 1, continuityCounter.incrementAndGetVideo());
                    tsAdaptationField = null;
                    tsHeader = tsHeader2;
                } else {
                    tsHeader = new TsHeader(71, 0, 1, 0, TsConstants.kTS_PID_Data, 0, 3, continuityCounter.incrementAndGetVideo());
                    tsAdaptationField = new TsAdaptationField((184 - length2) - 1, 64, 0L);
                }
            } else if (length2 > 183) {
                tsHeader2 = new TsHeader(71, 0, 0, 0, TsConstants.kTS_PID_Data, 0, 1, continuityCounter.incrementAndGetVideo());
                tsAdaptationField = null;
                tsHeader = tsHeader2;
            } else {
                tsHeader = new TsHeader(71, 0, 0, 0, TsConstants.kTS_PID_Data, 0, 3, continuityCounter.incrementAndGetVideo());
                tsAdaptationField = new TsAdaptationField((184 - length2) - 1, 64, 0L);
            }
            tsHeader.writeToTs(bArr2);
            int i = MPEGConst.GROUP_START_CODE;
            if (tsAdaptationField != null) {
                tsAdaptationField.writeTo(bArr2, 4);
                i = MPEGConst.GROUP_START_CODE - (tsAdaptationField.adaptation_field_length + 1);
                if (VERBOSE) {
                    C4638.m14099("PesToTs2", String.format("needPcr : %s , pcr : %s , adaptation.length : %s ", Boolean.valueOf(z), Long.valueOf(j2), Integer.valueOf(tsAdaptationField.adaptation_field_length + 1)));
                }
            }
            if (VERBOSE) {
                C4638.m14099("PesToTs2", String.format("sumLength : %s , remain_length : %s , srcPos : %s , dstPos : %s , ts_left_length : %s ", Integer.valueOf(length), Integer.valueOf(length2), Integer.valueOf(length - length2), Integer.valueOf(188 - i), Integer.valueOf(i)));
            }
            System.arraycopy(bArr, length - length2, bArr2, 188 - i, i);
            length2 -= i;
            tsCallback.onTsPacketReady(new TsPacket(bArr2));
        }
    }

    private static List<byte[]> PesToTs(byte[] bArr, ContinuityCounter continuityCounter, boolean z, long j, TsCallback tsCallback) {
        int i;
        TsHeader tsHeader;
        int i2;
        ArrayList arrayList = new ArrayList();
        int length = bArr.length;
        if (z) {
            length += 8;
        }
        int i3 = length % MPEGConst.GROUP_START_CODE;
        int i4 = length / MPEGConst.GROUP_START_CODE;
        if (VERBOSE) {
            C4638.m14099("TsPacket", String.format("pes.length : %s , needWriteSize : %s , packet_remain : %s , packet_num : %s ", Integer.valueOf(bArr.length), Integer.valueOf(length), Integer.valueOf(i3), Integer.valueOf(i4)));
        }
        if (i4 != 0) {
            if (i4 >= 1) {
                byte[] bArr2 = new byte[TsConstants.TS_PACKET_SIZE];
                if (z) {
                    tsHeader = new TsHeader(71, 0, 1, 0, 33, 0, 3, continuityCounter.incrementAndGetVideo());
                } else {
                    tsHeader = new TsHeader(71, 0, 1, 0, 33, 0, 1, continuityCounter.incrementAndGetVideo());
                }
                int iWriteToTs = tsHeader.writeToTs(bArr2);
                int i5 = iWriteToTs + 0;
                int i6 = 188 - iWriteToTs;
                if (z) {
                    long j2 = j - 1500;
                    new TsAdaptationField(7, 80, PesPacket.convertTime(j2 >= 0 ? j2 : 0L, 1000000L) * 300).writeTo(bArr2, i5);
                    i5 += 8;
                    i6 -= 8;
                }
                System.arraycopy(bArr, 0, bArr2, i5, i6);
                i = 0 + i6;
                i4--;
                arrayList.add(bArr2);
                tsCallback.onTsPacketReady(new TsPacket(bArr2));
            } else {
                i = 0;
            }
            while (i4 > 0) {
                byte[] bArr3 = new byte[TsConstants.TS_PACKET_SIZE];
                System.arraycopy(bArr, i, bArr3, new TsHeader(71, 0, 0, 0, 33, 0, 1, continuityCounter.incrementAndGetVideo()).writeToTs(bArr3) + 0, MPEGConst.GROUP_START_CODE);
                i += MPEGConst.GROUP_START_CODE;
                i4--;
                arrayList.add(bArr3);
                tsCallback.onTsPacketReady(new TsPacket(bArr3));
            }
            if (i3 > 0) {
                byte[] bArr4 = new byte[TsConstants.TS_PACKET_SIZE];
                int iWriteToTs2 = new TsHeader(71, 0, 0, 0, 33, 0, 3, continuityCounter.incrementAndGetVideo()).writeToTs(bArr4) + 0;
                int i7 = 183 - i3;
                if (i7 != 0) {
                    new TsAdaptationField(i7, 64, 0L).writeTo(bArr4, iWriteToTs2);
                    iWriteToTs2 += i7 + 1;
                }
                if (VERBOSE) {
                    C4638.m14099("TsPacket", String.format("packet_num : %s , pos : %s , len : %s , stuff_num : %s , packet_remain : %s ", Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(iWriteToTs2), Integer.valueOf(i7), Integer.valueOf(i3)));
                }
                System.arraycopy(bArr, i, bArr4, iWriteToTs2, i3);
                arrayList.add(bArr4);
                tsCallback.onTsPacketReady(new TsPacket(bArr4));
            }
            return arrayList;
        }
        if (i3 > 0) {
            byte[] bArr5 = new byte[TsConstants.TS_PACKET_SIZE];
            int iWriteToTs3 = new TsHeader(71, 0, 1, 0, 33, 0, 3, continuityCounter.incrementAndGetVideo()).writeToTs(bArr5) + 0;
            int i8 = 183 - i3;
            if (z) {
                long j3 = j - 1500;
                long j4 = j3 >= 0 ? j3 : 0L;
                long jConvertTime = PesPacket.convertTime(j4, 1000000L) * 300;
                i8 -= 8;
                bArr5[iWriteToTs3] = (byte) (7 + i8);
                int i9 = iWriteToTs3 + 1;
                bArr5[i9] = 80;
                int i10 = i9 + 1;
                long j5 = jConvertTime % 300;
                long j6 = jConvertTime / 300;
                if (VERBOSE) {
                    C4638.m14099("TimeConvert", String.format("pcr : %s , time : %s , pcr_low : %s , pcr_high : %s ", Long.valueOf(j4), Long.valueOf(jConvertTime), Long.valueOf(j5), Long.valueOf(j6)));
                }
                int i11 = i10 + 1;
                bArr5[i10] = (byte) ((j6 >> 25) & 255);
                int i12 = i11 + 1;
                bArr5[i11] = (byte) ((j6 >> 17) & 255);
                int i13 = i12 + 1;
                bArr5[i12] = (byte) ((j6 >> 9) & 255);
                int i14 = i13 + 1;
                bArr5[i13] = (byte) ((j6 >> 1) & 255);
                int i15 = i14 + 1;
                bArr5[i14] = (byte) (((j6 << 7) | (j5 >> 8) | 126) & 255);
                iWriteToTs3 = i15 + 1;
                bArr5[i15] = (byte) (j5 & 255);
            }
            if (i8 != 0) {
                bArr5[iWriteToTs3] = (byte) i8;
                int i16 = iWriteToTs3 + 1;
                int i17 = i16;
                while (true) {
                    i2 = i16 + i8;
                    if (i17 >= i2) {
                        break;
                    }
                    bArr5[i17] = -1;
                    i17++;
                }
                iWriteToTs3 = i2;
            }
            if (VERBOSE) {
                C4638.m14099("TsPacket", String.format("pos : %s , len : %s , stuff_num : %s , packet_remain : %s ", 0, Integer.valueOf(iWriteToTs3), Integer.valueOf(i8), Integer.valueOf(i3)));
            }
            System.arraycopy(bArr, 0, bArr5, iWriteToTs3, i3);
            arrayList.add(bArr5);
            tsCallback.onTsPacketReady(new TsPacket(bArr5));
        }
        return arrayList;
    }
}
