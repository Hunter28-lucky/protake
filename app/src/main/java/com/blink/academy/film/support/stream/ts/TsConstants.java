package com.blink.academy.film.support.stream.ts;

/* loaded from: classes.dex */
public interface TsConstants {
    public static final byte ACESType_data = 64;
    public static final byte ACESType_h264 = 27;
    public static final byte ACESType_h265 = 36;
    public static final int MAX_LINK_LIMIT = 4;
    public static final int PCR_FLAG_EXIST = 80;
    public static final int PCR_FLAG_NOT_EXIST = 64;
    public static final int Program_Number_PAM = 1;
    public static final int SYNC_BYTE = 71;
    public static final int TS_PACKET_SIZE = 188;
    public static final boolean VERBOSE = false;
    public static final int kFinderPort = 1137;
    public static final String kLinkParam_block = "h";
    public static final String kLinkParam_cameraType = "m4";
    public static final String kLinkParam_captureEvent = "j";
    public static final String kLinkParam_controlable = "g";
    public static final String kLinkParam_cropVideo = "l";
    public static final String kLinkParam_dimension = "m1";
    public static final String kLinkParam_fps = "m2";
    public static final String kLinkParam_job = "c";
    public static final String kLinkParam_machine = "e";
    public static final String kLinkParam_outRange = "i";
    public static final String kLinkParam_pixelFormat = "m3";
    public static final String kLinkParam_ratio = "k";
    public static final String kLinkParam_recording = "f";
    public static final String kLinkParam_suffix = "b";
    public static final String kLinkParam_uuid = "a";
    public static final String kLinkParam_wifiStatus = "d";
    public static final int kSRTPort = 2311;
    public static final int kSRTPort2 = 1992;
    public static final int kTS_DataStream_Version = 3;
    public static final int kTS_PID_Audio = 34;
    public static final int kTS_PID_Data = 258;
    public static final int kTS_PID_PAT = 0;
    public static final int kTS_PID_PMT = 4096;
    public static final int kTS_PID_Video = 33;
    public static final int kTS_StreamID_Audio = 119;
    public static final int kTS_StreamID_Data = 100;
    public static final int kTS_StreamID_Video = 224;

    public interface H264_NAL_UNIT_TYPE {
        public static final int IDR = 5;
        public static final int NOT_IDR = 1;
        public static final int PPS = 8;
        public static final int SEI = 6;
        public static final int SPLIT = 9;
        public static final int SPS = 7;
        public static final int UNUSED = 0;
    }

    public interface H265_NAL_UNIT_TYPE {
        public static final int IDR = 19;
        public static final int NAL_UINT_CODED_SLICE_STSA_N = 4;
        public static final int NAL_UINT_CODED_SLICE_STSA_R = 5;
        public static final int NAL_UINT_CODED_SLICE_TSA_R = 3;
        public static final int NAL_UNIT_CODED_SLICE_BLA_W_LP = 16;
        public static final int NAL_UNIT_CODED_SLICE_RADL_N = 6;
        public static final int NAL_UNIT_CODED_SLICE_RADL_R = 7;
        public static final int NAL_UNIT_CODED_SLICE_RASL_N = 8;
        public static final int NAL_UNIT_CODED_SLICE_TSA_N = 2;
        public static final int NAL_UNIT_CODE_DATA = 52;
        public static final int NAL_UNIT_CODE_SLICE_BLA_N_LP = 18;
        public static final int NAL_UNIT_CODE_SLICE_BLA_W_RADL = 17;
        public static final int NAL_UNIT_CODE_SLICE_CRA = 21;
        public static final int NAL_UNIT_CODE_SLICE_IDR_N_LP = 20;
        public static final int NAL_UNIT_CODE_SLICE_RASL_R = 9;
        public static final int NAL_UNIT_CODE_SLICE_TRAIL_N = 0;
        public static final int NOT_IDR = 1;
        public static final int PPS = 34;
        public static final int SEI = 39;
        public static final int SPS = 33;
        public static final int VPS = 32;
    }
}
