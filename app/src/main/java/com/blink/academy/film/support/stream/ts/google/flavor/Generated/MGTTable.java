package com.blink.academy.film.support.stream.ts.google.flavor.Generated;

import com.blink.academy.film.support.stream.ts.google.flavor.IBitstream;
import com.blink.academy.film.support.stream.ts.google.flavor.Util;
import com.blink.academy.film.support.stream.ts.google.flavor.XML;
import java.io.IOException;

/* loaded from: classes.dex */
public class MGTTable {
    public Descriptor descriptor;
    public int number_bytes;
    public int remain_desc_bytes;
    public int reserved1;
    public int reserved2;
    public int reserved3;
    public int table_type;
    public int table_type_PID;
    public int table_type_descriptors_length;
    public int table_type_version_number;

    public int get(IBitstream iBitstream) throws IOException {
        int i;
        Util.trace(iBitstream.getpos(), 0, 0, "begin MGTTable");
        this.table_type = iBitstream.getbits(16);
        Util.trace(iBitstream.getpos() - 16, 16, this.table_type, "table_type (" + this.table_type + ")");
        int i2 = iBitstream.getbits(3);
        this.reserved1 = i2;
        if (i2 != 7) {
            Util.flerror("Const value mismatch for 'reserved1'");
            Util.trace(iBitstream.getpos() - 3, 3, this.reserved1, "reserved1 (" + this.reserved1 + ") [ERROR]");
            i = 1;
        } else {
            Util.trace(iBitstream.getpos() - 3, 3, this.reserved1, "reserved1 (" + this.reserved1 + ")");
            i = 0;
        }
        this.table_type_PID = iBitstream.getbits(13);
        Util.trace(iBitstream.getpos() - 13, 13, this.table_type_PID, "table_type_PID (" + this.table_type_PID + ")");
        int i3 = iBitstream.getbits(3);
        this.reserved2 = i3;
        if (i3 != 7) {
            Util.flerror("Const value mismatch for 'reserved2'");
            i++;
            Util.trace(iBitstream.getpos() - 3, 3, this.reserved2, "reserved2 (" + this.reserved2 + ") [ERROR]");
        } else {
            Util.trace(iBitstream.getpos() - 3, 3, this.reserved2, "reserved2 (" + this.reserved2 + ")");
        }
        this.table_type_version_number = iBitstream.getbits(5);
        Util.trace(iBitstream.getpos() - 5, 5, this.table_type_version_number, "table_type_version_number (" + this.table_type_version_number + ")");
        this.number_bytes = iBitstream.getbits(32);
        Util.trace(iBitstream.getpos() - 32, 32, this.number_bytes, "number_bytes (" + this.number_bytes + ")");
        int i4 = iBitstream.getbits(4);
        this.reserved3 = i4;
        if (i4 != 15) {
            Util.flerror("Const value mismatch for 'reserved3'");
            i++;
            Util.trace(iBitstream.getpos() - 4, 4, this.reserved3, "reserved3 (" + this.reserved3 + ") [ERROR]");
        } else {
            Util.trace(iBitstream.getpos() - 4, 4, this.reserved3, "reserved3 (" + this.reserved3 + ")");
        }
        this.table_type_descriptors_length = iBitstream.getbits(12);
        Util.trace(iBitstream.getpos() - 12, 12, this.table_type_descriptors_length, "table_type_descriptors_length (" + this.table_type_descriptors_length + ")");
        this.remain_desc_bytes = this.table_type_descriptors_length;
        while (this.remain_desc_bytes > 0) {
            Util.trace(iBitstream.getpos(), 0, 0, "processing Descriptor descriptor");
            Descriptor descriptor = new Descriptor();
            this.descriptor = descriptor;
            i += descriptor.get(iBitstream);
            this.remain_desc_bytes -= this.descriptor._F_lengthof / 8;
        }
        Util.trace(iBitstream.getpos(), 0, 0, "end MGTTable");
        return i;
    }

    public int put(IBitstream iBitstream) throws IOException {
        iBitstream.putbits(this.table_type, 16);
        this.reserved1 = 7;
        iBitstream.putbits(7, 3);
        iBitstream.putbits(this.table_type_PID, 13);
        this.reserved2 = 7;
        iBitstream.putbits(7, 3);
        iBitstream.putbits(this.table_type_version_number, 5);
        iBitstream.putbits(this.number_bytes, 32);
        this.reserved3 = 15;
        iBitstream.putbits(15, 4);
        iBitstream.putbits(this.table_type_descriptors_length, 12);
        this.remain_desc_bytes = this.table_type_descriptors_length;
        int iPut = 0;
        while (this.remain_desc_bytes > 0) {
            iPut += this.descriptor.put(iBitstream);
            this.remain_desc_bytes -= this.descriptor._F_lengthof / 8;
        }
        return iPut;
    }

    public int putxml(IBitstream iBitstream, boolean z) throws IOException {
        int iPutxml;
        this.table_type = iBitstream.getbits(16);
        if (z) {
            XML.WriteXmlElement("<table_type type=\"flUInt\" bitLen=\"16\">" + this.table_type + "</table_type>");
        } else {
            XML.WriteXmlElement("<table_type bitLen=\"16\">" + this.table_type + "</table_type>");
        }
        int i = iBitstream.getbits(3);
        this.reserved1 = i;
        if (i != 7) {
            Util.flerror("Const value mismatch for 'reserved1'");
            if (z) {
                XML.WriteXmlElement("<reserved1 type=\"flUInt\" bitLen=\"3\">" + this.reserved1 + "</reserved1>");
            } else {
                XML.WriteXmlElement("<reserved1 bitLen=\"3\">" + this.reserved1 + "</reserved1>");
            }
            iPutxml = 1;
        } else {
            if (z) {
                XML.WriteXmlElement("<reserved1 type=\"flUInt\" bitLen=\"3\">" + this.reserved1 + "</reserved1>");
            } else {
                XML.WriteXmlElement("<reserved1 bitLen=\"3\">" + this.reserved1 + "</reserved1>");
            }
            Util.trace(iBitstream.getpos() - 3, 3, this.reserved1, "reserved1 (" + this.reserved1 + ")");
            iPutxml = 0;
        }
        this.table_type_PID = iBitstream.getbits(13);
        if (z) {
            XML.WriteXmlElement("<table_type_PID type=\"flUInt\" bitLen=\"13\">" + this.table_type_PID + "</table_type_PID>");
        } else {
            XML.WriteXmlElement("<table_type_PID bitLen=\"13\">" + this.table_type_PID + "</table_type_PID>");
        }
        int i2 = iBitstream.getbits(3);
        this.reserved2 = i2;
        if (i2 != 7) {
            Util.flerror("Const value mismatch for 'reserved2'");
            iPutxml++;
            if (z) {
                XML.WriteXmlElement("<reserved2 type=\"flUInt\" bitLen=\"3\">" + this.reserved2 + "</reserved2>");
            } else {
                XML.WriteXmlElement("<reserved2 bitLen=\"3\">" + this.reserved2 + "</reserved2>");
            }
        } else {
            if (z) {
                XML.WriteXmlElement("<reserved2 type=\"flUInt\" bitLen=\"3\">" + this.reserved2 + "</reserved2>");
            } else {
                XML.WriteXmlElement("<reserved2 bitLen=\"3\">" + this.reserved2 + "</reserved2>");
            }
            Util.trace(iBitstream.getpos() - 3, 3, this.reserved2, "reserved2 (" + this.reserved2 + ")");
        }
        this.table_type_version_number = iBitstream.getbits(5);
        if (z) {
            XML.WriteXmlElement("<table_type_version_number type=\"flUInt\" bitLen=\"5\">" + this.table_type_version_number + "</table_type_version_number>");
        } else {
            XML.WriteXmlElement("<table_type_version_number bitLen=\"5\">" + this.table_type_version_number + "</table_type_version_number>");
        }
        this.number_bytes = iBitstream.getbits(32);
        if (z) {
            XML.WriteXmlElement("<number_bytes type=\"flUInt\" bitLen=\"32\">" + this.number_bytes + "</number_bytes>");
        } else {
            XML.WriteXmlElement("<number_bytes bitLen=\"32\">" + this.number_bytes + "</number_bytes>");
        }
        int i3 = iBitstream.getbits(4);
        this.reserved3 = i3;
        if (i3 != 15) {
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
        this.table_type_descriptors_length = iBitstream.getbits(12);
        if (z) {
            XML.WriteXmlElement("<table_type_descriptors_length type=\"flUInt\" bitLen=\"12\">" + this.table_type_descriptors_length + "</table_type_descriptors_length>");
        } else {
            XML.WriteXmlElement("<table_type_descriptors_length bitLen=\"12\">" + this.table_type_descriptors_length + "</table_type_descriptors_length>");
        }
        this.remain_desc_bytes = this.table_type_descriptors_length;
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
