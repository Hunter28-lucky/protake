package org.jcodec.codecs.prores;

import androidx.exifinterface.media.ExifInterface;
import com.google.zxing.oned.Code39Reader;
import java.nio.ByteBuffer;
import org.jcodec.codecs.prores.ProresConsts;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.io.BitWriter;

/* loaded from: classes2.dex */
public class ProresToProxy {
    private static final int START_QP = 6;
    private int bitsPer1024;
    private int bitsPer1024High;
    private int bitsPer1024Low;
    private int frameSize;
    private int nCoeffs;
    private int[] qMatLumaTo = ProresConsts.QMAT_LUMA_APCO;
    private int[] qMatChromaTo = ProresConsts.QMAT_CHROMA_APCO;

    public ProresToProxy(int i, int i2, int i3) {
        this.frameSize = i3;
        int i4 = ((i3 - ((((i2 >> 4) * (((i >> 4) + 7) >> 3)) * 8) + Code39Reader.ASTERISK_ENCODING)) << 3) << 10;
        int i5 = i * i2;
        int i6 = i4 / i5;
        this.bitsPer1024 = i6;
        this.bitsPer1024High = i6 - (i6 / 10);
        this.bitsPer1024Low = i6 - (i6 / 20);
        this.nCoeffs = Math.max(Math.min(33000 / (i5 >> 8), 64), 4);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void transcodePicture(java.nio.ByteBuffer r28, java.nio.ByteBuffer r29, org.jcodec.codecs.prores.ProresConsts.FrameHeader r30) {
        /*
            Method dump skipped, instructions count: 199
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jcodec.codecs.prores.ProresToProxy.transcodePicture(java.nio.ByteBuffer, java.nio.ByteBuffer, org.jcodec.codecs.prores.ProresConsts$FrameHeader):void");
    }

    private void transcodeSlice(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int[] iArr, int[] iArr2, int[] iArr3, int i, int i2, int i3, short s, int i4) {
        int i5 = (byteBuffer.get() & ExifInterface.MARKER) >> 3;
        int iClip = ProresDecoder.clip(byteBuffer.get() & ExifInterface.MARKER, 1, 224);
        if (iClip > 128) {
            iClip = (iClip - 96) << 2;
        }
        int i6 = iClip;
        short s2 = byteBuffer.getShort();
        short s3 = byteBuffer.getShort();
        byteBuffer2.put((byte) 48);
        byteBuffer2.put((byte) i4);
        ByteBuffer byteBufferDuplicate = byteBuffer2.duplicate();
        byteBuffer2.putInt(0);
        int iPosition = byteBuffer2.position();
        requant(ProresDecoder.bitstream(byteBuffer, s2), new BitWriter(byteBuffer2), i << 2, ProresDecoder.scaleMat(iArr, i6), ProresDecoder.scaleMat(this.qMatLumaTo, i4), iArr3, i2, i3, 0);
        int iPosition2 = byteBuffer2.position();
        int i7 = i << 1;
        requant(ProresDecoder.bitstream(byteBuffer, s3), new BitWriter(byteBuffer2), i7, ProresDecoder.scaleMat(iArr2, i6), ProresDecoder.scaleMat(this.qMatChromaTo, i4), iArr3, i2, i3, 1);
        int iPosition3 = byteBuffer2.position();
        requant(ProresDecoder.bitstream(byteBuffer, ((s - s3) - s2) - i5), new BitWriter(byteBuffer2), i7, ProresDecoder.scaleMat(iArr2, i6), ProresDecoder.scaleMat(this.qMatChromaTo, i4), iArr3, i2, i3, 2);
        byteBufferDuplicate.putShort((short) (iPosition2 - iPosition));
        byteBufferDuplicate.putShort((short) (iPosition3 - iPosition2));
    }

    public int getFrameSize() {
        return this.frameSize;
    }

    public void requant(BitReader bitReader, BitWriter bitWriter, int i, int[] iArr, int[] iArr2, int[] iArr3, int i2, int i3, int i4) {
        int i5 = i << 6;
        int[] iArr4 = new int[i5];
        try {
            ProresDecoder.readDCCoeffs(bitReader, iArr, iArr4, i, 64);
            ProresDecoder.readACCoeffs(bitReader, iArr, iArr4, i, iArr3, this.nCoeffs, 6);
        } catch (RuntimeException unused) {
        }
        for (int i6 = 0; i6 < i5; i6++) {
            iArr4[i6] = iArr4[i6] << 2;
        }
        ProresEncoder.writeDCCoeffs(bitWriter, iArr2, iArr4, i);
        ProresEncoder.writeACCoeffs(bitWriter, iArr2, iArr4, i, iArr3, this.nCoeffs);
        bitWriter.flush();
    }

    public void transcode(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        ByteBuffer byteBufferDuplicate = byteBuffer2.duplicate();
        ProresConsts.FrameHeader frameHeader = ProresDecoder.readFrameHeader(byteBuffer);
        ProresEncoder.writeFrameHeader(byteBuffer2, frameHeader);
        int iPosition = byteBuffer2.position();
        if (frameHeader.frameType == 0) {
            transcodePicture(byteBuffer, byteBuffer2, frameHeader);
        } else {
            transcodePicture(byteBuffer, byteBuffer2, frameHeader);
            transcodePicture(byteBuffer, byteBuffer2, frameHeader);
        }
        frameHeader.qMatLuma = this.qMatLumaTo;
        frameHeader.qMatChroma = this.qMatChromaTo;
        frameHeader.payloadSize = byteBuffer2.position() - iPosition;
        ProresEncoder.writeFrameHeader(byteBufferDuplicate, frameHeader);
    }
}
