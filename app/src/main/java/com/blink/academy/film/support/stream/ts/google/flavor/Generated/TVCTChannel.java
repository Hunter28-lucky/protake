package com.blink.academy.film.support.stream.ts.google.flavor.Generated;

import com.blink.academy.film.support.stream.ts.google.flavor.IBitstream;
import com.blink.academy.film.support.stream.ts.google.flavor.Util;
import com.blink.academy.film.support.stream.ts.google.flavor.XML;
import java.io.IOException;

/* loaded from: classes.dex */
public class TVCTChannel {
    public int ETM_location;
    public int access_controlled;
    public int carrier_frequency;
    public int channel_TSID;
    public Descriptor descriptor;
    public int descriptors_length;
    public int hidden;
    public int hide_guide;
    public int major_channel_number;
    public int minor_channel_number;
    public int modulation_mode;
    public int program_number;
    public int remain_desc_bytes;
    public int reserved1;
    public int reserved2;
    public int reserved3;
    public int reserved4;
    public int service_type;
    public int[] short_name = new int[64];
    public int source_id;

    public int get(IBitstream iBitstream) throws IOException {
        int i;
        Util.trace(iBitstream.getpos(), 0, 0, "begin TVCTChannel");
        for (int i2 = 0; i2 < 7; i2++) {
            this.short_name[i2] = iBitstream.getbits(16);
            Util.trace(iBitstream.getpos() - 16, 16, this.short_name[i2], "short_name[" + i2 + "] (" + this.short_name[i2] + ")");
        }
        int i3 = iBitstream.getbits(4);
        this.reserved1 = i3;
        if (i3 != 15) {
            Util.flerror("Const value mismatch for 'reserved1'");
            Util.trace(iBitstream.getpos() - 4, 4, this.reserved1, "reserved1 (" + this.reserved1 + ") [ERROR]");
            i = 1;
        } else {
            Util.trace(iBitstream.getpos() - 4, 4, this.reserved1, "reserved1 (" + this.reserved1 + ")");
            i = 0;
        }
        this.major_channel_number = iBitstream.getbits(10);
        Util.trace(iBitstream.getpos() - 10, 10, this.major_channel_number, "major_channel_number (" + this.major_channel_number + ")");
        this.minor_channel_number = iBitstream.getbits(10);
        Util.trace(iBitstream.getpos() - 10, 10, this.minor_channel_number, "minor_channel_number (" + this.minor_channel_number + ")");
        this.modulation_mode = iBitstream.getbits(8);
        Util.trace(iBitstream.getpos() - 8, 8, this.modulation_mode, "modulation_mode (" + this.modulation_mode + ")");
        this.carrier_frequency = iBitstream.getbits(32);
        Util.trace(iBitstream.getpos() - 32, 32, this.carrier_frequency, "carrier_frequency (" + this.carrier_frequency + ")");
        this.channel_TSID = iBitstream.getbits(16);
        Util.trace(iBitstream.getpos() - 16, 16, this.channel_TSID, "channel_TSID (" + this.channel_TSID + ")");
        this.program_number = iBitstream.getbits(16);
        Util.trace(iBitstream.getpos() - 16, 16, this.program_number, "program_number (" + this.program_number + ")");
        this.ETM_location = iBitstream.getbits(2);
        Util.trace(iBitstream.getpos() - 2, 2, this.ETM_location, "ETM_location (" + this.ETM_location + ")");
        this.access_controlled = iBitstream.getbits(1);
        Util.trace(iBitstream.getpos() - 1, 1, this.access_controlled, "access_controlled (" + this.access_controlled + ")");
        this.hidden = iBitstream.getbits(1);
        Util.trace(iBitstream.getpos() - 1, 1, this.hidden, "hidden (" + this.hidden + ")");
        int i4 = iBitstream.getbits(2);
        this.reserved2 = i4;
        if (i4 != 3) {
            Util.flerror("Const value mismatch for 'reserved2'");
            i++;
            Util.trace(iBitstream.getpos() - 2, 2, this.reserved2, "reserved2 (" + this.reserved2 + ") [ERROR]");
        } else {
            Util.trace(iBitstream.getpos() - 2, 2, this.reserved2, "reserved2 (" + this.reserved2 + ")");
        }
        this.hide_guide = iBitstream.getbits(1);
        Util.trace(iBitstream.getpos() - 1, 1, this.hide_guide, "hide_guide (" + this.hide_guide + ")");
        int i5 = iBitstream.getbits(3);
        this.reserved3 = i5;
        if (i5 != 7) {
            Util.flerror("Const value mismatch for 'reserved3'");
            i++;
            Util.trace(iBitstream.getpos() - 3, 3, this.reserved3, "reserved3 (" + this.reserved3 + ") [ERROR]");
        } else {
            Util.trace(iBitstream.getpos() - 3, 3, this.reserved3, "reserved3 (" + this.reserved3 + ")");
        }
        this.service_type = iBitstream.getbits(6);
        Util.trace(iBitstream.getpos() - 6, 6, this.service_type, "service_type (" + this.service_type + ")");
        this.source_id = iBitstream.getbits(16);
        Util.trace(iBitstream.getpos() - 16, 16, this.source_id, "source_id (" + this.source_id + ")");
        int i6 = iBitstream.getbits(6);
        this.reserved4 = i6;
        if (i6 != 63) {
            Util.flerror("Const value mismatch for 'reserved4'");
            i++;
            Util.trace(iBitstream.getpos() - 6, 6, this.reserved4, "reserved4 (" + this.reserved4 + ") [ERROR]");
        } else {
            Util.trace(iBitstream.getpos() - 6, 6, this.reserved4, "reserved4 (" + this.reserved4 + ")");
        }
        this.descriptors_length = iBitstream.getbits(10);
        Util.trace(iBitstream.getpos() - 10, 10, this.descriptors_length, "descriptors_length (" + this.descriptors_length + ")");
        this.remain_desc_bytes = this.descriptors_length;
        while (this.remain_desc_bytes > 0) {
            Util.trace(iBitstream.getpos(), 0, 0, "processing Descriptor descriptor");
            Descriptor descriptor = new Descriptor();
            this.descriptor = descriptor;
            i += descriptor.get(iBitstream);
            this.remain_desc_bytes -= this.descriptor._F_lengthof / 8;
        }
        Util.trace(iBitstream.getpos(), 0, 0, "end TVCTChannel");
        return i;
    }

    public int put(IBitstream iBitstream) throws IOException {
        int iPut = 0;
        for (int i = 0; i < 7; i++) {
            iBitstream.putbits(this.short_name[i], 16);
        }
        this.reserved1 = 15;
        iBitstream.putbits(15, 4);
        iBitstream.putbits(this.major_channel_number, 10);
        iBitstream.putbits(this.minor_channel_number, 10);
        iBitstream.putbits(this.modulation_mode, 8);
        iBitstream.putbits(this.carrier_frequency, 32);
        iBitstream.putbits(this.channel_TSID, 16);
        iBitstream.putbits(this.program_number, 16);
        iBitstream.putbits(this.ETM_location, 2);
        iBitstream.putbits(this.access_controlled, 1);
        iBitstream.putbits(this.hidden, 1);
        this.reserved2 = 3;
        iBitstream.putbits(3, 2);
        iBitstream.putbits(this.hide_guide, 1);
        this.reserved3 = 7;
        iBitstream.putbits(7, 3);
        iBitstream.putbits(this.service_type, 6);
        iBitstream.putbits(this.source_id, 16);
        this.reserved4 = 63;
        iBitstream.putbits(63, 6);
        iBitstream.putbits(this.descriptors_length, 10);
        this.remain_desc_bytes = this.descriptors_length;
        while (this.remain_desc_bytes > 0) {
            iPut += this.descriptor.put(iBitstream);
            this.remain_desc_bytes -= this.descriptor._F_lengthof / 8;
        }
        return iPut;
    }

    public int putxml(IBitstream iBitstream, boolean z) throws IOException {
        int iPutxml;
        for (int i = 0; i < 7; i++) {
            this.short_name[i] = iBitstream.getbits(16);
            if (z) {
                XML.WriteXmlElement("<short_name type=\"flUInt\" bitLen=\"16\">" + this.short_name[i] + "</short_name>");
            } else {
                XML.WriteXmlElement("<short_name bitLen=\"16\">" + this.short_name[i] + "</short_name>");
            }
        }
        int i2 = iBitstream.getbits(4);
        this.reserved1 = i2;
        if (i2 != 15) {
            Util.flerror("Const value mismatch for 'reserved1'");
            if (z) {
                XML.WriteXmlElement("<reserved1 type=\"flUInt\" bitLen=\"4\">" + this.reserved1 + "</reserved1>");
            } else {
                XML.WriteXmlElement("<reserved1 bitLen=\"4\">" + this.reserved1 + "</reserved1>");
            }
            iPutxml = 1;
        } else {
            if (z) {
                XML.WriteXmlElement("<reserved1 type=\"flUInt\" bitLen=\"4\">" + this.reserved1 + "</reserved1>");
            } else {
                XML.WriteXmlElement("<reserved1 bitLen=\"4\">" + this.reserved1 + "</reserved1>");
            }
            Util.trace(iBitstream.getpos() - 4, 4, this.reserved1, "reserved1 (" + this.reserved1 + ")");
            iPutxml = 0;
        }
        this.major_channel_number = iBitstream.getbits(10);
        if (z) {
            XML.WriteXmlElement("<major_channel_number type=\"flUInt\" bitLen=\"10\">" + this.major_channel_number + "</major_channel_number>");
        } else {
            XML.WriteXmlElement("<major_channel_number bitLen=\"10\">" + this.major_channel_number + "</major_channel_number>");
        }
        this.minor_channel_number = iBitstream.getbits(10);
        if (z) {
            XML.WriteXmlElement("<minor_channel_number type=\"flUInt\" bitLen=\"10\">" + this.minor_channel_number + "</minor_channel_number>");
        } else {
            XML.WriteXmlElement("<minor_channel_number bitLen=\"10\">" + this.minor_channel_number + "</minor_channel_number>");
        }
        this.modulation_mode = iBitstream.getbits(8);
        if (z) {
            XML.WriteXmlElement("<modulation_mode type=\"flUInt\" bitLen=\"8\">" + this.modulation_mode + "</modulation_mode>");
        } else {
            XML.WriteXmlElement("<modulation_mode bitLen=\"8\">" + this.modulation_mode + "</modulation_mode>");
        }
        this.carrier_frequency = iBitstream.getbits(32);
        if (z) {
            XML.WriteXmlElement("<carrier_frequency type=\"flUInt\" bitLen=\"32\">" + this.carrier_frequency + "</carrier_frequency>");
        } else {
            XML.WriteXmlElement("<carrier_frequency bitLen=\"32\">" + this.carrier_frequency + "</carrier_frequency>");
        }
        this.channel_TSID = iBitstream.getbits(16);
        if (z) {
            XML.WriteXmlElement("<channel_TSID type=\"flUInt\" bitLen=\"16\">" + this.channel_TSID + "</channel_TSID>");
        } else {
            XML.WriteXmlElement("<channel_TSID bitLen=\"16\">" + this.channel_TSID + "</channel_TSID>");
        }
        this.program_number = iBitstream.getbits(16);
        if (z) {
            XML.WriteXmlElement("<program_number type=\"flUInt\" bitLen=\"16\">" + this.program_number + "</program_number>");
        } else {
            XML.WriteXmlElement("<program_number bitLen=\"16\">" + this.program_number + "</program_number>");
        }
        this.ETM_location = iBitstream.getbits(2);
        if (z) {
            XML.WriteXmlElement("<ETM_location type=\"flUInt\" bitLen=\"2\">" + this.ETM_location + "</ETM_location>");
        } else {
            XML.WriteXmlElement("<ETM_location bitLen=\"2\">" + this.ETM_location + "</ETM_location>");
        }
        this.access_controlled = iBitstream.getbits(1);
        if (z) {
            XML.WriteXmlElement("<access_controlled type=\"flUInt\" bitLen=\"1\">" + this.access_controlled + "</access_controlled>");
        } else {
            XML.WriteXmlElement("<access_controlled bitLen=\"1\">" + this.access_controlled + "</access_controlled>");
        }
        this.hidden = iBitstream.getbits(1);
        if (z) {
            XML.WriteXmlElement("<hidden type=\"flUInt\" bitLen=\"1\">" + this.hidden + "</hidden>");
        } else {
            XML.WriteXmlElement("<hidden bitLen=\"1\">" + this.hidden + "</hidden>");
        }
        int i3 = iBitstream.getbits(2);
        this.reserved2 = i3;
        if (i3 != 3) {
            Util.flerror("Const value mismatch for 'reserved2'");
            iPutxml++;
            if (z) {
                XML.WriteXmlElement("<reserved2 type=\"flUInt\" bitLen=\"2\">" + this.reserved2 + "</reserved2>");
            } else {
                XML.WriteXmlElement("<reserved2 bitLen=\"2\">" + this.reserved2 + "</reserved2>");
            }
        } else {
            if (z) {
                XML.WriteXmlElement("<reserved2 type=\"flUInt\" bitLen=\"2\">" + this.reserved2 + "</reserved2>");
            } else {
                XML.WriteXmlElement("<reserved2 bitLen=\"2\">" + this.reserved2 + "</reserved2>");
            }
            Util.trace(iBitstream.getpos() - 2, 2, this.reserved2, "reserved2 (" + this.reserved2 + ")");
        }
        this.hide_guide = iBitstream.getbits(1);
        if (z) {
            XML.WriteXmlElement("<hide_guide type=\"flUInt\" bitLen=\"1\">" + this.hide_guide + "</hide_guide>");
        } else {
            XML.WriteXmlElement("<hide_guide bitLen=\"1\">" + this.hide_guide + "</hide_guide>");
        }
        int i4 = iBitstream.getbits(3);
        this.reserved3 = i4;
        if (i4 != 7) {
            Util.flerror("Const value mismatch for 'reserved3'");
            iPutxml++;
            if (z) {
                XML.WriteXmlElement("<reserved3 type=\"flUInt\" bitLen=\"3\">" + this.reserved3 + "</reserved3>");
            } else {
                XML.WriteXmlElement("<reserved3 bitLen=\"3\">" + this.reserved3 + "</reserved3>");
            }
        } else {
            if (z) {
                XML.WriteXmlElement("<reserved3 type=\"flUInt\" bitLen=\"3\">" + this.reserved3 + "</reserved3>");
            } else {
                XML.WriteXmlElement("<reserved3 bitLen=\"3\">" + this.reserved3 + "</reserved3>");
            }
            Util.trace(iBitstream.getpos() - 3, 3, this.reserved3, "reserved3 (" + this.reserved3 + ")");
        }
        this.service_type = iBitstream.getbits(6);
        if (z) {
            XML.WriteXmlElement("<service_type type=\"flUInt\" bitLen=\"6\">" + this.service_type + "</service_type>");
        } else {
            XML.WriteXmlElement("<service_type bitLen=\"6\">" + this.service_type + "</service_type>");
        }
        this.source_id = iBitstream.getbits(16);
        if (z) {
            XML.WriteXmlElement("<source_id type=\"flUInt\" bitLen=\"16\">" + this.source_id + "</source_id>");
        } else {
            XML.WriteXmlElement("<source_id bitLen=\"16\">" + this.source_id + "</source_id>");
        }
        int i5 = iBitstream.getbits(6);
        this.reserved4 = i5;
        if (i5 != 63) {
            Util.flerror("Const value mismatch for 'reserved4'");
            iPutxml++;
            if (z) {
                XML.WriteXmlElement("<reserved4 type=\"flUInt\" bitLen=\"6\">" + this.reserved4 + "</reserved4>");
            } else {
                XML.WriteXmlElement("<reserved4 bitLen=\"6\">" + this.reserved4 + "</reserved4>");
            }
        } else {
            if (z) {
                XML.WriteXmlElement("<reserved4 type=\"flUInt\" bitLen=\"6\">" + this.reserved4 + "</reserved4>");
            } else {
                XML.WriteXmlElement("<reserved4 bitLen=\"6\">" + this.reserved4 + "</reserved4>");
            }
            Util.trace(iBitstream.getpos() - 6, 6, this.reserved4, "reserved4 (" + this.reserved4 + ")");
        }
        this.descriptors_length = iBitstream.getbits(10);
        if (z) {
            XML.WriteXmlElement("<descriptors_length type=\"flUInt\" bitLen=\"10\">" + this.descriptors_length + "</descriptors_length>");
        } else {
            XML.WriteXmlElement("<descriptors_length bitLen=\"10\">" + this.descriptors_length + "</descriptors_length>");
        }
        this.remain_desc_bytes = this.descriptors_length;
        while (this.remain_desc_bytes > 0) {
            Util.trace(iBitstream.getpos(), 0, 0, "processing Descriptor descriptor");
            this.descriptor = new Descriptor();
            XML.IntoAClass("descriptor", 0);
            iPutxml += this.descriptor.putxml(iBitstream, z);
            XML.OutOfClass("</descriptor>");
            this.remain_desc_bytes -= this.descriptor._F_lengthof / 8;
        }
        return iPutxml;
    }
}
