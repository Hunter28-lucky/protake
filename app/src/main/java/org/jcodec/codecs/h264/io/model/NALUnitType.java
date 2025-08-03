package org.jcodec.codecs.h264.io.model;

/* loaded from: classes2.dex */
public final class NALUnitType {
    public static final NALUnitType ACC_UNIT_DELIM;
    public static final NALUnitType AUX_SLICE;
    public static final NALUnitType END_OF_SEQ;
    public static final NALUnitType END_OF_STREAM;
    public static final NALUnitType FILLER_DATA;
    public static final NALUnitType IDR_SLICE;
    public static final NALUnitType NON_IDR_SLICE;
    public static final NALUnitType PPS;
    public static final NALUnitType SEI;
    public static final NALUnitType SEQ_PAR_SET_EXT;
    public static final NALUnitType SLICE_PART_A;
    public static final NALUnitType SLICE_PART_B;
    public static final NALUnitType SLICE_PART_C;
    public static final NALUnitType SPS;
    private static final NALUnitType[] _values;
    private static final NALUnitType[] lut;
    private String _name;
    private final String displayName;
    private final int value;

    static {
        NALUnitType nALUnitType = new NALUnitType(1, "NON_IDR_SLICE", "non IDR slice");
        NON_IDR_SLICE = nALUnitType;
        NALUnitType nALUnitType2 = new NALUnitType(2, "SLICE_PART_A", "slice part a");
        SLICE_PART_A = nALUnitType2;
        NALUnitType nALUnitType3 = new NALUnitType(3, "SLICE_PART_B", "slice part b");
        SLICE_PART_B = nALUnitType3;
        NALUnitType nALUnitType4 = new NALUnitType(4, "SLICE_PART_C", "slice part c");
        SLICE_PART_C = nALUnitType4;
        NALUnitType nALUnitType5 = new NALUnitType(5, "IDR_SLICE", "idr slice");
        IDR_SLICE = nALUnitType5;
        NALUnitType nALUnitType6 = new NALUnitType(6, "SEI", "sei");
        SEI = nALUnitType6;
        NALUnitType nALUnitType7 = new NALUnitType(7, "SPS", "sequence parameter set");
        SPS = nALUnitType7;
        NALUnitType nALUnitType8 = new NALUnitType(8, "PPS", "picture parameter set");
        PPS = nALUnitType8;
        NALUnitType nALUnitType9 = new NALUnitType(9, "ACC_UNIT_DELIM", "access unit delimiter");
        ACC_UNIT_DELIM = nALUnitType9;
        NALUnitType nALUnitType10 = new NALUnitType(10, "END_OF_SEQ", "end of sequence");
        END_OF_SEQ = nALUnitType10;
        NALUnitType nALUnitType11 = new NALUnitType(11, "END_OF_STREAM", "end of stream");
        END_OF_STREAM = nALUnitType11;
        NALUnitType nALUnitType12 = new NALUnitType(12, "FILLER_DATA", "filler data");
        FILLER_DATA = nALUnitType12;
        NALUnitType nALUnitType13 = new NALUnitType(13, "SEQ_PAR_SET_EXT", "sequence parameter set extension");
        SEQ_PAR_SET_EXT = nALUnitType13;
        NALUnitType nALUnitType14 = new NALUnitType(19, "AUX_SLICE", "auxilary slice");
        AUX_SLICE = nALUnitType14;
        int i = 0;
        _values = new NALUnitType[]{nALUnitType, nALUnitType2, nALUnitType3, nALUnitType4, nALUnitType5, nALUnitType6, nALUnitType7, nALUnitType8, nALUnitType9, nALUnitType10, nALUnitType11, nALUnitType12, nALUnitType13, nALUnitType14};
        lut = new NALUnitType[256];
        while (true) {
            NALUnitType[] nALUnitTypeArr = _values;
            if (i >= nALUnitTypeArr.length) {
                return;
            }
            NALUnitType nALUnitType15 = nALUnitTypeArr[i];
            lut[nALUnitType15.value] = nALUnitType15;
            i++;
        }
    }

    private NALUnitType(int i, String str, String str2) {
        this.value = i;
        this._name = str;
        this.displayName = str2;
    }

    public static NALUnitType fromValue(int i) {
        NALUnitType[] nALUnitTypeArr = lut;
        if (i < nALUnitTypeArr.length) {
            return nALUnitTypeArr[i];
        }
        return null;
    }

    public String getName() {
        return this.displayName;
    }

    public int getValue() {
        return this.value;
    }

    public String toString() {
        return this._name;
    }
}
