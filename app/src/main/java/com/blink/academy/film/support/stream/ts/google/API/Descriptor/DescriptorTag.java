package com.blink.academy.film.support.stream.ts.google.API.Descriptor;

import org.jcodec.codecs.vpx.vp9.Consts;

/* loaded from: classes.dex */
public enum DescriptorTag {
    STUFFING(128),
    AC3_AUDIO(129),
    CAPTION_SERVICE(134),
    CONTENT_ADVISORY(135),
    EXTENDED_CHANNEL_NAME(Consts.BORDERINPIXELS),
    SERVICE_LOCATION(161),
    TIMESHIFTED_SERVICE(162),
    COMPONENT_NAME(163),
    DCC_DEPARTING_REQUEST(168),
    DCC_ARRIVING_REQUEST(169),
    REDISTRIBUTION_CONTROL(170),
    ATSC_PRIVATE_INFORMATION(173),
    CONTENT_IDENTIFIER(182),
    GENRE(171);

    private int value;

    DescriptorTag(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    @Override // java.lang.Enum
    public String toString() {
        int i = this.value;
        if (i == 128) {
            return "STUFFING";
        }
        if (i == 129) {
            return "AC3_AUDIO";
        }
        if (i == 134) {
            return "CAPTION_SERVICE";
        }
        if (i == 135) {
            return "CONTENT_ADVISORY";
        }
        if (i == 173) {
            return "ATSC_PRIVATE_INFORMATION";
        }
        if (i == 182) {
            return "CONTENT_IDENTIFIER";
        }
        switch (i) {
            case Consts.BORDERINPIXELS /* 160 */:
                return "EXTENDED_CHANNEL_NAME";
            case 161:
                return "SERVICE_LOCATION";
            case 162:
                return "TIMESHIFTED_SERVICE";
            case 163:
                return "COMPONENT_NAME";
            default:
                switch (i) {
                    case 168:
                        return "DCC_DEPARTING_REQUEST";
                    case 169:
                        return "DCC_ARRIVING_REQUEST";
                    case 170:
                        return "REDISTRIBUTION_CONTROL";
                    default:
                        return "UNKNOWN";
                }
        }
    }
}
