package com.blink.academy.film.support.stream.ts.google.flavor.Generated;

import com.blink.academy.film.support.stream.ts.google.flavor.IBitstream;
import com.blink.academy.film.support.stream.ts.google.flavor.Util;
import com.blink.academy.film.support.stream.ts.google.flavor.XML;
import java.io.IOException;

/* loaded from: classes.dex */
public class EITEvent {
    public int ETM_location;
    public Descriptor descriptor;
    public int descriptors_length;
    public int event_id;
    public int length_in_seconds;
    public int remain_desc_bytes;
    public int reserved1;
    public int reserved2;
    public int reserved3;
    public int start_time;
    public int title_length;
    public MultiString title_text;

    public int get(IBitstream iBitstream) throws IOException {
        int i;
        Util.trace(iBitstream.getpos(), 0, 0, "begin EITEvent");
        int i2 = iBitstream.getbits(2);
        this.reserved1 = i2;
        if (i2 != 3) {
            Util.flerror("Const value mismatch for 'reserved1'");
            Util.trace(iBitstream.getpos() - 2, 2, this.reserved1, "reserved1 (" + this.reserved1 + ") [ERROR]");
            i = 1;
        } else {
            Util.trace(iBitstream.getpos() - 2, 2, this.reserved1, "reserved1 (" + this.reserved1 + ")");
            i = 0;
        }
        this.event_id = iBitstream.getbits(14);
        Util.trace(iBitstream.getpos() - 14, 14, this.event_id, "event_id (" + this.event_id + ")");
        this.start_time = iBitstream.getbits(32);
        Util.trace(iBitstream.getpos() - 32, 32, this.start_time, "start_time (" + this.start_time + ")");
        int i3 = iBitstream.getbits(2);
        this.reserved2 = i3;
        if (i3 != 3) {
            Util.flerror("Const value mismatch for 'reserved2'");
            i++;
            Util.trace(iBitstream.getpos() - 2, 2, this.reserved2, "reserved2 (" + this.reserved2 + ") [ERROR]");
        } else {
            Util.trace(iBitstream.getpos() - 2, 2, this.reserved2, "reserved2 (" + this.reserved2 + ")");
        }
        this.ETM_location = iBitstream.getbits(2);
        Util.trace(iBitstream.getpos() - 2, 2, this.ETM_location, "ETM_location (" + this.ETM_location + ")");
        this.length_in_seconds = iBitstream.getbits(20);
        Util.trace(iBitstream.getpos() - 20, 20, this.length_in_seconds, "length_in_seconds (" + this.length_in_seconds + ")");
        this.title_length = iBitstream.getbits(8);
        Util.trace(iBitstream.getpos() - 8, 8, this.title_length, "title_length (" + this.title_length + ")");
        Util.trace(iBitstream.getpos(), 0, 0, "processing MultipleStringStructure title_text");
        MultiString multiString = new MultiString();
        this.title_text = multiString;
        int i4 = i + multiString.get(iBitstream);
        int i5 = iBitstream.getbits(4);
        this.reserved3 = i5;
        if (i5 != 15) {
            Util.flerror("Const value mismatch for 'reserved3'");
            i4++;
            Util.trace(iBitstream.getpos() - 4, 4, this.reserved3, "reserved3 (" + this.reserved3 + ") [ERROR]");
        } else {
            Util.trace(iBitstream.getpos() - 4, 4, this.reserved3, "reserved3 (" + this.reserved3 + ")");
        }
        this.descriptors_length = iBitstream.getbits(12);
        Util.trace(iBitstream.getpos() - 12, 12, this.descriptors_length, "descriptors_length (" + this.descriptors_length + ")");
        this.remain_desc_bytes = this.descriptors_length;
        while (this.remain_desc_bytes > 0) {
            Util.trace(iBitstream.getpos(), 0, 0, "processing Descriptor descriptor");
            Descriptor descriptor = new Descriptor();
            this.descriptor = descriptor;
            i4 += descriptor.get(iBitstream);
            this.remain_desc_bytes -= this.descriptor._F_lengthof / 8;
        }
        Util.trace(iBitstream.getpos(), 0, 0, "end EITEvent");
        return i4;
    }

    public int put(IBitstream iBitstream) throws IOException {
        this.reserved1 = 3;
        iBitstream.putbits(3, 2);
        iBitstream.putbits(this.event_id, 14);
        iBitstream.putbits(this.start_time, 32);
        this.reserved2 = 3;
        iBitstream.putbits(3, 2);
        iBitstream.putbits(this.ETM_location, 2);
        iBitstream.putbits(this.length_in_seconds, 20);
        iBitstream.putbits(this.title_length, 8);
        int iPut = this.title_text.put(iBitstream) + 0;
        this.reserved3 = 15;
        iBitstream.putbits(15, 4);
        iBitstream.putbits(this.descriptors_length, 12);
        this.remain_desc_bytes = this.descriptors_length;
        while (this.remain_desc_bytes > 0) {
            iPut += this.descriptor.put(iBitstream);
            this.remain_desc_bytes -= this.descriptor._F_lengthof / 8;
        }
        return iPut;
    }

    public int putxml(IBitstream iBitstream, boolean z) throws IOException {
        int i;
        int i2 = iBitstream.getbits(2);
        this.reserved1 = i2;
        if (i2 != 3) {
            Util.flerror("Const value mismatch for 'reserved1'");
            if (z) {
                XML.WriteXmlElement("<reserved1 type=\"flUInt\" bitLen=\"2\">" + this.reserved1 + "</reserved1>");
            } else {
                XML.WriteXmlElement("<reserved1 bitLen=\"2\">" + this.reserved1 + "</reserved1>");
            }
            i = 1;
        } else {
            if (z) {
                XML.WriteXmlElement("<reserved1 type=\"flUInt\" bitLen=\"2\">" + this.reserved1 + "</reserved1>");
            } else {
                XML.WriteXmlElement("<reserved1 bitLen=\"2\">" + this.reserved1 + "</reserved1>");
            }
            Util.trace(iBitstream.getpos() - 2, 2, this.reserved1, "reserved1 (" + this.reserved1 + ")");
            i = 0;
        }
        this.event_id = iBitstream.getbits(14);
        if (z) {
            XML.WriteXmlElement("<event_id type=\"flUInt\" bitLen=\"14\">" + this.event_id + "</event_id>");
        } else {
            XML.WriteXmlElement("<event_id bitLen=\"14\">" + this.event_id + "</event_id>");
        }
        this.start_time = iBitstream.getbits(32);
        if (z) {
            XML.WriteXmlElement("<start_time type=\"flUInt\" bitLen=\"32\">" + this.start_time + "</start_time>");
        } else {
            XML.WriteXmlElement("<start_time bitLen=\"32\">" + this.start_time + "</start_time>");
        }
        int i3 = iBitstream.getbits(2);
        this.reserved2 = i3;
        if (i3 != 3) {
            Util.flerror("Const value mismatch for 'reserved2'");
            i++;
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
        this.ETM_location = iBitstream.getbits(2);
        if (z) {
            XML.WriteXmlElement("<ETM_location type=\"flUInt\" bitLen=\"2\">" + this.ETM_location + "</ETM_location>");
        } else {
            XML.WriteXmlElement("<ETM_location bitLen=\"2\">" + this.ETM_location + "</ETM_location>");
        }
        this.length_in_seconds = iBitstream.getbits(20);
        if (z) {
            XML.WriteXmlElement("<length_in_seconds type=\"flUInt\" bitLen=\"20\">" + this.length_in_seconds + "</length_in_seconds>");
        } else {
            XML.WriteXmlElement("<length_in_seconds bitLen=\"20\">" + this.length_in_seconds + "</length_in_seconds>");
        }
        this.title_length = iBitstream.getbits(8);
        if (z) {
            XML.WriteXmlElement("<title_length type=\"flUInt\" bitLen=\"8\">" + this.title_length + "</title_length>");
        } else {
            XML.WriteXmlElement("<title_length bitLen=\"8\">" + this.title_length + "</title_length>");
        }
        Util.trace(iBitstream.getpos(), 0, 0, "processing MultipleStringStructure title_text");
        this.title_text = new MultiString();
        XML.IntoAClass("title_text", 0);
        int iPutxml = i + this.title_text.putxml(iBitstream, z);
        XML.OutOfClass("</title_text>");
        int i4 = iBitstream.getbits(4);
        this.reserved3 = i4;
        if (i4 != 15) {
            Util.flerror("Const value mismatch for 'reserved3'");
            iPutxml++;
            if (z) {
                XML.WriteXmlElement("<reserved3 type=\"flUInt\" bitLen=\"4\">" + this.reserved3 + "</reserved3>");
            } else {
                XML.WriteXmlElement("<reserved3 bitLen=\"4\">" + this.reserved3 + "</reserved3>");
            }
        } else {
            if (z) {
                XML.WriteXmlElement("<reserved3 type=\"flUInt\" bitLen=\"4\">" + this.reserved3 + "</reserved3>");
            } else {
                XML.WriteXmlElement("<reserved3 bitLen=\"4\">" + this.reserved3 + "</reserved3>");
            }
            Util.trace(iBitstream.getpos() - 4, 4, this.reserved3, "reserved3 (" + this.reserved3 + ")");
        }
        this.descriptors_length = iBitstream.getbits(12);
        if (z) {
            XML.WriteXmlElement("<descriptors_length type=\"flUInt\" bitLen=\"12\">" + this.descriptors_length + "</descriptors_length>");
        } else {
            XML.WriteXmlElement("<descriptors_length bitLen=\"12\">" + this.descriptors_length + "</descriptors_length>");
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
