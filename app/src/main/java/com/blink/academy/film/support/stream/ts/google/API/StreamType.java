package com.blink.academy.film.support.stream.ts.google.API;

/* loaded from: classes.dex */
public enum StreamType {
    ISO_IEC_Reserved(0),
    ISO_IEC_11172_Video(1),
    ISO_IEC_13818_2_Video(2),
    ISO_IEC_11172_Audio(3),
    ISO_IEC_13818_3_Audio(4),
    ISO_IEC_13818_1_private_sections(5),
    ISO_IEC_13818_1_PES_packets_containing_private_data(6),
    ISO_IEC_13522_MHEG(7),
    ISO_IEC_13818_1_Annex_A_DSM_CC(8);

    private int value;

    StreamType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
