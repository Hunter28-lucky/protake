package org.jcodec.containers.mxf;

import org.jcodec.common.Codec;
import org.jcodec.containers.mxf.model.UL;

/* loaded from: classes2.dex */
public class MXFCodec {
    public static final MXFCodec AC3;
    public static final MXFCodec AVC_INTRA;
    public static final MXFCodec AVC_SPSPPS;
    public static final MXFCodec DV_25_PAL;
    public static final MXFCodec JPEG2000;
    public static final MXFCodec MP2;
    public static final MXFCodec MPEG2_D10_PAL;
    public static final MXFCodec MPEG2_HL;
    public static final MXFCodec MPEG2_HL_422_I;
    public static final MXFCodec MPEG2_ML;
    public static final MXFCodec MPEG2_XDCAM;
    public static final MXFCodec MPEG4_XDCAM_PROXY;
    public static final MXFCodec PCM_ALAW;
    public static final MXFCodec PCM_S16BE;
    public static final MXFCodec PCM_S16LE_1;
    public static final MXFCodec PCM_S16LE_2;
    public static final MXFCodec PCM_S16LE_3;
    public static final MXFCodec PRORES;
    public static final MXFCodec PRORES_AVID;
    public static final MXFCodec RAW;
    public static final MXFCodec RAW_422;
    public static final MXFCodec UNKNOWN;
    public static final MXFCodec V210;
    public static final MXFCodec VC1;
    public static final MXFCodec VC3_DNXHD;
    public static final MXFCodec VC3_DNXHD_2;
    public static final MXFCodec VC3_DNXHD_AVID;
    private final Codec codec;
    private final UL ul;

    static {
        Codec codec = Codec.MPEG2;
        MPEG2_XDCAM = mxfCodec("06.0E.2B.34.04.01.01.03.04.01.02.02.01.04.03", codec);
        MPEG2_ML = mxfCodec("06.0E.2B.34.04.01.01.03.04.01.02.02.01.01.11", codec);
        MPEG2_D10_PAL = mxfCodec("06.0E.2B.34.04.01.01.01.04.01.02.02.01.02.01.01", codec);
        MPEG2_HL = mxfCodec("06.0E.2B.34.04.01.01.03.04.01.02.02.01.03.03", codec);
        MPEG2_HL_422_I = mxfCodec("06.0E.2B.34.04.01.01.03.04.01.02.02.01.04.02", codec);
        MPEG4_XDCAM_PROXY = mxfCodec("06.0E.2B.34.04.01.01.03.04.01.02.02.01.20.02.03", Codec.MPEG4);
        DV_25_PAL = mxfCodec("06.0E.2B.34.04.01.01.01.04.01.02.02.02.01.02", Codec.DV);
        JPEG2000 = mxfCodec("06.0E.2B.34.04.01.01.07.04.01.02.02.03.01.01", Codec.J2K);
        VC1 = mxfCodec("06.0e.2b.34.04.01.01.0A.04.01.02.02.04", Codec.VC1);
        RAW = mxfCodec("06.0E.2B.34.04.01.01.01.04.01.02.01.7F", null);
        RAW_422 = mxfCodec("06.0E.2B.34.04.01.01.0A.04.01.02.01.01.02.01", null);
        Codec codec2 = Codec.VC3;
        VC3_DNXHD = mxfCodec("06.0E.2B.34.04.01.01.01.04.01.02.02.03.02", codec2);
        VC3_DNXHD_2 = mxfCodec("06.0E.2B.34.04.01.01.01.04.01.02.02.71", codec2);
        VC3_DNXHD_AVID = mxfCodec("06.0E.2B.34.04.01.01.01.0E.04.02.01.02.04.01", codec2);
        Codec codec3 = Codec.H264;
        AVC_INTRA = mxfCodec("06.0E.2B.34.04.01.01.0A.04.01.02.02.01.32", codec3);
        AVC_SPSPPS = mxfCodec("06.0E.2B.34.04.01.01.0A.04.01.02.02.01.31.11.01", codec3);
        V210 = mxfCodec("06.0E.2B.34.04.01.01.0A.04.01.02.01.01.02.02", Codec.V210);
        Codec codec4 = Codec.PRORES;
        PRORES_AVID = mxfCodec("06.0E.2B.34.04.01.01.01.0E.04.02.01.02.11", codec4);
        PRORES = mxfCodec("06.0E.2B.34.04.01.01.0D.04.01.02.02.03.06", codec4);
        PCM_S16LE_1 = mxfCodec("06.0E.2B.34.04.01.01.01.04.02.02.01", null);
        PCM_S16LE_3 = mxfCodec("06.0E.2B.34.04.01.01.01.04.02.02.01.01", null);
        PCM_S16LE_2 = mxfCodec("06.0E.2B.34.04.01.01.01.04.02.02.01.7F", null);
        PCM_S16BE = mxfCodec("06.0E.2B.34.04.01.01.07.04.02.02.01.7E", null);
        PCM_ALAW = mxfCodec("06.0E.2B.34.04.01.01.04.04.02.02.02.03.01.01", Codec.ALAW);
        AC3 = mxfCodec("06.0E.2B.34.04.01.01.01.04.02.02.02.03.02.01", Codec.AC3);
        MP2 = mxfCodec("06.0E.2B.34.04.01.01.01.04.02.02.02.03.02.05", Codec.MP3);
        UNKNOWN = new MXFCodec(new UL(new byte[0]), null);
    }

    public MXFCodec(UL ul, Codec codec) {
        this.ul = ul;
        this.codec = codec;
    }

    public static MXFCodec mxfCodec(String str, Codec codec) {
        return new MXFCodec(UL.newUL(str), codec);
    }

    public static MXFCodec[] values() {
        return new MXFCodec[]{MPEG2_XDCAM, MPEG2_ML, MPEG2_D10_PAL, MPEG2_HL, MPEG2_HL_422_I, MPEG4_XDCAM_PROXY, DV_25_PAL, JPEG2000, VC1, RAW, RAW_422, VC3_DNXHD, VC3_DNXHD_2, VC3_DNXHD_AVID, AVC_INTRA, AVC_SPSPPS, V210, PRORES_AVID, PRORES, PCM_S16LE_1, PCM_S16LE_3, PCM_S16LE_2, PCM_S16BE, PCM_ALAW, AC3, MP2};
    }

    public Codec getCodec() {
        return this.codec;
    }

    public UL getUl() {
        return this.ul;
    }
}
