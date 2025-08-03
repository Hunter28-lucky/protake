package com.blink.academy.film.support.stream.ts.google.flavor.Generated;

import com.blink.academy.film.support.stream.ts.google.flavor.IBitstream;
import com.blink.academy.film.support.stream.ts.google.flavor.Util;
import com.blink.academy.film.support.stream.ts.google.flavor.XML;
import java.io.IOException;

/* loaded from: classes.dex */
public class MGT {
    public int CRC_32;
    public int current_next_indicator;
    public Descriptor descriptor;
    public int descriptors_length;
    public int last_section_number;
    public int private_indicator;
    public int protocol_version;
    public int remain_desc_bytes;
    public int reserved1;
    public int reserved2;
    public int reserved3;
    public int section_length;
    public int section_number;
    public int section_syntax_indicator;
    public MGTTable table;
    public int table_id;
    public int table_id_extension;
    public int tables_defined;
    public int tn;
    public int version_number;

    public int get(IBitstream iBitstream) throws IOException {
        int i;
        Util.trace(iBitstream.getpos(), 0, 0, "begin MGT");
        int i2 = iBitstream.getbits(8);
        this.table_id = i2;
        if (i2 != 199) {
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
        if (i4 != 1) {
            Util.flerror("Const value mismatch for 'private_indicator'");
            i++;
            Util.trace(iBitstream.getpos() - 1, 1, this.private_indicator, "private_indicator (" + this.private_indicator + ") [ERROR]");
        } else {
            Util.trace(iBitstream.getpos() - 1, 1, this.private_indicator, "private_indicator (" + this.private_indicator + ")");
        }
        int i5 = iBitstream.getbits(2);
        this.reserved1 = i5;
        if (i5 != 3) {
            Util.flerror("Const value mismatch for 'reserved1'");
            i++;
            Util.trace(iBitstream.getpos() - 2, 2, this.reserved1, "reserved1 (" + this.reserved1 + ") [ERROR]");
        } else {
            Util.trace(iBitstream.getpos() - 2, 2, this.reserved1, "reserved1 (" + this.reserved1 + ")");
        }
        this.section_length = iBitstream.getbits(12);
        Util.trace(iBitstream.getpos() - 12, 12, this.section_length, "section_length (" + this.section_length + ")");
        int i6 = iBitstream.getbits(16);
        this.table_id_extension = i6;
        if (i6 != 0) {
            Util.flerror("Const value mismatch for 'table_id_extension'");
            i++;
            Util.trace(iBitstream.getpos() - 16, 16, this.table_id_extension, "table_id_extension (" + this.table_id_extension + ") [ERROR]");
        } else {
            Util.trace(iBitstream.getpos() - 16, 16, this.table_id_extension, "table_id_extension (" + this.table_id_extension + ")");
        }
        int i7 = iBitstream.getbits(2);
        this.reserved2 = i7;
        if (i7 != 3) {
            Util.flerror("Const value mismatch for 'reserved2'");
            i++;
            Util.trace(iBitstream.getpos() - 2, 2, this.reserved2, "reserved2 (" + this.reserved2 + ") [ERROR]");
        } else {
            Util.trace(iBitstream.getpos() - 2, 2, this.reserved2, "reserved2 (" + this.reserved2 + ")");
        }
        this.version_number = iBitstream.getbits(5);
        Util.trace(iBitstream.getpos() - 5, 5, this.version_number, "version_number (" + this.version_number + ")");
        int i8 = iBitstream.getbits(1);
        this.current_next_indicator = i8;
        if (i8 != 1) {
            Util.flerror("Const value mismatch for 'current_next_indicator'");
            i++;
            Util.trace(iBitstream.getpos() - 1, 1, this.current_next_indicator, "current_next_indicator (" + this.current_next_indicator + ") [ERROR]");
        } else {
            Util.trace(iBitstream.getpos() - 1, 1, this.current_next_indicator, "current_next_indicator (" + this.current_next_indicator + ")");
        }
        int i9 = iBitstream.getbits(8);
        this.section_number = i9;
        if (i9 != 0) {
            Util.flerror("Const value mismatch for 'section_number'");
            i++;
            Util.trace(iBitstream.getpos() - 8, 8, this.section_number, "section_number (" + this.section_number + ") [ERROR]");
        } else {
            Util.trace(iBitstream.getpos() - 8, 8, this.section_number, "section_number (" + this.section_number + ")");
        }
        int i10 = iBitstream.getbits(8);
        this.last_section_number = i10;
        if (i10 != 0) {
            Util.flerror("Const value mismatch for 'last_section_number'");
            i++;
            Util.trace(iBitstream.getpos() - 8, 8, this.last_section_number, "last_section_number (" + this.last_section_number + ") [ERROR]");
        } else {
            Util.trace(iBitstream.getpos() - 8, 8, this.last_section_number, "last_section_number (" + this.last_section_number + ")");
        }
        this.protocol_version = iBitstream.getbits(8);
        Util.trace(iBitstream.getpos() - 8, 8, this.protocol_version, "protocol_version (" + this.protocol_version + ")");
        this.tables_defined = iBitstream.getbits(16);
        Util.trace(iBitstream.getpos() - 16, 16, this.tables_defined, "tables_defined (" + this.tables_defined + ")");
        this.tn = 0;
        while (this.tn < this.tables_defined) {
            Util.trace(iBitstream.getpos(), 0, 0, "processing MGTTable table");
            MGTTable mGTTable = new MGTTable();
            this.table = mGTTable;
            i += mGTTable.get(iBitstream);
            this.tn++;
        }
        int i11 = iBitstream.getbits(4);
        this.reserved3 = i11;
        if (i11 != 15) {
            Util.flerror("Const value mismatch for 'reserved3'");
            i++;
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
            i += descriptor.get(iBitstream);
            this.remain_desc_bytes -= this.descriptor._F_lengthof / 8;
        }
        this.CRC_32 = iBitstream.getbits(32);
        Util.trace(iBitstream.getpos() - 32, 32, this.CRC_32, "CRC_32 (" + this.CRC_32 + ")");
        Util.trace(iBitstream.getpos(), 0, 0, "end MGT");
        return i;
    }

    public int put(IBitstream iBitstream) throws IOException {
        this.table_id = 199;
        iBitstream.putbits(199, 8);
        this.section_syntax_indicator = 1;
        iBitstream.putbits(1, 1);
        this.private_indicator = 1;
        iBitstream.putbits(1, 1);
        this.reserved1 = 3;
        iBitstream.putbits(3, 2);
        iBitstream.putbits(this.section_length, 12);
        int iPut = 0;
        this.table_id_extension = 0;
        iBitstream.putbits(0, 16);
        this.reserved2 = 3;
        iBitstream.putbits(3, 2);
        iBitstream.putbits(this.version_number, 5);
        this.current_next_indicator = 1;
        iBitstream.putbits(1, 1);
        this.section_number = 0;
        iBitstream.putbits(0, 8);
        this.last_section_number = 0;
        iBitstream.putbits(0, 8);
        iBitstream.putbits(this.protocol_version, 8);
        iBitstream.putbits(this.tables_defined, 16);
        this.tn = 0;
        while (this.tn < this.tables_defined) {
            iPut += this.table.put(iBitstream);
            this.tn++;
        }
        this.reserved3 = 15;
        iBitstream.putbits(15, 4);
        iBitstream.putbits(this.descriptors_length, 12);
        this.remain_desc_bytes = this.descriptors_length;
        while (this.remain_desc_bytes > 0) {
            iPut += this.descriptor.put(iBitstream);
            this.remain_desc_bytes -= this.descriptor._F_lengthof / 8;
        }
        iBitstream.putbits(this.CRC_32, 32);
        return iPut;
    }

    public int putxml(IBitstream iBitstream, boolean z) throws IOException {
        int iPutxml;
        int i = iBitstream.getbits(8);
        this.table_id = i;
        if (i != 199) {
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
        if (i3 != 1) {
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
        int i4 = iBitstream.getbits(2);
        this.reserved1 = i4;
        if (i4 != 3) {
            Util.flerror("Const value mismatch for 'reserved1'");
            iPutxml++;
            if (z) {
                XML.WriteXmlElement("<reserved1 type=\"flUInt\" bitLen=\"2\">" + this.reserved1 + "</reserved1>");
            } else {
                XML.WriteXmlElement("<reserved1 bitLen=\"2\">" + this.reserved1 + "</reserved1>");
            }
        } else {
            if (z) {
                XML.WriteXmlElement("<reserved1 type=\"flUInt\" bitLen=\"2\">" + this.reserved1 + "</reserved1>");
            } else {
                XML.WriteXmlElement("<reserved1 bitLen=\"2\">" + this.reserved1 + "</reserved1>");
            }
            Util.trace(iBitstream.getpos() - 2, 2, this.reserved1, "reserved1 (" + this.reserved1 + ")");
        }
        this.section_length = iBitstream.getbits(12);
        if (z) {
            XML.WriteXmlElement("<section_length type=\"flUInt\" bitLen=\"12\">" + this.section_length + "</section_length>");
        } else {
            XML.WriteXmlElement("<section_length bitLen=\"12\">" + this.section_length + "</section_length>");
        }
        int i5 = iBitstream.getbits(16);
        this.table_id_extension = i5;
        if (i5 != 0) {
            Util.flerror("Const value mismatch for 'table_id_extension'");
            iPutxml++;
            if (z) {
                XML.WriteXmlElement("<table_id_extension type=\"flUInt\" bitLen=\"16\">" + this.table_id_extension + "</table_id_extension>");
            } else {
                XML.WriteXmlElement("<table_id_extension bitLen=\"16\">" + this.table_id_extension + "</table_id_extension>");
            }
        } else {
            if (z) {
                XML.WriteXmlElement("<table_id_extension type=\"flUInt\" bitLen=\"16\">" + this.table_id_extension + "</table_id_extension>");
            } else {
                XML.WriteXmlElement("<table_id_extension bitLen=\"16\">" + this.table_id_extension + "</table_id_extension>");
            }
            Util.trace(iBitstream.getpos() - 16, 16, this.table_id_extension, "table_id_extension (" + this.table_id_extension + ")");
        }
        int i6 = iBitstream.getbits(2);
        this.reserved2 = i6;
        if (i6 != 3) {
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
        this.version_number = iBitstream.getbits(5);
        if (z) {
            XML.WriteXmlElement("<version_number type=\"flUInt\" bitLen=\"5\">" + this.version_number + "</version_number>");
        } else {
            XML.WriteXmlElement("<version_number bitLen=\"5\">" + this.version_number + "</version_number>");
        }
        int i7 = iBitstream.getbits(1);
        this.current_next_indicator = i7;
        if (i7 != 1) {
            Util.flerror("Const value mismatch for 'current_next_indicator'");
            iPutxml++;
            if (z) {
                XML.WriteXmlElement("<current_next_indicator type=\"flUInt\" bitLen=\"1\">" + this.current_next_indicator + "</current_next_indicator>");
            } else {
                XML.WriteXmlElement("<current_next_indicator bitLen=\"1\">" + this.current_next_indicator + "</current_next_indicator>");
            }
        } else {
            if (z) {
                XML.WriteXmlElement("<current_next_indicator type=\"flUInt\" bitLen=\"1\">" + this.current_next_indicator + "</current_next_indicator>");
            } else {
                XML.WriteXmlElement("<current_next_indicator bitLen=\"1\">" + this.current_next_indicator + "</current_next_indicator>");
            }
            Util.trace(iBitstream.getpos() - 1, 1, this.current_next_indicator, "current_next_indicator (" + this.current_next_indicator + ")");
        }
        int i8 = iBitstream.getbits(8);
        this.section_number = i8;
        if (i8 != 0) {
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
        int i9 = iBitstream.getbits(8);
        this.last_section_number = i9;
        if (i9 != 0) {
            Util.flerror("Const value mismatch for 'last_section_number'");
            iPutxml++;
            if (z) {
                XML.WriteXmlElement("<last_section_number type=\"flUInt\" bitLen=\"8\">" + this.last_section_number + "</last_section_number>");
            } else {
                XML.WriteXmlElement("<last_section_number bitLen=\"8\">" + this.last_section_number + "</last_section_number>");
            }
        } else {
            if (z) {
                XML.WriteXmlElement("<last_section_number type=\"flUInt\" bitLen=\"8\">" + this.last_section_number + "</last_section_number>");
            } else {
                XML.WriteXmlElement("<last_section_number bitLen=\"8\">" + this.last_section_number + "</last_section_number>");
            }
            Util.trace(iBitstream.getpos() - 8, 8, this.last_section_number, "last_section_number (" + this.last_section_number + ")");
        }
        this.protocol_version = iBitstream.getbits(8);
        if (z) {
            XML.WriteXmlElement("<protocol_version type=\"flUInt\" bitLen=\"8\">" + this.protocol_version + "</protocol_version>");
        } else {
            XML.WriteXmlElement("<protocol_version bitLen=\"8\">" + this.protocol_version + "</protocol_version>");
        }
        this.tables_defined = iBitstream.getbits(16);
        if (z) {
            XML.WriteXmlElement("<tables_defined type=\"flUInt\" bitLen=\"16\">" + this.tables_defined + "</tables_defined>");
        } else {
            XML.WriteXmlElement("<tables_defined bitLen=\"16\">" + this.tables_defined + "</tables_defined>");
        }
        this.tn = 0;
        while (this.tn < this.tables_defined) {
            Util.trace(iBitstream.getpos(), 0, 0, "processing MGTTable table");
            this.table = new MGTTable();
            XML.IntoAClass("table", 0);
            iPutxml += this.table.putxml(iBitstream, z);
            XML.OutOfClass("</table>");
            this.tn++;
        }
        int i10 = iBitstream.getbits(4);
        this.reserved3 = i10;
        if (i10 != 15) {
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
        this.CRC_32 = iBitstream.getbits(32);
        if (z) {
            XML.WriteXmlElement("<CRC_32 type=\"flUInt\" bitLen=\"32\">" + this.CRC_32 + "</CRC_32>");
        } else {
            XML.WriteXmlElement("<CRC_32 bitLen=\"32\">" + this.CRC_32 + "</CRC_32>");
        }
        return iPutxml;
    }
}
