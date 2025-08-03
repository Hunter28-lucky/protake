package org.jcodec.codecs.h264.decode;

import java.lang.reflect.Array;
import org.jcodec.codecs.h264.H264Utils;
import org.jcodec.codecs.h264.io.model.PictureParameterSet;
import org.jcodec.codecs.h264.io.model.SeqParameterSet;
import org.jcodec.codecs.h264.io.model.SliceHeader;
import org.jcodec.common.model.ColorSpace;

/* loaded from: classes2.dex */
public class DecoderState {
    public ColorSpace chromaFormat;
    public int[] chromaQpOffset;
    public byte[][] leftRow;
    public H264Utils.MvList mvLeft;
    public H264Utils.MvList mvTop;
    public H264Utils.MvList mvTopLeft;
    public int qp;
    public byte[][] topLeft;
    public byte[][] topLine;

    public DecoderState(SliceHeader sliceHeader) {
        SeqParameterSet seqParameterSet = sliceHeader.sps;
        int i = seqParameterSet.picWidthInMbsMinus1 + 1;
        int[] iArr = new int[2];
        PictureParameterSet pictureParameterSet = sliceHeader.pps;
        int i2 = pictureParameterSet.chromaQpIndexOffset;
        iArr[0] = i2;
        PictureParameterSet.PPSExt pPSExt = pictureParameterSet.extended;
        iArr[1] = pPSExt != null ? pPSExt.secondChromaQpIndexOffset : i2;
        this.chromaQpOffset = iArr;
        this.chromaFormat = seqParameterSet.chromaFormatIdc;
        this.mvTop = new H264Utils.MvList((i << 2) + 1);
        this.mvLeft = new H264Utils.MvList(4);
        this.mvTopLeft = new H264Utils.MvList(1);
        this.leftRow = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, 3, 16);
        this.topLeft = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, 3, 4);
        this.topLine = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, 3, i << 4);
        this.qp = sliceHeader.pps.picInitQpMinus26 + 26 + sliceHeader.sliceQpDelta;
    }
}
