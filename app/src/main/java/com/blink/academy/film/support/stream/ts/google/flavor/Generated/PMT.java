package com.blink.academy.film.support.stream.ts.google.flavor.Generated;

import com.blink.academy.film.support.stream.ts.google.flavor.IBitstream;
import com.blink.academy.film.support.stream.ts.google.flavor.Util;
import com.blink.academy.film.support.stream.ts.google.flavor.XML;
import java.io.IOException;

/* loaded from: classes.dex */
public class PMT {
    public int CRC_32;
    public int PCR_PID;
    public int current_next_indicator;
    public Descriptor descriptor;
    public int last_section_numbe;
    public int private_indicator;
    public int program_info_length;
    public int program_number;
    public int remain_desc_bytes;
    public int remain_section_bytes;
    public int section_length;
    public int section_number;
    public int section_syntax_indicator;
    public PMTStream stream;
    public int table_id;
    public int version_number;

    public int get(IBitstream iBitstream) throws IOException {
        int i;
        Util.trace(iBitstream.getpos(), 0, 0, "begin PMT");
        int i2 = iBitstream.getbits(8);
        this.table_id = i2;
        if (i2 != 2) {
            Util.flerror("Const value mismatch for 'table_id'");
            Util.trace(iBitstream.getpos() - 8, 8, this.table_id, "table_id (" + this.table_id + ") [ERROR]");
            i = 1;
        } else {
            Util.trace(iBitstream.getpos() - 8, 8, this.table_id, "table_id (" + this.table_id + ")");
            i = 0;
        }
        int i3 = iBitstream.getbits(1);
        this.section_syntax_indicator = i3;
        if (i3 != 1) {
            Util.flerror("Const value mismatch for 'section_syntax_indicator'");
            i++;
            Util.trace(iBitstream.getpos() - 1, 1, this.section_syntax_indicator, "section_syntax_indicator (" + this.section_syntax_indicator + ") [ERROR]");
        } else {
            Util.trace(iBitstream.getpos() - 1, 1, this.section_syntax_indicator, "section_syntax_indicator (" + this.section_syntax_indicator + ")");
        }
        int i4 = iBitstream.getbits(1);
        this.private_indicator = i4;
        if (i4 != 0) {
            Util.flerror("Const value mismatch for 'private_indicator'");
            i++;
            Util.trace(iBitstream.getpos() - 1, 1, this.private_indicator, "private_indicator (" + this.private_indicator + ") [ERROR]");
        } else {
            Util.trace(iBitstream.getpos() - 1, 1, this.private_indicator, "private_indicator (" + this.private_indicator + ")");
        }
        iBitstream.skipbits(2);
        this.section_length = iBitstream.getbits(12);
        Util.trace(iBitstream.getpos() - 12, 12, this.section_length, "section_length (" + this.section_length + ")");
        this.program_number = iBitstream.getbits(16);
        Util.trace(iBitstream.getpos() - 16, 16, this.program_number, "program_number (" + this.program_number + ")");
        iBitstream.skipbits(2);
        this.version_number = iBitstream.getbits(5);
        Util.trace(iBitstream.getpos() - 5, 5, this.version_number, "version_number (" + this.version_number + ")");
        this.current_next_indicator = iBitstream.getbits(1);
        Util.trace(iBitstream.getpos() - 1, 1, this.current_next_indicator, "current_next_indicator (" + this.current_next_indicator + ")");
        int i5 = iBitstream.getbits(8);
        this.section_number = i5;
        if (i5 != 0) {
            Util.flerror("Const value mismatch for 'section_number'");
            i++;
            Util.trace(iBitstream.getpos() - 8, 8, this.section_number, "section_number (" + this.section_number + ") [ERROR]");
        } else {
            Util.trace(iBitstream.getpos() - 8, 8, this.section_number, "section_number (" + this.section_number + ")");
        }
        int i6 = iBitstream.getbits(8);
        this.last_section_numbe = i6;
        if (i6 != 0) {
            Util.flerror("Const value mismatch for 'last_section_numbe'");
            i++;
            Util.trace(iBitstream.getpos() - 8, 8, this.last_section_numbe, "last_section_numbe (" + this.last_section_numbe + ") [ERROR]");
        } else {
            Util.trace(iBitstream.getpos() - 8, 8, this.last_section_numbe, "last_section_numbe (" + this.last_section_numbe + ")");
        }
        iBitstream.skipbits(3);
        this.PCR_PID = iBitstream.getbits(13);
        Util.trace(iBitstream.getpos() - 13, 13, this.PCR_PID, "PCR_PID (" + this.PCR_PID + ")");
        iBitstream.skipbits(4);
        this.program_info_length = iBitstream.getbits(12);
        Util.trace(iBitstream.getpos() - 12, 12, this.program_info_length, "program_info_length (" + this.program_info_length + ")");
        this.remain_desc_bytes = this.program_info_length;
        while (this.remain_desc_bytes > 0) {
            Util.trace(iBitstream.getpos(), 0, 0, "processing Descriptor descriptor");
            Descriptor descriptor = new Descriptor();
            this.descriptor = descriptor;
            i += descriptor.get(iBitstream);
            this.remain_desc_bytes -= this.descriptor._F_lengthof / 8;
        }
        this.remain_section_bytes = ((this.section_length - this.program_info_length) - 9) - 4;
        while (this.remain_section_bytes > 0) {
            Util.trace(iBitstream.getpos(), 0, 0, "processing PMTStream stream");
            PMTStream pMTStream = new PMTStream();
            this.stream = pMTStream;
            i += pMTStream.get(iBitstream);
            this.remain_section_bytes -= this.stream._F_lengthof / 8;
        }
        this.CRC_32 = iBitstream.getbits(32);
        Util.trace(iBitstream.getpos() - 32, 32, this.CRC_32, "CRC_32 (" + this.CRC_32 + ")");
        Util.trace(iBitstream.getpos(), 0, 0, "end PMT");
        return i;
    }

    public int put(IBitstream iBitstream) throws IOException {
        this.table_id = 2;
        iBitstream.putbits(2, 8);
        this.section_syntax_indicator = 1;
        iBitstream.putbits(1, 1);
        int iPut = 0;
        this.private_indicator = 0;
        iBitstream.putbits(0, 1);
        iBitstream.skipbits(2);
        iBitstream.putbits(this.section_length, 12);
        iBitstream.putbits(this.program_number, 16);
        iBitstream.skipbits(2);
        iBitstream.putbits(this.version_number, 5);
        iBitstream.putbits(this.current_next_indicator, 1);
        this.section_number = 0;
        iBitstream.putbits(0, 8);
        this.last_section_numbe = 0;
        iBitstream.putbits(0, 8);
        iBitstream.skipbits(3);
        iBitstream.putbits(this.PCR_PID, 13);
        iBitstream.skipbits(4);
        iBitstream.putbits(this.program_info_length, 12);
        this.remain_desc_bytes = this.program_info_length;
        while (this.remain_desc_bytes > 0) {
            iPut += this.descriptor.put(iBitstream);
            this.remain_desc_bytes -= this.descriptor._F_lengthof / 8;
        }
        this.remain_section_bytes = ((this.section_length - this.program_info_length) - 9) - 4;
        while (this.remain_section_bytes > 0) {
            iPut += this.stream.put(iBitstream);
            this.remain_section_bytes -= this.stream._F_lengthof / 8;
        }
        iBitstream.putbits(this.CRC_32, 32);
        return iPut;
    }

    public int putxml(IBitstream iBitstream, boolean z) throws IOException {
        int iPutxml;
        int i = iBitstream.getbits(8);
        this.table_id = i;
        if (i != 2) {
            Util.flerror("Const value mismatch for 'table_id'");
            if (z) {
                XML.WriteXmlElement("<table_id type=\"flUInt\" bitLen=\"8\">" + this.table_id + "</table_id>");
            } else {
                XML.WriteXmlElement("<table_id bitLen=\"8\">" + this.table_id + "</table_id>");
            }
            iPutxml = 1;
        } else {
            if (z) {
                XML.WriteXmlElement("<table_id type=\"flUInt\" bitLen=\"8\">" + this.table_id + "</table_id>");
            } else {
                XML.WriteXmlElement("<table_id bitLen=\"8\">" + this.table_id + "</table_id>");
            }
            Util.trace(iBitstream.getpos() - 8, 8, this.table_id, "table_id (" + this.table_id + ")");
            iPutxml = 0;
        }
        int i2 = iBitstream.getbits(1);
        this.section_syntax_indicator = i2;
        if (i2 != 1) {
            Util.flerror("Const value mismatch for 'section_syntax_indicator'");
            iPutxml++;
            if (z) {
                XML.WriteXmlElement("<section_syntax_indicator type=\"flUInt\" bitLen=\"1\">" + this.section_syntax_indicator + "</section_syntax_indicator>");
            } else {
                XML.WriteXmlElement("<section_syntax_indicator bitLen=\"1\">" + this.section_syntax_indicator + "</section_syntax_indicator>");
            }
        } else {
            if (z) {
                XML.WriteXmlElement("<section_syntax_indicator type=\"flUInt\" bitLen=\"1\">" + this.section_syntax_indicator + "</section_syntax_indicator>");
            } else {
                XML.WriteXmlElement("<section_syntax_indicator bitLen=\"1\">" + this.section_syntax_indicator + "</section_syntax_indicator>");
            }
            Util.trace(iBitstream.getpos() - 1, 1, this.section_syntax_indicator, "section_syntax_indicator (" + this.section_syntax_indicator + ")");
        }
        int i3 = iBitstream.getbits(1);
        this.private_indicator = i3;
        if (i3 != 0) {
            Util.flerror("Const value mismatch for 'private_indicator'");
            iPutxml++;
            if (z) {
                XML.WriteXmlElement("<private_indicator type=\"flUInt\" bitLen=\"1\">" + this.private_indicator + "</private_indicator>");
            } else {
                XML.WriteXmlElement("<private_indicator bitLen=\"1\">" + this.private_indicator + "</private_indicator>");
            }
        } else {
            if (z) {
                XML.WriteXmlElement("<private_indicator type=\"flUInt\" bitLen=\"1\">" + this.private_indicator + "</private_indicator>");
            } else {
                XML.WriteXmlElement("<private_indicator bitLen=\"1\">" + this.private_indicator + "</private_indicator>");
            }
            Util.trace(iBitstream.getpos() - 1, 1, this.private_indicator, "private_indicator (" + this.private_indicator + ")");
        }
        iBitstream.skipbits(2);
        this.section_length = iBitstream.getbits(12);
        if (z) {
            XML.WriteXmlElement("<section_length type=\"flUInt\" bitLen=\"12\">" + this.section_length + "</section_length>");
        } else {
            XML.WriteXmlElement("<section_length bitLen=\"12\">" + this.section_length + "</section_length>");
        }
        this.program_number = iBitstream.getbits(16);
        if (z) {
            XML.WriteXmlElement("<program_number type=\"flUInt\" bitLen=\"16\">" + this.program_number + "</program_number>");
        } else {
            XML.WriteXmlElement("<program_number bitLen=\"16\">" + this.program_number + "</program_number>");
        }
        iBitstream.skipbits(2);
        this.version_number = iBitstream.getbits(5);
        if (z) {
            XML.WriteXmlElement("<version_number type=\"flUInt\" bitLen=\"5\">" + this.version_number + "</version_number>");
        } else {
            XML.WriteXmlElement("<version_number bitLen=\"5\">" + this.version_number + "</version_number>");
        }
        this.current_next_indicator = iBitstream.getbits(1);
        if (z) {
            XML.WriteXmlElement("<current_next_indicator type=\"flUInt\" bitLen=\"1\">" + this.current_next_indicator + "</current_next_indicator>");
        } else {
            XML.WriteXmlElement("<current_next_indicator bitLen=\"1\">" + this.current_next_indicator + "</current_next_indicator>");
        }
        int i4 = iBitstream.getbits(8);
        this.section_number = i4;
        if (i4 != 0) {
            Util.flerror("Const value mismatch for 'section_number'");
            iPutxml++;
            if (z) {
                XML.WriteXmlElement("<section_number type=\"flUInt\" bitLen=\"8\">" + this.section_number + "</section_number>");
            } else {
                XML.WriteXmlElement("<section_number bitLen=\"8\">" + this.section_number + "</section_number>");
            }
        } else {
            if (z) {
                XML.WriteXmlElement("<section_number type=\"flUInt\" bitLen=\"8\">" + this.section_number + "</section_number>");
            } else {
                XML.WriteXmlElement("<section_number bitLen=\"8\">" + this.section_number + "</section_number>");
            }
            Util.trace(iBitstream.getpos() - 8, 8, this.section_number, "section_number (" + this.section_number + ")");
        }
        int i5 = iBitstream.getbits(8);
        this.last_section_numbe = i5;
        if (i5 != 0) {
            Util.flerror("Const value mismatch for 'last_section_numbe'");
            iPutxml++;
            if (z) {
                XML.WriteXmlElement("<last_section_numbe type=\"flUInt\" bitLen=\"8\">" + this.last_section_numbe + "</last_section_numbe>");
            } else {
                XML.WriteXmlElement("<last_section_numbe bitLen=\"8\">" + this.last_section_numbe + "</last_section_numbe>");
            }
        } else {
            if (z) {
                XML.WriteXmlElement("<last_section_numbe type=\"flUInt\" bitLen=\"8\">" + this.last_section_numbe + "</last_section_numbe>");
            } else {
                XML.WriteXmlElement("<last_section_numbe bitLen=\"8\">" + this.last_section_numbe + "</last_section_numbe>");
            }
            Util.trace(iBitstream.getpos() - 8, 8, this.last_section_numbe, "last_section_numbe (" + this.last_section_numbe + ")");
        }
        iBitstream.skipbits(3);
        this.PCR_PID = iBitstream.getbits(13);
        if (z) {
            XML.WriteXmlElement("<PCR_PID type=\"flUInt\" bitLen=\"13\">" + this.PCR_PID + "</PCR_PID>");
        } else {
            XML.WriteXmlElement("<PCR_PID bitLen=\"13\">" + this.PCR_PID + "</PCR_PID>");
        }
        iBitstream.skipbits(4);
        this.program_info_length = iBitstream.getbits(12);
        if (z) {
            XML.WriteXmlElement("<program_info_length type=\"flUInt\" bitLen=\"12\">" + this.program_info_length + "</program_info_length>");
        } else {
            XML.WriteXmlElement("<program_info_length bitLen=\"12\">" + this.program_info_length + "</program_info_length>");
        }
        this.remain_desc_bytes = this.program_info_length;
        while (this.remain_desc_bytes > 0) {
            Util.trace(iBitstream.getpos(), 0, 0, "processing Descriptor descriptor");
            this.descriptor = new Descriptor();
            XML.IntoAClass("descriptor", 0);
            iPutxml += this.descriptor.putxml(iBitstream, z);
            XML.OutOfClass("</descriptor>");
            this.remain_desc_bytes -= this.descriptor._F_lengthof / 8;
        }
        this.remain_section_bytes = ((this.section_length - this.program_info_length) - 9) - 4;
        while (this.remain_section_bytes > 0) {
            Util.trace(iBitstream.getpos(), 0, 0, "processing PMTStream stream");
            this.stream = new PMTStream();
            XML.IntoAClass("stream", 0);
            iPutxml += this.stream.putxml(iBitstream, z);
            XML.OutOfClass("</stream>");
            this.remain_section_bytes -= this.stream._F_lengthof / 8;
        }
        this.CRC_32 = iBitstream.getbits(32);
        if (z) {
            XML.WriteXmlElement("<CRC_32 type=\"flUInt\" bitLen=\"32\">" + this.CRC_32 + "</CRC_32>");
        } else {
            XML.WriteXmlElement("<CRC_32 bitLen=\"32\">" + this.CRC_32 + "</CRC_32>");
        }
        return iPutxml;
    }
}
